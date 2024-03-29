// [The "BSD licence"]
// Copyright (c) 2006-2007 Kay Roepke
// All rights reserved.
//
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions
// are met:
// 1. Redistributions of source code must retain the above copyright
//    notice, this list of conditions and the following disclaimer.
// 2. Redistributions in binary form must reproduce the above copyright
//    notice, this list of conditions and the following disclaimer in the
//    documentation and/or other materials provided with the distribution.
// 3. The name of the author may not be used to endorse or promote products
//    derived from this software without specific prior written permission.
//
// THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
// IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
// OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
// IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
// INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
// NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
// DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
// THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
// (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
// THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.



#import "ANTLRBaseRecognizer.h"
#import "ANTLRBitSet.h"
#import "ANTLRCommonToken.h"

@class ANTLRRuleReturnScope;
@implementation ANTLRBaseRecognizer

- (id) init
{
	if (nil != (self = [super init])) {
		following = [[NSMutableArray alloc] init];
		errorRecovery = NO;
		lastErrorIndex = -1;
		failed = NO;
		backtracking = 0;
	}
	return self;
}

- (void) dealloc
{
	[following release];
	[super dealloc];
}

- (BOOL) isFailed
{
	return failed;
}

- (void) setIsFailed: (BOOL) flag
{
	failed = flag;
}

- (BOOL) isBacktracking
{
	return backtracking > 0;
}

- (int) backtrackingLevel
{
	return backtracking;
}

// reset the recognizer to the initial state. does not touch the token source!
// this can be extended by the grammar writer to reset custom ivars
- (void) reset
{
	errorRecovery = NO;
	lastErrorIndex = -1;
	failed = NO;
	backtracking = 0;
	[following removeAllObjects]; 
	[ruleMemo removeAllObjects];
}

// match the next token on the input stream. try to recover with the FOLLOW set is there is a mismatch
- (void) match:(id<ANTLRIntStream>)input 
	 tokenType:(ANTLRTokenType) ttype
		follow:(ANTLRBitSet *)follow
{
	ANTLRTokenType _ttype = [input LA:1];
	if (_ttype == ttype) {
		[input consume];
		errorRecovery = NO;
		failed = NO;
		return;
	}
	if (backtracking > 0) {
		failed = YES;
		return;
	}
	[self mismatch:input tokenType:ttype follow:follow];
}

// prepare and exception and try to recover from a mismatch
- (void) mismatch:(id<ANTLRIntStream>)aStream tokenType:(int)aTType follow:(ANTLRBitSet *)aBitset
{
	ANTLRMismatchedTokenException *mte = [ANTLRMismatchedTokenException exceptionWithTokenType:aTType stream:aStream];
	[self recoverFromMismatchedToken:aStream exception:mte tokenType:aTType follow:aBitset];
}

// just consume the next symbol and reset the error ivars
- (void) matchAny:(id<ANTLRIntStream>)input
{
	errorRecovery = NO;
	failed = NO;
	[input consume];
}

// everything failed. report the error
- (void) reportError:(NSException *)e
{
	if (errorRecovery) {
		return;
	}
	errorRecovery = YES;
	[self displayRecognitionError:NSStringFromClass([self class]) tokenNames:[self tokenNames] exception:e];
}

// override to implement a different display strategy.
- (void) displayRecognitionError:(NSString *)name tokenNames:(NSArray *)tokenNames exception:(NSException *)e
{
	NSLog(@"%@", [e description]);
}

// try to recover from a mismatch by resyncing
- (void) recover:(id<ANTLRIntStream>)input exception:(NSException *)e
{
	if (lastErrorIndex == [input index]) {
		[input consume];
	}
	lastErrorIndex = [input index];
	ANTLRBitSet *followSet = [self computeErrorRecoverySet];
	[self beginResync];
	[self consumeUntil:input bitSet:followSet];
	[self endResync];
}

// code smell...:(
// hooks for debugger
- (void) beginResync
{
}

