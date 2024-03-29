/** \file
 * Base functions to initalize and manipulate any input stream
 */
#include    <antlr3input.h>


/* INT Stream API
 */
static	    void	    antlr3AsciiConsume		(pANTLR3_INT_STREAM is);
static	    ANTLR3_UCHAR    antlr3AsciiLA		(pANTLR3_INT_STREAM is, ANTLR3_INT64 la);
static	    ANTLR3_INT64    antlr3AsciiIndex		(pANTLR3_INT_STREAM is);
static	    ANTLR3_UINT64   antlr3AsciiMark		(pANTLR3_INT_STREAM is);
static	    void	    antlr3AsciiRewind		(pANTLR3_INT_STREAM is, ANTLR3_UINT64 mark);
static	    void	    antlr3AsciiRewindLast	(pANTLR3_INT_STREAM is);
static	    void	    antlr3AsciiRelease		(pANTLR3_INT_STREAM is, ANTLR3_UINT64 mark);
static	    void	    antlr3AsciiSeek		(pANTLR3_INT_STREAM is, ANTLR3_UINT64 seekPoint);

/* ASCII Charstream API functions
 */
static	    void	    antlr3InputClose		(pANTLR3_INPUT_STREAM input);
static	    void	    antlr3InputReset		(pANTLR3_INPUT_STREAM input);
static	    pANTLR3_UINT8   antlr3InputFileName		(pANTLR3_INPUT_STREAM input);
static	    void *	    antlr3AsciiLT		(pANTLR3_INPUT_STREAM input, ANTLR3_INT64 lt);
static	    ANTLR3_UINT64   antlr3AsciiSize		(pANTLR3_INPUT_STREAM input);
static	    pANTLR3_STRING  antlr3AsciiSubstr		(pANTLR3_INPUT_STREAM input, ANTLR3_INT64 start, ANTLR3_INT64 stop);
static	    ANTLR3_UINT64   antlr3AsciiGetLine		(pANTLR3_INPUT_STREAM input);
static	    void	  * antlr3AsciiGetLineBuf	(pANTLR3_INPUT_STREAM input);
static	    ANTLR3_UINT32   antlr3AsciiGetCharPosition	(pANTLR3_INPUT_STREAM input);
static	    void	    antlr3AsciiSetLine		(pANTLR3_INPUT_STREAM input, ANTLR3_UINT32 line);
static	    void	    antlr3AsciiSetCharPosition	(pANTLR3_INPUT_STREAM input, ANTLR3_UINT32 position);
static	    void	    antlr3AsciiSetNewLineChar	(pANTLR3_INPUT_STREAM input, ANTLR3_UINT32 newlineChar);

/** \brief Common function to setup function interface for an 8 bit ASCII input stream.
 *
 * \param input Input stream context pointer
 *
 * \remark
 *   - Many of the 8 bit ASCII oriented file stream handling functions will be usable
 *     by any or at least some other input streams. Therefore it is perfectly acceptible
 *     to call this funcinto to install teh ASCII handler then override just those functions
 *     that would not work for the particular input encoding, such as consume for instance.
 *  
 */
void 
antlr3AsciiSetupStream	(pANTLR3_INPUT_STREAM input, ANTLR3_UINT32 type)
{
    /* Build a string factory for this stream
     */
    input->strFactory	= antlr3StringFactoryNew();

    /* Default stream set up is for ASCII, therefore ther eis nothign else
     * to do but set it up as such
     */
    antlr3GenericSetupStream(input, type);
}

