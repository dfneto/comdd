package com.acme.internal;

import com.acme.Dsl;
import org.xwiki.component.annotation.Component;


import org.antlr.runtime.*;
import java.io.*;


@Component
public class DefaultDsl implements Dsl
{
   public String executeDsl(String modelo) {
     try{//Criando um arquivo a partir da string modelo
	
		FileWriter writer = new FileWriter("/home/david/Xwiki/apache-tomcat-6.0.30/webapps/DSL/WEB-INF/classes/Modelo/Modelo");
	        writer.write(modelo);
                writer.close(); 
       


	PrintStream padrao = System.out;
	PrintStream fileLog = new PrintStream(new File("/home/david/Xwiki/apache-tomcat-6.0.30/webapps/DSL/WEB-INF/classes/Modelo/CodigoGerado.cpp")); 
	System.setOut(fileLog);//Joga tudo que sairia na saída padrão (no caso o código gerado) num arquivo

	// create a CharStream that reads from standard input
//	ANTLRFileStream input = new ANTLRFileStream("./Modelo/Modelo"); -> nao funciona :/
//ANTLRInputStream
	ANTLRFileStream input = new ANTLRFileStream("/home/david/Xwiki/apache-tomcat-6.0.30/webapps/DSL/WEB-INF/classes/Modelo/Modelo");
	// create a lexer that feeds off of input CharStream
	MyDslLexer lexer = new MyDslLexer(input);
	// create a buffer of tokens pulled from the lexer
	CommonTokenStream tokens = new CommonTokenStream(lexer);
	// create a parser that feeds off the tokens buffer
	MyDslParser parser = new MyDslParser(tokens);
	// begin parsing at rule r
	parser.stat();
					
	System.setOut(padrao); //Volta ao normal: joga tudo que sairia no log na saída padrao
	
	//lendo o codigo gerado e inserindo numa string
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

	return CodigoGeradoPelaDsl;
	}catch(Exception e){ return ""; }
}
}

