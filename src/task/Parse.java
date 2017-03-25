/*
 * The MIT License
 *
 * Copyright 2017 lanelutgen.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package task;

import object.ParseResult;
import object.TokenSet;
import object.CustomErrorListener;

import generated.LITTLEParser;
import generated.LITTLEParser.ProgramContext;
import generated.LITTLELexer;

import org.antlr.runtime.RuleReturnScope;
import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.TokenStream;

public class Parse extends TaskTemplate<ParseResult, TokenSet>{
	
	private TokenSet input;
	private LITTLELexer lexer;
	private ParseResult result;
	
	@Override
	public ParseResult doTask(TokenSet input) {
		this.input = input;
		
		try{
			//Create the token stream (not sure how to instantiate yet)
			CommonTokenStream stream = new CommonTokenStream(lexer);
			
			//Pass the stream to the parser
			LITTLEParser parser = new LITTLEParser(stream);
			
			//Remove old error listener and add our custom one to print Accepted or Not
			parser.removeErrorListener(ConsoleErrorListener.INSTANCE);
			CustomErrorListener errorListener = new CustomErrorListener();
			parser.addErrorListener(errorListener);
			
			//Perform the parse
			ProgramContext context = parser.program();
			
			//Determine if accepted or not
			result = new ParseResult(context);
			result.Accepted = !errorListener.errorOccured;
			
			return result;
		}
		catch(Exception e){
			System.err.println("\n\n\nParser error!\n" + e.getMessage() + "\n\n\n");
		}
		return null;
	}
	
	public void setLexer(LITTLELexer lexer)
	{
		this.lexer = lexer;
	}

	@Override
	public TokenSet getInputObject() {
		return input;
	}

	@Override
	public void printOutput() {
		// TODO Auto-generated method stub
		result.printData();
	}

}
