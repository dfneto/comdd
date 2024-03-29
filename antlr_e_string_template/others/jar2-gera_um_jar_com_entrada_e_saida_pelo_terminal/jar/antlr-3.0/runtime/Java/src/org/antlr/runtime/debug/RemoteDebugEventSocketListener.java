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
package org.antlr.runtime.debug;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.util.StringTokenizer;

public class RemoteDebugEventSocketListener implements Runnable {
	static final int MAX_EVENT_ELEMENTS = 8;
	DebugEventListener listener;
	String machine;
	int port;
	Socket channel = null;
	PrintWriter out;
	BufferedReader in;
	String event;
	/** Version of ANTLR (dictates events) */
	public String version;
	public String grammarFileName;
	/** Track the last token index we saw during a consume.  If same, then
	 *  set a flag that we have a problem.
	 */
	int previousTokenIndex = -1;
	boolean tokenIndexesInvalid = false;

	public static class ProxyToken implements Token {
		int index;
		int type;
		int channel;
		int line;
		int charPos;
		String text;
		public ProxyToken(int index, int type, int channel,
						  int line, int charPos, String text)
		{
			this.index = index;
			this.type = type;
			this.channel = channel;
			this.line = line;
			this.charPos = charPos;
			this.text = text;
		}
		public String getText() {
			return text;
		}
		public void setText(String text) {
			this.text = text;
		}
		public int getType() {
			return type;
		}
		public void setType(int ttype) {
			this.type = ttype;
		}
		public int getLine() {
			return line;
		}
		public void setLine(int line) {
			this.line = line;
		}
		public int getCharPositionInLine() {
			return charPos;
		}
		public void setCharPositionInLine(int pos) {
			this.charPos = pos;
		}
		public int getChannel() {
			return channel;
		}
		public void setChannel(int channel) {
			this.channel = channel;
		}
		public int getTokenIndex() {
			return index;
		}
		public void setTokenIndex(int index) {
			this.index = index;
		}
		public String toString() {
			String channelStr = "";
			if ( channel>0 ) {
				channelStr=",channel="+channel;
			}
			return "["+getText()+"/<"+type+">"+channelStr+","+line+":"+getCharPositionInLine()+"]";
		}
	}

	public RemoteDebugEventSocketListener(DebugEventListener listener,
										  String machine,
										  int port) throws IOException
	{
		this.listener = listener;
		this.machine = machine;
		this.port = port;

        if( !openConnection() ) {
            throw new ConnectException();
        }
	}

	protected void eventHandler() {
		try {
			handshake();
			event = in.readLine();
			while ( event!=null ) {
				dispatch(event);
				ack();
				event = in.readLine();
			}
		}
		catch (Exception e) {
			System.err.println(e);
			e.printStackTrace(System.err);
		}
		finally {
            closeConnection();
		}
	}

