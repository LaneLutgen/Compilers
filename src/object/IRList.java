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

public class IRList {

	public IRNode first;
	public IRNode cur;
	
	public IRList()
	{
		first = null;
	}
	
	public void insert(IRNode node)
	{
		if(first == null)
		{
			first = node;
			cur = first;
		}
		else
		{
			cur.next = node;
			cur = node;
		}
	}
	
	public void addLABELNode(String name)
	{
		IRNode node = new IRNode("LABEL", null, null, name);
		this.insert(node);
	}
	
	public void addLINKNode()
	{
		IRNode node = new IRNode("LINK", null, null, null);
		this.insert(node);
	}
	
	public void addSTOREFNode(String input, String output)
	{
		IRNode node = new IRNode("STOREF", input, null, output);
		this.insert(node);
	}
	
	public void addSTOREINode(String input, String output)
	{
		IRNode node = new IRNode("STOREI", input, null, output);
		this.insert(node);
	}
	
	public void addADDFNode(String opOne, String opTwo, String result)
	{
		IRNode node = new IRNode("ADDF", opOne, opTwo, result);
		this.insert(node);
	}
	
	public void addSUBFNode(String opOne, String opTwo, String result)
	{
		IRNode node = new IRNode("SUBF", opOne, opTwo, result);
		this.insert(node);
	}
	
	public void addMULTFNode(String opOne, String opTwo, String result)
	{
		IRNode node = new IRNode("MULTF", opOne, opTwo, result);
		this.insert(node);
	}
	
	public void addDIVFNode(String opOne, String opTwo, String result)
	{
		IRNode node = new IRNode("DIVF", opOne, opTwo, result);
		this.insert(node);
	}
	
	public void addADDINode(String opOne, String opTwo, String result)
	{
		IRNode node = new IRNode("ADDI", opOne, opTwo, result);
		this.insert(node);
	}
	
	public void addSUBINode(String opOne, String opTwo, String result)
	{
		IRNode node = new IRNode("SUBI", opOne, opTwo, result);
		this.insert(node);
	}
	
	public void addMULTINode(String opOne, String opTwo, String result)
	{
		IRNode node = new IRNode("MULTI", opOne, opTwo, result);
		this.insert(node);
	}
	
	public void addDIVINode(String opOne, String opTwo, String result)
	{
		IRNode node = new IRNode("DIVI", opOne, opTwo, result);
		this.insert(node);
	}
}
