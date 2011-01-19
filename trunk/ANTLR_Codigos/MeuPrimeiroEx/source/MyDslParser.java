// $ANTLR 3.0 source/MyDsl.g 2011-01-19 16:18:36

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class MyDslParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "WS", "'robo'", "'Adicionar'", "'defines'", "'includes'", "'criarSensor'", "'gps'", "'bussola'"
    };
    public static final int WS=5;
    public static final int ID=4;
    public static final int EOF=-1;

        public MyDslParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "source/MyDsl.g"; }


    String s;



    // $ANTLR start prog
    // source/MyDsl.g:10:1: prog : ( stat )+ ;
    public final void prog() throws RecognitionException {
        try {
            // source/MyDsl.g:10:7: ( ( stat )+ )
            // source/MyDsl.g:10:7: ( stat )+
            {
            // source/MyDsl.g:10:7: ( stat )+
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
            	    // source/MyDsl.g:10:7: stat
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
    // source/MyDsl.g:12:1: stat : 'robo' nomeRobo= ID ( cabecalho )* ( sensor )* ;
    public final void stat() throws RecognitionException {
        Token nomeRobo=null;

        try {
            // source/MyDsl.g:12:7: ( 'robo' nomeRobo= ID ( cabecalho )* ( sensor )* )
            // source/MyDsl.g:12:7: 'robo' nomeRobo= ID ( cabecalho )* ( sensor )*
            {
            match(input,6,FOLLOW_6_in_stat32); 
            nomeRobo=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_stat36); 
            // source/MyDsl.g:12:26: ( cabecalho )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==7) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // source/MyDsl.g:12:26: cabecalho
            	    {
            	    pushFollow(FOLLOW_cabecalho_in_stat38);
            	    cabecalho();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // source/MyDsl.g:12:38: ( sensor )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==10) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // source/MyDsl.g:12:38: sensor
            	    {
            	    pushFollow(FOLLOW_sensor_in_stat42);
            	    sensor();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            System.out.println ("Robo " +nomeRobo.getText()+ " criado com sucesso!! ");

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


    // $ANTLR start cabecalho
    // source/MyDsl.g:15:1: cabecalho : 'Adicionar' itensCabecalho= ( 'defines' | 'includes' ) ;
    public final void cabecalho() throws RecognitionException {
        Token itensCabecalho=null;

        try {
            // source/MyDsl.g:16:2: ( 'Adicionar' itensCabecalho= ( 'defines' | 'includes' ) )
            // source/MyDsl.g:16:2: 'Adicionar' itensCabecalho= ( 'defines' | 'includes' )
            {
            match(input,7,FOLLOW_7_in_cabecalho55); 
            // source/MyDsl.g:16:29: ( 'defines' | 'includes' )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==8) ) {
                alt4=1;
            }
            else if ( (LA4_0==9) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("16:29: ( 'defines' | 'includes' )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // source/MyDsl.g:17:3: 'defines'
                    {
                    match(input,8,FOLLOW_8_in_cabecalho63); 
                    System.out.println("Defines Adicionados!!");

                    }
                    break;
                case 2 :
                    // source/MyDsl.g:18:10: 'includes'
                    {
                    match(input,9,FOLLOW_9_in_cabecalho76); 
                    System.out.println("Includes Adicionados!!");

                    }
                    break;

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
    // $ANTLR end cabecalho


    // $ANTLR start sensor
    // source/MyDsl.g:20:1: sensor : 'criarSensor' tipoSensor ;
    public final void sensor() throws RecognitionException {
        try {
            // source/MyDsl.g:21:2: ( 'criarSensor' tipoSensor )
            // source/MyDsl.g:21:2: 'criarSensor' tipoSensor
            {
            match(input,10,FOLLOW_10_in_sensor87); 
            pushFollow(FOLLOW_tipoSensor_in_sensor89);
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


    // $ANTLR start tipoSensor
    // source/MyDsl.g:25:1: tipoSensor returns [String value] : ( 'gps' | 'bussola' ) ;
    public final String tipoSensor() throws RecognitionException {
        String value = null;

        try {
            // source/MyDsl.g:26:2: ( ( 'gps' | 'bussola' ) )
            // source/MyDsl.g:26:2: ( 'gps' | 'bussola' )
            {
            // source/MyDsl.g:26:2: ( 'gps' | 'bussola' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==11) ) {
                alt5=1;
            }
            else if ( (LA5_0==12) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("26:2: ( 'gps' | 'bussola' )", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // source/MyDsl.g:26:3: 'gps'
                    {
                    match(input,11,FOLLOW_11_in_tipoSensor105); 
                    value = "gps";
                    		System.out.println("GPS criado com sucesso!");

                    }
                    break;
                case 2 :
                    // source/MyDsl.g:28:4: 'bussola'
                    {
                    match(input,12,FOLLOW_12_in_tipoSensor112); 
                    value = "bussola";
                    		System.out.println("Compass criado com sucesso!");

                    }
                    break;

            }

            System.out.println("Valor do $tipoSensor = " +value);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end tipoSensor


 

    public static final BitSet FOLLOW_stat_in_prog24 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_6_in_stat32 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_stat36 = new BitSet(new long[]{0x0000000000000482L});
    public static final BitSet FOLLOW_cabecalho_in_stat38 = new BitSet(new long[]{0x0000000000000482L});
    public static final BitSet FOLLOW_sensor_in_stat42 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_7_in_cabecalho55 = new BitSet(new long[]{0x0000000000000300L});
    public static final BitSet FOLLOW_8_in_cabecalho63 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_9_in_cabecalho76 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_sensor87 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_tipoSensor_in_sensor89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_tipoSensor105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_tipoSensor112 = new BitSet(new long[]{0x0000000000000002L});

}