grammar MyDsl;
@header{
import java.io.*;
}

@members {
String s;
}


prog: stat+;

stat: 'robo' nomeRobo=ID cabecalho*  sensor* {System.out.println ("Robo " +$nomeRobo.text+ " criado com sucesso!! ");} ;


cabecalho:
	'Adicionar' itensCabecalho=(
		'defines' {
			System.out.println("Falhou1!!");
			class Writer2{
			public void main(String[] args){
			char[] in = new char[50];
			int size = 0;
			System.out.println("Falhou2!!");
		try{
			System.out.println("Defines Adicionados!!");
			File file = new File("file.txt");
			FileWriter fw = new FileWriter(file);
			PrintWriter pw = new PrintWriter(fw);
			pw.println("Ricardo");
			pw.println("Ramos");
			pw.println("de");		
			pw.println("Oliveira");	
			pw.flush();
          		pw.close();}
		catch(IOException ex){
			System.out.println("Falhouuuuuu!!");
			ex.printStackTrace();}
		}}}
	      | 'includes'{System.out.println("Includes Adicionados!!");})
	;
sensor:
	'criarSensor' tipoSensor;



tipoSensor returns [String value]: 
	('gps' {$tipoSensor.value = "gps";
		System.out.println("GPS criado com sucesso!");}
	| 'bussola' {$tipoSensor.value = "bussola";
		System.out.println("Compass criado com sucesso!");} )
	{System.out.println("Valor do $tipoSensor = " +$tipoSensor.value);}
	;
	

/*name=ID r;
r: 'robo' name2=ID {System.out.println("O nome do robo eh: "+$name2.text);};
*/
ID: 'a'..'z' + ;
WS: (' ' |'\n' |'\r' )+ {skip();} ; // ignore whitespace

