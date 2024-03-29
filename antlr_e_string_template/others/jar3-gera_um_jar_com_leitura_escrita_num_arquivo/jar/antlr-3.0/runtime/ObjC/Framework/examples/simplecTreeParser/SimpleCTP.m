// $ANTLR 3.0b6 SimpleCTP.gtp 2007-02-01 01:28:02

#import "SimpleCTP.h"

#pragma mark Cyclic DFA

#pragma mark Bitsets
const static unsigned long long FOLLOW_declaration_in_program43_data[] = {0x0000000000000192LL};
static ANTLRBitSet *FOLLOW_declaration_in_program43;
const static unsigned long long FOLLOW_variable_in_declaration63_data[] = {0x0000000000000002LL};
static ANTLRBitSet *FOLLOW_variable_in_declaration63;
const static unsigned long long FOLLOW_SimpleCTP_FUNC_DECL_in_declaration74_data[] = {0x0000000000000004LL};
static ANTLRBitSet *FOLLOW_SimpleCTP_FUNC_DECL_in_declaration74;
const static unsigned long long FOLLOW_functionHeader_in_declaration76_data[] = {0x0000000000000008LL};
static ANTLRBitSet *FOLLOW_functionHeader_in_declaration76;
const static unsigned long long FOLLOW_SimpleCTP_FUNC_DEF_in_declaration88_data[] = {0x0000000000000004LL};
static ANTLRBitSet *FOLLOW_SimpleCTP_FUNC_DEF_in_declaration88;
const static unsigned long long FOLLOW_functionHeader_in_declaration90_data[] = {0x0000000000000200LL};
static ANTLRBitSet *FOLLOW_functionHeader_in_declaration90;
const static unsigned long long FOLLOW_block_in_declaration92_data[] = {0x0000000000000008LL};
static ANTLRBitSet *FOLLOW_block_in_declaration92;
const static unsigned long long FOLLOW_SimpleCTP_VAR_DEF_in_variable113_data[] = {0x0000000000000004LL};
static ANTLRBitSet *FOLLOW_SimpleCTP_VAR_DEF_in_variable113;
const static unsigned long long FOLLOW_type_in_variable115_data[] = {0x0000000000000400LL};
static ANTLRBitSet *FOLLOW_type_in_variable115;
const static unsigned long long FOLLOW_declarator_in_variable117_data[] = {0x0000000000000008LL};
static ANTLRBitSet *FOLLOW_declarator_in_variable117;
const static unsigned long long FOLLOW_SimpleCTP_ID_in_declarator137_data[] = {0x0000000000000002LL};
static ANTLRBitSet *FOLLOW_SimpleCTP_ID_in_declarator137;
const static unsigned long long FOLLOW_SimpleCTP_FUNC_HDR_in_functionHeader158_data[] = {0x0000000000000004LL};
static ANTLRBitSet *FOLLOW_SimpleCTP_FUNC_HDR_in_functionHeader158;
const static unsigned long long FOLLOW_type_in_functionHeader160_data[] = {0x0000000000000400LL};
static ANTLRBitSet *FOLLOW_type_in_functionHeader160;
const static unsigned long long FOLLOW_SimpleCTP_ID_in_functionHeader162_data[] = {0x0000000000000020LL};
static ANTLRBitSet *FOLLOW_SimpleCTP_ID_in_functionHeader162;
const static unsigned long long FOLLOW_formalParameter_in_functionHeader164_data[] = {0x0000000000000028LL};
static ANTLRBitSet *FOLLOW_formalParameter_in_functionHeader164;
const static unsigned long long FOLLOW_SimpleCTP_ARG_DEF_in_formalParameter186_data[] = {0x0000000000000004LL};
static ANTLRBitSet *FOLLOW_SimpleCTP_ARG_DEF_in_formalParameter186;
const static unsigned long long FOLLOW_type_in_formalParameter188_data[] = {0x0000000000000400LL};
static ANTLRBitSet *FOLLOW_type_in_formalParameter188;
const static unsigned long long FOLLOW_declarator_in_formalParameter190_data[] = {0x0000000000000008LL};
static ANTLRBitSet *FOLLOW_declarator_in_formalParameter190;
const static unsigned long long FOLLOW_set_in_type210_data[] = {0x0000000000000002LL};
static ANTLRBitSet *FOLLOW_set_in_type210;
const static unsigned long long FOLLOW_SimpleCTP_BLOCK_in_block273_data[] = {0x0000000000000004LL};
static ANTLRBitSet *FOLLOW_SimpleCTP_BLOCK_in_block273;
const static unsigned long long FOLLOW_variable_in_block275_data[] = {0x00000000000E3E18LL};
static ANTLRBitSet *FOLLOW_variable_in_block275;
const static unsigned long long FOLLOW_stat_in_block278_data[] = {0x00000000000E3E08LL};
static ANTLRBitSet *FOLLOW_stat_in_block278;
const static unsigned long long FOLLOW_forStat_in_stat292_data[] = {0x0000000000000002LL};
static ANTLRBitSet *FOLLOW_forStat_in_stat292;
const static unsigned long long FOLLOW_expr_in_stat300_data[] = {0x0000000000000002LL};
static ANTLRBitSet *FOLLOW_expr_in_stat300;
const static unsigned long long FOLLOW_block_in_stat308_data[] = {0x0000000000000002LL};
static ANTLRBitSet *FOLLOW_block_in_stat308;
const static unsigned long long FOLLOW_SimpleCTP_FOR_in_forStat328_data[] = {0x0000000000000004LL};
static ANTLRBitSet *FOLLOW_SimpleCTP_FOR_in_forStat328;
const static unsigned long long FOLLOW_expr_in_forStat330_data[] = {0x00000000000E1C00LL};
static ANTLRBitSet *FOLLOW_expr_in_forStat330;
const static unsigned long long FOLLOW_expr_in_forStat332_data[] = {0x00000000000E1C00LL};
static ANTLRBitSet *FOLLOW_expr_in_forStat332;
const static unsigned long long FOLLOW_expr_in_forStat334_data[] = {0x0000000000000200LL};
static ANTLRBitSet *FOLLOW_expr_in_forStat334;
const static unsigned long long FOLLOW_block_in_forStat336_data[] = {0x0000000000000008LL};
static ANTLRBitSet *FOLLOW_block_in_forStat336;
const static unsigned long long FOLLOW_SimpleCTP_EQEQ_in_expr352_data[] = {0x0000000000000004LL};
static ANTLRBitSet *FOLLOW_SimpleCTP_EQEQ_in_expr352;
const static unsigned long long FOLLOW_expr_in_expr354_data[] = {0x00000000000E1C00LL};
static ANTLRBitSet *FOLLOW_expr_in_expr354;
const static unsigned long long FOLLOW_expr_in_expr356_data[] = {0x0000000000000008LL};
static ANTLRBitSet *FOLLOW_expr_in_expr356;
const static unsigned long long FOLLOW_SimpleCTP_LT_in_expr368_data[] = {0x0000000000000004LL};
static ANTLRBitSet *FOLLOW_SimpleCTP_LT_in_expr368;
const static unsigned long long FOLLOW_expr_in_expr370_data[] = {0x00000000000E1C00LL};
static ANTLRBitSet *FOLLOW_expr_in_expr370;
const static unsigned long long FOLLOW_expr_in_expr372_data[] = {0x0000000000000008LL};
static ANTLRBitSet *FOLLOW_expr_in_expr372;
const static unsigned long long FOLLOW_SimpleCTP_PLUS_in_expr384_data[] = {0x0000000000000004LL};
static ANTLRBitSet *FOLLOW_SimpleCTP_PLUS_in_expr384;
const static unsigned long long FOLLOW_expr_in_expr386_data[] = {0x00000000000E1C00LL};
static ANTLRBitSet *FOLLOW_expr_in_expr386;
const static unsigned long long FOLLOW_expr_in_expr388_data[] = {0x0000000000000008LL};
static ANTLRBitSet *FOLLOW_expr_in_expr388;
const static unsigned long long FOLLOW_SimpleCTP_EQ_in_expr400_data[] = {0x0000000000000004LL};
static ANTLRBitSet *FOLLOW_SimpleCTP_EQ_in_expr400;
const static unsigned long long FOLLOW_SimpleCTP_ID_in_expr402_data[] = {0x00000000000E1C00LL};
static ANTLRBitSet *FOLLOW_SimpleCTP_ID_in_expr402;
const static unsigned long long FOLLOW_expr_in_expr404_data[] = {0x0000000000000008LL};
static ANTLRBitSet *FOLLOW_expr_in_expr404;
const static unsigned long long FOLLOW_atom_in_expr415_data[] = {0x0000000000000002LL};
static ANTLRBitSet *FOLLOW_atom_in_expr415;
const static unsigned long long FOLLOW_set_in_atom432_data[] = {0x0000000000000002LL};
static ANTLRBitSet *FOLLOW_set_in_atom432;


