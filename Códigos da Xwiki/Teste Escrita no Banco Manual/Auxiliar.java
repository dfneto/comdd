import java.sql.*;
import java.io.*;

public class Auxiliar {

		Connection connection = null;
		String leitura = "select xwd_content from xwikidoc where xwd_name='TesteNome'"; 
		String valorLido = null; //valorLido a partir da string de leitura
		Statement stmt; 		
		String url = "jdbc:postgresql://localhost:5432/xwiki";
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
			connection = DriverManager.getConnection(url,"xwiki", "xwiki"); 
			resultConexaoBanco = "Conexao estabelecida";
		} catch(SQLException ex) {
	                System.err.print("SQLException: ");
                        System.err.println(ex.getMessage());
			resultConexaoBanco = "Conexão Não Estabelecida";	}
        }

	public void escritaNoBanco(String modeloDaXwiki) {
			String escrita = "UPDATE xwikidoc SET xwd_content='" + modeloDaXwiki + "' where xwd_name='TesteEdicaoSimultanea'";
			try{
				stmtUpdate = connection.createStatement(); 
				stmtUpdate.executeUpdate(escrita);
				stmtUpdate.close();
				resultEscritaBanco ="Modelo escrito no banco";
			} catch(SQLException ex) { 
				System.err.print("SQLException: "); 
		   		System.err.println(ex.getMessage());
				resultEscritaBanco ="Modelo Não escrito no banco";} 
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
