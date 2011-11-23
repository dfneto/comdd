/* *****************************************************************************
 * PathFinder sem as classes GPS.cpp, Compass.cpp
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <math.h>
#include <fcntl.h>
#include <termios.h>
#include <sys/stat.h>
#include <time.h>
#include <libplayerc/playerc.h>

#define BAUDRATE_GPS B19200
#define BAUDRATE_COMPASS B19200

#define PORTA_COMPASS "/dev/ttyUSB0"
#define PORTA_GPS "/dev/ttyUSB1"

#define NOME_ARQUIVO_LISTA_COORDENADAS "path.txt"
#define QTD_MAX_DESTINOS 50
FILE *arquivoDeCoordenadas;

#define _POSIX_SOURCE 1

#define PRINT_INFO_CHECKSUM 0
#define PRINT_NMEA_ORIGINAL 0
#define PRINT_LEITURA_SENSOR 1  // variaveis lidas tratadas
#define PRINT_BRAIN 1           // variaveis de calculos de acao
#define PRINT_ACAO 1            // variaveis de acao

/* *****************************************************************************
 * utm stuff (conversao de graus para utm, copiado do player)
 */

// WGS84 Parameters
#define WGS84_A     6378137.0           // major axis
#define WGS84_B     6356752.31424518    // minor axis
#define WGS84_F     0.0033528107        // ellipsoid flattening
#define WGS84_E     0.0818191908        // first eccentricity
#define WGS84_EP    0.0820944379        // second eccentricity

// UTM Parameters
#define UTM_K0      0.9996              // scale factor
#define UTM_FE      500000.0            // false easting
#define UTM_FN_N    0.0                 // false northing on north hemisphere
#define UTM_FN_S    10000000.0          // false northing on south hemisphere
#define UTM_E2      (WGS84_E*WGS84_E)   // e^2
#define UTM_E4      (UTM_E2*UTM_E2)     // e^4
#define UTM_E6      (UTM_E4*UTM_E2)     // e^6
#define UTM_EP2     (UTM_E2/(1-UTM_E2)) // e'^2

// my stuff to conversao de lat-long para utm (organizar na proxima versao)
double dUTM_E_X=0.0;
double dUTM_N_Y=0.0;
char sHemisferioLatitude[5] = "S";
char sHemisferioLongitude[5] = "W";


/* *****************************************************************************
 *  classe ("struct") que guarda pontos de destino
 */

class Destino
{
    public:

        double UTM_X_Leste_Oeste;
        double UTM_Y_Norte_Sul;
        int id_lido; /* vem do arquivo de coordenadas, quando o proximo eh -1
                      * o sistema pára */
};

/* *****************************************************************************
 * Variaveis globais
 */

int iPortaGPS; // descritor da porta do GPS
int iPortaCompass; // descritor da porta do GPS

GPS gps;
Compass compass;
Destino destino[QTD_MAX_DESTINOS];

double dTorque = 0.0;
double dGiro = 0.0;

playerc_client_t *client;
playerc_position2d_t *position2d;


/* *****************************************************************************
 * azimute é o angulo para o alvo (considera angulo de bussola)
 *
 * exemplo de uso:
 * double origemX = 475000.00; double origemY = 220000.00;
 * double destinoX = 475010.00; double destinoY = 220010.00;
 * double res =  getAzimute(origemX, origemY, destinoX, destinoY);
 * std::cout << "Res.: " << res;
 */


double getAzimute(double destinoX, double destinoY, double origemX, double origemY)
{
    if (origemY==destinoY) destinoY += 0.0001;
    if (origemX==destinoX) destinoX += 0.0001;

    double AngR = atan((origemY-destinoY)/(origemX-destinoX));
    double AngG = (AngR/(2.0*M_PI))*360.0;

    /*
     * Isso é uma bússola de "verdade", 0 == norte [y]
     * e angulos aumentam em sentido horário
     */

    if ((destinoX<origemX) && (destinoY<origemY)) return (double) 360.0 - (90.0  + AngG);
    if ((destinoX>origemX) && (destinoY>origemY)) return (double) 360.0 - (270.0 + AngG);
    if ((destinoX>origemX) && (destinoY<origemY)) return (double) 360.0 - (270.0 + AngG);
    if ((destinoX<origemX) && (destinoY>origemY)) return (double) 360.0 - (90.0  + AngG);

    /* nunca entra aqui, mas... ;-) */
    return 0;
}




/* *****************************************************************************
 * inicializa player
 */

