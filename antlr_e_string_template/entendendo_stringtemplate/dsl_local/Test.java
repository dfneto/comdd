import java.io.*;
import org.antlr.runtime.*;
import org.antlr.stringtemplate.*;
import org.antlr.stringtemplate.language.*;

public class Test {
    public static void main(String[] args) throws Exception {
    
        FileReader groupFileR = new FileReader("T.stg");
        StringTemplateGroup templates =
            new StringTemplateGroup(groupFileR);
        groupFileR.close();

        // PARSE INPUT AND COMPUTE TEMPLATE
        ANTLRInputStream input = new ANTLRInputStream(System.in);
        TLexer lexer = new TLexer(input);     // create lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TParser parser = new TParser(tokens); // create parser
        parser.setTemplateLib(templates); // give parser templates
//        TParser.s_return r = parser.s();      // parse rule s
//        StringTemplate output = r.getTemplate();
//        System.out.println(output.toString());// emit translation

        RuleReturnScope r = parser.robo();
        System.out.println(r.getTemplate().toString());

    }
}
