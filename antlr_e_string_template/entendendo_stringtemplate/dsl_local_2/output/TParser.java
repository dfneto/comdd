// $ANTLR 3.4 /home/david/Desktop/tentativas a entender/dsl_local_2/T.g 2011-11-22 17:36:19

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;
@SuppressWarnings({"all", "warnings", "unchecked"})
public class TParser extends DebugParser {
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


public static final String[] ruleNames = new String[] {
    "invalidRule", "expr", "robo", "s", "atom", "condExpr", "assignStat", 
    "aexpr"
};

public static final boolean[] decisionCanBacktrack = new boolean[] {
    false, // invalid decision
    false, false, false
};

 
    public int ruleLevel = 0;
    public int getRuleLevel() { return ruleLevel; }
    public void incRuleLevel() { ruleLevel++; }
    public void decRuleLevel() { ruleLevel--; }
    public TParser(TokenStream input) {
        this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
    }
    public TParser(TokenStream input, int port, RecognizerSharedState state) {
        super(input, state);
        DebugEventSocketProxy proxy =
            new DebugEventSocketProxy(this, port, null);

        setDebugListener(proxy);
        try {
            proxy.handshake();
        }
        catch (IOException ioe) {
            reportError(ioe);
        }
    }

public TParser(TokenStream input, DebugEventListener dbg) {
    super(input, dbg, new RecognizerSharedState());
}

protected boolean evalPredicate(boolean result, String predicate) {
    dbg.semanticPredicate(result, predicate);
    return result;
}

    public String[] getTokenNames() { return TParser.tokenNames; }
    public String getGrammarFileName() { return "/home/david/Desktop/tentativas a entender/dsl_local_2/T.g"; }



