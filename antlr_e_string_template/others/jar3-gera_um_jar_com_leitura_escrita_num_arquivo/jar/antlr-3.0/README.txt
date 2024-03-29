Early Access ANTLR v3
ANTLR 3.0
May 17, 2007

Terence Parr, parrt at cs usfca edu
ANTLR project lead and supreme dictator for life
University of San Francisco

INTRODUCTION 

Welcome to ANTLR v3!  I've been working on this for nearly 4 years and it's
finally ready!  I have lots of features to add later, but this will be
the first set.

You should use v3 in conjunction with ANTLRWorks:

    http://www.antlr.org/works/index.html 

The book will also help you a great deal (printed May 15, 2007); you
can also buy the PDF:

http://www.pragmaticprogrammer.com/titles/tpantlr/index.html

See the getting started document:

http://www.antlr.org/wiki/display/ANTLR3/FAQ+-+Getting+Started

You also have the examples plus the source to guide you.

See the new wiki FAQ:

    http://www.antlr.org/wiki/display/ANTLR3/ANTLR+v3+FAQ

and general doc root:

    http://www.antlr.org/wiki/display/ANTLR3/ANTLR+3+Wiki+Home

Please help add/update FAQ entries.

If all else fails, you can buy support or ask the antlr-interest list:

    http://www.antlr.org/support.html

I have made very little effort at this point to deal well with
erroneous input (e.g., bad syntax might make ANTLR crash).  I will clean
this up after I've rewritten v3 in v3.  v3 is written in v2 at the moment.

Per the license in LICENSE.txt, this software is not guaranteed to
work and might even destroy all life on this planet:

THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED.  IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT,
INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING
IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
POSSIBILITY OF SUCH DAMAGE.

----------------------------------------------------------------------

EXAMPLES

