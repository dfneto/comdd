//Leitura e escrita diretamente no Banco:
import java.sql.*;

public class AcessoBanco {
	public static void main(String[] argv) {
		//declarando as variáveis:	 
		Connection connection = null;
		String leitura = "select xwd_content from xwikidoc where xwd_name='TesteNome'"; 
	//	String escrita = "UPDATE xwikidoc SET xwd_content='Chocolate Feliz' where xwd_name='TesteNome'";
		String CodigoGeradoPelaDsl = "Quero alterar esse valor agora";
		String escrita = "UPDATE xwikidoc SET xwd_content='" + CodigoGeradoPelaDsl + "' where xwd_name='TesteNome'";
		Statement stmtSelect; 			
		Statement stmtUpdate; 		
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
			stmtSelect = connection.createStatement(); 
			ResultSet rsSelect = stmtSelect.executeQuery(leitura); 
			
			ResultSetMetaData rsmd = rsSelect.getMetaData(); 
			int numberOfColumns = rsmd.getColumnCount(); 
			int rowCount = 1; 
			//Imprimindo os resultados no terminal		
			System.out.println("Modelo (entrada): \n"); 
			while (rsSelect.next()) { 
		
				for (int i = 1; i <= numberOfColumns; i++) { 

				  // System.out.print("   Campo " + i + ":  "); 
				   System.out.println(rsSelect.getString(i)); 
			        } 

		       System.out.println(""); 
		       rowCount++; 
		       }
			//Alterando o valor do campo (UPDATE)
			stmtUpdate = connection.createStatement(); 
			stmtUpdate.executeUpdate(escrita);
			System.out.println("O valor foi alterado: \n String usada: "+escrita+ "\n Valor Alterado para: \n" + CodigoGeradoPelaDsl);	 

		   	stmtSelect.close(); 
			stmtUpdate.close();
		   	connection.close(); 

       } catch(SQLException ex) { 
           System.err.print("SQLException: "); 
           System.err.println(ex.getMessage());} 
		
	}
}
