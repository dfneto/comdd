/** \file Default implementaation of CommonTokenStream
 */
#include    <antlr3tokenstream.h>

#ifdef	WIN32
#pragma warning( disable : 4100 )
#endif

/* COMMON_TOKEN_STREAM API */
static void		    setTokenTypeChannel	(pANTLR3_COMMON_TOKEN_STREAM cts, ANTLR3_UINT32 ttype, ANTLR3_UINT32 channel);
static void		    discardTokenType	(pANTLR3_COMMON_TOKEN_STREAM cts, ANTLR3_INT32 ttype);
static void		    discardOffChannel	(pANTLR3_COMMON_TOKEN_STREAM cts, ANTLR3_BOOLEAN discard);
static pANTLR3_VECTOR	    getTokens		(pANTLR3_COMMON_TOKEN_STREAM cts);
static pANTLR3_LIST	    getTokenRange	(pANTLR3_COMMON_TOKEN_STREAM cts, ANTLR3_UINT64 start, ANTLR3_UINT64 stop);
static pANTLR3_LIST	    getTokensSet	(pANTLR3_COMMON_TOKEN_STREAM cts, ANTLR3_UINT64 start, ANTLR3_UINT64 stop, pANTLR3_BITSET types);
static pANTLR3_LIST	    getTokensList	(pANTLR3_COMMON_TOKEN_STREAM cts, ANTLR3_UINT64 start, ANTLR3_UINT64 stop, pANTLR3_LIST list);
static pANTLR3_LIST	    getTokensType	(pANTLR3_COMMON_TOKEN_STREAM cts, ANTLR3_UINT64 start, ANTLR3_UINT64 stop, ANTLR3_UINT32 type);

/* TOKEN_STREAM API 
 */
static pANTLR3_COMMON_TOKEN tokLT		(pANTLR3_TOKEN_STREAM ts, ANTLR3_INT64 k);
static pANTLR3_COMMON_TOKEN get			(pANTLR3_TOKEN_STREAM ts, ANTLR3_UINT64 i);
static pANTLR3_TOKEN_SOURCE getTokenSource	(pANTLR3_TOKEN_STREAM ts);
static void		    setTokenSource	(pANTLR3_TOKEN_STREAM ts, pANTLR3_TOKEN_SOURCE tokenSource);
static pANTLR3_STRING	    toString		(pANTLR3_TOKEN_STREAM ts);
static pANTLR3_STRING	    toStringSS		(pANTLR3_TOKEN_STREAM ts, ANTLR3_UINT64 start, ANTLR3_UINT64 stop);
static pANTLR3_STRING	    toStringTT		(pANTLR3_TOKEN_STREAM ts, pANTLR3_COMMON_TOKEN start, pANTLR3_COMMON_TOKEN stop);

/* INT STREAM API */
static void		    consume		(pANTLR3_INT_STREAM is);
static ANTLR3_UINT32	    _LA			(pANTLR3_INT_STREAM is, ANTLR3_INT64 i);
static ANTLR3_UINT64	    mark		(pANTLR3_INT_STREAM is);
static void		    release		(pANTLR3_INT_STREAM is, ANTLR3_UINT64 mark);
static ANTLR3_UINT64	    size		(pANTLR3_INT_STREAM is);
static ANTLR3_INT64	    tindex		(pANTLR3_INT_STREAM is);
static void		    rewindStream	(pANTLR3_INT_STREAM is, ANTLR3_UINT64 marker);
static void		    rewindLast		(pANTLR3_INT_STREAM is);
static void		    seek		(pANTLR3_INT_STREAM is, ANTLR3_UINT64 index);

static void		    antlr3TokenStreamFree   (pANTLR3_TOKEN_STREAM	    stream);
static void		    antlr3CTSFree	    (pANTLR3_COMMON_TOKEN_STREAM    stream);

