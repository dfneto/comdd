grammar MyDsl;
options {
language=Java;
}
@members {
String s;
}


prog: stat+;

stat: 'robo' sensor;

sensor:
	'criarSensor' tipoSensor=('gps' | 'bussola') ;

/*name=ID r;
r: 'robo' name2=ID {System.out.println("O nome do robo eh: "+$name2.text);};
*/
ID: 'a'..'z' + ;
WS: (' ' |'\n' |'\r' )+ {skip();} ; // ignore whitespace