ANTLR v3 sample grammars (currently for C, C#, Java targets):

    http://www.antlr.org/download/examples-v3.tar.gz

contains the following examples: LL-star, cminus, dynamic-scope,
fuzzy, hoistedPredicates, island-grammar, java, python, scopes,
simplecTreeParser, treeparser, tweak, xmlLexer.

Also check out Mantra Programming Language for a prototype (work in
progress) using v3:

    http://www.linguamantra.org/

----------------------------------------------------------------------

What is ANTLR?

ANTLR stands for (AN)other (T)ool for (L)anguage (R)ecognition and was
originally known as PCCTS.  ANTLR is a language tool that provides a
framework for constructing recognizers, compilers, and translators
from grammatical descriptions containing actions.  Target language list:

http://www.antlr.org/wiki/display/ANTLR3/Code+Generation+Targets

----------------------------------------------------------------------

How is ANTLR v3 different than ANTLR v2?

See "What is the difference between ANTLR v2 and v3?"

    http://www.antlr.org/wiki/pages/viewpage.action?pageId=719

See migration guide:

    http://www.antlr.org/wiki/display/ANTLR3/Migrating+from+ANTLR+2+to+ANTLR+3

----------------------------------------------------------------------

How do I install this damn thing?

Just untar and you'll get:

antlr-3.0/README.txt (this file)
antlr-3.0/LICENSE.txt
antlr-3.0/src/org/antlr/...
antlr-3.0/lib/stringtemplate-3.0.jar (3.0 needs 3.0)
antlr-3.0/lib/antlr-2.7.7.jar
antlr-3.0/lib/antlr-3.0.jar

Then you need to add all the jars in lib to your CLASSPATH.

Please see the FAQ

http://www.antlr.org/wiki/display/ANTLR3/ANTLR+v3+FAQ

----------------------------------------------------------------------

CHANGES

3.0 final - May 17, 2007

May 14, 2007

* Auto backtracking didn't work with ! and ^ suffixes on first element
  of an alt.

* Auto backtracking didn't work with an action as first element.

May 10, 2007

* turn off the warning about no local messages:
 no such locale file org/antlr/tool/templates/messages/languages/ru.stg retrying with English locale

May 5, 2007

* moving org.antlr.runtime to runtime/Java/src/org/... Other target
  source / libs are under runtime/targetname.

May 4, 2007

* You could not use arguments on a token reference that was a route in a
  tree rewrite rule like -> ^(ID[args] ...).

May 3, 2007

* Fixed ANTLR-82.  Actions after the root were considered part of
  an optional child.  They were not always executed.  Required a change
  to the ANTLRCore.sti interface for tree() template.

May 2, 2007

* Fixed ANTLR-117. Wasn't building decisions properly for subrules in
  syntactic predicates.

April 22, 2007

* Made build.xml ref all jars in antlr lib.  Thanks to Miguel Ping.

* Fixed ANTLR-11

* Now labels on ranges and such in lexer work properly.

* ActionAnalysisLexer was in wrong package.

April 21, 2007

* Pushing a huge update that fixes:
	http://www.antlr.org:8888/browse/ANTLR-112
	http://www.antlr.org:8888/browse/ANTLR-110
	http://www.antlr.org:8888/browse/ANTLR-109
	http://www.antlr.org:8888/browse/ANTLR-103
	http://www.antlr.org:8888/browse/ANTLR-97
	http://www.antlr.org:8888/browse/ANTLR-113
	http://www.antlr.org:8888/browse/ANTLR-66
	http://www.antlr.org:8888/browse/ANTLR-98
	http://www.antlr.org:8888/browse/ANTLR-24
	http://www.antlr.org:8888/browse/ANTLR-114
	http://www.antlr.org:8888/browse/ANTLR-5
	http://www.antlr.org:8888/browse/ANTLR-6

  Basically, I gutted the way AST rewrites work.  MUCH better.

* Fixed lots of little label issues in the lexer.  Couldn't do x+=ID
  in lexer, for example.  Fixed ANTLR-114, ANTLR-112

* Isolated EOT transition in lexer generated dangling else clause.
  Fixed ANTLR-113.

April 17, 2007

* Fixed a major problem with gated semantic predicates.  Added more
  unit tests.

* Fixed bug in cyclic DFA with syntactic predicates.  Wasn't rewinding
  properly.  Further, mark() in token stream did not fill buffer so
  when you rewound back to last marker index was -1 not 0.  At same time
  I fixed ANTLR-103.  Syn preds evaluated only once now.

* Altered code gen file writing so it writes directly to a file
  instead of building a big string and then writing that out.  Should
  be faster and much less memory intensive.

* Fixed so antlr writes files to correct location again.  See:

http://www.antlr.org/wiki/pages/viewpage.action?pageId=1862

3.0b7 - April 12, 2007

April 10, 2007

* Allows -> {...} actions now when building ASTs.  Fixed ANTLR-14.

* Allows ! on sets and wildcard now during output=AST option. Fixed ANTLR-17.

* Fixed ANTLR-92 bug.  Couldn't use sets with -> tree construction.

* No lexer rule for a token type is now a warning.

* Fixed set labels in lexer; ANTLR-60 bug

* Fixed problem with duplicate state variable definitions in switch-case

April 9, 2007

* Gated predicates didn't work properly in cyclic DFA.

April 7, 2007

* Couldn't have more than one set per rule it seems.  Fixed.

April 3, 2007

* Fix a problem in my unused label optimization.  Added new
  pass over actions to examine them.

* RuleReturnScope has method back:
  /** Has a value potentially if output=template; Don't use StringTemplate
   *  type as it then causes a dependency with ST lib.
   */
  public Object getTemplate() { return null; }

March 30, 2007

* Fixed ANTLR-8.  Labels to rules w/o return values caused compile errors.

* Fixed ANTLR-89; semantic predicates in lexer sometimes
  caused exception in code gen.

* Fixed ANTLR-36; remove runtime dependency with ST

March 29, 2007

* Over last few days, I've gutted how ANTLR handles sets of chars or
  tokens.  I cleaned up a lot of stuff in the grammars and added lots
  of unit tests.

March 26, 2007

* CommonTreeNodeStream didn't push correctly; couldn't handle very
  deeply nested trees.

* Fixed bug that E : 'a' 'b' ; made E be seen as an alias of 'a'.

March 22, 2007

* Working with Egor Ushakov from Sun Optimization / NetBeans team I
  made all the Java lexer transition tables static w/o screwing up
  ability to reference semantic predicates etc...  Only changed Java.stg

* cached text string in CommonToken.getText(); saves on repeated calls;
  Java mode.

* made all generated methods final; saves a few percent speed according to
  Egor Ushakov (Java only).

* removed most assignments from each lexer rule and even the Lexer.emit()
  call!  All done in nextToken now.  Saves on code gen size and a wee bit of
  execution speed probably.  Variables became fields: type, channel, line,
  etc... Now emit() needs no args even.  Again, Egor helped on this.

March 17, 2007

* Jonathan DeKlotz updated C# templates to be 3.0b6 current

March 14, 2007

* Manually-specified (...)=> force backtracking eval of that predicate.
  backtracking=true mode does not however.  Added unit test.

March 14, 2007

* Fixed bug in lexer where ~T didn't compute the set from rule T.

* Added -Xnoinlinedfa make all DFA with tables; no inline prediction with IFs

* Fixed http://www.antlr.org:8888/browse/ANTLR-80.
  Sem pred states didn't define lookahead vars.

* Fixed http://www.antlr.org:8888/browse/ANTLR-91.  
  When forcing some acyclic DFA to be state tables, they broke.
  Forcing all DFA to be state tables should give same results.

March 12, 2007

* setTokenSource in CommonTokenStream didn't clear tokens list.
  setCharStream calls reset in Lexer.

* Altered -depend.  No longer printing grammar files for multiple input
  files with -depend.  Doesn't show T__.g temp file anymore. Added
  TLexer.tokens.  Added .h files if defined.

February 11, 2007

* Added -depend command-line option that, instead of processing files,
  it shows you what files the input grammar(s) depend on and what files
  they generate. For combined grammar T.g:

  $ java org.antlr.Tool -depend T.g

  You get:

  TParser.java : T.g
  T.tokens : T.g
  T__.g : T.g

  Now, assuming U.g is a tree grammar ref'd T's tokens:

  $ java org.antlr.Tool -depend T.g U.g

  TParser.java : T.g
  T.tokens : T.g
  T__.g : T.g
  U.g: T.tokens
  U.java : U.g
  U.tokens : U.g

  Handles spaces by escaping them.  Pays attention to -o, -fo and -lib.
  Dir 'x y' is a valid dir in current dir.

  $ java org.antlr.Tool -depend -lib /usr/local/lib -o 'x y' T.g U.g
  x\ y/TParser.java : T.g
  x\ y/T.tokens : T.g
  x\ y/T__.g : T.g
  U.g: /usr/local/lib/T.tokens
  x\ y/U.java : U.g
  x\ y/U.tokens : U.g

  You have API access via org.antlr.tool.BuildDependencyGenerator class:
  getGeneratedFileList(), getDependenciesFileList().  You can also access
  the output template: getDependencies().  The file
  org/antlr/tool/templates/depend.stg contains the template.  You can
  modify as you want.  File objects go in so you can play with path etc...

February 10, 2007

* no more .gl files generated.  All .g all the time.

* changed @finally to be @after and added a finally clause to the
  exception stuff.  I also removed the superfluous "exception"
  keyword.  Here's what the new syntax looks like:

  a
  @after { System.out.println("ick"); }
    : 'a'
    ;        
    catch[RecognitionException e] { System.out.println("foo"); }
    catch[IOException e] { System.out.println("io"); }
    finally { System.out.println("foobar"); }

  @after executes after bookkeeping to set $rule.stop, $rule.tree but
  before scopes pop and any memoization happens.  Dynamic scopes and
  memoization are still in generated finally block because they must
  exec even if error in rule.  The @after action and tree setting
  stuff can technically be skipped upon syntax error in rule.  [Later
  we might add something to finally to stick an ERROR token in the
  tree and set the return value.]  Sequence goes: set $stop, $tree (if
  any), @after (if any), pop scopes (if any), memoize (if needed),
  grammar finally clause.  Last 3 are in generated code's finally
  clause.

3.0b6 - January 31, 2007

January 30, 2007

* Fixed bug in IntervalSet.and: it returned the same empty set all the time
  rather than new empty set.  Code altered the same empty set.

* Made analysis terminate faster upon a decision that takes too long;
  it seemed to keep doing work for a while.  Refactored some names
  and updated comments.  Also made it terminate when it realizes it's
  non-LL(*) due to recursion.  just added terminate conditions to loop
  in convert().

* Sometimes fatal non-LL(*) messages didn't appear; instead you got
  "antlr couldn't analyze", which is actually untrue.  I had the
  order of some prints wrong in the DecisionProbe.

* The code generator incorrectly detected when it could use a fixed,
  acyclic inline DFA (i.e., using an IF).  Upon non-LL(*) decisions
  with predicates, analysis made cyclic DFA.  But this stops
  the computation detecting whether they are cyclic.  I just added
  a protection in front of the acyclic DFA generator to avoid if
  non-LL(*).  Updated comments.

January 23, 2007

* Made tree node streams use adaptor to create navigation nodes.
  Thanks to Emond Papegaaij.

January 22, 2007

* Added lexer rule properties: start, stop

January 1, 2007

* analysis failsafe is back on; if a decision takes too long, it bails out
  and uses k=1

January 1, 2007

* += labels for rules only work for output option; previously elements
  of list were the return value structs, but are now either the tree or
  StringTemplate return value.  You can label different rules now
  x+=a x+=b.

December 30, 2006

* Allow \" to work correctly in "..." template.

December 28, 2006

* errors that are now warnings: missing AST label type in trees.
  Also "no start rule detected" is warning.

* tree grammars also can do rewrite=true for output=template.
  Only works for alts with single node or tree as alt elements.
  If you are going to use $text in a tree grammar or do rewrite=true
  for templates, you must use in your main:

  nodes.setTokenStream(tokens);

* You get a warning for tree grammars that do rewrite=true and
  output=template and have -> for alts that are not simple nodes
  or simple trees.  new unit tests in TestRewriteTemplates at end.

December 27, 2006

* Error message appears when you use -> in tree grammar with
  output=template and rewrite=true for alt that is not simple
  node or tree ref.

* no more $stop attribute for tree parsers; meaningless/useless.
  Removed from TreeRuleReturnScope also.

* rule text attribute in tree parser must pull from token buffer.
  Makes no sense otherwise.  added getTokenStream to TreeNodeStream
  so rule $text attr works.  CommonTreeNodeStream etc... now let
  you set the token stream so you can access later from tree parser.
  $text is not well-defined for rules like

     slist : stat+ ;

  because stat is not a single node nor rooted with a single node.
  $slist.text will get only first stat.  I need to add a warning about
  this...

* Fixed http://www.antlr.org:8888/browse/ANTLR-76 for Java.
  Enhanced TokenRewriteStream so it accepts any object; converts
  to string at last second.  Allows you to rewrite with StringTemplate
  templates now :)

