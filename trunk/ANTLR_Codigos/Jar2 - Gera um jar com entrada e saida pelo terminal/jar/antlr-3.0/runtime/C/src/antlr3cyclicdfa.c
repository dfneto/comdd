/** Support functions for traversing cyclic DFA states as laid
 *  out in static initialized structures by the code generator.
 *
 * A DFA implemented as a set of transition tables.
 *
 *  Any state that has a semantic predicate edge is special; those states
 *  are generated with if-then-else structures in a ->specialStateTransition()
 *  which is generated by cyclicDFA template.
 *
 *  There are at most 32767 states (16-bit signed short).
 *  Could get away with byte sometimes but would have to generate different
 *  types and the simulation code too.  For a point of reference, the Java
 *  lexer's Tokens rule DFA has 326 states roughly.
 */
#include    <antlr3defs.h>
#include    <antlr3cyclicdfa.h>

#ifdef	WIN32
#pragma warning( disable : 4100 )
#endif

static void
noViableAlt(pANTLR3_BASE_RECOGNIZER rec, pANTLR3_CYCLIC_DFA cdfa, ANTLR3_UINT32	s)
{
    if	(rec->backtracking > 0)
    {
	rec->failed = ANTLR3_TRUE;
    }
    rec->exConstruct(rec);
    rec->exception->type         = ANTLR3_NO_VIABLE_ALT_EXCEPTION;
    rec->exception->message      = cdfa->description;
    rec->exception->decisionNum  = cdfa->decisionNumber;
    rec->exception->state        = s;
}

/** From the input stream, predict what alternative will succeed
 *  using this DFA (representing the covering regular approximation
 *  to the underlying CFL).  Return an alternative number 1..n.  Throw
 *  an exception upon error.
 */
ANTLR3_API ANTLR3_INT32
antlr3dfapredict (void * ctx, pANTLR3_BASE_RECOGNIZER rec, pANTLR3_INT_STREAM is, pANTLR3_CYCLIC_DFA cdfa)
{
    ANTLR3_UINT64	mark;
    ANTLR3_INT32	s;
    ANTLR3_INT32	specialState;
    ANTLR3_INT32	c;

    mark	= is->mark(is);	    /* Store where we are right now	*/
    s		= 0;		    /* Always start with state 0	*/
    
    for (;;)
    {
	/* Pick out any special state entry for this state
	 */
	specialState	= cdfa->special[s];
	
	/* Transition the special state and consume an input token
	 */
	if  (specialState >= 0)
	{
	    s = cdfa->specialStateTransition(ctx, rec, is, cdfa, specialState);
	    is->consume(is);
	    continue;
	}

	/* Accept state?
	 */
	if  (cdfa->accept[s] >= 1)
	{
	    is->rewind(is, mark);
	    return  cdfa->accept[s];
	}

	/* Look for a normal transition stae based upon the input token element
	 */
	c = is->_LA(is, 1);

	/* Check against min and max for this state
	 */
	if  (c>= cdfa->min[s] && c <= cdfa->max[s])
	{
	    ANTLR3_INT32   snext;

	    /* What is the next state?
	     */
	    snext = cdfa->transition[s][c - cdfa->min[s]];

	    if	(snext < 0)
	    {
		/* was in range but not a normal transition
		 * must check EOT, which is like the else clause.
		 * eot[s]>=0 indicates that an EOT edge goes to another
		 * state.
		 */
		if  (cdfa->eot[s] >= 0)
		{
		    s = cdfa->eot[s];
		    is->consume(is);
		    continue;
		}
		noViableAlt(rec,cdfa, s);
		is->rewind(is, mark);
		return	0;
	    }

	    /* New current state - move to it
	     */
	    s	= snext;
	    is->consume(is);
	    continue;
	}
	/* EOT Transistion?
	 */
	if  (cdfa->eot[s] >= 0)
	{
	    s	= cdfa->eot[s];
	    is->consume(is);
	    continue;
	}
	/* EOF transition to accept state?
	 */
	if  ( c == ANTLR3_TOKEN_EOF && cdfa->eof[s] >= 0)
	{
	    is->rewind(is, mark);
	    return  cdfa->accept[cdfa->eof[s]];
	}

	/* No alt, so bomb
	 */
	noViableAlt(rec, cdfa, s);
        is->rewind(is, mark);
	return 0;
    }
    
}

/** Default special state implementation
 */
ANTLR3_API ANTLR3_INT32	
antlr3dfaspecialStateTransition   (void * ctx, pANTLR3_BASE_RECOGNIZER recognizer, pANTLR3_INT_STREAM is, pANTLR3_CYCLIC_DFA dfa, ANTLR3_UINT32 s)
{
    return -1;
}

/* Default special transition implementation
 */
ANTLR3_API ANTLR3_INT32
antlr3dfaspecialTransition    (void * ctx, pANTLR3_BASE_RECOGNIZER recognizer, pANTLR3_INT_STREAM is, pANTLR3_CYCLIC_DFA dfa, ANTLR3_UINT32 s)
{
    return 0;
}
