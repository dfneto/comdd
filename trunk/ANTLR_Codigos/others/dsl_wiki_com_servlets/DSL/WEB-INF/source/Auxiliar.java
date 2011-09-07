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
		String resultDriverBanco; //do carregamento do driver do banco
		String resultConexaoBanco; 
		String resultEscritaModelo;
		String resultEscritaBanco; 
	 	String resultFimConexao; //da conexao com o banco
	
	public void estabelecerConexaoComBanco() {
		//Carregando o Driver do Postgres
		try {
 			Class.forName("org.postgresql.Driver"); 
			resultDriverBanco = "Driver Carregado";			
		} catch (ClassNotFoundException e) {
 			System.out.println("Where is your PostgreSQL JDBC Driver? \n Include in your library path!");
			e.printStackTrace();
			resultDriverBanco = "Driver Não Carregado";	}
		//estabelecendo conexão com o banco		
		try {	 
			connection = DriverManager.getConnection(url,"postgres", "12345"); 
			resultConexaoBanco = "Conexao estabelecida";
		} catch(SQLException ex) {
	                System.err.print("SQLException: ");
                        System.err.println(ex.getMessage());
			resultConexaoBanco = "Conexão Não Estabelecida";	}
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
			FileWriter writer = new FileWriter("/home/david/Xwiki/apache-tomcat-6.0.30/webapps/DSL/WEB-INF/classes/Modelo/Modelo");
			writer.write(valorLido);
			writer.close(); 
			resultEscritaModelo= "Modelo Gravado";
		} catch(IOException ex) {
			ex.printStackTrace();
			resultEscritaModelo= "Modelo Não Gravado";}
	}
	
	public void leituraDoArquivoCodigoGerado() {
		try {
                        File myFile = new File("/home/david/Xwiki/apache-tomcat-6.0.30/webapps/DSL/WEB-INF/classes/Modelo/CodigoGerado.cpp");
                        FileReader fileReader = new FileReader(myFile);
                        BufferedReader reader = new BufferedReader(fileReader);
                        String line = null;
                        while ((line = reader.readLine()) != null) {
                                System.out.println(line);
                                codigoGeradoPelaDsl = codigoGeradoPelaDsl + "\n" + line;
	                }
			reader.close();
                } catch(Exception ex) {
                        ex.printStackTrace(); }

	}

	public void escritaNoBanco() {
			String escrita = "UPDATE xwikidoc SET xwd_content='" + codigoGeradoPelaDsl + "' where xwd_name='CodigoGerado'";
			try{
				stmtUpdate = connection.createStatement(); 
				stmtUpdate.executeUpdate(escrita);
				stmtUpdate.close();
				resultEscritaBanco ="Codigo escrito no banco";
			} catch(SQLException ex) { 
				System.err.print("SQLException: "); 
		   		System.err.println(ex.getMessage());
				resultEscritaBanco ="Codigo Não escrito no banco";} 
	}
	public void encerrarConexao() {
		try{
			connection.close(); 
			resultFimConexao="Conexao com banco encerrada";
		} catch(SQLException ex) { 
			System.err.print("SQLException: "); 
			System.err.println(ex.getMessage());
			resultFimConexao="Conexao com banco Nao encerrada";} 
	/*public void gerarArquivoComCodigoFonteGerado() {
		
	}*/
	
	}
}
