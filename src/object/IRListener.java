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
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import generated.LITTLEBaseListener;
import generated.LITTLEParser;
import java.text.DecimalFormat;

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
	 * Exiting a function, create its LABEL instruction
	 */
	@Override
	public void exitFunc_decl(LITTLEParser.Func_declContext ctx)
	{
		irList.addRETURNNode();
	}
	
	/*
	 * Entering while loop, create new LABEL
	 */
	@Override
	public void enterWhile_stmt(LITTLEParser.While_stmtContext ctx)
	{
		irList.addLABELNode("label"+labelIndex);
                
                //Check the conditional to generate correct instruction
                String conditional = ctx.children.get(2).getText();
                this.evaluateCond(conditional);
	}
	
	@Override
	public void exitWhile_stmt(LITTLEParser.While_stmtContext ctx)
	{
		irList.addJUMPNode("label"+labelIndex);
		labelIndex++;
		irList.addLABELNode("label"+labelIndex);        
                // Generate code for conditional
                
	}
	
	@Override
	public void enterIf_stmt(LITTLEParser.If_stmtContext ctx)
	{
		//Check the conditional to generate correct instruction
                String conditional = ctx.children.get(2).getText();
                this.evaluateCond(conditional);
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
                                        registerIndex++;
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
                                        registerIndex++;
				}
				
			}
		}
	}
        
        @Override
	public void exitExpr(LITTLEParser.ExprContext ctx)
	{
		String value = ctx.getText();
		curExprValue = value;
	}
     
    @Override    
    public void enterWrite_stmt(LITTLEParser.Write_stmtContext ctx)
    {
    	String exp = ctx.getText();
    	evaluateReadWriteExpr(exp, false);
    }
    
    @Override
    public void enterRead_stmt(LITTLEParser.Read_stmtContext ctx)
    {
    	String exp = ctx.getText();
    	evaluateReadWriteExpr(exp, true);
    }
    
    private void evaluateReadWriteExpr(String exp, boolean isRead)
    {
    	char[] tokens = exp.toCharArray();
    	
    	String varName = null;
    	
    	for(int i = 0; i < tokens.length; i++)
		{
    		if(tokens[i] == ' ')
    		{
    			continue;
    		}
    	    else if(tokens[i] == '(')
    		{
    			continue;
    		}
    		else if(tokens[i] == ')')
    		{
    			continue;
    		}
    		else if(tokens[i] == ',')
    		{
    			varName = null;
    		}
    		else
    		{
    			StringBuffer sbuf = new StringBuffer();
                while (i < tokens.length && tokens[i] != '(' && tokens[i] != ')' && tokens[i] != ',')
                {
                	sbuf.append(tokens[i++]);
                }
                varName = sbuf.toString(); 
                
                if(!varName.equals("WRITE") && !varName.equals("READ"))
                {
                	if(varName.equals("newline"))
                	{
                		if(!isRead)
                		{
                			irList.addWRITESNode();
                		}
                	}
                	else
                	{
                		String varType = null;
                		//Determine if int or float
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
                				if(isRead)
                					irList.addREADFNODE(varName);
                				else
                					irList.addWRITEFNode(varName);
                			}
                			else
                			{
                				if(isRead)
                					irList.addREADINODE(varName);
                				else
                					irList.addWRITEINode(varName);
                			}
                		}
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
                        
                        // Prevent exponential notation
                        DecimalFormat decimalFormat = new DecimalFormat("#");
                        int numFractionDigits = String.valueOf(Math.round(1 / val)).length();
                        decimalFormat.setMinimumIntegerDigits(1);
                        decimalFormat.setMinimumFractionDigits(1);
                        decimalFormat.setMaximumFractionDigits(numFractionDigits);
                        
                	String reg = "$T"+registerIndex;
                	irList.addSTOREFNode(decimalFormat.format(val), reg);
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
                    generateIntArithmetic(op, variables.pop(), variables.peek());
                }
            }

            return hasOperators;
	}
        
        private boolean evaluateCond(String expr)
	{
            char[] tokens = expr.toCharArray();
            ArrayList<String> tokenStrings = new ArrayList<>();
            
            // Convert tokens into strings to catch multi-char operators
            boolean testNextToken = false;
            boolean addingVariableToken = false;
            String currentToken = "";
            for (int i = 0; i < tokens.length; i++)
            {
                // Get ready for the worst switch statement in the world.
                switch(tokens[i])
                {
                    case '>':
                        // Previous token could have been opener to multi-token
                        if (testNextToken)
                        {
                            // Should never be second char in multi-token
                            System.err.println("Token not recognized!");
                            
                            // End multi-token token
                            testNextToken = false;
                            tokenStrings.add(currentToken + ">");
                        }
                        // Previous token(s) were part of variable token and this token may be opener to multi-token
                        else if (addingVariableToken)
                        {
                            // End multi-char variable
                            addingVariableToken = false;
                            tokenStrings.add(currentToken);
                            
                            // Start potential multi-token
                            testNextToken = true;
                            currentToken = ">";
                        }
                        // This token may be opener to multi-token
                        else
                        {
                            // Start potential multi-token
                            testNextToken = true;
                            currentToken = ">";
                        }
                        break;
                    case '<':
                        if (testNextToken)
                        {
                            System.err.println("Token not recognized!");
                            testNextToken = false;
                            tokenStrings.add(currentToken + "<");
                        }
                        else if (addingVariableToken)
                        {
                            addingVariableToken = false;
                            tokenStrings.add(currentToken);
                            
                            testNextToken = true;
                            currentToken = "<";
                        }
                        else
                        {
                            testNextToken = true;
                            currentToken = "<";
                        }
                        break;
                    case '=':
                        if (testNextToken)
                        {
                            testNextToken = false;
                            tokenStrings.add(currentToken + "=");
                        }
                        else if (addingVariableToken)
                        {
                            addingVariableToken = false;
                            tokenStrings.add(currentToken);
                            
                            testNextToken = true;
                            currentToken = "=";
                        }
                        else
                        {
                            testNextToken = true;
                            currentToken = "=";
                        }
                        break;
                    case '!':
                        if (testNextToken)
                        {
                            System.err.println("Token not recognized!");
                            testNextToken = false;
                            tokenStrings.add(currentToken + "!");
                        }
                        else if (addingVariableToken)
                        {
                            addingVariableToken = false;
                            tokenStrings.add(currentToken);
                            
                            testNextToken = true;
                            currentToken = "!";
                        }
                        else
                        {
                            testNextToken = true;
                            currentToken = "!";
                        }
                        break;
                    case '&':
                        if (testNextToken)
                        {
                            testNextToken = false;
                            tokenStrings.add(currentToken + "&");
                        }
                        else if (addingVariableToken)
                        {
                            addingVariableToken = false;
                            tokenStrings.add(currentToken);
                            
                            testNextToken = true;
                            currentToken = "&";
                        }
                        else
                        {
                            testNextToken = true;
                            currentToken = "&";
                        }
                        break;
                    case '|':
                        if (testNextToken)
                        {
                            testNextToken = false;
                            tokenStrings.add(currentToken + "|");
                        }
                        else if (addingVariableToken)
                        {
                            addingVariableToken = false;
                            tokenStrings.add(currentToken);
                            
                            testNextToken = true;
                            currentToken = "|";
                        }
                        else
                        {
                            testNextToken = true;
                            currentToken = "|";
                        }
                        break;
                    case '(':
                        if (testNextToken)
                        {
                            testNextToken = false;
                            tokenStrings.add(currentToken);
                            tokenStrings.add("(");
                        }
                        else if (addingVariableToken)
                        {
                            addingVariableToken = false;
                            tokenStrings.add(currentToken);
                            tokenStrings.add("(");
                        }
                        else
                        {
                            tokenStrings.add("(");
                        }
                        break;
                    case ')':
                        if (testNextToken)
                        {
                            testNextToken = false;
                            tokenStrings.add(currentToken);
                            tokenStrings.add(")");
                        }
                        else if (addingVariableToken)
                        {
                            addingVariableToken = false;
                            tokenStrings.add(currentToken);
                            tokenStrings.add(")");
                        }
                        else
                        {
                            tokenStrings.add(")");
                        }
                        break;
                    case '+':
                        if (testNextToken)
                        {
                            testNextToken = false;
                            tokenStrings.add(currentToken);
                            tokenStrings.add(Character.toString(tokens[i]));
                        }
                        else if (addingVariableToken)
                        {
                            addingVariableToken = false;
                            tokenStrings.add(currentToken);
                            tokenStrings.add(Character.toString(tokens[i]));
                        }
                        else
                        {
                            tokenStrings.add(Character.toString(tokens[i]));
                        }
                        break;
                    case '-':
                        if (testNextToken)
                        {
                            testNextToken = false;
                            tokenStrings.add(currentToken);
                            tokenStrings.add(Character.toString(tokens[i]));
                        }
                        else if (addingVariableToken)
                        {
                            addingVariableToken = false;
                            tokenStrings.add(currentToken);
                            tokenStrings.add(Character.toString(tokens[i]));
                        }
                        else
                        {
                            tokenStrings.add(Character.toString(tokens[i]));
                        }
                        break;
                    case '*':
                        if (testNextToken)
                        {
                            testNextToken = false;
                            tokenStrings.add(currentToken);
                            tokenStrings.add(Character.toString(tokens[i]));
                        }
                        else if (addingVariableToken)
                        {
                            addingVariableToken = false;
                            tokenStrings.add(currentToken);
                            tokenStrings.add(Character.toString(tokens[i]));
                        }
                        else
                        {
                            tokenStrings.add(Character.toString(tokens[i]));
                        }
                        break;
                    case '/':
                        if (testNextToken)
                        {
                            testNextToken = false;
                            tokenStrings.add(currentToken);
                            tokenStrings.add(Character.toString(tokens[i]));
                        }
                        else if (addingVariableToken)
                        {
                            addingVariableToken = false;
                            tokenStrings.add(currentToken);
                            tokenStrings.add(Character.toString(tokens[i]));
                        }
                        else
                        {
                            tokenStrings.add(Character.toString(tokens[i]));
                        }
                        break;
                    default:
                        if (testNextToken)
                        {
                            testNextToken = false;
                            tokenStrings.add(currentToken);
                            
                            addingVariableToken = true;
                            currentToken = (Character.toString(tokens[i]));
                        }
                        else if (addingVariableToken)
                        {
                            currentToken = currentToken + (Character.toString(tokens[i]));
                        }
                        else
                        {
                            addingVariableToken = true;
                            currentToken = currentToken + (Character.toString(tokens[i]));
                        }
                        break;
                }
                
                // Catch last token if there are no remaining tokens
                if ((i == tokens.length-1) && (testNextToken || addingVariableToken))
                {
                    tokenStrings.add(currentToken);
                }
                
                // Clear current token if necessary
                if (!(testNextToken || addingVariableToken))
                {
                    currentToken = "";
                }
            }
            
            Stack<String> variables = new Stack<>();
            Stack<String> operations = new Stack<>();
            
            // Generate code for variables and operations
            String previousToken = "";
            String arithmeticExpString = "";
            boolean arithmeticExp = false;
            for(String tokenString : tokenStrings)
            {
                // Start arithmetic expression in conditional
                if (!arithmeticExp && (tokenString.equals("+") || tokenString.equals("-") || tokenString.equals("*") || tokenString.equals("/")))
                {
                    arithmeticExp = true;
                    arithmeticExpString = previousToken + tokenString;
                    if (variables.size() > 0)
                    {
                        variables.pop();
                    }
                }
                // Continuing or ending arithmetic expression
                else if (arithmeticExp == true)
                {
                    if (tokenString.equals("(") || tokenString.equals(")") || tokenString.equals(";"))
                    {
                        arithmeticExp = false;
                        if (arithmeticExpString.contains("."))
                        {
                            this.evaluateExprFloat(arithmeticExpString);
                        }
                        else
                        {
                            this.evaluateExprInt(arithmeticExpString);
                        }
                        // Add register of evaluated expression to stack of variables
                        variables.push("$T"+(registerIndex - 1));
                    }
                    else
                    {
                        arithmeticExpString += tokenString;
                    }
                }
                // Add logic operator to stack
                else if (tokenString.contains("=") || tokenString.contains(">") || tokenString.contains("<"))
                {
                    operations.push(tokenString);
                }
                // Add variable to stack
                else if (!tokenString.equals("(") && !tokenString.equals(")"))
                {
                    variables.push(tokenString);
                }
                
                previousToken = tokenString;
            }
            
            // Generate conditional code
            while(!operations.isEmpty() && variables.size() > 1)
            {
                String op = operations.pop();
                if(!op.equals("(") && !op.equals(")"))
                {
                    String varType = "";
                    String varName = variables.pop();
		
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
                    
                    String varType2 = "";
                    String varName2 = variables.pop();
		
                    //Search symbol table for variable type
                    for(Entry<String, SymbolValue> entry : symbols.entrySet())
                    {
                            SymbolValue val = entry.getValue();
                            if(entry.getKey() != null)
                            {
                                    if(entry.getKey().equals(varName2))
                                    {
                                            varType2 = val.getType();
                                    }
                            }
                    }
                    
                    String regPattern = "[a-zA-z]+";
                    Pattern pattern = Pattern.compile(regPattern);
                    Matcher matcher = pattern.matcher(varName);
                    
                    // Variable one temp register storage
                    if(!matcher.find())
                    {
                        String tempRegister = "$T"+registerIndex;
                        if (varType.equals("FLOAT") || varName.contains("."))
                        {
                            irList.addSTOREFNode(varName, tempRegister);
                            registerIndex++;
                        }
                        else
                        {
                            irList.addSTOREINode(varName, tempRegister);
                            registerIndex++;
                        }
                        varName = tempRegister;
                    }
                    
                    // Variable two temp register storage
                    matcher = pattern.matcher(varName2);
                    if(!matcher.find())
                    {
                        String tempRegister = "$T"+registerIndex;
                        if (varType2.equals("FLOAT") || varName2.contains("."))
                        {
                            irList.addSTOREFNode(varName2, tempRegister);
                            registerIndex++;
                        }
                        else
                        {
                            irList.addSTOREINode(varName2, tempRegister);
                            registerIndex++;
                        }
                        varName2 = tempRegister;
                    }
                    
                    // Add conditional logic
                    if (varType.equals("FLOAT") || varType2.equals("FLOAT"))
                    {
                        generateFloatCondLogic(op, varName, varName2);
                    }
                    else
                    {
                        generateIntCondLogic(op, varName, varName2);
                    }
                }
            }

            return true;
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
        
        private String generateFloatCondLogic(String op, String varOne, String varTwo)
        {
            String tempLabel = "label"+(labelIndex+1);
		
		switch(op)
		{
			case ">":
				irList.addLEFNode(varTwo, varOne, tempLabel);
				break;
			case "<":
				irList.addGEFNode(varTwo, varOne, tempLabel);
				break;
			case "=":
				irList.addNEFNode(varTwo, varOne, tempLabel);
				break;
			case "!=":
				irList.addEQFNode(varTwo, varOne, tempLabel);
				break;
                        case ">=":
				irList.addLTFNode(varTwo, varOne, tempLabel);
				break;
			case "<=":
				irList.addGTFNode(varTwo, varOne, tempLabel);	
				break;
		}
		
		return tempLabel;
        }
        
        private String generateIntCondLogic(String op, String varOne, String varTwo)
        {
            String tempLabel = "label"+(labelIndex+1);
		
		switch(op)
		{
			case ">":
				irList.addLEINode(varTwo, varOne, tempLabel);
				break;
			case "<":
				irList.addGEINode(varTwo, varOne, tempLabel);
				break;
			case "=":
				irList.addNEINode(varTwo, varOne, tempLabel);
				break;
			case "!=":
				irList.addEQINode(varTwo, varOne, tempLabel);
				break;
                        case ">=":
				irList.addLTINode(varTwo, varOne, tempLabel);
				break;
			case "<=":
				irList.addGTINode(varTwo, varOne, tempLabel);	
				break;
		}
		
		return tempLabel;
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