void inicializaPlayer()
{
    // Conecta ao servidor
    client = playerc_client_create(NULL, "localhost", 6665);
    if (playerc_client_connect(client) != 0) exit (0);
    
    // Conecta ao position (comando e odometria)
    position2d = playerc_position2d_create(client, 0);
    if (playerc_position2d_subscribe(position2d, PLAYERC_OPEN_MODE) != 0) exit (0);
    
    // Configura parametros
    if (playerc_client_datamode (client, PLAYERC_DATAMODE_PULL) != 0)
    {
        printf("Error: %s\n", playerc_error_str());
        exit (0);
    }
    
    // Configura parametros
    if (playerc_client_set_replace_rule (client, -1, -1, PLAYER_MSGTYPE_DATA, -1, 1) != 0)
    {
        printf("Error: %s\n", playerc_error_str());
        exit (0);
    }

    // Ativa os motores do robo
    playerc_position2d_enable(position2d, 1);
}

/* *****************************************************************************
 * zera a lista de destinos, colocando -1 em todos os campos
 */

void zera_destinos()
{
    for (int i=0;i<QTD_MAX_DESTINOS;i++)
    {
        destino[i].UTM_X_Leste_Oeste = -1.0;
        destino[i].UTM_Y_Norte_Sul = -1.0;
        destino[i].id_lido = -1;
    }
}

/* *****************************************************************************
 * leitura do arquivo de destinos
 */

void read_file_destinos()
{
    arquivoDeCoordenadas = fopen(NOME_ARQUIVO_LISTA_COORDENADAS,"rt");
    if (arquivoDeCoordenadas == NULL)
    {
        printf("\nNao achei arquivo %s\n", NOME_ARQUIVO_LISTA_COORDENADAS);
        exit(0);
    }

    int i=0;

    while(!feof(arquivoDeCoordenadas))
    {
        fscanf(arquivoDeCoordenadas,"%lf",&destino[i].UTM_X_Leste_Oeste);
        fscanf(arquivoDeCoordenadas,"%lf",&destino[i].UTM_Y_Norte_Sul);
        fscanf(arquivoDeCoordenadas,"%d",&destino[i].id_lido);
        i++;

        if (i >= QTD_MAX_DESTINOS)
        {
            printf("\nTamanho maximo atingido, aumente tamanho do vetor de destinos\n");
            exit (0);
        }
    }
}

/* *****************************************************************************
 * Imprime vetor (lido do arquivo de destinos)
 */

void imprime_destinos()
{
    for (int i=0;i<QTD_MAX_DESTINOS;i++)
    {
        printf("I:%i \t X:%lf ",i, destino[i].UTM_X_Leste_Oeste);
        printf("\tY:%lf ",destino[i].UTM_Y_Norte_Sul);
        printf("\tID:%d\n",destino[i].id_lido);
    }
}

/* *****************************************************************************
 * bloco main
 */

