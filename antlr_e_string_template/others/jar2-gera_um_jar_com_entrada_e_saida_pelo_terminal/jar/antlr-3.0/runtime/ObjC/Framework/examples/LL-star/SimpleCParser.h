// $ANTLR 3.0b6 SimpleC.g 2007-02-01 01:27:57

#import <Cocoa/Cocoa.h>
#import <ANTLR/ANTLR.h>


#pragma mark Cyclic DFA
@interface SimpleCParserDFA2 : ANTLRDFA {} @end


#pragma mark Tokens
#define SimpleCParser_INT	5
#define SimpleCParser_WS	6
#define SimpleCParser_EOF	-1
#define SimpleCParser_ID	4

#pragma mark Dynamic Global Scopes

#pragma mark Dynamic Rule Scopes

#pragma mark Rule Return Scopes


@interface SimpleCParser : ANTLRParser {

	SimpleCParserDFA2 *dfa2;
																

 }


- (void) program;
- (void) declaration;
- (void) variable;
- (void) declarator;
- (NSString*) functionHeader;
- (void) formalParameter;
- (void) type;
- (void) block;
- (void) stat;
- (void) forStat;
- (void) assignStat;
- (void) expr;
- (void) condExpr;
- (void) aexpr;
- (void) atom;



@end