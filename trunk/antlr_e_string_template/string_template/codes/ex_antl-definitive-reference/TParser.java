// $ANTLR 3.4 T.g 2011-09-16 17:44:24

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "INT", "WS", "';'", "'='"
    };

    public static final int EOF=-1;
    public static final int T__7=7;
    public static final int T__8=8;
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


    public static class s_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "s"
    // T.g:3:1: s : ID '=' INT ';' -> assign(x=$ID.texty=$INT.text);
    public final TParser.s_return s() throws RecognitionException {
        TParser.s_return retval = new TParser.s_return();
        retval.start = input.LT(1);


        Token ID1=null;
        Token INT2=null;

        try {
            // T.g:3:3: ( ID '=' INT ';' -> assign(x=$ID.texty=$INT.text))
            // T.g:3:5: ID '=' INT ';'
            {
            ID1=(Token)match(input,ID,FOLLOW_ID_in_s16); 

            match(input,8,FOLLOW_8_in_s18); 

            INT2=(Token)match(input,INT,FOLLOW_INT_in_s20); 

            match(input,7,FOLLOW_7_in_s22); 

            // TEMPLATE REWRITE
            // 3:20: -> assign(x=$ID.texty=$INT.text)
            {
                retval.st = templateLib.getInstanceOf("assign",new STAttrMap().put("x", (ID1!=null?ID1.getText():null)).put("y", (INT2!=null?INT2.getText():null)));
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
    // $ANTLR end "s"

    // Delegated rules


 

    public static final BitSet FOLLOW_ID_in_s16 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_s18 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_INT_in_s20 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_7_in_s22 = new BitSet(new long[]{0x0000000000000002L});

}