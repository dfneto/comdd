// $ANTLR 3.4 T.g 2011-11-22 23:51:00

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class TParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "INT", "WS", "'('", "')'", "'+'", "'<'", "'='", "'=='"
    };

    public static final int EOF=-1;
    public static final int T__7=7;
    public static final int T__8=8;
    public static final int T__9=9;
    public static final int T__10=10;
    public static final int T__11=11;
    public static final int T__12=12;
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

    public String[] getTokenNames() { return TParser.tokenNames; }
    public String getGrammarFileName() { return "T.g"; }



    // $ANTLR start "robo"
    // T.g:4:1: robo : ( s )+ ;
    public final void robo() throws RecognitionException {
        try {
            // T.g:4:5: ( ( s )+ )
            // T.g:4:8: ( s )+
            {
            // T.g:4:8: ( s )+
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
            	    // T.g:4:8: s
            	    {
            	    pushFollow(FOLLOW_s_in_robo11);
            	    s();

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
    // $ANTLR end "robo"



    // $ANTLR start "s"
    // T.g:8:1: s : assignStat ;
    public final void s() throws RecognitionException {
        try {
            // T.g:8:3: ( assignStat )
            // T.g:8:5: assignStat
            {
            pushFollow(FOLLOW_assignStat_in_s22);
            assignStat();

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
    // $ANTLR end "s"



    // $ANTLR start "assignStat"
    // T.g:10:1: assignStat : ID '=' expr ;
    public final void assignStat() throws RecognitionException {
        try {
            // T.g:11:5: ( ID '=' expr )
            // T.g:11:9: ID '=' expr
            {
            match(input,ID,FOLLOW_ID_in_assignStat36); 

            match(input,11,FOLLOW_11_in_assignStat38); 

            pushFollow(FOLLOW_expr_in_assignStat40);
            expr();

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
    // $ANTLR end "assignStat"



    // $ANTLR start "expr"
    // T.g:14:1: expr : condExpr ;
    public final void expr() throws RecognitionException {
        try {
            // T.g:14:5: ( condExpr )
            // T.g:14:9: condExpr
            {
            pushFollow(FOLLOW_condExpr_in_expr56);
            condExpr();

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
    // $ANTLR end "expr"



    // $ANTLR start "condExpr"
    // T.g:17:1: condExpr : a= aexpr ( ( '==' b= aexpr | '<' b= aexpr ) ) ;
    public final void condExpr() throws RecognitionException {
        try {
            // T.g:18:5: (a= aexpr ( ( '==' b= aexpr | '<' b= aexpr ) ) )
            // T.g:18:9: a= aexpr ( ( '==' b= aexpr | '<' b= aexpr ) )
            {
            pushFollow(FOLLOW_aexpr_in_condExpr78);
            aexpr();

            state._fsp--;


            // T.g:19:9: ( ( '==' b= aexpr | '<' b= aexpr ) )
            // T.g:19:13: ( '==' b= aexpr | '<' b= aexpr )
            {
            // T.g:19:13: ( '==' b= aexpr | '<' b= aexpr )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            else if ( (LA2_0==10) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // T.g:19:16: '==' b= aexpr
                    {
                    match(input,12,FOLLOW_12_in_condExpr95); 

                    pushFollow(FOLLOW_aexpr_in_condExpr99);
                    aexpr();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // T.g:20:16: '<' b= aexpr
                    {
                    match(input,10,FOLLOW_10_in_condExpr117); 

                    pushFollow(FOLLOW_aexpr_in_condExpr121);
                    aexpr();

                    state._fsp--;


                    }
                    break;

            }


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
    // $ANTLR end "condExpr"



    // $ANTLR start "aexpr"
    // T.g:26:1: aexpr : (a= atom ) ( '+' b= atom ) ;
    public final void aexpr() throws RecognitionException {
        try {
            // T.g:27:5: ( (a= atom ) ( '+' b= atom ) )
            // T.g:27:9: (a= atom ) ( '+' b= atom )
            {
            // T.g:27:9: (a= atom )
            // T.g:27:10: a= atom
            {
            pushFollow(FOLLOW_atom_in_aexpr178);
            atom();

            state._fsp--;


            }


            // T.g:28:9: ( '+' b= atom )
            // T.g:28:11: '+' b= atom
            {
            match(input,9,FOLLOW_9_in_aexpr192); 

            pushFollow(FOLLOW_atom_in_aexpr196);
            atom();

            state._fsp--;


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
    // $ANTLR end "aexpr"



    // $ANTLR start "atom"
    // T.g:31:1: atom : ( ID | INT | '(' expr ')' );
    public final void atom() throws RecognitionException {
        try {
            // T.g:32:5: ( ID | INT | '(' expr ')' )
            int alt3=3;
            switch ( input.LA(1) ) {
            case ID:
                {
                alt3=1;
                }
                break;
            case INT:
                {
                alt3=2;
                }
                break;
            case 7:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }

            switch (alt3) {
                case 1 :
                    // T.g:32:7: ID
                    {
                    match(input,ID,FOLLOW_ID_in_atom215); 

                    }
                    break;
                case 2 :
                    // T.g:33:7: INT
                    {
                    match(input,INT,FOLLOW_INT_in_atom224); 

                    }
                    break;
                case 3 :
                    // T.g:34:7: '(' expr ')'
                    {
                    match(input,7,FOLLOW_7_in_atom233); 

                    pushFollow(FOLLOW_expr_in_atom235);
                    expr();

                    state._fsp--;


                    match(input,8,FOLLOW_8_in_atom237); 

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
    // $ANTLR end "atom"

    // Delegated rules


 

    public static final BitSet FOLLOW_s_in_robo11 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_assignStat_in_s22 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_assignStat36 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_assignStat38 = new BitSet(new long[]{0x00000000000000B0L});
    public static final BitSet FOLLOW_expr_in_assignStat40 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_condExpr_in_expr56 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_aexpr_in_condExpr78 = new BitSet(new long[]{0x0000000000001400L});
    public static final BitSet FOLLOW_12_in_condExpr95 = new BitSet(new long[]{0x00000000000000B0L});
    public static final BitSet FOLLOW_aexpr_in_condExpr99 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_condExpr117 = new BitSet(new long[]{0x00000000000000B0L});
    public static final BitSet FOLLOW_aexpr_in_condExpr121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_aexpr178 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_aexpr192 = new BitSet(new long[]{0x00000000000000B0L});
    public static final BitSet FOLLOW_atom_in_aexpr196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_atom215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_atom224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_7_in_atom233 = new BitSet(new long[]{0x00000000000000B0L});
    public static final BitSet FOLLOW_expr_in_atom235 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_atom237 = new BitSet(new long[]{0x0000000000000002L});

}