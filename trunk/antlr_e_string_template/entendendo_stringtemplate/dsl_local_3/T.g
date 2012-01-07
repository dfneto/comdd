grammar T;
options {output=template;}
@header {import org.antlr.stringtemplate.*;}

robo	: stat+ regra-> cabecalho(entrada={$stat.st}, entrada1={$regra.st})
	;

stat 	: dir=ID '=' vel=INT ';' -> robo4()

// -> robo2(direcao={$dir.text}, velocidade={$vel.text}) 
	;

//regra : 'mais ' ang=INT -> {$robo4.st};

regra : 'mais ' ang=INT -> robo3(angulo={$ang.text}, direcao={3});


ID: 'a'..'z'+ ;
INT:'0'..'9'+ ;
WS :(' '|'\t'|'\n'|'\r') {skip();} ;