/* Helpers */
static void		    fillBuffer			(pANTLR3_COMMON_TOKEN_STREAM tokenStream);
static ANTLR3_UINT64	    skipOffTokenChannels	(pANTLR3_COMMON_TOKEN_STREAM tokenStream, ANTLR3_INT64 i);
static ANTLR3_UINT64	    skipOffTokenChannelsReverse	(pANTLR3_COMMON_TOKEN_STREAM tokenStream, ANTLR3_INT64 i);
static pANTLR3_COMMON_TOKEN LB				(pANTLR3_COMMON_TOKEN_STREAM tokenStream, ANTLR3_INT64 i);

ANTLR3_API pANTLR3_TOKEN_STREAM
antlr3TokenStreamNew()
{
    pANTLR3_TOKEN_STREAM stream;

    /* Memory for the interface structure
     */
    stream  = (pANTLR3_TOKEN_STREAM) ANTLR3_MALLOC(sizeof(ANTLR3_TOKEN_STREAM));

    if	(stream == NULL)
    {
	return	(pANTLR3_TOKEN_STREAM) ANTLR3_ERR_NOMEM;
    }

    /* Install basic API 
     */
    stream->free    =  antlr3TokenStreamFree;

    
    return stream;
}

static void
antlr3TokenStreamFree(pANTLR3_TOKEN_STREAM stream)
{   
    ANTLR3_FREE(stream);
}

static void		    
antlr3CTSFree	    (pANTLR3_COMMON_TOKEN_STREAM stream)
{
   /* We only free up our subordinate interfaces if they belong
    * to us, otherwise we let whoever owns them deal with them.
    */
    if	(stream->tstream->super == stream)
    {
	if	(stream->tstream->istream->super == stream->tstream)
	{
	    stream->tstream->istream->free(stream->tstream->istream);
	    stream->tstream->istream = NULL;
	}

	stream->tstream->free(stream->tstream);
    }

    /* Now we free our own resources
     */
    if	(stream->tokens != NULL)
    {
	stream->tokens->free(stream->tokens);
	stream->tokens	= NULL;
    }
    if	(stream->discardSet != NULL)
    {
	stream->discardSet->free(stream->discardSet);
	stream->discardSet  = NULL;
    }
    if	(stream->channelOverrides != NULL)
    {
	stream->channelOverrides->free(stream->channelOverrides);
	stream->channelOverrides = NULL;
    }

    /* Free our memory now
     */
    ANTLR3_FREE(stream);
}

static void
freeEofTOken(pANTLR3_COMMON_TOKEN tok)
{
    ANTLR3_FREE(tok);
}

ANTLR3_API pANTLR3_COMMON_TOKEN_STREAM
antlr3CommonTokenStreamSourceNew(ANTLR3_UINT32 hint, pANTLR3_TOKEN_SOURCE source)
{
    pANTLR3_COMMON_TOKEN_STREAM	stream;

    stream = antlr3CommonTokenStreamNew(hint);

    stream->channel = ANTLR3_TOKEN_DEFAULT_CHANNEL;
    
    stream->channelOverrides	= NULL;
    stream->discardSet		= NULL;
    stream->discardOffChannel	= ANTLR3_TRUE;

    stream->tstream->setTokenSource(stream->tstream, source);

    stream->free		=  antlr3CTSFree;
    return  stream;
}

