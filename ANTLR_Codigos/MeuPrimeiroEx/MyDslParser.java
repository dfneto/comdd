// $ANTLR 3.0 MyDsl.g 2010-12-01 10:41:55

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class MyDslParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "WS", "'robo'", "'criarSensor'", "'gps'", "'bussola'"
    };
    public static final int WS=5;
    public static final int ID=4;
    public static final int EOF=-1;

        public MyDslParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "MyDsl.g"; }


    String s;



    // $ANTLR start prog
    // MyDsl.g:10:1: prog : ( stat )+ ;
    public final void prog() throws RecognitionException {
        try {
            // MyDsl.g:10:7: ( ( stat )+ )
            // MyDsl.g:10:7: ( stat )+
            {
            // MyDsl.g:10:7: ( stat )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==6) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // MyDsl.g:10:7: stat
            	    {
            	    pushFollow(FOLLOW_stat_in_prog24);
            	    stat();
            	    _fsp--;


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
        }
        return ;
    }
    // $ANTLR end prog


    // $ANTLR start stat
    // MyDsl.g:12:1: stat : 'robo' sensor ;
    public final void stat() throws RecognitionException {
        try {
            // MyDsl.g:12:7: ( 'robo' sensor )
            // MyDsl.g:12:7: 'robo' sensor
            {
            match(input,6,FOLLOW_6_in_stat32); 
            pushFollow(FOLLOW_sensor_in_stat34);
            sensor();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end stat


    // $ANTLR start sensor
    // MyDsl.g:14:1: sensor : 'criarSensor' tipoSensor= ( 'gps' | 'bussola' ) ;
    public final void sensor() throws RecognitionException {
        Token tipoSensor=null;

        try {
            // MyDsl.g:15:2: ( 'criarSensor' tipoSensor= ( 'gps' | 'bussola' ) )
            // MyDsl.g:15:2: 'criarSensor' tipoSensor= ( 'gps' | 'bussola' )
            {
            match(input,7,FOLLOW_7_in_sensor42); 
            tipoSensor=(Token)input.LT(1);
            if ( (input.LA(1)>=8 && input.LA(1)<=9) ) {
                input.consume();
                errorRecovery=false;
            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_sensor46);    throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end sensor


 

    public static final BitSet FOLLOW_stat_in_prog24 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_6_in_stat32 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_sensor_in_stat34 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_7_in_sensor42 = new BitSet(new long[]{0x0000000000000300L});
    public static final BitSet FOLLOW_set_in_sensor46 = new BitSet(new long[]{0x0000000000000002L});

}