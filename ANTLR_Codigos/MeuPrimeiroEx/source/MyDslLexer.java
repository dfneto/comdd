// $ANTLR 3.0 source/MyDsl.g 2011-01-12 18:03:30

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class MyDslLexer extends Lexer {
    public static final int WS=5;
    public static final int T6=6;
    public static final int T7=7;
    public static final int T10=10;
    public static final int T11=11;
    public static final int T12=12;
    public static final int T8=8;
    public static final int T9=9;
    public static final int ID=4;
    public static final int Tokens=13;
    public static final int EOF=-1;
    public MyDslLexer() {;} 
    public MyDslLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "source/MyDsl.g"; }

    // $ANTLR start T6
    public final void mT6() throws RecognitionException {
        try {
            int _type = T6;
            // source/MyDsl.g:7:6: ( 'robo' )
            // source/MyDsl.g:7:6: 'robo'
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
            // source/MyDsl.g:8:6: ( 'Adicionar' )
            // source/MyDsl.g:8:6: 'Adicionar'
            {
            match("Adicionar"); 


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
            // source/MyDsl.g:9:6: ( 'defines' )
            // source/MyDsl.g:9:6: 'defines'
            {
            match("defines"); 


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
            // source/MyDsl.g:10:6: ( 'includes' )
            // source/MyDsl.g:10:6: 'includes'
            {
            match("includes"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T9

    // $ANTLR start T10
    public final void mT10() throws RecognitionException {
        try {
            int _type = T10;
            // source/MyDsl.g:11:7: ( 'criarSensor' )
            // source/MyDsl.g:11:7: 'criarSensor'
            {
            match("criarSensor"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T10

    // $ANTLR start T11
    public final void mT11() throws RecognitionException {
        try {
            int _type = T11;
            // source/MyDsl.g:12:7: ( 'gps' )
            // source/MyDsl.g:12:7: 'gps'
            {
            match("gps"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T11

    // $ANTLR start T12
    public final void mT12() throws RecognitionException {
        try {
            int _type = T12;
            // source/MyDsl.g:13:7: ( 'bussola' )
            // source/MyDsl.g:13:7: 'bussola'
            {
            match("bussola"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T12

    // $ANTLR start ID
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            // source/MyDsl.g:37:5: ( ( 'a' .. 'z' )+ )
            // source/MyDsl.g:37:5: ( 'a' .. 'z' )+
            {
            // source/MyDsl.g:37:5: ( 'a' .. 'z' )+
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
            	    // source/MyDsl.g:37:5: 'a' .. 'z'
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
            // source/MyDsl.g:38:5: ( ( ' ' | '\\n' | '\\r' )+ )
            // source/MyDsl.g:38:5: ( ' ' | '\\n' | '\\r' )+
            {
            // source/MyDsl.g:38:5: ( ' ' | '\\n' | '\\r' )+
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
            	    // source/MyDsl.g:
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
        // source/MyDsl.g:1:10: ( T6 | T7 | T8 | T9 | T10 | T11 | T12 | ID | WS )
        int alt3=9;
        switch ( input.LA(1) ) {
        case 'r':
            {
            int LA3_1 = input.LA(2);

            if ( (LA3_1=='o') ) {
                int LA3_10 = input.LA(3);

                if ( (LA3_10=='b') ) {
                    int LA3_16 = input.LA(4);

                    if ( (LA3_16=='o') ) {
                        int LA3_22 = input.LA(5);

                        if ( ((LA3_22>='a' && LA3_22<='z')) ) {
                            alt3=8;
                        }
                        else {
                            alt3=1;}
                    }
                    else {
                        alt3=8;}
                }
                else {
                    alt3=8;}
            }
            else {
                alt3=8;}
            }
            break;
        case 'A':
            {
            alt3=2;
            }
            break;
        case 'd':
            {
            int LA3_3 = input.LA(2);

            if ( (LA3_3=='e') ) {
                int LA3_11 = input.LA(3);

                if ( (LA3_11=='f') ) {
                    int LA3_17 = input.LA(4);

                    if ( (LA3_17=='i') ) {
                        int LA3_23 = input.LA(5);

                        if ( (LA3_23=='n') ) {
                            int LA3_29 = input.LA(6);

                            if ( (LA3_29=='e') ) {
                                int LA3_33 = input.LA(7);

                                if ( (LA3_33=='s') ) {
                                    int LA3_37 = input.LA(8);

                                    if ( ((LA3_37>='a' && LA3_37<='z')) ) {
                                        alt3=8;
                                    }
                                    else {
                                        alt3=3;}
                                }
                                else {
                                    alt3=8;}
                            }
                            else {
                                alt3=8;}
                        }
                        else {
                            alt3=8;}
                    }
                    else {
                        alt3=8;}
                }
                else {
                    alt3=8;}
            }
            else {
                alt3=8;}
            }
            break;
        case 'i':
            {
            int LA3_4 = input.LA(2);

            if ( (LA3_4=='n') ) {
                int LA3_12 = input.LA(3);

                if ( (LA3_12=='c') ) {
                    int LA3_18 = input.LA(4);

                    if ( (LA3_18=='l') ) {
                        int LA3_24 = input.LA(5);

                        if ( (LA3_24=='u') ) {
                            int LA3_30 = input.LA(6);

                            if ( (LA3_30=='d') ) {
                                int LA3_34 = input.LA(7);

                                if ( (LA3_34=='e') ) {
                                    int LA3_38 = input.LA(8);

                                    if ( (LA3_38=='s') ) {
                                        int LA3_41 = input.LA(9);

                                        if ( ((LA3_41>='a' && LA3_41<='z')) ) {
                                            alt3=8;
                                        }
                                        else {
                                            alt3=4;}
                                    }
                                    else {
                                        alt3=8;}
                                }
                                else {
                                    alt3=8;}
                            }
                            else {
                                alt3=8;}
                        }
                        else {
                            alt3=8;}
                    }
                    else {
                        alt3=8;}
                }
                else {
                    alt3=8;}
            }
            else {
                alt3=8;}
            }
            break;
        case 'c':
            {
            int LA3_5 = input.LA(2);

            if ( (LA3_5=='r') ) {
                int LA3_13 = input.LA(3);

                if ( (LA3_13=='i') ) {
                    int LA3_19 = input.LA(4);

                    if ( (LA3_19=='a') ) {
                        int LA3_25 = input.LA(5);

                        if ( (LA3_25=='r') ) {
                            int LA3_31 = input.LA(6);

                            if ( (LA3_31=='S') ) {
                                alt3=5;
                            }
                            else {
                                alt3=8;}
                        }
                        else {
                            alt3=8;}
                    }
                    else {
                        alt3=8;}
                }
                else {
                    alt3=8;}
            }
            else {
                alt3=8;}
            }
            break;
        case 'g':
            {
            int LA3_6 = input.LA(2);

            if ( (LA3_6=='p') ) {
                int LA3_14 = input.LA(3);

                if ( (LA3_14=='s') ) {
                    int LA3_20 = input.LA(4);

                    if ( ((LA3_20>='a' && LA3_20<='z')) ) {
                        alt3=8;
                    }
                    else {
                        alt3=6;}
                }
                else {
                    alt3=8;}
            }
            else {
                alt3=8;}
            }
            break;
        case 'b':
            {
            int LA3_7 = input.LA(2);

            if ( (LA3_7=='u') ) {
                int LA3_15 = input.LA(3);

                if ( (LA3_15=='s') ) {
                    int LA3_21 = input.LA(4);

                    if ( (LA3_21=='s') ) {
                        int LA3_27 = input.LA(5);

                        if ( (LA3_27=='o') ) {
                            int LA3_32 = input.LA(6);

                            if ( (LA3_32=='l') ) {
                                int LA3_36 = input.LA(7);

                                if ( (LA3_36=='a') ) {
                                    int LA3_39 = input.LA(8);

                                    if ( ((LA3_39>='a' && LA3_39<='z')) ) {
                                        alt3=8;
                                    }
                                    else {
                                        alt3=7;}
                                }
                                else {
                                    alt3=8;}
                            }
                            else {
                                alt3=8;}
                        }
                        else {
                            alt3=8;}
                    }
                    else {
                        alt3=8;}
                }
                else {
                    alt3=8;}
            }
            else {
                alt3=8;}
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
                new NoViableAltException("1:1: Tokens : ( T6 | T7 | T8 | T9 | T10 | T11 | T12 | ID | WS );", 3, 0, input);

            throw nvae;
        }

        switch (alt3) {
            case 1 :
                // source/MyDsl.g:1:10: T6
                {
                mT6(); 

                }
                break;
            case 2 :
                // source/MyDsl.g:1:13: T7
                {
                mT7(); 

                }
                break;
            case 3 :
                // source/MyDsl.g:1:16: T8
                {
                mT8(); 

                }
                break;
            case 4 :
                // source/MyDsl.g:1:19: T9
                {
                mT9(); 

                }
                break;
            case 5 :
                // source/MyDsl.g:1:22: T10
                {
                mT10(); 

                }
                break;
            case 6 :
                // source/MyDsl.g:1:26: T11
                {
                mT11(); 

                }
                break;
            case 7 :
                // source/MyDsl.g:1:30: T12
                {
                mT12(); 

                }
                break;
            case 8 :
                // source/MyDsl.g:1:34: ID
                {
                mID(); 

                }
                break;
            case 9 :
                // source/MyDsl.g:1:37: WS
                {
                mWS(); 

                }
                break;

        }

    }


 

}