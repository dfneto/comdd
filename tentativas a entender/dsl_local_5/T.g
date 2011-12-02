grammar T;
options {output=template;}
@header {import org.antlr.stringtemplate.*;}

robo	
scope {
	List cabList;
	List senList;
}
@init {
	$robo::cabList = new ArrayList();
	$robo::senList = new ArrayList();
}
	: declaration+ -> classe(cab={$robo::cabList}, sen={$robo::senList})
	;

declaration : 'robo' nomeRobo=ID cabecalho* sensor*  //{$robo::cabList.add($cabecalho.st);}
	;

cabecalho:
	'adicionar' itensCabecalho=(
	   'defines' -> define() | 'includes' -> include() )
	{$robo::cabList.add($cabecalho.st);}
	;
	
sensor:
	'criarSensor' tipoSensor
	;
	
tipoSensor returns [String value]: 
	('gps' {$tipoSensor.value = "gps";} -> gps()
	| 'bussola' {$tipoSensor.value = "bussola";} -> bussola() )
//	('gps' {$tipoSensor.value = "gps";} -> gps()
//	| 'bussola' {$tipoSensor.value = "bussola";} -> bussola() )
	{$robo::senList.add($tipoSensor.st);}
	;


	

ID: 'a'..'z'+ ;
INT:'0'..'9'+ ;
WS :(' '|'\t'|'\n'|'\r') {skip();} ;