- (void) endResync
{
}

- (void)beginBacktracking:(int)level
{
}

- (void)endBacktracking:(int)level wasSuccessful:(BOOL)successful
{
}

// end hooks for debugger

- (ANTLRBitSet *)computeErrorRecoverySet
{
	return [self combineFollowsExact:NO];
}

- (ANTLRBitSet *)computeContextSensitiveRuleFOLLOW
{
	return [self combineFollowsExact:YES];
}

// compute a new FOLLOW set for recovery using the rules we have descended through
- (ANTLRBitSet *)combineFollowsExact:(BOOL)exact
{
	ANTLRBitSet *followSet = [[[ANTLRBitSet alloc] init] autorelease];
	int i;
	for (i = [following count]-1; i >= 0; i--) {
		ANTLRBitSet *localFollowSet = [following objectAtIndex:i];
		[followSet orInPlace:localFollowSet];
		if (exact && ![localFollowSet isMember:ANTLRTokenTypeEOR]) {
			break;
		}
	}
	[followSet remove:ANTLRTokenTypeEOR];
	return followSet;
}


// delete one token and try to carry on.
- (void) recoverFromMismatchedToken:(id<ANTLRIntStream>)input 
						  exception:(NSException *)e 
						  tokenType:(ANTLRTokenType)ttype 
							 follow:(ANTLRBitSet *)follow
{
	if ([input LA:2] == ttype) {
		[self reportError:e];
		[self beginResync];
		[input consume];
		[self endResync];
		[input consume];
		return;
	}
	if (![self recoverFromMismatchedElement:input exception:e follow:follow]) {
		@throw e;
	}
}

- (void) recoverFromMismatchedSet:(id<ANTLRIntStream>)input
						exception:(NSException *)e
						   follow:(ANTLRBitSet *)follow
{
	// TODO - recovery is currently incomplete in ANTLR
	if (![self recoverFromMismatchedElement:input exception:e follow:follow]) {
		@throw e;
	}
}

// this code handles single token insertion recovery
- (BOOL) recoverFromMismatchedElement:(id<ANTLRIntStream>)input
							exception:(NSException *)e
							   follow:(ANTLRBitSet *)follow
{
	if (follow == nil) {
		return NO;
	}
	
	// compute the viable symbols that can follow the current rule
	ANTLRBitSet *localFollow = follow;
	if ([follow isMember:ANTLRTokenTypeEOR]) {
		ANTLRBitSet *viableTokensFollowingThisRule = [self computeContextSensitiveRuleFOLLOW];
		ANTLRBitSet *localFollow = [follow or:viableTokensFollowingThisRule];
		[localFollow remove:ANTLRTokenTypeEOR];
	}
	// if the current token could follow the missing token we tell the user and proceed with matching
	if ([localFollow isMember:[input LA:1]]) {
		[self reportError:e];
		return YES;
	}
	// otherwise the match fails
	return NO;
}

// used in resyncing to skip to next token of a known type
- (void) consumeUntil:(id<ANTLRIntStream>)input
			tokenType:(ANTLRTokenType)theTtype
{
	ANTLRTokenType ttype = [input LA:1];
	while (ttype != ANTLRTokenTypeEOF && ttype != theTtype) {
		[input consume];
		ttype = [input LA:1];
	}
}

// used in resyncing to skip to the next token whose type in the bitset
- (void) consumeUntil:(id<ANTLRIntStream>)input
			   bitSet:(ANTLRBitSet *)bitSet
{
	ANTLRTokenType ttype = [input LA:1];
	while (ttype != ANTLRTokenTypeEOF && ![bitSet isMember:ttype]) {
		[input consume];
		ttype = [input LA:1];
	}
}

- (void) pushFollow:(ANTLRBitSet *)follow
{
	[following addObject:follow];
}


- (NSArray *) ruleInvocationStack
{
	return [self ruleInvocationStack:nil recognizer:[self class]];
}


