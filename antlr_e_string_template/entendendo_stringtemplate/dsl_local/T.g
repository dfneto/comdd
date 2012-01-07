grammar T;
options {
output=template;
}
@header {
import org.antlr.stringtemplate.*;
}

robo: declaration+;

declaration:
	'robo' cabecalho
	;

cabecalho:
	'define'  
	| 'include'
	;

ID: 'a'..'z'+ ;
INT:'0'..'9'+ ;
WS :(' '|'\t'|'\n'|'\r') {skip();} ;