void
antlr3GenericSetupStream  (pANTLR3_INPUT_STREAM input, ANTLR3_UINT32 type)
{

    /* Install function pointers for an 8 bit ASCII input
     */

    /* Allocate stream interface
     */
    input->istream	    =  antlr3IntStreamNew();
    input->istream->type    = ANTLR3_CHARSTREAM;
    input->istream->super   =  input;

    input->istream->type	= type;

    /* Intstream API
     */
    input->istream->consume	    =  antlr3AsciiConsume;	    /* Consume the next 8 bit character in the buffer			    */
    input->istream->_LA		    =  antlr3AsciiLA;		    /* Return the UTF32 chracter at offset n (1 based)			    */
    input->istream->index	    =  antlr3AsciiIndex;	    /* Current index (offset from first character			    */
    input->istream->mark	    =  antlr3AsciiMark;		    /* Record the current lex state for later restore			    */
    input->istream->rewind	    =  antlr3AsciiRewind;	    /* How to rewind the input						    */
    input->istream->rewindLast	    =  antlr3AsciiRewindLast;	    /* How to rewind the input						    */
    input->istream->seek	    =  antlr3AsciiSeek;		    /* How to seek to a specific point in the stream			    */
    input->istream->release	    =  antlr3AsciiRelease;	    /* Reset marks after mark n						    */

    /* Charstream API
     */
    input->close		    =  antlr3InputClose;		    /* Close down the stream completely					    */
    input->reset		    =  antlr3InputReset;		    /* Reset input to start						    */
    input->getSourceName	    =  antlr3InputFileName;	    /* Return the source description (filename here)			    */
    input->_LT			    =  antlr3AsciiLT;		    /* Same as _LA for 8 bit Ascii file					    */
    input->size			    =  antlr3AsciiSize;		    /* Return the size of the input buffer				    */
    input->substr		    =  antlr3AsciiSubstr;	    /* Return a string from the input stream				    */
    input->getLine		    =  antlr3AsciiGetLine;	    /* Return the current line number in the input stream		    */
    input->getLineBuf		    =  antlr3AsciiGetLineBuf;	    /* Return a pointer to the start of the current line being consumed	    */
    input->getCharPositionInLine    =  antlr3AsciiGetCharPosition;   /* Return the offset into the current line of input			    */
    input->setLine		    =  antlr3AsciiSetLine;	    /* Set the input stream line number (does not set buffer pointers)	    */
    input->setCharPositionInLine    =  antlr3AsciiSetCharPosition;   /* Set the offset in to the current line (does not set any pointers	)   */
    input->SetNewLineChar	    =  antlr3AsciiSetNewLineChar;    /* Set the value of the newline trigger character			    */

    /* Initialize entries for tables etc
     */
    input->markers  = NULL;

    /* Set up the input stream brand new
     */
    input->reset(input);
    
    /* Install default line separator character (it can be replaced
     * by the grammar programmer later)
     */
    input->SetNewLineChar(input, (ANTLR3_UCHAR)'\n');
}

/** \brief Close down an input stream and free any memory allocated by it.
 *
 * \param input Input stream context pointer
 */
static void
antlr3InputClose(pANTLR3_INPUT_STREAM input)
{
    /* Close any markers in the input stream
     */
    if	(input->markers != NULL)
    {
	input->markers->free(input->markers);
	input->markers = NULL;
    }

    /* Close the string factory
     */
    if	(input->strFactory != NULL)
    {
	input->strFactory->close(input->strFactory);
    }

    /* Free the input stream buffer if we allocated it
     */
    if	(input->isAllocated && input->data != NULL)
    {
	ANTLR3_FREE(input->data);
	input->data = NULL;
    }
    
    input->istream->free(input->istream);

    /* We always allocate the memory for the stream name
     */
    ANTLR3_FREE(input->fileName);

    /* Finaly, free the space for teh structure itself
     */
    ANTLR3_FREE(input);

    /* Done
     */
}

/** \brief Reset a restartable input stream to the start
 *
 * \param input Input stream context pointer
 */
static void
antlr3InputReset(pANTLR3_INPUT_STREAM input)
{

    input->nextChar		= input->data;	/* Input at first character */
    input->line			= 1;		/* starts at line 1	    */
    input->charPositionInLine	= -1;
    input->currentLine		= input->data;
    input->markDepth		= 0;		/* Reset markers	    */
    
    /* Free up the markers table if it is there
     */
    if	(input->markers != NULL)
    {
	input->markers->free(input->markers);
    }

    /* Install a new markers table
     */
    input->markers  = antlr3VectorNew(0);
}

