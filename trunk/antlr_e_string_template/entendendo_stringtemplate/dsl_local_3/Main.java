import java.io.*;
import org.antlr.runtime.*;
import org.antlr.stringtemplate.*;
import org.antlr.stringtemplate.language.*;

public class Main {
    public static StringTemplateGroup templates;

    public static void main(String[] args) throws Exception {
	String templateFileName = "T.stg";

	templates = new StringTemplateGroup(new FileReader(templateFileName),
					    AngleBracketTemplateLexer.class);
	//pega argumentos
	//CharStream input = new ANTLRFileStream(args[a]);
	//o usuario edita na hora
        ANTLRInputStream input = new ANTLRInputStream(System.in);
	TLexer lexer = new TLexer(input);
	//TLexer lexer1 = new TLexer(input);
	CommonTokenStream tokens = new CommonTokenStream(lexer);
	//CommonTokenStream tokens1 = new CommonTokenStream(lexer1);
	TParser parser = new TParser(tokens);
	//TParser parser1 = new TParser(tokens1);
	parser.setTemplateLib(templates);
	//parser1.setTemplateLib(templates);
	RuleReturnScope r = parser.robo();
	//RuleReturnScope r1 = parser1.stat();
	//System.out.println(r.getTemplate().toString()+r1.getTemplate().toString());
	System.out.println(r.getTemplate().toString());
	//System.out.println(r1.getTemplate().toString());

    }
}