* added rewrite option that makes -> template rewrites do replace ops for
  TokenRewriteStream input stream.  In output=template and rewrite=true mode
  same as before 'cept that the parser does

    ((TokenRewriteStream)input).replace(
	      ((Token)retval.start).getTokenIndex(),
	      input.LT(-1).getTokenIndex(),
	      retval.st);

  after each rewrite so that the input stream is altered.  Later refs to
  $text will have rewrites.  Here's a sample test program for grammar Rew.

        FileReader groupFileR = new FileReader("Rew.stg");
        StringTemplateGroup templates = new StringTemplateGroup(groupFileR);
        ANTLRInputStream input = new ANTLRInputStream(System.in);
        RewLexer lexer = new RewLexer(input);
        TokenRewriteStream tokens = new TokenRewriteStream(lexer);
        RewParser parser = new RewParser(tokens);
        parser.setTemplateLib(templates);
        parser.program();
        System.out.println(tokens.toString());
        groupFileR.close();

December 26, 2006

* BaseTree.dupTree didn't dup recursively.

December 24, 2006

* Cleaned up some comments and removed field treeNode
  from MismatchedTreeNodeException class.  It is "node" in
  RecognitionException.

* Changed type from Object to BitSet for expecting fields in
  MismatchedSetException and MismatchedNotSetException

* Cleaned up error printing in lexers and the messages that it creates.

* Added this to TreeAdaptor:
	/** Return the token object from which this node was created.
	 *  Currently used only for printing an error message.
	 *  The error display routine in BaseRecognizer needs to
	 *  display where the input the error occurred. If your
	 *  tree of limitation does not store information that can
	 *  lead you to the token, you can create a token filled with
	 *  the appropriate information and pass that back.  See
	 *  BaseRecognizer.getErrorMessage().
	 */
	public Token getToken(Object t);

December 23, 2006

* made BaseRecognizer.displayRecognitionError nonstatic so people can
  override it. Not sure why it was static before.

* Removed state/decision message that comes out of no 
  viable alternative exceptions, as that was too much.
  removed the decision number from the early exit exception
  also.  During development, you can simply override
  displayRecognitionError from BaseRecognizer to add the stuff
  back in if you want.

* made output go to an output method you can override: emitErrorMessage()

* general cleanup of the error emitting code in BaseRecognizer.  Lots
  more stuff you can override: getErrorHeader, getTokenErrorDisplay,
  emitErrorMessage, getErrorMessage.

December 22, 2006

* Altered Tree.Parser.matchAny() so that it skips entire trees if
  node has children otherwise skips one node.  Now this works to
  skip entire body of function if single-rooted subtree:
  ^(FUNC name=ID arg=ID .)

* Added "reverse index" from node to stream index.  Override
  fillReverseIndex() in CommonTreeNodeStream if you want to change.
  Use getNodeIndex(node) to find stream index for a specific tree node.
  See getNodeIndex(), reverseIndex(Set tokenTypes),
  reverseIndex(int tokenType), fillReverseIndex().  The indexing
  costs time and memory to fill, but pulling stuff out will be lots
  faster as it can jump from a node ptr straight to a stream index.

* Added TreeNodeStream.get(index) to make it easier for interpreters to
  jump around in tree node stream.

* New CommonTreeNodeStream buffers all nodes in stream for fast jumping
  around.  It now has push/pop methods to invoke other locations in
  the stream for building interpreters.

* Moved CommonTreeNodeStream to UnBufferedTreeNodeStream and removed
  Iterator implementation.  moved toNodesOnlyString() to TestTreeNodeStream

* [BREAKS ANY TREE IMPLEMENTATION]
  made CommonTreeNodeStream work with any tree node type.  TreeAdaptor
  now implements isNil so must add; trivial, but does break back
  compatibility.

December 17, 2006

* Added traceIn/Out methods to recognizers so that you can override them;
  previously they were in-line print statements. The message has also
  been slightly improved.

* Factored BuildParseTree into debug package; cleaned stuff up. Fixed
  unit tests.

December 15, 2006

* [BREAKS ANY TREE IMPLEMENTATION]
  org.antlr.runtime.tree.Tree; needed to add get/set for token start/stop
  index so CommonTreeAdaptor can assume Tree interface not CommonTree
  implementation.  Otherwise, no way to create your own nodes that satisfy
  Tree because CommonTreeAdaptor was doing 

	public int getTokenStartIndex(Object t) {
		return ((CommonTree)t).startIndex;
	}

  Added to Tree:

	/**  What is the smallest token index (indexing from 0) for this node
	 *   and its children?
	 */
	int getTokenStartIndex();

	void setTokenStartIndex(int index);

	/**  What is the largest token index (indexing from 0) for this node
	 *   and its children?
	 */
	int getTokenStopIndex();	

	void setTokenStopIndex(int index);

December 13, 2006
 
* Added org.antlr.runtime.tree.DOTTreeGenerator so you can generate DOT
  diagrams easily from trees.

	CharStream input = new ANTLRInputStream(System.in);
	TLexer lex = new TLexer(input);
	CommonTokenStream tokens = new CommonTokenStream(lex);
	TParser parser = new TParser(tokens);
	TParser.e_return r = parser.e();
	Tree t = (Tree)r.tree;
	System.out.println(t.toStringTree());
	DOTTreeGenerator gen = new DOTTreeGenerator();
	StringTemplate st = gen.toDOT(t);
	System.out.println(st);

* Changed the way mark()/rewind() work in CommonTreeNode stream to mirror
  more flexible solution in ANTLRStringStream.  Forgot to set lastMarker
  anyway.  Now you can rewind to non-most-recent marker.

December 12, 2006

* Temp lexer now end in .gl (T__.gl, for example)

* TreeParser suffix no longer generated for tree grammars

* Defined reset for lexer, parser, tree parser; rewinds the input stream also

December 10, 2006

* Made Grammar.abortNFAToDFAConversion() abort in middle of a DFA.

December 9, 2006

* fixed bug in OrderedHashSet.add().  It didn't track elements correctly.

December 6, 2006

* updated build.xml for future Ant compatibility, thanks to Matt Benson.

* various tests in TestRewriteTemplate and TestSyntacticPredicateEvaluation
  were using the old 'channel' vs. new '$channel' notation.
  TestInterpretedParsing didn't pick up an earlier change to CommonToken.
  Reported by Matt Benson.

* fixed platform dependent test failures in TestTemplates, supplied by Matt
  Benson.

November 29, 2006

*  optimized semantic predicate evaluation so that p||!p yields true.

November 22, 2006

* fixed bug that prevented var = $rule.some_retval from working in anything
  but the first alternative of a rule or subrule.

* attribute names containing digits were not allowed, this is now fixed,
  allowing attributes like 'name1' but not '1name1'.

November 19, 2006

* Removed LeftRecursionMessage and apparatus because it seems that I check
  for left recursion upfront before analysis and everything gets specified as
  recursion cycles at this point.

November 16, 2006

* TokenRewriteStream.replace was not passing programName to next method.

November 15, 2006

* updated DOT files for DFA generation to make smaller circles.

* made epsilon edges italics in the NFA diagrams.

3.0b5 - November 15, 2006

The biggest thing is that your grammar file names must match the grammar name
inside (your generated class names will also be different) and we use
$channel=HIDDEN now instead of channel=99 inside lexer actions.
Should be compatible other than that.   Please look at complete list of
changes.

November 14, 2006

* Force token index to be -1 for CommonIndex in case not set.

November 11, 2006

* getUniqueID for TreeAdaptor now uses identityHashCode instead of hashCode.

