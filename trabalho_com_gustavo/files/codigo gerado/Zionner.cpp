
//Texto Padrão:
// Este código foi gerado automaticamente
// Para o robo Zionner!
// ***************************

//Cabecalho
defines...
		
includes...
#define NOME_ARQUIVO_LISTA_COORDENADAS "c://home.txt"
#define QTD_MAX_DESTINOS 50

	
		


//Variáveis Globais?
// my stuff to conversao de lat-long para utm (organizar na proxima versao)
double dUTM_E_X=0.0;
double dUTM_N_Y=0.0;
char sHemisferioLatitude[5] = "S";
char sHemisferioLongitude[5] = "W";

/**********************************
 * Variaveis globais
 */
int iPortaGPS; 	   // descritor da porta do GPS
int iPortaCompass; // descritor da porta do Compass

double dGiro = 0.0; //o dGiro é usado apenas para saber a direção que o robo gira. Assim só é usado num cálculo

GPS gps;



 
Compass compass;
		
	



Destino destino[QTD_MAX_DESTINOS];


double dTorque = 0.0 ; //falta colocar aqui o necessário para imprimir o leste_oeste...

playerc_client_t *client; //Essas variáveis eu não vi serem usadas
playerc_position2d_t *position2d;
	
// funcoes
		/* *****************************************************************************
		 * bloco main
		 */
		int main(int argc, const char **argv){

Destinos--> aonde colocar esse carfa para aparecer so uma vez?

imprime_destinos();


Destinos--> aonde colocar esse carfa para aparecer so uma vez?

read_file_destinos();


Destinos--> aonde colocar esse carfa para aparecer so uma vez?

zera_destinos();

		while(true) {


// na inicializacao, faz umas leituras para descartar...
// em geral, as primeiras leituras vem quebradas...
abreportaGPS();
for (int i=0;i<5;i++) read(iPortaGPS,lixo,255);




// na inicializacao, faz umas leituras para descartar...
// em geral, as primeiras leituras vem quebradas...
abreportaCompass();
for (int i=0;i<5;i++) read(iPortaCompass,lixo,255);




inicializaPlayer();




// variáveis para  compass
    char *achouSubStringCompass; // se achou substring...
    int respostaCompass;
    char buf_compass[255];
    char lixo[255];
//método de leitura da ClasseBussola
	getInfoBussolas();


    


// variáveis para gps
    char *achouSubStringGPS; // se achou substring...
    int respostaGPS;
    char buf_gps[255];
//método de leitura da ClasseGps
	getInfoGps();


    
		 Chegou ao Final?
		 //verifica se chegou no Fim. 
		 {Se sim dTorque = 2
		 Se não dTorque = 0
		 }
		}
	
		}	

