//A classe Auxiliar serve para auxiliar a classe TEST (que executa a MyDsl.g) realizando as seguintes atividades:
//1.Leitura do banco (Modelo),  2.escrita do Modelo num txt. Esse Modelo servirá de entrada para minha dsl.jar (TEST.java) que irá 
//transformar em códigofonte.cpp (Atividade da Classe TEST)
//3. Gerar e 4.Inserir o CódigoFonte.cpp em uma tabela

import java.sql.*;
import java.io.*;

public class Auxiliar {
		Connection connection = null;
		String leitura = "select xwd_content from xwikidoc where xwd_name='TesteNome'"; 
		String valorLido = null; //valorLido a partir da string de leitura
		Statement stmt; 		
		String url = "jdbc:postgresql://143.107.231.251:5432/xwiki";
		String codigoGeradoPelaDsl = "";
		//String escrita = "UPDATE xwikidoc SET xwd_content='" + codigoGeradoPelaDsl + "' where xwd_name='CodigoGerado'";
		Statement stmtSelect; 			
		Statement stmtUpdate;
		String resultado; 			
		String resultado1;
		String resultado2; 
	
	public String estabelecerConexaoComBanco() {
		//Carregando o Driver do Postgre
		try {
 			Class.forName("org.postgresql.Driver"); 
			resultado1 = "ok1";			
		} catch (ClassNotFoundException e) {
 			System.out.println("Where is your PostgreSQL JDBC Driver? \n Include in your library path!");
			e.printStackTrace();
			resultado1 = "fail1";	}
		//estabelecendo conexão com o banco		
		try {	 
			connection = DriverManager.getConnection(url,"postgres", "12345"); 
			resultado2 = "ok2";
		} catch(SQLException ex) {
	                System.err.print("SQLException: ");
                        System.err.println(ex.getMessage());
			resultado2 = "fail2";	}

			resultado = resultado1 + "  " + resultado2;
			return resultado;
        }

	public void leituraDoBanco() {
		try {
			//Leitura (SELECT)
			stmt = connection.createStatement(); 
			ResultSet rs = stmt.executeQuery(leitura); 
			
			rs.next();
			valorLido = rs.getString(1);
			//System.out.println("Modelo extraído da Xwiki:\n\n"+valorLido);

			
		   	stmt.close(); 
		   	

			
		} catch(SQLException ex) { 
			System.err.print("SQLException: "); 
		   	System.err.println(ex.getMessage());} 
	}
	public void escritaDoModelo() {
		//Escrever o Modelo lido do banco num arquivo
		try{
			FileWriter writer = new FileWriter("/home/david/comdd/ANTLR_Codigos/jar/DSL-LRM/classes/Modelo/Modelo");
			writer.write(valorLido);
			writer.close(); 
			//System.out.println("@@ Foi criado um arquivo com o modelo extraído da Xwiki.................");
		} catch(IOException ex) {
			ex.printStackTrace();}
	}
	
	public void leituraDoArquivoCodigoGerado() {
		try {
                        File myFile = new File("CodigoGerado.cpp");
                        FileReader fileReader = new FileReader(myFile);
                        BufferedReader reader = new BufferedReader(fileReader);
                        String line = null;
                        while ((line = reader.readLine()) != null) {
                                System.out.println(line);
                                codigoGeradoPelaDsl = codigoGeradoPelaDsl + "\n" + line;
	                }
			System.out.println("O codigo foi armazenado com sucesso: \n"+codigoGeradoPelaDsl);
                        reader.close();
                } catch(Exception ex) {
                        ex.printStackTrace();
                }

	}

	public void escritaNoBanco() {
			String escrita = "UPDATE xwikidoc SET xwd_content='" + codigoGeradoPelaDsl + "' where xwd_name='CodigoGerado'";
			try{
				stmtUpdate = connection.createStatement(); 
				stmtUpdate.executeUpdate(escrita);
				System.out.println("Valor Alterado para: \n" + codigoGeradoPelaDsl);
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
