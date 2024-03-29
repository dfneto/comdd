header {
/*
 [The "BSD licence"]
 Copyright (c) 2005-2006 Terence Parr
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
    notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions and the following disclaimer in the
    documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
    derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package org.antlr.tool;
import java.util.*;
import java.io.*;
import org.antlr.analysis.*;
import org.antlr.misc.*;
import antlr.*;
}

/** Read in an ANTLR grammar and build an AST.  Try not to do
 *  any actions, just build the tree.
 *
 *  The phases are:
 *
 *		antlr.g (this file)
 *		assign.types.g
 *		define.g
 *		buildnfa.g
 *		antlr.print.g (optional)
 *		codegen.g
 *
 *  Terence Parr
 *  University of San Francisco
 *  2005
 */
class ANTLRParser extends Parser;
options {
    buildAST = true;
	exportVocab=ANTLR;
    ASTLabelType="GrammarAST";
	k=2;
}

tokens {
	OPTIONS="options";
	TOKENS="tokens";
	PARSER="parser";
	
    LEXER;
    RULE;
    BLOCK;
    OPTIONAL;
    CLOSURE;
    POSITIVE_CLOSURE;
    SYNPRED;
    RANGE;
    CHAR_RANGE;
    EPSILON;
    ALT;
    EOR;
    EOB;
    EOA; // end of alt
    ID;
    ARG;
    ARGLIST;
    RET;
    LEXER_GRAMMAR;
    PARSER_GRAMMAR;
    TREE_GRAMMAR;
    COMBINED_GRAMMAR;
    INITACTION;
    LABEL; // $x used in rewrite rules
    TEMPLATE;
    SCOPE="scope";
    GATED_SEMPRED; // {p}? =>
    SYN_SEMPRED; // (...) =>   it's a manually-specified synpred converted to sempred
    BACKTRACK_SEMPRED; // auto backtracking mode syn pred converted to sempred
    FRAGMENT="fragment";
}

{
	Grammar grammar = null;
	protected int gtype = 0;
	protected String currentRuleName = null;
	protected GrammarAST currentBlockAST = null;

	/* this next stuff supports construction of the Tokens artificial rule.
	   I hate having some partial functionality here, I like doing everything
	   in future tree passes, but the Tokens rule is sensitive to filter mode.
	   And if it adds syn preds, future tree passes will need to process the
	   fragments defined in Tokens; a cyclic dependency.
	   As of 1-17-06 then, Tokens is created for lexer grammars in the
	   antlr grammar parser itself.

	   This grammar is also sensitive to the backtrack grammar option that
	   tells ANTLR to automatically backtrack when it can't compute a DFA.

	   7-2-06 I moved all option processing to antlr.g from define.g as I
	   need backtrack option etc... for blocks.  Got messy.
	*/
	protected List lexerRuleNames = new ArrayList();
	public List getLexerRuleNames() { return lexerRuleNames; }

	protected GrammarAST setToBlockWithSet(GrammarAST b) {
		GrammarAST alt = #(#[ALT,"ALT"],#b,#[EOA,"<end-of-alt>"]);
		prefixWithSynPred(alt);
		return #(#[BLOCK,"BLOCK"],
		           alt,
		           #[EOB,"<end-of-block>"]
		        );
	}

	/** Create a copy of the alt and make it into a BLOCK; all actions,
	 *  labels, tree operators, rewrites are removed.
	 */
	protected GrammarAST createBlockFromDupAlt(GrammarAST alt) {
		//GrammarAST nalt = (GrammarAST)astFactory.dupTree(alt);
		GrammarAST nalt = GrammarAST.dupTreeNoActions(alt, null);
		GrammarAST blk = #(#[BLOCK,"BLOCK"],
						   nalt,
						   #[EOB,"<end-of-block>"]
						  );
		return blk;
	}

	/** Rewrite alt to have a synpred as first element;
	 *  (xxx)=>xxx
	 *  but only if they didn't specify one manually.
	 */
	protected void prefixWithSynPred(GrammarAST alt) {
		// if they want backtracking and it's not a lexer rule in combined grammar
		String autoBacktrack = (String)currentBlockAST.getOption("backtrack");
		if ( autoBacktrack==null ) {
			autoBacktrack = (String)grammar.getOption("backtrack");
		}
		if ( autoBacktrack!=null&&autoBacktrack.equals("true") &&
			 !(gtype==COMBINED_GRAMMAR &&
			 Character.isUpperCase(currentRuleName.charAt(0))) &&
			 alt.getFirstChild().getType()!=SYN_SEMPRED )
		{
			// duplicate alt and make a synpred block around that dup'd alt
			GrammarAST synpredBlockAST = createBlockFromDupAlt(alt);

			// Create a BACKTRACK_SEMPRED node as if user had typed this in
			// Effectively we replace (xxx)=>xxx with {synpredxxx}? xxx
			GrammarAST synpredAST = createSynSemPredFromBlock(synpredBlockAST,
															  BACKTRACK_SEMPRED);

			// insert BACKTRACK_SEMPRED as first element of alt
			synpredAST.getLastSibling().setNextSibling(alt.getFirstChild());
			alt.setFirstChild(synpredAST);
		}
	}

	protected GrammarAST createSynSemPredFromBlock(GrammarAST synpredBlockAST,
												   int synpredTokenType)
	{
		// add grammar fragment to a list so we can make fake rules for them
		// later.
		String predName = grammar.defineSyntacticPredicate(synpredBlockAST,currentRuleName);
		// convert (alpha)=> into {synpredN}? where N is some pred count
		// during code gen we convert to function call with templates
		String synpredinvoke = predName;
		GrammarAST p = #[synpredTokenType,synpredinvoke];
		p.setEnclosingRule(currentRuleName);
		// track how many decisions have synpreds
		grammar.blocksWithSynPreds.add(currentBlockAST);
		return p;
	}

	public GrammarAST createSimpleRuleAST(String name,
										  GrammarAST block,
										  boolean fragment)
   {
   		GrammarAST modifier = null;
   		if ( fragment ) {
   			modifier = #[FRAGMENT,"fragment"];
   		}
   		GrammarAST EORAST = #[EOR,"<end-of-rule>"];
   		GrammarAST EOBAST = block.getLastChild();
		EORAST.setLine(EOBAST.getLine());
		EORAST.setColumn(EOBAST.getColumn());
		GrammarAST ruleAST =
		   #([RULE,"rule"],
                 [ID,name],modifier,[ARG,"ARG"],[RET,"RET"],
				 [SCOPE,"scope"],block,EORAST);
		ruleAST.setLine(block.getLine());
		ruleAST.setColumn(block.getColumn());
		return ruleAST;
	}

    public void reportError(RecognitionException ex) {
		Token token = null;
		try {
			token = LT(1);
		}
		catch (TokenStreamException tse) {
			ErrorManager.internalError("can't get token???", tse);
		}
		ErrorManager.syntaxError(
			ErrorManager.MSG_SYNTAX_ERROR,
			grammar,
			token,
			"antlr: "+ex.toString(),
			ex);
    }

    public void cleanup(GrammarAST root) {
		if ( gtype==LEXER_GRAMMAR ) {
			String filter = (String)grammar.getOption("filter");
			GrammarAST tokensRuleAST =
			    grammar.addArtificialMatchTokensRule(
			    	root,
			    	lexerRuleNames,
			    	filter!=null&&filter.equals("true"));
		}
    }
}

