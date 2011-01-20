//Código extraído do JavaHeadFirst

import java.io.*;

class Lendo {
	public static void main (String[] args) {
		String CodigoGeradoPelaDsl = "";
		try {
			File myFile = new File("CodigoGerado.txt");
			FileReader fileReader = new FileReader(myFile);

			BufferedReader reader = new BufferedReader(fileReader);

			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				CodigoGeradoPelaDsl = CodigoGeradoPelaDsl + "\n" + line;
			}
			System.out.println("O codigo foi armazenado com sucesso: \n"+CodigoGeradoPelaDsl);
			reader.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
}
}
