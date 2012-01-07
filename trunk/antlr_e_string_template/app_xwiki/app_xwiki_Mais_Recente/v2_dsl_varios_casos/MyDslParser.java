// $ANTLR 3.4 MyDsl.g 2011-12-01 11:55:20
import org.antlr.stringtemplate.*;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.stringtemplate.*;
import org.antlr.stringtemplate.language.*;
import java.util.HashMap;
@SuppressWarnings({"all", "warnings", "unchecked"})
public class MyDslParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "WS", "'(true)'", "'adicionar'", "'andar();'", "'bussola'", "'bussola.ler();'", "'bussola.ligar();'", "'camera'", "'camera.ler();'", "'camera.ligar();'", "'carregarListaCoordenadas();'", "'criarSensor'", "'defineRegra();'", "'defineRegraNaoBater();'", "'defineRegraSeguir();'", "'defineRegraSeguirMultiplasCoordenadas();'", "'defines'", "'golfe'", "'gps'", "'gps.ler();'", "'gps.ligar();'", "'importar pacote'", "'includes'", "'inicializarPlayer();'", "'int main()'", "'localizacao;'", "'pioneer'", "'plataforma'", "'player;'", "'processaImagem();'", "'processaInfo();'", "'receberCoordenada();'", "'robo'", "'srv'", "'while'", "'{'", "'}'"
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
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int T__41=41;
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

protected StringTemplateGroup templateLib =
  new StringTemplateGroup("MyDslParserTemplates", AngleBracketTemplateLexer.class);

public void setTemplateLib(StringTemplateGroup templateLib) {
  this.templateLib = templateLib;
}
public StringTemplateGroup getTemplateLib() {
  return templateLib;
}
/** allows convenient multi-value initialization:
 *  "new STAttrMap().put(...).put(...)"
 */