grammar![Grammar g]
{
	this.grammar = g;
	GrammarAST opt=null;
	Token optionsStartToken = null;
	Map opts;
}
   :    //hdr:headerSpec
        ( ACTION )?
	    ( cmt:DOC_COMMENT  )?
        gr:grammarType gid:id SEMI
			( {optionsStartToken=LT(1);}
			  opts=optionsSpec {grammar.setOptions(opts, optionsStartToken);}
			  {opt=(GrammarAST)returnAST;}
			)?
		    (ts:tokensSpec!)?
        	scopes:attrScopes
		    (a:actions)?
	        r:rules
        EOF
        {
        #grammar = #(null, #(#gr, #gid, #cmt, opt, #ts, #scopes, #a, #r));
        cleanup(#grammar);
        }
	;

grammarType
    :   (	"lexer"!  {gtype=LEXER_GRAMMAR;}    // pure lexer
    	|   "parser"! {gtype=PARSER_GRAMMAR;}   // pure parser
    	|   "tree"!   {gtype=TREE_GRAMMAR;}     // a tree parser
    	|			  {gtype=COMBINED_GRAMMAR;} // merged parser/lexer
    	)
    	gr:"grammar" {#gr.setType(gtype);}
    ;

actions
	:	(action)+
	;

/** Match stuff like @parser::members {int i;} */
action
	:	AMPERSAND^ (actionScopeName COLON! COLON!)? id ACTION
	;

/** Sometimes the scope names will collide with keywords; allow them as
 *  ids for action scopes.
 */
actionScopeName
	:	id
	|	l:"lexer"	{#l.setType(ID);}
    |   p:"parser"	{#p.setType(ID);}
	;

/*
optionsSpec returns [Map opts=new HashMap()]
    :   #( OPTIONS (option[opts])+ )
    ;

option[Map opts]
{
    String key=null;
    Object value=null;
}
    :   #( ASSIGN id:ID {key=#id.getText();} value=optionValue )
        {opts.put(key,value);}
    ;
*/

optionsSpec returns [Map opts=new HashMap()]
	:	OPTIONS^ (option[opts] SEMI!)+ RCURLY!
	;

option[Map opts]
{
    Object value=null;
}
    :   o:id ASSIGN^ value=optionValue
    	{
    	opts.put(#o.getText(), value);
    	}
    	/*
    	{
    	if ( #o.getText().equals("filter") && #v.getText().equals("true") ) {
    		isFilterMode = true;
    	}
    	else if ( #o.getText().equals("backtrack") && #v.getText().equals("true") ) {
    		if ( currentRuleName==null ) { // must grammar level
    			isAutoBacktrackMode = true;
    		}
    		else {
    			blockAutoBacktrackMode = true;
    		}
    	}
    	}
    	*/
    ;

optionValue returns [Object value=null]
    :   x:id			 {value = #x.getText();}
    |   s:STRING_LITERAL {String vs = #s.getText();
                          value=vs.substring(1,vs.length()-1);}
    |   c:CHAR_LITERAL   {String vs = #c.getText();
                          value=vs.substring(1,vs.length()-1);}
    |   i:INT            {value = new Integer(#i.getText());}
    |	ss:STAR			 {#ss.setType(STRING_LITERAL); value = "*";} // used for k=*
//  |   cs:charSet       {value = #cs;} // return set AST in this case
    ;

/*
optionValue
	:	id
	|   STRING_LITERAL
	|	CHAR_LITERAL
	|	INT
//	|   cs:charSet       {value = #cs;} // return set AST in this case
	;
*/

tokensSpec
	:	TOKENS^
			( tokenSpec	)+
		RCURLY!
	;

tokenSpec
	:	TOKEN_REF ( ASSIGN^ (STRING_LITERAL|CHAR_LITERAL) )? SEMI!
	;

attrScopes
	:	(attrScope)*
	;

attrScope
	:	"scope"^ id ACTION
	;

rules
    :   (
			options {
				// limitation of appox LL(k) says ambig upon
				// DOC_COMMENT TOKEN_REF, but that's an impossible sequence
				warnWhenFollowAmbig=false;
			}
		:	//{g.type==PARSER}? (aliasLexerRule)=>aliasLexerRule |
			rule
		)+
    ;

rule!
{
GrammarAST modifier=null, blk=null, blkRoot=null, eob=null;
int start = ((TokenWithIndex)LT(1)).getIndex();
int startLine = LT(1).getLine();
GrammarAST opt = null;
Map opts = null;
}
	:
	(	d:DOC_COMMENT	
	)?
	(	p1:"protected"	{modifier=#p1;}
	|	p2:"public"		{modifier=#p2;}
	|	p3:"private"    {modifier=#p3;}
	|	p4:"fragment"	{modifier=#p4;}
	)?
	ruleName:id
	{currentRuleName=#ruleName.getText();
     if ( gtype==LEXER_GRAMMAR && #p4==null ) {
         lexerRuleNames.add(currentRuleName);
	 }
	}
	( BANG )?
	( aa:ARG_ACTION )?
	( "returns" rt:ARG_ACTION  )?
	( throwsSpec )?
    ( opts=optionsSpec {opt=(GrammarAST)returnAST;} )?
	scopes:ruleScopeSpec
	(a:ruleActions)?
	colon:COLON
	{
	blkRoot = #[BLOCK,"BLOCK"];
	blkRoot.options = opts;
	blkRoot.setLine(colon.getLine());
	blkRoot.setColumn(colon.getColumn());
	eob = #[EOB,"<end-of-block>"];
    }
    /*
	(	{!currentRuleName.equals(Grammar.ARTIFICIAL_TOKENS_RULENAME)}?
		(setNoParens SEMI) => s:setNoParens // try to collapse sets
		{
		blk = #(blkRoot,#(#[ALT,"ALT"],#s,#[EOA,"<end-of-alt>"]),eob);
		}
	|	b:altList[opts] {blk = #b;}
	)
	*/
	b:altList[opts] {blk = #b;}
	semi:SEMI
	( ex:exceptionGroup )?
    {
    int stop = ((TokenWithIndex)LT(1)).getIndex()-1; // point at the semi or exception thingie
	eob.setLine(semi.getLine());
	eob.setColumn(semi.getColumn());
    GrammarAST eor = #[EOR,"<end-of-rule>"];
   	eor.setEnclosingRule(#ruleName.getText());
	eor.setLine(semi.getLine());
	eor.setColumn(semi.getColumn());
	GrammarAST root = #[RULE,"rule"];
	root.ruleStartTokenIndex = start;
	root.ruleStopTokenIndex = stop;
	root.setLine(startLine);
	root.options = opts;
    #rule = #(root,
              #ruleName,modifier,#(#[ARG,"ARG"],#aa),#(#[RET,"RET"],#rt),
              opt,#scopes,#a,blk,ex,eor);
	currentRuleName=null;
    }
	;

ruleActions
	:	(ruleAction)+
	;

/** Match stuff like @init {int i;} */
ruleAction
	:	AMPERSAND^ id ACTION
	;

throwsSpec
	:	"throws" id ( COMMA id )*
		
	;

ruleScopeSpec
{
int line = LT(1).getLine();
int column = LT(1).getColumn();
}
	:!	( options {warnWhenFollowAmbig=false;} : "scope" a:ACTION )?
		( "scope" ids:idList SEMI! )*
		{
		GrammarAST scopeRoot = (GrammarAST)#[SCOPE,"scope"];
		scopeRoot.setLine(line);
		scopeRoot.setColumn(column);
		#ruleScopeSpec = #(scopeRoot, #a, #ids);
		}
	;

/** Build #(BLOCK ( #(ALT ...) EOB )+ ) */
block
{
GrammarAST save = currentBlockAST;
Map opts=null;
}
    :   /*
        (set) => s:set  // special block like ('a'|'b'|'0'..'9')

    |	*/

    	lp:LPAREN^ {#lp.setType(BLOCK); #lp.setText("BLOCK");}
		(
			// 2nd alt and optional branch ambig due to
			// linear approx LL(2) issue.  COLON ACTION
			// matched correctly in 2nd alt.
			options {
				warnWhenFollowAmbig = false;
			}
		:
            (opts=optionsSpec {#block.setOptions(grammar,opts);})?
            ( ruleActions )?
            COLON!
		|	ACTION COLON!
		)?

		{currentBlockAST = #lp;}

		a1:alternative rewrite
		{if (LA(1)==OR||(LA(2)==QUESTION||LA(2)==PLUS||LA(2)==STAR)) prefixWithSynPred(#a1);}
		( OR! a2:alternative rewrite
		  {if (LA(1)==OR||(LA(2)==QUESTION||LA(2)==PLUS||LA(2)==STAR)) prefixWithSynPred(#a2);}
		)*

        rp:RPAREN!
        {
		currentBlockAST = save;
        GrammarAST eob = #[EOB,"<end-of-block>"];
        eob.setLine(rp.getLine());
        eob.setColumn(rp.getColumn());
        #block.addChild(eob);
        }
    ;

altList[Map opts]
{
	GrammarAST blkRoot = #[BLOCK,"BLOCK"];
	blkRoot.options = opts;
	blkRoot.setLine(LT(1).getLine());
	blkRoot.setColumn(LT(1).getColumn());
	GrammarAST save = currentBlockAST;
	currentBlockAST = #blkRoot;
}
    :   a1:alternative rewrite
		{if (LA(1)==OR||(LA(2)==QUESTION||LA(2)==PLUS||LA(2)==STAR)) prefixWithSynPred(#a1);}
    	( OR! a2:alternative rewrite
    	  {if (LA(1)==OR||(LA(2)==QUESTION||LA(2)==PLUS||LA(2)==STAR)) prefixWithSynPred(#a2);} )*
        {
        #altList = #(blkRoot,#altList,#[EOB,"<end-of-block>"]);
        currentBlockAST = save;
        }
    ;

alternative
{
    GrammarAST eoa = #[EOA, "<end-of-alt>"];
    GrammarAST altRoot = #[ALT,"ALT"];
    altRoot.setLine(LT(1).getLine());
    altRoot.setColumn(LT(1).getColumn());
}
    :   ( el:element )+
        {
            if ( #alternative==null ) {
                #alternative = #(altRoot,#[EPSILON,"epsilon"],eoa);
            }
            else {
            	// we have a real list of stuff
               	#alternative = #(altRoot, #alternative, eoa);
            }
        }
    |   {
    	GrammarAST eps = #[EPSILON,"epsilon"];
		eps.setLine(LT(0).getLine()); // get line/col of '|' or ':' (prev token)
		eps.setColumn(LT(0).getColumn());
    	#alternative = #(altRoot,eps,eoa);
    	}
    ;

exceptionGroup
	:	( exceptionHandler )+ ( finallyClause )?
	|	finallyClause
    ;

exceptionHandler
    :    "catch"^ ARG_ACTION ACTION
    ;

finallyClause
    :    "finally"^ ACTION
    ;

element
	:	elementNoOptionSpec
	;

elementNoOptionSpec
{
    IntSet elements=null;
    GrammarAST sub, sub2;
}
	:	id (ASSIGN^|PLUS_ASSIGN^) (atom|block)
        ( sub=ebnfSuffix[(GrammarAST)currentAST.root,false]! {#elementNoOptionSpec=sub;} )?
    |   atom
        ( sub2=ebnfSuffix[(GrammarAST)currentAST.root,false]! {#elementNoOptionSpec=sub2;} )?
    |	ebnf
	|   ACTION
	|   p:SEMPRED ( IMPLIES! {#p.setType(GATED_SEMPRED);} )?
		{
		#p.setEnclosingRule(currentRuleName);
		grammar.blocksWithSemPreds.add(currentBlockAST);
		}
	|   t3:tree
	;

atom:   range (ROOT^|BANG^)?
    |   terminal
    |	notSet (ROOT^|BANG^)?
    |   rr:RULE_REF^
		( ARG_ACTION )?
		(ROOT^|BANG^)?
    ;

notSet
{
    int line = LT(1).getLine();
    int col = LT(1).getColumn();
    GrammarAST subrule=null;
}
	:	n:NOT^
		(	notTerminal
        |   block
		)
        {#notSet.setLine(line); #notSet.setColumn(col);}
	;

tree :
	TREE_BEGIN^
        element ( element )+
    RPAREN!
	;

/** matches ENBF blocks (and sets via block rule) */
ebnf!
{
    int line = LT(1).getLine();
    int col = LT(1).getColumn();
}
	:	b:block
		(	QUESTION    {#ebnf=#([OPTIONAL,"?"],#b);}
		|	STAR	    {#ebnf=#([CLOSURE,"*"],#b);}
		|	PLUS	    {#ebnf=#([POSITIVE_CLOSURE,"+"],#b);}
		|   IMPLIES! // syntactic predicate
			{
			if ( gtype==COMBINED_GRAMMAR &&
			     Character.isUpperCase(currentRuleName.charAt(0)) )
		    {
                // ignore for lexer rules in combined
		    	#ebnf = #(#[SYNPRED,"=>"],#b); 
		    }
		    else {
		    	// create manually specified (...)=> predicate;
                // convert to sempred
		    	#ebnf = createSynSemPredFromBlock(#b, SYN_SEMPRED);
			}
			}
		|   ROOT {#ebnf = #(#ROOT, #b);}
		|   BANG {#ebnf = #(#BANG, #b);}
        |   {#ebnf = #b;}
		)
		{#ebnf.setLine(line); #ebnf.setColumn(col);}
	;

range!
{
GrammarAST subrule=null, root=null;
}
	:	c1:CHAR_LITERAL RANGE c2:CHAR_LITERAL
		{
		GrammarAST r = #[CHAR_RANGE,".."];
		r.setLine(c1.getLine());
		r.setColumn(c1.getColumn());
		#range = #(r, #c1, #c2);
		root = #range;
		}
//    	(subrule=ebnfSuffix[root,false] {#range=subrule;})?
	;

terminal
{
GrammarAST ebnfRoot=null, subrule=null;
}
    :   cl:CHAR_LITERAL^ (ROOT^|BANG^)?

	|   tr:TOKEN_REF^
			( ARG_ACTION )? // Args are only valid for lexer rules
            (ROOT^|BANG^)?

	|   sl:STRING_LITERAL (ROOT^|BANG^)?

	|   wi:WILDCARD (ROOT^|BANG^)?
	;

ebnfSuffix[GrammarAST elemAST, boolean inRewrite] returns [GrammarAST subrule=null]
{
GrammarAST ebnfRoot=null;
}
	:!	(	QUESTION {ebnfRoot = #[OPTIONAL,"?"];}
   		|	STAR     {ebnfRoot = #[CLOSURE,"*"];}
   		|	PLUS     {ebnfRoot = #[POSITIVE_CLOSURE,"+"];}
   		)
    	{
		GrammarAST save = currentBlockAST;
       	ebnfRoot.setLine(elemAST.getLine());
       	ebnfRoot.setColumn(elemAST.getColumn());
    	GrammarAST blkRoot = #[BLOCK,"BLOCK"];
    	currentBlockAST = blkRoot;
       	GrammarAST eob = #[EOB,"<end-of-block>"];
		eob.setLine(elemAST.getLine());
		eob.setColumn(elemAST.getColumn());
		GrammarAST alt = #(#[ALT,"ALT"],elemAST,#[EOA,"<end-of-alt>"]);
    	if ( !inRewrite ) {
    		prefixWithSynPred(alt);
    	}
  		subrule =
  		     #(ebnfRoot,
  		       #(blkRoot,alt,eob)
  		      );
  		currentBlockAST = save;
   		}
    ;

notTerminal
	:   cl:CHAR_LITERAL
	|	tr:TOKEN_REF
	|	STRING_LITERAL
	;

idList
	:	(id)+
	;

id	:	TOKEN_REF {#id.setType(ID);}
	|	RULE_REF  {#id.setType(ID);}
	;

/** Match anything that looks like an ID and return tree as token type ID */
idToken
    :	TOKEN_REF {#idToken.setType(ID);}
	|	RULE_REF  {#idToken.setType(ID);}
	;

// R E W R I T E  S Y N T A X

rewrite
{
    GrammarAST root = new GrammarAST();
}
	:!
		( options { warnWhenFollowAmbig=false;}
		: rew:REWRITE pred:SEMPRED alt:rewrite_alternative
	      {root.addChild( #(#rew, #pred, #alt) );}
		  {
          #pred.setEnclosingRule(currentRuleName);
          #rew.setEnclosingRule(currentRuleName);
          }
	    )*
		rew2:REWRITE alt2:rewrite_alternative
        {
        root.addChild( #(#rew2, #alt2) );
        #rewrite = (GrammarAST)root.getFirstChild();
        }
	|
	;

rewrite_block
    :   lp:LPAREN^ {#lp.setType(BLOCK); #lp.setText("BLOCK");}
		rewrite_alternative
        RPAREN!
        {
        GrammarAST eob = #[EOB,"<end-of-block>"];
        eob.setLine(lp.getLine());
        eob.setColumn(lp.getColumn());
        #rewrite_block.addChild(eob);
        }
    ;

rewrite_alternative
{
    GrammarAST eoa = #[EOA, "<end-of-alt>"];
    GrammarAST altRoot = #[ALT,"ALT"];
    altRoot.setLine(LT(1).getLine());
    altRoot.setColumn(LT(1).getColumn());
}
    :	{grammar.buildTemplate()}? rewrite_template

    |	{grammar.buildAST()}? ( rewrite_element )+
        {
            if ( #rewrite_alternative==null ) {
                #rewrite_alternative = #(altRoot,#[EPSILON,"epsilon"],eoa);
            }
            else {
                #rewrite_alternative = #(altRoot, #rewrite_alternative,eoa);
            }
        }

   	|   {#rewrite_alternative = #(altRoot,#[EPSILON,"epsilon"],eoa);}
    ;

rewrite_element
{
GrammarAST subrule=null;
}
	:	t:rewrite_atom
    	( subrule=ebnfSuffix[#t,true] {#rewrite_element=subrule;} )?
	|   rewrite_ebnf
	|   tr:rewrite_tree
    	( subrule=ebnfSuffix[#tr,true] {#rewrite_element=subrule;} )?
	;

rewrite_atom
{
GrammarAST subrule=null;
}
    :   cl:CHAR_LITERAL
	|   tr:TOKEN_REF^ (ARG_ACTION)? // for imaginary nodes
    |   rr:RULE_REF
	|   sl:STRING_LITERAL
	|!  d:DOLLAR i:id // reference to a label in a rewrite rule
		{
		#rewrite_atom = #[LABEL,i_AST.getText()];
		#rewrite_atom.setLine(#d.getLine());
		#rewrite_atom.setColumn(#d.getColumn());
        #rewrite_atom.setEnclosingRule(currentRuleName);
		}
	|	ACTION
	;

rewrite_ebnf!
{
    int line = LT(1).getLine();
    int col = LT(1).getColumn();
}
	:	b:rewrite_block
		(	QUESTION    {#rewrite_ebnf=#([OPTIONAL,"?"],#b);}
		|	STAR	    {#rewrite_ebnf=#([CLOSURE,"*"],#b);}
		|	PLUS	    {#rewrite_ebnf=#([POSITIVE_CLOSURE,"+"],#b);}
		)
		{#rewrite_ebnf.setLine(line); #rewrite_ebnf.setColumn(col);}
	;

rewrite_tree :
	TREE_BEGIN^
        rewrite_atom ( rewrite_element )*
    RPAREN!
	;

/** Build a tree for a template rewrite:
      ^(TEMPLATE (ID|ACTION) ^(ARGLIST ^(ARG ID ACTION) ...) )
    where ARGLIST is always there even if no args exist.
    ID can be "template" keyword.  If first child is ACTION then it's
    an indirect template ref

    -> foo(a={...}, b={...})
    -> ({string-e})(a={...}, b={...})  // e evaluates to template name
    -> {%{$ID.text}} // create literal template from string (done in ActionTranslator)
	-> {st-expr} // st-expr evaluates to ST
 */
rewrite_template
{Token st=null;}
	:   // -> template(a={...},...) "..."
		{LT(1).getText().equals("template")}? // inline
		rewrite_template_head {st=LT(1);}
		( DOUBLE_QUOTE_STRING_LITERAL! | DOUBLE_ANGLE_STRING_LITERAL! )
		{#rewrite_template.addChild(#[st]);}

	|	// -> foo(a={...}, ...)
		rewrite_template_head

	|	// -> ({expr})(a={...}, ...)
		rewrite_indirect_template_head

	|	// -> {...}
		ACTION
	;

/** -> foo(a={...}, ...) */
rewrite_template_head
	:	id lp:LPAREN^ {#lp.setType(TEMPLATE); #lp.setText("TEMPLATE");}
		rewrite_template_args
		RPAREN!
	;

/** -> ({expr})(a={...}, ...) */
rewrite_indirect_template_head
	:	lp:LPAREN^ {#lp.setType(TEMPLATE); #lp.setText("TEMPLATE");}
		ACTION
		RPAREN!
		LPAREN! rewrite_template_args RPAREN!
	;

rewrite_template_args
	:	rewrite_template_arg (COMMA! rewrite_template_arg)*
		{#rewrite_template_args = #(#[ARGLIST,"ARGLIST"], rewrite_template_args);}
	|	{#rewrite_template_args = #[ARGLIST,"ARGLIST"];}
	;

rewrite_template_arg
	:   id a:ASSIGN^ {#a.setType(ARG); #a.setText("ARG");} ACTION
	;

class ANTLRLexer extends Lexer;
options {
	k=2;
	exportVocab=ANTLR;
	testLiterals=false;
	interactive=true;
	charVocabulary='\003'..'\377';
}

{
    /** advance the current column number by one; don't do tabs.
     *  we want char position in line to be sent to AntlrWorks.
     */
    public void tab() {
		setColumn( getColumn()+1 );
    }
}

WS	:	(	' '
		|	'\t'
		|	('\r')? '\n' {newline();}
		)
	;

COMMENT :
	( SL_COMMENT | t:ML_COMMENT {$setType(t.getType());} )
	;

protected
SL_COMMENT
 	:	"//"
 	 	(	(" $ANTLR")=> " $ANTLR " SRC ('\r')? '\n' // src directive
 		|	( options {greedy=false;} : . )* ('\r')? '\n'
		)
		{ newline(); }
	;

protected
ML_COMMENT :
	"/*"
	(	{ LA(2)!='/' }? '*' {$setType(DOC_COMMENT);}
	|
	)
	(
		options {
			greedy=false;  // make it exit upon "*/"
		}
	:	'\r' '\n'	{newline();}
	|	'\n'		{newline();}
	|	~('\n'|'\r')
	)*
	"*/"
	;

OPEN_ELEMENT_OPTION
	:	'<'
	;

CLOSE_ELEMENT_OPTION
	:	'>'
	;

AMPERSAND : '@';

COMMA : ',';

QUESTION :	'?' ;

TREE_BEGIN : "^(" ;

LPAREN:	'(' ;

RPAREN:	')' ;

COLON :	':' ;

STAR:	'*' ;

PLUS:	'+' ;

ASSIGN : '=' ;

PLUS_ASSIGN : "+=" ;

IMPLIES : "=>" ;

REWRITE : "->" ;

SEMI:	';' ;

ROOT : '^' ;

BANG : '!' ;

OR	:	'|' ;

WILDCARD : '.' ;

RANGE : ".." ;

NOT :	'~' ;

RCURLY:	'}'	;

DOLLAR : '$' ;

CHAR_LITERAL
	:	'\'' (ESC|'\n'{newline();}|~'\'')* '\''
		{
		StringBuffer s = Grammar.getUnescapedStringFromGrammarStringLiteral($getText);
		if ( s.length()>1 ) {
			$setType(STRING_LITERAL);
		}
		}
	;

DOUBLE_QUOTE_STRING_LITERAL
	:	'"' ('\\'! '"'|'\n'{newline();}|~'"')* '"'
	;

DOUBLE_ANGLE_STRING_LITERAL
	:	"<<" (options {greedy=false;}:'\n'{newline();}|.)* ">>"
	;

protected
ESC	:	'\\'
		(	'n'
		|	'r'
		|	't'
		|	'b'
		|	'f'
		|	'"'
		|	'\''
		|	'\\'
		|	'>'
		|	('0'..'3')
			(
				options {
					warnWhenFollowAmbig = false;
				}
			:
			('0'..'9')
				(
					options {
						warnWhenFollowAmbig = false;
					}
				:
				'0'..'9'
				)?
			)?
		|	('4'..'7')
			(
				options {
					warnWhenFollowAmbig = false;
				}
			:
			('0'..'9')
			)?
		|	'u' XDIGIT XDIGIT XDIGIT XDIGIT
		|	. // unknown, leave as it is
		)
	;

protected
DIGIT
	:	'0'..'9'
	;

protected
XDIGIT :
		'0' .. '9'
	|	'a' .. 'f'
	|	'A' .. 'F'
	;

INT	:	('0'..'9')+
	;

ARG_ACTION
   :
	NESTED_ARG_ACTION
	;

protected
NESTED_ARG_ACTION :
	'['!
	(
		NESTED_ARG_ACTION
	|	'\r' '\n'	{newline();}
	|	'\n'		{newline();}
	|	ACTION_STRING_LITERAL
	|	~']'
	)*
	']'!
	;

ACTION
{int actionLine=getLine(); int actionColumn = getColumn(); }
	:	NESTED_ACTION
		(	'?'! {_ttype = SEMPRED;} )?
		{
			Token t = makeToken(_ttype);
			String action = $getText;
			action = action.substring(1,action.length()-1);
			t.setText(action);
			t.setLine(actionLine);			// set action line to start
			t.setColumn(actionColumn);
			$setToken(t);
		}
	;

protected
NESTED_ACTION :
	'{'
	(
		options {
			greedy = false; // exit upon '}'
		}
	:
		(
			'\r' '\n'	{newline();}
		|	'\n'		{newline();}
		)
	|	NESTED_ACTION
	|	ACTION_CHAR_LITERAL
	|	COMMENT
	|	ACTION_STRING_LITERAL
	|	.
	)*
	'}'
   ;

protected
ACTION_CHAR_LITERAL
	:	'\'' (ACTION_ESC|'\n'{newline();}|~'\'')* '\''
	;

protected
ACTION_STRING_LITERAL
	:	'"' (ACTION_ESC|'\n'{newline();}|~'"')* '"'
	;

protected
ACTION_ESC
	:	"\\'"
	|	"\\\""
	|	'\\' ~('\''|'"')
	;

TOKEN_REF
options { testLiterals = true; }
	:	'A'..'Z'
		(	// scarf as many letters/numbers as you can
			options {
				warnWhenFollowAmbig=false;
			}
		:
			'a'..'z'|'A'..'Z'|'_'|'0'..'9'
		)*
	;

// we get a warning here when looking for options '{', but it works right
RULE_REF
{
	int t=0;
}
	:	t=INTERNAL_RULE_REF {_ttype=t;}
		(	{t==OPTIONS}? WS_LOOP ('{' {_ttype = OPTIONS;})?
		|	{t==TOKENS}? WS_LOOP ('{' {_ttype = TOKENS;})?
		|
		)
	;

protected
WS_LOOP
	:	(	// grab as much WS as you can
			options {
				greedy=true;
			}
		:
			WS
		|	COMMENT
		)*
	;

protected
INTERNAL_RULE_REF returns [int t]
{
	t = RULE_REF;
}
	:	'a'..'z'
		(	// scarf as many letters/numbers as you can
			options {
				warnWhenFollowAmbig=false;
			}
		:
			'a'..'z'|'A'..'Z'|'_'|'0'..'9'
		)*
		{t = testLiteralsTable(t);}
	;

protected
WS_OPT
	:	(WS)?
	;

/** Reset the file and line information; useful when the grammar
 *  has been generated so that errors are shown relative to the
 *  original file like the old C preprocessor used to do.
 */
protected
SRC	:	"src" ' ' file:ACTION_STRING_LITERAL ' ' line:INT
		{
		newline();
		setFilename(file.getText().substring(1,file.getText().length()-1));
		setLine(Integer.parseInt(line.getText())-1);  // -1 because SL_COMMENT will increment the line no. KR
		$setType(Token.SKIP); // don't let this go to the parser
		}
	;

