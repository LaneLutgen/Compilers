package task;

import object.ParseResult;
import object.TokenSet;

import generated.LITTLEParser;
import generated.LITTLELexer;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

public class Parse extends TaskTemplate<ParseResult, TokenSet>{
	
	private TokenSet input;
	private LITTLELexer lexer;
	
	@Override
	public ParseResult doTask(TokenSet input) {
		this.input = input;
		
		try{
			//Create the token stream (not sure how to instantiate yet)
			TokenStream stream = new CommonTokenStream(lexer);
			
			//Pass the stream to the parser
			LITTLEParser parser = new LITTLEParser(stream);
			
			//Determine if accepted or not
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
		
	}

}
