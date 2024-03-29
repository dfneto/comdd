/** \file
 *  Contains the definition of a basic ANTLR3 exception structure created
 *  by a recognizer when errors are found/predicted.
 */
#ifndef	_ANTLR3_EXCEPTION_H
#define	_ANTLR3_EXCEPTION_H

#include    <antlr3defs.h>

/** Indicates that the recognizer received a token
 *  in the input that was not predicted.
 */
#define	ANTLR3_RECOGNITION_EXCEPTION	    1

/** Name of exception #ANTLR3_RECOGNITION_EXCEPTION
 */
#define	ANTLR3_RECOGNITION_EX_NAME  "Recognition Exception"

/** Inidicates that the recognizer was expecting one token and found a
 *  a different one.
 */
#define	ANTLR3_MISMATCHED_TOKEN_EXCEPTION   2

/** Name of #ANTLR3_MISMATCHED_TOKEN_EXCEPTION
 */
#define	ANTLR3_MISMATCHED_EX_NAME   "Mismatched Token Exception"

/** Recognizer could not find a valid alternative from the input
 */
#define	ANTLR3_NO_VIABLE_ALT_EXCEPTION	    3

/** Name of #ANTLR3_NO_VIABLE_ALT_EXCEPTION
 */
#define	ANTLR3_NO_VIABLE_ALT_NAME   "No Viable Alt"

/* Character in a set was not found
 */
#define	ANTLR3_MISMATCHED_SET_EXCEPTION	    4

/* Name of #ANTLR3_MISMATCHED_SET_EXCEPTION
 */
#define	ANTLR3_MISMATCHED_SET_NAME  "Mismatched set"

/* A rule predicting at least n elements found less than that,
 * such as: WS: " "+;
 */
#define	ANTLR3_EARLY_EXIT_EXCEPTION	    5

/* Name of #ANTLR3_EARLY_EXIT_EXCEPTION
 */
#define	ANTLR3_EARLY_EXIT_NAME	     "Early exit"

#define	ANTLR3_FAILED_PREDICATE_EXCEPTION   6
#define	ANTLR3_FAILED_PREDICATE_NAME	    "Predicate failed!"

#define	ANTLR3_MISMATCHED_TREE_NODE_EXCEPTION	7
#define	ANTLR3_MISMATCHED_TREE_NODE_NAME    "Mismatched tree node!"

#define	ANTLR3_REWRITE_EARLY_EXCEPTION	7
#define	ANTLR3_REWRITE_EARLY_EXCEPTION_NAME    "Mismatched tree node!"

/** Base structure for an ANTLR3 exception tracker
 */
typedef	struct ANTLR3_EXCEPTION_struct
{
    /** Set to one of the exception type #defines above.
     */
    ANTLR3_UINT32   type;

    /** The string name of the exception
     */
    void    *	    name;

    /** The printable message that goes with this exception, in your preferred
     *  encoding format. ANTLR just uses ASCII by deafult but you cna ignore these
     *  messages or convert them to another ofrat or whatever of course. They are
     *  really internal messges that you then decide how to print out in a form that
     *  the users of your product will understand, as they are unlikely to know what
     *  to do with "Recognition exception at: [[TOK_GERUND..... " ;-)
     */
    void    *	    message;

    /** Name of the file/input source for reporting
     */
    void    *	    streamName;

    /** If set to ANTLR3_TRUE, this indicates that the message element of this structure
     *  should be freed by calling ANTLR3_FREE() when the exception is destroyed.
     */
    ANTLR3_BOOLEAN  freeMessage;

    /** Indicates the index of the 'token' we were looking at when the
     *  exception occurred.
     */
    ANTLR3_UINT64   index;

    /** Indicates what the current token/tree was when the error occurred. Since not
     *  all input streams will be able to retrieve the nth token, we track it here
     *  instead. This is for parsers, and even tree parsers may set this.
     */
    void	* token;

    /** Indicates the token we were expecting to see next when the error occured
     */
    ANTLR3_UINT32   expecting;

    /** Indicates a set of tokens that we were expecting to see one of when the
     *  error occured. It is a following bitset, so you can use ->toIntList() on it
     *  to generate an array of integers that it represents.
     */
    pANTLR3_BITSET  expectingSet;

    /** If this is a tree parser exception then the node is set to point ot the node
     * that caused the issue.
     */
    void	* node;

    /** The current character when an error ocurred - for lexers.
     */
    ANTLR3_UCHAR   c;

    /** Track the line at which the error occurred in case this is
     *  generated from a lexer.  We need to track this since the
     *  unexpected char doesn't carry the line info.
     */
    ANTLR3_UINT64   line;

    /** Character position in the line where the error occurred.
     */
    ANTLR3_INT32   charPositionInLine;

    /** decision number for NVE
     */
    ANTLR3_UINT32   decisionNum;

    /** State for NVE
     */
    ANTLR3_UINT32   state;

    /** Rule name for failed prediacte exception
     */
    void	    * ruleName;

    /** Pointer to the next exception in the chain (if any)
     */
    struct ANTLR3_EXCEPTION_struct * nextException;

    /** Pointer to the input stream that this exception occurred in.
     */
    pANTLR3_INT_STREAM    input;

    /** Pointer for you, the programmer to add anything you like to an exception.
     */
    void    *	    custom;

    /** Pointer to a routine that is called to free the custom exception structure
     *  when the exception is destroyed. Set to NULL if nothing should be done.
     */
    void	    (*freeCustom)   (void * custom);
    void	    (*print)	    (struct ANTLR3_EXCEPTION_struct * ex);
    void	    (*freeEx)	    (struct ANTLR3_EXCEPTION_struct * ex);

}
    ANTLR3_EXCEPTION;



#endif