    // $ANTLR start "robo"
    // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:4:1: robo : ( s )+ ;
    public final void robo() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "robo");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(4, 0);

        try {
            // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:4:5: ( ( s )+ )
            dbg.enterAlt(1);

            // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:4:8: ( s )+
            {
            dbg.location(4,8);
            // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:4:8: ( s )+
            int cnt1=0;
            try { dbg.enterSubRule(1);

            loop1:
            do {
                int alt1=2;
                try { dbg.enterDecision(1, decisionCanBacktrack[1]);

                int LA1_0 = input.LA(1);

                if ( (LA1_0==ID) ) {
                    alt1=1;
                }


                } finally {dbg.exitDecision(1);}

                switch (alt1) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:4:8: s
            	    {
            	    dbg.location(4,8);
            	    pushFollow(FOLLOW_s_in_robo11);
            	    s();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        dbg.recognitionException(eee);

                        throw eee;
                }
                cnt1++;
            } while (true);
            } finally {dbg.exitSubRule(1);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(4, 9);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "robo");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "robo"



    // $ANTLR start "s"
    // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:8:1: s : assignStat ;
    public final void s() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "s");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(8, 0);

        try {
            // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:8:3: ( assignStat )
            dbg.enterAlt(1);

            // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:8:5: assignStat
            {
            dbg.location(8,5);
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
        dbg.location(8, 14);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "s");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "s"



    // $ANTLR start "assignStat"
    // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:9:1: assignStat : ID '=' expr ;
    public final void assignStat() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "assignStat");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(9, 0);

        try {
            // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:10:5: ( ID '=' expr )
            dbg.enterAlt(1);

            // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:10:9: ID '=' expr
            {
            dbg.location(10,9);
            match(input,ID,FOLLOW_ID_in_assignStat35); 
            dbg.location(10,12);
            match(input,11,FOLLOW_11_in_assignStat37); 
            dbg.location(10,16);
            pushFollow(FOLLOW_expr_in_assignStat39);
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
        dbg.location(11, 4);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "assignStat");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "assignStat"



    // $ANTLR start "expr"
    // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:13:1: expr : condExpr ;
    public final void expr() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "expr");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(13, 0);

        try {
            // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:13:5: ( condExpr )
            dbg.enterAlt(1);

            // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:13:9: condExpr
            {
            dbg.location(13,9);
            pushFollow(FOLLOW_condExpr_in_expr55);
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
        dbg.location(14, 4);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "expr");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "expr"



    // $ANTLR start "condExpr"
    // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:16:1: condExpr : a= aexpr ( ( '==' b= aexpr | '<' b= aexpr ) ) ;
    public final void condExpr() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "condExpr");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(16, 0);

        try {
            // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:17:5: (a= aexpr ( ( '==' b= aexpr | '<' b= aexpr ) ) )
            dbg.enterAlt(1);

            // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:17:9: a= aexpr ( ( '==' b= aexpr | '<' b= aexpr ) )
            {
            dbg.location(17,10);
            pushFollow(FOLLOW_aexpr_in_condExpr77);
            aexpr();

            state._fsp--;

            dbg.location(18,9);
            // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:18:9: ( ( '==' b= aexpr | '<' b= aexpr ) )
            dbg.enterAlt(1);

            // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:18:13: ( '==' b= aexpr | '<' b= aexpr )
            {
            dbg.location(18,13);
            // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:18:13: ( '==' b= aexpr | '<' b= aexpr )
            int alt2=2;
            try { dbg.enterSubRule(2);
            try { dbg.enterDecision(2, decisionCanBacktrack[2]);

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

                dbg.recognitionException(nvae);
                throw nvae;

            }
            } finally {dbg.exitDecision(2);}

            switch (alt2) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:18:16: '==' b= aexpr
                    {
                    dbg.location(18,16);
                    match(input,12,FOLLOW_12_in_condExpr94); 
                    dbg.location(18,22);
                    pushFollow(FOLLOW_aexpr_in_condExpr98);
                    aexpr();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:19:16: '<' b= aexpr
                    {
                    dbg.location(19,16);
                    match(input,10,FOLLOW_10_in_condExpr116); 
                    dbg.location(19,21);
                    pushFollow(FOLLOW_aexpr_in_condExpr120);
                    aexpr();

                    state._fsp--;


                    }
                    break;

            }
            } finally {dbg.exitSubRule(2);}


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
        dbg.location(23, 4);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "condExpr");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "condExpr"



    // $ANTLR start "aexpr"
    // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:25:1: aexpr : (a= atom ) ( '+' b= atom ) ;
    public final void aexpr() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "aexpr");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(25, 0);

        try {
            // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:26:5: ( (a= atom ) ( '+' b= atom ) )
            dbg.enterAlt(1);

            // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:26:9: (a= atom ) ( '+' b= atom )
            {
            dbg.location(26,9);
            // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:26:9: (a= atom )
            dbg.enterAlt(1);

            // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:26:10: a= atom
            {
            dbg.location(26,11);
            pushFollow(FOLLOW_atom_in_aexpr177);
            atom();

            state._fsp--;


            }

            dbg.location(27,9);
            // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:27:9: ( '+' b= atom )
            dbg.enterAlt(1);

            // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:27:11: '+' b= atom
            {
            dbg.location(27,11);
            match(input,9,FOLLOW_9_in_aexpr191); 
            dbg.location(27,16);
            pushFollow(FOLLOW_atom_in_aexpr195);
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
        dbg.location(28, 4);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "aexpr");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "aexpr"



    // $ANTLR start "atom"
    // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:30:1: atom : ( ID | INT | '(' expr ')' );
    public final void atom() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "atom");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(30, 0);

        try {
            // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:31:5: ( ID | INT | '(' expr ')' )
            int alt3=3;
            try { dbg.enterDecision(3, decisionCanBacktrack[3]);

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

                dbg.recognitionException(nvae);
                throw nvae;

            }

            } finally {dbg.exitDecision(3);}

            switch (alt3) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:31:7: ID
                    {
                    dbg.location(31,7);
                    match(input,ID,FOLLOW_ID_in_atom214); 

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:32:7: INT
                    {
                    dbg.location(32,7);
                    match(input,INT,FOLLOW_INT_in_atom223); 

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:33:7: '(' expr ')'
                    {
                    dbg.location(33,7);
                    match(input,7,FOLLOW_7_in_atom232); 
                    dbg.location(33,11);
                    pushFollow(FOLLOW_expr_in_atom234);
                    expr();

                    state._fsp--;

                    dbg.location(33,16);
                    match(input,8,FOLLOW_8_in_atom236); 

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
        dbg.location(34, 4);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "atom");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "atom"

    // Delegated rules


 

    public static final BitSet FOLLOW_s_in_robo11 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_assignStat_in_s22 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_assignStat35 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_assignStat37 = new BitSet(new long[]{0x00000000000000B0L});
    public static final BitSet FOLLOW_expr_in_assignStat39 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_condExpr_in_expr55 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_aexpr_in_condExpr77 = new BitSet(new long[]{0x0000000000001400L});
    public static final BitSet FOLLOW_12_in_condExpr94 = new BitSet(new long[]{0x00000000000000B0L});
    public static final BitSet FOLLOW_aexpr_in_condExpr98 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_condExpr116 = new BitSet(new long[]{0x00000000000000B0L});
    public static final BitSet FOLLOW_aexpr_in_condExpr120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_aexpr177 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_aexpr191 = new BitSet(new long[]{0x00000000000000B0L});
    public static final BitSet FOLLOW_atom_in_aexpr195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_atom214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_atom223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_7_in_atom232 = new BitSet(new long[]{0x00000000000000B0L});
    public static final BitSet FOLLOW_expr_in_atom234 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_atom236 = new BitSet(new long[]{0x0000000000000002L});

}