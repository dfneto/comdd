//Comportamento é referente aos sensores, ou seja, que comportamento os sensores têm
//Ação é referente ao robo, ou seja, o que o robô pode fazer: processar, andar ...
grammar MyDsl;
options {
	language=Java;
}
@members {
	String plataforma;
	String sensor;
	String sensorCriado;
}


prog: stat+;

stat:	plataforma 
	'robo' nomeRobo=ID 
	link*
	cabecalho* 
	sensor* 
	main 
	{System.out.println ("Robo " +$nomeRobo.text+ " criado com sucesso!!");}
	;

link:
	'<' nomeLink=ID '>'
	{System.out.println("[["+$nomeLink.text+"]]");}
	;


//*******************************************/
//***DEFININDO A PLATAFORMA*****************/
//*****************************************/
plataforma : 
	'plataforma' nomeDaPlataforma ;

nomeDaPlataforma:
	(
	 'pioneer' {plataforma = "pioneer";} |
	 'srv' {plataforma = "srv";} |
	 'golfe' {plataforma = "golfe";} 
	)
	{System.out.println ("Plataforma escolhida: " +plataforma);}
	;

//*******************************************/
//***DEFINES E INCLUDES*********************/
//*****************************************/
cabecalho:
	'adicionar' itensCabecalho=(
		'defines' {
				if (plataforma == "pioneer")
				System.out.println("Defines Adicionados para plataforma Pioneer......................");
				if (plataforma == "srv")
				System.out.println("Defines Adicionados para plataforma SRV......................");
				if (plataforma == "golfe")
				System.out.println("Defines Adicionados para plataforma Carro de golfe......................");
				
		} | 
		'includes'{
				if (plataforma == "pioneer")
					System.out.println("Includes Adicionados para plataforma Pioneer......................");
				if (plataforma == "srv")
					System.out.println("Includes Adicionados para plataforma SRV......................");
				if (plataforma == "golfe")
					System.out.println("Includes Adicionados para plataforma Carro de golfe......................");
		} 
	)
	;

//*******************************************/
//***DEFININDO SENSORES*********************/
//*****************************************/

sensor:
	'criarSensor' tipoSensor;

tipoSensor: 
	s=(
	 'gps' {sensor = "gps";} |
	 'bussola' {sensor = "bussola";} |
	 'camera' {sensor = "camera";} 
	 )
	{System.out.println("Código para inicializar o/a " +sensor+ " vem aqui");}
	;
	
//*******************************************/
//***MAIN***********************************/
//*****************************************/

main:
	'int main()' '{' {System.out.println("int main() {");} loop '}' {System.out.println("}");} 
	;

loop:
	(comportamento | acoes)*	
//	'while' '(true)' '{' {System.out.println("\twhile(true) {");}
	'while' '(true)' '{' {System.out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;while(true) {");}  
	(comportamento | acoes)*
//	'}' {System.out.println("\t}");} 
	'}' {System.out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}");} 
	;

//*******************************************/
//***MAIN->COMPORTAMENTO********************/
//*****************************************/

comportamento:
	sensorCriado '.' //o tipoSensor tem que ser um sensor ja criado 
	acaoSensor
	;

sensorCriado:
	 'gps' {sensorCriado = "gps";} |
	 'bussola' {sensorCriado = "bussola";} |
	 'camera' {sensorCriado = "camera";}
	 ;


acaoSensor:
	ligar | ler | carregarListaCoordenadas | recebeCoordenada | obterImagem 
	;

ligar:
//	'ligar();' {System.out.println("\t\tO sensor " +sensorCriado+ " foi ligado");}
	'ligar();' {System.out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;O sensor " +sensorCriado+ " foi ligado");}
	;

ler:
//	'ler();' {System.out.println("\t\tO sensor " +sensorCriado+ " está lendo");}
	'ler();' {System.out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;O sensor " +sensorCriado+ " está lendo");}
	;

carregarListaCoordenadas:
//	'carregarListaCoordenadas();' {System.out.println("\t\tCódigo da lista de coordenadas vem aqui");}
	'carregarListaCoordenadas();' {System.out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Código da lista de coordenadas vem aqui");}
	;

recebeCoordenada:
//	'recebeCoordenada();' {System.out.println("\t\tCódigo para receber uma coordenada apenas vem aqui");}
	'recebeCoordenada();' {System.out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Código para receber uma coordenada apenas vem aqui");}
	;

obterImagem:
//	'obterImagem();' {System.out.println("\t\tCódigo de obter imagem vem aqui");}
	'obterImagem();' {System.out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Código de obter imagem vem aqui");}
	;

//*******************************************/
//***MAIN->ACOES****************************/
//*****************************************/
	
acoes:
	processarImagem | defineAtirar | atuar | regra
	;

processarImagem:
//	'processarImagem();' {System.out.println("\t\tO robo está processando a imagem......");}
	'processarImagem();' {System.out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;O robo está processando a imagem......");}
	;

defineAtirar:
//	'defineAtirar();' {System.out.println("\t\tO robo está atirando......");}
	'defineAtirar();' {System.out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;O robo está atirando......");}
	;

atuar:
//	'andar();' {System.out.println("\t\tO robo está andando......");}
	'andar();' {System.out.println("\t\tO robo está andando......");}
	;

regra:
//	'naoBater();' {System.out.println("\t\tO robo nao pode bater......");} |
//	'seguir();' {System.out.println("\t\tO robo deve seguir......");}
	'naoBater();' {System.out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;O robo nao pode bater......");} |
	'seguir();' {System.out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;O robo deve seguir......");}
	;


/*name=ID r;
r: 'robo' name2=ID {System.out.println("O nome do robo eh: "+$name2.text);};
*/
ID: 'a'..'z' + ;
WS: (' ' |'\n' |'\r' )+ {skip();} ; // ignore whitespace



















