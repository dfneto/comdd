grammar MyDsl;
options {output=template;}
@header {import org.antlr.stringtemplate.*;}
@members {
	String plat;
	String sensor;
	String sensorCriado;
}

robo
scope {
	List cabList;
	List senList;
	List mainList;
	List pacList;
}
@init{
	$robo::cabList = new ArrayList();
	$robo::pacList = new ArrayList();
	$robo::senList = new ArrayList();
	$robo::mainList = new ArrayList();
}	
	: stat+ -> classe(cab={$robo::cabList}, pacote={$robo::pacList}, sen={$robo::senList}, main={$robo::mainList})
	;

stat:	plataforma 
	'robo' nomeRobo=ID 
	cabecalho* 
	pacote*
	sensor* 
	main  
	;


//*******************************************/
//***DEFININDO A PLATAFORMA*****************/
//*****************************************/
plataforma : 
	'plataforma' nomeDaPlataforma ;

nomeDaPlataforma
//scope{ String name; }
:	 plat=( 'pioneer'  
	      | 'srv'  
	      | 'golfe' )
//	{$nomeDaPlataforma::name=$ID.text;}
	;

//*******************************************/
//***DEFINES, INCLUDES E PACOTES************/
//*****************************************/
cabecalho:
	'adicionar' itensCabecalho=(
		'defines' -> define() 
		| 'includes' -> include() )
//	'adicionar defines' ({$nomeDaPlataforma::name == null}? -> definePionner())
//			    -> defineSrv() )
		{$robo::cabList.add($cabecalho.st);}	
	;

pacote	:	
	'importar pacote' ( 'player;' -> pacotePlayer()
			  | 'localizacao;' -> pacoteLocalizacao() )
			  {$robo::pacList.add($pacote.st);}	
	;
//*******************************************/
//***DEFININDO SENSORES*********************/
//*****************************************/
sensor:
	'criarSensor' tipoSensor {$robo::senList.add($tipoSensor.st);};

tipoSensor 
	:	'gps' -> gps()
	| 	'bussola'-> bussola() 
	| 	'camera'-> camera() 
	;
	
//*******************************************/
//***MAIN***********************************/
//*****************************************/
main:
	('int main()' '{' -> mainTemplate()) {$robo::mainList.add($main.st);}  loop '}'
	;


loop:
	(inicializacaoSensor)*	
	( 'while' '(true)' '{'  -> while() )  {$robo::mainList.add($loop.st);}
	(entrada | processamento | comportamento | acao)*
	'}' 
	;

//*******************************************/
//***MAIN->INICIALIZAÇÃO********************/
//*****************************************/
inicializacaoSensor : 
			(WS)*
			( 'gps.ligar();' 		-> gpsLigar() 
			| 'bussola.ligar();' 		-> bussolaLigar()
			| 'camera.ligar();'		-> cameraLigar()
			| 'carregarListaCoordenadas();' -> carregarListaCoordenadas() 
			| 'inicializarPlayer();'   	-> inicializarPlayer() )
			{$robo::mainList.add($inicializacaoSensor.st);}
			;


//*******************************************/
//***MAIN->ENTRADA**************************/
//*****************************************/
entrada:
		( 'gps.ler();' -> gpsLer() 
		| 'bussola.ler();' -> bussolaLer()
		| 'camera.ler();' -> cameraLer()
		| 'receberCoordenada();' -> receberCoordenada()
		| 'carregarListaCoordenadas();' -> carregarListaCoordenadas() )
		{$robo::mainList.add($entrada.st);}
		;


//*******************************************/
//***MAIN->PROCESSAMENTO********************/
//*****************************************/
processamento :	
		( 'processaInfo();' -> processaInfo()
		| 'processaImagem();' -> processaImagem() )	
		{$robo::mainList.add($processamento.st);}
	;


//*******************************************/
//***MAIN->COMPORTAMENTO********************/
//*****************************************/

acao:
	andar
	;
comportamento :	
		( 'defineRegra();' -> defineRegra()
		| 'defineRegraSeguir();' -> defineRegraSeguir()
		| 'defineRegraNaoBater();' -> defineRegraNaoBater() 
		| 'defineRegraSeguirMultiplasCoordenadas();' -> defineRegraSeguirMultiplasCoordenadas() )
		{$robo::mainList.add($comportamento.st);}
	;
	
	
//*******************************************/
//***MAIN->ACAO*****************************/
//*****************************************/

andar	:	('andar();' -> andar()) {$robo::mainList.add($andar.st);}
	;

ID: 'a'..'z' + ;
WS: (' ' |'\n' |'\r' | '\t' )+ {skip();} ; // ignore whitespace



