/** \brief Return a pointer to the input stream source name, such as the file.
 *
 * \param input Input stream context pointer
 * \return Pointer to 8 bit ascii (assumed here at least) stream name
 */
static pANTLR3_UINT8
antlr3InputFileName(pANTLR3_INPUT_STREAM input)
{
    return  input->fileName;
}

/** \brief Consume the next character in an 8 bit ASCII input stream
 *
 * \param input Input stream context pointer
 */
static void
antlr3AsciiConsume(pANTLR3_INT_STREAM is)
{
    pANTLR3_INPUT_STREAM input;

    input   = ((pANTLR3_INPUT_STREAM) (is->super));

    if	((pANTLR3_UINT8)(input->nextChar) < (((pANTLR3_UINT8)input->data) + input->sizeBuf))
    {	
	/* Indicate one more character in this line
	 */
	input->charPositionInLine++;
	
	if  ((ANTLR3_UCHAR)(*((pANTLR3_UINT8)input->nextChar)) == input->newlineChar)
	{
	    /* Reset for start of a new line of input
	     */
	    input->line++;
	    input->charPositionInLine	= 0;
	    input->currentLine		= (void *)(((pANTLR3_UINT8)input->nextChar) + 1);
	}

	/* Increment to next character position
	 */
	input->nextChar = (void *)(((pANTLR3_UINT8)input->nextChar) + 1);
    }
}

/** \brief Return the input element assuming an 8 bit ascii iinput
 *
 * \param[in] input Input stream context pointer
 * \param[in] la 1 based offset of next input stream element
 *
 * \return Next input character in internal ANTLR3 encoding (UTF32)
 */
static ANTLR3_UCHAR 
antlr3AsciiLA(pANTLR3_INT_STREAM is, ANTLR3_INT64 la)
{
    pANTLR3_INPUT_STREAM input;

    input   = ((pANTLR3_INPUT_STREAM) (is->super));

    if	(( ((pANTLR3_UINT8)input->nextChar) + la - 1) >= (((pANTLR3_UINT8)input->data) + input->sizeBuf))
    {
	return	ANTLR3_CHARSTREAM_EOF;
    }
    else
    {
	return	(ANTLR3_UCHAR)(*((pANTLR3_UINT8)input->nextChar + la - 1));
    }
}

/** \brief Return the input element assuming an 8 bit ascii iinput
 *
 * \param[in] input Input stream context pointer
 * \param[in] lt 1 based offset of next input stream element
 *
 * \return Next input character in internal ANTLR3 encoding (UTF32)
 */
static void * 
antlr3AsciiLT(pANTLR3_INPUT_STREAM input, ANTLR3_INT64 lt)
{
    /* Casting is horrible but it means no warnings and LT should never be called
     * on a character stream anyway I think. If it is then, the void * will need to be 
     * cast back in a similar manner. Yuck! But this means that LT for Token streams and
     * tree streams is correct.
     */
    return (ANTLR3_FUNC_PTR(input->istream->_LA(input->istream, lt)));
}

/** \brief Calculate the current index in the output stream.
 * \param[in] input Input stream context pointer
 */
static ANTLR3_INT64 
antlr3AsciiIndex(pANTLR3_INT_STREAM is)
{
    pANTLR3_INPUT_STREAM input;

    input   = ((pANTLR3_INPUT_STREAM) (is->super));

    return  (ANTLR3_INT64)(((pANTLR3_UINT8)input->nextChar) - ((pANTLR3_UINT8)input->data));
}

/** \brief Return the size of the current input stream, as an Ascii file
 *   which in this case is the total input. Other implementations may provide
 *   more sophisticated implemenatins to deal with non-recoverable streams 
 *   and so on.
 *
 * \param[in] input Input stream context pointer
 */
static	ANTLR3_UINT64 
antlr3AsciiSize(pANTLR3_INPUT_STREAM input)
{
    return  input->sizeBuf;
}

/** \brief Mark the current input point in an Ascii 8 bit stream
 *  such as a file stream, where all the input is available in the
 *  buffer.
 *
 * \param[in] input Input stream context pointer
 */
