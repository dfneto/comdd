grammar Calculator;
options {
  language = Ruby;
}

evaluate returns [result]: r=expression { result = r };

expression returns [result]: r=mult (
    '+' r2=mult {
        r += r2
    }
  | '-' r2=mult {
        r -= r2
    }
  )* { result = r };

mult returns [result]: r=log (
    '*' r2=log {
        r *= r2
    }
  | '/' r2=log {
        r /= r2
    }
  | '%' r2=log {
        r %= r2
    }
  )* { result = r };

log returns [result]: 'ln' r=exp { result = Math::log(r) }
    | r=exp { result = r }
    ;

exp returns [result]: r=atom ('^' r2=atom { r = r ** r2 } )? { result = r }
    ;

atom returns [result]:
    n=INTEGER { result = $n.text.to_i }
  | n=DECIMAL { result = $n.text.to_f } 
  | '(' r=expression { result = r } ')'
  | 'PI' { result = Math::PI }
  | 'E' { result = Math::E }
  ;

INTEGER: DIGIT+;

DECIMAL: DIGIT+ '.' DIGIT+;

fragment
DIGIT: '0'..'9';

WS: (' ' | '\n' | '\t')+ { channel = 99 };
