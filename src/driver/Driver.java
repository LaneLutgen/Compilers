package driver;

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
        // Parse token set
//        Parse parse = new Parse();
//        SyntaxTree syntaxTree = parse.doTask(tokenSet);
//        
        // Run semantic routines
//        SemanticRoutines semRout = new SemanticRoutines();
//        IR ir = semRout.doTask(syntaxTree);
//        
        // Optimize code
//        Optimize optimize = new Optimize();
//        ir = optimize.doTask(ir);
//        
        // Generate executable
//        Generate generate = new Generate();
//        generate.doTask();
    }
}
