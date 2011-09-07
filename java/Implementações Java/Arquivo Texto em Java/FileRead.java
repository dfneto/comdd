import java.io.*;
 
class FileRead{
	public static void main(String[] args){
		try{
			File file = new File("file.txt");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String data = br.readLine();
			while(br.ready()){
				data += " ";
				data += br.readLine();				
			}
			System.out.println(data);
			br.close();
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
	}
}
