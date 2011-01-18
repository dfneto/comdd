//Lendo do Banco:
import java.sql.*;

public class LendoBanco {
	public static void main(String[] argv) {
		//declarando as variáveis:	 
		Connection connection = null;
		String leitura = "select xwd_content from xwikidoc where xwd_name='TesteNome'"; 
	//	String escrita = "UPDATE xwikidoc SET xwd_content='Chocolate Feliz' where xwd_name='TesteNome'";
		String CodigoGeradoPelaDsl = "Aeeeeeeeeeeeeeee";
		String escrita = "UPDATE xwikidoc SET xwd_content='" + CodigoGeradoPelaDsl + "' where xwd_name='TesteNome'";
		Statement stmt; 		
		String url = "jdbc:postgresql://localhost:5432/xwiki";

		System.out.println("-------- PostgreSQL JDBC Connection Testing ------------");
 
		try {
 			Class.forName("org.postgresql.Driver"); //Carrega o driver do postgresql
		} catch (ClassNotFoundException e) {
 			System.out.println("Where is your PostgreSQL JDBC Driver? \n Include in your library path!");
			e.printStackTrace();
			return;	}
 		
		System.out.println("PostgreSQL JDBC Driver Registered! \n Valendo !!");
 
		//Connection connection = null;
 
		try { 
			connection = DriverManager.getConnection(
				"jdbc:postgresql://127.0.0.1:5432/xwiki","xwiki", "xwiki"); //conectando ao banco
 		} catch (SQLException e) {
 			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;	}
 
		if (connection != null){
			System.out.println("You made it, take control your database now! -- Valendo 2!!!");
		}else{
			System.out.println("Failed to make connection!");
		}

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
			//Alterando o valor do campo (UPDATE)
			stmt.executeUpdate(escrita);
			System.out.println("O valor foi alterado: \n String usada: "+escrita+ "\n Valor Alterado para: \n" + CodigoGeradoPelaDsl);	 

		   	stmt.close(); 
		   	connection.close(); 

       } catch(SQLException ex) { 
           System.err.print("SQLException: "); 
           System.err.println(ex.getMessage());} 
		
	}
}
