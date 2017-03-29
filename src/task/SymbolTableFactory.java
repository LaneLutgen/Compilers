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

import java.util.ArrayList;

import org.antlr.v4.runtime.tree.ParseTreeWalker;

import generated.LITTLEParser.ProgramContext;
import java.util.Map.Entry;
import object.Listener;
import object.ParseResult;
import object.SymbolTable;
import object.SymbolValue;

public class SymbolTableFactory extends TaskTemplate<ArrayList<SymbolTable>, ParseResult>{

	private ParseResult input;
	private Listener parseListener;
	private ArrayList<SymbolTable> symbolTables;
	
	@Override
	public ArrayList<SymbolTable> doTask(ParseResult input) {
		try{
			this.input = input;
			parseListener = new Listener();
			
			ProgramContext context = input.getContext();
			new ParseTreeWalker().walk(parseListener, context);
			
			symbolTables = parseListener.getSymbolTables();
			
			return symbolTables;
		}
		catch(Exception e){
			System.err.println("\n\n\nSymbolTableFactory error!\n" + e.getMessage() + "\n\n\n");
		}
		return null;
	}

	@Override
	public ParseResult getInputObject() {
		return input;
	}

	@Override
	public void printOutput() {
		if(symbolTables != null)
		{
                    int numberOfTables = symbolTables.size();
                    for(SymbolTable table: symbolTables)
                    {
                        System.out.println("Symbol table "+table.getName());
                        for (Entry<String, SymbolValue> entry : table.entrySet())
                        {
                            SymbolValue entrySymbolValue = entry.getValue();
                            String entryName = entry.getKey();
                            String entryType = entrySymbolValue.getType();
                            String entryValue = entrySymbolValue.getValue();

                            if (entryValue == null)
                            {
                                System.out.println("name " + entryName +
                                        " type " + entryType);
                            }
                            else
                            {
                                System.out.println("name " + entryName +
                                        " type " + entryType +
                                        " value " + entryValue);
                            }
                        }
                        if (numberOfTables > 1)
                        {
                            System.out.println();
                            numberOfTables--;
                        }
                    }
		}
	}


}
