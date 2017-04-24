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
package object;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import generated.LITTLEBaseListener;
import generated.LITTLEParser;

/*
 * This class is a IR specific listener for generating IR code based on parser results
 */
public class IRListener extends LITTLEBaseListener{

	//List for storing our IRNodes
	private IRList irList = new IRList();
	
	//Index used for temp registers, Ex. $T1, $T2, etc.
	private int registerIndex = 1;
	private int labelIndex = 1;
	
	private String curExprValue;
	private String curOperator;
	
	private SymbolTable symbols;
	
	public void setSymbolTable(SymbolTable table)
	{
		this.symbols = table;
	}
	
	public IRList getIRList()
	{
		return irList;
	}
	
	/*
	 * Entering a function, create its LABEL instruction
	 */
	@Override
	public void enterFunc_decl(LITTLEParser.Func_declContext ctx)
	{
		// Search for function name
        String context = ctx.getText();
        String funcName = this.getFunctionNameFromContext(context);
        
        addLABELNode(funcName);
	}
	
	/*
	 * Entering while loop, create new LABEL
	 */
	@Override
	public void enterWhile_stmt(LITTLEParser.While_stmtContext ctx)
	{
		addLABELNode("label"+labelIndex);
		labelIndex++;
	}
	
	@Override
	public void exitWhile_stmt(LITTLEParser.While_stmtContext ctx)
	{
		addLABELNode("label"+labelIndex);
		labelIndex++;
	}
	
	@Override
	public void enterIf_stmt(LITTLEParser.If_stmtContext ctx)
	{
		//Check the conditional to generate correct instruction
	}
	
	@Override
	public void exitIf_stmt(LITTLEParser.If_stmtContext ctx)
	{
		addLABELNode("label"+labelIndex);
		labelIndex++;
	}
	
	@Override
	public void enterElse_part(LITTLEParser.Else_partContext ctx)
	{
		addLABELNode("label"+labelIndex);
		labelIndex++;
	}
	
	private void addLABELNode(String name)
	{
		IRNode node = new IRNode("LABEL", null, null, name);
		irList.insert(node);
	}
	
	/*
	 * Exiting assign stmt, create the STOREI instructions
	 */
	@Override
	public void exitAssign_stmt(LITTLEParser.Assign_stmtContext ctx)
	{
		String varName = ctx.start.getText();
		String tempRegister = "$T"+registerIndex;
		
		String varType = null;
		
		//Search symbol table for variable type
		for(Entry<String, SymbolValue> entry : symbols.entrySet())
		{
			SymbolValue val = entry.getValue();
			if(entry.getKey() != null)
			{
				if(entry.getKey().equals(varName))
				{
					varType = val.getType();
				}
			}
		}
		
		if(varType != null)
		{
			if(varType.equals("FLOAT"))
			{
				addSTOREFNode(curExprValue, tempRegister);
				addSTOREFNode(tempRegister, varName);
			}
			else if(varType.equals("INT"))
			{
				addSTOREINode(curExprValue, tempRegister);
				addSTOREINode(tempRegister, varName);
			}
			registerIndex++;
		}
		
	}
	
	@Override
	public void exitExpr(LITTLEParser.ExprContext ctx)
	{
		String value = ctx.getText();
		curExprValue = value;
		
		//Here we will have to generate any instructions for evaluation
		//Ex. ADD, SUB, etc.
	}
	
	
	private void addSTOREFNode(String input, String output)
	{
		IRNode node = new IRNode("STOREF", input, null, output);
		irList.insert(node);
	}
	
	private void addSTOREINode(String input, String output)
	{
		IRNode node = new IRNode("STOREI", input, null, output);
		irList.insert(node);
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
}