    protected boolean openConnection() {
        boolean success = false;
        try {
            channel = new Socket(machine, port);
            channel.setTcpNoDelay(true);
			OutputStream os = channel.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os, "UTF8");
			out = new PrintWriter(new BufferedWriter(osw));
			InputStream is = channel.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "UTF8");
			in = new BufferedReader(isr);
            success = true;
        } catch(Exception e) {
            System.err.println(e);
        }
        return success;
    }

    protected void closeConnection() {
        try {
            in.close(); in = null;
            out.close(); out = null;
            channel.close(); channel=null;
        }
        catch (Exception e) {
            System.err.println(e);
            e.printStackTrace(System.err);
        }
        finally {
            if ( in!=null ) {
                try {in.close();} catch (IOException ioe) {
                    System.err.println(ioe);
                }
            }
            if ( out!=null ) {
                out.close();
            }
            if ( channel!=null ) {
                try {channel.close();} catch (IOException ioe) {
                    System.err.println(ioe);
                }
            }
        }

    }

	protected void handshake() throws IOException {
		String antlrLine = in.readLine();
		String[] antlrElements = getEventElements(antlrLine);
		version = antlrElements[1];
		String grammarLine = in.readLine();
		String[] grammarElements = getEventElements(grammarLine);
		grammarFileName = grammarElements[1];
		ack();
		listener.commence(); // inform listener after handshake
	}

	protected void ack() {
        out.println("ack");
		out.flush();
	}

	protected void dispatch(String line) {
		String[] elements = getEventElements(line);
		if ( elements==null || elements[0]==null ) {
			System.err.println("unknown debug event: "+line);
			return;
		}
		if ( elements[0].equals("enterRule") ) {
			listener.enterRule(elements[1]);
		}
		else if ( elements[0].equals("exitRule") ) {
			listener.exitRule(elements[1]);
		}
		else if ( elements[0].equals("enterAlt") ) {
			listener.enterAlt(Integer.parseInt(elements[1]));
		}
		else if ( elements[0].equals("enterSubRule") ) {
			listener.enterSubRule(Integer.parseInt(elements[1]));
		}
		else if ( elements[0].equals("exitSubRule") ) {
			listener.exitSubRule(Integer.parseInt(elements[1]));
		}
		else if ( elements[0].equals("enterDecision") ) {
			listener.enterDecision(Integer.parseInt(elements[1]));
		}
		else if ( elements[0].equals("exitDecision") ) {
			listener.exitDecision(Integer.parseInt(elements[1]));
		}
		else if ( elements[0].equals("location") ) {
			listener.location(Integer.parseInt(elements[1]),
							  Integer.parseInt(elements[2]));
		}
		else if ( elements[0].equals("consumeToken") ) {
			Token t = deserializeToken(elements, 1);
			if ( t.getTokenIndex() == previousTokenIndex ) {
				tokenIndexesInvalid = true;
			}
			previousTokenIndex = t.getTokenIndex();
			listener.consumeToken(t);
		}
		else if ( elements[0].equals("consumeHiddenToken") ) {
			Token t = deserializeToken(elements, 1);
			if ( t.getTokenIndex() == previousTokenIndex ) {
				tokenIndexesInvalid = true;
			}
			previousTokenIndex = t.getTokenIndex();
			listener.consumeHiddenToken(t);
		}
		else if ( elements[0].equals("LT") ) {
			Token t = deserializeToken(elements, 2);
			listener.LT(Integer.parseInt(elements[1]), t);
		}
		else if ( elements[0].equals("mark") ) {
			listener.mark(Integer.parseInt(elements[1]));
		}
		else if ( elements[0].equals("rewind") ) {
			if ( elements[1]!=null ) {
				listener.rewind(Integer.parseInt(elements[1]));
			}
			else {
				listener.rewind();
			}
		}
		else if ( elements[0].equals("beginBacktrack") ) {
			listener.beginBacktrack(Integer.parseInt(elements[1]));
		}
		else if ( elements[0].equals("endBacktrack") ) {
			int level = Integer.parseInt(elements[1]);
			int successI = Integer.parseInt(elements[2]);
			listener.endBacktrack(level, successI==DebugEventListener.TRUE);
		}
		else if ( elements[0].equals("exception") ) {
			String excName = elements[1];
			String indexS = elements[2];
			String lineS = elements[3];
			String posS = elements[4];
			Class excClass = null;
			try {
				excClass = Class.forName(excName);
				RecognitionException e =
					(RecognitionException)excClass.newInstance();
				e.index = Integer.parseInt(indexS);
				e.line = Integer.parseInt(lineS);
				e.charPositionInLine = Integer.parseInt(posS);
				listener.recognitionException(e);
			}
			catch (ClassNotFoundException cnfe) {
				System.err.println("can't find class "+cnfe);
				cnfe.printStackTrace(System.err);
			}
			catch (InstantiationException ie) {
				System.err.println("can't instantiate class "+ie);
				ie.printStackTrace(System.err);
			}
			catch (IllegalAccessException iae) {
				System.err.println("can't access class "+iae);
				iae.printStackTrace(System.err);
			}
		}
		else if ( elements[0].equals("beginResync") ) {
			listener.beginResync();
		}
		else if ( elements[0].equals("endResync") ) {
			listener.endResync();
		}
		else if ( elements[0].equals("terminate") ) {
			listener.terminate();
		}
		else if ( elements[0].equals("semanticPredicate") ) {
			Boolean result = Boolean.valueOf(elements[1]);
			String predicateText = elements[2];
			predicateText = unEscapeNewlines(predicateText);
			listener.semanticPredicate(result.booleanValue(),
									   predicateText);
		}
		else if ( elements[0].equals("consumeNode") ) {
			String tokenText = elements[3];
			tokenText = unEscapeNewlines(tokenText);
			listener.consumeNode(Integer.parseInt(elements[1]),
								 tokenText,
								 Integer.parseInt(elements[2]));
		}
		else if ( elements[0].equals("LN") ) {
			String tokenText = elements[4];
			tokenText = unEscapeNewlines(tokenText);
			listener.LT(Integer.parseInt(elements[1]),
						Integer.parseInt(elements[2]),
						tokenText,
						Integer.parseInt(elements[3]));
		}
		else if ( elements[0].equals("createNodeFromToken") ) {
			String tokenText = elements[3];
			tokenText = unEscapeNewlines(tokenText);
			listener.createNode(Integer.parseInt(elements[1]),
								tokenText,
								Integer.parseInt(elements[2]));
		}
		else if ( elements[0].equals("createNode") ) {
			listener.createNode(Integer.parseInt(elements[1]),
								Integer.parseInt(elements[2]));
		}
		else if ( elements[0].equals("nilNode") ) {
			listener.nilNode(Integer.parseInt(elements[1]));
		}
		else if ( elements[0].equals("becomeRoot") ) {
			listener.becomeRoot(Integer.parseInt(elements[1]),
								Integer.parseInt(elements[2]));
		}
		else if ( elements[0].equals("addChild") ) {
			listener.addChild(Integer.parseInt(elements[1]),
							  Integer.parseInt(elements[2]));
		}
		else if ( elements[0].equals("setTokenBoundaries") ) {
			listener.setTokenBoundaries(Integer.parseInt(elements[1]),
										Integer.parseInt(elements[2]),
										Integer.parseInt(elements[3]));
		}
		else {
			System.err.println("unknown debug event: "+line);
		}
	}

	protected ProxyToken deserializeToken(String[] elements,
										  int offset)
	{
		String indexS = elements[offset+0];
		String typeS = elements[offset+1];
		String channelS = elements[offset+2];
		String lineS = elements[offset+3];
		String posS = elements[offset+4];
		String text = elements[offset+5];
		text = unEscapeNewlines(text);
		int index = Integer.parseInt(indexS);
		ProxyToken t =
			new ProxyToken(index,
						   Integer.parseInt(typeS),
						   Integer.parseInt(channelS),
						   Integer.parseInt(lineS),
						   Integer.parseInt(posS),
						   text);
		return t;
	}

	/** Create a thread to listen to the remote running recognizer */
	public void start() {
		Thread t = new Thread(this);
		t.start();
	}

	public void run() {
		eventHandler();
	}

	// M i s c

	public String[] getEventElements(String event) {
		if ( event==null ) {
			return null;
		}
		String[] elements = new String[MAX_EVENT_ELEMENTS];
		String str = null; // a string element if present (must be last)
		try {
			int firstQuoteIndex = event.indexOf('"');
			if ( firstQuoteIndex>=0 ) {
				// treat specially; has a string argument like "a comment\n
				// Note that the string is terminated by \n not end quote.
				// Easier to parse that way.
				String eventWithoutString = event.substring(0,firstQuoteIndex);
				str = event.substring(firstQuoteIndex+1,event.length());
				event = eventWithoutString;
			}
			StringTokenizer st = new StringTokenizer(event, " \t", false);
			int i = 0;
			while ( st.hasMoreTokens() ) {
				elements[i] = st.nextToken();
				i++;
			}
			if ( str!=null ) {
				elements[i] = str;
			}
		}
		catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return elements;
	}

	protected String unEscapeNewlines(String txt) {
		// this unescape is slow but easy to understand
		txt = txt.replaceAll("%0A","\n");  // unescape \n
		txt = txt.replaceAll("%0D","\r");  // unescape \r
		txt = txt.replaceAll("%25","%");   // undo escaped escape chars
		return txt;
	}

	public boolean tokenIndexesAreInvalid() {
		return false;
		//return tokenIndexesInvalid;
	}

}

