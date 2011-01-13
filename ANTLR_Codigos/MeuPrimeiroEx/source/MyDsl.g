grammar MyDsl;
options {
language=Java;
}
@members {
String s;
}


prog: stat+;

stat: 'robo' nomeRobo=ID cabecalho*  sensor* {System.out.println ("Robo " +$nomeRobo.text+ " criado com sucesso!! ");} ;


cabecalho:
	'Adicionar' itensCabecalho=(
		'defines' {System.out.println("Defines Adicionados!!");}
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

