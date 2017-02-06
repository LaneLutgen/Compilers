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

import generated.LITTLELexer;
import java.io.File;
import java.io.FileInputStream;
import object.FilePath;
import object.TokenSet;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.Vocabulary;

/**
 *
 * @author lanelutgen
 * @author matthewrohrlach
 */
public class Scan extends TaskTemplate<TokenSet,FilePath>{
    
    // =============== Globals ============================
    private FilePath input;
    private String outputString;
    
    // =============== Methods ============================
    @Override
    /**
     * Run the Scanner task on a given FilePath, output a TokenSet
     */
    public TokenSet doTask(FilePath inputIn) {
        input = inputIn;
        outputString = "";
        
        try
        {
            //Open micro file input (replace System.in with actual file stream)
            CharStream stream = new ANTLRInputStream(new FileInputStream(new File(input.getData())));

            // Create a new lexer on the specified 'CharStream'
            LITTLELexer lexer = new LITTLELexer(stream);

            // Scan types are enumerated, so we need to create a
            // 'Vocabulary' to lookup the symbol names from the
            // enumerated value. Note: The 'EOF' token has a value
            // of -1, and all other reules are enumerated from 0.
            Vocabulary vocab = lexer.getVocabulary();
            TokenSet output = new TokenSet(vocab);

            // A simple loop that prints out all token symbols and
            // their literal values. This is not quite set up as you
            // want for the grading script - you will need to change
            // the format a bit.
            Token token = null;
            do 
            {
              token = lexer.nextToken();
              printToken(vocab, token);
              
              //Write tokens to an output TokenSet object
              output.addToken(token);
              
            } while (token.getType() != Token.EOF);
            //Run antlr on program to generate tokens
            
            return output;
        }
        catch(Exception e)
        {
                System.err.println("\n\n\nScanner error!\n" + e.getMessage() + "\n\n\n");
        }
        return null;
    }
    
    @Override
    /**
     * Access the private input object of this task
     */
    public FilePath getInputObject() {
        return input;
    }
    
    @Override
    /**
     * Reprint total console output of this task
     */
    public void printOutput() {
        System.out.println(outputString);
    }
    
    /**
     * Print token name and text to console
     * @param vocab
     * @param token 
     */
    private void printToken(Vocabulary vocab, Token token) {
        outputString += ("\t" + vocab.getSymbolicName(token.getType()) +
                                 "\t\t" + token.getText());
        System.out.println("\t" + vocab.getSymbolicName(token.getType()) +
                                 "\t\t" + token.getText());
    }
}
