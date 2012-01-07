// $ANTLR 3.4 T.g 2011-11-21 19:42:44

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "INT", "WS", "'define'", "'include'", "'robo'"
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
    // T.g:9:1: robo : ( declaration )+ ;
    public final TParser.robo_return robo() throws RecognitionException {
        TParser.robo_return retval = new TParser.robo_return();
        retval.start = input.LT(1);


        try {
            // T.g:9:5: ( ( declaration )+ )
            // T.g:9:7: ( declaration )+
            {
            // T.g:9:7: ( declaration )+
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
            	    // T.g:9:7: declaration
            	    {
            	    pushFollow(FOLLOW_declaration_in_robo23);
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


    public static class declaration_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "declaration"
    // T.g:11:1: declaration : 'robo' cabecalho ;
    public final TParser.declaration_return declaration() throws RecognitionException {
        TParser.declaration_return retval = new TParser.declaration_return();
        retval.start = input.LT(1);


        try {
            // T.g:11:12: ( 'robo' cabecalho )
            // T.g:12:2: 'robo' cabecalho
            {
            match(input,9,FOLLOW_9_in_declaration32); 

            pushFollow(FOLLOW_cabecalho_in_declaration34);
            cabecalho();

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
    // $ANTLR end "declaration"


    public static class cabecalho_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "cabecalho"
    // T.g:15:1: cabecalho : ( 'define' | 'include' );
    public final TParser.cabecalho_return cabecalho() throws RecognitionException {
        TParser.cabecalho_return retval = new TParser.cabecalho_return();
        retval.start = input.LT(1);


        try {
            // T.g:15:10: ( 'define' | 'include' )
            // T.g:
            {
            if ( (input.LA(1) >= 7 && input.LA(1) <= 8) ) {
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
    // $ANTLR end "cabecalho"

    // Delegated rules


 

    public static final BitSet FOLLOW_declaration_in_robo23 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_9_in_declaration32 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_cabecalho_in_declaration34 = new BitSet(new long[]{0x0000000000000002L});

}