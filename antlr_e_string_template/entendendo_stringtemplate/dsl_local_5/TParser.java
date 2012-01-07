// $ANTLR 3.4 T.g 2011-11-23 03:43:46
import org.antlr.stringtemplate.*;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.stringtemplate.*;
import org.antlr.stringtemplate.language.*;
import java.util.HashMap;
@SuppressWarnings({"all", "warnings", "unchecked"})
public class TParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "INT", "WS", "'adicionar'", "'bussola'", "'criarSensor'", "'defines'", "'gps'", "'includes'", "'robo'"
    };

    public static final int EOF=-1;
    public static final int T__7=7;
    public static final int T__8=8;
    public static final int T__9=9;
    public static final int T__10=10;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int ID=4;
    public static final int INT=5;
    public static final int WS=6;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public TParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public TParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected StringTemplateGroup templateLib =
  new StringTemplateGroup("TParserTemplates", AngleBracketTemplateLexer.class);

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
    public String[] getTokenNames() { return TParser.tokenNames; }
    public String getGrammarFileName() { return "T.g"; }


    protected static class robo_scope {
        List cabList;
        List senList;
    }
    protected Stack robo_stack = new Stack();


    public static class robo_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "robo"
    // T.g:5:1: robo : ( declaration )+ -> classe(cab=$robo::cabListsen=$robo::senList);
    public final TParser.robo_return robo() throws RecognitionException {
        robo_stack.push(new robo_scope());
        TParser.robo_return retval = new TParser.robo_return();
        retval.start = input.LT(1);



        	((robo_scope)robo_stack.peek()).cabList = new ArrayList();
        	((robo_scope)robo_stack.peek()).senList = new ArrayList();

        try {
            // T.g:14:2: ( ( declaration )+ -> classe(cab=$robo::cabListsen=$robo::senList))
            // T.g:14:4: ( declaration )+
            {
            // T.g:14:4: ( declaration )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // T.g:14:4: declaration
            	    {
            	    pushFollow(FOLLOW_declaration_in_robo33);
            	    declaration();

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
            // 14:17: -> classe(cab=$robo::cabListsen=$robo::senList)
            {
                retval.st = templateLib.getInstanceOf("classe",new STAttrMap().put("cab", ((robo_scope)robo_stack.peek()).cabList).put("sen", ((robo_scope)robo_stack.peek()).senList));
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


    public static class declaration_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "declaration"
    // T.g:17:1: declaration : 'robo' nomeRobo= ID ( cabecalho )* ( sensor )* ;
    public final TParser.declaration_return declaration() throws RecognitionException {
        TParser.declaration_return retval = new TParser.declaration_return();
        retval.start = input.LT(1);


        Token nomeRobo=null;

        try {
            // T.g:17:13: ( 'robo' nomeRobo= ID ( cabecalho )* ( sensor )* )
            // T.g:17:15: 'robo' nomeRobo= ID ( cabecalho )* ( sensor )*
            {
            match(input,13,FOLLOW_13_in_declaration58); 

            nomeRobo=(Token)match(input,ID,FOLLOW_ID_in_declaration62); 

            // T.g:17:34: ( cabecalho )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==7) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // T.g:17:34: cabecalho
            	    {
            	    pushFollow(FOLLOW_cabecalho_in_declaration64);
            	    cabecalho();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            // T.g:17:45: ( sensor )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==9) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // T.g:17:45: sensor
            	    {
            	    pushFollow(FOLLOW_sensor_in_declaration67);
            	    sensor();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


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
    // $ANTLR end "declaration"


    public static class cabecalho_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "cabecalho"
    // T.g:20:1: cabecalho : 'adicionar' itensCabecalho= ( 'defines' -> define(| 'includes' -> include() ;
    public final TParser.cabecalho_return cabecalho() throws RecognitionException {
        TParser.cabecalho_return retval = new TParser.cabecalho_return();
        retval.start = input.LT(1);


        Token itensCabecalho=null;

        try {
            // T.g:20:10: ( 'adicionar' itensCabecalho= ( 'defines' -> define(| 'includes' -> include() )
            // T.g:21:2: 'adicionar' itensCabecalho= ( 'defines' -> define(| 'includes' -> include()
            {
            match(input,7,FOLLOW_7_in_cabecalho80); 

            // T.g:21:29: ( 'defines' -> define(| 'includes' -> include()
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==10) ) {
                alt4=1;
            }
            else if ( (LA4_0==12) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }
            switch (alt4) {
                case 1 :
                    // T.g:22:5: 'defines'
                    {
                    match(input,10,FOLLOW_10_in_cabecalho90); 

                    // TEMPLATE REWRITE
                    // 22:15: -> define(
                    {
                        retval.st = templateLib.getInstanceOf("define");
                    }



                    }
                    break;
                case 2 :
                    // T.g:22:29: 'includes'
                    {
                    match(input,12,FOLLOW_12_in_cabecalho100); 

                    // TEMPLATE REWRITE
                    // 22:40: -> include(
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


    public static class sensor_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "sensor"
    // T.g:26:1: sensor : 'criarSensor' tipoSensor ;
    public final TParser.sensor_return sensor() throws RecognitionException {
        TParser.sensor_return retval = new TParser.sensor_return();
        retval.start = input.LT(1);


        try {
            // T.g:26:7: ( 'criarSensor' tipoSensor )
            // T.g:27:2: 'criarSensor' tipoSensor
            {
            match(input,9,FOLLOW_9_in_sensor122); 

            pushFollow(FOLLOW_tipoSensor_in_sensor124);
            tipoSensor();

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
    // $ANTLR end "sensor"


    public static class tipoSensor_return extends ParserRuleReturnScope {
        public String value;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "tipoSensor"
    // T.g:30:1: tipoSensor returns [String value] : ( 'gps' -> gps(| 'bussola' -> bussola() ;
    public final TParser.tipoSensor_return tipoSensor() throws RecognitionException {
        TParser.tipoSensor_return retval = new TParser.tipoSensor_return();
        retval.start = input.LT(1);


        try {
            // T.g:30:34: ( ( 'gps' -> gps(| 'bussola' -> bussola() )
            // T.g:31:2: ( 'gps' -> gps(| 'bussola' -> bussola()
            {
            // T.g:31:2: ( 'gps' -> gps(| 'bussola' -> bussola()
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==11) ) {
                alt5=1;
            }
            else if ( (LA5_0==8) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }
            switch (alt5) {
                case 1 :
                    // T.g:31:3: 'gps'
                    {
                    match(input,11,FOLLOW_11_in_tipoSensor141); 

                    retval.value = "gps";

                    // TEMPLATE REWRITE
                    // 31:38: -> gps(
                    {
                        retval.st = templateLib.getInstanceOf("gps");
                    }



                    }
                    break;
                case 2 :
                    // T.g:32:4: 'bussola'
                    {
                    match(input,8,FOLLOW_8_in_tipoSensor154); 

                    retval.value = "bussola";

                    // TEMPLATE REWRITE
                    // 32:47: -> bussola(
                    {
                        retval.st = templateLib.getInstanceOf("bussola");
                    }



                    }
                    break;

            }


            ((robo_scope)robo_stack.peek()).senList.add(retval.st);

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

    // Delegated rules


 

    public static final BitSet FOLLOW_declaration_in_robo33 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_declaration58 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_declaration62 = new BitSet(new long[]{0x0000000000000282L});
    public static final BitSet FOLLOW_cabecalho_in_declaration64 = new BitSet(new long[]{0x0000000000000282L});
    public static final BitSet FOLLOW_sensor_in_declaration67 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_7_in_cabecalho80 = new BitSet(new long[]{0x0000000000001400L});
    public static final BitSet FOLLOW_10_in_cabecalho90 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_cabecalho100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_9_in_sensor122 = new BitSet(new long[]{0x0000000000000900L});
    public static final BitSet FOLLOW_tipoSensor_in_sensor124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_tipoSensor141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_8_in_tipoSensor154 = new BitSet(new long[]{0x0000000000000002L});

}