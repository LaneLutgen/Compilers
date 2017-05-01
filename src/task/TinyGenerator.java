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

import java.util.ArrayList;
import java.util.Map.Entry;

import org.antlr.v4.runtime.tree.ParseTreeWalker;

import generated.LITTLEParser.ProgramContext;
import object.IRList;
import object.IRListener;
import object.IRNode;
import object.SymbolTable;
import object.SymbolValue;
import object.TinyConverter;

public class TinyGenerator extends TaskTemplate<ArrayList<String>,IRList>{

	private SymbolTable symbols;
	private IRList input;
	private ArrayList<String> tinyCodes = new ArrayList<String>();
	
	public TinyGenerator(SymbolTable symbols)
	{
		this.symbols = symbols;
	}
	
	@Override
	public ArrayList<String> doTask(IRList input) {
		try{
			this.input = input;
			parseSymbols();
			
			IRNode cur = input.first;
			while(cur != null)
			{
				ArrayList<String> codes = TinyConverter.convert(cur);
				
				for(String c : codes)
				{
					tinyCodes.add(c);
				}
				cur = cur.next;
			}
		}
		catch(Exception e){
			System.err.println("\n\n\nTinyGenerator error!\n" + e.getMessage() + "\n\n\n");
		}
		return null;
	}
	
	private void parseSymbols()
	{
		for(Entry<String, SymbolValue> entry : symbols.entrySet())
		{
			//Check if String type
			SymbolValue val = entry.getValue();
			if(val.getType().equals("STRING"))
			{
				tinyCodes.add("str "+entry.getKey()+" "+val.getValue());
			}
			else
			{
				tinyCodes.add("var "+entry.getKey());
			}	
		}
	}

	@Override
	public IRList getInputObject() {
		// TODO Auto-generated method stub
		return input;
	}

	@Override
	public void printOutput() {
		for(String s : tinyCodes)
		{
			System.out.println(s);
		}
		
	}

}
