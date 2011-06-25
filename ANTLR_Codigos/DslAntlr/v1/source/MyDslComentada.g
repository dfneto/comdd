grammar MyDsl;
options {
language=Java;
}
//@header{package source;}
@members {
String linguagem;
String sensor;
String sensorCriado;
}


prog: stat+;

/*stat: 'robo' nomeRobo=ID
	cabecalho*  
	sensor* 
	main
	{System.out.println ("Robo " +$nomeRobo.text+ " criado com sucesso!!");} 
	;
*/

stat:	linguagem 
	'robo' nomeRobo=ID 
	cabecalho* 
	sensor* 
	main 
	{System.out.println ("Robo " +$nomeRobo.text+ " criado com sucesso!!");}
	;//linguagemGerada;

linguagem : 
	'linguagem' nomeDaLinguagem ;

nomeDaLinguagem:// returns [String s]:
//	{s=5;}
//	{System.out.println ("Valor de s1: " +linguagem);}

	(
	 'c++' {linguagem = "c++";} |
	 'java' {linguagem = "java"; } 
	)
	{System.out.println ("1.Linguagem escolhida: " +linguagem);}

	;

linguagemGerada : 
//	{if (s == 4)
	{if (linguagem == "java")
		System.out.println("2.A linguagem vai ser gerada em JAVA---------- " +linguagem);}		
//		{System.out.println("Valor de s:" +s);}
	{if (linguagem == "c++")
		System.out.println("2.A linguagem vai ser gerada em C++ ----------" +linguagem);}		
//		{System.out.println("Valor de s no else:" +s);}	
//	}

	{System.out.println("3.LINGUAGEM : " +linguagem);}		
	;


cabecalho:
	'adicionar' itensCabecalho=(
		'defines' {System.out.println("Defines Adicionados!!");}
	      | 'includes'{System.out.println("Includes Adicionados!!");})
	;
sensor:
	'criarSensor' tipoSensor;



tipoSensor: 
	s=(
	 'gps' {sensor = "gps";} |
	 'bussola' {sensor = "bussola";}
	 )
	{System.out.println("Código para inicializar o/a " +sensor+ " vem aqui");}
	;
	

main:
	'int main()' '{' {System.out.println("int main() {");} loop 		'}' {System.out.println("}");} 
	;

loop:
	'while' '(true)' '{' {System.out.println("while(true) {");} 
	(comportamento | acoes)*
	'}' {System.out.println("}");} 
	;


comportamento:
	sensorCriado '.' //o tipoSensor tem que ser um sensor ja criado 
	acaoSensor
	;

sensorCriado:
	s=(
	 'gps' {sensorCriado = "gps";} |
	 'bussola' {sensorCriado = "bussola";}
	 )
	;


acaoSensor:
	ligar | ler | carregarListaCoordenadas | obterImagem 
	;

ligar:
	'ligar();' {System.out.println("O sensor " +sensorCriado+ " foi ligado");}
	;

ler:
	'ler();' {System.out.println("O sensor " +sensorCriado+ " está lendo");}
	;

carregarListaCoordenadas:
	'carregarListaCoordenadas();' {System.out.prinln("Código da lista de coordenadas vem aqui");}
	;

obterImagem:
	'obterImagem();' {System.out.prinln("Código de obter imagem vem aqui");}
	;
	
acoes:
	processarImagem | defineAtirar | atuar
	;

processarImagem:
	'processarImagem();' {System.out.prinln("O robo está processando a imagem......");}
	;

defineAtirar:
	'defineAtirar();' {System.out.prinln("O robo está atirando......");}
	;

atuar:
	'atuar();' {System.out.prinln("O robo está atuando......");}
	;


/*name=ID r;
r: 'robo' name2=ID {System.out.println("O nome do robo eh: "+$name2.text);};
*/
ID: 'a'..'z' + ;
WS: (' ' |'\n' |'\r' )+ {skip();} ; // ignore whitespace



















