import gerador.GeradorDoDavid;
import gerador.Programa;


public class Testando {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Programa p = new Programa();
		p.plataforma = "Golfe";
		
		GeradorDoDavid g = new GeradorDoDavid();
		 String result = g.generate(p);
		 System.out.println(result);


	}

}

