import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        TLexer lex = new TLexer(new ANTLRFileStream("/home/david/Desktop/tentativas a entender/dsl_local_2/output/__Test___input.txt", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        TParser g = new TParser(tokens, 49100, null);
        try {
            g.robo();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}