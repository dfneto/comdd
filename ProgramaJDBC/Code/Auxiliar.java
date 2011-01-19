//A classe Auxiliar serve para auxiliar a classe TEST (que executa a MyDsl.g) realizando as seguintes atividades:
//1.Leitura do banco (Modelo),  2.escrita do Modelo num txt. Esse Modelo servirá de entrada para minha dsl.jar (TEST.java) que irá 
//transformar em códigofonte.cpp (Atividade da Classe TEST)
//3. Inserir o CódigoFonte.cpp deve ser inserido em uma tabela

import java.sql.*;
import java.io.*;

public class Auxiliar {
	public static void main(String[] argv) {
		Connection connection = null;
		String leitura = "select xwd_content from xwikidoc where xwd_name='TesteNome'"; 
		String ValorLido = null;
		Statement stmt; 		
		String url = "jdbc:postgresql://localhost:5432/xwiki";
 		
		//Carregando o Driver
		try {
 			Class.forName("org.postgresql.Driver"); 
		} catch (ClassNotFoundException e) {
 			System.out.println("Where is your PostgreSQL JDBC Driver? \n Include in your library path!");
			e.printStackTrace();
			return;	}
		try { 
			connection = DriverManager.getConnection(url,"postgres", "12345"); //estabelecendo conexão			
			//Leitura (SELECT)
			stmt = connection.createStatement(); 
			ResultSet rs = stmt.executeQuery(leitura); 
			
			rs.next();
			ValorLido = rs.getString(1);
			System.out.println(ValorLido);

			ResultSetMetaData rsmd = rs.getMetaData(); 
			int numberOfColumns = rsmd.getColumnCount(); 
						
			//Imprimindo os resultados no terminal		
			System.out.println("Modelo (entrada): \n"); 
			while (rs.next()) {  //rs.next será true enquanto tiver linhas a percorrer
				ValorLido = rs.getString(1);
				for (int i = 1; i <= numberOfColumns; i++) { 
					System.out.println(rs.getString(i)); 
					System.out.println(i); 	
			        } 
		       	}
			
		   	stmt.close(); 
		   	connection.close(); 

			
	       } catch(SQLException ex) { 
		   	System.err.print("SQLException: "); 
		   	System.err.println(ex.getMessage());} 
		//Escrita num txt
		try{
			FileWriter writer = new FileWriter("CodigoGerado.txt");
			writer.write(ValorLido);
			writer.close(); 
		} catch(IOException ex) {
			ex.printStackTrace();}
		
	}
}