#pragma mark Dynamic Global Scopes

#pragma mark Dynamic Rule Scopes

#pragma mark Rule return scopes start

@implementation SimpleCTP

+ (void) initialize
{
	FOLLOW_declaration_in_program43 = [[ANTLRBitSet alloc] initWithBits:FOLLOW_declaration_in_program43_data count:1];
	FOLLOW_variable_in_declaration63 = [[ANTLRBitSet alloc] initWithBits:FOLLOW_variable_in_declaration63_data count:1];
	FOLLOW_SimpleCTP_FUNC_DECL_in_declaration74 = [[ANTLRBitSet alloc] initWithBits:FOLLOW_SimpleCTP_FUNC_DECL_in_declaration74_data count:1];
	FOLLOW_functionHeader_in_declaration76 = [[ANTLRBitSet alloc] initWithBits:FOLLOW_functionHeader_in_declaration76_data count:1];
	FOLLOW_SimpleCTP_FUNC_DEF_in_declaration88 = [[ANTLRBitSet alloc] initWithBits:FOLLOW_SimpleCTP_FUNC_DEF_in_declaration88_data count:1];
	FOLLOW_functionHeader_in_declaration90 = [[ANTLRBitSet alloc] initWithBits:FOLLOW_functionHeader_in_declaration90_data count:1];
	FOLLOW_block_in_declaration92 = [[ANTLRBitSet alloc] initWithBits:FOLLOW_block_in_declaration92_data count:1];
	FOLLOW_SimpleCTP_VAR_DEF_in_variable113 = [[ANTLRBitSet alloc] initWithBits:FOLLOW_SimpleCTP_VAR_DEF_in_variable113_data count:1];
	FOLLOW_type_in_variable115 = [[ANTLRBitSet alloc] initWithBits:FOLLOW_type_in_variable115_data count:1];
	FOLLOW_declarator_in_variable117 = [[ANTLRBitSet alloc] initWithBits:FOLLOW_declarator_in_variable117_data count:1];
	FOLLOW_SimpleCTP_ID_in_declarator137 = [[ANTLRBitSet alloc] initWithBits:FOLLOW_SimpleCTP_ID_in_declarator137_data count:1];
	FOLLOW_SimpleCTP_FUNC_HDR_in_functionHeader158 = [[ANTLRBitSet alloc] initWithBits:FOLLOW_SimpleCTP_FUNC_HDR_in_functionHeader158_data count:1];
	FOLLOW_type_in_functionHeader160 = [[ANTLRBitSet alloc] initWithBits:FOLLOW_type_in_functionHeader160_data count:1];
	FOLLOW_SimpleCTP_ID_in_functionHeader162 = [[ANTLRBitSet alloc] initWithBits:FOLLOW_SimpleCTP_ID_in_functionHeader162_data count:1];
	FOLLOW_formalParameter_in_functionHeader164 = [[ANTLRBitSet alloc] initWithBits:FOLLOW_formalParameter_in_functionHeader164_data count:1];
	FOLLOW_SimpleCTP_ARG_DEF_in_formalParameter186 = [[ANTLRBitSet alloc] initWithBits:FOLLOW_SimpleCTP_ARG_DEF_in_formalParameter186_data count:1];
	FOLLOW_type_in_formalParameter188 = [[ANTLRBitSet alloc] initWithBits:FOLLOW_type_in_formalParameter188_data count:1];
	FOLLOW_declarator_in_formalParameter190 = [[ANTLRBitSet alloc] initWithBits:FOLLOW_declarator_in_formalParameter190_data count:1];
	FOLLOW_set_in_type210 = [[ANTLRBitSet alloc] initWithBits:FOLLOW_set_in_type210_data count:1];
	FOLLOW_SimpleCTP_BLOCK_in_block273 = [[ANTLRBitSet alloc] initWithBits:FOLLOW_SimpleCTP_BLOCK_in_block273_data count:1];
	FOLLOW_variable_in_block275 = [[ANTLRBitSet alloc] initWithBits:FOLLOW_variable_in_block275_data count:1];
	FOLLOW_stat_in_block278 = [[ANTLRBitSet alloc] initWithBits:FOLLOW_stat_in_block278_data count:1];
	FOLLOW_forStat_in_stat292 = [[ANTLRBitSet alloc] initWithBits:FOLLOW_forStat_in_stat292_data count:1];
	FOLLOW_expr_in_stat300 = [[ANTLRBitSet alloc] initWithBits:FOLLOW_expr_in_stat300_data count:1];
	FOLLOW_block_in_stat308 = [[ANTLRBitSet alloc] initWithBits:FOLLOW_block_in_stat308_data count:1];
	FOLLOW_SimpleCTP_FOR_in_forStat328 = [[ANTLRBitSet alloc] initWithBits:FOLLOW_SimpleCTP_FOR_in_forStat328_data count:1];
	FOLLOW_expr_in_forStat330 = [[ANTLRBitSet alloc] initWithBits:FOLLOW_expr_in_forStat330_data count:1];
	FOLLOW_expr_in_forStat332 = [[ANTLRBitSet alloc] initWithBits:FOLLOW_expr_in_forStat332_data count:1];
	FOLLOW_expr_in_forStat334 = [[ANTLRBitSet alloc] initWithBits:FOLLOW_expr_in_forStat334_data count:1];
	FOLLOW_block_in_forStat336 = [[ANTLRBitSet alloc] initWithBits:FOLLOW_block_in_forStat336_data count:1];
	FOLLOW_SimpleCTP_EQEQ_in_expr352 = [[ANTLRBitSet alloc] initWithBits:FOLLOW_SimpleCTP_EQEQ_in_expr352_data count:1];
	FOLLOW_expr_in_expr354 = [[ANTLRBitSet alloc] initWithBits:FOLLOW_expr_in_expr354_data count:1];
	FOLLOW_expr_in_expr356 = [[ANTLRBitSet alloc] initWithBits:FOLLOW_expr_in_expr356_data count:1];
	FOLLOW_SimpleCTP_LT_in_expr368 = [[ANTLRBitSet alloc] initWithBits:FOLLOW_SimpleCTP_LT_in_expr368_data count:1];
	FOLLOW_expr_in_expr370 = [[ANTLRBitSet alloc] initWithBits:FOLLOW_expr_in_expr370_data count:1];
	FOLLOW_expr_in_expr372 = [[ANTLRBitSet alloc] initWithBits:FOLLOW_expr_in_expr372_data count:1];
	FOLLOW_SimpleCTP_PLUS_in_expr384 = [[ANTLRBitSet alloc] initWithBits:FOLLOW_SimpleCTP_PLUS_in_expr384_data count:1];
	FOLLOW_expr_in_expr386 = [[ANTLRBitSet alloc] initWithBits:FOLLOW_expr_in_expr386_data count:1];
	FOLLOW_expr_in_expr388 = [[ANTLRBitSet alloc] initWithBits:FOLLOW_expr_in_expr388_data count:1];
	FOLLOW_SimpleCTP_EQ_in_expr400 = [[ANTLRBitSet alloc] initWithBits:FOLLOW_SimpleCTP_EQ_in_expr400_data count:1];
	FOLLOW_SimpleCTP_ID_in_expr402 = [[ANTLRBitSet alloc] initWithBits:FOLLOW_SimpleCTP_ID_in_expr402_data count:1];
	FOLLOW_expr_in_expr404 = [[ANTLRBitSet alloc] initWithBits:FOLLOW_expr_in_expr404_data count:1];
	FOLLOW_atom_in_expr415 = [[ANTLRBitSet alloc] initWithBits:FOLLOW_atom_in_expr415_data count:1];
	FOLLOW_set_in_atom432 = [[ANTLRBitSet alloc] initWithBits:FOLLOW_set_in_atom432_data count:1];

}