static ANTLR3_UINT64
antlr3AsciiMark	(pANTLR3_INT_STREAM is)
{
    pANTLR3_LEX_STATE	    state;
    pANTLR3_INPUT_STREAM    input;

    input   = ((pANTLR3_INPUT_STREAM) (is->super));

    /* New mark point 
     */
    input->markDepth++;

    /* See if we are revisiting a mark as we can just reuse the hashtable
     * entry if we are, otherwise, we need a new one
     */
    if	(input->markDepth > input->markers->count)
    {	
	state	= ANTLR3_MALLOC(sizeof(ANTLR3_LEX_STATE));

	/* Add it to the table
	 */
	input->markers->add(input->markers, state, ANTLR3_FREE_FUNC);	/* No special structure, just free() on delete */
    }
    else
    {
	state	= (pANTLR3_LEX_STATE)input->markers->get(input->markers, input->markDepth);

	/* Assume no errors for speed, it will just blow up if the table failed
	 * for some reasons, hence lots of unit tests on the tables ;-)
	 */
    }

    /* We have created or retrieved the state, so update it with the current
     * elements of the lexer state.
     */
    state->charPositionInLine	= input->charPositionInLine;
    state->currentLine		= input->currentLine;
    state->line			= input->line;
    state->nextChar		= input->nextChar;

    is->lastMarker  = input->markDepth;

    /* And that's it
     */
    return  input->markDepth;
}
/** \brief Rewind the lexer input to the state specified by the last produced mark.
 * 
 * \param[in] input Input stream context pointer
 *
 * \remark
 * Assumes ASCII (or at least, 8 Bit) input stream.
 */
static void
antlr3AsciiRewindLast	(pANTLR3_INT_STREAM is)
{
    is->rewind(is, is->lastMarker);
}

/** \brief Rewind the lexer input to the state specified by the supplied mark.
 * 
 * \param[in] input Input stream context pointer
 *
 * \remark
 * Assumes ASCII (or at least, 8 Bit) input stream.
 */
static void
antlr3AsciiRewind	(pANTLR3_INT_STREAM is, ANTLR3_UINT64 mark)
{
    pANTLR3_LEX_STATE	state;
    pANTLR3_INPUT_STREAM input;

    input   = ((pANTLR3_INPUT_STREAM) is->super);

    /* Perform any clean up of the marks
     */
    input->istream->release(input->istream, mark);

    /* Find the supplied mark state 
     */
    state   = (pANTLR3_LEX_STATE)input->markers->get(input->markers, mark);

    /* Seek input pointer to the requested point (note we supply the void *pointer
     * to whatever is implementing the int stream to seek).
     */
    antlr3AsciiSeek(is, ANTLR3_UINT64_CAST(state->nextChar));

    /* Reset to the reset of the information in the mark
     */
    input->charPositionInLine	= state->charPositionInLine;
    input->currentLine		= state->currentLine;
    input->line			= state->line;
    input->nextChar		= state->nextChar;

    /* And we are done
     */
}

/** \brief Rewind the lexer input to the state specified by the supplied mark.
 * 
 * \param[in] input Input stream context pointer
 *
 * \remark
 * Assumes ASCII (or at least, 8 Bit) input stream.
 */
static void
antlr3AsciiRelease	(pANTLR3_INT_STREAM is, ANTLR3_UINT64 mark)
{
    pANTLR3_INPUT_STREAM input;

    input   = ((pANTLR3_INPUT_STREAM) (is->super));

    /* We don't do much here in fact as we never free any higher marks in
     * the hashtable as we just resuse any memory allocated for them.
     */
    input->markDepth	= mark - 1;
}

/** \brief Rewind the lexer input to the state specified by the supplied mark.
 * 
 * \param[in] input Input stream context pointer
 *
 * \remark
 * Assumes ASCII (or at least, 8 Bit) input stream.
 */
