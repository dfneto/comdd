grammar T;
//options {language=Java;}
//options {output=template;}
robo:  s+;
//s : ID '=' INT ';' -> assign(x={$ID.text},y={$INT.text}) ;
//<<"imprima X=<x> e Y=<y>>>  ; 

s	:	assignStat;

assignStat
    :   ID '=' expr  -> assign(lhs={$ID.text}, rhs={$expr.st})
    ;

expr:   condExpr //-> {$condExpr.st}
    ;

condExpr
    :   a=aexpr
        (   (  '==' b=aexpr // -> equals(left={$a.st},right={$b.st})
            |  '<' b=aexpr  // -> lessThan(left={$a.st},right={$b.st})
            )
        //|   -> {$a.st} // else just aexpr
        )
    ;

aexpr
    :   (a=atom) //-> {$a.st})
        ( '+' b=atom) //-> add(left={$aexpr.st}, right={$b.st}) )*
    ;

atom
    : ID //-> refVar(id={$ID.text})
    | INT //-> iconst(value={$INT.text})
    | '(' expr ')' //-> {$expr.st}
    ; 
    






//s : v | 'robo' ID ('=' INT)* ';'  -> assign(x={$ID.text},y={$INT.text});

//v	:	'nave' ID ';' -> {System.out.println("Aqui!!!");} -> assign1(x={$ID.text});
/*
d	: declaration ID  ';' -> assign(x={$ID.text},y={$INT.text}) 
	;
	
declaration: 'robo' ID -> robo(z={$ID.text})
	 ;

v	: 'robo' ID ';'	-> robo2()
	;

*/


ID: 'a'..'z'+ ;
INT:'0'..'9'+ ;
WS :(' '|'\t'|'\n'|'\r') {skip();} ;