public static class STAttrMap extends HashMap {
  public STAttrMap put(String attrName, Object value) {
    super.put(attrName, value);
    return this;
  }
  public STAttrMap put(String attrName, int value) {
    super.put(attrName, new Integer(value));
    return this;
  }
}
    public String[] getTokenNames() { return MyDslParser.tokenNames; }
    public String getGrammarFileName() { return "MyDsl.g"; }


    	String plat;
    	String sensor;
    	String sensorCriado;


    protected static class robo_scope {
        List cabList;
        List senList;
        List mainList;
        List pacList;
    }
    protected Stack robo_stack = new Stack();


    public static class robo_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "robo"
    // MyDsl.g:10:1: robo : ( stat )+ -> classe(cab=$robo::cabListpacote=$robo::pacListsen=$robo::senListmain=$robo::mainList);
    public final MyDslParser.robo_return robo() throws RecognitionException {
        robo_stack.push(new robo_scope());
        MyDslParser.robo_return retval = new MyDslParser.robo_return();
        retval.start = input.LT(1);



        	((robo_scope)robo_stack.peek()).cabList = new ArrayList();
        	((robo_scope)robo_stack.peek()).pacList = new ArrayList();
        	((robo_scope)robo_stack.peek()).senList = new ArrayList();
        	((robo_scope)robo_stack.peek()).mainList = new ArrayList();

        try {
            // MyDsl.g:23:2: ( ( stat )+ -> classe(cab=$robo::cabListpacote=$robo::pacListsen=$robo::senListmain=$robo::mainList))
            // MyDsl.g:23:4: ( stat )+
            {
            // MyDsl.g:23:4: ( stat )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==32) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // MyDsl.g:23:4: stat
            	    {
            	    pushFollow(FOLLOW_stat_in_robo37);
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


            // TEMPLATE REWRITE
            // 23:10: -> classe(cab=$robo::cabListpacote=$robo::pacListsen=$robo::senListmain=$robo::mainList)
            {
                retval.st = templateLib.getInstanceOf("classe",new STAttrMap().put("cab", ((robo_scope)robo_stack.peek()).cabList).put("pacote", ((robo_scope)robo_stack.peek()).pacList).put("sen", ((robo_scope)robo_stack.peek()).senList).put("main", ((robo_scope)robo_stack.peek()).mainList));
            }



            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            robo_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "robo"


    public static class stat_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "stat"
    // MyDsl.g:26:1: stat : plataforma 'robo' nomeRobo= ID ( cabecalho )* ( pacote )* ( sensor )* main ;
    public final MyDslParser.stat_return stat() throws RecognitionException {
        MyDslParser.stat_return retval = new MyDslParser.stat_return();
        retval.start = input.LT(1);


        Token nomeRobo=null;

        try {
            // MyDsl.g:26:5: ( plataforma 'robo' nomeRobo= ID ( cabecalho )* ( pacote )* ( sensor )* main )
            // MyDsl.g:26:7: plataforma 'robo' nomeRobo= ID ( cabecalho )* ( pacote )* ( sensor )* main
            {
            pushFollow(FOLLOW_plataforma_in_stat71);
            plataforma();

            state._fsp--;


            match(input,37,FOLLOW_37_in_stat75); 

            nomeRobo=(Token)match(input,ID,FOLLOW_ID_in_stat79); 

            // MyDsl.g:28:2: ( cabecalho )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==7) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // MyDsl.g:28:2: cabecalho
            	    {
            	    pushFollow(FOLLOW_cabecalho_in_stat83);
            	    cabecalho();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            // MyDsl.g:29:2: ( pacote )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==26) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // MyDsl.g:29:2: pacote
            	    {
            	    pushFollow(FOLLOW_pacote_in_stat88);
            	    pacote();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            // MyDsl.g:30:2: ( sensor )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==16) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // MyDsl.g:30:2: sensor
            	    {
            	    pushFollow(FOLLOW_sensor_in_stat92);
            	    sensor();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            pushFollow(FOLLOW_main_in_stat97);
            main();

            state._fsp--;


            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "stat"


    public static class plataforma_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "plataforma"
    // MyDsl.g:38:1: plataforma : 'plataforma' nomeDaPlataforma ;
    public final MyDslParser.plataforma_return plataforma() throws RecognitionException {
        MyDslParser.plataforma_return retval = new MyDslParser.plataforma_return();
        retval.start = input.LT(1);


        try {
            // MyDsl.g:38:12: ( 'plataforma' nomeDaPlataforma )
            // MyDsl.g:39:2: 'plataforma' nomeDaPlataforma
            {
            match(input,32,FOLLOW_32_in_plataforma115); 

            pushFollow(FOLLOW_nomeDaPlataforma_in_plataforma117);
            nomeDaPlataforma();

            state._fsp--;


            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "plataforma"


    public static class nomeDaPlataforma_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "nomeDaPlataforma"
    // MyDsl.g:41:1: nomeDaPlataforma : plat= ( 'pioneer' | 'srv' | 'golfe' ) ;
    public final MyDslParser.nomeDaPlataforma_return nomeDaPlataforma() throws RecognitionException {
        MyDslParser.nomeDaPlataforma_return retval = new MyDslParser.nomeDaPlataforma_return();
        retval.start = input.LT(1);


        Token plat=null;

        try {
            // MyDsl.g:43:4: (plat= ( 'pioneer' | 'srv' | 'golfe' ) )
            // MyDsl.g:43:4: plat= ( 'pioneer' | 'srv' | 'golfe' )
            {
            plat=(Token)input.LT(1);

            if ( input.LA(1)==22||input.LA(1)==31||input.LA(1)==38 ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nomeDaPlataforma"


    public static class cabecalho_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "cabecalho"
    // MyDsl.g:52:1: cabecalho : 'adicionar' itensCabecalho= ( 'defines' -> define(| 'includes' -> include() ;
    public final MyDslParser.cabecalho_return cabecalho() throws RecognitionException {
        MyDslParser.cabecalho_return retval = new MyDslParser.cabecalho_return();
        retval.start = input.LT(1);


        Token itensCabecalho=null;

        try {
            // MyDsl.g:52:10: ( 'adicionar' itensCabecalho= ( 'defines' -> define(| 'includes' -> include() )
            // MyDsl.g:53:2: 'adicionar' itensCabecalho= ( 'defines' -> define(| 'includes' -> include()
            {
            match(input,7,FOLLOW_7_in_cabecalho174); 

            // MyDsl.g:53:29: ( 'defines' -> define(| 'includes' -> include()
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==21) ) {
                alt5=1;
            }
            else if ( (LA5_0==27) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }
            switch (alt5) {
                case 1 :
                    // MyDsl.g:54:3: 'defines'
                    {
                    match(input,21,FOLLOW_21_in_cabecalho182); 

                    // TEMPLATE REWRITE
                    // 54:13: -> define(
                    {
                        retval.st = templateLib.getInstanceOf("define");
                    }



                    }
                    break;
                case 2 :
                    // MyDsl.g:55:5: 'includes'
                    {
                    match(input,27,FOLLOW_27_in_cabecalho195); 

                    // TEMPLATE REWRITE
                    // 55:16: -> include(
                    {
                        retval.st = templateLib.getInstanceOf("include");
                    }



                    }
                    break;

            }


            ((robo_scope)robo_stack.peek()).cabList.add(retval.st);

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cabecalho"


    public static class pacote_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "pacote"
    // MyDsl.g:61:1: pacote : 'importar pacote' ( 'player;' -> pacotePlayer(| 'localizacao;' -> pacoteLocalizacao() ;
    public final MyDslParser.pacote_return pacote() throws RecognitionException {
        MyDslParser.pacote_return retval = new MyDslParser.pacote_return();
        retval.start = input.LT(1);


        try {
            // MyDsl.g:61:8: ( 'importar pacote' ( 'player;' -> pacotePlayer(| 'localizacao;' -> pacoteLocalizacao() )
            // MyDsl.g:62:2: 'importar pacote' ( 'player;' -> pacotePlayer(| 'localizacao;' -> pacoteLocalizacao()
            {
            match(input,26,FOLLOW_26_in_pacote222); 

            // MyDsl.g:62:20: ( 'player;' -> pacotePlayer(| 'localizacao;' -> pacoteLocalizacao()
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==33) ) {
                alt6=1;
            }
            else if ( (LA6_0==30) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }
            switch (alt6) {
                case 1 :
                    // MyDsl.g:62:22: 'player;'
                    {
                    match(input,33,FOLLOW_33_in_pacote226); 

                    // TEMPLATE REWRITE
                    // 62:32: -> pacotePlayer(
                    {
                        retval.st = templateLib.getInstanceOf("pacotePlayer");
                    }



                    }
                    break;
                case 2 :
                    // MyDsl.g:63:8: 'localizacao;'
                    {
                    match(input,30,FOLLOW_30_in_pacote241); 

                    // TEMPLATE REWRITE
                    // 63:23: -> pacoteLocalizacao(
                    {
                        retval.st = templateLib.getInstanceOf("pacoteLocalizacao");
                    }



                    }
                    break;

            }


            ((robo_scope)robo_stack.peek()).pacList.add(retval.st);

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "pacote"


    public static class sensor_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "sensor"
    // MyDsl.g:69:1: sensor : 'criarSensor' tipoSensor ;
    public final MyDslParser.sensor_return sensor() throws RecognitionException {
        MyDslParser.sensor_return retval = new MyDslParser.sensor_return();
        retval.start = input.LT(1);


        MyDslParser.tipoSensor_return tipoSensor1 =null;


        try {
            // MyDsl.g:69:7: ( 'criarSensor' tipoSensor )
            // MyDsl.g:70:2: 'criarSensor' tipoSensor
            {
            match(input,16,FOLLOW_16_in_sensor269); 

            pushFollow(FOLLOW_tipoSensor_in_sensor271);
            tipoSensor1=tipoSensor();

            state._fsp--;


            ((robo_scope)robo_stack.peek()).senList.add((tipoSensor1!=null?tipoSensor1.st:null));

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "sensor"


    public static class tipoSensor_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "tipoSensor"
    // MyDsl.g:72:1: tipoSensor : ( 'gps' -> gps(| 'bussola' -> bussola(| 'camera' -> camera();
    public final MyDslParser.tipoSensor_return tipoSensor() throws RecognitionException {
        MyDslParser.tipoSensor_return retval = new MyDslParser.tipoSensor_return();
        retval.start = input.LT(1);


        try {
            // MyDsl.g:73:2: ( 'gps' -> gps(| 'bussola' -> bussola(| 'camera' -> camera()
            int alt7=3;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt7=1;
                }
                break;
            case 9:
                {
                alt7=2;
                }
                break;
            case 12:
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
                    // MyDsl.g:73:4: 'gps'
                    {
                    match(input,23,FOLLOW_23_in_tipoSensor283); 

                    // TEMPLATE REWRITE
                    // 73:10: -> gps(
                    {
                        retval.st = templateLib.getInstanceOf("gps");
                    }



                    }
                    break;
                case 2 :
                    // MyDsl.g:74:5: 'bussola'
                    {
                    match(input,9,FOLLOW_9_in_tipoSensor295); 

                    // TEMPLATE REWRITE
                    // 74:14: -> bussola(
                    {
                        retval.st = templateLib.getInstanceOf("bussola");
                    }



                    }
                    break;
                case 3 :
                    // MyDsl.g:75:5: 'camera'
                    {
                    match(input,12,FOLLOW_12_in_tipoSensor307); 

                    // TEMPLATE REWRITE
                    // 75:13: -> camera(
                    {
                        retval.st = templateLib.getInstanceOf("camera");
                    }



                    }
                    break;

            }
            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "tipoSensor"


    public static class main_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "main"
    // MyDsl.g:81:1: main : ( 'int main()' '{' -> mainTemplate() loop '}' ;
    public final MyDslParser.main_return main() throws RecognitionException {
        MyDslParser.main_return retval = new MyDslParser.main_return();
        retval.start = input.LT(1);


        try {
            // MyDsl.g:81:5: ( ( 'int main()' '{' -> mainTemplate() loop '}' )
            // MyDsl.g:82:2: ( 'int main()' '{' -> mainTemplate() loop '}'
            {
            // MyDsl.g:82:2: ( 'int main()' '{' -> mainTemplate()
            // MyDsl.g:82:3: 'int main()' '{'
            {
            match(input,29,FOLLOW_29_in_main328); 

            match(input,40,FOLLOW_40_in_main330); 

            // TEMPLATE REWRITE
            // 82:20: -> mainTemplate(
            {
                retval.st = templateLib.getInstanceOf("mainTemplate");
            }



            }


            ((robo_scope)robo_stack.peek()).mainList.add(retval.st);

            pushFollow(FOLLOW_loop_in_main342);
            loop();

            state._fsp--;


            match(input,41,FOLLOW_41_in_main344); 

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "main"


    public static class loop_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "loop"
    // MyDsl.g:86:1: loop : ( inicializacaoSensor )* ( 'while' '(true)' '{' -> while() ( entrada | processamento | comportamento | acao )* '}' ;
    public final MyDslParser.loop_return loop() throws RecognitionException {
        MyDslParser.loop_return retval = new MyDslParser.loop_return();
        retval.start = input.LT(1);


        try {
            // MyDsl.g:86:5: ( ( inicializacaoSensor )* ( 'while' '(true)' '{' -> while() ( entrada | processamento | comportamento | acao )* '}' )
            // MyDsl.g:87:2: ( inicializacaoSensor )* ( 'while' '(true)' '{' -> while() ( entrada | processamento | comportamento | acao )* '}'
            {
            // MyDsl.g:87:2: ( inicializacaoSensor )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==WS||LA8_0==11||(LA8_0 >= 14 && LA8_0 <= 15)||LA8_0==25||LA8_0==28) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // MyDsl.g:87:3: inicializacaoSensor
            	    {
            	    pushFollow(FOLLOW_inicializacaoSensor_in_loop356);
            	    inicializacaoSensor();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            // MyDsl.g:88:2: ( 'while' '(true)' '{' -> while()
            // MyDsl.g:88:4: 'while' '(true)' '{'
            {
            match(input,39,FOLLOW_39_in_loop364); 

            match(input,6,FOLLOW_6_in_loop366); 

            match(input,40,FOLLOW_40_in_loop368); 

            // TEMPLATE REWRITE
            // 88:26: -> while(
            {
                retval.st = templateLib.getInstanceOf("while");
            }



            }


            ((robo_scope)robo_stack.peek()).mainList.add(retval.st);

            // MyDsl.g:89:2: ( entrada | processamento | comportamento | acao )*
            loop9:
            do {
                int alt9=5;
                switch ( input.LA(1) ) {
                case 10:
                case 13:
                case 15:
                case 24:
                case 36:
                    {
                    alt9=1;
                    }
                    break;
                case 34:
                case 35:
                    {
                    alt9=2;
                    }
                    break;
                case 17:
                case 18:
                case 19:
                case 20:
                    {
                    alt9=3;
                    }
                    break;
                case 8:
                    {
                    alt9=4;
                    }
                    break;

                }

                switch (alt9) {
            	case 1 :
            	    // MyDsl.g:89:3: entrada
            	    {
            	    pushFollow(FOLLOW_entrada_in_loop384);
            	    entrada();

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // MyDsl.g:89:13: processamento
            	    {
            	    pushFollow(FOLLOW_processamento_in_loop388);
            	    processamento();

            	    state._fsp--;


            	    }
            	    break;
            	case 3 :
            	    // MyDsl.g:89:29: comportamento
            	    {
            	    pushFollow(FOLLOW_comportamento_in_loop392);
            	    comportamento();

            	    state._fsp--;


            	    }
            	    break;
            	case 4 :
            	    // MyDsl.g:89:45: acao
            	    {
            	    pushFollow(FOLLOW_acao_in_loop396);
            	    acao();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            match(input,41,FOLLOW_41_in_loop401); 

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "loop"


    public static class inicializacaoSensor_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "inicializacaoSensor"
    // MyDsl.g:96:1: inicializacaoSensor : ( WS )* ( 'gps.ligar();' -> gpsLigar(| 'bussola.ligar();' -> bussolaLigar(| 'camera.ligar();' -> cameraLigar(| 'carregarListaCoordenadas();' -> carregarListaCoordenadas(| 'inicializarPlayer();' -> inicializarPlayer() ;
    public final MyDslParser.inicializacaoSensor_return inicializacaoSensor() throws RecognitionException {
        MyDslParser.inicializacaoSensor_return retval = new MyDslParser.inicializacaoSensor_return();
        retval.start = input.LT(1);


        try {
            // MyDsl.g:96:21: ( ( WS )* ( 'gps.ligar();' -> gpsLigar(| 'bussola.ligar();' -> bussolaLigar(| 'camera.ligar();' -> cameraLigar(| 'carregarListaCoordenadas();' -> carregarListaCoordenadas(| 'inicializarPlayer();' -> inicializarPlayer() )
            // MyDsl.g:97:4: ( WS )* ( 'gps.ligar();' -> gpsLigar(| 'bussola.ligar();' -> bussolaLigar(| 'camera.ligar();' -> cameraLigar(| 'carregarListaCoordenadas();' -> carregarListaCoordenadas(| 'inicializarPlayer();' -> inicializarPlayer()
            {
            // MyDsl.g:97:4: ( WS )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==WS) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // MyDsl.g:97:5: WS
            	    {
            	    match(input,WS,FOLLOW_WS_in_inicializacaoSensor420); 

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            // MyDsl.g:98:4: ( 'gps.ligar();' -> gpsLigar(| 'bussola.ligar();' -> bussolaLigar(| 'camera.ligar();' -> cameraLigar(| 'carregarListaCoordenadas();' -> carregarListaCoordenadas(| 'inicializarPlayer();' -> inicializarPlayer()
            int alt11=5;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt11=1;
                }
                break;
            case 11:
                {
                alt11=2;
                }
                break;
            case 14:
                {
                alt11=3;
                }
                break;
            case 15:
                {
                alt11=4;
                }
                break;
            case 28:
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
                    // MyDsl.g:98:6: 'gps.ligar();'
                    {
                    match(input,25,FOLLOW_25_in_inicializacaoSensor429); 

                    // TEMPLATE REWRITE
                    // 98:23: -> gpsLigar(
                    {
                        retval.st = templateLib.getInstanceOf("gpsLigar");
                    }



                    }
                    break;
                case 2 :
                    // MyDsl.g:99:6: 'bussola.ligar();'
                    {
                    match(input,11,FOLLOW_11_in_inicializacaoSensor445); 

                    // TEMPLATE REWRITE
                    // 99:27: -> bussolaLigar(
                    {
                        retval.st = templateLib.getInstanceOf("bussolaLigar");
                    }



                    }
                    break;
                case 3 :
                    // MyDsl.g:100:6: 'camera.ligar();'
                    {
                    match(input,14,FOLLOW_14_in_inicializacaoSensor460); 

                    // TEMPLATE REWRITE
                    // 100:25: -> cameraLigar(
                    {
                        retval.st = templateLib.getInstanceOf("cameraLigar");
                    }



                    }
                    break;
                case 4 :
                    // MyDsl.g:101:6: 'carregarListaCoordenadas();'
                    {
                    match(input,15,FOLLOW_15_in_inicializacaoSensor474); 

                    // TEMPLATE REWRITE
                    // 101:36: -> carregarListaCoordenadas(
                    {
                        retval.st = templateLib.getInstanceOf("carregarListaCoordenadas");
                    }



                    }
                    break;
                case 5 :
                    // MyDsl.g:102:6: 'inicializarPlayer();'
                    {
                    match(input,28,FOLLOW_28_in_inicializacaoSensor488); 

                    // TEMPLATE REWRITE
                    // 102:32: -> inicializarPlayer(
                    {
                        retval.st = templateLib.getInstanceOf("inicializarPlayer");
                    }



                    }
                    break;

            }


            ((robo_scope)robo_stack.peek()).mainList.add(retval.st);

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "inicializacaoSensor"


    public static class entrada_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "entrada"
    // MyDsl.g:110:1: entrada : ( 'gps.ler();' -> gpsLer(| 'bussola.ler();' -> bussolaLer(| 'camera.ler();' -> cameraLer(| 'receberCoordenada();' -> receberCoordenada(| 'carregarListaCoordenadas();' -> carregarListaCoordenadas() ;
    public final MyDslParser.entrada_return entrada() throws RecognitionException {
        MyDslParser.entrada_return retval = new MyDslParser.entrada_return();
        retval.start = input.LT(1);


        try {
            // MyDsl.g:110:8: ( ( 'gps.ler();' -> gpsLer(| 'bussola.ler();' -> bussolaLer(| 'camera.ler();' -> cameraLer(| 'receberCoordenada();' -> receberCoordenada(| 'carregarListaCoordenadas();' -> carregarListaCoordenadas() )
            // MyDsl.g:111:3: ( 'gps.ler();' -> gpsLer(| 'bussola.ler();' -> bussolaLer(| 'camera.ler();' -> cameraLer(| 'receberCoordenada();' -> receberCoordenada(| 'carregarListaCoordenadas();' -> carregarListaCoordenadas()
            {
            // MyDsl.g:111:3: ( 'gps.ler();' -> gpsLer(| 'bussola.ler();' -> bussolaLer(| 'camera.ler();' -> cameraLer(| 'receberCoordenada();' -> receberCoordenada(| 'carregarListaCoordenadas();' -> carregarListaCoordenadas()
            int alt12=5;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt12=1;
                }
                break;
            case 10:
                {
                alt12=2;
                }
                break;
            case 13:
                {
                alt12=3;
                }
                break;
            case 36:
                {
                alt12=4;
                }
                break;
            case 15:
                {
                alt12=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;

            }

            switch (alt12) {
                case 1 :
                    // MyDsl.g:111:5: 'gps.ler();'
                    {
                    match(input,24,FOLLOW_24_in_entrada523); 

                    // TEMPLATE REWRITE
                    // 111:18: -> gpsLer(
                    {
                        retval.st = templateLib.getInstanceOf("gpsLer");
                    }



                    }
                    break;
                case 2 :
                    // MyDsl.g:112:5: 'bussola.ler();'
                    {
                    match(input,10,FOLLOW_10_in_entrada536); 

                    // TEMPLATE REWRITE
                    // 112:22: -> bussolaLer(
                    {
                        retval.st = templateLib.getInstanceOf("bussolaLer");
                    }



                    }
                    break;
                case 3 :
                    // MyDsl.g:113:5: 'camera.ler();'
                    {
                    match(input,13,FOLLOW_13_in_entrada548); 

                    // TEMPLATE REWRITE
                    // 113:21: -> cameraLer(
                    {
                        retval.st = templateLib.getInstanceOf("cameraLer");
                    }



                    }
                    break;
                case 4 :
                    // MyDsl.g:114:5: 'receberCoordenada();'
                    {
                    match(input,36,FOLLOW_36_in_entrada560); 

                    // TEMPLATE REWRITE
                    // 114:28: -> receberCoordenada(
                    {
                        retval.st = templateLib.getInstanceOf("receberCoordenada");
                    }



                    }
                    break;
                case 5 :
                    // MyDsl.g:115:5: 'carregarListaCoordenadas();'
                    {
                    match(input,15,FOLLOW_15_in_entrada572); 

                    // TEMPLATE REWRITE
                    // 115:35: -> carregarListaCoordenadas(
                    {
                        retval.st = templateLib.getInstanceOf("carregarListaCoordenadas");
                    }



                    }
                    break;

            }


            ((robo_scope)robo_stack.peek()).mainList.add(retval.st);

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "entrada"


    public static class processamento_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "processamento"
    // MyDsl.g:123:1: processamento : ( 'processaInfo();' -> processaInfo(| 'processaImagem();' -> processaImagem() ;
    public final MyDslParser.processamento_return processamento() throws RecognitionException {
        MyDslParser.processamento_return retval = new MyDslParser.processamento_return();
        retval.start = input.LT(1);


        try {
            // MyDsl.g:123:15: ( ( 'processaInfo();' -> processaInfo(| 'processaImagem();' -> processaImagem() )
            // MyDsl.g:124:3: ( 'processaInfo();' -> processaInfo(| 'processaImagem();' -> processaImagem()
            {
            // MyDsl.g:124:3: ( 'processaInfo();' -> processaInfo(| 'processaImagem();' -> processaImagem()
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==35) ) {
                alt13=1;
            }
            else if ( (LA13_0==34) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;

            }
            switch (alt13) {
                case 1 :
                    // MyDsl.g:124:5: 'processaInfo();'
                    {
                    match(input,35,FOLLOW_35_in_processamento604); 

                    // TEMPLATE REWRITE
                    // 124:23: -> processaInfo(
                    {
                        retval.st = templateLib.getInstanceOf("processaInfo");
                    }



                    }
                    break;
                case 2 :
                    // MyDsl.g:125:5: 'processaImagem();'
                    {
                    match(input,34,FOLLOW_34_in_processamento616); 

                    // TEMPLATE REWRITE
                    // 125:25: -> processaImagem(
                    {
                        retval.st = templateLib.getInstanceOf("processaImagem");
                    }



                    }
                    break;

            }


            ((robo_scope)robo_stack.peek()).mainList.add(retval.st);

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "processamento"


    public static class acao_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "acao"
    // MyDsl.g:134:1: acao : andar ;
    public final MyDslParser.acao_return acao() throws RecognitionException {
        MyDslParser.acao_return retval = new MyDslParser.acao_return();
        retval.start = input.LT(1);


        try {
            // MyDsl.g:134:5: ( andar )
            // MyDsl.g:135:2: andar
            {
            pushFollow(FOLLOW_andar_in_acao644);
            andar();

            state._fsp--;


            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "acao"


    public static class comportamento_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "comportamento"
    // MyDsl.g:137:1: comportamento : ( 'defineRegra();' -> defineRegra(| 'defineRegraSeguir();' -> defineRegraSeguir(| 'defineRegraNaoBater();' -> defineRegraNaoBater(| 'defineRegraSeguirMultiplasCoordenadas();' -> defineRegraSeguirMultiplasCoordenadas() ;
    public final MyDslParser.comportamento_return comportamento() throws RecognitionException {
        MyDslParser.comportamento_return retval = new MyDslParser.comportamento_return();
        retval.start = input.LT(1);


        try {
            // MyDsl.g:137:15: ( ( 'defineRegra();' -> defineRegra(| 'defineRegraSeguir();' -> defineRegraSeguir(| 'defineRegraNaoBater();' -> defineRegraNaoBater(| 'defineRegraSeguirMultiplasCoordenadas();' -> defineRegraSeguirMultiplasCoordenadas() )
            // MyDsl.g:138:3: ( 'defineRegra();' -> defineRegra(| 'defineRegraSeguir();' -> defineRegraSeguir(| 'defineRegraNaoBater();' -> defineRegraNaoBater(| 'defineRegraSeguirMultiplasCoordenadas();' -> defineRegraSeguirMultiplasCoordenadas()
            {
            // MyDsl.g:138:3: ( 'defineRegra();' -> defineRegra(| 'defineRegraSeguir();' -> defineRegraSeguir(| 'defineRegraNaoBater();' -> defineRegraNaoBater(| 'defineRegraSeguirMultiplasCoordenadas();' -> defineRegraSeguirMultiplasCoordenadas()
            int alt14=4;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt14=1;
                }
                break;
            case 19:
                {
                alt14=2;
                }
                break;
            case 18:
                {
                alt14=3;
                }
                break;
            case 20:
                {
                alt14=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;

            }

            switch (alt14) {
                case 1 :
                    // MyDsl.g:138:5: 'defineRegra();'
                    {
                    match(input,17,FOLLOW_17_in_comportamento658); 

                    // TEMPLATE REWRITE
                    // 138:22: -> defineRegra(
                    {
                        retval.st = templateLib.getInstanceOf("defineRegra");
                    }



                    }
                    break;
                case 2 :
                    // MyDsl.g:139:5: 'defineRegraSeguir();'
                    {
                    match(input,19,FOLLOW_19_in_comportamento670); 

                    // TEMPLATE REWRITE
                    // 139:28: -> defineRegraSeguir(
                    {
                        retval.st = templateLib.getInstanceOf("defineRegraSeguir");
                    }



                    }
                    break;
                case 3 :
                    // MyDsl.g:140:5: 'defineRegraNaoBater();'
                    {
                    match(input,18,FOLLOW_18_in_comportamento682); 

                    // TEMPLATE REWRITE
                    // 140:30: -> defineRegraNaoBater(
                    {
                        retval.st = templateLib.getInstanceOf("defineRegraNaoBater");
                    }



                    }
                    break;
                case 4 :
                    // MyDsl.g:141:5: 'defineRegraSeguirMultiplasCoordenadas();'
                    {
                    match(input,20,FOLLOW_20_in_comportamento695); 

                    // TEMPLATE REWRITE
                    // 141:48: -> defineRegraSeguirMultiplasCoordenadas(
                    {
                        retval.st = templateLib.getInstanceOf("defineRegraSeguirMultiplasCoordenadas");
                    }



                    }
                    break;

            }


            ((robo_scope)robo_stack.peek()).mainList.add(retval.st);

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "comportamento"


    public static class andar_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "andar"
    // MyDsl.g:150:1: andar : ( 'andar();' -> andar() ;
    public final MyDslParser.andar_return andar() throws RecognitionException {
        MyDslParser.andar_return retval = new MyDslParser.andar_return();
        retval.start = input.LT(1);


        try {
            // MyDsl.g:150:7: ( ( 'andar();' -> andar() )
            // MyDsl.g:150:9: ( 'andar();' -> andar()
            {
            // MyDsl.g:150:9: ( 'andar();' -> andar()
            // MyDsl.g:150:10: 'andar();'
            {
            match(input,8,FOLLOW_8_in_andar725); 

            // TEMPLATE REWRITE
            // 150:21: -> andar(
            {
                retval.st = templateLib.getInstanceOf("andar");
            }



            }


            ((robo_scope)robo_stack.peek()).mainList.add(retval.st);

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "andar"

    // Delegated rules


 

    public static final BitSet FOLLOW_stat_in_robo37 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_plataforma_in_stat71 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_stat75 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_stat79 = new BitSet(new long[]{0x0000000024010080L});
    public static final BitSet FOLLOW_cabecalho_in_stat83 = new BitSet(new long[]{0x0000000024010080L});
    public static final BitSet FOLLOW_pacote_in_stat88 = new BitSet(new long[]{0x0000000024010000L});
    public static final BitSet FOLLOW_sensor_in_stat92 = new BitSet(new long[]{0x0000000020010000L});
    public static final BitSet FOLLOW_main_in_stat97 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_plataforma115 = new BitSet(new long[]{0x0000004080400000L});
    public static final BitSet FOLLOW_nomeDaPlataforma_in_plataforma117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_nomeDaPlataforma130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_7_in_cabecalho174 = new BitSet(new long[]{0x0000000008200000L});
    public static final BitSet FOLLOW_21_in_cabecalho182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_cabecalho195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_pacote222 = new BitSet(new long[]{0x0000000240000000L});
    public static final BitSet FOLLOW_33_in_pacote226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_pacote241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_sensor269 = new BitSet(new long[]{0x0000000000801200L});
    public static final BitSet FOLLOW_tipoSensor_in_sensor271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_tipoSensor283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_9_in_tipoSensor295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_tipoSensor307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_main328 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_main330 = new BitSet(new long[]{0x000000801200C820L});
    public static final BitSet FOLLOW_loop_in_main342 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_main344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inicializacaoSensor_in_loop356 = new BitSet(new long[]{0x000000801200C820L});
    public static final BitSet FOLLOW_39_in_loop364 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_6_in_loop366 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_loop368 = new BitSet(new long[]{0x0000021C011EA500L});
    public static final BitSet FOLLOW_entrada_in_loop384 = new BitSet(new long[]{0x0000021C011EA500L});
    public static final BitSet FOLLOW_processamento_in_loop388 = new BitSet(new long[]{0x0000021C011EA500L});
    public static final BitSet FOLLOW_comportamento_in_loop392 = new BitSet(new long[]{0x0000021C011EA500L});
    public static final BitSet FOLLOW_acao_in_loop396 = new BitSet(new long[]{0x0000021C011EA500L});
    public static final BitSet FOLLOW_41_in_loop401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WS_in_inicializacaoSensor420 = new BitSet(new long[]{0x000000001200C820L});
    public static final BitSet FOLLOW_25_in_inicializacaoSensor429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_inicializacaoSensor445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_inicializacaoSensor460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_inicializacaoSensor474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_inicializacaoSensor488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_entrada523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_entrada536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_entrada548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_entrada560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_entrada572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_processamento604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_processamento616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_andar_in_acao644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_comportamento658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_comportamento670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_comportamento682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_comportamento695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_8_in_andar725 = new BitSet(new long[]{0x0000000000000002L});

}