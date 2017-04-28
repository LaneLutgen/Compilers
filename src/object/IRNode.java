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

public class IRNode extends ObjectTemplate{

	private String opCode;
	private String firstOp;
	private String secondOp;
	private String result;
	
	//Pointer to the next node in the list
	public IRNode next;
	
	//Only used on branch type instructions
	public IRNode target;
	
	public IRNode(String opCode, String firstOp, String secondOp, String result)
	{
		this.opCode = opCode;
		this.firstOp = firstOp;
		this.secondOp = secondOp;
		this.result = result;
	}
	
	@Override
	public void printData() {
		// TODO Auto-generated method stub
		if(firstOp == null && secondOp == null && result == null)
		{
			System.out.println(opCode);
		}
		else if(firstOp == null && secondOp == null)
		{
			System.out.println(opCode+" "+result);
		}
		else if(secondOp == null)
		{
			System.out.println(opCode+" "+firstOp+" "+result);
		}
		else
		{
			System.out.println(opCode+" "+firstOp+" "+secondOp+" "+result);
		}
	}

}