int main(int argc, const char **argv)
{
    // Leitura arquivo de destinos
    zera_destinos();
    read_file_destinos();
    imprime_destinos();
    
    printf("\nFollow the yellow brick road to reach the Emerald City!\n");
    getchar();
    
    // pra onde eu vou? (o primeiro destino é a posicao [0])
    double dDestinoX = destino[0].UTM_X_Leste_Oeste;
    double dDestinoY = destino[0].UTM_Y_Norte_Sul;

    // é a chave da troca dos destinos
    int contadorPontoDestino = 1; // comeca com um pq

    // compass
    char *achouSubStringCompass; // se achou substring...
    int respostaCompass;
    char buf_compass[255];
    char lixo[255];
    
    // gps
    char *achouSubStringGPS; // se achou substring...
    int respostaGPS;
    char buf_gps[255];
    
    abreportaCompass();
    abreportaGPS();

    inicializaPlayer();
    
    // na inicializacao, faz umas leituras para descartar...
    // em geral, as primeiras leituras vem quebradas...
    for (int i=0;i<5;i++) read(iPortaCompass,lixo,255);
    for (int i=0;i<5;i++) read(iPortaGPS,lixo,255);
    
    char messageNMEAsemSifrao[255];
    int r; // resposta from check
    
    while (true)
    {
        if ((PRINT_NMEA_ORIGINAL==1) || (PRINT_INFO_CHECKSUM==1)) printf("\n");

//tenho que chamar
//ler bussola
//ler gps
       
        // *********************************************************************
        //
        // *********************************************************************

        playerc_client_read(client);

        // *********************************************************************
        // padawan, you can use the vars
        // *********************************************************************

        if (PRINT_LEITURA_SENSOR==1)
        {
            long int clock = time(NULL);
            
            printf("\nutc:%.1lf %ld ns %d dop %.1lf",gps.dUTC, clock, gps.iNumSat, gps.dDOP);
            printf(" utmNy %lf utmEx %lf",dUTM_N_Y, dUTM_E_X);
            printf(" tc %.1lf mc %.1lf",gps.dTrueCourse, gps.dMagneticCourse);
            printf(" rme %.2lf",gps.dHPE);
            printf(" head %.2lf ",compass.dHeading);
        }

        // *********************************************************************
        // brain, from robombeiros
        // *********************************************************************
        
        double dVeiculoOrientacao = compass.dHeading;
        double dVeiculoPosX = dUTM_E_X;
        double dVeiculoPosY = dUTM_N_Y;
        double dAzimute = getAzimute(dDestinoX, dDestinoY, dUTM_E_X, dUTM_N_Y);
        double dErroGps = gps.dHPE * 2.0; // erro_gps
        
        if (PRINT_BRAIN==1)
        {
            printf ("Az: %.2lf",dAzimute);
            printf ("eGPS: %.1lf",dErroGps);
        }

        // chegada no final final ? [define torque]
        if ( 
             (dVeiculoPosX <= dDestinoX+dErroGps) &&
             (dVeiculoPosX >= dDestinoX-dErroGps) &&
             (dVeiculoPosY <= dDestinoY+dErroGps) &&
             (dVeiculoPosY >= dDestinoY-dErroGps)
           )
        {
            // quando começa, contadorPontoDestino vale um
            // ao chegar em cada ponto, troca pro próximo
            
            if (destino[contadorPontoDestino].id_lido == -1) //acabou
            {
                dTorque = 0.0;
            }
            else 
            {
                dDestinoX = destino[contadorPontoDestino].UTM_X_Leste_Oeste;
                dDestinoX = destino[contadorPontoDestino].UTM_Y_Norte_Sul;
                contadorPontoDestino++;
            }

        }

        else
        {
            // sonar? laser? if ((raiosDistancias > 30.0) torque = -1.0 * VELOCIDADE_LIVRE;
            // if raiosDistancias[3] < 30.0) Torque = -1.0 * VELOCIDADE_OBSTACULO_LONGE;
            // if raiosDistancias[3] < 18.0) Torque = -1.0 * VELOCIDADE_OBSTACULO_PERTO;
            dTorque = 0.2; // m/s
        }
        
        // para saber se vira para a direita ou esuqerda 
        double dDif=0.0;
        double dAnguloOposto = 180.0 + dVeiculoOrientacao;
        if (dAnguloOposto > 360.0) dAnguloOposto -= 360.0;
        dDif = dVeiculoOrientacao - dAzimute; // pega diferença para "suavizar" curva
        if (dDif < 0.0) dDif *= -1.0;

        if (PRINT_BRAIN==1) printf ("Dif: %.2lf",dDif);

        dGiro = 0.0;

        if (
                (  (dAzimute > dVeiculoOrientacao) && (dAzimute < dAnguloOposto) &&  (dAnguloOposto > dVeiculoOrientacao) ) ||
                ( !(dAzimute > dVeiculoOrientacao) && (dAzimute < dAnguloOposto) && !(dAnguloOposto > dVeiculoOrientacao) ) ||
                (  (dAzimute > dVeiculoOrientacao) && !(dAzimute < dAnguloOposto) && !(dAnguloOposto > dVeiculoOrientacao) )
           )
        {
            if (dDif<=15.0) dGiro = -0.05;
            if ((dDif<=25.0) && (dDif>15.0)) dGiro = -0.15;
            if (dDif>25.0) dGiro = -0.3;
            if (dDif<=0.1) dGiro = 0.0;
        }
        else
        {
            if (dDif<=15.0) dGiro = 0.05;
            if ((dDif<=25.0) && (dDif>15.0)) dGiro = 0.15;
            if (dDif>25.0) dGiro = 0.3;
            if (dDif<=0.1) dGiro = 0.0;
        }
        
        // if (SONAR_ATIVO == 1) (se precisar, pegue código robombeiros)

        if (PRINT_ACAO==1)
        {
            printf ("tor: %.2lf",dTorque);
            printf ("gir: %.2lf",dGiro);
        }

        // *********************************************************************
        // brain... that's all folks!
        // now, send the player commands
        // *********************************************************************

        //fprintf(f," px %f py %f pa %f",(position2d->px),(position2d->py),(position2d->pa)); // odometro
        //fprintf(f,"\naz: %f giro: %f vel: %f",azimute,gira,velocidade);
        //fflush(f);

        playerc_position2d_set_cmd_vel (position2d, dTorque, 0, dGiro, 1);
        
    } // fim do while

    // *************************************************************************
    // end player
    // *************************************************************************
    playerc_position2d_unsubscribe(position2d);
    playerc_position2d_destroy(position2d);
    playerc_client_disconnect(client);
    playerc_client_destroy(client);

    return 0;
}