ANTLR3_API pANTLR3_COMMON_TOKEN_STREAM
antlr3CommonTokenStreamNew(ANTLR3_UINT32 hint)
{
    pANTLR3_COMMON_TOKEN_STREAM stream;

    /* Memory for the interface structure
     */
    stream  = (pANTLR3_COMMON_TOKEN_STREAM) ANTLR3_MALLOC(sizeof(ANTLR3_COMMON_TOKEN_STREAM));

    if	(stream == NULL)
    {
	return	(pANTLR3_COMMON_TOKEN_STREAM) ANTLR3_ERR_NOMEM;
    }

    /* Create space for the token stream interface
     */
    stream->tstream	    = antlr3TokenStreamNew();
    stream->tstream->super  =  stream;

    /* Create space for the INT_STREAM interfacce
     */
    stream->tstream->istream		    =  antlr3IntStreamNew();
    stream->tstream->istream->super	    =  (stream->tstream);
    stream->tstream->istream->type	    = ANTLR3_TOKENSTREAM;

    /* Install the token tracking tables
     */
    stream->tokens  = antlr3VectorNew(0);

    /* Defaults
     */
    stream->p	    = -1;

    /* Install the common token stream API
     */
    stream->setTokenTypeChannel	    =  setTokenTypeChannel;
    stream->discardTokenType	    =  discardTokenType;
    stream->discardOffChannelToks   =  discardOffChannel;
    stream->getTokens		    =  getTokens;
    stream->getTokenRange	    =  getTokenRange;
    stream->getTokensSet	    =  getTokensSet;
    stream->getTokensList	    =  getTokensList;
    stream->getTokensType	    =  getTokensType;

    /* Install the token stream API
     */
    stream->tstream->_LT		=  tokLT;
    stream->tstream->get		=  get;
    stream->tstream->getTokenSource	=  getTokenSource;
    stream->tstream->setTokenSource	=  setTokenSource;
    stream->tstream->toString		=  toString;
    stream->tstream->toStringSS		=  toStringSS;
    stream->tstream->toStringTT		=  toStringTT;

    /* Install INT_STREAM interface
     */
    stream->tstream->istream->_LA	=  _LA;
    stream->tstream->istream->mark	=  mark;
    stream->tstream->istream->release	=  release;
    stream->tstream->istream->size	=  size;
    stream->tstream->istream->index	=  tindex;
    stream->tstream->istream->rewind	=  rewindStream;
    stream->tstream->istream->rewindLast=  rewindLast;
    stream->tstream->istream->seek	=  seek;
    stream->tstream->istream->consume	=  consume;

    return  stream;
}

/** Get the ith token from the current position 1..n where k=1 is the
 *  first symbol of lookahead.
 */
static pANTLR3_COMMON_TOKEN 
tokLT  (pANTLR3_TOKEN_STREAM ts, ANTLR3_INT64 k)
{
    ANTLR3_INT64    i;
    ANTLR3_INT64    n;
    pANTLR3_COMMON_TOKEN_STREAM cts;

    cts	    = (pANTLR3_COMMON_TOKEN_STREAM)ts->super;
    

    if	(cts->p == -1)
    {
	fillBuffer(cts);
    }
    if	(k == 0)
    {
	return NULL;
    }
    if	(k < 0)
    {
	return LB(cts, -k);
    }
   
    if	((cts->p + k - 1) >= (ANTLR3_INT64)ts->istream->cachedSize)
    {
	pANTLR3_COMMON_TOKEN    teof = &(ts->tokenSource->eofToken);

	teof->setStartIndex (teof, ts->istream->index	    (ts->istream));
	teof->setStopIndex  (teof, ts->istream->index	    (ts->istream));
	return  teof;
    }

    i	= cts->p;
    n	= 1;

    /* Need to find k good tokens, skipping ones that are off channel
     */
    while   ( n < k)
    {
	/* Skip off-channel tokens */
	i = skipOffTokenChannels(cts, i+1); /* leave p on valid token    */
	n++;
    }
    if	( (ANTLR3_UINT64) i > ts->istream->cachedSize)
    {
	    pANTLR3_COMMON_TOKEN    teof = &(ts->tokenSource->eofToken);

	    teof->setStartIndex (teof, ts->istream->index(ts->istream));
	    teof->setStopIndex  (teof, ts->istream->index(ts->istream));
	    return  teof;
    }

    return  (pANTLR3_COMMON_TOKEN)cts->tokens->get(cts->tokens, i+1);
}

#ifdef	WIN32
	/* When fully optimized VC7 complains about non reachable code.
	 * Not yet sure if this is an optimizer bug, or a bug in the flow analysis
	 */
#pragma warning( disable : 4702 )
#endif

