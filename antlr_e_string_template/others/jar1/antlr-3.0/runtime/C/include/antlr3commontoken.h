/** \file
 * \brief Defines the interface for a common token.
 *
 * All token streams should provide their tokens using an instance
 * of this common token. A custom pointer is provided, wher you may attach
 * a further structure to enhance the common token if you feel the need
 * to do so. The C runtime will assume that a token provides implementations
 * of the interface functions, but all of them may be rplaced by your own
 * implementation if you require it.
 */
#ifndef	_ANTLR3_COMMON_TOKEN_H
#define	_ANTLR3_COMMON_TOKEN_H

#include    <antlr3defs.h>

/** How many tokens to allocate at once in the token factory
 */
#define	ANTLR3_FACTORY_POOL_SIZE    512

/* Base token types, wheich all lexer/parser tokens come after in sequence.
 */

/** Indicator of an invalid token
 */
#define	ANTLR3_TOKEN_INVALID	0

#define	ANTLR3_EOR_TOKEN_TYPE	1

/** Imaginary token type to cause a traversal of child nodes in a tree parser
 */
#define	ANTLR3_TOKEN_DOWN		2

/** Imaginary token type to signal the end of a stream of child nodes.
 */
#define	ANTLR3_TOKEN_UP		3

/** First token that can be used by users/genrated code
 */
#define	ANTLR3_MIN_TOKEN_TYPE	ANTLR3_UP + 1

/** End of file token
 */
#define	ANTLR3_TOKEN_EOF	(ANTLR3_CHARSTREAM_EOF & 0xFFFFFFFF)

/** Default channel for a token
 */
#define	ANTLR3_TOKEN_DEFAULT_CHANNEL	0

/** Reserved channel number for a HIDDEN token - a token that
 *  is hidden from the parser.
 */
#define	HIDDEN				99

/** The definition of an ANTLR3 common token structure, which all implementations
 * of a token stream should provide, installing any firther structures in the
 * custom pointer elment of this structure.
 *
 * \remark
 * Token streams are in essence provided by lexers or other programs that serve
 * as lexers.
 */