static ANTLR3_INLINE void
antlr3AsciiSeek	(pANTLR3_INT_STREAM is, ANTLR3_UINT64 seekPoint)
{
    ANTLR3_INT64   count;
    pANTLR3_INPUT_STREAM input;

    input   = ((pANTLR3_INPUT_STREAM) is->super);

    /* If the requested seek point is less than the current
     * input point, then we assume that we are reseting from a mark
     * and do not need to scan, but can just set to there.
     */
    if	(seekPoint <= ANTLR3_UINT64_CAST(input->nextChar))
    {
	input->nextChar	= ((pANTLR3_UINT8) seekPoint);
    }
    else
    {
	count	= seekPoint - ANTLR3_UINT64_CAST(((pANTLR3_UINT8)(input->nextChar)));

	while (count--)
	{
	    is->consume(is);
	}
    }
}
/** \brief Retrun a substring of the ASCII (8 bit) input stream in
 *  newly allocated memory.
 *
 * \param input Input stream context pointer
 * \param start Offset in input stream where the string starts
 * \param stop  Offset in the input stream where the string ends.
 */
static pANTLR3_STRING
antlr3AsciiSubstr		(pANTLR3_INPUT_STREAM input, ANTLR3_INT64 start, ANTLR3_INT64 stop)
{
    return  input->strFactory->newPtr(input->strFactory, (pANTLR3_UINT8)(input->data)+start, (ANTLR3_UINT32)(stop - start + 1));
}

/** \brief Return the line number as understood by the 8 bit/ASCII input stream.
 *
 * \param input Input stream context pointer
 * \return	Line number in input stream that we belive we are working on.
 */
static ANTLR3_UINT64   
antlr3AsciiGetLine		(pANTLR3_INPUT_STREAM input)
{
    return  input->line;
}

/** \ Brief return a pointer into the input stream that points at the start
 *    of the current input line as triggered by the end of line character installed
 *    for the stream ('\n' unless told differently).
 *
 * \param input 
 */
static void	  * 
antlr3AsciiGetLineBuf	(pANTLR3_INPUT_STREAM input)
{
    return  input->currentLine;
}

/** \Brief return the current offset in to the current line in the input stream.
 *
 * \param input Input stream context pointer
 * \return      Current line offset
 */
static ANTLR3_UINT32
antlr3AsciiGetCharPosition	(pANTLR3_INPUT_STREAM input)
{
    return  input->charPositionInLine;
}

/** \ Brief Set the current line number as understood by the input stream.
 *
 * \param input Input stream context pointer
 * \param line  Line number to tell the input stream we are on
 *
 * \remark
 *  This function does not change any pointers, it just allows the programmer to set the
 *  line number according to some external criterion, such as finding a lexed directive
 *  like: #nnn "file.c" for instance, such that error reporting and so on in is in sync
 *  with some oringial source format.
 */
static void
antlr3AsciiSetLine		(pANTLR3_INPUT_STREAM input, ANTLR3_UINT32 line)
{
    input->line	= line;
}

/** \Brief Set the current offset in the current line to be a paricular setting.
 *
 * \param[in] input    Input stream context pointer
 * \param[in] position New setting for current offset.
 *
 * \remark
 * This does not set the actaul pointers in the input stream, it is purely for reporting
 * purposes and so on as per antlr3AsciiSetLine();
 */
static void
antlr3AsciiSetCharPosition	(pANTLR3_INPUT_STREAM input, ANTLR3_UINT32 position)
{
    input->charPositionInLine = position;
}

/** \brief set the newline trigger chacter in the input stream to the supplied paramter.
 *
 * \param[in] input	    Input stream context pointer
 * \param[in] newlineChar   Character to set to be the newline trigger.
 *
 * \remark
 *  - The supplied newLineChar is in UTF32 encoding (which means ASCII and latin1 etc
 *    are the same encodings), but the input stream catered to by this function is 8 bit
 *    only, so it is up to the programmer ti ensure that the character supplied is valid.
 */
static void 
antlr3AsciiSetNewLineChar	(pANTLR3_INPUT_STREAM input, ANTLR3_UINT32 newlineChar)
{
    input->newlineChar	= newlineChar;
}



