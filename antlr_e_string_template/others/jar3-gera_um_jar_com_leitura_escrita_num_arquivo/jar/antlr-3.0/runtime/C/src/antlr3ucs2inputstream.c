/** \file
 * Base functions to initalize and manipulate any input stream
 */
#include    <antlr3input.h>


/* INT Stream API
 */
static	    void	    antlr3UCS2Consume		(pANTLR3_INT_STREAM is);
static	    ANTLR3_UCHAR    antlr3UCS2LA		(pANTLR3_INT_STREAM is, ANTLR3_INT64 la);
static	    ANTLR3_INT64    antlr3UCS2Index		(pANTLR3_INT_STREAM is);
static	    void	    antlr3UCS2Seek		(pANTLR3_INT_STREAM is, ANTLR3_UINT64 seekPoint);

/* ucs2 Charstream API functions
 */
static	    pANTLR3_STRING  antlr3UCS2Substr		(pANTLR3_INPUT_STREAM input, ANTLR3_INT64 start, ANTLR3_INT64 stop);

/** \brief Common function to setup function interface for a 16 bit "UCS2" input stream.
 *
 * \param input Input stream context pointer
 *
 * \remark
 *   - Strictly speaking, there is no such thing as a UCS2 input stream as the term
 *     tends to confues the notions of character encoding, unicode and so on. However
 *     because there will probably be a need for a UTF-16 stream, I needed to identify 16 bit
 *     streams that do not support surrogate encodings and UCS2 is how it is mostly referredto.
 *     For instance Java, Oracle and others use a 16 bit encoding of characters and so this type
 *     of stream is very common.
 *     Take it to mean therefore, a stright 16 bit uncomplicated encoding of Unicode code points.
 *
 */
void 
antlr3UCS2SetupStream	(pANTLR3_INPUT_STREAM input, ANTLR3_UINT32 type)
{
    /* Build a string factory for this stream. This is a 16 bit string "UCS2" factory which is a standard
     * part of the ANTLR3 string. Teh string factory is then passed through the whoel chain of lexer->parser->tree->treeparser
     * and so on.
     */
    input->strFactory	= antlr3UCS2StringFactoryNew();

    /* Install function pointers for an 8 bit ASCII input, which are good for almost
     * all input stream functions. We will then override those that won't work for 16 bit characters.
     */
    antlr3GenericSetupStream	(input, type);

    /* Intstream API overrides for UCS2
     */
    input->istream->consume	    =  antlr3UCS2Consume;	    /* Consume the next 16 bit character in the buffer			    */
    input->istream->_LA		    =  antlr3UCS2LA;		    /* Return the UTF32 chracter at offset n (1 based)			    */
    input->istream->index	    =  antlr3UCS2Index;		    /* Calculate current index in input stream, 16 bit based		    */
    input->istream->seek	    =  antlr3UCS2Seek;		    /* How to seek to a specific point in the stream			    */
    
    /* Charstream API overrides for UCS2
     */
    input->substr		    =  antlr3UCS2Substr;	    /* Return a string from the input stream				    */
        
}

/** \brief Consume the next character in an 8 bit ASCII input stream
 *
 * \param input Input stream context pointer
 */
static void
antlr3UCS2Consume(pANTLR3_INT_STREAM is)
{
    pANTLR3_INPUT_STREAM input;

    input   = ((pANTLR3_INPUT_STREAM) (is->super));

    if	((pANTLR3_UINT16)(input->nextChar) < (((pANTLR3_UINT16)input->data) + input->sizeBuf))
    {	
	/* Indicate one more character in this line
	 */
	input->charPositionInLine++;
	
	if  ((ANTLR3_UCHAR)(*((pANTLR3_UINT16)input->nextChar)) == input->newlineChar)
	{
	    /* Reset for start of a new line of input
	     */
	    input->line++;
	    input->charPositionInLine	= 0;
	    input->currentLine		= (void *)(((pANTLR3_UINT16)input->nextChar) + 1);
	}

	/* Increment to next character position
	 */
	input->nextChar = (void *)(((pANTLR3_UINT16)input->nextChar) + 1);
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
antlr3UCS2LA(pANTLR3_INT_STREAM is, ANTLR3_INT64 la)
{
    pANTLR3_INPUT_STREAM input;

    input   = ((pANTLR3_INPUT_STREAM) (is->super));

    if	(( ((pANTLR3_UINT16)input->nextChar) + la - 1) >= (((pANTLR3_UINT16)input->data) + input->sizeBuf))
    {
	return	ANTLR3_CHARSTREAM_EOF;
    }
    else
    {
	return	(ANTLR3_UCHAR)(*((pANTLR3_UINT16)input->nextChar + la - 1));
    }
}


/** \brief Calculate the current index in the output stream.
 * \param[in] input Input stream context pointer
 */
static ANTLR3_INT64 
antlr3UCS2Index(pANTLR3_INT_STREAM is)
{
    pANTLR3_INPUT_STREAM input;

    input   = ((pANTLR3_INPUT_STREAM) (is->super));

    return  (ANTLR3_INT64)(((pANTLR3_UINT16)input->nextChar) - ((pANTLR3_UINT16)input->data));
}

/** \brief Rewind the lexer input to the state specified by the supplied mark.
 * 
 * \param[in] input Input stream context pointer
 *
 * \remark
 * Assumes ASCII (or at least, 8 Bit) input stream.
 */
static void
antlr3UCS2Seek	(pANTLR3_INT_STREAM is, ANTLR3_UINT64 seekPoint)
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
	input->nextChar	= ((pANTLR3_UINT16) seekPoint);
    }
    else
    {
	count	= seekPoint - ANTLR3_UINT64_CAST(((pANTLR3_UINT16)(input->nextChar)));

	while (count--)
	{
	    is->consume(is);
	}
    }
}
/** \brief Retrun a substring of the ucs2 (16 bit) input stream in
 *  newly allocated memory.
 *
 * \param input Input stream context pointer
 * \param start Offset in input stream where the string starts
 * \param stop  Offset in the input stream where the string ends.
 */
static pANTLR3_STRING
antlr3UCS2Substr		(pANTLR3_INPUT_STREAM input, ANTLR3_INT64 start, ANTLR3_INT64 stop)
{
    return  input->strFactory->newPtr(input->strFactory, (pANTLR3_UINT8)((pANTLR3_UINT16)(input->data)+start), (ANTLR3_UINT32)(stop - start + 1));
}