- (id) initWithTreeNodeStream:(id<ANTLRTreeNodeStream>)aStream
{
	if ((self = [super initWithTreeNodeStream:aStream])) {

		tokenNames = [[NSArray alloc] initWithObjects:@"<invalid>", @"<EOR>", @"<DOWN>", @"<UP>", 
	@"VAR_DEF", @"ARG_DEF", @"FUNC_HDR", @"FUNC_DECL", @"FUNC_DEF", @"BLOCK", 
	@"ID", @"EQ", @"INT", @"FOR", @"INT_TYPE", @"CHAR", @"VOID", @"EQEQ", @"LT", 
	@"PLUS", @"WS", @"';'", @"'('", @"','", @"')'", @"'{'", @"'}'", nil];

																										
	}
	return self;
}

- (void) dealloc
{
	[tokenNames release];

	[super dealloc];
}

- (NSString *) grammarFileName
{
	return @"SimpleCTP.gtp";
}


// $ANTLR start program
// SimpleCTP.gtp:8:1: program : ( declaration )+ ;
- (void) program
{
    // token labels
    // token+rule list labels
    // rule labels
    // rule list labels
    // rule refs in alts with rewrites

    @try {
        // SimpleCTP.gtp:9:9: ( ( declaration )+ ) // ruleBlockSingleAlt
        // SimpleCTP.gtp:9:9: ( declaration )+ // alt
        {
        // SimpleCTP.gtp:9:9: ( declaration )+	// positiveClosureBlock
        int cnt1=0;

        do {
            int alt1=2;
            {
            	int LA1_0 = [input LA:1];
            	if ( LA1_0==SimpleCTP_VAR_DEF||(LA1_0>=SimpleCTP_FUNC_DECL && LA1_0<=SimpleCTP_FUNC_DEF) ) {
            		alt1 = 1;
            	}

            }
            switch (alt1) {
        	case 1 :
        	    // SimpleCTP.gtp:9:9: declaration // alt
        	    {
        	    [following addObject:FOLLOW_declaration_in_program43];
        	    [self declaration];
        	    [following removeLastObject];



        	    }
        	    break;

        	default :
        	    if ( cnt1 >= 1 )  goto loop1;
        			ANTLREarlyExitException *eee = [ANTLREarlyExitException exceptionWithStream:input decisionNumber:1];
        			@throw eee;
            }
            cnt1++;
        } while (YES); loop1: ;


        }

    }
	@catch (ANTLRRecognitionException *re) {
		[self reportError:re];
		[self recover:input exception:re];
	}
	@finally {
		// token labels
		// token+rule list labels
		// rule labels
		// rule refs in alts with rewrites

	}
	return ;
}
// $ANTLR end program