static	pANTLR3_COMMON_TOKEN
LB  (pANTLR3_COMMON_TOKEN_STREAM cts, ANTLR3_INT64 k)
{
    ANTLR3_INT64    i;
    ANTLR3_INT32    n;

    if	(cts->p == -1)
    {
	fillBuffer(cts);
    }
    if	(k == 0)
    {
	return NULL;
    }
    if	((cts->p - k) < 0)
    {
	return NULL;
    }

    i	= cts->p;
    n	= 1;

    /* Need to find k good tokens, going backwards, skipping ones that are off channel
     */
    while   (  n <= (ANTLR3_INT32)k )
    {
	/* Skip off-channel tokens 
	 */

	i = skipOffTokenChannelsReverse(cts, i-1); /* leave p on valid token    */
	n++;
    }
    if	( i <0 )
    {
	return	NULL;
    }

    return  (pANTLR3_COMMON_TOKEN)cts->tokens->get(cts->tokens, i+1);
}

static pANTLR3_COMMON_TOKEN 
get (pANTLR3_TOKEN_STREAM ts, ANTLR3_UINT64 i)
{
    pANTLR3_COMMON_TOKEN_STREAM cts;

    cts	    = (pANTLR3_COMMON_TOKEN_STREAM)ts->super;

    return  (pANTLR3_COMMON_TOKEN)(cts->tokens->get(cts->tokens, i+1));  /* Token index is zero based but vectors are 1 based */
}

static pANTLR3_TOKEN_SOURCE 
getTokenSource	(pANTLR3_TOKEN_STREAM ts)
{
    return  ts->tokenSource;
}

static void
setTokenSource	(   pANTLR3_TOKEN_STREAM ts,
		    pANTLR3_TOKEN_SOURCE tokenSource)
{
    ts->tokenSource	= tokenSource;
}

static pANTLR3_STRING	    
toString    (pANTLR3_TOKEN_STREAM ts)
{
    pANTLR3_COMMON_TOKEN_STREAM cts;

    cts	    = (pANTLR3_COMMON_TOKEN_STREAM)ts->super;

    if	(cts->p == -1)
    {
	fillBuffer(cts);
    }

    return  ts->toStringSS(ts, 0, ts->istream->size(ts->istream));
}

static pANTLR3_STRING	    
toStringSS   (pANTLR3_TOKEN_STREAM ts, ANTLR3_UINT64 start, ANTLR3_UINT64 stop)
{
    pANTLR3_STRING		string;
    pANTLR3_TOKEN_SOURCE	tsource;
    pANTLR3_COMMON_TOKEN	tok;
    ANTLR3_UINT64		i;
    pANTLR3_COMMON_TOKEN_STREAM cts;

    cts	    = (pANTLR3_COMMON_TOKEN_STREAM)ts->super;

    if	(cts->p == -1)
    {
	fillBuffer(cts);
    }
    if	(stop >= ts->istream->size(ts->istream))
    {
	stop = ts->istream->size(ts->istream)-1;
    }
    
    /* Who is giving us these tokens?
     */
    tsource  = ts->getTokenSource(ts);

    if	(tsource != NULL && cts->tokens != NULL)
    {
	/* Finally, let's get a string
	 */
	string	= tsource->strFactory->newRaw(tsource->strFactory);

	for (i = start; i <= stop; i++)
	{
	    tok	= ts->get(ts, i);

	    if	(tok != NULL)
	    {
		string->appendS(string, tok->getText(tok));
	    }
	}

	return	string;
    }
    return NULL;

}

static pANTLR3_STRING	    
toStringTT  (pANTLR3_TOKEN_STREAM ts, pANTLR3_COMMON_TOKEN start, pANTLR3_COMMON_TOKEN stop)
{
    if	(start != NULL && stop != NULL)
    {
	return	ts->toStringSS(ts, start->getTokenIndex(start), stop->getTokenIndex(stop));
    }
    else
    {
	return	NULL;
    }
}

/** Move the input pointer to the next incoming token.  The stream
 *  must become active with LT(1) available.  consume() simply
 *  moves the input pointer so that LT(1) points at the next
 *  input symbol. Consume at least one token.
 *
 *  Walk past any token not on the channel the parser is listening to.
 */
