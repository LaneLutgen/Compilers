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
package object;

import java.util.ArrayList;
import java.util.LinkedList;

import generated.LITTLEBaseListener;
import generated.LITTLEParser;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SymbolTableListener extends LITTLEBaseListener
{
	//MAY OR MAY NOT NEED THIS
	private ArrayList<SymbolTable> tableList = new ArrayList<SymbolTable>();
	
	/*LinkedList for storing symbol tables per scope*/
	private LinkedList<SymbolTable> tableLinkedList = new LinkedList<SymbolTable>();
        
        // Track number of block tables
        private int blockCounter = 1;
        
        private boolean skipNextIfBlockRemove = false;
        private boolean skipNextElseBlockRemove = false;
	
	/*
	 * Entering a function, define a new scope
	 */
	@Override
	public void enterFunc_decl(LITTLEParser.Func_declContext ctx)
	{
            // Search for function name
            String context = ctx.getText();
            String funcName = this.getFunctionNameFromContext(context);
            
            // Create associated table
            if(funcName != null)
            {
                //Object token = ctx.start;
                tableLinkedList.add(new SymbolTable(funcName));
            }
            else {
                System.err.println("Null function name: " + context);
            }
            
            
            // Continue declarations (arguments to add to table)
            context = context.substring(context.indexOf("(")+1, context.indexOf(")"));
            
            boolean done = false;
            while (!done)
            {
                // Search for capitalized variable name
                String type = this.getVariableTypeFromContext(context);
                if (type != null)
                {
                    // Use type to add variable to symbol table
                    switch (type) 
                    {
                        case "INT":
                        case "FLOAT":
                            // Process int or float
                            this.continueVar_decl(type, context);
                            break;
                        case "STRING":
                            // Process string
                            this.continueString_decl(type, context);
                            break;
                        default:
                            // Unrecognized variable type
                            System.err.println("Type \"" + type + "\" not recognized!");
                            break;
                    }
                    
                    // Check for further variables to add
                    if (context.contains(",")) {
                        
                        // Delete portion of string that proceeds next comma
                        context = context.substring(context.indexOf(",")+1);
                    }
                    else {
                        // No further variables found
                        done = true;
                    }
                }
                
                // No variables found at all means we're done
                else
                {
                    done = true;
                }
            }
	}
	
	/*
	 * Exiting a function, pop current scope from the stack
	 */
	@Override
	public void exitFunc_body(LITTLEParser.Func_bodyContext ctx)
	{
		tableList.add(tableLinkedList.remove());
	}
	
	/*
	 * Entering an if block, create new symbol table
	 */
	@Override 
	public void enterIf_stmt(LITTLEParser.If_stmtContext ctx) 
	{
            if (!(ctx == null || ctx.getText().isEmpty())) 
            {
                tableLinkedList.add(new SymbolTable("BLOCK " + blockCounter));
                    blockCounter++;
            }
            else {
                skipNextIfBlockRemove = true;
            }
	}

	/*
	 * Exiting if block, pop from stack and add to list
	 */
	@Override 
	public void exitIf_stmt(LITTLEParser.If_stmtContext ctx) 
	{
            if (!skipNextIfBlockRemove)
            {
		tableList.add(tableLinkedList.remove());
            }
            else
            {
                skipNextIfBlockRemove = false;
            }
	}
	
	/*
	 * Entering an else block, create new symbol table
	 */
	@Override 
	public void enterElse_part(LITTLEParser.Else_partContext ctx) 
	{
//		tableLinkedList.add(new SymbolTable("ELSE BLOCK"));
            if (!(ctx == null || ctx.getText().isEmpty())) 
            {
                tableLinkedList.add(new SymbolTable("BLOCK " + blockCounter));
                    blockCounter++;
            }
            else {
                skipNextElseBlockRemove = true;
            }
	}
	
	/*
	 * Exiting an else block, pop from stack and add to list
	 */
	@Override 
	public void exitElse_part(LITTLEParser.Else_partContext ctx)
	{ 
            if (!skipNextElseBlockRemove)
            {
		tableList.add(tableLinkedList.remove());
            }
            else
            {
                skipNextElseBlockRemove = false;
            }
	}
	
	/*
	 * Entering an while block, create new symbol table
	 */
	@Override 
	public void enterWhile_stmt(LITTLEParser.While_stmtContext ctx) 
	{ 
		tableLinkedList.add(new SymbolTable("BLOCK " + blockCounter));
                blockCounter++;
	}
	
	/*
	 * Exiting a while block, pop from stack and add to list
	 */
	@Override
	public void exitWhile_stmt(LITTLEParser.While_stmtContext ctx) 
	{
		tableList.add(tableLinkedList.remove());
	}
	
	/*
	 * Entering the program, define a new scope
	 */
	@Override 
	public void enterProgram(LITTLEParser.ProgramContext ctx) 
	{
		tableLinkedList.add(new SymbolTable("GLOBAL"));
	}

	/*
	 * Exiting program, pop the stack.
	 */
	@Override 
	public void exitProgram(LITTLEParser.ProgramContext ctx) 
	{ 
		tableList.add(tableLinkedList.remove());
	}
	
	/*
	 * Declaring a string, add name, type and value to symbol table
	 */
	@Override 
	public void enterString_decl(LITTLEParser.String_declContext ctx)
	{
		String context = ctx.getText();
                int numberOfDeclarations = 1;
                
                // Count number of separate variables to instantiate
                String tempContext = context;
                while (tempContext.contains(","))
                {
                    numberOfDeclarations++;
                    tempContext = tempContext.substring(tempContext.indexOf(",")+1);
                }
                
                // Find variable type
                String type = this.getVariableTypeFromContext(context);
                
                // Add variables to symbol table on top of stack
                for (int i = 0; i < numberOfDeclarations; i++) {
                    this.continueString_decl(type, context);
                    if (context.contains(","))
                    {
                        context = context.substring(context.indexOf(",")+1);
                    }
                }
	}
        
        /**
         * Finish adding string symbol to top table from given context
         * Takes in only first variable and value. DOES NOT LOOP ON ITS OWN.
         * @param type
         * @param context 
         */
        public void continueString_decl(String type, String context)
        {
            // Attempt to retrieve value (if applicable)
            String value = null;
            if (context.contains("=")) {
                value = context.substring(
//                        context.indexOf("\"")+1, context.lastIndexOf("\""));
                        context.indexOf("=")+1, context.indexOf(";"));
            }
            
            // Create symbol and add to table
            String name = this.getVariableNameFromContext(context);
            if (name != null)
            {
                // Symbol table mappings are name -> SymbolValue (value, type)
                SymbolTable curTable = tableLinkedList.getLast();
                if (!curTable.containsKey(name))
                {
                    // Add name -> symbol value mapping to table
                    SymbolValue newValue = new SymbolValue(value, type);
                    curTable.put(name, newValue);
                }
                else
                {
                    // Store declaration error in symbol table for later output.
                    // These errors are stored as fake symbols so that they may be read in order during output printing.
                    SymbolValue newError = new SymbolValue(null, "DECLARATION_ERROR");
                    curTable.put("DECLARATION_ERROR" + name + ";;;", newError);
                }
            }
            else {
                System.err.println("Null variable name: " + context);
            }
        }

	/*
	 * Declaring a variable (float or int), add name and type to symbol table
	 */
	@Override 
	public void enterVar_decl(LITTLEParser.Var_declContext ctx) 
	{
		String context = ctx.getText();
                int numberOfDeclarations = 1;
                
                // Count number of separate variables to instantiate
                String tempContext = context;
                while (tempContext.contains(","))
                {
                    numberOfDeclarations++;
                    tempContext = tempContext.substring(tempContext.indexOf(",")+1);
                }
                
                // Find variable type
                String type = this.getVariableTypeFromContext(context);
                
                // Add variables to symbol table on top of stack
                for (int i = 0; i < numberOfDeclarations; i++) {
                    this.continueVar_decl(type, context);
                    if (context.contains(","))
                    {
                        context = context.substring(context.indexOf(",")+1);
                    }
                }
	}
        
        /**
         * Finish adding int or float symbol to top table from given context.
         * Takes in only first variable and value. DOES NOT LOOP ON ITS OWN.
         * @param type
         * @param context 
         */
        public void continueVar_decl(String type, String context)
        {
            // Attempt to retrieve value (if applicable)
            String value = null;
            if (context.contains("=")) {
                value = context.substring(
                        context.indexOf("=")+1, context.indexOf(";"));
            }
            
            // Create symbol and add to table
            String name = this.getVariableNameFromContext(context);
            if (name != null)
            {
                // Symbol table mappings are name -> SymbolValue (value, type)
                SymbolTable curTable = tableLinkedList.getLast();
                if (!curTable.containsKey(name))
                {
                    // Add name -> symbol value mapping to table
                    SymbolValue newValue = new SymbolValue(value, type);
                    curTable.put(name, newValue);
                }
                else
                {
                    // Store declaration error in symbol table for later output
                    SymbolValue newError = new SymbolValue(null, "DECLARATION_ERROR");
                    curTable.put("DECLARATION_ERROR" + name + ";;;", newError);
                }
            }
            else {
                System.out.println("Null variable name: " + context);
            }
        }
        
        /**
         * Take context and extract a function name
         * @param context
         * @return 
         */
        public String getFunctionNameFromContext(String context)
        {
            // Remove "FUNCTION" and return type from context
            String regPattern = "FUNCTIONINT|FUNCTIONSTRING|FUNCTIONFLOAT|FUNCTIONVOID";
            Pattern pattern = Pattern.compile(regPattern);
            Matcher matcher = pattern.matcher(context);
            
            if(matcher.find())
            {
                context = context.substring(matcher.end());
            }
            
            // Search for one or more lowercase letters and digits in succession (variable names)
            regPattern = "[a-zA-Z0-9]+";
            pattern = Pattern.compile(regPattern);
            matcher = pattern.matcher(context);
            
            if(matcher.find())
            {
                String funcName = context.substring(matcher.start(), matcher.end());
                return funcName;
            }
            
            return null;
        }
        
        /**
         * Take context and extract a variable name
         * @param context
         * @return 
         */
        public String getVariableNameFromContext(String context)
        {
            // Search for one or more lowercase letters and digits in succession (variable names)
            String regPattern = "[a-z0-9]+";
            Pattern pattern = Pattern.compile(regPattern);
            Matcher matcher = pattern.matcher(context);
            
            if(matcher.find())
            {
                String varName = context.substring(matcher.start(), matcher.end());
                return varName;
            }
            
            return null;
        }
        
        /**
         * Take context and extract a variable type
         * @param context
         * @return 
         */
        public String getVariableTypeFromContext(String context)
        {
            // Search for capitalized variable name
                String type;
                String regPattern = "[A-Z]+";
                Pattern pattern = Pattern.compile(regPattern);
                Matcher matcher = pattern.matcher(context);
                
                // If capitalized variable name is found, type is found
                if(matcher.find())
                {
                    type = context.substring(matcher.start(), matcher.end());
                    return type;
                }
                
                return null;
        }
	
	public ArrayList<SymbolTable> getSymbolTables()
	{
		return tableList;
	}
}
