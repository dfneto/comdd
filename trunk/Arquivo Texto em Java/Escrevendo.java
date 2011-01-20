//Gravando um texto em um txt
//Código extraído do JavaHeadFirts

import java.io.*;

public class Escrevendo{

	public static void main (String [] args){
		try{
			FileWriter writer = new FileWriter("CodigoGerado.txt");
			writer.write("Este será o código gerado pela minha dsl!!");
			writer.close(); 
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}
}
		
