//Esta classe é responsável por chamar a classe auxiliar e a test

import java.io.*;
public class Principal {
	public static void main(String[] args) {
		
		String modeloDaXwiki = "plataforma golfe \n robo feliz";

		System.out.println("@@ Iniciando ....");
		
		Auxiliar aux = new Auxiliar();
		aux.estabelecerConexaoComBanco();
		
		aux.escritaNoBanco(modeloDaXwiki);
		
		
		
		aux.encerrarConexao();
	}
}
		