November 10, 2006

* No grammar nondeterminism warning now when wildcard '.' is final alt.
  Examples:

	a : A | B | . ;

	A : 'a'
	  | .
	  ;

	SL_COMMENT
	    : '//' (options {greedy=false;} : .)* '\r'? '\n'
	    ;

	SL_COMMENT2
	    : '//' (options {greedy=false;} : 'x'|.)* '\r'? '\n'
	    ;


November 8, 2006

* Syntactic predicates did not get hoisting properly upon non-LL(*) decision.  Other hoisting issues fixed.  Cleaned up code.

* Removed failsafe that check to see if I'm spending too much time on a single DFA; I don't think we need it anymore.

November 3, 2006

* $text, $line, etc... were not working in assignments. Fixed and added
  test case.

* $label.text translated to label.getText in lexer even if label was on a char

November 2, 2006

* Added error if you don't specify what the AST type is; actions in tree
  grammar won't work without it.

  $ cat x.g
  tree grammar x;
  a : ID {String s = $ID.text;} ;

  ANTLR Parser Generator   Early Access Version 3.0b5 (??, 2006)  1989-2006
  error: x.g:0:0: (152) tree grammar x has no ASTLabelType option

November 1, 2006

* $text, $line, etc... were not working properly within lexer rule.

October 32, 2006

* Finally actions now execute before dynamic scopes are popped it in the
  rule. Previously was not possible to access the rules scoped variables
  in a finally action.

October 29, 2006

* Altered ActionTranslator to emit errors on setting read-only attributes
  such as $start, $stop, $text in a rule. Also forbid setting any attributes
  in rules/tokens referenced by a label or name.
  Setting dynamic scopes's attributes and your own parameter attributes
  is legal.

October 27, 2006

* Altered how ANTLR figures out what decision is associated with which
  block of grammar.  Makes ANTLRWorks correctly find DFA for a block.

October 26, 2006

* Fixed bug where EOT transitions led to no NFA configs in a DFA state,
  yielding an error in DFA table generation.

* renamed action.g to ActionTranslator.g
  the ActionTranslator class is now called ActionTranslatorLexer, as ANTLR
  generates this classname now. Fixed rest of codebase accordingly.

* added rules recognizing setting of scopes' attributes to ActionTranslator.g
  the Objective C target needed access to the right-hand side of the assignment
  in order to generate correct code

* changed ANTLRCore.sti to reflect the new mandatory templates to support the above
  namely: scopeSetAttributeRef, returnSetAttributeRef and the ruleSetPropertyRef_*
  templates, with the exception of ruleSetPropertyRef_text. we cannot set this attribute

October 19, 2006

* Fixed 2 bugs in DFA conversion that caused exceptions.
  altered functionality of getMinElement so it ignores elements<0.

October 18, 2006

* moved resetStateNumbersToBeContiguous() to after issuing of warnings;
  an internal error in that routine should make more sense as issues
  with decision will appear first.

* fixed cut/paste bug I introduced when fixed EOF in min/max
  bug. Prevented C grammar from working briefly.

October 17, 2006

* Removed a failsafe that seems to be unnecessary that ensure DFA didn't
  get too big.  It was resulting in some failures in code generation that
  led me on quite a strange debugging trip.

October 16, 2006

* Use channel=HIDDEN not channel=99 to put tokens on hidden channel.

October 12, 2006

* ANTLR now has a customizable message format for errors and warnings,
  to make it easier to fulfill requirements by IDEs and such.
  The format to be used can be specified via the '-message-format name'
  command line switch. The default for name is 'antlr', also available
  at the moment is 'gnu'. This is done via StringTemplate, for details
  on the requirements look in org/antlr/tool/templates/messages/formats/

* line numbers for lexers in combined grammars are now reported correctly.

September 29, 2006

* ANTLRReaderStream improperly checked for end of input.

September 28, 2006

* For ANTLRStringStream, LA(-1) was off by one...gave you LA(-2).

3.0b4 - August 24, 2006

* error when no rules in grammar.  doesn't crash now.

* Token is now an interface.

* remove dependence on non runtime classes in runtime package.

* filename and grammar name must be same Foo in Foo.g.  Generates FooParser,
  FooLexer, ...  Combined grammar Foo generates Foo$Lexer.g which generates
  FooLexer.java.  tree grammars generate FooTreeParser.java

August 24, 2006

* added C# target to lib, codegen, templates

August 11, 2006

* added tree arg to navigation methods in treeadaptor

August 07, 2006

* fixed bug related to (a|)+ on end of lexer rules.  crashed instead
  of warning.

* added warning that interpreter doesn't do synpreds yet

* allow different source of classloader:
ClassLoader cl = Thread.currentThread().getContextClassLoader();
if ( cl==null ) {
    cl = this.getClass().getClassLoader();
}


July 26, 2006

* compressed DFA edge tables significantly.  All edge tables are
  unique. The transition table can reuse arrays.  Look like this now:

     public static readonly DFA30_transition0 =
     	new short[] { 46, 46, -1, 46, 46, -1, -1, -1, -1, -1, -1, -1,...};
         public static readonly DFA30_transition1 =
     	new short[] { 21 };
      public static readonly short[][] DFA30_transition = {
     	  DFA30_transition0,
     	  DFA30_transition0,
     	  DFA30_transition1,
     	  ...
      };

* If you defined both a label like EQ and '=', sometimes the '=' was
  used instead of the EQ label.

* made headerFile template have same arg list as outputFile for consistency

* outputFile, lexer, genericParser, parser, treeParser templates
  reference cyclicDFAs attribute which was no longer used after I
  started the new table-based DFA.  I made cyclicDFADescriptors
  argument to outputFile and headerFile (only).  I think this is
  correct as only OO languages will want the DFA in the recognizer.
  At the top level, C and friends can use it.  Changed name to use
  cyclicDFAs again as it's a better name probably.  Removed parameter
  from the lexer, ...  For example, my parser template says this now:

    <cyclicDFAs:cyclicDFA()> <! dump tables for all DFA !>

* made all token ref token types go thru code gen's
  getTokenTypeAsTargetLabel()

* no more computing DFA transition tables for acyclic DFA.

July 25, 2006

* fixed a place where I was adding syn predicates into rewrite stuff.

* turned off invalid token index warning in AW support; had a problem.

* bad location event generated with -debug for synpreds in autobacktrack mode.

July 24, 2006

* changed runtime.DFA so that it treats all chars and token types as
  char (unsigned 16 bit int).  -1 becomes '\uFFFF' then or 65535.

* changed MAX_STATE_TRANSITIONS_FOR_TABLE to be 65534 by default
  now. This means that all states can use a table to do transitions.

* was not making synpreds on (C)* type loops with backtrack=true

* was copying tree stuff and actions into synpreds with backtrack=true

* was making synpreds on even single alt rules / blocks with backtrack=true

3.0b3 - July 21, 2006

* ANTLR fails to analyze complex decisions much less frequently.  It
  turns out that the set of decisions for which ANTLR fails (times
  out) is the same set (so far) of non-LL(*) decisions.  Morever, I'm
  able to detect this situation quickly and report rather than timing
  out. Errors look like:

  java.g:468:23: [fatal] rule concreteDimensions has non-LL(*)
    decision due to recursive rule invocations in alts 1,2.  Resolve
    by left-factoring or using syntactic predicates with fixed k
    lookahead or use backtrack=true option.

  This message only appears when k=*.

* Shortened no viable alt messages to not include decision
  description:

[compilationUnit, declaration]: line 8:8 decision=<<67:1: declaration
: ( ( fieldDeclaration )=> fieldDeclaration | ( methodDeclaration )=>
methodDeclaration | ( constructorDeclaration )=>
constructorDeclaration | ( classDeclaration )=> classDeclaration | (
interfaceDeclaration )=> interfaceDeclaration | ( blockDeclaration )=>
blockDeclaration | emptyDeclaration );>> state 3 (decision=14) no
viable alt; token=[@1,184:187='java',<122>,8:8]

  too long and hard to read.

July 19, 2006

* Code gen bug: states with no emanating edges were ignored by ST.
  Now an empty list is used.

* Added grammar parameter to recognizer templates so they can access
  properties like getName(), ...

July 10, 2006

* Fixed the gated pred merged state bug.  Added unit test.

* added new method to Target: getTokenTypeAsTargetLabel()

July 7, 2006

* I was doing an AND instead of OR in the gated predicate stuff.
  Thanks to Stephen Kou!

* Reduce op for combining predicates was insanely slow sometimes and
  didn't actually work well.  Now it's fast and works.

* There is a bug in merging of DFA stop states related to gated
  preds...turned it off for now.

3.0b2 - July 5, 2006

July 5, 2006

* token emission not properly protected in lexer filter mode.

* EOT, EOT DFA state transition tables should be init'd to -1 (only
  was doing this for compressed tables).  Fixed.

* in trace mode, exit method not shown for memoized rules

* added -Xmaxdfaedges to allow you to increase number of edges allowed
  for a single DFA state before it becomes "special" and can't fit in
  a simple table.

* Bug in tables.  Short are signed so min/max tables for DFA are now
  char[].  Bizarre.

July 3, 2006

* Added a method to reset the tool error state for current thread.
  See ErrorManager.java

* [Got this working properly today] backtrack mode that let's you type
  in any old crap and ANTLR will backtrack if it can't figure out what
  you meant.  No errors are reported by antlr during analysis.  It
  implicitly adds a syn pred in front of every production, using them
  only if static grammar LL(*) analysis fails.  Syn pred code is not
  generated if the pred is not used in a decision.

  This is essentially a rapid prototyping mode.

* Added backtracking report to the -report option

* Added NFA->DFA conversion early termination report to the -report option

* Added grammar level k and backtrack options to -report

* Added a dozen unit tests to test autobacktrack NFA construction.

* If you are using filter mode, you must manually use option
  memoize=true now.

July 2, 2006

* Added k=* option so you can set k=2, for example, on whole grammar,
  but an individual decision can be LL(*).

* memoize option for grammars, rules, blocks.  Remove -nomemo cmd-line option

* but in DOT generator for DFA; fixed.

* runtime.DFA reported errors even when backtracking

July 1, 2006

* Added -X option list to help

* Syn preds were being hoisted into other rules, causing lots of extra
  backtracking.

June 29, 2006

* unnecessary files removed during build.

* Matt Benson updated build.xml

* Detecting use of synpreds in analysis now instead of codegen.  In
  this way, I can avoid analyzing decisions in synpreds for synpreds
  not used in a DFA for a real rule.  This is used to optimize things
  for backtrack option.

* Code gen must add _fragment or whatever to end of pred name in
  template synpredRule to avoid having ANTLR know anything about
  method names.

* Added -IdbgST option to emit ST delimiters at start/stop of all
  templates spit out.

June 28, 2006

* Tweaked message when ANTLR cannot handle analysis.

3.0b1 - June 27, 2006

June 24, 2006

* syn preds no longer generate little static classes; they also don't
  generate a whole bunch of extra crap in the rules built to test syn
  preds.  Removed GrammarFragmentPointer class from runtime.

June 23-24, 2006

* added output option to -report output.

* added profiling info:
  Number of rule invocations in "guessing" mode
  number of rule memoization cache hits
  number of rule memoization cache misses

* made DFA DOT diagrams go left to right not top to bottom

* I try to recursive overflow states now by resolving these states
  with semantic/syntactic predicates if they exist.  The DFA is then
  deterministic rather than simply resolving by choosing first
  nondeterministic alt.  I used to generated errors:

~/tmp $ java org.antlr.Tool -dfa t.g
ANTLR Parser Generator   Early Access Version 3.0b2 (July 5, 2006)  1989-2006
t.g:2:5: Alternative 1: after matching input such as A A A A A decision cannot predict what comes next due to recursion overflow to b from b
t.g:2:5: Alternative 2: after matching input such as A A A A A decision cannot predict what comes next due to recursion overflow to b from b

  Now, I uses predicates if available and emits no warnings.

* made sem preds share accept states.  Previously, multiple preds in a
decision forked new accepts each time for each nondet state.

June 19, 2006

* Need parens around the prediction expressions in templates.

* Referencing $ID.text in an action forced bad code gen in lexer rule ID.

* Fixed a bug in how predicates are collected.  The definition of
  "last predicated alternative" was incorrect in the analysis.  Further,
  gated predicates incorrectly missed a case where an edge should become
  true (a tautology).

* Removed an unnecessary input.consume() reference in the runtime/DFA class.

June 14, 2006

* -> ($rulelabel)? didn't generate proper code for ASTs.

* bug in code gen (did not compile)
a : ID -> ID
  | ID -> ID
  ;
Problem is repeated ref to ID from left side.  Juergen pointed this out.

* use of tokenVocab with missing file yielded exception

* (A|B)=> foo yielded an exception as (A|B) is a set not a block. Fixed.

