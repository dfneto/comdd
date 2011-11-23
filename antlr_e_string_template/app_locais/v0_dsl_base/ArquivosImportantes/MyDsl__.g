lexer grammar MyDsl;
options {
  language=Java;

}

T6 : 'robo' ;
T7 : 'Adicionar' ;
T8 : 'defines' ;
T9 : 'includes' ;
T10 : 'criarSensor' ;
T11 : 'gps' ;
T12 : 'bussola' ;

// $ANTLR src "MyDsl.g" 39
ID: 'a'..'z' + ;
// $ANTLR src "MyDsl.g" 40
WS: (' ' |'\n' |'\r' )+ {skip();} ; // ignore whitespace

