lexer grammar MyDsl;

T6 : 'robo' ;
T7 : 'Adicionar' ;
T8 : 'defines' ;
T9 : 'includes' ;
T10 : 'criarSensor' ;
T11 : 'gps' ;
T12 : 'bussola' ;

// $ANTLR src "source/MyDsl.g" 61
ID: 'a'..'z' + ;
// $ANTLR src "source/MyDsl.g" 62
WS: (' ' |'\n' |'\r' )+ {skip();} ; // ignore whitespace

