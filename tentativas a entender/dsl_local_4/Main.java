import java.io.*;
import org.antlr.runtime.*;
import org.antlr.stringtemplate.*;
import org.antlr.stringtemplate.language.*;

public class Main {
    public static StringTemplateGroup templates;

    public static void main(String[] args) throws Exception {
	String templateFileName;
	int a = 0;
	if ( args.length<=1 ) {
		templateFileName = "T.stg";
	}
	else {
		templateFileName = args[a];
		a++;
	}
	templates = new StringTemplateGroup(new FileReader(templateFileName),
					    AngleBracketTemplateLexer.class);

	CharStream input = new ANTLRFileStream(args[a]);
	TLexer lexer = new TLexer(input);
	CommonTokenStream tokens = new CommonTokenStream(lexer);
	TParser parser = new TParser(tokens);
	parser.setTemplateLib(templates);
	RuleReturnScope r = parser.robo();
	System.out.println(r.getTemplate().toString());
    }
}
