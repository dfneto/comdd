//A classe Auxiliar serve para auxiliar a classe TEST (que executa a MyDsl.g) realizando as seguintes atividades:
//1.Leitura do banco (Modelo),  2.escrita do Modelo num txt. Esse Modelo servirá de entrada para minha dsl.jar (TEST.java) que irá 
//transformar em códigofonte.cpp (Atividade da Classe TEST)
//3. Gerar e 4.Inserir o CódigoFonte.cpp em uma tabela

import java.sql.*;
import java.io.*;

public class Auxiliar {
	//public static void main(String[] argv) {
		Connection connection = null;
		String leitura = "select xwd_content from xwikidoc where xwd_name='TesteNome'"; 
		String ValorLido = null;
		Statement stmt; 		
		String url = "jdbc:postgresql://143.107.231.251:5432/xwiki";
		String CodigoGeradoPelaDsl = "Substituir isso pelo codigo gerado pela dsl";
		String escrita = "UPDATE xwikidoc SET xwd_content='" + CodigoGeradoPelaDsl + "' where xwd_name='CodigoGerado'";
		Statement stmtSelect; 			
		Statement stmtUpdate;
 		
	public void estabelecerConexaoComBanco() {
		//Carregando o Driver do Postgre
		try {
 			Class.forName("org.postgresql.Driver"); 
		} catch (ClassNotFoundException e) {
 			System.out.println("Where is your PostgreSQL JDBC Driver? \n Include in your library path!");
			e.printStackTrace();
			return;	}
		//estabelecendo conexão com o banco		
		try {	 
			connection = DriverManager.getConnection(url,"postgres", "12345"); 
		} catch(SQLException ex) {
	                System.err.print("SQLException: ");
                        System.err.println(ex.getMessage());}
        }

	public void leituraDoBanco() {
		try {
			//Leitura (SELECT)
			stmt = connection.createStatement(); 
			ResultSet rs = stmt.executeQuery(leitura); 
			
			rs.next();
			ValorLido = rs.getString(1);
			System.out.println("Modelo extraído da Xwiki:\n\n"+ValorLido);

			//ResultSetMetaData rsmd = rs.getMetaData(); 
			//int numberOfColumns = rsmd.getColumnCount(); 
						
			//Imprimindo os resultados no terminal		
			//System.out.println("Modelo (entrada): \n"); 
			/*while (rs.next()) {  //rs.next será true enquanto tiver linhas a percorrer
				ValorLido = rs.getString(1);
				for (int i = 1; i <= numberOfColumns; i++) { 
					System.out.println(rs.getString(i)); 
					System.out.println(i); 	
			        } 
		       	}*/
			
		   	stmt.close(); 
		   	

			
		} catch(SQLException ex) { 
			System.err.print("SQLException: "); 
		   	System.err.println(ex.getMessage());} 
	}
	public void escritaDoModelo() {
		//Escrever o Modelo lido do banco num arquivo
		try{
			FileWriter writer = new FileWriter("/home/david/comdd/ANTLR_Codigos/jar/DSL-LRM/classes/Modelo/Modelo");
			writer.write(ValorLido);
			writer.close(); 
			System.out.println("@@ Foi criado um arquivo com o modelo extraído da Xwiki.................");
		} catch(IOException ex) {
			ex.printStackTrace();}
	}
	
	public void lerArquivoCodigoGerado() {
			
	}

	public void escritaNoBanco() {
			try{
				stmtUpdate = connection.createStatement(); 
				stmtUpdate.executeUpdate(escrita);
				System.out.println("Valor Alterado para: \n" + CodigoGeradoPelaDsl);
				stmtUpdate.close();
			} catch(SQLException ex) { 
				System.err.print("SQLException: "); 
		   		System.err.println(ex.getMessage());} 
	}
	public void encerrarConexao() {
		try{
			connection.close(); 
		} catch(SQLException ex) { 
			System.err.print("SQLException: "); 
			System.err.println(ex.getMessage());} 
	/*public void gerarArquivoComCodigoFonteGerado() {
		
	}*/
	
	}
}
