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
package org.antlr.runtime;

import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.CommonTree;

/** The root of the ANTLR exception hierarchy.
 *
 *  To avoid English-only error messages and to generally make things
 *  as flexible as possible, these exceptions are not created with strings,
 *  but rather the information necessary to generate an error.  Then
 *  the various reporting methods in Parser and Lexer can be overridden
 *  to generate a localized error message.  For example, MismatchedToken
 *  exceptions are built with the expected token type.
 *  So, don't expect getMessage() to return anything.
 *
 *  Note that as of Java 1.4, you can access the stack trace, which means
 *  that you can compute the complete trace of rules from the start symbol.
 *  This gives you considerable context information with which to generate
 *  useful error messages.
 *
 *  ANTLR generates code that throws exceptions upon recognition error and
 *  also generates code to catch these exceptions in each rule.  If you
 *  want to quit upon first error, you can turn off the automatic error
 *  handling mechanism using rulecatch action, but you still need to
 *  override methods mismatch and recoverFromMismatchSet.
 *
 *  In general, the recognition exceptions can track where in a grammar a
 *  problem occurred and/or what was the expected input.  While the parser
 *  knows its state (such as current input symbol and line info) that
 *  state can change before the exception is reported so current token index
 *  is computed and stored at exception time.  From this info, you can
 *  perhaps print an entire line of input not just a single token, for example.
 *  Better to just say the recognizer had a problem and then let the parser
 *  figure out a fancy report.
 */
public class RecognitionException extends Exception {
	/** What input stream did the error occur in? */
	public transient IntStream input;

	/** What is index of token/char were we looking at when the error occurred? */
	public int index;

	/** The current Token when an error occurred.  Since not all streams
	 *  can retrieve the ith Token, we have to track the Token object.
	 *  For parsers.  Even when it's a tree parser, token might be set.
	 */
	public Token token;

	/** If this is a tree parser exception, node is set to the node with
	 *  the problem.
	 */
	public Object node;

	/** The current char when an error occurred. For lexers. */
	public int c;

	/** Track the line at which the error occurred in case this is
	 *  generated from a lexer.  We need to track this since the
	 *  unexpected char doesn't carry the line info.
	 */
	public int line;

	public int charPositionInLine;

	/** Used for remote debugger deserialization */
	public RecognitionException() {
	}

	public RecognitionException(IntStream input) {
		this.input = input;
		this.index = input.index();
		if ( input instanceof TokenStream ) {
			this.token = ((TokenStream)input).LT(1);
			this.line = token.getLine();
			this.charPositionInLine = token.getCharPositionInLine();
		}
		if ( input instanceof CommonTreeNodeStream ) {
			this.node = ((CommonTreeNodeStream)input).LT(1);
			if ( this.node instanceof CommonTree ) {
				this.token = ((CommonTree)this.node).token;
				this.line = token.getLine();
				this.charPositionInLine = token.getCharPositionInLine();
			}
		}
		else if ( input instanceof CharStream ) {
			this.c = input.LA(1);
			this.line = ((CharStream)input).getLine();
			this.charPositionInLine = ((CharStream)input).getCharPositionInLine();
		}
		else {
			this.c = input.LA(1);
		}
	}

	/** Return the token type or char of the unexpected input element */
	public int getUnexpectedType() {
		if ( input instanceof TokenStream ) {
			return token.getType();
		}
		else {
			return c;
		}
	}
}
