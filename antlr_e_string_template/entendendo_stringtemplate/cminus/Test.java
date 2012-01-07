import org.antlr.runtime.*;
import org.antlr.stringtemplate.*;
import org.antlr.stringtemplate.language.*;
import java.io.*;


public class Test {
    public static StringTemplateGroup templates;

    public static void main(String[] args) throws Exception {
	String templateFileName = "Java.stg";
	int a=0; 
        





	
	templates = new StringTemplateGroup(new FileReader(templateFileName), 
						AngleBracketTemplateLexer.class);


	CharStream input = new ANTLRFileStream(args[a]);
        CMinusLexer lexer = new CMinusLexer(input);     // create lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CMinusParser parser = new CMinusParser(tokens); // create parser
        parser.setTemplateLib(templates); // give parser templates
        RuleReturnScope r = parser.program();
        System.out.println(r.getTemplate().toString());

    }
}
