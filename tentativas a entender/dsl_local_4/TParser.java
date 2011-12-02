// $ANTLR 3.4 T.g 2011-12-01 11:25:44
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "INT", "WS", "';'", "'char'", "'int'"
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
    // T.g:5:1: robo : ( stat )+ ;
    public final TParser.robo_return robo() throws RecognitionException {
        TParser.robo_return retval = new TParser.robo_return();
        retval.start = input.LT(1);


        try {
            // T.g:5:6: ( ( stat )+ )
            // T.g:5:8: ( stat )+
            {
            // T.g:5:8: ( stat )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= 8 && LA1_0 <= 9)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // T.g:5:8: stat
            	    {
            	    pushFollow(FOLLOW_stat_in_robo22);
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
    // T.g:7:1: stat : ( variable | function );
    public final TParser.stat_return stat() throws RecognitionException {
        TParser.stat_return retval = new TParser.stat_return();
        retval.start = input.LT(1);


        try {
            // T.g:7:7: ( variable | function )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==9) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==ID) ) {
                    int LA2_3 = input.LA(3);

                    if ( (LA2_3==7) ) {
                        alt2=1;
                    }
                    else if ( (LA2_3==EOF||(LA2_3 >= 8 && LA2_3 <= 9)) ) {
                        alt2=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 3, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA2_0==8) ) {
                int LA2_2 = input.LA(2);

                if ( (LA2_2==ID) ) {
                    int LA2_3 = input.LA(3);

                    if ( (LA2_3==7) ) {
                        alt2=1;
                    }
                    else if ( (LA2_3==EOF||(LA2_3 >= 8 && LA2_3 <= 9)) ) {
                        alt2=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 3, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 2, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // T.g:7:9: variable
                    {
                    pushFollow(FOLLOW_variable_in_stat32);
                    variable();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // T.g:7:21: function
                    {
                    pushFollow(FOLLOW_function_in_stat37);
                    function();

                    state._fsp--;


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
    // $ANTLR end "stat"


    public static class variable_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "variable"
    // T.g:10:1: variable : type declarator ';' -> robo2(type=$type.stname=$declarator.st);
    public final TParser.variable_return variable() throws RecognitionException {
        TParser.variable_return retval = new TParser.variable_return();
        retval.start = input.LT(1);


        TParser.type_return type1 =null;

        TParser.declarator_return declarator2 =null;


        try {
            // T.g:10:10: ( type declarator ';' -> robo2(type=$type.stname=$declarator.st))
            // T.g:10:12: type declarator ';'
            {
            pushFollow(FOLLOW_type_in_variable46);
            type1=type();

            state._fsp--;


            pushFollow(FOLLOW_declarator_in_variable48);
            declarator2=declarator();

            state._fsp--;


            match(input,7,FOLLOW_7_in_variable50); 

            // TEMPLATE REWRITE
            // 10:32: -> robo2(type=$type.stname=$declarator.st)
            {
                retval.st = templateLib.getInstanceOf("robo2",new STAttrMap().put("type", (type1!=null?type1.st:null)).put("name", (declarator2!=null?declarator2.st:null)));
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
    // $ANTLR end "variable"


    public static class function_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "function"
    // T.g:12:1: function : type ID ;
    public final TParser.function_return function() throws RecognitionException {
        TParser.function_return retval = new TParser.function_return();
        retval.start = input.LT(1);


        try {
            // T.g:12:10: ( type ID )
            // T.g:12:12: type ID
            {
            pushFollow(FOLLOW_type_in_function72);
            type();

            state._fsp--;


            match(input,ID,FOLLOW_ID_in_function74); 

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
    // $ANTLR end "function"


    public static class declarator_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "declarator"
    // T.g:14:1: declarator : ID ;
    public final TParser.declarator_return declarator() throws RecognitionException {
        TParser.declarator_return retval = new TParser.declarator_return();
        retval.start = input.LT(1);


        try {
            // T.g:14:12: ( ID )
            // T.g:14:14: ID
            {
            match(input,ID,FOLLOW_ID_in_declarator82); 

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
    // $ANTLR end "declarator"


    public static class type_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "type"
    // T.g:16:1: type : ( 'int' -> type_int(| 'char' -> type_char();
    public final TParser.type_return type() throws RecognitionException {
        TParser.type_return retval = new TParser.type_return();
        retval.start = input.LT(1);


        try {
            // T.g:16:6: ( 'int' -> type_int(| 'char' -> type_char()
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==9) ) {
                alt3=1;
            }
            else if ( (LA3_0==8) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // T.g:16:8: 'int'
                    {
                    match(input,9,FOLLOW_9_in_type90); 

                    // TEMPLATE REWRITE
                    // 16:14: -> type_int(
                    {
                        retval.st = templateLib.getInstanceOf("type_int");
                    }



                    }
                    break;
                case 2 :
                    // T.g:17:4: 'char'
                    {
                    match(input,8,FOLLOW_8_in_type101); 

                    // TEMPLATE REWRITE
                    // 17:11: -> type_char(
                    {
                        retval.st = templateLib.getInstanceOf("type_char");
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
    // $ANTLR end "type"

    // Delegated rules


 

    public static final BitSet FOLLOW_stat_in_robo22 = new BitSet(new long[]{0x0000000000000302L});
    public static final BitSet FOLLOW_variable_in_stat32 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_stat37 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_variable46 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_declarator_in_variable48 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_7_in_variable50 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_function72 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_function74 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_declarator82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_9_in_type90 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_8_in_type101 = new BitSet(new long[]{0x0000000000000002L});

}