typedef	struct ANTLR3_COMMON_TOKEN_struct
{
    /** The actual type of this token
     */
    ANTLR3_UINT32   type;

    /** Indicates that a token was produced from the token factory and therefor
     *  the the freeToken() method should not do anything itself because
     *  token factory is responsible for deleting it.
     */
    ANTLR3_BOOLEAN  factoryMade;

    /** The line number in the input stream where this token was derived from
     */
    ANTLR3_UINT64   line;

    /** The charaacter position in the line that this token was derived from
     */
    ANTLR3_INT32    charPosition;

    /** The virtual channel that this token exists in.
     */
    ANTLR3_UINT32   channel;

    /** Pointer to the input stream that this token originated in.
     */
    pANTLR3_INPUT_STREAM    input;

    /** What the index of this token is, 0, 1, .., n-2, n-1 tokens
     */
    ANTLR3_UINT64   index;

    /** The chracter offset in the input stream where the text for this token
     *  starts.
     */
    ANTLR3_UINT64   start;

    /** The chracter offset in the input stream where the text for this token
     *  stops.
     */
    ANTLR3_UINT64   stop;

    /** Some token types actually do carry around their associated text, hence
     * (*getText)() will return this pointer if it is not NULL
     */
    pANTLR3_STRING   text;

    /**  Because it is a bit more of a hassle to override an ANTLR3_COMMON_TOKEN
     *   as the standard structure for a token, a number of user programmable 
     *	 elements are allowed in a token. This is one of them.
     */
    ANTLR3_UINT32   user1;
    
    /**  Because it is a bit more of a hassle to override an ANTLR3_COMMON_TOKEN
     *   as the standard structure for a token, a number of user programmable 
     *	 elements are allowed in a token. This is one of them.
     */
    ANTLR3_UINT32   user2;

    /**  Because it is a bit more of a hassle to override an ANTLR3_COMMON_TOKEN
     *   as the standard structure for a token, a number of user programmable 
     *	 elements are allowed in a token. This is one of them.
     */
    ANTLR3_UINT32   user3;

    /** Pointer to a custom element that the ANTLR3 programmer may define and install
     */
    void    * custom;

    /** Pointer to a function that knows how to free the custom structure when the 
     *  token is destroyed.
     */
    void    (*freeCustom)(void * custom);

    /* ==============================
     * API 
     */

    /** Pointer to function that returns the text pointer of a token, use
     *  toString() if you want a pANTLR3_STRING version of the token.
     */
    pANTLR3_STRING  (*getText)(struct ANTLR3_COMMON_TOKEN_struct * token);

    /** Pointer to a function that 'might' be able to set the text associated
     *  with a token. Imaginary tokens such as an ANTLR3_CLASSIC_TOKEN may actually
     *  do this, however many tokens such as ANTLR3_COMMON_TOKEN do not actaully have
     *  strings associated with them but just point into the current input stream. These
     *  tokens will implement this function with a function that errors out (probably
     *  drastically.
     */
    void	    (*setText)(struct ANTLR3_COMMON_TOKEN_struct * token, pANTLR3_UINT8 text);

    /** Pointer to a function that 'might' be able to set the text associated
     *  with a token. Imaginary tokens such as an ANTLR3_CLASSIC_TOKEN may actually
     *  do this, however many tokens such as ANTLR3_COMMON_TOKEN do not actully have
     *  strings associated with them but just point into the current input stream. These
     *  tokens will implement this function with a function that errors out (probably
     *  drastically.
     */
    void	    (*setText8)(struct ANTLR3_COMMON_TOKEN_struct * token, pANTLR3_UINT8 text);

    /** Pointer to a function that returns the token type of this token
     */
    ANTLR3_UINT32   (*getType)(struct ANTLR3_COMMON_TOKEN_struct * token);

    /** Pointer to a function that sets the type of this token
     */
    void	    (*setType)(struct ANTLR3_COMMON_TOKEN_struct * token, ANTLR3_UINT32 ttype);

    /** Pointer to a function that gets the 'line' number where this token resides
     */
    ANTLR3_UINT64   (*getLine)(struct ANTLR3_COMMON_TOKEN_struct * token);

    /** Pointer to a function that sets the 'line' number where this token reside
     */
    void	    (*setLine)(struct ANTLR3_COMMON_TOKEN_struct * token, ANTLR3_UINT64 line);

    /** Pointer to a function that gets the offset in the line where this token exists
     */ 
    ANTLR3_INT32    (*getCharPositionInLine)	(struct ANTLR3_COMMON_TOKEN_struct * token);

    /** Pointer to a function that sets the offset in the line where this token exists
     */
    void	    (*setCharPositionInLine)	(struct ANTLR3_COMMON_TOKEN_struct * token, ANTLR3_INT32 pos);

    /** Pointer to a function that gets the channel that this token was placed in (parsers
     *  can 'tune' to these channels.
     */
    ANTLR3_UINT32   (*getChannel)	(struct ANTLR3_COMMON_TOKEN_struct * token);

    /** Pointer to a function that sets the channel that this token should belong to
     */
    void	    (*setChannel)	(struct ANTLR3_COMMON_TOKEN_struct * token, ANTLR3_UINT32 channel);

    /** Pointer to a function that returns an index 0...n-1 of the token in the token
     *  input stream.
     */
    ANTLR3_UINT64   (*getTokenIndex)	(struct ANTLR3_COMMON_TOKEN_struct * token);

    /** Pointer to a function tha tcna set the token index of this token in the token
     *  input stream.
     */
    void	    (*setTokenIndex)	(struct ANTLR3_COMMON_TOKEN_struct * token, ANTLR3_UINT64);

    /** Pointer to a function that gets the start index in the input stream for this token.
     */
    ANTLR3_UINT64   (*getStartIndex)	(struct ANTLR3_COMMON_TOKEN_struct * token);

    /** Pointer to a function that sets the start index in the input stream for this token.
     */
    void	    (*setStartIndex)	(struct ANTLR3_COMMON_TOKEN_struct * token, ANTLR3_UINT64 index);
    
    /** Pointer to a function that gets the stop index in the input stream for this token.
     */
    ANTLR3_UINT64   (*getStopIndex)	(struct ANTLR3_COMMON_TOKEN_struct * token);

    /** Pointer to a function that sets the stop index in the input stream for this token.
     */
    void	    (*setStopIndex)	(struct ANTLR3_COMMON_TOKEN_struct * token, ANTLR3_UINT64 index);

    /** Pointer to a function that returns this token as a text representation that can be 
     *  printed with embedded control codes such as \n replaced with the printable sequence "\\n"
     *  This also yields a string structure that can be used more easilly than the pointer to 
     *  the input stream in certain situations.
     */
    pANTLR3_STRING  (*toString)		(struct ANTLR3_COMMON_TOKEN_struct * token);
}
    ANTLR3_COMMON_TOKEN;

/** \brief ANTLR3 Token factory interface to create lots of tokens efficiently
 *  rather than creating and freeing lots of little bits of memory.
 */
typedef	struct ANTLR3_TOKEN_FACTORY_struct
{
    /** Pointers to the array of tokens that this factory has produced so far
     */
    pANTLR3_COMMON_TOKEN    *pools;

    /** Current pool tokens we are allocating from
     */
    ANTLR3_INT32	    thisPool;

    /** The next token to throw out from the pool, will cause a new pool allocation
     *  if this exceeds the available tokenCount
     */
    ANTLR3_UINT32	    nextToken;

    /** Trick to initialize tokens and their API quickly, we set up this token when the
     *  factory is created, then just copy the memory it uses into the new token.
     */
    ANTLR3_COMMON_TOKEN	    unTruc;

    /** Pointer to an input stream that is using this token factory (may be NULL)
     *  which will be assigned to the tokens automatically.
     */
    pANTLR3_INPUT_STREAM    input;

    /** Pointer to a function that returns a new token
     */
    pANTLR3_COMMON_TOKEN    (*newToken)	    (struct ANTLR3_TOKEN_FACTORY_struct * factory);

    /** Pointer to a function the destroys the factory
     */
    void		    (*close)	    (struct ANTLR3_TOKEN_FACTORY_struct * factory);
}
    ANTLR3_TOKEN_FACTORY;

#endif
