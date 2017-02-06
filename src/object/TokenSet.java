/*
 * The MIT License
 *
 * Copyright 2017 matthewrohrlach.
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
package object;

import java.util.ArrayList;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.Vocabulary;

/**
 *
 * @author matthewrohrlach
 */
public class TokenSet extends ObjectTemplate{
    
    // ============== Globals ====================
    private final ArrayList<Token> tokenList;
    private final Vocabulary vocabulary;
    
    // ============== Constructors ===============
    public TokenSet(Vocabulary vocabularyIn) {
        vocabulary = vocabularyIn;
        tokenList = new ArrayList<>();
    }
    
    
    // ============== Methods ====================
    
    /**
     * Add given token to end of list
     * @param tokenToAdd 
     */
    public void addToken(Token tokenToAdd) {
        tokenList.add(tokenToAdd);
    }
    
    /**
     * Access list of token objects
     * @return 
     */
    public ArrayList<Token> getData() {
        return this.tokenList;
    }
    
    /**
     * Retrieve specified token index from tokenList
     * @param index
     * @return 
     */
    public Token getTokenAtIndex(int index) {
        try {
            return tokenList.get(index);
        } catch (Exception e) {
            System.out.println("No token at that index!");
            return null;
        }
    }
    
    /**
     * Test if tokenList contains specified token
     * @param searchToken
     * @return 
     */
    public boolean hasToken(Token searchToken) {
        return tokenList.contains(searchToken);
    }
    
    @Override
    /**
     * Print every token to console
     */
    public void printData() {
        for (Token token : tokenList) {
            System.out.println("\t" + vocabulary.getSymbolicName(token.getType()) +
                                 "\t\t" + token.getText());
        }
    }
}
