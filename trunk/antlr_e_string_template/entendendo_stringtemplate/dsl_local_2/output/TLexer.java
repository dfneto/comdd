// $ANTLR 3.4 /home/david/Desktop/tentativas a entender/dsl_local_2/T.g 2011-11-22 17:36:19

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class TLexer extends Lexer {
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
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public TLexer() {} 
    public TLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public TLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "/home/david/Desktop/tentativas a entender/dsl_local_2/T.g"; }

    // $ANTLR start "T__7"
    public final void mT__7() throws RecognitionException {
        try {
            int _type = T__7;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:2:6: ( '(' )
            // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:2:8: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__7"

    // $ANTLR start "T__8"
    public final void mT__8() throws RecognitionException {
        try {
            int _type = T__8;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:3:6: ( ')' )
            // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:3:8: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__8"

    // $ANTLR start "T__9"
    public final void mT__9() throws RecognitionException {
        try {
            int _type = T__9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:4:6: ( '+' )
            // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:4:8: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__9"

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:5:7: ( '<' )
            // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:5:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:6:7: ( '=' )
            // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:6:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:7:7: ( '==' )
            // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:7:9: '=='
            {
            match("=="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:58:3: ( ( 'a' .. 'z' )+ )
            // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:58:5: ( 'a' .. 'z' )+
            {
            // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:58:5: ( 'a' .. 'z' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:
            	    {
            	    if ( (input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:59:4: ( ( '0' .. '9' )+ )
            // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:59:5: ( '0' .. '9' )+
            {
            // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:59:5: ( '0' .. '9' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:60:4: ( ( ' ' | '\\t' | '\\n' | '\\r' ) )
            // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:60:5: ( ' ' | '\\t' | '\\n' | '\\r' )
            {
            if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            skip();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:1:8: ( T__7 | T__8 | T__9 | T__10 | T__11 | T__12 | ID | INT | WS )
        int alt3=9;
        switch ( input.LA(1) ) {
        case '(':
            {
            alt3=1;
            }
            break;
        case ')':
            {
            alt3=2;
            }
            break;
        case '+':
            {
            alt3=3;
            }
            break;
        case '<':
            {
            alt3=4;
            }
            break;
        case '=':
            {
            int LA3_5 = input.LA(2);

            if ( (LA3_5=='=') ) {
                alt3=6;
            }
            else {
                alt3=5;
            }
            }
            break;
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'f':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'o':
        case 'p':
        case 'q':
        case 'r':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt3=7;
            }
            break;
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
            {
            alt3=8;
            }
            break;
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt3=9;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 3, 0, input);

            throw nvae;

        }

        switch (alt3) {
            case 1 :
                // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:1:10: T__7
                {
                mT__7(); 


                }
                break;
            case 2 :
                // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:1:15: T__8
                {
                mT__8(); 


                }
                break;
            case 3 :
                // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:1:20: T__9
                {
                mT__9(); 


                }
                break;
            case 4 :
                // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:1:25: T__10
                {
                mT__10(); 


                }
                break;
            case 5 :
                // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:1:31: T__11
                {
                mT__11(); 


                }
                break;
            case 6 :
                // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:1:37: T__12
                {
                mT__12(); 


                }
                break;
            case 7 :
                // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:1:43: ID
                {
                mID(); 


                }
                break;
            case 8 :
                // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:1:46: INT
                {
                mINT(); 


                }
                break;
            case 9 :
                // /home/david/Desktop/tentativas a entender/dsl_local_2/T.g:1:50: WS
                {
                mWS(); 


                }
                break;

        }

    }


 

}