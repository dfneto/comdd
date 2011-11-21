import org.antlr.runtime.*;
import java.io.*;

public class Test {
	public static void main(String[] args) throws Exception {
		PrintStream padrao = System.out;
		PrintStream fileLog = new PrintStream(new File("/home/david/liguagem_comdd_v2/versa_modificada/CodigoGerado/Codigo.cpp")); 
		System.setOut(fileLog);//Joga tudo que sairia na saída padrão (no caso o código gerado) num arquivo


		ANTLRInputStream input = new ANTLRFileStream("/home/david/liguagem_comdd_v2/versa_modificada/Modelo/Modelo");
		MyDslLexer lexer = new MyDslLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MyDslParser parser = new MyDslParser(tokens);
		parser.stat();
		System.setOut(padrao); //Volta ao normal: joga tudo que sairia no log na saída padrao
	}
}

