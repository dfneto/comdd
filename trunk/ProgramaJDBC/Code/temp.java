import java.sql.*;

public class SQLStatement {

   public static void main(String args[]) { 

       //String url = "jdbc:postgresql://10.0.1.53:5432/agenda"; 

       String url = "jdbc:postgresql://localhost:5432/agenda"; 

       //String url = "jdbc:postgresql:agenda";    //Assim pega os defaults 

       Connection con; 

       String query = "select * from amigos”; 

       Statement stmt; 

       try { 

           Class.forName("org.postgresql.Driver"); 

       } catch(java.lang.ClassNotFoundException e) { 

           System.err.print("ClassNotFoundException: "); 

           System.err.println(e.getMessage()); 

       } 

       try { 

           con = DriverManager.getConnection(url,"postgres", "postgres"); 

           stmt = con.createStatement(); 

           ResultSet rs = stmt.executeQuery(query); 

           ResultSetMetaData rsmd = rs.getMetaData(); 

           int numberOfColumns = rsmd.getColumnCount(); 

           int rowCount = 1; 

           while (rs.next()) { 

               System.out.println("Registro " + rowCount + ":  "); 

               for (int i = 1; i <= numberOfColumns; i++) { 

                   System.out.print("   Campo " + i + ":  "); 

                   System.out.println(rs.getString(i)); 

               } 

               System.out.println(""); 

               rowCount++; 

           } 

           stmt.close(); 

           con.close(); 

       } catch(SQLException ex) { 

           System.err.print("SQLException: "); 

           System.err.println(ex.getMessage()); 

       } 

   } 

}