// $ANTLR start declaration
// SimpleCTP.gtp:12:1: declaration : ( variable | ^( FUNC_DECL functionHeader ) | ^( FUNC_DEF functionHeader block ) );
- (void) declaration
{
    // token labels
    // token+rule list labels
    // rule labels
    // rule list labels
    // rule refs in alts with rewrites

    @try {
        // SimpleCTP.gtp:13:9: ( variable | ^( FUNC_DECL functionHeader ) | ^( FUNC_DEF functionHeader block ) ) //ruleblock
        int alt2=3;
        switch ([input LA:1]) {
        	case SimpleCTP_VAR_DEF:
        		alt2 = 1;
        		break;
        	case SimpleCTP_FUNC_DECL:
        		alt2 = 2;
        		break;
        	case SimpleCTP_FUNC_DEF:
        		alt2 = 3;
        		break;
        default:
         {
            ANTLRNoViableAltException *nvae = [ANTLRNoViableAltException exceptionWithDecision:2 state:0 stream:input];
        	@throw nvae;

        	}}
        switch (alt2) {
        	case 1 :
        	    // SimpleCTP.gtp:13:9: variable // alt
        	    {
        	    [following addObject:FOLLOW_variable_in_declaration63];
        	    [self variable];
        	    [following removeLastObject];



        	    }
        	    break;
        	case 2 :
        	    // SimpleCTP.gtp:14:9: ^( FUNC_DECL functionHeader ) // alt
        	    {
        	    [self match:input tokenType:SimpleCTP_FUNC_DECL follow:FOLLOW_SimpleCTP_FUNC_DECL_in_declaration74]; 

        	    [self match:input tokenType:ANTLRTokenTypeDOWN follow:nil]; 
        	    [following addObject:FOLLOW_functionHeader_in_declaration76];
        	    [self functionHeader];
        	    [following removeLastObject];



        	    [self match:input tokenType:ANTLRTokenTypeUP follow:nil]; 

        	    }
        	    break;
        	case 3 :
        	    // SimpleCTP.gtp:15:9: ^( FUNC_DEF functionHeader block ) // alt
        	    {
        	    [self match:input tokenType:SimpleCTP_FUNC_DEF follow:FOLLOW_SimpleCTP_FUNC_DEF_in_declaration88]; 

        	    [self match:input tokenType:ANTLRTokenTypeDOWN follow:nil]; 
        	    [following addObject:FOLLOW_functionHeader_in_declaration90];
        	    [self functionHeader];
        	    [following removeLastObject];


        	    [following addObject:FOLLOW_block_in_declaration92];
        	    [self block];
        	    [following removeLastObject];



        	    [self match:input tokenType:ANTLRTokenTypeUP follow:nil]; 

        	    }
        	    break;

        }
    }
	@catch (ANTLRRecognitionException *re) {
		[self reportError:re];
		[self recover:input exception:re];
	}
	@finally {
		// token labels
		// token+rule list labels
		// rule labels
		// rule refs in alts with rewrites

	}
	return ;
}
// $ANTLR end declaration