static void		    
consume	(pANTLR3_INT_STREAM is)
{
    pANTLR3_COMMON_TOKEN_STREAM cts;
    pANTLR3_TOKEN_STREAM	ts;

    ts	    = (pANTLR3_TOKEN_STREAM)	    is->super;
    cts	    = (pANTLR3_COMMON_TOKEN_STREAM) ts->super;

    if	((ANTLR3_UINT64)cts->p < cts->tokens->size(cts->tokens))
    {
	cts->p++;
	cts->p	= skipOffTokenChannels(cts, cts->p);
    }
}
/** A simple filter mechanism whereby you can tell this token stream
 *  to force all tokens of type ttype to be on channel.  For example,
 *  when interpreting, we cannot execute actions so we need to tell
 *  the stream to force all WS and NEWLINE to be a different, ignored,
 *  channel.
 */
static void		    
setTokenTypeChannel (pANTLR3_COMMON_TOKEN_STREAM tokenStream, ANTLR3_UINT32 ttype, ANTLR3_UINT32 channel)
{
    if	(tokenStream->channelOverrides == NULL)
    {
	tokenStream->channelOverrides	= antlr3ListNew(10);
    }

    /* We add one to the channel so we can distinguish NULL as being no entry in the
     * table for a particular token type.
     */
    tokenStream->channelOverrides->put(tokenStream->channelOverrides, ttype, ANTLR3_FUNC_PTR((ANTLR3_UINT64)channel + 1), NULL);
}

static void		    
discardTokenType    (pANTLR3_COMMON_TOKEN_STREAM tokenStream, ANTLR3_INT32 ttype)
{
    if	(tokenStream->discardSet == NULL)
    {
	tokenStream->discardSet	= antlr3ListNew(31);
    }

    /* We add one to the channel so we can distinguish NULL as being no entry in the
     * table for a particular token type. We could use bitsets for this I suppose too.
     */
    tokenStream->discardSet->put(tokenStream->discardSet, ttype, ANTLR3_FUNC_PTR((ANTLR3_UINT64)ttype + 1), NULL);
}

static void		    
discardOffChannel   (pANTLR3_COMMON_TOKEN_STREAM tokenStream, ANTLR3_BOOLEAN discard)
{
    tokenStream->discardOffChannel  = discard;
}

static pANTLR3_VECTOR	    
getTokens   (pANTLR3_COMMON_TOKEN_STREAM tokenStream)
{
    if	(tokenStream->p == -1)
    {
	fillBuffer(tokenStream);
    }

    return  tokenStream->tokens;
}

static pANTLR3_LIST	    
getTokenRange	(pANTLR3_COMMON_TOKEN_STREAM tokenStream, ANTLR3_UINT64 start, ANTLR3_UINT64 stop)
{
    return tokenStream->getTokensSet(tokenStream, start, stop, NULL);
}                                                   
/** Given a start and stop index, return a List of all tokens in
 *  the token type BitSet.  Return null if no tokens were found.  This
 *  method looks at both on and off channel tokens.
 */
static pANTLR3_LIST	    
getTokensSet	(pANTLR3_COMMON_TOKEN_STREAM tokenStream, ANTLR3_UINT64 start, ANTLR3_UINT64 stop, pANTLR3_BITSET types)
{
    pANTLR3_LIST	    filteredList;
    ANTLR3_UINT64	    i;
    ANTLR3_UINT64	    n;
    pANTLR3_COMMON_TOKEN    tok;

    if	(tokenStream->p == -1)
    {
	fillBuffer(tokenStream);
    }
    if	(stop > tokenStream->tstream->istream->size(tokenStream->tstream->istream))
    {
	stop = tokenStream->tstream->istream->size(tokenStream->tstream->istream);
    }
    if	(start > stop)
    {
	return NULL;
    }

    /* We have the range set, now we need to iterate through the
     * installed tokens and create a new list with just the ones we want
     * in it. We are just moving pointers about really.
     */
    filteredList    = antlr3ListNew((ANTLR3_UINT32)tokenStream->tstream->istream->size(tokenStream->tstream->istream));

    for	(i = start, n = 0; i<= stop; i++)
    {
	tok = tokenStream->tstream->get(tokenStream->tstream, i);

	if  (	   types == NULL
		|| types->isMember(types, tok->getType(tok) == ANTLR3_TRUE)
	    )
	{
	    filteredList->put(filteredList, n++, (void *)tok, NULL);
	}
    }
    
    /* Did we get any then?
     */
    if	(filteredList->size(filteredList) == 0)
    {
	filteredList->free(filteredList);
	filteredList	= NULL;
    }

    return  filteredList;
}

