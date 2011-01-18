//Leitura do banco e escrita num txt
import java.sql.*;
import java.io.*;

public class LeituraBancoEscritaTxt {//Leitura e escrita diretamente no Banco:
	public static void main(String[] argv) {
		//declarando as variáveis:	 
		Connection connection = null;
		String leitura = "select xwd_content from xwikidoc where xwd_name='TesteNome'"; 
	
		Statement stmt; 		
		String url = "jdbc:postgresql://localhost:5432/xwiki";

 
		try {
 			Class.forName("org.postgresql.Driver"); //Carrega o driver do postgresql
		} catch (ClassNotFoundException e) {
 			System.out.println("Where is your PostgreSQL JDBC Driver? \n Include in your library path!");
			e.printStackTrace();
			return;	}
 			
		try { 
			connection = DriverManager.getConnection(url,"postgres", "12345"); 			
			//Leitura (SELECT)
			stmt = connection.createStatement(); 
			ResultSet rs = stmt.executeQuery(leitura); 
			
			ResultSetMetaData rsmd = rs.getMetaData(); 
			int numberOfColumns = rsmd.getColumnCount(); 
			int rowCount = 1; 
			//Imprimindo os resultados no terminal		
			System.out.println("Modelo (entrada): \n"); 
			while (rs.next()) { 
		
				for (int i = 1; i <= numberOfColumns; i++) { 

				  // System.out.print("   Campo " + i + ":  "); 
				   System.out.println(rs.getString(i)); 
			        } 

		       System.out.println(""); 
		       rowCount++; 
		       }
			
		   	stmt.close(); 
		   	connection.close(); 

			
	       } catch(SQLException ex) { 
		   System.err.print("SQLException: "); 
		   System.err.println(ex.getMessage());} 
		
		try{
			FileWriter writer = new FileWriter("CodigoGerado.txt");
			writer.write("Este será o código gerado pela minha dsl!!");
			writer.close(); 
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
	}
}
