// $ANTLR 3.4 T.g 2011-11-23 03:43:47

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
    public static final int T__13=13;
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
    public String getGrammarFileName() { return "T.g"; }

    // $ANTLR start "T__7"
    public final void mT__7() throws RecognitionException {
        try {
            int _type = T__7;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // T.g:2:6: ( 'adicionar' )
            // T.g:2:8: 'adicionar'
            {
            match("adicionar"); 



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
            // T.g:3:6: ( 'bussola' )
            // T.g:3:8: 'bussola'
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
    // $ANTLR end "T__8"

    // $ANTLR start "T__9"
    public final void mT__9() throws RecognitionException {
        try {
            int _type = T__9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // T.g:4:6: ( 'criarSensor' )
            // T.g:4:8: 'criarSensor'
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
    // $ANTLR end "T__9"

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // T.g:5:7: ( 'defines' )
            // T.g:5:9: 'defines'
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
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // T.g:6:7: ( 'gps' )
            // T.g:6:9: 'gps'
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
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // T.g:7:7: ( 'includes' )
            // T.g:7:9: 'includes'
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
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // T.g:8:7: ( 'robo' )
            // T.g:8:9: 'robo'
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
    // $ANTLR end "T__13"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // T.g:41:3: ( ( 'a' .. 'z' )+ )
            // T.g:41:5: ( 'a' .. 'z' )+
            {
            // T.g:41:5: ( 'a' .. 'z' )+
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
            	    // T.g:
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
            // T.g:42:4: ( ( '0' .. '9' )+ )
            // T.g:42:5: ( '0' .. '9' )+
            {
            // T.g:42:5: ( '0' .. '9' )+
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
            	    // T.g:
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
            // T.g:43:4: ( ( ' ' | '\\t' | '\\n' | '\\r' ) )
            // T.g:43:5: ( ' ' | '\\t' | '\\n' | '\\r' )
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
        // T.g:1:8: ( T__7 | T__8 | T__9 | T__10 | T__11 | T__12 | T__13 | ID | INT | WS )
        int alt3=10;
        switch ( input.LA(1) ) {
        case 'a':
            {
            int LA3_1 = input.LA(2);

            if ( (LA3_1=='d') ) {
                int LA3_11 = input.LA(3);

                if ( (LA3_11=='i') ) {
                    int LA3_18 = input.LA(4);

                    if ( (LA3_18=='c') ) {
                        int LA3_25 = input.LA(5);

                        if ( (LA3_25=='i') ) {
                            int LA3_32 = input.LA(6);

                            if ( (LA3_32=='o') ) {
                                int LA3_38 = input.LA(7);

                                if ( (LA3_38=='n') ) {
                                    int LA3_43 = input.LA(8);

                                    if ( (LA3_43=='a') ) {
                                        int LA3_47 = input.LA(9);

                                        if ( (LA3_47=='r') ) {
                                            int LA3_51 = input.LA(10);

                                            if ( ((LA3_51 >= 'a' && LA3_51 <= 'z')) ) {
                                                alt3=8;
                                            }
                                            else {
                                                alt3=1;
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
            else {
                alt3=8;
            }
            }
            break;
        case 'b':
            {
            int LA3_2 = input.LA(2);

            if ( (LA3_2=='u') ) {
                int LA3_12 = input.LA(3);

                if ( (LA3_12=='s') ) {
                    int LA3_19 = input.LA(4);

                    if ( (LA3_19=='s') ) {
                        int LA3_26 = input.LA(5);

                        if ( (LA3_26=='o') ) {
                            int LA3_33 = input.LA(6);

                            if ( (LA3_33=='l') ) {
                                int LA3_39 = input.LA(7);

                                if ( (LA3_39=='a') ) {
                                    int LA3_44 = input.LA(8);

                                    if ( ((LA3_44 >= 'a' && LA3_44 <= 'z')) ) {
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
                int LA3_13 = input.LA(3);

                if ( (LA3_13=='i') ) {
                    int LA3_20 = input.LA(4);

                    if ( (LA3_20=='a') ) {
                        int LA3_27 = input.LA(5);

                        if ( (LA3_27=='r') ) {
                            int LA3_34 = input.LA(6);

                            if ( (LA3_34=='S') ) {
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
                int LA3_14 = input.LA(3);

                if ( (LA3_14=='f') ) {
                    int LA3_21 = input.LA(4);

                    if ( (LA3_21=='i') ) {
                        int LA3_28 = input.LA(5);

                        if ( (LA3_28=='n') ) {
                            int LA3_35 = input.LA(6);

                            if ( (LA3_35=='e') ) {
                                int LA3_41 = input.LA(7);

                                if ( (LA3_41=='s') ) {
                                    int LA3_45 = input.LA(8);

                                    if ( ((LA3_45 >= 'a' && LA3_45 <= 'z')) ) {
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
                int LA3_15 = input.LA(3);

                if ( (LA3_15=='s') ) {
                    int LA3_22 = input.LA(4);

                    if ( ((LA3_22 >= 'a' && LA3_22 <= 'z')) ) {
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
                int LA3_16 = input.LA(3);

                if ( (LA3_16=='c') ) {
                    int LA3_23 = input.LA(4);

                    if ( (LA3_23=='l') ) {
                        int LA3_30 = input.LA(5);

                        if ( (LA3_30=='u') ) {
                            int LA3_36 = input.LA(6);

                            if ( (LA3_36=='d') ) {
                                int LA3_42 = input.LA(7);

                                if ( (LA3_42=='e') ) {
                                    int LA3_46 = input.LA(8);

                                    if ( (LA3_46=='s') ) {
                                        int LA3_50 = input.LA(9);

                                        if ( ((LA3_50 >= 'a' && LA3_50 <= 'z')) ) {
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
                int LA3_17 = input.LA(3);

                if ( (LA3_17=='b') ) {
                    int LA3_24 = input.LA(4);

                    if ( (LA3_24=='o') ) {
                        int LA3_31 = input.LA(5);

                        if ( ((LA3_31 >= 'a' && LA3_31 <= 'z')) ) {
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
            alt3=9;
            }
            break;
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt3=10;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 3, 0, input);

            throw nvae;

        }

        switch (alt3) {
            case 1 :
                // T.g:1:10: T__7
                {
                mT__7(); 


                }
                break;
            case 2 :
                // T.g:1:15: T__8
                {
                mT__8(); 


                }
                break;
            case 3 :
                // T.g:1:20: T__9
                {
                mT__9(); 


                }
                break;
            case 4 :
                // T.g:1:25: T__10
                {
                mT__10(); 


                }
                break;
            case 5 :
                // T.g:1:31: T__11
                {
                mT__11(); 


                }
                break;
            case 6 :
                // T.g:1:37: T__12
                {
                mT__12(); 


                }
                break;
            case 7 :
                // T.g:1:43: T__13
                {
                mT__13(); 


                }
                break;
            case 8 :
                // T.g:1:49: ID
                {
                mID(); 


                }
                break;
            case 9 :
                // T.g:1:52: INT
                {
                mINT(); 


                }
                break;
            case 10 :
                // T.g:1:56: WS
                {
                mWS(); 


                }
                break;

        }

    }


 

}