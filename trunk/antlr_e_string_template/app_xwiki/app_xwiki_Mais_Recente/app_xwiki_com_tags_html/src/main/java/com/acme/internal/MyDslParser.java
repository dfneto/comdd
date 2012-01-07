// $ANTLR 3.0 source/MyDsl.g 2011-07-11 15:00:16
package com.acme.internal;
import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class MyDslParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "WS", "'robo'", "'<'", "'>'", "'plataforma'", "'pioneer'", "'srv'", "'golfe'", "'adicionar'", "'defines'", "'includes'", "'criarSensor'", "'gps'", "'bussola'", "'camera'", "'int main()'", "'{'", "'}'", "'while'", "'(true)'", "'.'", "'ligar();'", "'ler();'", "'carregarListaCoordenadas();'", "'recebeCoordenada();'", "'obterImagem();'", "'processarImagem();'", "'defineAtirar();'", "'andar();'", "'naoBater();'", "'seguir();'"
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

                if ( (LA1_0==9) ) {
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
    // source/MyDsl.g:16:1: stat : plataforma 'robo' nomeRobo= ID ( link )* ( cabecalho )* ( sensor )* main ;
    public final void stat() throws RecognitionException {
        Token nomeRobo=null;

        try {
            // source/MyDsl.g:16:7: ( plataforma 'robo' nomeRobo= ID ( link )* ( cabecalho )* ( sensor )* main )
            // source/MyDsl.g:16:7: plataforma 'robo' nomeRobo= ID ( link )* ( cabecalho )* ( sensor )* main
            {
            pushFollow(FOLLOW_plataforma_in_stat35);
            plataforma();
            _fsp--;

            match(input,6,FOLLOW_6_in_stat39); 
            nomeRobo=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_stat43); 
            // source/MyDsl.g:18:2: ( link )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==7) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // source/MyDsl.g:18:2: link
            	    {
            	    pushFollow(FOLLOW_link_in_stat47);
            	    link();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // source/MyDsl.g:19:2: ( cabecalho )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // source/MyDsl.g:19:2: cabecalho
            	    {
            	    pushFollow(FOLLOW_cabecalho_in_stat51);
            	    cabecalho();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // source/MyDsl.g:20:2: ( sensor )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==16) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // source/MyDsl.g:20:2: sensor
            	    {
            	    pushFollow(FOLLOW_sensor_in_stat56);
            	    sensor();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            pushFollow(FOLLOW_main_in_stat61);
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


    // $ANTLR start link
    // source/MyDsl.g:25:1: link : '<' nomeLink= ID '>' ;
    public final void link() throws RecognitionException {
        Token nomeLink=null;

        try {
            // source/MyDsl.g:26:2: ( '<' nomeLink= ID '>' )
            // source/MyDsl.g:26:2: '<' nomeLink= ID '>'
            {
            match(input,7,FOLLOW_7_in_link75); 
            nomeLink=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_link79); 
            match(input,8,FOLLOW_8_in_link81); 
            System.out.println("[["+nomeLink.getText()+"]]");

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
    // $ANTLR end link


    // $ANTLR start plataforma
    // source/MyDsl.g:34:1: plataforma : 'plataforma' nomeDaPlataforma ;
    public final void plataforma() throws RecognitionException {
        try {
            // source/MyDsl.g:35:2: ( 'plataforma' nomeDaPlataforma )
            // source/MyDsl.g:35:2: 'plataforma' nomeDaPlataforma
            {
            match(input,9,FOLLOW_9_in_plataforma100); 
            pushFollow(FOLLOW_nomeDaPlataforma_in_plataforma102);
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
    // source/MyDsl.g:37:1: nomeDaPlataforma : ( 'pioneer' | 'srv' | 'golfe' ) ;
    public final void nomeDaPlataforma() throws RecognitionException {
        try {
            // source/MyDsl.g:38:2: ( ( 'pioneer' | 'srv' | 'golfe' ) )
            // source/MyDsl.g:38:2: ( 'pioneer' | 'srv' | 'golfe' )
            {
            // source/MyDsl.g:38:2: ( 'pioneer' | 'srv' | 'golfe' )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 10:
                {
                alt5=1;
                }
                break;
            case 11:
                {
                alt5=2;
                }
                break;
            case 12:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("38:2: ( 'pioneer' | 'srv' | 'golfe' )", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // source/MyDsl.g:39:3: 'pioneer'
                    {
                    match(input,10,FOLLOW_10_in_nomeDaPlataforma115); 
                    plataforma = "pioneer";

                    }
                    break;
                case 2 :
                    // source/MyDsl.g:40:3: 'srv'
                    {
                    match(input,11,FOLLOW_11_in_nomeDaPlataforma123); 
                    plataforma = "srv";

                    }
                    break;
                case 3 :
                    // source/MyDsl.g:41:3: 'golfe'
                    {
                    match(input,12,FOLLOW_12_in_nomeDaPlataforma131); 
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
    // source/MyDsl.g:49:1: cabecalho : 'adicionar' itensCabecalho= ( 'defines' | 'includes' ) ;
    public final void cabecalho() throws RecognitionException {
        Token itensCabecalho=null;

        try {
            // source/MyDsl.g:50:2: ( 'adicionar' itensCabecalho= ( 'defines' | 'includes' ) )
            // source/MyDsl.g:50:2: 'adicionar' itensCabecalho= ( 'defines' | 'includes' )
            {
            match(input,13,FOLLOW_13_in_cabecalho153); 
            // source/MyDsl.g:50:29: ( 'defines' | 'includes' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==14) ) {
                alt6=1;
            }
            else if ( (LA6_0==15) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("50:29: ( 'defines' | 'includes' )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // source/MyDsl.g:51:3: 'defines'
                    {
                    match(input,14,FOLLOW_14_in_cabecalho161); 

                    				if (plataforma == "pioneer")
                    				System.out.println("Defines Adicionados para plataforma Pioneer......................");
                    				if (plataforma == "srv")
                    				System.out.println("Defines Adicionados para plataforma SRV......................");
                    				if (plataforma == "golfe")
                    				System.out.println("Defines Adicionados para plataforma Carro de golfe......................");
                    				
                    		

                    }
                    break;
                case 2 :
                    // source/MyDsl.g:60:3: 'includes'
                    {
                    match(input,15,FOLLOW_15_in_cabecalho170); 

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
    // source/MyDsl.g:75:1: sensor : 'criarSensor' tipoSensor ;
    public final void sensor() throws RecognitionException {
        try {
            // source/MyDsl.g:76:2: ( 'criarSensor' tipoSensor )
            // source/MyDsl.g:76:2: 'criarSensor' tipoSensor
            {
            match(input,16,FOLLOW_16_in_sensor189); 
            pushFollow(FOLLOW_tipoSensor_in_sensor191);
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
    // source/MyDsl.g:78:1: tipoSensor : s= ( 'gps' | 'bussola' | 'camera' ) ;
    public final void tipoSensor() throws RecognitionException {
        Token s=null;

        try {
            // source/MyDsl.g:79:2: (s= ( 'gps' | 'bussola' | 'camera' ) )
            // source/MyDsl.g:79:2: s= ( 'gps' | 'bussola' | 'camera' )
            {
            // source/MyDsl.g:79:4: ( 'gps' | 'bussola' | 'camera' )
            int alt7=3;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt7=1;
                }
                break;
            case 18:
                {
                alt7=2;
                }
                break;
            case 19:
                {
                alt7=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("79:4: ( 'gps' | 'bussola' | 'camera' )", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // source/MyDsl.g:80:3: 'gps'
                    {
                    match(input,17,FOLLOW_17_in_tipoSensor206); 
                    sensor = "gps";

                    }
                    break;
                case 2 :
                    // source/MyDsl.g:81:3: 'bussola'
                    {
                    match(input,18,FOLLOW_18_in_tipoSensor214); 
                    sensor = "bussola";

                    }
                    break;
                case 3 :
                    // source/MyDsl.g:82:3: 'camera'
                    {
                    match(input,19,FOLLOW_19_in_tipoSensor222); 
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
    // source/MyDsl.g:91:1: main : 'int main()' '{' loop '}' ;
    public final void main() throws RecognitionException {
        try {
            // source/MyDsl.g:92:2: ( 'int main()' '{' loop '}' )
            // source/MyDsl.g:92:2: 'int main()' '{' loop '}'
            {
            match(input,20,FOLLOW_20_in_main247); 
            match(input,21,FOLLOW_21_in_main249); 
            System.out.println("int main() {");
            pushFollow(FOLLOW_loop_in_main253);
            loop();
            _fsp--;

            match(input,22,FOLLOW_22_in_main255); 
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
    // source/MyDsl.g:95:1: loop : ( comportamento | acoes )* 'while' '(true)' '{' ( comportamento | acoes )* '}' ;
    public final void loop() throws RecognitionException {
        try {
            // source/MyDsl.g:96:2: ( ( comportamento | acoes )* 'while' '(true)' '{' ( comportamento | acoes )* '}' )
            // source/MyDsl.g:96:2: ( comportamento | acoes )* 'while' '(true)' '{' ( comportamento | acoes )* '}'
            {
            // source/MyDsl.g:96:2: ( comportamento | acoes )*
            loop8:
            do {
                int alt8=3;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=17 && LA8_0<=19)) ) {
                    alt8=1;
                }
                else if ( ((LA8_0>=31 && LA8_0<=35)) ) {
                    alt8=2;
                }


                switch (alt8) {
            	case 1 :
            	    // source/MyDsl.g:96:3: comportamento
            	    {
            	    pushFollow(FOLLOW_comportamento_in_loop269);
            	    comportamento();
            	    _fsp--;


            	    }
            	    break;
            	case 2 :
            	    // source/MyDsl.g:96:19: acoes
            	    {
            	    pushFollow(FOLLOW_acoes_in_loop273);
            	    acoes();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            match(input,23,FOLLOW_23_in_loop280); 
            match(input,24,FOLLOW_24_in_loop282); 
            match(input,21,FOLLOW_21_in_loop284); 
            System.out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;while(true) {");
            // source/MyDsl.g:99:2: ( comportamento | acoes )*
            loop9:
            do {
                int alt9=3;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=17 && LA9_0<=19)) ) {
                    alt9=1;
                }
                else if ( ((LA9_0>=31 && LA9_0<=35)) ) {
                    alt9=2;
                }


                switch (alt9) {
            	case 1 :
            	    // source/MyDsl.g:99:3: comportamento
            	    {
            	    pushFollow(FOLLOW_comportamento_in_loop292);
            	    comportamento();
            	    _fsp--;


            	    }
            	    break;
            	case 2 :
            	    // source/MyDsl.g:99:19: acoes
            	    {
            	    pushFollow(FOLLOW_acoes_in_loop296);
            	    acoes();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            match(input,22,FOLLOW_22_in_loop302); 
            System.out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}");

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
    // source/MyDsl.g:108:1: comportamento : sensorCriado '.' acaoSensor ;
    public final void comportamento() throws RecognitionException {
        try {
            // source/MyDsl.g:109:2: ( sensorCriado '.' acaoSensor )
            // source/MyDsl.g:109:2: sensorCriado '.' acaoSensor
            {
            pushFollow(FOLLOW_sensorCriado_in_comportamento319);
            sensorCriado();
            _fsp--;

            match(input,25,FOLLOW_25_in_comportamento321); 
            pushFollow(FOLLOW_acaoSensor_in_comportamento325);
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
    // source/MyDsl.g:113:1: sensorCriado : ( 'gps' | 'bussola' | 'camera' );
    public final void sensorCriado() throws RecognitionException {
        try {
            // source/MyDsl.g:114:3: ( 'gps' | 'bussola' | 'camera' )
            int alt10=3;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt10=1;
                }
                break;
            case 18:
                {
                alt10=2;
                }
                break;
            case 19:
                {
                alt10=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("113:1: sensorCriado : ( 'gps' | 'bussola' | 'camera' );", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // source/MyDsl.g:114:3: 'gps'
                    {
                    match(input,17,FOLLOW_17_in_sensorCriado336); 
                    sensorCriado = "gps";

                    }
                    break;
                case 2 :
                    // source/MyDsl.g:115:3: 'bussola'
                    {
                    match(input,18,FOLLOW_18_in_sensorCriado344); 
                    sensorCriado = "bussola";

                    }
                    break;
                case 3 :
                    // source/MyDsl.g:116:3: 'camera'
                    {
                    match(input,19,FOLLOW_19_in_sensorCriado352); 
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
    // source/MyDsl.g:120:1: acaoSensor : ( ligar | ler | carregarListaCoordenadas | recebeCoordenada | obterImagem );
    public final void acaoSensor() throws RecognitionException {
        try {
            // source/MyDsl.g:121:2: ( ligar | ler | carregarListaCoordenadas | recebeCoordenada | obterImagem )
            int alt11=5;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt11=1;
                }
                break;
            case 27:
                {
                alt11=2;
                }
                break;
            case 28:
                {
                alt11=3;
                }
                break;
            case 29:
                {
                alt11=4;
                }
                break;
            case 30:
                {
                alt11=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("120:1: acaoSensor : ( ligar | ler | carregarListaCoordenadas | recebeCoordenada | obterImagem );", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // source/MyDsl.g:121:2: ligar
                    {
                    pushFollow(FOLLOW_ligar_in_acaoSensor366);
                    ligar();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // source/MyDsl.g:121:10: ler
                    {
                    pushFollow(FOLLOW_ler_in_acaoSensor370);
                    ler();
                    _fsp--;


                    }
                    break;
                case 3 :
                    // source/MyDsl.g:121:16: carregarListaCoordenadas
                    {
                    pushFollow(FOLLOW_carregarListaCoordenadas_in_acaoSensor374);
                    carregarListaCoordenadas();
                    _fsp--;


                    }
                    break;
                case 4 :
                    // source/MyDsl.g:121:43: recebeCoordenada
                    {
                    pushFollow(FOLLOW_recebeCoordenada_in_acaoSensor378);
                    recebeCoordenada();
                    _fsp--;


                    }
                    break;
                case 5 :
                    // source/MyDsl.g:121:62: obterImagem
                    {
                    pushFollow(FOLLOW_obterImagem_in_acaoSensor382);
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
    // source/MyDsl.g:124:1: ligar : 'ligar();' ;
    public final void ligar() throws RecognitionException {
        try {
            // source/MyDsl.g:126:2: ( 'ligar();' )
            // source/MyDsl.g:126:2: 'ligar();'
            {
            match(input,26,FOLLOW_26_in_ligar394); 
            System.out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;O sensor " +sensorCriado+ " foi ligado");

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
    // source/MyDsl.g:129:1: ler : 'ler();' ;
    public final void ler() throws RecognitionException {
        try {
            // source/MyDsl.g:131:2: ( 'ler();' )
            // source/MyDsl.g:131:2: 'ler();'
            {
            match(input,27,FOLLOW_27_in_ler407); 
            System.out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;O sensor " +sensorCriado+ " está lendo");

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
    // source/MyDsl.g:134:1: carregarListaCoordenadas : 'carregarListaCoordenadas();' ;
    public final void carregarListaCoordenadas() throws RecognitionException {
        try {
            // source/MyDsl.g:136:2: ( 'carregarListaCoordenadas();' )
            // source/MyDsl.g:136:2: 'carregarListaCoordenadas();'
            {
            match(input,28,FOLLOW_28_in_carregarListaCoordenadas420); 
            System.out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Código da lista de coordenadas vem aqui");

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
    // source/MyDsl.g:139:1: recebeCoordenada : 'recebeCoordenada();' ;
    public final void recebeCoordenada() throws RecognitionException {
        try {
            // source/MyDsl.g:141:2: ( 'recebeCoordenada();' )
            // source/MyDsl.g:141:2: 'recebeCoordenada();'
            {
            match(input,29,FOLLOW_29_in_recebeCoordenada433); 
            System.out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Código para receber uma coordenada apenas vem aqui");

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
    // source/MyDsl.g:144:1: obterImagem : 'obterImagem();' ;
    public final void obterImagem() throws RecognitionException {
        try {
            // source/MyDsl.g:146:2: ( 'obterImagem();' )
            // source/MyDsl.g:146:2: 'obterImagem();'
            {
            match(input,30,FOLLOW_30_in_obterImagem446); 
            System.out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Código de obter imagem vem aqui");

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
    // source/MyDsl.g:153:1: acoes : ( processarImagem | defineAtirar | atuar | regra );
    public final void acoes() throws RecognitionException {
        try {
            // source/MyDsl.g:154:2: ( processarImagem | defineAtirar | atuar | regra )
            int alt12=4;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt12=1;
                }
                break;
            case 32:
                {
                alt12=2;
                }
                break;
            case 33:
                {
                alt12=3;
                }
                break;
            case 34:
            case 35:
                {
                alt12=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("153:1: acoes : ( processarImagem | defineAtirar | atuar | regra );", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // source/MyDsl.g:154:2: processarImagem
                    {
                    pushFollow(FOLLOW_processarImagem_in_acoes463);
                    processarImagem();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // source/MyDsl.g:154:20: defineAtirar
                    {
                    pushFollow(FOLLOW_defineAtirar_in_acoes467);
                    defineAtirar();
                    _fsp--;


                    }
                    break;
                case 3 :
                    // source/MyDsl.g:154:35: atuar
                    {
                    pushFollow(FOLLOW_atuar_in_acoes471);
                    atuar();
                    _fsp--;


                    }
                    break;
                case 4 :
                    // source/MyDsl.g:154:43: regra
                    {
                    pushFollow(FOLLOW_regra_in_acoes475);
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
    // source/MyDsl.g:157:1: processarImagem : 'processarImagem();' ;
    public final void processarImagem() throws RecognitionException {
        try {
            // source/MyDsl.g:159:2: ( 'processarImagem();' )
            // source/MyDsl.g:159:2: 'processarImagem();'
            {
            match(input,31,FOLLOW_31_in_processarImagem486); 
            System.out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;O robo está processando a imagem......");

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
    // source/MyDsl.g:162:1: defineAtirar : 'defineAtirar();' ;
    public final void defineAtirar() throws RecognitionException {
        try {
            // source/MyDsl.g:164:2: ( 'defineAtirar();' )
            // source/MyDsl.g:164:2: 'defineAtirar();'
            {
            match(input,32,FOLLOW_32_in_defineAtirar499); 
            System.out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;O robo está atirando......");

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
    // source/MyDsl.g:167:1: atuar : 'andar();' ;
    public final void atuar() throws RecognitionException {
        try {
            // source/MyDsl.g:169:2: ( 'andar();' )
            // source/MyDsl.g:169:2: 'andar();'
            {
            match(input,33,FOLLOW_33_in_atuar512); 
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
    // source/MyDsl.g:172:1: regra : ( 'naoBater();' | 'seguir();' );
    public final void regra() throws RecognitionException {
        try {
            // source/MyDsl.g:175:2: ( 'naoBater();' | 'seguir();' )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==34) ) {
                alt13=1;
            }
            else if ( (LA13_0==35) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("172:1: regra : ( 'naoBater();' | 'seguir();' );", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // source/MyDsl.g:175:2: 'naoBater();'
                    {
                    match(input,34,FOLLOW_34_in_regra526); 
                    System.out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;O robo nao pode bater......");

                    }
                    break;
                case 2 :
                    // source/MyDsl.g:176:2: 'seguir();'
                    {
                    match(input,35,FOLLOW_35_in_regra533); 
                    System.out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;O robo deve seguir......");

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


 

    public static final BitSet FOLLOW_stat_in_prog27 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_plataforma_in_stat35 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_6_in_stat39 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_stat43 = new BitSet(new long[]{0x0000000000112080L});
    public static final BitSet FOLLOW_link_in_stat47 = new BitSet(new long[]{0x0000000000112080L});
    public static final BitSet FOLLOW_cabecalho_in_stat51 = new BitSet(new long[]{0x0000000000112000L});
    public static final BitSet FOLLOW_sensor_in_stat56 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_main_in_stat61 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_7_in_link75 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_link79 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_link81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_9_in_plataforma100 = new BitSet(new long[]{0x0000000000001C00L});
    public static final BitSet FOLLOW_nomeDaPlataforma_in_plataforma102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_nomeDaPlataforma115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_nomeDaPlataforma123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_nomeDaPlataforma131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_cabecalho153 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_cabecalho161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_cabecalho170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_sensor189 = new BitSet(new long[]{0x00000000000E0000L});
    public static final BitSet FOLLOW_tipoSensor_in_sensor191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_tipoSensor206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_tipoSensor214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_tipoSensor222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_main247 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_main249 = new BitSet(new long[]{0x0000000F808E0000L});
    public static final BitSet FOLLOW_loop_in_main253 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_main255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_comportamento_in_loop269 = new BitSet(new long[]{0x0000000F808E0000L});
    public static final BitSet FOLLOW_acoes_in_loop273 = new BitSet(new long[]{0x0000000F808E0000L});
    public static final BitSet FOLLOW_23_in_loop280 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_loop282 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_loop284 = new BitSet(new long[]{0x0000000F804E0000L});
    public static final BitSet FOLLOW_comportamento_in_loop292 = new BitSet(new long[]{0x0000000F804E0000L});
    public static final BitSet FOLLOW_acoes_in_loop296 = new BitSet(new long[]{0x0000000F804E0000L});
    public static final BitSet FOLLOW_22_in_loop302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sensorCriado_in_comportamento319 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_comportamento321 = new BitSet(new long[]{0x000000007C000000L});
    public static final BitSet FOLLOW_acaoSensor_in_comportamento325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_sensorCriado336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_sensorCriado344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_sensorCriado352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ligar_in_acaoSensor366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ler_in_acaoSensor370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_carregarListaCoordenadas_in_acaoSensor374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_recebeCoordenada_in_acaoSensor378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_obterImagem_in_acaoSensor382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ligar394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ler407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_carregarListaCoordenadas420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_recebeCoordenada433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_obterImagem446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_processarImagem_in_acoes463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_defineAtirar_in_acoes467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atuar_in_acoes471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_regra_in_acoes475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_processarImagem486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_defineAtirar499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_atuar512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_regra526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_regra533 = new BitSet(new long[]{0x0000000000000002L});

}
