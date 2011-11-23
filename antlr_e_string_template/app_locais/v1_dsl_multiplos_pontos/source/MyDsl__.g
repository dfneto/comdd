lexer grammar MyDsl;
options {
  language=Java;

}

T6 : 'robo' ;
T7 : '<' ;
T8 : '>' ;
T9 : 'plataforma' ;
T10 : 'pioneer' ;
T11 : 'srv' ;
T12 : 'golfe' ;
T13 : 'adicionar' ;
T14 : 'defines' ;
T15 : 'includes' ;
T16 : 'criarSensor' ;
T17 : 'gps' ;
T18 : 'bussola' ;
T19 : 'camera' ;
T20 : 'int main()' ;
T21 : '{' ;
T22 : '}' ;
T23 : 'while' ;
T24 : '(true)' ;
T25 : '.' ;
T26 : 'ligar();' ;
T27 : 'ler();' ;
T28 : 'carregarListaCoordenadas();' ;
T29 : 'recebeCoordenada();' ;
T30 : 'obterImagem();' ;
T31 : 'processarImagem();' ;
T32 : 'defineAtirar();' ;
T33 : 'andar();' ;
T34 : 'naoBater();' ;
T35 : 'seguir();' ;

// $ANTLR src "source/MyDsl.g" 183
ID: 'a'..'z' + ;
// $ANTLR src "source/MyDsl.g" 184
WS: (' ' |'\n' |'\r' )+ {skip();} ; // ignore whitespace



















