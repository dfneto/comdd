// $ANTLR 3.4 MyDsl.g 2011-11-22 21:28:42

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class MyDslLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__6=6;
    public static final int T__7=7;
    public static final int T__8=8;
    public static final int T__9=9;
    public static final int T__10=10;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int ID=4;
    public static final int WS=5;

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public MyDslLexer() {} 
    public MyDslLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public MyDslLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "MyDsl.g"; }

    // $ANTLR start "T__6"
    public final void mT__6() throws RecognitionException {
        try {
            int _type = T__6;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // MyDsl.g:7:6: ( 'Adicionar' )
            // MyDsl.g:7:8: 'Adicionar'
            {
            match("Adicionar"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__6"

    // $ANTLR start "T__7"
    public final void mT__7() throws RecognitionException {
        try {
            int _type = T__7;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // MyDsl.g:8:6: ( 'bussola' )
            // MyDsl.g:8:8: 'bussola'
            {
            match("bussola"); 



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
            // MyDsl.g:9:6: ( 'criarSensor' )
            // MyDsl.g:9:8: 'criarSensor'
            {
            match("criarSensor"); 



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
            // MyDsl.g:10:6: ( 'defines' )
            // MyDsl.g:10:8: 'defines'
            {
            match("defines"); 



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
            // MyDsl.g:11:7: ( 'gps' )
            // MyDsl.g:11:9: 'gps'
            {
            match("gps"); 



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
            // MyDsl.g:12:7: ( 'includes' )
            // MyDsl.g:12:9: 'includes'
            {
            match("includes"); 



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
            // MyDsl.g:13:7: ( 'robo' )
            // MyDsl.g:13:9: 'robo'
            {
            match("robo"); 



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
            // MyDsl.g:37:3: ( ( 'a' .. 'z' )+ )
            // MyDsl.g:37:5: ( 'a' .. 'z' )+
            {
            // MyDsl.g:37:5: ( 'a' .. 'z' )+
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
            	    // MyDsl.g:
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

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // MyDsl.g:38:3: ( ( ' ' | '\\n' | '\\r' )+ )
            // MyDsl.g:38:5: ( ' ' | '\\n' | '\\r' )+
            {
            // MyDsl.g:38:5: ( ' ' | '\\n' | '\\r' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='\n'||LA2_0=='\r'||LA2_0==' ') ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // MyDsl.g:
            	    {
            	    if ( input.LA(1)=='\n'||input.LA(1)=='\r'||input.LA(1)==' ' ) {
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
        // MyDsl.g:1:8: ( T__6 | T__7 | T__8 | T__9 | T__10 | T__11 | T__12 | ID | WS )
        int alt3=9;
        switch ( input.LA(1) ) {
        case 'A':
            {
            alt3=1;
            }
            break;
        case 'b':
            {
            int LA3_2 = input.LA(2);

            if ( (LA3_2=='u') ) {
                int LA3_10 = input.LA(3);

                if ( (LA3_10=='s') ) {
                    int LA3_16 = input.LA(4);

                    if ( (LA3_16=='s') ) {
                        int LA3_22 = input.LA(5);

                        if ( (LA3_22=='o') ) {
                            int LA3_28 = input.LA(6);

                            if ( (LA3_28=='l') ) {
                                int LA3_33 = input.LA(7);

                                if ( (LA3_33=='a') ) {
                                    int LA3_37 = input.LA(8);

                                    if ( ((LA3_37 >= 'a' && LA3_37 <= 'z')) ) {
                                        alt3=8;
                                    }
                                    else {
                                        alt3=2;
                                    }
                                }
                                else {
                                    alt3=8;
                                }
                            }
                            else {
                                alt3=8;
                            }
                        }
                        else {
                            alt3=8;
                        }
                    }
                    else {
                        alt3=8;
                    }
                }
                else {
                    alt3=8;
                }
            }
            else {
                alt3=8;
            }
            }
            break;
        case 'c':
            {
            int LA3_3 = input.LA(2);

            if ( (LA3_3=='r') ) {
                int LA3_11 = input.LA(3);

                if ( (LA3_11=='i') ) {
                    int LA3_17 = input.LA(4);

                    if ( (LA3_17=='a') ) {
                        int LA3_23 = input.LA(5);

                        if ( (LA3_23=='r') ) {
                            int LA3_29 = input.LA(6);

                            if ( (LA3_29=='S') ) {
                                alt3=3;
                            }
                            else {
                                alt3=8;
                            }
                        }
                        else {
                            alt3=8;
                        }
                    }
                    else {
                        alt3=8;
                    }
                }
                else {
                    alt3=8;
                }
            }
            else {
                alt3=8;
            }
            }
            break;
        case 'd':
            {
            int LA3_4 = input.LA(2);

            if ( (LA3_4=='e') ) {
                int LA3_12 = input.LA(3);

                if ( (LA3_12=='f') ) {
                    int LA3_18 = input.LA(4);

                    if ( (LA3_18=='i') ) {
                        int LA3_24 = input.LA(5);

                        if ( (LA3_24=='n') ) {
                            int LA3_30 = input.LA(6);

                            if ( (LA3_30=='e') ) {
                                int LA3_35 = input.LA(7);

                                if ( (LA3_35=='s') ) {
                                    int LA3_38 = input.LA(8);

                                    if ( ((LA3_38 >= 'a' && LA3_38 <= 'z')) ) {
                                        alt3=8;
                                    }
                                    else {
                                        alt3=4;
                                    }
                                }
                                else {
                                    alt3=8;
                                }
                            }
                            else {
                                alt3=8;
                            }
                        }
                        else {
                            alt3=8;
                        }
                    }
                    else {
                        alt3=8;
                    }
                }
                else {
                    alt3=8;
                }
            }
            else {
                alt3=8;
            }
            }
            break;
        case 'g':
            {
            int LA3_5 = input.LA(2);

            if ( (LA3_5=='p') ) {
                int LA3_13 = input.LA(3);

                if ( (LA3_13=='s') ) {
                    int LA3_19 = input.LA(4);

                    if ( ((LA3_19 >= 'a' && LA3_19 <= 'z')) ) {
                        alt3=8;
                    }
                    else {
                        alt3=5;
                    }
                }
                else {
                    alt3=8;
                }
            }
            else {
                alt3=8;
            }
            }
            break;
        case 'i':
            {
            int LA3_6 = input.LA(2);

            if ( (LA3_6=='n') ) {
                int LA3_14 = input.LA(3);

                if ( (LA3_14=='c') ) {
                    int LA3_20 = input.LA(4);

                    if ( (LA3_20=='l') ) {
                        int LA3_26 = input.LA(5);

                        if ( (LA3_26=='u') ) {
                            int LA3_31 = input.LA(6);

                            if ( (LA3_31=='d') ) {
                                int LA3_36 = input.LA(7);

                                if ( (LA3_36=='e') ) {
                                    int LA3_39 = input.LA(8);

                                    if ( (LA3_39=='s') ) {
                                        int LA3_42 = input.LA(9);

                                        if ( ((LA3_42 >= 'a' && LA3_42 <= 'z')) ) {
                                            alt3=8;
                                        }
                                        else {
                                            alt3=6;
                                        }
                                    }
                                    else {
                                        alt3=8;
                                    }
                                }
                                else {
                                    alt3=8;
                                }
                            }
                            else {
                                alt3=8;
                            }
                        }
                        else {
                            alt3=8;
                        }
                    }
                    else {
                        alt3=8;
                    }
                }
                else {
                    alt3=8;
                }
            }
            else {
                alt3=8;
            }
            }
            break;
        case 'r':
            {
            int LA3_7 = input.LA(2);

            if ( (LA3_7=='o') ) {
                int LA3_15 = input.LA(3);

                if ( (LA3_15=='b') ) {
                    int LA3_21 = input.LA(4);

                    if ( (LA3_21=='o') ) {
                        int LA3_27 = input.LA(5);

                        if ( ((LA3_27 >= 'a' && LA3_27 <= 'z')) ) {
                            alt3=8;
                        }
                        else {
                            alt3=7;
                        }
                    }
                    else {
                        alt3=8;
                    }
                }
                else {
                    alt3=8;
                }
            }
            else {
                alt3=8;
            }
            }
            break;
        case 'a':
        case 'e':
        case 'f':
        case 'h':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'o':
        case 'p':
        case 'q':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt3=8;
            }
            break;
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
                // MyDsl.g:1:10: T__6
                {
                mT__6(); 


                }
                break;
            case 2 :
                // MyDsl.g:1:15: T__7
                {
                mT__7(); 


                }
                break;
            case 3 :
                // MyDsl.g:1:20: T__8
                {
                mT__8(); 


                }
                break;
            case 4 :
                // MyDsl.g:1:25: T__9
                {
                mT__9(); 


                }
                break;
            case 5 :
                // MyDsl.g:1:30: T__10
                {
                mT__10(); 


                }
                break;
            case 6 :
                // MyDsl.g:1:36: T__11
                {
                mT__11(); 


                }
                break;
            case 7 :
                // MyDsl.g:1:42: T__12
                {
                mT__12(); 


                }
                break;
            case 8 :
                // MyDsl.g:1:48: ID
                {
                mID(); 


                }
                break;
            case 9 :
                // MyDsl.g:1:51: WS
                {
                mWS(); 


                }
                break;

        }

    }


 

}