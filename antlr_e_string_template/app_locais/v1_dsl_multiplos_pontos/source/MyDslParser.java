// $ANTLR 3.4 MyDsl.g 2011-11-26 00:26:10

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class MyDslParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "WS", "'(true)'", "'.'", "'<'", "'>'", "'adicionar'", "'andar();'", "'bussola'", "'camera'", "'carregarListaCoordenadas();'", "'criarSensor'", "'defineAtirar();'", "'defines'", "'golfe'", "'gps'", "'includes'", "'int main()'", "'ler();'", "'ligar();'", "'naoBater();'", "'obterImagem();'", "'pioneer'", "'plataforma'", "'processarImagem();'", "'recebeCoordenada();'", "'robo'", "'seguir();'", "'srv'", "'while'", "'{'", "'}'"
    };

    public static final int EOF=-1;
    public static final int T__6=6;
    public static final int T__7=7;
    public static final int T__8=8;
    public static final int T__9=9;
    public static final int T__10=10;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int ID=4;
    public static final int WS=5;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public MyDslParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public MyDslParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return MyDslParser.tokenNames; }
    public String getGrammarFileName() { return "MyDsl.g"; }


    	String plataforma;
    	String sensor;
    	String sensorCriado;



    // $ANTLR start "prog"
    // MyDsl.g:14:1: prog : ( stat )+ ;
    public final void prog() throws RecognitionException {
        try {
            // MyDsl.g:14:5: ( ( stat )+ )
            // MyDsl.g:14:7: ( stat )+
            {
            // MyDsl.g:14:7: ( stat )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==27) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // MyDsl.g:14:7: stat
            	    {
            	    pushFollow(FOLLOW_stat_in_prog27);
            	    stat();

            	    state._fsp--;


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
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "prog"



    // $ANTLR start "stat"
    // MyDsl.g:16:1: stat : plataforma 'robo' nomeRobo= ID ( link )* ( cabecalho )* ( sensor )* main ;
    public final void stat() throws RecognitionException {
        Token nomeRobo=null;

        try {
            // MyDsl.g:16:5: ( plataforma 'robo' nomeRobo= ID ( link )* ( cabecalho )* ( sensor )* main )
            // MyDsl.g:16:7: plataforma 'robo' nomeRobo= ID ( link )* ( cabecalho )* ( sensor )* main
            {
            pushFollow(FOLLOW_plataforma_in_stat35);
            plataforma();

            state._fsp--;


            match(input,30,FOLLOW_30_in_stat39); 

            nomeRobo=(Token)match(input,ID,FOLLOW_ID_in_stat43); 

            // MyDsl.g:18:2: ( link )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==8) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // MyDsl.g:18:2: link
            	    {
            	    pushFollow(FOLLOW_link_in_stat47);
            	    link();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            // MyDsl.g:19:2: ( cabecalho )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==10) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // MyDsl.g:19:2: cabecalho
            	    {
            	    pushFollow(FOLLOW_cabecalho_in_stat51);
            	    cabecalho();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            // MyDsl.g:20:2: ( sensor )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==15) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // MyDsl.g:20:2: sensor
            	    {
            	    pushFollow(FOLLOW_sensor_in_stat56);
            	    sensor();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            pushFollow(FOLLOW_main_in_stat61);
            main();

            state._fsp--;


            System.out.println ("Robo " +(nomeRobo!=null?nomeRobo.getText():null)+ " criado com sucesso!!");

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "stat"



    // $ANTLR start "link"
    // MyDsl.g:25:1: link : '<' nomeLink= ID '>' ;
    public final void link() throws RecognitionException {
        Token nomeLink=null;

        try {
            // MyDsl.g:25:5: ( '<' nomeLink= ID '>' )
            // MyDsl.g:26:2: '<' nomeLink= ID '>'
            {
            match(input,8,FOLLOW_8_in_link75); 

            nomeLink=(Token)match(input,ID,FOLLOW_ID_in_link79); 

            match(input,9,FOLLOW_9_in_link81); 

            System.out.println("[["+(nomeLink!=null?nomeLink.getText():null)+"]]");

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "link"



    // $ANTLR start "plataforma"
    // MyDsl.g:34:1: plataforma : 'plataforma' nomeDaPlataforma ;
    public final void plataforma() throws RecognitionException {
        try {
            // MyDsl.g:34:12: ( 'plataforma' nomeDaPlataforma )
            // MyDsl.g:35:2: 'plataforma' nomeDaPlataforma
            {
            match(input,27,FOLLOW_27_in_plataforma100); 

            pushFollow(FOLLOW_nomeDaPlataforma_in_plataforma102);
            nomeDaPlataforma();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "plataforma"



    // $ANTLR start "nomeDaPlataforma"
    // MyDsl.g:37:1: nomeDaPlataforma : ( 'pioneer' | 'srv' | 'golfe' ) ;
    public final void nomeDaPlataforma() throws RecognitionException {
        try {
            // MyDsl.g:37:17: ( ( 'pioneer' | 'srv' | 'golfe' ) )
            // MyDsl.g:38:2: ( 'pioneer' | 'srv' | 'golfe' )
            {
            // MyDsl.g:38:2: ( 'pioneer' | 'srv' | 'golfe' )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt5=1;
                }
                break;
            case 32:
                {
                alt5=2;
                }
                break;
            case 18:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }

            switch (alt5) {
                case 1 :
                    // MyDsl.g:39:3: 'pioneer'
                    {
                    match(input,26,FOLLOW_26_in_nomeDaPlataforma115); 

                    plataforma = "pioneer";

                    }
                    break;
                case 2 :
                    // MyDsl.g:40:3: 'srv'
                    {
                    match(input,32,FOLLOW_32_in_nomeDaPlataforma123); 

                    plataforma = "srv";

                    }
                    break;
                case 3 :
                    // MyDsl.g:41:3: 'golfe'
                    {
                    match(input,18,FOLLOW_18_in_nomeDaPlataforma131); 

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
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "nomeDaPlataforma"



    // $ANTLR start "cabecalho"
    // MyDsl.g:49:1: cabecalho : 'adicionar' itensCabecalho= ( 'defines' | 'includes' ) ;
    public final void cabecalho() throws RecognitionException {
        Token itensCabecalho=null;

        try {
            // MyDsl.g:49:10: ( 'adicionar' itensCabecalho= ( 'defines' | 'includes' ) )
            // MyDsl.g:50:2: 'adicionar' itensCabecalho= ( 'defines' | 'includes' )
            {
            match(input,10,FOLLOW_10_in_cabecalho153); 

            // MyDsl.g:50:29: ( 'defines' | 'includes' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            else if ( (LA6_0==20) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }
            switch (alt6) {
                case 1 :
                    // MyDsl.g:51:3: 'defines'
                    {
                    match(input,17,FOLLOW_17_in_cabecalho161); 


                    				if (plataforma == "pioneer")
                    				System.out.println("Defines Adicionados para plataforma Pioneer......................");
                    				if (plataforma == "srv")
                    				System.out.println("Defines Adicionados para plataforma SRV......................");
                    				if (plataforma == "golfe")
                    				System.out.println("Defines Adicionados para plataforma Carro de golfe......................");
                    				
                    		

                    }
                    break;
                case 2 :
                    // MyDsl.g:60:3: 'includes'
                    {
                    match(input,20,FOLLOW_20_in_cabecalho170); 


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
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "cabecalho"



    // $ANTLR start "sensor"
    // MyDsl.g:75:1: sensor : 'criarSensor' tipoSensor ;
    public final void sensor() throws RecognitionException {
        try {
            // MyDsl.g:75:7: ( 'criarSensor' tipoSensor )
            // MyDsl.g:76:2: 'criarSensor' tipoSensor
            {
            match(input,15,FOLLOW_15_in_sensor189); 

            pushFollow(FOLLOW_tipoSensor_in_sensor191);
            tipoSensor();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "sensor"



    // $ANTLR start "tipoSensor"
    // MyDsl.g:78:1: tipoSensor : s= ( 'gps' | 'bussola' | 'camera' ) ;
    public final void tipoSensor() throws RecognitionException {
        Token s=null;

        try {
            // MyDsl.g:78:11: (s= ( 'gps' | 'bussola' | 'camera' ) )
            // MyDsl.g:79:2: s= ( 'gps' | 'bussola' | 'camera' )
            {
            // MyDsl.g:79:4: ( 'gps' | 'bussola' | 'camera' )
            int alt7=3;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt7=1;
                }
                break;
            case 12:
                {
                alt7=2;
                }
                break;
            case 13:
                {
                alt7=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }

            switch (alt7) {
                case 1 :
                    // MyDsl.g:80:3: 'gps'
                    {
                    match(input,19,FOLLOW_19_in_tipoSensor206); 

                    sensor = "gps";

                    }
                    break;
                case 2 :
                    // MyDsl.g:81:3: 'bussola'
                    {
                    match(input,12,FOLLOW_12_in_tipoSensor214); 

                    sensor = "bussola";

                    }
                    break;
                case 3 :
                    // MyDsl.g:82:3: 'camera'
                    {
                    match(input,13,FOLLOW_13_in_tipoSensor222); 

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
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "tipoSensor"



    // $ANTLR start "main"
    // MyDsl.g:91:1: main : 'int main()' '{' loop '}' ;
    public final void main() throws RecognitionException {
        try {
            // MyDsl.g:91:5: ( 'int main()' '{' loop '}' )
            // MyDsl.g:92:2: 'int main()' '{' loop '}'
            {
            match(input,21,FOLLOW_21_in_main247); 

            match(input,34,FOLLOW_34_in_main249); 

            System.out.println("int main() {");

            pushFollow(FOLLOW_loop_in_main253);
            loop();

            state._fsp--;


            match(input,35,FOLLOW_35_in_main255); 

            System.out.println("}");

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "main"



    // $ANTLR start "loop"
    // MyDsl.g:95:1: loop : ( comportamento | acoes )* 'while' '(true)' '{' ( comportamento | acoes )* '}' ;
    public final void loop() throws RecognitionException {
        try {
            // MyDsl.g:95:5: ( ( comportamento | acoes )* 'while' '(true)' '{' ( comportamento | acoes )* '}' )
            // MyDsl.g:96:2: ( comportamento | acoes )* 'while' '(true)' '{' ( comportamento | acoes )* '}'
            {
            // MyDsl.g:96:2: ( comportamento | acoes )*
            loop8:
            do {
                int alt8=3;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0 >= 12 && LA8_0 <= 13)||LA8_0==19) ) {
                    alt8=1;
                }
                else if ( (LA8_0==11||LA8_0==16||LA8_0==24||LA8_0==28||LA8_0==31) ) {
                    alt8=2;
                }


                switch (alt8) {
            	case 1 :
            	    // MyDsl.g:96:3: comportamento
            	    {
            	    pushFollow(FOLLOW_comportamento_in_loop269);
            	    comportamento();

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // MyDsl.g:96:19: acoes
            	    {
            	    pushFollow(FOLLOW_acoes_in_loop273);
            	    acoes();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            match(input,33,FOLLOW_33_in_loop280); 

            match(input,6,FOLLOW_6_in_loop282); 

            match(input,34,FOLLOW_34_in_loop284); 

            System.out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;while(true) {");

            // MyDsl.g:99:2: ( comportamento | acoes )*
            loop9:
            do {
                int alt9=3;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0 >= 12 && LA9_0 <= 13)||LA9_0==19) ) {
                    alt9=1;
                }
                else if ( (LA9_0==11||LA9_0==16||LA9_0==24||LA9_0==28||LA9_0==31) ) {
                    alt9=2;
                }


                switch (alt9) {
            	case 1 :
            	    // MyDsl.g:99:3: comportamento
            	    {
            	    pushFollow(FOLLOW_comportamento_in_loop292);
            	    comportamento();

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // MyDsl.g:99:19: acoes
            	    {
            	    pushFollow(FOLLOW_acoes_in_loop296);
            	    acoes();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            match(input,35,FOLLOW_35_in_loop302); 

            System.out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}");

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "loop"



    // $ANTLR start "comportamento"
    // MyDsl.g:108:1: comportamento : sensorCriado '.' acaoSensor ;
    public final void comportamento() throws RecognitionException {
        try {
            // MyDsl.g:108:14: ( sensorCriado '.' acaoSensor )
            // MyDsl.g:109:2: sensorCriado '.' acaoSensor
            {
            pushFollow(FOLLOW_sensorCriado_in_comportamento319);
            sensorCriado();

            state._fsp--;


            match(input,7,FOLLOW_7_in_comportamento321); 

            pushFollow(FOLLOW_acaoSensor_in_comportamento325);
            acaoSensor();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "comportamento"



    // $ANTLR start "sensorCriado"
    // MyDsl.g:113:1: sensorCriado : ( 'gps' | 'bussola' | 'camera' );
    public final void sensorCriado() throws RecognitionException {
        try {
            // MyDsl.g:113:13: ( 'gps' | 'bussola' | 'camera' )
            int alt10=3;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt10=1;
                }
                break;
            case 12:
                {
                alt10=2;
                }
                break;
            case 13:
                {
                alt10=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;

            }

            switch (alt10) {
                case 1 :
                    // MyDsl.g:114:3: 'gps'
                    {
                    match(input,19,FOLLOW_19_in_sensorCriado336); 

                    sensorCriado = "gps";

                    }
                    break;
                case 2 :
                    // MyDsl.g:115:3: 'bussola'
                    {
                    match(input,12,FOLLOW_12_in_sensorCriado344); 

                    sensorCriado = "bussola";

                    }
                    break;
                case 3 :
                    // MyDsl.g:116:3: 'camera'
                    {
                    match(input,13,FOLLOW_13_in_sensorCriado352); 

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
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "sensorCriado"



    // $ANTLR start "acaoSensor"
    // MyDsl.g:120:1: acaoSensor : ( ligar | ler | carregarListaCoordenadas | recebeCoordenada | obterImagem );
    public final void acaoSensor() throws RecognitionException {
        try {
            // MyDsl.g:120:11: ( ligar | ler | carregarListaCoordenadas | recebeCoordenada | obterImagem )
            int alt11=5;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt11=1;
                }
                break;
            case 22:
                {
                alt11=2;
                }
                break;
            case 14:
                {
                alt11=3;
                }
                break;
            case 29:
                {
                alt11=4;
                }
                break;
            case 25:
                {
                alt11=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;

            }

            switch (alt11) {
                case 1 :
                    // MyDsl.g:121:2: ligar
                    {
                    pushFollow(FOLLOW_ligar_in_acaoSensor366);
                    ligar();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // MyDsl.g:121:10: ler
                    {
                    pushFollow(FOLLOW_ler_in_acaoSensor370);
                    ler();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // MyDsl.g:121:16: carregarListaCoordenadas
                    {
                    pushFollow(FOLLOW_carregarListaCoordenadas_in_acaoSensor374);
                    carregarListaCoordenadas();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // MyDsl.g:121:43: recebeCoordenada
                    {
                    pushFollow(FOLLOW_recebeCoordenada_in_acaoSensor378);
                    recebeCoordenada();

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // MyDsl.g:121:62: obterImagem
                    {
                    pushFollow(FOLLOW_obterImagem_in_acaoSensor382);
                    obterImagem();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "acaoSensor"



    // $ANTLR start "ligar"
    // MyDsl.g:124:1: ligar : 'ligar();' ;
    public final void ligar() throws RecognitionException {
        try {
            // MyDsl.g:124:6: ( 'ligar();' )
            // MyDsl.g:126:2: 'ligar();'
            {
            match(input,23,FOLLOW_23_in_ligar394); 

            System.out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;O sensor " +sensorCriado+ " foi ligado");

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "ligar"



    // $ANTLR start "ler"
    // MyDsl.g:129:1: ler : 'ler();' ;
    public final void ler() throws RecognitionException {
        try {
            // MyDsl.g:129:4: ( 'ler();' )
            // MyDsl.g:131:2: 'ler();'
            {
            match(input,22,FOLLOW_22_in_ler407); 

            System.out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;O sensor " +sensorCriado+ " está lendo");

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "ler"



    // $ANTLR start "carregarListaCoordenadas"
    // MyDsl.g:134:1: carregarListaCoordenadas : 'carregarListaCoordenadas();' ;
    public final void carregarListaCoordenadas() throws RecognitionException {
        try {
            // MyDsl.g:134:25: ( 'carregarListaCoordenadas();' )
            // MyDsl.g:136:2: 'carregarListaCoordenadas();'
            {
            match(input,14,FOLLOW_14_in_carregarListaCoordenadas420); 

            System.out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Código da lista de coordenadas vem aqui");

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "carregarListaCoordenadas"



    // $ANTLR start "recebeCoordenada"
    // MyDsl.g:139:1: recebeCoordenada : 'recebeCoordenada();' ;
    public final void recebeCoordenada() throws RecognitionException {
        try {
            // MyDsl.g:139:17: ( 'recebeCoordenada();' )
            // MyDsl.g:141:2: 'recebeCoordenada();'
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
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "recebeCoordenada"



    // $ANTLR start "obterImagem"
    // MyDsl.g:144:1: obterImagem : 'obterImagem();' ;
    public final void obterImagem() throws RecognitionException {
        try {
            // MyDsl.g:144:12: ( 'obterImagem();' )
            // MyDsl.g:146:2: 'obterImagem();'
            {
            match(input,25,FOLLOW_25_in_obterImagem446); 

            System.out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Código de obter imagem vem aqui");

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "obterImagem"



    // $ANTLR start "acoes"
    // MyDsl.g:153:1: acoes : ( processarImagem | defineAtirar | atuar | regra );
    public final void acoes() throws RecognitionException {
        try {
            // MyDsl.g:153:6: ( processarImagem | defineAtirar | atuar | regra )
            int alt12=4;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt12=1;
                }
                break;
            case 16:
                {
                alt12=2;
                }
                break;
            case 11:
                {
                alt12=3;
                }
                break;
            case 24:
            case 31:
                {
                alt12=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;

            }

            switch (alt12) {
                case 1 :
                    // MyDsl.g:154:2: processarImagem
                    {
                    pushFollow(FOLLOW_processarImagem_in_acoes463);
                    processarImagem();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // MyDsl.g:154:20: defineAtirar
                    {
                    pushFollow(FOLLOW_defineAtirar_in_acoes467);
                    defineAtirar();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // MyDsl.g:154:35: atuar
                    {
                    pushFollow(FOLLOW_atuar_in_acoes471);
                    atuar();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // MyDsl.g:154:43: regra
                    {
                    pushFollow(FOLLOW_regra_in_acoes475);
                    regra();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "acoes"



    // $ANTLR start "processarImagem"
    // MyDsl.g:157:1: processarImagem : 'processarImagem();' ;
    public final void processarImagem() throws RecognitionException {
        try {
            // MyDsl.g:157:16: ( 'processarImagem();' )
            // MyDsl.g:159:2: 'processarImagem();'
            {
            match(input,28,FOLLOW_28_in_processarImagem486); 

            System.out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;O robo está processando a imagem......");

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "processarImagem"



    // $ANTLR start "defineAtirar"
    // MyDsl.g:162:1: defineAtirar : 'defineAtirar();' ;
    public final void defineAtirar() throws RecognitionException {
        try {
            // MyDsl.g:162:13: ( 'defineAtirar();' )
            // MyDsl.g:164:2: 'defineAtirar();'
            {
            match(input,16,FOLLOW_16_in_defineAtirar499); 

            System.out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;O robo está atirando......");

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "defineAtirar"



    // $ANTLR start "atuar"
    // MyDsl.g:167:1: atuar : 'andar();' ;
    public final void atuar() throws RecognitionException {
        try {
            // MyDsl.g:167:6: ( 'andar();' )
            // MyDsl.g:169:2: 'andar();'
            {
            match(input,11,FOLLOW_11_in_atuar512); 

            System.out.println("\t\tO robo está andando......");

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "atuar"



    // $ANTLR start "regra"
    // MyDsl.g:172:1: regra : ( 'naoBater();' | 'seguir();' );
    public final void regra() throws RecognitionException {
        try {
            // MyDsl.g:172:6: ( 'naoBater();' | 'seguir();' )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==24) ) {
                alt13=1;
            }
            else if ( (LA13_0==31) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;

            }
            switch (alt13) {
                case 1 :
                    // MyDsl.g:175:2: 'naoBater();'
                    {
                    match(input,24,FOLLOW_24_in_regra526); 

                    System.out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;O robo nao pode bater......");

                    }
                    break;
                case 2 :
                    // MyDsl.g:176:2: 'seguir();'
                    {
                    match(input,31,FOLLOW_31_in_regra533); 

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
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "regra"

    // Delegated rules


 

    public static final BitSet FOLLOW_stat_in_prog27 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_plataforma_in_stat35 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_stat39 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_stat43 = new BitSet(new long[]{0x0000000000208500L});
    public static final BitSet FOLLOW_link_in_stat47 = new BitSet(new long[]{0x0000000000208500L});
    public static final BitSet FOLLOW_cabecalho_in_stat51 = new BitSet(new long[]{0x0000000000208400L});
    public static final BitSet FOLLOW_sensor_in_stat56 = new BitSet(new long[]{0x0000000000208000L});
    public static final BitSet FOLLOW_main_in_stat61 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_8_in_link75 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_link79 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_link81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_plataforma100 = new BitSet(new long[]{0x0000000104040000L});
    public static final BitSet FOLLOW_nomeDaPlataforma_in_plataforma102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_nomeDaPlataforma115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_nomeDaPlataforma123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_nomeDaPlataforma131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_cabecalho153 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_17_in_cabecalho161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_cabecalho170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_sensor189 = new BitSet(new long[]{0x0000000000083000L});
    public static final BitSet FOLLOW_tipoSensor_in_sensor191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_tipoSensor206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_tipoSensor214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_tipoSensor222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_main247 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_main249 = new BitSet(new long[]{0x0000000291093800L});
    public static final BitSet FOLLOW_loop_in_main253 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_main255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_comportamento_in_loop269 = new BitSet(new long[]{0x0000000291093800L});
    public static final BitSet FOLLOW_acoes_in_loop273 = new BitSet(new long[]{0x0000000291093800L});
    public static final BitSet FOLLOW_33_in_loop280 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_6_in_loop282 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_loop284 = new BitSet(new long[]{0x0000000891093800L});
    public static final BitSet FOLLOW_comportamento_in_loop292 = new BitSet(new long[]{0x0000000891093800L});
    public static final BitSet FOLLOW_acoes_in_loop296 = new BitSet(new long[]{0x0000000891093800L});
    public static final BitSet FOLLOW_35_in_loop302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sensorCriado_in_comportamento319 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_7_in_comportamento321 = new BitSet(new long[]{0x0000000022C04000L});
    public static final BitSet FOLLOW_acaoSensor_in_comportamento325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_sensorCriado336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_sensorCriado344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_sensorCriado352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ligar_in_acaoSensor366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ler_in_acaoSensor370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_carregarListaCoordenadas_in_acaoSensor374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_recebeCoordenada_in_acaoSensor378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_obterImagem_in_acaoSensor382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ligar394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ler407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_carregarListaCoordenadas420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_recebeCoordenada433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_obterImagem446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_processarImagem_in_acoes463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_defineAtirar_in_acoes467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atuar_in_acoes471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_regra_in_acoes475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_processarImagem486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_defineAtirar499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_atuar512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_regra526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_regra533 = new BitSet(new long[]{0x0000000000000002L});

}