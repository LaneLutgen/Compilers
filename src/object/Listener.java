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
import java.util.Stack;

import generated.LITTLEBaseListener;
import generated.LITTLEParser;

public class Listener extends LITTLEBaseListener
{
	//MAY OR MAY NOT NEED THIS
	private ArrayList<SymbolTable> tableList = new ArrayList<SymbolTable>();
	
	/*Stack for storing symbol tables per scope*/
	private Stack<SymbolTable> tableStack = new Stack<SymbolTable>();
	
	/*
	 * Entering a function, define a new scope
	 */
	@Override
	public void enterFunc_decl(LITTLEParser.Func_declContext ctx)
	{
		//Object token = ctx.start;
		tableStack.push(new SymbolTable("trying to figure out how to get function name"));
	}
	
	/*
	 * Exiting a function, pop current scope from the stack
	 */
	@Override
	public void exitFunc_body(LITTLEParser.Func_bodyContext ctx)
	{
		tableList.add(tableStack.pop());
	}
	
	/*
	 * Entering an if block, create new symbol table
	 */
	@Override 
	public void enterIf_stmt(LITTLEParser.If_stmtContext ctx) 
	{
		tableStack.push(new SymbolTable("IF BLOCK"));
	}

	/*
	 * Exiting if block, pop from stack and add to list
	 */
	@Override 
	public void exitIf_stmt(LITTLEParser.If_stmtContext ctx) 
	{
		tableList.add(tableStack.pop());
	}
	
	/*
	 * Entering an else block, create new symbol table
	 */
	@Override 
	public void enterElse_part(LITTLEParser.Else_partContext ctx) 
	{
		tableStack.push(new SymbolTable("ELSE BLOCK"));
	}
	
	/*
	 * Exiting an else block, pop from stack and add to list
	 */
	@Override 
	public void exitElse_part(LITTLEParser.Else_partContext ctx)
	{ 
		tableList.add(tableStack.pop());
	}
	
	/*
	 * Entering an while block, create new symbol table
	 */
	@Override 
	public void enterWhile_stmt(LITTLEParser.While_stmtContext ctx) 
	{ 
		tableStack.push(new SymbolTable("WHILE BLOCK"));
	}
	
	/*
	 * Exiting a while block, pop from stack and add to list
	 */
	@Override
	public void exitWhile_stmt(LITTLEParser.While_stmtContext ctx) 
	{
		tableList.add(tableStack.pop());
	}
	
	/*
	 * Entering the program, define a new scope
	 */
	@Override 
	public void enterProgram(LITTLEParser.ProgramContext ctx) 
	{
		tableStack.push(new SymbolTable("GLOBAL"));
	}

	/*
	 * Exiting program, pop the stack.
	 */
	@Override 
	public void exitProgram(LITTLEParser.ProgramContext ctx) 
	{ 
		tableList.add(tableStack.pop());
	}
	
	/*
	 * Declaring a string, add name, type and value to symbol table
	 */
	@Override 
	public void enterString_decl(LITTLEParser.String_declContext ctx)
	{
		SymbolTable curTable = tableStack.peek();
		//TODO: Add to the symbol table
	}

	/*
	 * Declaring a variable (float or int), add name and type to symbol table
	 */
	@Override 
	public void enterVar_decl(LITTLEParser.Var_declContext ctx) 
	{
		SymbolTable curTable = tableStack.peek();
		//TODO: Add to the symbol table
	}
	
	public ArrayList<SymbolTable> getSymbolTables()
	{
		return tableList;
	}
}
