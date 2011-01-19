import org.antlr.runtime.*;
//import java.io.*;

public class ExecutarDsl {
	//public static void main(String[] args) throws Exception {
	public void executeDsl() throws Exception {
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
		}	
	/*public void generateFile() {
		try{	
			String CodigoGerado = parser.stat();
			FileWriter writer = new FileWriter("CodigoGerado.cpp");
			writer.write(CodigoGerado);
			writer.close(); 
			System.out.println("@@ Foi criado um arquivo com o código gerado.................");
		} catch(IOException ex) {
				ex.printStackTrace();}
		}
	*/
		
	}

