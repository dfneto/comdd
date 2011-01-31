import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*; 

public class JDBCExample {
	public static void main(String[] argv) {
		//declarando as variáveis:	 
		Connection connection = null;
		String query = "select xwd_content from xwikidoc where xwd_name='TesteNome'"; 
		Statement stmt; 		
		String url = "jdbc:postgresql://localhost:5432/xwiki";

		System.out.println("-------- PostgreSQL JDBC Connection Testing ------------");
 
		try {
 			Class.forName("org.postgresql.Driver"); //Carrega o driver do postgresql
		} catch (ClassNotFoundException e) {
 			System.out.println("Where is your PostgreSQL JDBC Driver? \n Include in your library path!");
			e.printStackTrace();
			return;	}
 		
		System.out.println("PostgreSQL JDBC Driver Registered! \n Valendo !!);
 
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
		stmt = connection.createStatement(); 
		ResultSet rs = stmt.executeQuery(query); 
	        ResultSetMetaData rsmd = rs.getMetaData(); 
		int numberOfColumns = rsmd.getColumnCount(); 
	        int rowCount = 1; 
		
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

	
	}
}