// $ANTLR start variable
// SimpleCTP.gtp:18:1: variable : ^( VAR_DEF type declarator ) ;
- (void) variable
{
    // token labels
    // token+rule list labels
    // rule labels
    // rule list labels
    // rule refs in alts with rewrites

    @try {
        // SimpleCTP.gtp:19:9: ( ^( VAR_DEF type declarator ) ) // ruleBlockSingleAlt
        // SimpleCTP.gtp:19:9: ^( VAR_DEF type declarator ) // alt
        {
        [self match:input tokenType:SimpleCTP_VAR_DEF follow:FOLLOW_SimpleCTP_VAR_DEF_in_variable113]; 

        [self match:input tokenType:ANTLRTokenTypeDOWN follow:nil]; 
        [following addObject:FOLLOW_type_in_variable115];
        [self type];
        [following removeLastObject];


        [following addObject:FOLLOW_declarator_in_variable117];
        [self declarator];
        [following removeLastObject];



        [self match:input tokenType:ANTLRTokenTypeUP follow:nil]; 

        }

    }
	@catch (ANTLRRecognitionException *re) {
		[self reportError:re];
		[self recover:input exception:re];
	}
	@finally {
		// token labels
		// token+rule list labels
		// rule labels
		// rule refs in alts with rewrites

	}
	return ;
}
// $ANTLR end variable

// $ANTLR start declarator
// SimpleCTP.gtp:22:1: declarator : ID ;
- (void) declarator
{
    // token labels
    // token+rule list labels
    // rule labels
    // rule list labels
    // rule refs in alts with rewrites

    @try {
        // SimpleCTP.gtp:23:9: ( ID ) // ruleBlockSingleAlt
        // SimpleCTP.gtp:23:9: ID // alt
        {
        [self match:input tokenType:SimpleCTP_ID follow:FOLLOW_SimpleCTP_ID_in_declarator137]; 

        }

    }
	@catch (ANTLRRecognitionException *re) {
		[self reportError:re];
		[self recover:input exception:re];
	}
	@finally {
		// token labels
		// token+rule list labels
		// rule labels
		// rule refs in alts with rewrites

	}
	return ;
}
// $ANTLR end declarator

// $ANTLR start functionHeader
// SimpleCTP.gtp:26:1: functionHeader : ^( FUNC_HDR type ID ( formalParameter )+ ) ;
- (void) functionHeader
{
    // token labels
    // token+rule list labels
    // rule labels
    // rule list labels
    // rule refs in alts with rewrites

    @try {
        // SimpleCTP.gtp:27:9: ( ^( FUNC_HDR type ID ( formalParameter )+ ) ) // ruleBlockSingleAlt
        // SimpleCTP.gtp:27:9: ^( FUNC_HDR type ID ( formalParameter )+ ) // alt
        {
        [self match:input tokenType:SimpleCTP_FUNC_HDR follow:FOLLOW_SimpleCTP_FUNC_HDR_in_functionHeader158]; 

        [self match:input tokenType:ANTLRTokenTypeDOWN follow:nil]; 
        [following addObject:FOLLOW_type_in_functionHeader160];
        [self type];
        [following removeLastObject];


        [self match:input tokenType:SimpleCTP_ID follow:FOLLOW_SimpleCTP_ID_in_functionHeader162]; 
        // SimpleCTP.gtp:27:28: ( formalParameter )+	// positiveClosureBlock
        int cnt3=0;

        do {
            int alt3=2;
            {
            	int LA3_0 = [input LA:1];
            	if ( LA3_0==SimpleCTP_ARG_DEF ) {
            		alt3 = 1;
            	}

            }
            switch (alt3) {
        	case 1 :
        	    // SimpleCTP.gtp:27:28: formalParameter // alt
        	    {
        	    [following addObject:FOLLOW_formalParameter_in_functionHeader164];
        	    [self formalParameter];
        	    [following removeLastObject];



        	    }
        	    break;

        	default :
        	    if ( cnt3 >= 1 )  goto loop3;
        			ANTLREarlyExitException *eee = [ANTLREarlyExitException exceptionWithStream:input decisionNumber:3];
        			@throw eee;
            }
            cnt3++;
        } while (YES); loop3: ;


        [self match:input tokenType:ANTLRTokenTypeUP follow:nil]; 

        }

    }
	@catch (ANTLRRecognitionException *re) {
		[self reportError:re];
		[self recover:input exception:re];
	}
	@finally {
		// token labels
		// token+rule list labels
		// rule labels
		// rule refs in alts with rewrites

	}
	return ;
}
// $ANTLR end functionHeader

