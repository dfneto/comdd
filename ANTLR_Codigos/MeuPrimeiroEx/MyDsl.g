grammar MyDsl;
options {
language=Java;
}
@members {
String s;
}


prog: stat+;

stat: 'robo' nomeRobo=ID sensor {System.out.println ("Robo " +$nomeRobo.text+ " criado com sucesso!! \n ");}; //Valor do $tipoSensor = "+$tipoSensor.text );} ;

sensor:
	'criarSensor' tipoSensor;



tipoSensor: ('gps' | 'bussola')
	{if ($tipoSensor.text == "gps")
		System.out.println("GPS criado com sucesso!");
	else 
		System.out.println("Compass criado com sucesso!");
	System.out.println("Valor do $tipoSensor = " +$tipoSensor.text);
	}
	;

/*tipoSensor returns [string value]:
	('gps' | 'bussola');
*/


/*name=ID r;
r: 'robo' name2=ID {System.out.println("O nome do robo eh: "+$name2.text);};
*/
ID: 'a'..'z' + ;
WS: (' ' |'\n' |'\r' )+ {skip();} ; // ignore whitespace

