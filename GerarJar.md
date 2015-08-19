# Introduction #

Add your content here.


# Details #

Ao tentar rodar a versão 30, tenho o seguinte erro:

---

david@linux-touch:~/comdd/ANTLR\_Codigos/jar$ java -jar dsl.jarException in thread "main" java.lang.NoClassDefFoundError: org/antlr/runtime/CharStream
Caused by: java.lang.ClassNotFoundException: org.antlr.runtime.CharStream
> at java.net.URLClassLoader$1.run(URLClassLoader.java:202)
> at java.security.AccessController.doPrivileged(Native Method)
> at java.net.URLClassLoader.findClass(URLClassLoader.java:190)
> at java.lang.ClassLoader.loadClass(ClassLoader.java:307)
> at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:301)
> at java.lang.ClassLoader.loadClass(ClassLoader.java:248)
Could not find the main class: Test. Program will exit.


Daí pensei que seria o mesmo erro que teria se rodasse ./Comandos sem o classpath configurado, entretanto percebi que não:

---

david@linux-touch:~/comdd/ANTLR\_Codigos/jar$ ./Comandos
removido `MyDsl.g'
removido `MyDslParser.java'
removido `MyDslLexer.java'
removido `MyDsl.tokens'
removido `MyDslLexer.class'
removido `MyDslParser.class'
removido `Test.class'
removido `TLexer.class'
Exception in thread "main" java.lang.NoClassDefFoundError: org/antlr/Tool
Caused by: java.lang.ClassNotFoundException: org.antlr.Tool
> at java.net.URLClassLoader$1.run(URLClassLoader.java:202)
> at java.security.AccessController.doPrivileged(Native Method)
> at java.net.URLClassLoader.findClass(URLClassLoader.java:190)
> at java.lang.ClassLoader.loadClass(ClassLoader.java:307)
> at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:301)
> at java.lang.ClassLoader.loadClass(ClassLoader.java:248)
Could not find the main class: org.antlr.Tool.  Program will exit.
Test.java:1: package org.antlr.runtime does not exist
import org.antlr.runtime.**;
^
TLexer.java:3: package org.antlr.runtime does not exist
import org.antlr.runtime.**;
^
TLexer.java:8: cannot find symbol
symbol: class Lexer
public class TLexer extends Lexer {
> > ^
TLexer.java:15: cannot find symbol
symbol  : class CharStream
location: class TLexer
> > public TLexer(CharStream input) {
> > > ^
TLexer.java:21: cannot find symbol
symbol  : class RecognitionException
location: class TLexer

> > public final void mT6() throws RecognitionException {
> > > ^
TLexer.java:40: cannot find symbol
symbol  : class RecognitionException
location: class TLexer

> > public final void mID() throws RecognitionException {
> > > ^
TLexer.java:87: cannot find symbol
symbol  : class RecognitionException
location: class TLexer

> > public final void mWS() throws RecognitionException {
> > > ^
TLexer.java:143: cannot find symbol
symbol  : class RecognitionException
location: class TLexer

> > public void mTokens() throws RecognitionException {
> > > ^
Test.java:5: cannot find symbol
symbol  : class ANTLRInputStream
location: class Test
ANTLRInputStream input = new ANTLRInputStream(System.in);
^
Test.java:5: cannot find symbol
symbol  : class ANTLRInputStream
location: class Test
ANTLRInputStream input = new ANTLRInputStream(System.in);
> > > ^
Test.java:7: cannot find symbol
symbol  : class MyDslLexer
location: class Test
MyDslLexer lexer = new MyDslLexer(input);
^
Test.java:7: cannot find symbol
symbol  : class MyDslLexer
location: class Test
MyDslLexer lexer = new MyDslLexer(input);
> > > ^
Test.java:9: cannot find symbol
symbol  : class CommonTokenStream
location: class Test
CommonTokenStream tokens = new CommonTokenStream(lexer);
^
Test.java:9: cannot find symbol
symbol  : class CommonTokenStream
location: class Test
CommonTokenStream tokens = new CommonTokenStream(lexer);
> > > > ^
Test.java:11: cannot find symbol
symbol  : class MyDslParser
location: class Test
MyDslParser parser = new MyDslParser(tokens);
^
Test.java:11: cannot find symbol
symbol  : class MyDslParser
location: class Test
MyDslParser parser = new MyDslParser(tokens);
> > > > ^
TLexer.java:27: cannot find symbol
symbol  : method match(java.lang.String)
location: class TLexer

> > > match("robo");
> > > ^
TLexer.java:32: cannot find symbol
symbol  : variable type
location: class TLexer
> > > this.type = _type;
> > > > ^
TLexer.java:51: cannot find symbol
symbol  : variable input
location: class TLexer
> > > > int LA1\_0 = input.LA(1);
> > > > > ^
TLexer.java:62: cannot find symbol
symbol  : method matchRange(char,char)
location: class TLexer
> > > > > matchRange('a','z');
> > > > > ^
TLexer.java:69: cannot find symbol
symbol  : class EarlyExitException
location: class TLexer
> > > > > > EarlyExitException eee =
> > > > > > ^
TLexer.java:70: cannot find symbol
symbol  : class EarlyExitException
location: class TLexer
> > > > > > > new EarlyExitException(1, input);
> > > > > > > > ^
TLexer.java:70: cannot find symbol
symbol  : variable input
location: class TLexer

> > > > > > > new EarlyExitException(1, input);
> > > > > > > > ^
TLexer.java:79: cannot find symbol
symbol  : variable type
location: class TLexer

> > > this.type =_type;
> > > > ^
TLexer.java:98: cannot find symbol
symbol  : variable input
location: class TLexer
> > > > int LA2\_0 = input.LA(1);
> > > > > ^
TLexer.java:109: cannot find symbol
symbol  : variable input
location: class TLexer
> > > > > if ( input.LA(1)=='\n'|input.LA(1)=='\r'||input.LA(1)==' ' ) {|
|:----------------|
> > > > > > ^
TLexer.java:109: cannot find symbol
symbol  : variable input
location: class TLexer

> > > > > if ( input.LA(1)=='\n'|input.LA(1)=='\r'||input.LA(1)==' ' ) {|
> > > > > > ^
TLexer.java:109: cannot find symbol
symbol  : variable input
location: class TLexer

> > > > > if ( input.LA(1)=='\n'|input.LA(1)=='\r'||input.LA(1)==' ' ) {|
> > > > > > ^
TLexer.java:110: cannot find symbol
symbol  : variable input
location: class TLexer
> > > > > > input.consume();
> > > > > > ^
TLexer.java:114: cannot find symbol
symbol  : class MismatchedSetException
location: class TLexer
> > > > > > MismatchedSetException mse =
> > > > > > ^
TLexer.java:115: cannot find symbol
symbol  : class MismatchedSetException
location: class TLexer
> > > > > > > new MismatchedSetException(null,input);
> > > > > > > > ^
TLexer.java:115: cannot find symbol
symbol  : variable input
location: class TLexer

> > > > > > > new MismatchedSetException(null,input);
> > > > > > > > ^
TLexer.java:125: cannot find symbol
symbol  : class EarlyExitException
location: class TLexer

> > > > > > > EarlyExitException eee =
> > > > > > > ^
TLexer.java:126: cannot find symbol
symbol  : class EarlyExitException
location: class TLexer
> > > > > > > > new EarlyExitException(2, input);
> > > > > > > > > ^
TLexer.java:126: cannot find symbol
symbol  : variable input
location: class TLexer

> > > > > > > > new EarlyExitException(2, input);
> > > > > > > > > ^
TLexer.java:132: cannot find symbol
symbol  : method skip()
location: class TLexer

> > > skip();
> > > ^
TLexer.java:136: cannot find symbol
symbol  : variable type
location: class TLexer
> > > this.type = 