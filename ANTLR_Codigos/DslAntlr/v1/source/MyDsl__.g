lexer grammar MyDsl;
options {
  language=Java;

}

T6 : 'robo' ;
T7 : 'plataforma' ;
T8 : 'pioneer' ;
T9 : 'srv' ;
T10 : 'golfe' ;
T11 : 'adicionar' ;
T12 : 'defines' ;
T13 : 'includes' ;
T14 : 'criarSensor' ;
T15 : 'gps' ;
T16 : 'bussola' ;
T17 : 'camera' ;
T18 : 'int main()' ;
T19 : '{' ;
T20 : '}' ;
T21 : 'while' ;
T22 : '(true)' ;
T23 : '.' ;
T24 : 'ligar();' ;
T25 : 'ler();' ;
T26 : 'carregarListaCoordenadas();' ;
T27 : 'recebeCoordenada();' ;
T28 : 'obterImagem();' ;
T29 : 'processarImagem();' ;
T30 : 'defineAtirar();' ;
T31 : 'andar();' ;
T32 : 'naoBater();' ;
T33 : 'seguir();' ;

// $ANTLR src "source/MyDsl.g" 164
ID: 'a'..'z' + ;
// $ANTLR src "source/MyDsl.g" 165
WS: (' ' |'\n' |'\r' )+ {skip();} ; // ignore whitespace



















