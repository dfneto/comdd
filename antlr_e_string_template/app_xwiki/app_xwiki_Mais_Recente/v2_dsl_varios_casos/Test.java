/***
 * Excerpted from "The Definitive ANTLR Reference",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/tpantlr for more book information.
***/
import org.antlr.runtime.*;
import org.antlr.stringtemplate.*;
import java.io.*;

public class Test {
    public static void main(String[] args) throws Exception {
        // load in T.stg template group, put in templates variable
        FileReader groupFileR = new FileReader("Template.stg");
        StringTemplateGroup templates =
            new StringTemplateGroup(groupFileR);
        groupFileR.close();

        // PARSE INPUT AND COMPUTE TEMPLATE
        ANTLRInputStream input = new ANTLRInputStream(System.in);
        MyDslLexer lexer = new MyDslLexer(input);     // create lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MyDslParser parser = new MyDslParser(tokens); // create parser
        parser.setTemplateLib(templates); // give parser templates
//        TParser.s_return r = parser.s();      // parse rule s
//        StringTemplate output = r.getTemplate();
//        System.out.println(output.toString());// emit translation

        RuleReturnScope r = parser.robo();
        System.out.println(r.getTemplate().toString());

    }
}
