//Esta classe é responsável por chamar a classe auxiliar e a test

import java.io.*;
public class Principal {
	public static void main(String[] args) {
		
		System.out.println("@@ Iniciando ....");
		//Ações de Auxiliar		
		Auxiliar aux = new Auxiliar();
		aux.estabelecerConexaoComBanco();
		aux.leituraDoBanco();
		aux.escritaDoModelo();
		//aux.escritaNoBanco();
		aux.encerrarConexao();		

		ExecutarDsl dsl = new ExecutarDsl();
		try{	
			System.out.println("@@ Chamando a classe ExecutarDsl..........................\n");
			System.out.println("======= Código Gerado =========\n");
			dsl.executeDsl(); 
			PrintStream padrao = System.out;
			System.out.println("@@ A classe ExecutarDsl foi executada com sucesso .........................\n");
		} catch (Exception e) {
			System.out.println("Fodeo");}

	}
}
		
