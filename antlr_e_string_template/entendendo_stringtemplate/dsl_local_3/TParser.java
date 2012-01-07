// $ANTLR 3.4 T.g 2011-11-23 02:16:31
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "INT", "WS", "';'", "'='", "'mais '"
    };

    public static final int EOF=-1;
    public static final int T__7=7;
    public static final int T__8=8;
    public static final int T__9=9;
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


    public static class robo_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "robo"
    // T.g:5:1: robo : ( stat )+ regra -> cabecalho(entrada=$stat.stentrada1=$regra.st);
    public final TParser.robo_return robo() throws RecognitionException {
        TParser.robo_return retval = new TParser.robo_return();
        retval.start = input.LT(1);


        TParser.stat_return stat1 =null;

        TParser.regra_return regra2 =null;


        try {
            // T.g:5:6: ( ( stat )+ regra -> cabecalho(entrada=$stat.stentrada1=$regra.st))
            // T.g:5:8: ( stat )+ regra
            {
            // T.g:5:8: ( stat )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // T.g:5:8: stat
            	    {
            	    pushFollow(FOLLOW_stat_in_robo22);
            	    stat1=stat();

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


            pushFollow(FOLLOW_regra_in_robo25);
            regra2=regra();

            state._fsp--;


            // TEMPLATE REWRITE
            // 5:19: -> cabecalho(entrada=$stat.stentrada1=$regra.st)
            {
                retval.st = templateLib.getInstanceOf("cabecalho",new STAttrMap().put("entrada", (stat1!=null?stat1.st:null)).put("entrada1", (regra2!=null?regra2.st:null)));
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
    // $ANTLR end "robo"


    public static class stat_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "stat"
    // T.g:8:1: stat : dir= ID '=' vel= INT ';' -> robo4(;
    public final TParser.stat_return stat() throws RecognitionException {
        TParser.stat_return retval = new TParser.stat_return();
        retval.start = input.LT(1);


        Token dir=null;
        Token vel=null;

        try {
            // T.g:8:7: (dir= ID '=' vel= INT ';' -> robo4()
            // T.g:8:9: dir= ID '=' vel= INT ';'
            {
            dir=(Token)match(input,ID,FOLLOW_ID_in_stat51); 

            match(input,8,FOLLOW_8_in_stat53); 

            vel=(Token)match(input,INT,FOLLOW_INT_in_stat57); 

            match(input,7,FOLLOW_7_in_stat59); 

            // TEMPLATE REWRITE
            // 8:32: -> robo4(
            {
                retval.st = templateLib.getInstanceOf("robo4");
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
    // $ANTLR end "stat"


    public static class regra_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "regra"
    // T.g:15:1: regra : 'mais ' ang= INT -> robo3(angulo=$ang.textdirecao=3);
    public final TParser.regra_return regra() throws RecognitionException {
        TParser.regra_return retval = new TParser.regra_return();
        retval.start = input.LT(1);


        Token ang=null;

        try {
            // T.g:15:7: ( 'mais ' ang= INT -> robo3(angulo=$ang.textdirecao=3))
            // T.g:15:9: 'mais ' ang= INT
            {
            match(input,9,FOLLOW_9_in_regra79); 

            ang=(Token)match(input,INT,FOLLOW_INT_in_regra83); 

            // TEMPLATE REWRITE
            // 15:25: -> robo3(angulo=$ang.textdirecao=3)
            {
                retval.st = templateLib.getInstanceOf("robo3",new STAttrMap().put("angulo", (ang!=null?ang.getText():null)).put("direcao", 3));
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
    // $ANTLR end "regra"

    // Delegated rules


 

    public static final BitSet FOLLOW_stat_in_robo22 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_regra_in_robo25 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_stat51 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_stat53 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_INT_in_stat57 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_7_in_stat59 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_9_in_regra79 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_INT_in_regra83 = new BitSet(new long[]{0x0000000000000002L});

}