// $ANTLR start formalParameter
// SimpleCTP.gtp:30:1: formalParameter : ^( ARG_DEF type declarator ) ;
- (void) formalParameter
{
    // token labels
    // token+rule list labels
    // rule labels
    // rule list labels
    // rule refs in alts with rewrites

    @try {
        // SimpleCTP.gtp:31:9: ( ^( ARG_DEF type declarator ) ) // ruleBlockSingleAlt
        // SimpleCTP.gtp:31:9: ^( ARG_DEF type declarator ) // alt
        {
        [self match:input tokenType:SimpleCTP_ARG_DEF follow:FOLLOW_SimpleCTP_ARG_DEF_in_formalParameter186]; 

        [self match:input tokenType:ANTLRTokenTypeDOWN follow:nil]; 
        [following addObject:FOLLOW_type_in_formalParameter188];
        [self type];
        [following removeLastObject];


        [following addObject:FOLLOW_declarator_in_formalParameter190];
        [self declarator];
        [following removeLastObject];



        [self match:input tokenType:ANTLRTokenTypeUP follow:nil]; 

        }

    }
	@catch (ANTLRRecognitionException *re) {
		[self reportError:re];
		[self recover:input exception:re];
	}
	@finally {
		// token labels
		// token+rule list labels
		// rule labels
		// rule refs in alts with rewrites

	}
	return ;
}
// $ANTLR end formalParameter

// $ANTLR start type
// SimpleCTP.gtp:34:1: type : ('int'|'char'|'void'|ID);
- (void) type
{
    // token labels
    // token+rule list labels
    // rule labels
    // rule list labels
    // rule refs in alts with rewrites

    @try {
        // SimpleCTP.gtp:35:5: ( ('int'|'char'|'void'|ID)) // ruleBlockSingleAlt
        // SimpleCTP.gtp:35:9: ('int'|'char'|'void'|ID) // alt
        {
        if ([input LA:1]==SimpleCTP_ID||([input LA:1]>=SimpleCTP_INT_TYPE && [input LA:1]<=SimpleCTP_VOID)) {
        	[input consume];
        	errorRecovery = NO;
        } else {
        	ANTLRMismatchedSetException *mse = [ANTLRMismatchedSetException exceptionWithSet:nil stream:input];
        	[self recoverFromMismatchedSet:input exception:mse follow:FOLLOW_set_in_type210];	@throw mse;
        }


        }

    }
	@catch (ANTLRRecognitionException *re) {
		[self reportError:re];
		[self recover:input exception:re];
	}
	@finally {
		// token labels
		// token+rule list labels
		// rule labels
		// rule refs in alts with rewrites

	}
	return ;
}
// $ANTLR end type

// $ANTLR start block
// SimpleCTP.gtp:41:1: block : ^( BLOCK ( variable )* ( stat )* ) ;
- (void) block
{
    // token labels
    // token+rule list labels
    // rule labels
    // rule list labels
    // rule refs in alts with rewrites

    @try {
        // SimpleCTP.gtp:42:9: ( ^( BLOCK ( variable )* ( stat )* ) ) // ruleBlockSingleAlt
        // SimpleCTP.gtp:42:9: ^( BLOCK ( variable )* ( stat )* ) // alt
        {
        [self match:input tokenType:SimpleCTP_BLOCK follow:FOLLOW_SimpleCTP_BLOCK_in_block273]; 

        if ( [input LA:1] == ANTLRTokenTypeDOWN ) {
            [self match:input tokenType:ANTLRTokenTypeDOWN follow:nil]; 
            do {
                int alt4=2;
                {
                	int LA4_0 = [input LA:1];
                	if ( LA4_0==SimpleCTP_VAR_DEF ) {
                		alt4 = 1;
                	}

                }
                switch (alt4) {
            	case 1 :
            	    // SimpleCTP.gtp:42:17: variable // alt
            	    {
            	    [following addObject:FOLLOW_variable_in_block275];
            	    [self variable];
            	    [following removeLastObject];



            	    }
            	    break;

            	default :
            	    goto loop4;
                }
            } while (YES); loop4: ;

            do {
                int alt5=2;
                {
                	int LA5_0 = [input LA:1];
                	if ( (LA5_0>=SimpleCTP_BLOCK && LA5_0<=SimpleCTP_FOR)||(LA5_0>=SimpleCTP_EQEQ && LA5_0<=SimpleCTP_PLUS) ) {
                		alt5 = 1;
                	}

                }
                switch (alt5) {
            	case 1 :
            	    // SimpleCTP.gtp:42:27: stat // alt
            	    {
            	    [following addObject:FOLLOW_stat_in_block278];
            	    [self stat];
            	    [following removeLastObject];



            	    }
            	    break;

            	default :
            	    goto loop5;
                }
            } while (YES); loop5: ;


            [self match:input tokenType:ANTLRTokenTypeUP follow:nil]; 
        }

        }

    }
	@catch (ANTLRRecognitionException *re) {
		[self reportError:re];
		[self recover:input exception:re];
	}
	@finally {
		// token labels
		// token+rule list labels
		// rule labels
		// rule refs in alts with rewrites

	}
	return ;
}
// $ANTLR end block

