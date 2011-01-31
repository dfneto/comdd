//A classe DslServlet é um servlet responsável por chamar os métodos da classe Auxiliar

import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
import java.sql.*;   


public class DslServlet extends HttpServlet{  
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 	throws IOException, ServletException {  
	 	// implementação da Servlet...  
  		// vamos definir o tipo de conteudo 
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
		dsl.executeDsl(); 

		Printer p = new Printer();
		
	        

		// Agora vamos escrever o conteudo da pagina
		out.println("<HTML>");
		out.println("<BODY>");
		out.println("<H1>DSL Rodando!</h1>");
		out.println("String de leitura:"+aux.leitura);	
		out.println("<br><br><br>");
		out.println("Valor lido:"+aux.valorLido);			
		out.println("<br><br><br>");
		//método que mostra uma mensagem na página:
		out.println(aux.estabelecerConexaoComBanco());
		//out.println(p.imprimaOk());
		//out.println(aux.leitura);
		//out.println(aux.imprimirOk());		
		//método que criar um arquivo 
		
		out.println("</body>");
		out.println("</html>");

} 
    }  

