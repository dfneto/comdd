package com.acme.internal;

import com.acme.Dsl;
import org.xwiki.component.annotation.Component;

import java.io.*;
import org.antlr.runtime.*;
import org.antlr.stringtemplate.*;
import org.antlr.stringtemplate.language.*;
import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.antlr.stringtemplate.language.DefaultTemplateLexer;



@Component
public class DefaultDsl implements Dsl
{

   public String executeDsl(String modelo) {
     try{
	StringTemplateGroup templates;
	//Salva o modelo criado na xwiki neste diretório
	FileWriter writer = new FileWriter("/home/david/Xwiki/apache-tomcat-6.0.30/webapps/DSL/WEB-INF/classes/Modelo/Modelo");
	writer.write(modelo);
        writer.close(); 
       
	PrintStream padrao = System.out;
	PrintStream fileLog = new PrintStream(new File("/home/david/Xwiki/apache-tomcat-6.0.30/webapps/DSL/WEB-INF/classes/Modelo/CodigoGerado.cpp")); 
	System.setOut(fileLog);//Joga tudo que sairia na saída padrão (no caso o código gerado) num arquivo

	String templateFileName = "Template.stg";
	templates = new StringTemplateGroup(new FileReader(templateFileName), AngleBracketTemplateLexer.class);


	//ANTLRFileStream input = new ANTLRFileStream("./Modelo/Modelo"); -> nao funciona :/	
	ANTLRFileStream input = new ANTLRFileStream("/home/david/Xwiki/apache-tomcat-6.0.30/webapps/DSL/WEB-INF/classes/Modelo/Modelo");
	MyDslLexer lexer = new MyDslLexer(input);
	CommonTokenStream tokens = new CommonTokenStream(lexer);
	MyDslParser parser = new MyDslParser(tokens);
//	parser.robo();
	parser.setTemplateLib(templates);
	RuleReturnScope r = parser.robo();
	String saida = r.getTemplate().toString();
	System.out.println(saida);
	FileWriter fw = new FileWriter("/home/david/Xwiki/apache-tomcat-6.0.30/webapps/DSL/WEB-INF/classes/Modelo/CodigoGerado.cpp", true);
	fw.write(saida);
	fw.close();				
	System.setOut(padrao); //Volta ao normal: joga tudo que sairia no log na saída padrao
	
	//lendo o codigo gerado e inserindo numa string para apresentar na Xwiki
	File myFile = new File("/home/david/Xwiki/apache-tomcat-6.0.30/webapps/DSL/WEB-INF/classes/Modelo/CodigoGerado.cpp");
        FileReader fileReader = new FileReader(myFile);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = null;
	String CodigoGeradoPelaDsl = "";
        while ((line = reader.readLine()) != null) {
                System.out.println(line);
                CodigoGeradoPelaDsl = CodigoGeradoPelaDsl + "\n" + line;
        }
      
        reader.close();

//	return saida;
	return CodigoGeradoPelaDsl;

    }catch(Exception e)
	{ return ""; }
}
}

