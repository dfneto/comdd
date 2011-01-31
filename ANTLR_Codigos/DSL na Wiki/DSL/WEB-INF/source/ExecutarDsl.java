//Lê o modelo de entrada passado pela classe Principal, se comunica com a gramática e gerar um arquivo CódigoGerado.cpp

import org.antlr.runtime.*;
import java.io.*;

public class ExecutarDsl {
	//public static void main(String[] args) throws Exception {
	public static void executeDsl() throws Exception {
		PrintStream padrao = System.out;
		PrintStream fileLog = new PrintStream(new File("CodigoGerado.cpp")); 
		System.setOut(fileLog);//Joga tudo que sairia na saída padrão (no caso o código gerado) num arquivo

		// create a CharStream that reads from standard input
		ANTLRFileStream input = new ANTLRFileStream("./Modelo/Modelo");
		// create a lexer that feeds off of input CharStream
		MyDslLexer lexer = new MyDslLexer(input);
		// create a buffer of tokens pulled from the lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		// create a parser that feeds off the tokens buffer
		MyDslParser parser = new MyDslParser(tokens);
		// begin parsing at rule r
		parser.stat();
				
		System.setOut(padrao); //Volta ao normal: joga tudo que sairia no log na saída padrao
		}	
	
		
	}

