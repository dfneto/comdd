grammar T;
options {output=template;}
s : ID '=' INT ';' -> assign(x={$ID.text},y={$INT.text}) ;
ID: 'a'..'z'+ ;
INT:'0'..'9'+ ;
WS :(' '|'\t'|'\n'|'\r') {skip();} ;