* Didn't set ID1= and INT1= for this alt:
  | ^(ID INT+ {System.out.print(\"^(\"+$ID+\" \"+$INT+\")\");})

* Fixed so repeated dangling state errors only occur once like:
t.g:4:17: the decision cannot distinguish between alternative(s) 2,1 for at least one input sequence

* tracking of rule elements was on (making list defs at start of
  method) with templates instead of just with ASTs.  Turned off.

* Doesn't crash when you give it a missing file now.

* -report: add output info: how many LL(1) decisions.

June 13, 2006

* ^(ROOT ID?) Didn't work; nor did any other nullable child list such as
  ^(ROOT ID* INT?).  Now, I check to see if child list is nullable using
  Grammar.LOOK() and, if so, I generate an "IF lookahead is DOWN" gate
  around the child list so the whole thing is optional.

* Fixed a bug in LOOK that made it not look through nullable rules.

* Using AST suffixes or -> rewrite syntax now gives an error w/o a grammar
  output option.  Used to crash ;)

* References to EOF ended up with improper -1 refs instead of EOF in output.

* didn't warn of ambig ref to $expr in rewrite; fixed.
list
     :	'[' expr 'for' type ID 'in' expr ']'
	-> comprehension(expr={$expr.st},type={},list={},i={})
	;

June 12, 2006

* EOF works in the parser as a token name.

* Rule b:(A B?)*; didn't display properly in AW due to the way ANTLR
  generated NFA.

* "scope x;" in a rule for unknown x gives no error.  Fixed.  Added unit test.

* Label type for refs to start/stop in tree parser and other parsers were
  not used.  Lots of casting.  Ick. Fixed.

* couldn't refer to $tokenlabel in isolation; but need so we can test if
  something was matched.  Fixed.

* Lots of little bugs fixed in $x.y, %... translation due to new
  action translator.

* Improperly tracking block nesting level; result was that you couldn't
  see $ID in action of rule "a : A+ | ID {Token t = $ID;} | C ;"

* a : ID ID {$ID.text;} ; did not get a warning about ambiguous $ID ref.

* No error was found on $COMMENT.text:

COMMENT
    :   '/*' (options {greedy=false;} : . )* '*/'
        {System.out.println("found method "+$COMMENT.text);}
    ;

  $enclosinglexerrule scope does not exist.  Use text or setText() here.

June 11, 2006

* Single return values are initialized now to default or to your spec.

* cleaned up input stream stuff.  Added ANTLRReaderStream, ANTLRInputStream
  and refactored.  You can specify encodings now on ANTLRFileStream (and
  ANTLRInputStream) now.

* You can set text local var now in a lexer rule and token gets that text.
  start/stop indexes are still set for the token.

* Changed lexer slightly.  Calling a nonfragment rule from a
  nonfragment rule does not set the overall token.

June 10, 2006

* Fixed bug where unnecessary escapes yield char==0 like '\{'.

* Fixed analysis bug.  This grammar didn't report a recursion warning:
x   : y X
    | y Y
    ;
y   : L y R
    | B
    ;
  The DFAState.equals() method was messed up.

* Added @synpredgate {...} action so you can tell ANTLR how to gate actions
  in/out during syntactic predicate evaluation.

* Fuzzy parsing should be more efficient.  It should backtrack over a rule
  and then rewind and do it again "with feeling" to exec actions.  It was
  actually doing it 3x not 2x.

June 9, 2006

* Gutted and rebuilt the action translator for $x.y, $x::y, ...
  Uses ANTLR v3 now for the first time inside v3 source. :)
  ActionTranslator.java

* Fixed a bug where referencing a return value on a rule didn't work
  because later a ref to that rule's predefined properties didn't
  properly force a return value struct to be built.  Added unit test.

June 6, 2006

* New DFA mechanisms.  Cyclic DFA are implemented as state tables,
  encoded via strings as java cannot handle large static arrays :(
  States with edges emanating that have predicates are specially
  treated.  A method is generated to do these states.  The DFA
  simulation routine uses the "special" array to figure out if the
  state is special.  See March 25, 2006 entry for description:
  http://www.antlr.org/blog/antlr3/codegen.tml.  analysis.DFA now has
  all the state tables generated for code gen.  CyclicCodeGenerator.java
  disappeared as it's unneeded code. :)

* Internal general clean up of the DFA.states vs uniqueStates thing.
  Fixed lookahead decisions no longer fill uniqueStates.  Waste of
  time.  Also noted that when adding sem pred edges, I didn't check
  for state reuse.  Fixed.

June 4, 2006

* When resolving ambig DFA states predicates, I did not add the new states
  to the list of unique DFA states.  No observable effect on output except
  that DFA state numbers were not always contiguous for predicated decisions.
  I needed this fix for new DFA tables.

3.0ea10 - June 2, 2006

June 2, 2006

* Improved grammar stats and added syntactic pred tracking.

June 1, 2006

* Due to a type mismatch, the DebugParser.recoverFromMismatchedToken()
  method was not called.  Debug events for mismatched token error
  notification were not sent to ANTLRWorks probably

* Added getBacktrackingLevel() for any recognizer; needed for profiler.

* Only writes profiling data for antlr grammar analysis with -profile set

* Major update and bug fix to (runtime) Profiler.

May 27, 2006

* Added Lexer.skip() to force lexer to ignore current token and look for
  another; no token is created for current rule and is not passed on to
  parser (or other consumer of the lexer).

* Parsers are much faster now.  I removed use of java.util.Stack for pushing
  follow sets and use a hardcoded array stack instead.  Dropped from
  5900ms to 3900ms for parse+lex time parsing entire java 1.4.2 source.  Lex
  time alone was about 1500ms.  Just looking at parse time, we get about 2x
  speed improvement. :)

May 26, 2006

* Fixed NFA construction so it generates NFA for (A*)* such that ANTLRWorks
  can display it properly.

May 25, 2006

* added abort method to Grammar so AW can terminate the conversion if it's
  taking too long.

May 24, 2006

* added method to get left recursive rules from grammar without doing full
  grammar analysis.

* analysis, code gen not attempted if serious error (like
  left-recursion or missing rule definition) occurred while reading
  the grammar in and defining symbols.

* added amazing optimization; reduces analysis time by 90% for java
  grammar; simple IF statement addition!

3.0ea9 - May 20, 2006

* added global k value for grammar to limit lookahead for all decisions unless
overridden in a particular decision.

* added failsafe so that any decision taking longer than 2 seconds to create
the DFA will fall back on k=1.  Use -ImaxtimeforDFA n (in ms) to set the time.

* added an option (turned off for now) to use multiple threads to
perform grammar analysis.  Not much help on a 2-CPU computer as
garbage collection seems to peg the 2nd CPU already. :( Gotta wait for
a 4 CPU box ;)

* switched from #src to // $ANTLR src directive.

* CommonTokenStream.getTokens() looked past end of buffer sometimes. fixed.

* unicode literals didn't really work in DOT output and generated code. fixed.

* fixed the unit test rig so it compiles nicely with Java 1.5

* Added ant build.xml file (reads build.properties file)

* predicates sometimes failed to compile/eval properly due to missing (...)
  in IF expressions.  Forced (..)

* (...)? with only one alt were not optimized.  Was:

        // t.g:4:7: ( B )?
        int alt1=2;
        int LA1_0 = input.LA(1);
        if ( LA1_0==B ) {
            alt1=1;
        }
        else if ( LA1_0==-1 ) {
            alt1=2;
        }
        else {
            NoViableAltException nvae =
                new NoViableAltException("4:7: ( B )?", 1, 0, input);
            throw nvae;
        }

is now:

        // t.g:4:7: ( B )?
        int alt1=2;
        int LA1_0 = input.LA(1);
        if ( LA1_0==B ) {
            alt1=1;
        }

  Smaller, faster and more readable.

* Allow manual init of return values now:
  functionHeader returns [int x=3*4, char (*f)()=null] : ... ;

* Added optimization for DFAs that fixed a codegen bug with rules in lexer:
   EQ			 : '=' ;
   ASSIGNOP		 : '=' | '+=' ;
  EQ is a subset of other rule.  It did not given an error which is
  correct, but generated bad code.

* ANTLR was sending column not char position to ANTLRWorks.

* Bug fix: location 0, 0 emitted for synpreds and empty alts.

* debugging event handshake how sends grammar file name.  Added getGrammarFileName() to recognizers.  Java.stg generates it:

    public String getGrammarFileName() { return "<fileName>"; }

* tree parsers can do arbitrary lookahead now including backtracking.  I
  updated CommonTreeNodeStream.

* added events for debugging tree parsers:

	/** Input for a tree parser is an AST, but we know nothing for sure
	 *  about a node except its type and text (obtained from the adaptor).
	 *  This is the analog of the consumeToken method.  Again, the ID is
	 *  the hashCode usually of the node so it only works if hashCode is
	 *  not implemented.
	 */
	public void consumeNode(int ID, String text, int type);

	/** The tree parser looked ahead */
	public void LT(int i, int ID, String text, int type);

	/** The tree parser has popped back up from the child list to the
	 *  root node.
	 */
	public void goUp();

	/** The tree parser has descended to the first child of a the current
	 *  root node.
	 */
	public void goDown();

* Added DebugTreeNodeStream and DebugTreeParser classes

* Added ctor because the debug tree node stream will need to ask quesitons about nodes and since  nodes are just Object, it needs an adaptor to decode the nodes and get text/type info for the debugger.

public CommonTreeNodeStream(TreeAdaptor adaptor, Tree tree);

* added getter to TreeNodeStream:
	public TreeAdaptor getTreeAdaptor();

* Implemented getText/getType in CommonTreeAdaptor.

* Added TraceDebugEventListener that can dump all events to stdout.

* I broke down and make Tree implement getText

* tree rewrites now gen location debug events.

* added AST debug events to listener; added blank listener for convenience

* updated debug events to send begin/end backtrack events for debugging

* with a : (b->b) ('+' b -> ^(PLUS $a b))* ; you get b[0] each time as
  there is no loop in rewrite rule itself.  Need to know context that
  the -> is inside the rule and hence b means last value of b not all
  values.

* Bug in TokenRewriteStream; ops at indexes < start index blocked proper op.

* Actions in ST rewrites "-> ({$op})()" were not translated

* Added new action name:

@rulecatch {
catch (RecognitionException re) {
    reportError(re);
    recover(input,re);
}
catch (Throwable t) {
    System.err.println(t);
}
}
Overrides rule catch stuff.

* Isolated $ refs caused exception

3.0ea8 - March 11, 2006

* added @finally {...} action like @init for rules.  Executes in
  finally block (java target) after all other stuff like rule memoization.
  No code changes needs; ST just refs a new action:
      <ruleDescriptor.actions.finally>

* hideous bug fixed: PLUS='+' didn't result in '+' rule in lexer

* TokenRewriteStream didn't do toString() right when no rewrites had been done.

* lexer errors in interpreter were not printed properly

* bitsets are dumped in hex not decimal now for FOLLOW sets

* /* epsilon */ is not printed now when printing out grammars with empty alts

* Fixed another bug in tree rewrite stuff where it was checking that elements
  had at least one element.  Strange...commented out for now to see if I can remember what's up.

* Tree rewrites had problems when you didn't have x+=FOO variables.  Rules
  like this work now:

  a : (x=ID)? y=ID -> ($x $y)?;

* filter=true for lexers turns on k=1 and backtracking for every token
  alternative.  Put the rules in priority order.

* added getLine() etc... to Tree to support better error reporting for
  trees.  Added MismatchedTreeNodeException.

* $templates::foo() is gone.  added % as special template symbol.
  %foo(a={},b={},...) ctor (even shorter than $templates::foo(...))
  %({name-expr})(a={},...) indirect template ctor reference

  The above are parsed by antlr.g and translated by codegen.g
  The following are parsed manually here:

  %{string-expr} anonymous template from string expr
  %{expr}.y = z; template attribute y of StringTemplate-typed expr to z
  %x.y = z; set template attribute y of x (always set never get attr)
            to z [languages like python without ';' must still use the
            ';' which the code generator is free to remove during code gen]

* -> ({expr})(a={},...) notation for indirect template rewrite.
  expr is the name of the template.

* $x[i]::y and $x[-i]::y notation for accesssing absolute scope stack
  indexes and relative negative scopes.  $x[-1]::y is the y attribute
  of the previous scope (stack top - 1).

* filter=true mode for lexers; can do this now...upon mismatch, just
  consumes a char and tries again:
lexer grammar FuzzyJava;
options {filter=true;}

FIELD
    :   TYPE WS? name=ID WS? (';'|'=')
        {System.out.println("found var "+$name.text);}
    ;

* refactored char streams so ANTLRFileStream is now a subclass of
  ANTLRStringStream.

* char streams for lexer now allowed nested backtracking in lexer.

* added TokenLabelType for lexer/parser for all token labels

* line numbers for error messages were not updated properly in antlr.g
  for strings, char literals and <<...>>

* init action in lexer rules was before the type,start,line,... decls.

* Tree grammars can now specify output; I've only tested output=templat
  though.

* You can reference EOF now in the parser and lexer.  It's just token type
  or char value -1.

* Bug fix: $ID refs in the *lexer* were all messed up.  Cleaned up the
  set of properties available...

* Bug fix: .st not found in rule ref when rule has scope:
field
scope {
	StringTemplate funcDef;
}
    :   ...
	{$field::funcDef = $field.st;}
    ;
it gets field_stack.st instead

* return in backtracking must return retval or null if return value.

* $property within a rule now works like $text, $st, ...

* AST/Template Rewrites were not gated by backtracking==0 so they
  executed even when guessing.  Auto AST construction is now gated also.

* CommonTokenStream was somehow returning tokens not text in toString()

* added useful methods to runtime.BitSet and also to CommonToken so you can
  update the text.  Added nice Token stream method:

  /** Given a start and stop index, return a List of all tokens in
   *  the token type BitSet.  Return null if no tokens were found.  This
   *  method looks at both on and off channel tokens.
   */
  public List getTokens(int start, int stop, BitSet types);

* literals are now passed in the .tokens files so you can ref them in
  tree parses, for example.

* added basic exception handling; no labels, just general catches:

a : {;}A | B ;
        exception
                catch[RecognitionException re] {
                        System.out.println("recog error");
                }
                catch[Exception e] {
                        System.out.println("error");
                }

* Added method to TokenStream:
  public String toString(Token start, Token stop);

* antlr generates #src lines in lexer grammars generated from combined grammars
  so error messages refer to original file.

* lexers generated from combined grammars now use originally formatting.

* predicates have $x.y stuff translated now.  Warning: predicates might be
  hoisted out of context.

* return values in return val structs are now public.

* output=template with return values on rules was broken.  I assume return values with ASTs was broken too.  Fixed.

3.0ea7 - December 14, 2005

* Added -print option to print out grammar w/o actions

* Renamed BaseParser to be BaseRecognizer and even made Lexer derive from
  this; nice as it now shares backtracking support code.

* Added syntactic predicates (...)=>.  See December 4, 2005 entry:

  http://www.antlr.org/blog/antlr3/lookahead.tml

  Note that we have a new option for turning off rule memoization during
  backtracking:

  -nomemo        when backtracking don't generate memoization code

* Predicates are now tested in order that you specify the alts.  If you
  leave the last alt "naked" (w/o pred), it will assume a true pred rather
  than union of other preds.

* Added gated predicates "{p}?=>" that literally turn off a production whereas
disambiguating predicates are only hoisted into the predictor when syntax alone
is not sufficient to uniquely predict alternatives.

A : {p}?  => "a" ;
B : {!p}? => ("a"|"b")+ ;

* bug fixed related to predicates in predictor
lexer grammar w;
A : {p}? "a" ;
B : {!p}? ("a"|"b")+ ;
DFA is correct.  A state splits for input "a" on the pred.
Generated code though was hosed.  No pred tests in prediction code!
I added testLexerPreds() and others in TestSemanticPredicateEvaluation.java

* added execAction template in case we want to do something in front of
  each action execution or something.

* left-recursive cycles from rules w/o decisions were not detected.

* undefined lexer rules were not announced! fixed.

* unreachable messages for Tokens rule now indicate rule name not alt. E.g.,

  Ruby.lexer.g:24:1: The following token definitions are unreachable: IVAR

* nondeterminism warnings improved for Tokens rule:

Ruby.lexer.g:10:1: Multiple token rules can match input such as ""0".."9"": INT, FLOAT
As a result, tokens(s) FLOAT were disabled for that input


* DOT diagrams didn't show escaped char properly.

* Char/string literals are now all 'abc' not "abc".

* action syntax changed "@scope::actionname {action}" where scope defaults
  to "parser" if parser grammar or combined grammar, "lexer" if lexer grammar,
  and "treeparser" if tree grammar.  The code generation targets decide
  what scopes are available.  Each "scope" yields a hashtable for use in
  the output templates.  The scopes full of actions are sent to all output
  file templates (currently headerFile and outputFile) as attribute actions.
  Then you can reference <actions.scope> to get the map of actions associated
  with scope and <actions.parser.header> to get the parser's header action
  for example.  This should be very flexible.  The target should only have
  to define which scopes are valid, but the action names should be variable
  so we don't have to recompile ANTLR to add actions to code gen templates.

  grammar T;
  options {language=Java;}
  @header { package foo; }
  @parser::stuff { int i; } // names within scope not checked; target dependent
  @members { int i; }
  @lexer::header {head}
  @lexer::members { int j; }
  @headerfile::blort {...} // error: this target doesn't have headerfile
  @treeparser::members {...} // error: this is not a tree parser
  a
  @init {int i;}
    : ID
    ;
  ID : 'a'..'z';

  For now, the Java target uses members and header as a valid name.  Within a
  rule, the init action name is valid.

* changed $dynamicscope.value to $dynamicscope::value even if value is defined
  in same rule such as $function::name where rule function defines name.

* $dynamicscope gets you the stack

* rule scopes go like this now:

  rule
  scope {...}
  scope slist,Symbols;
  	: ...
	;

* Created RuleReturnScope as a generic rule return value.  Makes it easier
  to do this:
    RuleReturnScope r = parser.program();
    System.out.println(r.getTemplate().toString());

* $template, $tree, $start, etc...

* $r.x in current rule.  $r is ignored as fully-qualified name. $r.start works too

* added warning about $r referring to both return value of rule and dynamic scope of rule

* integrated StringTemplate in a very simple manner

Syntax:
-> template(arglist) "..."
-> template(arglist) <<...>>
-> namedTemplate(arglist)
-> {free expression}
-> // empty

Predicate syntax:
a : A B -> {p1}? foo(a={$A.text})
        -> {p2}? foo(a={$B.text})
        -> // return nothing

An arg list is just a list of template attribute assignments to actions in curlies.

There is a setTemplateLib() method for you to use with named template rewrites.

Use a new option:

grammar t;
options {output=template;}
...

This all should work for tree grammars too, but I'm still testing.

* fixed bugs where strings were improperly escaped in exceptions, comments, etc..  For example, newlines came out as newlines not the escaped version

3.0ea6 - November 13, 2005

* turned off -debug/-profile, which was on by default

* completely refactored the output templates; added some missing templates.

* dramatically improved infinite recursion error messages (actually
  left-recursion never even was printed out before).

* wasn't printing dangling state messages when it reanalyzes with k=1.

* fixed a nasty bug in the analysis engine dealing with infinite recursion.
  Spent all day thinking about it and cleaned up the code dramatically.
  Bug fixed and software is more powerful and I understand it better! :)

