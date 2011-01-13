import java.io.*;
 
class FileWriter3{
	public static void main(String[] args){
		try{
			File file = new File("file.txt");
			FileWriter fw = new FileWriter(file);
			PrintWriter pw = new PrintWriter(fw);
			pw.println("Ricardo");
			pw.println("Ramos");
			pw.println("de");		
			pw.println("Oliveira");	
			pw.flush();
          		pw.close();	
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
	}
}
