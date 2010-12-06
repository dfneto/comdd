lexer grammar MyDsl;
options {
  language=Java;

}

T6 : 'robo' ;
T7 : 'criarSensor' ;
T8 : 'gps' ;
T9 : 'bussola' ;

// $ANTLR src "MyDsl.g" 29
ID: 'a'..'z' + ;
// $ANTLR src "MyDsl.g" 30
WS: (' ' |'\n' |'\r' )+ {skip();} ; // ignore whitespace