* improved verbose DFA nodes; organized by alt

* got much better random phrase generation.  For example:

 $ java org.antlr.tool.RandomPhrase simple.g program
 int Ktcdn ';' method wh '(' ')' '{' return 5 ';' '}'

* empty rules like "a : ;" generated code that didn't compile due to
  try/catch for RecognitionException.  Generated code couldn't possibly
  throw that exception.

* when printing out a grammar, such as in comments in generated code,
  ANTLR didn't print ast suffix stuff back out for literals.

* This never exited loop:
  DATA : (options {greedy=false;}: .* '\n' )* '\n' '.' ;
  and now it works due to new default nongreedy .*  Also this works:
  DATA : (options {greedy=false;}: .* '\n' )* '.' ;

* Dot star ".*" syntax didn't work; in lexer it is nongreedy by
  default.  In parser it is on greedy but also k=1 by default.  Added
  unit tests.  Added blog entry to describe.

* ~T where T is the only token yielded an empty set but no error

* Used to generate unreachable message here:

  parser grammar t;
  a : ID a
    | ID
    ;

  z.g:3:11: The following alternatives are unreachable: 2

  In fact it should really be an error; now it generates:

  no start rule in grammar t (no rule can obviously be followed by EOF)

  Per next change item, ANTLR cannot know that EOF follows rule 'a'.

