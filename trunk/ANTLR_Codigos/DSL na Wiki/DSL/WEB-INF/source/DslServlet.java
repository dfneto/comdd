//A classe DslServlet é um servlet responsável por chamar os métodos da classe Auxiliar. Substitui a classe Principal que faz a mesma coisa só que localmente

import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
import java.sql.*;  


public class DslServlet extends HttpServlet{  
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 	throws IOException, ServletException {  
	 	// implementação da Servlet...  
  		// definindo o tipo de conteudo 
		// que será devolvido pelo response
		response.setContentType("text/html");

		// pegamos o PrintWriter do response, através 
		// do qual escreveremos o conteudo da pagina
		PrintWriter out = response.getWriter();

		//Ações de Auxiliar		
		Auxiliar aux = new Auxiliar();
		aux.estabelecerConexaoComBanco();
		aux.leituraDoBanco();
		aux.escritaDoModelo();
		
		//Executando a DSL (transformação do modelo em código)
		ExecutarDsl dsl = new ExecutarDsl();
		String resultExecucaoDsl; //da execução da dsl	
		try{	
			dsl.executeDsl();
			resultExecucaoDsl = "DSL executada com sucesso"; 
	
		} catch (Exception e) {
			System.out.println("Fodeo");
			resultExecucaoDsl = "DSL Não executada com sucesso"; }		

		aux.leituraDoArquivoCodigoGerado();		
		aux.escritaNoBanco();
		aux.encerrarConexao();
		
		// Escrevendo o conteudo da pagina
		out.println("<HTML>");
		out.println("<BODY>");
		out.println("<H1>DSL Rodando!</h1>");
		out.println(aux.resultDriverBanco);
		out.println("<br><br>");
		out.println(aux.resultConexaoBanco);
		out.println("<br><br><br>");
		out.println("Valor Lido: "+aux.valorLido);
		out.println("<br><br>");
		out.println(aux.resultEscritaModelo);
		out.println("<br><br>");
		out.println(resultExecucaoDsl);
		out.println("<br><br>");
		out.println("Codigo Gerado: "+aux.codigoGeradoPelaDsl);
		out.println("<br><br>");
		out.println(aux.resultEscritaBanco);
		out.println("<br><br>");
		out.println(aux.resultFimConexao);
		out.println("<br><br>");
		out.println("</body>");
		out.println("</html>");

} 
    }  