// $ANTLR start stat
// SimpleCTP.gtp:45:1: stat : ( forStat | expr | block );
- (void) stat
{
    // token labels
    // token+rule list labels
    // rule labels
    // rule list labels
    // rule refs in alts with rewrites

    @try {
        // SimpleCTP.gtp:45:7: ( forStat | expr | block ) //ruleblock
        int alt6=3;
        switch ([input LA:1]) {
        	case SimpleCTP_FOR:
        		alt6 = 1;
        		break;
        	case SimpleCTP_ID:
        	case SimpleCTP_EQ:
        	case SimpleCTP_INT:
        	case SimpleCTP_EQEQ:
        	case SimpleCTP_LT:
        	case SimpleCTP_PLUS:
        		alt6 = 2;
        		break;
        	case SimpleCTP_BLOCK:
        		alt6 = 3;
        		break;
        default:
         {
            ANTLRNoViableAltException *nvae = [ANTLRNoViableAltException exceptionWithDecision:6 state:0 stream:input];
        	@throw nvae;

        	}}
        switch (alt6) {
        	case 1 :
        	    // SimpleCTP.gtp:45:7: forStat // alt
        	    {
        	    [following addObject:FOLLOW_forStat_in_stat292];
        	    [self forStat];
        	    [following removeLastObject];



        	    }
        	    break;
        	case 2 :
        	    // SimpleCTP.gtp:46:7: expr // alt
        	    {
        	    [following addObject:FOLLOW_expr_in_stat300];
        	    [self expr];
        	    [following removeLastObject];



        	    }
        	    break;
        	case 3 :
        	    // SimpleCTP.gtp:47:7: block // alt
        	    {
        	    [following addObject:FOLLOW_block_in_stat308];
        	    [self block];
        	    [following removeLastObject];



        	    }
        	    break;

        }
    }
	@catch (ANTLRRecognitionException *re) {
		[self reportError:re];
		[self recover:input exception:re];
	}
	@finally {
		// token labels
		// token+rule list labels
		// rule labels
		// rule refs in alts with rewrites

	}
	return ;
}
// $ANTLR end stat

// $ANTLR start forStat
// SimpleCTP.gtp:50:1: forStat : ^( 'for' expr expr expr block ) ;
- (void) forStat
{
    // token labels
    // token+rule list labels
    // rule labels
    // rule list labels
    // rule refs in alts with rewrites

    @try {
        // SimpleCTP.gtp:51:9: ( ^( 'for' expr expr expr block ) ) // ruleBlockSingleAlt
        // SimpleCTP.gtp:51:9: ^( 'for' expr expr expr block ) // alt
        {
        [self match:input tokenType:SimpleCTP_FOR follow:FOLLOW_SimpleCTP_FOR_in_forStat328]; 

        [self match:input tokenType:ANTLRTokenTypeDOWN follow:nil]; 
        [following addObject:FOLLOW_expr_in_forStat330];
        [self expr];
        [following removeLastObject];


        [following addObject:FOLLOW_expr_in_forStat332];
        [self expr];
        [following removeLastObject];


        [following addObject:FOLLOW_expr_in_forStat334];
        [self expr];
        [following removeLastObject];


        [following addObject:FOLLOW_block_in_forStat336];
        [self block];
        [following removeLastObject];



        [self match:input tokenType:ANTLRTokenTypeUP follow:nil]; 

        }

    }
	@catch (ANTLRRecognitionException *re) {
		[self reportError:re];
		[self recover:input exception:re];
	}
	@finally {
		// token labels
		// token+rule list labels
		// rule labels
		// rule refs in alts with rewrites

	}
	return ;
}
// $ANTLR end forStat