* added error message indicating that ANTLR can't figure out what your
  start rule is.  Required to properly generate code in some cases.

* validating semantic predicates now work (if they are false, they
  throw a new FailedPredicateException

* two hideous bug fixes in the IntervalSet, which made analysis go wrong
  in a few cases.  Thanks to Oliver Zeigermann for finding lots of bugs
  and making suggested fixes (including the next two items)!

* cyclic DFAs are now nonstatic and hence can access instance variables

* labels are now allowed on lexical elements (in the lexer)

* added some internal debugging options

* ~'a'* and ~('a')* were not working properly; refactored antlr.g grammar

3.0ea5 - July 5, 2005

* Using '\n' in a parser grammar resulted in a nonescaped version of '\n' in the token names table making compilation fail.  I fixed this by reorganizing/cleaning up portion of ANTLR that deals with literals.  See comment org.antlr.codegen.Target.

* Target.getMaxCharValue() did not use the appropriate max value constant.

* ALLCHAR was a constant when it should use the Target max value def.  set complement for wildcard also didn't use the Target def.  Generally cleaned up the max char value stuff.

* Code gen didn't deal with ASTLabelType properly...I think even the 3.0ea7 example tree parser was broken! :(

* Added a few more unit tests dealing with escaped literals

3.0ea4 - June 29, 2005

* tree parsers work; added CommonTreeNodeStream.  See simplecTreeParser
  example in examples-v3 tarball.

* added superClass and ASTLabelType options

* refactored Parser to have a BaseParser and added TreeParser

* bug fix: actions being dumped in description strings; compile errors
  resulted

3.0ea3 - June 23, 2005

Enhancements

* Automatic tree construction operators are in: ! ^ ^^

* Tree construction rewrite rules are in
	-> {pred1}? rewrite1
	-> {pred2}? rewrite2
	...
	-> rewriteN

  The rewrite rules may be elements like ID, expr, $label, {node expr}
  and trees ^( <root> <children> ).  You have have (...)?, (...)*, (...)+
  subrules as well.

  You may have rewrites in subrules not just at outer level of rule, but
  any -> rewrite forces auto AST construction off for that alternative
  of that rule.

  To avoid cycles, copy semantics are used:

  r : INT -> INT INT ;

  means make two new nodes from the same INT token.

  Repeated references to a rule element implies a copy for at least one
  tree:

  a : atom -> ^(atom atom) ; // NOT CYCLE! (dup atom tree)

* $ruleLabel.tree refers to tree created by matching the labeled element.

* A description of the blocks/alts is generated as a comment in output code

* A timestamp / signature is put at top of each generated code file

3.0ea2 - June 12, 2005

Bug fixes

* Some error messages were missing the stackTrace parameter

* Removed the file locking mechanism as it's not cross platform

* Some absolute vs relative path name problems with writing output
  files.  Rules are now more concrete.  -o option takes precedence
  // -o /tmp /var/lib/t.g => /tmp/T.java
  // -o subdir/output /usr/lib/t.g => subdir/output/T.java
  // -o . /usr/lib/t.g => ./T.java
  // -o /tmp subdir/t.g => /tmp/subdir/t.g
  // If they didn't specify a -o dir so just write to location
  // where grammar is, absolute or relative

* does error checking on unknown option names now

* Using just language code not locale name for error message file.  I.e.,
  the default (and for any English speaking locale) is en.stg not en_US.stg
  anymore.

* The error manager now asks the Tool to panic rather than simply doing
  a System.exit().

* Lots of refactoring concerning grammar, rule, subrule options.  Now
  detects invalid options.

3.0ea1 - June 1, 2005

Initial early access release
