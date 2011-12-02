grammar T;
options {output=template;}
@header {import org.antlr.stringtemplate.*;}

robo	: stat+;

stat 	: variable  | function;


variable : type declarator ';' -> robo2(type={$type.st}, name={$declarator.st});

function : type ID;

declarator : ID;

type	: 'int' -> type_int()
	| 'char' -> type_char()
	;


ID: 'a'..'z'+ ;
INT:'0'..'9'+ ;
WS :(' '|'\t'|'\n'|'\r') {skip();} ;