- (NSArray *) ruleInvocationStack:(id) exception
					   recognizer:(Class) recognizerClass
{
	// todo
	return [NSArray arrayWithObject:[@"not implemented yet: " stringByAppendingString:NSStringFromClass(recognizerClass)]];
}


- (NSArray *) tokenNames
{
	return tokenNames;
}

- (NSString *) grammarFileName
{
	return grammarFileName;
}

// pure convenience
- (NSArray *) toStrings:(NSArray *)tokens
{
	if (tokens == nil ) {
		return nil;
	}
	NSMutableArray *strings = [[[NSArray alloc] init] autorelease];
	NSEnumerator *tokensEnumerator = [tokens objectEnumerator];
	id value;
	while (nil != (value = [tokensEnumerator nextObject])) {
		[strings addObject:[(ANTLRToken *)value text]];
	}
	return strings;
}


// TODO need an Objective-C StringTemplate implementation for this
- (NSArray *) toTemplates:(NSArray *)retvals
{
	return nil;
#warning Templates are not yet supported in ObjC!
}

// the following methods handle the "memoization" caching functionality
// they work by associating token indices with rule numbers.
// that way, when we are about to parse a rule and have parsed the rule previously, e.g. in prediction,
// we don't have to do it again but can simply return the token index to continue up parsing at.

- (int) ruleMemoization:(int)ruleIndex startIndex:(int)ruleStartIndex
{
	if ([ruleMemo count] < ruleIndex) {
		[ruleMemo setObject:[NSMutableDictionary dictionary] forKey:[NSNumber numberWithInt:ruleIndex]];
	}
	NSNumber *stopIndexI = [ruleMemo objectForKey:[NSNumber numberWithInt:ruleIndex]];
	if (stopIndexI == nil) {
		return ANTLR_MEMO_RULE_UNKNOWN;
	} else {
		return [stopIndexI intValue];
	}
}

- (BOOL) alreadyParsedRule:(id<ANTLRIntStream>)input ruleIndex:(int)ruleIndex
{
	int stopIndex = [self ruleMemoization:ruleIndex startIndex:[input index]];
	if (stopIndex == ANTLR_MEMO_RULE_UNKNOWN) {
		return NO;
	}
	if (stopIndex == ANTLR_MEMO_RULE_FAILED) {
		failed = YES;
	} else {
		[input seek:stopIndex+1];
	}
	return YES;
}

- (void) memoize:(id<ANTLRIntStream>)input
	   ruleIndex:(int)ruleIndex
	  startIndex:(int)ruleStartIndex
{
	int stopTokenIndex = failed ? ANTLR_MEMO_RULE_FAILED : [input index]-1;
	if ([ruleMemo objectForKey:[NSNumber numberWithInt:ruleIndex]] == nil) {
		[ruleMemo setObject:[NSNumber numberWithInt:stopTokenIndex] forKey:[NSNumber numberWithInt:ruleStartIndex]];
	}
}

- (int) ruleMemoizationCacheSize
{
	int n = 0;
	
	NSEnumerator *ruleEnumerator = [ruleMemo objectEnumerator];
	id value;
	while ((value = [ruleEnumerator nextObject])) {
		n += [value count];
	}
	return n;
}

// call a syntactic predicate methods using its selector. this way we can support arbitrary synpreds.
- (BOOL) evaluateSyntacticPredicate:(SEL)synpredFragment // stream:(id<ANTLRIntStream>)input
{
    backtracking++;
	[self beginBacktracking:backtracking];
	int start = [[self input] mark];
    @try {
        [self performSelector:synpredFragment];
    }
    @catch (ANTLRRecognitionException *re) {
        NSLog(@"impossible synpred: %@", re);
    }
    BOOL success = !failed;
    [[self input] rewind:start];
	[self endBacktracking:backtracking wasSuccessful:success];
	backtracking--;
    failed = NO;
    return success;
}	

@end