static pANTLR3_LIST	    
getTokensList	(pANTLR3_COMMON_TOKEN_STREAM tokenStream, ANTLR3_UINT64 start, ANTLR3_UINT64 stop, pANTLR3_LIST list)
{
    pANTLR3_BITSET  bitSet;
    pANTLR3_LIST    newlist;

    bitSet  = antlr3BitsetList(list->table);

    newlist    = tokenStream->getTokensSet(tokenStream, start, stop, bitSet);

    bitSet->free(bitSet);

    return  newlist;

}

static pANTLR3_LIST	    
getTokensType	(pANTLR3_COMMON_TOKEN_STREAM tokenStream, ANTLR3_UINT64 start, ANTLR3_UINT64 stop, ANTLR3_UINT32 type)
{
    pANTLR3_BITSET  bitSet;
    pANTLR3_LIST    newlist;

    bitSet  = antlr3BitsetOf(type, -1);
    newlist = tokenStream->getTokensSet(tokenStream, start, stop, bitSet);

    bitSet->free(bitSet);

    return  newlist;
}

static ANTLR3_UINT32	    
_LA  (pANTLR3_INT_STREAM is, ANTLR3_INT64 i)
{
    pANTLR3_TOKEN_STREAM    ts;
    pANTLR3_COMMON_TOKEN    tok;

    ts	    = (pANTLR3_TOKEN_STREAM)	    is->super;

    tok	    = ts->_LT(ts, i);

    if	(tok != NULL)
    {
	return	tok->getType(tok);
    }
    else
    {
	return	ANTLR3_TOKEN_INVALID;
    }
}

static ANTLR3_UINT64
mark	(pANTLR3_INT_STREAM is)
{
    is->lastMarker = is->index(is);
    return  is->lastMarker;
}

static void		    
release	(pANTLR3_INT_STREAM is, ANTLR3_UINT64 mark)
{
    return;
}

static ANTLR3_UINT64	    
size	(pANTLR3_INT_STREAM is)
{
    pANTLR3_COMMON_TOKEN_STREAM cts;
    pANTLR3_TOKEN_STREAM	ts;

    if (is->cachedSize > 0)
    {
	return  is->cachedSize;
    }
    ts	    = (pANTLR3_TOKEN_STREAM)	    is->super;
    cts	    = (pANTLR3_COMMON_TOKEN_STREAM) ts->super;

    is->cachedSize =  cts->tokens->count;
    return  is->cachedSize;
}

static ANTLR3_INT64    
tindex	(pANTLR3_INT_STREAM is)
{
    pANTLR3_COMMON_TOKEN_STREAM cts;
    pANTLR3_TOKEN_STREAM	ts;

    ts	    = (pANTLR3_TOKEN_STREAM)	    is->super;
    cts	    = (pANTLR3_COMMON_TOKEN_STREAM) ts->super;

    return  cts->p;
}

static void		    
rewindLast	(pANTLR3_INT_STREAM is)
{
    is->rewind(is, is->lastMarker);
}

static void		    
rewindStream	(pANTLR3_INT_STREAM is, ANTLR3_UINT64 marker)
{
    is->seek(is, marker);
}

static void		    
seek	(pANTLR3_INT_STREAM is, ANTLR3_UINT64 index)
{
    pANTLR3_COMMON_TOKEN_STREAM cts;
    pANTLR3_TOKEN_STREAM	ts;

    ts	    = (pANTLR3_TOKEN_STREAM)	    is->super;
    cts	    = (pANTLR3_COMMON_TOKEN_STREAM) ts->super;

    cts->p  = index;
}

