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
import java.util.Arrays;
import java.util.Map.Entry;
import java.util.Stack;
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
        
        irList.addLABELNode(funcName);
        irList.addLINKNode();
	}
	
	/*
	 * Entering while loop, create new LABEL
	 */
	@Override
	public void enterWhile_stmt(LITTLEParser.While_stmtContext ctx)
	{
		irList.addLABELNode("label"+labelIndex);
		labelIndex++;
	}
	
	@Override
	public void exitWhile_stmt(LITTLEParser.While_stmtContext ctx)
	{
		irList.addLABELNode("label"+labelIndex);
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
		irList.addLABELNode("label"+labelIndex);
		labelIndex++;
	}
	
	@Override
	public void enterElse_part(LITTLEParser.Else_partContext ctx)
	{
		irList.addLABELNode("label"+labelIndex);
		labelIndex++;
	}
	
	/*
	 * Exiting assign stmt, create the STOREI instructions
	 */
	@Override
	public void exitAssign_stmt(LITTLEParser.Assign_stmtContext ctx)
	{
		String varName = ctx.start.getText();
		String tempRegister = null;
		
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
				boolean hasOps = evaluateExprFloat(curExprValue);
				
				try
				{
					registerIndex--;
					Float f = Float.parseFloat(curExprValue);
					tempRegister = "$T"+registerIndex;
					irList.addSTOREFNode(tempRegister, varName);
					registerIndex++;
				}
				catch(Exception e)
				{
					if(hasOps){
						tempRegister = "$T"+registerIndex;
						irList.addSTOREFNode(tempRegister, varName);
					}	
					else{
						irList.addSTOREFNode(curExprValue, varName);
					}
				}	
			}
			else if(varType.equals("INT"))
			{
				boolean hasOps = evaluateExprInt(curExprValue);
				
				try
				{
					registerIndex--;
					Integer i = Integer.parseInt(curExprValue);
					tempRegister = "$T"+registerIndex;
					irList.addSTOREINode(tempRegister, varName);
					registerIndex++;
				}
				catch(Exception e)
				{
					if(hasOps){
						tempRegister = "$T"+registerIndex;
						irList.addSTOREINode(tempRegister, varName);
					}	
					else{
						irList.addSTOREINode(curExprValue, varName);
					}
				}
				
			}
		}
		
	}
	
	private boolean evaluateExprFloat(String exp)
	{
		boolean hasOperators = false;
		
		char[] tokens = exp.toCharArray();
		
		Stack<String> variables = new Stack<String>();
		Stack<Character> operations = new Stack<Character>();
		
		for(int i = 0; i < tokens.length; i++)
		{
			if(tokens[i] == ' ')
			{
				continue;
			}
			else if(tokens[i] == '+' || tokens[i] == '-' ||
                    tokens[i] == '*' || tokens[i] == '/')
			{				
				while(!operations.empty() && hasPrecedence(tokens[i], operations.peek()))
				{
					String reg = generateFloatArithmetic(operations.pop(), variables.pop(), variables.pop());
					variables.push(reg);
				}
				operations.push(tokens[i]);
				hasOperators = true;
			}
			else if(tokens[i] == '(')
			{
				operations.push(tokens[i]);
			}
			else if(tokens[i] == ')')
			{
				while(operations.peek() != '(')
				{
					String reg = generateFloatArithmetic(operations.pop(), variables.pop(), variables.pop());
					variables.push(reg);
				}
			}
			else
            {
                StringBuffer sbuf = new StringBuffer();
                // There may be more than one digits in number
                while (i < tokens.length && tokens[i] != '+' && tokens[i] != '-' &&
                        tokens[i] != '*' && tokens[i] != '/' && tokens[i] != '(' && tokens[i] != ')')
                {
                	sbuf.append(tokens[i++]);
                }
                
                try
                {
                	Float val = Float.parseFloat(sbuf.toString());
                	String reg = "$T"+registerIndex;
                	irList.addSTOREFNode(val.toString(), reg);
                	variables.push(reg);
                	registerIndex++;
                }
                catch(Exception e)
                {
                    variables.push(sbuf.toString());
                }
                
                i--;
            }
		}
		
		while(!operations.isEmpty())
		{
			char op = operations.pop();
			if(op != '(' && op != ')')
			{
				generateFloatArithmetic(op, variables.pop(), variables.pop());
			}
		}
		
		return hasOperators;
	}
	
	private boolean evaluateExprInt(String expr)
	{
		boolean hasOperators = false;
		
		char[] tokens = expr.toCharArray();
		
		Stack<String> variables = new Stack<String>();
		Stack<Character> operations = new Stack<Character>();
		
		for(int i = 0; i < tokens.length; i++)
		{
			if(tokens[i] == ' ')
			{
				continue;
			}
			else if(tokens[i] == '+' || tokens[i] == '-' ||
                    tokens[i] == '*' || tokens[i] == '/')
			{				
				while(!operations.empty() && hasPrecedence(tokens[i], operations.peek()))
				{
					String reg = generateIntArithmetic(operations.pop(), variables.pop(), variables.pop());
					variables.push(reg);
				}
				operations.push(tokens[i]);
				
				hasOperators = true;
			}
			else if(tokens[i] == '(')
			{
				operations.push(tokens[i]);
			}
			else if(tokens[i] == ')')
			{
				while(operations.peek() != '(')
				{
					String reg = generateIntArithmetic(operations.pop(), variables.pop(), variables.pop());
					variables.push(reg);
				}
			}
			else
            {
                StringBuffer sbuf = new StringBuffer();
                // There may be more than one digits in number
                while (i < tokens.length && tokens[i] != '+' && tokens[i] != '-' &&
                        tokens[i] != '*' && tokens[i] != '/' && tokens[i] != '(' && tokens[i] != ')')
                {
                	sbuf.append(tokens[i++]);
                }
                
                i--;
                
                try
                {
                	Integer val = Integer.parseInt(sbuf.toString());
                	String reg = "$T"+registerIndex;
                	irList.addSTOREINode(val.toString(), reg);
                	variables.push(reg);
                	registerIndex++;
                }
                catch(Exception e)
                {
                    variables.push(sbuf.toString());
                }
               
            }
		}
		
		while(!operations.isEmpty())
		{
			char op = operations.pop();
			if(op != '(' && op != ')')
			{
				generateIntArithmetic(op, variables.pop(), variables.pop());
			}
		}
		
		return hasOperators;
	}
	
	private boolean hasPrecedence(char opOne, char opTwo)
	{
		if (opTwo == '(' || opTwo == ')')
            return false;
        if ((opOne == '*' || opOne == '/') && (opTwo == '+' || opTwo == '-'))
            return false;
        else
            return true;
	}
	
	private String generateFloatArithmetic(char op, String varOne, String varTwo)
	{
		String tempRegister = "$T"+registerIndex;
		
		switch(op)
		{
			case '+':
				irList.addADDFNode(varTwo, varOne, tempRegister);
				break;
			case '-':
				irList.addSUBFNode(varTwo, varOne, tempRegister);
				break;
			case '*':
				irList.addMULTFNode(varTwo, varOne, tempRegister);
				break;
			case '/':
				irList.addDIVFNode(varTwo, varOne, tempRegister);	
				break;
		}
		
		registerIndex++;
		
		return tempRegister;
	}
	
	private String generateIntArithmetic(char op, String varOne, String varTwo)
	{
		String tempRegister = "$T"+registerIndex;
		
		switch(op)
		{
			case '+':
				irList.addADDINode(varTwo, varOne, tempRegister);
				break;
			case '-':
				irList.addSUBINode(varTwo, varOne, tempRegister);
				break;
			case '*':
				irList.addMULTINode(varTwo, varOne, tempRegister);
				break;
			case '/':
				irList.addDIVINode(varTwo, varOne, tempRegister);	
				break;
		}
		
		registerIndex++;
		
		return tempRegister;
	}
	
	
	@Override
	public void exitExpr(LITTLEParser.ExprContext ctx)
	{
		String value = ctx.getText();
		curExprValue = value;
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