// $ANTLR start expr
// SimpleCTP.gtp:54:1: expr : ( ^( EQEQ expr expr ) | ^( LT expr expr ) | ^( PLUS expr expr ) | ^( EQ ID expr ) | atom );
- (void) expr
{
    // token labels
    // token+rule list labels
    // rule labels
    // rule list labels
    // rule refs in alts with rewrites

    @try {
        // SimpleCTP.gtp:54:9: ( ^( EQEQ expr expr ) | ^( LT expr expr ) | ^( PLUS expr expr ) | ^( EQ ID expr ) | atom ) //ruleblock
        int alt7=5;
        switch ([input LA:1]) {
        	case SimpleCTP_EQEQ:
        		alt7 = 1;
        		break;
        	case SimpleCTP_LT:
        		alt7 = 2;
        		break;
        	case SimpleCTP_PLUS:
        		alt7 = 3;
        		break;
        	case SimpleCTP_EQ:
        		alt7 = 4;
        		break;
        	case SimpleCTP_ID:
        	case SimpleCTP_INT:
        		alt7 = 5;
        		break;
        default:
         {
            ANTLRNoViableAltException *nvae = [ANTLRNoViableAltException exceptionWithDecision:7 state:0 stream:input];
        	@throw nvae;

        	}}
        switch (alt7) {
        	case 1 :
        	    // SimpleCTP.gtp:54:9: ^( EQEQ expr expr ) // alt
        	    {
        	    [self match:input tokenType:SimpleCTP_EQEQ follow:FOLLOW_SimpleCTP_EQEQ_in_expr352]; 

        	    [self match:input tokenType:ANTLRTokenTypeDOWN follow:nil]; 
        	    [following addObject:FOLLOW_expr_in_expr354];
        	    [self expr];
        	    [following removeLastObject];


        	    [following addObject:FOLLOW_expr_in_expr356];
        	    [self expr];
        	    [following removeLastObject];



        	    [self match:input tokenType:ANTLRTokenTypeUP follow:nil]; 

        	    }
        	    break;
        	case 2 :
        	    // SimpleCTP.gtp:55:9: ^( LT expr expr ) // alt
        	    {
        	    [self match:input tokenType:SimpleCTP_LT follow:FOLLOW_SimpleCTP_LT_in_expr368]; 

        	    [self match:input tokenType:ANTLRTokenTypeDOWN follow:nil]; 
        	    [following addObject:FOLLOW_expr_in_expr370];
        	    [self expr];
        	    [following removeLastObject];


        	    [following addObject:FOLLOW_expr_in_expr372];
        	    [self expr];
        	    [following removeLastObject];



        	    [self match:input tokenType:ANTLRTokenTypeUP follow:nil]; 

        	    }
        	    break;
        	case 3 :
        	    // SimpleCTP.gtp:56:9: ^( PLUS expr expr ) // alt
        	    {
        	    [self match:input tokenType:SimpleCTP_PLUS follow:FOLLOW_SimpleCTP_PLUS_in_expr384]; 

        	    [self match:input tokenType:ANTLRTokenTypeDOWN follow:nil]; 
        	    [following addObject:FOLLOW_expr_in_expr386];
        	    [self expr];
        	    [following removeLastObject];


        	    [following addObject:FOLLOW_expr_in_expr388];
        	    [self expr];
        	    [following removeLastObject];



        	    [self match:input tokenType:ANTLRTokenTypeUP follow:nil]; 

        	    }
        	    break;
        	case 4 :
        	    // SimpleCTP.gtp:57:9: ^( EQ ID expr ) // alt
        	    {
        	    [self match:input tokenType:SimpleCTP_EQ follow:FOLLOW_SimpleCTP_EQ_in_expr400]; 

        	    [self match:input tokenType:ANTLRTokenTypeDOWN follow:nil]; 
        	    [self match:input tokenType:SimpleCTP_ID follow:FOLLOW_SimpleCTP_ID_in_expr402]; 
        	    [following addObject:FOLLOW_expr_in_expr404];
        	    [self expr];
        	    [following removeLastObject];



        	    [self match:input tokenType:ANTLRTokenTypeUP follow:nil]; 

        	    }
        	    break;
        	case 5 :
        	    // SimpleCTP.gtp:58:9: atom // alt
        	    {
        	    [following addObject:FOLLOW_atom_in_expr415];
        	    [self atom];
        	    [following removeLastObject];



        	    }
        	    break;

        }
    }
	@catch (ANTLRRecognitionException *re) {
		[self reportError:re];
		[self recover:input exception:re];
	}
	@finally {
		// token labels
		// token+rule list labels
		// rule labels
		// rule refs in alts with rewrites

	}
	return ;
}
// $ANTLR end expr

// $ANTLR start atom
// SimpleCTP.gtp:61:1: atom : (ID|INT);
- (void) atom
{
    // token labels
    // token+rule list labels
    // rule labels
    // rule list labels
    // rule refs in alts with rewrites

    @try {
        // SimpleCTP.gtp:62:5: ( (ID|INT)) // ruleBlockSingleAlt
        // SimpleCTP.gtp:62:7: (ID|INT) // alt
        {
        if ([input LA:1]==SimpleCTP_ID||[input LA:1]==SimpleCTP_INT) {
        	[input consume];
        	errorRecovery = NO;
        } else {
        	ANTLRMismatchedSetException *mse = [ANTLRMismatchedSetException exceptionWithSet:nil stream:input];
        	[self recoverFromMismatchedSet:input exception:mse follow:FOLLOW_set_in_atom432];	@throw mse;
        }


        }

    }
	@catch (ANTLRRecognitionException *re) {
		[self reportError:re];
		[self recover:input exception:re];
	}
	@finally {
		// token labels
		// token+rule list labels
		// rule labels
		// rule refs in alts with rewrites

	}
	return ;
}
// $ANTLR end atom



@end