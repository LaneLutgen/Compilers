
import java.io.*;
import org.antlr.v4.runtime.*;

public class Driver {

	public static void main(String[] args) {
		try{
		//Open micro file input (replace System.in with actual file stream)
		CharStream stream = new ANTLRInputStream(new FileInputStream(new File("inputs/fibonacci.micro")));
		
		// Create a new lexer on the specified 'CharStream'
	    LITTLELexer lexer = new LITTLELexer(stream);

	      // Lexer types are enumerated, so we need to create a
	      // 'Vocabulary' to lookup the symbol names from the
	      // enumerated value. Note: The 'EOF' token has a value
	      // of -1, and all other reules are enumerated from 0.
	      Vocabulary vocab = lexer.getVocabulary();

	      // A simple loop that prints out all token symbols and
	      // their literal values. This is not quite set up as you
	      // want for the grading script - you will need to change
	      // the format a bit.
	      Token token = null;
	      do {
	        token = lexer.nextToken();
	        System.out.println("\t" + vocab.getSymbolicName(token.getType()) +
	                           "\t\t" + token.getText());
	      } while (token.getType() != Token.EOF);
		//Run antlr on program to generate tokens
		
		//Write tokens to an output micro file
		}
		catch(Exception e)
		{
			System.out.println("Bad things happened");
		}
	}

}
