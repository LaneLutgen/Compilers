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
package driver;

import java.util.ArrayList;

import object.*;
import task.*;

public class Driver {

    // =========== Globals =========
    private final String filePathString;
    
    // =========== Constructors ==================
    public Driver(String filePathStringIn) {
        
        filePathString = filePathStringIn;
        this.runSequence();
    }
    
    // =========== Methods ===================
    public final void runSequence() {
        
        // Instantiate objects and run tasks in sequence:
        
        // Scan for tokens
        FilePath filePath = new FilePath(filePathString);
        Scan scan = new Scan();
        TokenSet tokenSet = scan.doTask(filePath);
        
        // [Example progression from here]
        //Parse token set
        Parse parse = new Parse();
        parse.setLexer(scan.lexer);
        ParseResult parseResult = parse.doTask(tokenSet);
        //parseResult.printData();

        SymbolTableFactory symTblFactory = new SymbolTableFactory();
        ArrayList<SymbolTable> tables = symTblFactory.doTask(parseResult);
        symTblFactory.printOutput();
       
        // Optimize code
//        Optimize optimize = new Optimize();
//        ir = optimize.doTask(ir);
//        
        // Generate executable
//        Generate generate = new Generate();
//        generate.doTask();
    }
}
