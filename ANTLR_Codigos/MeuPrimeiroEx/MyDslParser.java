// $ANTLR 3.0 MyDsl.g 2010-12-01 14:03:53

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
    // MyDsl.g:12:1: stat : 'robo' nomeRobo= ID sensor ;
    public final void stat() throws RecognitionException {
        Token nomeRobo=null;

        try {
            // MyDsl.g:12:7: ( 'robo' nomeRobo= ID sensor )
            // MyDsl.g:12:7: 'robo' nomeRobo= ID sensor
            {
            match(input,6,FOLLOW_6_in_stat32); 
            nomeRobo=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_stat36); 
            pushFollow(FOLLOW_sensor_in_stat38);
            sensor();
            _fsp--;

            System.out.println ("Robo " +nomeRobo.getText()+ " criado com sucesso!!" );

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
    // MyDsl.g:14:1: sensor : 'criarSensor' tipoSensor ;
    public final void sensor() throws RecognitionException {
        try {
            // MyDsl.g:15:2: ( 'criarSensor' tipoSensor )
            // MyDsl.g:15:2: 'criarSensor' tipoSensor
            {
            match(input,7,FOLLOW_7_in_sensor49); 
            pushFollow(FOLLOW_tipoSensor_in_sensor51);
            tipoSensor();
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
    // $ANTLR end sensor

    public static class tipoSensor_return extends ParserRuleReturnScope {
    };

    // $ANTLR start tipoSensor
    // MyDsl.g:17:1: tipoSensor : ( 'gps' | 'bussola' ) ;
    public final tipoSensor_return tipoSensor() throws RecognitionException {
        tipoSensor_return retval = new tipoSensor_return();
        retval.start = input.LT(1);

        try {
            // MyDsl.g:17:13: ( ( 'gps' | 'bussola' ) )
            // MyDsl.g:17:13: ( 'gps' | 'bussola' )
            {
            if ( (input.LA(1)>=8 && input.LA(1)<=9) ) {
                input.consume();
                errorRecovery=false;
            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_tipoSensor58);    throw mse;
            }

            if (input.toString(retval.start,input.LT(-1)) == "gps")
            		System.out.println("GPS criado com sucesso!");
            	else 
            		System.out.println("Compass criado com sucesso!");
            	

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end tipoSensor


 

    public static final BitSet FOLLOW_stat_in_prog24 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_6_in_stat32 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_stat36 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_sensor_in_stat38 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_7_in_sensor49 = new BitSet(new long[]{0x0000000000000300L});
    public static final BitSet FOLLOW_tipoSensor_in_sensor51 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_tipoSensor58 = new BitSet(new long[]{0x0000000000000002L});

}