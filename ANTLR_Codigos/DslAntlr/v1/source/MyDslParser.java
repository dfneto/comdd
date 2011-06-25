// $ANTLR 3.0 source/MyDsl.g 2011-06-25 16:54:15

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class MyDslParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "WS", "'robo'", "'plataforma'", "'pioneer'", "'srv'", "'golfe'", "'adicionar'", "'defines'", "'includes'", "'criarSensor'", "'gps'", "'bussola'", "'camera'", "'int main()'", "'{'", "'}'", "'while'", "'(true)'", "'.'", "'ligar();'", "'ler();'", "'carregarListaCoordenadas();'", "'recebeCoordenada();'", "'obterImagem();'", "'processarImagem();'", "'defineAtirar();'", "'andar();'", "'naoBater();'", "'seguir();'"
    };
    public static final int WS=5;
    public static final int ID=4;
    public static final int EOF=-1;

        public MyDslParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "source/MyDsl.g"; }


    	String plataforma;
    	String sensor;
    	String sensorCriado;



    // $ANTLR start prog
    // source/MyDsl.g:14:1: prog : ( stat )+ ;
    public final void prog() throws RecognitionException {
        try {
            // source/MyDsl.g:14:7: ( ( stat )+ )
            // source/MyDsl.g:14:7: ( stat )+
            {
            // source/MyDsl.g:14:7: ( stat )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==7) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // source/MyDsl.g:14:7: stat
            	    {
            	    pushFollow(FOLLOW_stat_in_prog27);
            	    stat();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end prog


    // $ANTLR start stat
    // source/MyDsl.g:16:1: stat : plataforma 'robo' nomeRobo= ID ( cabecalho )* ( sensor )* main ;
    public final void stat() throws RecognitionException {
        Token nomeRobo=null;

        try {
            // source/MyDsl.g:16:7: ( plataforma 'robo' nomeRobo= ID ( cabecalho )* ( sensor )* main )
            // source/MyDsl.g:16:7: plataforma 'robo' nomeRobo= ID ( cabecalho )* ( sensor )* main
            {
            pushFollow(FOLLOW_plataforma_in_stat35);
            plataforma();
            _fsp--;

            match(input,6,FOLLOW_6_in_stat38); 
            nomeRobo=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_stat42); 
            // source/MyDsl.g:18:2: ( cabecalho )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==11) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // source/MyDsl.g:18:2: cabecalho
            	    {
            	    pushFollow(FOLLOW_cabecalho_in_stat46);
            	    cabecalho();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // source/MyDsl.g:19:2: ( sensor )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==14) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // source/MyDsl.g:19:2: sensor
            	    {
            	    pushFollow(FOLLOW_sensor_in_stat51);
            	    sensor();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            pushFollow(FOLLOW_main_in_stat56);
            main();
            _fsp--;

            System.out.println ("Robo " +nomeRobo.getText()+ " criado com sucesso!!");

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end stat


    // $ANTLR start plataforma
    // source/MyDsl.g:27:1: plataforma : 'plataforma' nomeDaPlataforma ;
    public final void plataforma() throws RecognitionException {
        try {
            // source/MyDsl.g:28:2: ( 'plataforma' nomeDaPlataforma )
            // source/MyDsl.g:28:2: 'plataforma' nomeDaPlataforma
            {
            match(input,7,FOLLOW_7_in_plataforma75); 
            pushFollow(FOLLOW_nomeDaPlataforma_in_plataforma77);
            nomeDaPlataforma();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end plataforma


    // $ANTLR start nomeDaPlataforma
    // source/MyDsl.g:30:1: nomeDaPlataforma : ( 'pioneer' | 'srv' | 'golfe' ) ;
    public final void nomeDaPlataforma() throws RecognitionException {
        try {
            // source/MyDsl.g:31:2: ( ( 'pioneer' | 'srv' | 'golfe' ) )
            // source/MyDsl.g:31:2: ( 'pioneer' | 'srv' | 'golfe' )
            {
            // source/MyDsl.g:31:2: ( 'pioneer' | 'srv' | 'golfe' )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 8:
                {
                alt4=1;
                }
                break;
            case 9:
                {
                alt4=2;
                }
                break;
            case 10:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("31:2: ( 'pioneer' | 'srv' | 'golfe' )", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // source/MyDsl.g:32:3: 'pioneer'
                    {
                    match(input,8,FOLLOW_8_in_nomeDaPlataforma90); 
                    plataforma = "pioneer";

                    }
                    break;
                case 2 :
                    // source/MyDsl.g:33:3: 'srv'
                    {
                    match(input,9,FOLLOW_9_in_nomeDaPlataforma98); 
                    plataforma = "srv";

                    }
                    break;
                case 3 :
                    // source/MyDsl.g:34:3: 'golfe'
                    {
                    match(input,10,FOLLOW_10_in_nomeDaPlataforma106); 
                    plataforma = "golfe";

                    }
                    break;

            }

            System.out.println ("Plataforma escolhida: " +plataforma);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end nomeDaPlataforma


    // $ANTLR start cabecalho
    // source/MyDsl.g:42:1: cabecalho : 'adicionar' itensCabecalho= ( 'defines' | 'includes' ) ;
    public final void cabecalho() throws RecognitionException {
        Token itensCabecalho=null;

        try {
            // source/MyDsl.g:43:2: ( 'adicionar' itensCabecalho= ( 'defines' | 'includes' ) )
            // source/MyDsl.g:43:2: 'adicionar' itensCabecalho= ( 'defines' | 'includes' )
            {
            match(input,11,FOLLOW_11_in_cabecalho128); 
            // source/MyDsl.g:43:29: ( 'defines' | 'includes' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==12) ) {
                alt5=1;
            }
            else if ( (LA5_0==13) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("43:29: ( 'defines' | 'includes' )", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // source/MyDsl.g:44:3: 'defines'
                    {
                    match(input,12,FOLLOW_12_in_cabecalho136); 

                    				if (plataforma == "pioneer")
                    				System.out.println("Defines Adicionados para plataforma Pioneer......................");
                    				if (plataforma == "srv")
                    				System.out.println("Defines Adicionados para plataforma SRV......................");
                    				if (plataforma == "golfe")
                    				System.out.println("Defines Adicionados para plataforma Carro de golfe......................");
                    				
                    		

                    }
                    break;
                case 2 :
                    // source/MyDsl.g:53:3: 'includes'
                    {
                    match(input,13,FOLLOW_13_in_cabecalho145); 

                    				if (plataforma == "pioneer")
                    					System.out.println("Includes Adicionados para plataforma Pioneer......................");
                    				if (plataforma == "srv")
                    					System.out.println("Includes Adicionados para plataforma SRV......................");
                    				if (plataforma == "golfe")
                    					System.out.println("Includes Adicionados para plataforma Carro de golfe......................");
                    		

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end cabecalho


    // $ANTLR start sensor
    // source/MyDsl.g:68:1: sensor : 'criarSensor' tipoSensor ;
    public final void sensor() throws RecognitionException {
        try {
            // source/MyDsl.g:69:2: ( 'criarSensor' tipoSensor )
            // source/MyDsl.g:69:2: 'criarSensor' tipoSensor
            {
            match(input,14,FOLLOW_14_in_sensor164); 
            pushFollow(FOLLOW_tipoSensor_in_sensor166);
            tipoSensor();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end sensor


    // $ANTLR start tipoSensor
    // source/MyDsl.g:71:1: tipoSensor : s= ( 'gps' | 'bussola' | 'camera' ) ;
    public final void tipoSensor() throws RecognitionException {
        Token s=null;

        try {
            // source/MyDsl.g:72:2: (s= ( 'gps' | 'bussola' | 'camera' ) )
            // source/MyDsl.g:72:2: s= ( 'gps' | 'bussola' | 'camera' )
            {
            // source/MyDsl.g:72:4: ( 'gps' | 'bussola' | 'camera' )
            int alt6=3;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt6=1;
                }
                break;
            case 16:
                {
                alt6=2;
                }
                break;
            case 17:
                {
                alt6=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("72:4: ( 'gps' | 'bussola' | 'camera' )", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // source/MyDsl.g:73:3: 'gps'
                    {
                    match(input,15,FOLLOW_15_in_tipoSensor181); 
                    sensor = "gps";

                    }
                    break;
                case 2 :
                    // source/MyDsl.g:74:3: 'bussola'
                    {
                    match(input,16,FOLLOW_16_in_tipoSensor189); 
                    sensor = "bussola";

                    }
                    break;
                case 3 :
                    // source/MyDsl.g:75:3: 'camera'
                    {
                    match(input,17,FOLLOW_17_in_tipoSensor197); 
                    sensor = "camera";

                    }
                    break;

            }

            System.out.println("Código para inicializar o/a " +sensor+ " vem aqui");

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end tipoSensor


    // $ANTLR start main
    // source/MyDsl.g:84:1: main : 'int main()' '{' loop '}' ;
    public final void main() throws RecognitionException {
        try {
            // source/MyDsl.g:85:2: ( 'int main()' '{' loop '}' )
            // source/MyDsl.g:85:2: 'int main()' '{' loop '}'
            {
            match(input,18,FOLLOW_18_in_main222); 
            match(input,19,FOLLOW_19_in_main224); 
            System.out.println("int main() {");
            pushFollow(FOLLOW_loop_in_main228);
            loop();
            _fsp--;

            match(input,20,FOLLOW_20_in_main232); 
            System.out.println("}");

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end main


    // $ANTLR start loop
    // source/MyDsl.g:88:1: loop : ( comportamento | acoes )* 'while' '(true)' '{' ( comportamento | acoes )* '}' ;
    public final void loop() throws RecognitionException {
        try {
            // source/MyDsl.g:89:2: ( ( comportamento | acoes )* 'while' '(true)' '{' ( comportamento | acoes )* '}' )
            // source/MyDsl.g:89:2: ( comportamento | acoes )* 'while' '(true)' '{' ( comportamento | acoes )* '}'
            {
            // source/MyDsl.g:89:2: ( comportamento | acoes )*
            loop7:
            do {
                int alt7=3;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=15 && LA7_0<=17)) ) {
                    alt7=1;
                }
                else if ( ((LA7_0>=29 && LA7_0<=33)) ) {
                    alt7=2;
                }


                switch (alt7) {
            	case 1 :
            	    // source/MyDsl.g:89:3: comportamento
            	    {
            	    pushFollow(FOLLOW_comportamento_in_loop246);
            	    comportamento();
            	    _fsp--;


            	    }
            	    break;
            	case 2 :
            	    // source/MyDsl.g:89:19: acoes
            	    {
            	    pushFollow(FOLLOW_acoes_in_loop250);
            	    acoes();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            match(input,21,FOLLOW_21_in_loop256); 
            match(input,22,FOLLOW_22_in_loop258); 
            match(input,19,FOLLOW_19_in_loop260); 
            System.out.println("\twhile(true) {");
            // source/MyDsl.g:91:2: ( comportamento | acoes )*
            loop8:
            do {
                int alt8=3;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=15 && LA8_0<=17)) ) {
                    alt8=1;
                }
                else if ( ((LA8_0>=29 && LA8_0<=33)) ) {
                    alt8=2;
                }


                switch (alt8) {
            	case 1 :
            	    // source/MyDsl.g:91:3: comportamento
            	    {
            	    pushFollow(FOLLOW_comportamento_in_loop267);
            	    comportamento();
            	    _fsp--;


            	    }
            	    break;
            	case 2 :
            	    // source/MyDsl.g:91:19: acoes
            	    {
            	    pushFollow(FOLLOW_acoes_in_loop271);
            	    acoes();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            match(input,20,FOLLOW_20_in_loop276); 
            System.out.println("\t}");

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end loop


    // $ANTLR start comportamento
    // source/MyDsl.g:99:1: comportamento : sensorCriado '.' acaoSensor ;
    public final void comportamento() throws RecognitionException {
        try {
            // source/MyDsl.g:100:2: ( sensorCriado '.' acaoSensor )
            // source/MyDsl.g:100:2: sensorCriado '.' acaoSensor
            {
            pushFollow(FOLLOW_sensorCriado_in_comportamento293);
            sensorCriado();
            _fsp--;

            match(input,23,FOLLOW_23_in_comportamento295); 
            pushFollow(FOLLOW_acaoSensor_in_comportamento299);
            acaoSensor();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end comportamento


    // $ANTLR start sensorCriado
    // source/MyDsl.g:104:1: sensorCriado : ( 'gps' | 'bussola' | 'camera' );
    public final void sensorCriado() throws RecognitionException {
        try {
            // source/MyDsl.g:105:3: ( 'gps' | 'bussola' | 'camera' )
            int alt9=3;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt9=1;
                }
                break;
            case 16:
                {
                alt9=2;
                }
                break;
            case 17:
                {
                alt9=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("104:1: sensorCriado : ( 'gps' | 'bussola' | 'camera' );", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // source/MyDsl.g:105:3: 'gps'
                    {
                    match(input,15,FOLLOW_15_in_sensorCriado310); 
                    sensorCriado = "gps";

                    }
                    break;
                case 2 :
                    // source/MyDsl.g:106:3: 'bussola'
                    {
                    match(input,16,FOLLOW_16_in_sensorCriado318); 
                    sensorCriado = "bussola";

                    }
                    break;
                case 3 :
                    // source/MyDsl.g:107:3: 'camera'
                    {
                    match(input,17,FOLLOW_17_in_sensorCriado326); 
                    sensorCriado = "camera";

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end sensorCriado


    // $ANTLR start acaoSensor
    // source/MyDsl.g:111:1: acaoSensor : ( ligar | ler | carregarListaCoordenadas | recebeCoordenada | obterImagem );
    public final void acaoSensor() throws RecognitionException {
        try {
            // source/MyDsl.g:112:2: ( ligar | ler | carregarListaCoordenadas | recebeCoordenada | obterImagem )
            int alt10=5;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt10=1;
                }
                break;
            case 25:
                {
                alt10=2;
                }
                break;
            case 26:
                {
                alt10=3;
                }
                break;
            case 27:
                {
                alt10=4;
                }
                break;
            case 28:
                {
                alt10=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("111:1: acaoSensor : ( ligar | ler | carregarListaCoordenadas | recebeCoordenada | obterImagem );", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // source/MyDsl.g:112:2: ligar
                    {
                    pushFollow(FOLLOW_ligar_in_acaoSensor340);
                    ligar();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // source/MyDsl.g:112:10: ler
                    {
                    pushFollow(FOLLOW_ler_in_acaoSensor344);
                    ler();
                    _fsp--;


                    }
                    break;
                case 3 :
                    // source/MyDsl.g:112:16: carregarListaCoordenadas
                    {
                    pushFollow(FOLLOW_carregarListaCoordenadas_in_acaoSensor348);
                    carregarListaCoordenadas();
                    _fsp--;


                    }
                    break;
                case 4 :
                    // source/MyDsl.g:112:43: recebeCoordenada
                    {
                    pushFollow(FOLLOW_recebeCoordenada_in_acaoSensor352);
                    recebeCoordenada();
                    _fsp--;


                    }
                    break;
                case 5 :
                    // source/MyDsl.g:112:62: obterImagem
                    {
                    pushFollow(FOLLOW_obterImagem_in_acaoSensor356);
                    obterImagem();
                    _fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end acaoSensor


    // $ANTLR start ligar
    // source/MyDsl.g:115:1: ligar : 'ligar();' ;
    public final void ligar() throws RecognitionException {
        try {
            // source/MyDsl.g:116:2: ( 'ligar();' )
            // source/MyDsl.g:116:2: 'ligar();'
            {
            match(input,24,FOLLOW_24_in_ligar367); 
            System.out.println("\t\tO sensor " +sensorCriado+ " foi ligado");

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end ligar


    // $ANTLR start ler
    // source/MyDsl.g:119:1: ler : 'ler();' ;
    public final void ler() throws RecognitionException {
        try {
            // source/MyDsl.g:120:2: ( 'ler();' )
            // source/MyDsl.g:120:2: 'ler();'
            {
            match(input,25,FOLLOW_25_in_ler379); 
            System.out.println("\t\tO sensor " +sensorCriado+ " está lendo");

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end ler


    // $ANTLR start carregarListaCoordenadas
    // source/MyDsl.g:123:1: carregarListaCoordenadas : 'carregarListaCoordenadas();' ;
    public final void carregarListaCoordenadas() throws RecognitionException {
        try {
            // source/MyDsl.g:124:2: ( 'carregarListaCoordenadas();' )
            // source/MyDsl.g:124:2: 'carregarListaCoordenadas();'
            {
            match(input,26,FOLLOW_26_in_carregarListaCoordenadas391); 
            System.out.println("\t\tCódigo da lista de coordenadas vem aqui");

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end carregarListaCoordenadas


    // $ANTLR start recebeCoordenada
    // source/MyDsl.g:127:1: recebeCoordenada : 'recebeCoordenada();' ;
    public final void recebeCoordenada() throws RecognitionException {
        try {
            // source/MyDsl.g:128:2: ( 'recebeCoordenada();' )
            // source/MyDsl.g:128:2: 'recebeCoordenada();'
            {
            match(input,27,FOLLOW_27_in_recebeCoordenada403); 
            System.out.println("\t\tCódigo para receber uma coordenada apenas vem aqui");

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end recebeCoordenada


    // $ANTLR start obterImagem
    // source/MyDsl.g:131:1: obterImagem : 'obterImagem();' ;
    public final void obterImagem() throws RecognitionException {
        try {
            // source/MyDsl.g:132:2: ( 'obterImagem();' )
            // source/MyDsl.g:132:2: 'obterImagem();'
            {
            match(input,28,FOLLOW_28_in_obterImagem415); 
            System.out.println("\t\tCódigo de obter imagem vem aqui");

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end obterImagem


    // $ANTLR start acoes
    // source/MyDsl.g:139:1: acoes : ( processarImagem | defineAtirar | atuar | regra );
    public final void acoes() throws RecognitionException {
        try {
            // source/MyDsl.g:140:2: ( processarImagem | defineAtirar | atuar | regra )
            int alt11=4;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt11=1;
                }
                break;
            case 30:
                {
                alt11=2;
                }
                break;
            case 31:
                {
                alt11=3;
                }
                break;
            case 32:
            case 33:
                {
                alt11=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("139:1: acoes : ( processarImagem | defineAtirar | atuar | regra );", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // source/MyDsl.g:140:2: processarImagem
                    {
                    pushFollow(FOLLOW_processarImagem_in_acoes432);
                    processarImagem();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // source/MyDsl.g:140:20: defineAtirar
                    {
                    pushFollow(FOLLOW_defineAtirar_in_acoes436);
                    defineAtirar();
                    _fsp--;


                    }
                    break;
                case 3 :
                    // source/MyDsl.g:140:35: atuar
                    {
                    pushFollow(FOLLOW_atuar_in_acoes440);
                    atuar();
                    _fsp--;


                    }
                    break;
                case 4 :
                    // source/MyDsl.g:140:43: regra
                    {
                    pushFollow(FOLLOW_regra_in_acoes444);
                    regra();
                    _fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end acoes


    // $ANTLR start processarImagem
    // source/MyDsl.g:143:1: processarImagem : 'processarImagem();' ;
    public final void processarImagem() throws RecognitionException {
        try {
            // source/MyDsl.g:144:2: ( 'processarImagem();' )
            // source/MyDsl.g:144:2: 'processarImagem();'
            {
            match(input,29,FOLLOW_29_in_processarImagem454); 
            System.out.println("\t\tO robo está processando a imagem......");

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end processarImagem


    // $ANTLR start defineAtirar
    // source/MyDsl.g:147:1: defineAtirar : 'defineAtirar();' ;
    public final void defineAtirar() throws RecognitionException {
        try {
            // source/MyDsl.g:148:2: ( 'defineAtirar();' )
            // source/MyDsl.g:148:2: 'defineAtirar();'
            {
            match(input,30,FOLLOW_30_in_defineAtirar466); 
            System.out.println("\t\tO robo está atirando......");

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end defineAtirar


    // $ANTLR start atuar
    // source/MyDsl.g:151:1: atuar : 'andar();' ;
    public final void atuar() throws RecognitionException {
        try {
            // source/MyDsl.g:152:2: ( 'andar();' )
            // source/MyDsl.g:152:2: 'andar();'
            {
            match(input,31,FOLLOW_31_in_atuar478); 
            System.out.println("\t\tO robo está andando......");

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end atuar


    // $ANTLR start regra
    // source/MyDsl.g:155:1: regra : ( 'naoBater();' | 'seguir();' );
    public final void regra() throws RecognitionException {
        try {
            // source/MyDsl.g:156:2: ( 'naoBater();' | 'seguir();' )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==32) ) {
                alt12=1;
            }
            else if ( (LA12_0==33) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("155:1: regra : ( 'naoBater();' | 'seguir();' );", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // source/MyDsl.g:156:2: 'naoBater();'
                    {
                    match(input,32,FOLLOW_32_in_regra490); 
                    System.out.println("\t\tO robo nao pode bater......");

                    }
                    break;
                case 2 :
                    // source/MyDsl.g:157:2: 'seguir();'
                    {
                    match(input,33,FOLLOW_33_in_regra497); 
                    System.out.println("\t\tO robo deve seguir......");

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end regra


 

    public static final BitSet FOLLOW_stat_in_prog27 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_plataforma_in_stat35 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_6_in_stat38 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_stat42 = new BitSet(new long[]{0x0000000000044800L});
    public static final BitSet FOLLOW_cabecalho_in_stat46 = new BitSet(new long[]{0x0000000000044800L});
    public static final BitSet FOLLOW_sensor_in_stat51 = new BitSet(new long[]{0x0000000000044000L});
    public static final BitSet FOLLOW_main_in_stat56 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_7_in_plataforma75 = new BitSet(new long[]{0x0000000000000700L});
    public static final BitSet FOLLOW_nomeDaPlataforma_in_plataforma77 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_8_in_nomeDaPlataforma90 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_9_in_nomeDaPlataforma98 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_nomeDaPlataforma106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_cabecalho128 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_12_in_cabecalho136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_cabecalho145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_sensor164 = new BitSet(new long[]{0x0000000000038000L});
    public static final BitSet FOLLOW_tipoSensor_in_sensor166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_tipoSensor181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_tipoSensor189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_tipoSensor197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_main222 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_main224 = new BitSet(new long[]{0x00000003E0238000L});
    public static final BitSet FOLLOW_loop_in_main228 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_main232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_comportamento_in_loop246 = new BitSet(new long[]{0x00000003E0238000L});
    public static final BitSet FOLLOW_acoes_in_loop250 = new BitSet(new long[]{0x00000003E0238000L});
    public static final BitSet FOLLOW_21_in_loop256 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_loop258 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_loop260 = new BitSet(new long[]{0x00000003E0138000L});
    public static final BitSet FOLLOW_comportamento_in_loop267 = new BitSet(new long[]{0x00000003E0138000L});
    public static final BitSet FOLLOW_acoes_in_loop271 = new BitSet(new long[]{0x00000003E0138000L});
    public static final BitSet FOLLOW_20_in_loop276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sensorCriado_in_comportamento293 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_comportamento295 = new BitSet(new long[]{0x000000001F000000L});
    public static final BitSet FOLLOW_acaoSensor_in_comportamento299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_sensorCriado310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_sensorCriado318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_sensorCriado326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ligar_in_acaoSensor340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ler_in_acaoSensor344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_carregarListaCoordenadas_in_acaoSensor348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_recebeCoordenada_in_acaoSensor352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_obterImagem_in_acaoSensor356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ligar367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ler379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_carregarListaCoordenadas391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_recebeCoordenada403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_obterImagem415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_processarImagem_in_acoes432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_defineAtirar_in_acoes436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atuar_in_acoes440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_regra_in_acoes444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_processarImagem454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_defineAtirar466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_atuar478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_regra490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_regra497 = new BitSet(new long[]{0x0000000000000002L});

}