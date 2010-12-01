// $ANTLR 3.0 MyDsl.g 2010-12-01 10:41:56

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class MyDslLexer extends Lexer {
    public static final int WS=5;
    public static final int T6=6;
    public static final int T7=7;
    public static final int T8=8;
    public static final int T9=9;
    public static final int ID=4;
    public static final int Tokens=10;
    public static final int EOF=-1;
    public MyDslLexer() {;} 
    public MyDslLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "MyDsl.g"; }

    // $ANTLR start T6
    public final void mT6() throws RecognitionException {
        try {
            int _type = T6;
            // MyDsl.g:7:6: ( 'robo' )
            // MyDsl.g:7:6: 'robo'
            {
            match("robo"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T6

    // $ANTLR start T7
    public final void mT7() throws RecognitionException {
        try {
            int _type = T7;
            // MyDsl.g:8:6: ( 'criarSensor' )
            // MyDsl.g:8:6: 'criarSensor'
            {
            match("criarSensor"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T7

    // $ANTLR start T8
    public final void mT8() throws RecognitionException {
        try {
            int _type = T8;
            // MyDsl.g:9:6: ( 'gps' )
            // MyDsl.g:9:6: 'gps'
            {
            match("gps"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T8

    // $ANTLR start T9
    public final void mT9() throws RecognitionException {
        try {
            int _type = T9;
            // MyDsl.g:10:6: ( 'bussola' )
            // MyDsl.g:10:6: 'bussola'
            {
            match("bussola"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T9

    // $ANTLR start ID
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            // MyDsl.g:20:5: ( ( 'a' .. 'z' )+ )
            // MyDsl.g:20:5: ( 'a' .. 'z' )+
            {
            // MyDsl.g:20:5: ( 'a' .. 'z' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // MyDsl.g:20:5: 'a' .. 'z'
            	    {
            	    matchRange('a','z'); 

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

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ID

    // $ANTLR start WS
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            // MyDsl.g:21:5: ( ( ' ' | '\\n' | '\\r' )+ )
            // MyDsl.g:21:5: ( ' ' | '\\n' | '\\r' )+
            {
            // MyDsl.g:21:5: ( ' ' | '\\n' | '\\r' )+
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
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
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

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end WS

    public void mTokens() throws RecognitionException {
        // MyDsl.g:1:10: ( T6 | T7 | T8 | T9 | ID | WS )
        int alt3=6;
        switch ( input.LA(1) ) {
        case 'r':
            {
            int LA3_1 = input.LA(2);

            if ( (LA3_1=='o') ) {
                int LA3_7 = input.LA(3);

                if ( (LA3_7=='b') ) {
                    int LA3_11 = input.LA(4);

                    if ( (LA3_11=='o') ) {
                        int LA3_15 = input.LA(5);

                        if ( ((LA3_15>='a' && LA3_15<='z')) ) {
                            alt3=5;
                        }
                        else {
                            alt3=1;}
                    }
                    else {
                        alt3=5;}
                }
                else {
                    alt3=5;}
            }
            else {
                alt3=5;}
            }
            break;
        case 'c':
            {
            int LA3_2 = input.LA(2);

            if ( (LA3_2=='r') ) {
                int LA3_8 = input.LA(3);

                if ( (LA3_8=='i') ) {
                    int LA3_12 = input.LA(4);

                    if ( (LA3_12=='a') ) {
                        int LA3_16 = input.LA(5);

                        if ( (LA3_16=='r') ) {
                            int LA3_20 = input.LA(6);

                            if ( (LA3_20=='S') ) {
                                alt3=2;
                            }
                            else {
                                alt3=5;}
                        }
                        else {
                            alt3=5;}
                    }
                    else {
                        alt3=5;}
                }
                else {
                    alt3=5;}
            }
            else {
                alt3=5;}
            }
            break;
        case 'g':
            {
            int LA3_3 = input.LA(2);

            if ( (LA3_3=='p') ) {
                int LA3_9 = input.LA(3);

                if ( (LA3_9=='s') ) {
                    int LA3_13 = input.LA(4);

                    if ( ((LA3_13>='a' && LA3_13<='z')) ) {
                        alt3=5;
                    }
                    else {
                        alt3=3;}
                }
                else {
                    alt3=5;}
            }
            else {
                alt3=5;}
            }
            break;
        case 'b':
            {
            int LA3_4 = input.LA(2);

            if ( (LA3_4=='u') ) {
                int LA3_10 = input.LA(3);

                if ( (LA3_10=='s') ) {
                    int LA3_14 = input.LA(4);

                    if ( (LA3_14=='s') ) {
                        int LA3_18 = input.LA(5);

                        if ( (LA3_18=='o') ) {
                            int LA3_21 = input.LA(6);

                            if ( (LA3_21=='l') ) {
                                int LA3_23 = input.LA(7);

                                if ( (LA3_23=='a') ) {
                                    int LA3_24 = input.LA(8);

                                    if ( ((LA3_24>='a' && LA3_24<='z')) ) {
                                        alt3=5;
                                    }
                                    else {
                                        alt3=4;}
                                }
                                else {
                                    alt3=5;}
                            }
                            else {
                                alt3=5;}
                        }
                        else {
                            alt3=5;}
                    }
                    else {
                        alt3=5;}
                }
                else {
                    alt3=5;}
            }
            else {
                alt3=5;}
            }
            break;
        case 'a':
        case 'd':
        case 'e':
        case 'f':
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
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt3=5;
            }
            break;
        case '\n':
        case '\r':
        case ' ':
            {
            alt3=6;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T6 | T7 | T8 | T9 | ID | WS );", 3, 0, input);

            throw nvae;
        }

        switch (alt3) {
            case 1 :
                // MyDsl.g:1:10: T6
                {
                mT6(); 

                }
                break;
            case 2 :
                // MyDsl.g:1:13: T7
                {
                mT7(); 

                }
                break;
            case 3 :
                // MyDsl.g:1:16: T8
                {
                mT8(); 

                }
                break;
            case 4 :
                // MyDsl.g:1:19: T9
                {
                mT9(); 

                }
                break;
            case 5 :
                // MyDsl.g:1:22: ID
                {
                mID(); 

                }
                break;
            case 6 :
                // MyDsl.g:1:25: WS
                {
                mWS(); 

                }
                break;

        }

    }


 

}