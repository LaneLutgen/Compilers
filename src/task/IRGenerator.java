/*
 * The MIT License
 *
 * Copyright 2017 Lane Lutgen.
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

import org.antlr.v4.runtime.tree.ParseTreeWalker;

import generated.LITTLEParser.ProgramContext;
import object.IRList;
import object.IRListener;
import object.IRNode;
import object.ParseResult;
import object.SymbolTable;

public class IRGenerator extends TaskTemplate<IRList ,ParseResult>{

	private ParseResult input;
	private IRListener irListener;
	private IRList output;
	private SymbolTable globalSymbolTable;
	
	public void setSymbolTable(SymbolTable table)
	{
		globalSymbolTable = table;
	}
	
	@Override
	public IRList doTask(ParseResult input) {
		try{
			this.input = input;
			irListener = new IRListener();
			irListener.setSymbolTable(globalSymbolTable);
			
			ProgramContext context = input.getContext();
			new ParseTreeWalker().walk(irListener, context);
			
			output = irListener.getIRList();
			
			return output;
		}
		catch(Exception e){
			System.err.println("\n\n\nIRGenerator error!\n" + e.getMessage() + "\n\n\n");
		}
		return null;
	}

	@Override
	public ParseResult getInputObject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void printOutput() {
		// TODO Auto-generated method stub
		System.out.println(";IR code");
		
		IRNode cur = output.first;
		while(cur != null)
		{
			System.out.print(";");
			cur.printData();
			cur = cur.next;
		}
	}

}
