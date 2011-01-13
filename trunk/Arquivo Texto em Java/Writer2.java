import java.io.*;
 
class Writer2{
	public static void main(String[] args){
		char[] in = new char[50];
		int size = 0;
		try{
			File file = new File("fileWriter2.txt");
			FileWriter fw = new FileWriter(file);
			fw.write("Ricardo Ramos de Oliveira");
			fw.flush();
			fw.close();
			FileReader fr = new FileReader(file);
			fr.read(in);
			//System.out.println(size + " ");
			//for(char c: in){				
				System.out.print(in[6]);
				System.out.print(in[7]);
				System.out.print(in[8]);
			//}
			System.out.println();
			fr.close();			
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
	}
}
