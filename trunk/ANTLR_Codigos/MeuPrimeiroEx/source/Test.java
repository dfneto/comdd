import org.antlr.runtime.*;
public class Test {
public static void main(String[] args) throws Exception {
// create a CharStream that reads from standard input
ANTLRInputStream input = new ANTLRInputStream(System.in);
// create a lexer that feeds off of input CharStream
MyDslLexer lexer = new MyDslLexer(input);
// create a buffer of tokens pulled from the lexer
CommonTokenStream tokens = new CommonTokenStream(lexer);
// create a parser that feeds off the tokens buffer
MyDslParser parser = new MyDslParser(tokens);
// begin parsing at rule r
parser.stat();
}
}