static void
fillBuffer  (pANTLR3_COMMON_TOKEN_STREAM tokenStream)
{
    ANTLR3_UINT64	    index;
    pANTLR3_COMMON_TOKEN    tok;
    ANTLR3_BOOLEAN	    discard;
    void		  * channelI;

    /* Start at index 0 of course
     */
    index   = 0;

    /* Pick out the next token from the token source
     * Remember we just get a pointer (reference if you like) here
     * and so if we store it anywhere, we don't set any pointers to auto free it.
     */
    tok	    = tokenStream->tstream->tokenSource->nextToken(tokenStream->tstream->tokenSource);

    while   (tok != NULL && tok->type != ANTLR3_TOKEN_EOF)
    {
	discard	    = ANTLR3_FALSE;	/* Assume we are not discarding	*/

	/* I employ a bit of a trick, or perhaps hack here. Rather than
	 * store a poitner to a structure in the override map and discard set
	 * we store the value + 1 cast to a void *. Hence on systesm where NULL = (void *)0
	 * we can distingusih not being there with being channel or type 0
	 */

	if  (	tokenStream->discardSet							    != NULL
	     && tokenStream->discardSet->get(tokenStream->discardSet, tok->getType(tok))    != NULL)
	{
	    discard = ANTLR3_TRUE;
	}
	else if (      tokenStream->discardOffChannel	== ANTLR3_TRUE
		    && tok->getChannel(tok)		!= tokenStream->channel
		    )
	{
	    discard = ANTLR3_TRUE;
	}
	else if	(   tokenStream->channelOverrides != NULL)
	{
	    /* See if this type is in the override map
	     */
	    channelI	= tokenStream->channelOverrides->get(tokenStream->channelOverrides, tok->getType(tok)+1);

	    if	(channelI != NULL)
	    {
		/* Override found
		 */
		tok->setChannel(tok, ANTLR3_UINT32_CAST(channelI) - 1);
	    }
	}
	
	/* If not discarding it, add it to the list at the current index
	 */
	if  (discard == ANTLR3_FALSE)
	{
	    /* Add it, indicating that we will delete it and the table should not
	     */
	    tok->setTokenIndex(tok, index);
	    tokenStream->p++;
	    tokenStream->tokens->add(tokenStream->tokens, (void *)tok, NULL);
	    index++;
	}
	
	tok	    = tokenStream->tstream->tokenSource->nextToken(tokenStream->tstream->tokenSource);
    }

    /* Set the consume pointer to the first token that is on our channel
     */
    tokenStream->p  = 0;
    tokenStream->p  = skipOffTokenChannels(tokenStream, tokenStream->p);

    /* Cache the size so we don't keep doing indirect method calls
     */
    tokenStream->tstream->istream->cachedSize = tokenStream->tokens->count;

}
/** Given a starting index, return the index of the first on-channel
 *  token.
 */
static ANTLR3_UINT64
skipOffTokenChannels(pANTLR3_COMMON_TOKEN_STREAM tokenStream, ANTLR3_INT64 i)
{
    ANTLR3_INT64	    n;
    pANTLR3_COMMON_TOKEN    tok;

    n	= tokenStream->tstream->istream->cachedSize;

    while   (	   i < n )
    {
	tok =	tokenStream->tstream->get(tokenStream->tstream, i);

	if  (tok == NULL || tok->getChannel(tok) != tokenStream->channel)
	{
	    i++;
	}
	else
	{
	    return i;
	}
    }
    return i;
}

static ANTLR3_UINT64
skipOffTokenChannelsReverse(pANTLR3_COMMON_TOKEN_STREAM tokenStream, ANTLR3_INT64 x)
{
    pANTLR3_COMMON_TOKEN    tok;

    while   ( x >= 0 )
    {
	tok =	tokenStream->tstream->get(tokenStream->tstream, x);

	if  (tok == NULL || (tok->getChannel(tok) != tokenStream->channel))
	{
	    x--;
	}
	else
	{
	    return x;
	}
    }
    return x;
}
