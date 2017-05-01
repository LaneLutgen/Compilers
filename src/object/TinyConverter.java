package object;

import java.util.ArrayList;
import java.util.HashMap;

public class TinyConverter {
	
	public static int registerIndex = 0;
	public static HashMap<String, String> hashTable = new HashMap<String, String>();
	
	public static ArrayList<String> convert(IRNode node)
	{
		String opOne = null;
		String opTwo = null;
		String op = null;
		String result = null;
		String temp = null;
		ArrayList<String> codes = new ArrayList<String>();
		
		//I think this switch statement is worse...
		switch(node.opCode)
		{
			case "LABEL":
				codes.add("label "+node.result);
				break;
			case "STOREF":
			case "STOREI":
				op = node.firstOp;
				result = node.result;
				
				//Create seperate registers
				if(!op.contains("$T") && !result.contains("$T"))
				{
					temp = result;
					String reg = "r"+registerIndex;
					codes.add("move "+op+" "+reg);
					codes.add("move "+reg+" "+temp);
					registerIndex++;
					
					if(temp.contains("$T"))
						hashTable.put(temp, reg);
				}
				else
				{
					if(op.contains("$T"))
					{
						registerIndex--;
						op = "r"+registerIndex;
						registerIndex++;
					}
					
					if(result.contains("$T"))
					{
						result = "r"+registerIndex;
						registerIndex++;
					}
					codes.add("move "+op+" "+result);
				}
				break;
			case "ADDI":
				opOne = null;
				opTwo = null;
				
				if(hashTable.containsKey(node.firstOp))
				{
					opTwo = hashTable.get(node.firstOp);
				}
				else
				{
					opOne = node.firstOp;
					opTwo = "r"+registerIndex;
					codes.add("move "+opOne+" "+opTwo);
				}
				
				if(hashTable.containsKey(node.secondOp))
				{
					opOne = hashTable.get(node.secondOp);
				}
				else
				{
					opOne = node.secondOp;
				}
				
				codes.add("addi "+opOne+" "+opTwo);
				registerIndex++;
				opTwo = "r"+registerIndex;
				codes.add("move "+opOne+" "+opTwo);
				registerIndex++;
				
				hashTable.put(opOne, opTwo);
				break;
			case "ADDF":
				opOne = null;
				opTwo = null;
				
				if(hashTable.containsKey(node.firstOp))
				{
					opTwo = hashTable.get(node.firstOp);
				}
				else
				{
					opOne = node.firstOp;
					opTwo = "r"+registerIndex;
					codes.add("move "+opOne+" "+opTwo);
				}
				
				if(hashTable.containsKey(node.secondOp))
				{
					opOne = hashTable.get(node.secondOp);
				}
				else
				{
					opOne = node.secondOp;
				}
					
				codes.add("addr "+opOne+" "+opTwo);
				registerIndex++;
				opTwo = "r"+registerIndex;
				
				hashTable.put(opOne, opTwo);
				break;
			case "SUBI":
				opOne = null;
				opTwo = null;
				
				if(hashTable.containsKey(node.firstOp))
				{
					opTwo = hashTable.get(node.firstOp);
				}
				else
				{
					opOne = node.firstOp;
					opTwo = "r"+registerIndex;
					codes.add("move "+opOne+" "+opTwo);
				}
				
				if(hashTable.containsKey(node.secondOp))
				{
					opOne = hashTable.get(node.secondOp);
				}
				else
				{
					opOne = node.secondOp;
				}
					
				if(opOne.contains("$T"))
					opOne = "r"+opOne.charAt(2);
				
				codes.add("subi "+opOne+" "+opTwo);
				registerIndex++;
				opTwo = "r"+registerIndex;
				
				hashTable.put(opOne, opTwo);
				break;
			case "SUBF":
				opOne = null;
				opTwo = null;
				
				if(hashTable.containsKey(node.firstOp))
				{
					opTwo = hashTable.get(node.firstOp);
				}
				else
				{
					opOne = node.firstOp;
					opTwo = "r"+registerIndex;
					codes.add("move "+opOne+" "+opTwo);
				}
				
				if(hashTable.containsKey(node.secondOp))
				{
					opOne = hashTable.get(node.secondOp);
				}
				else
				{
					opOne = node.secondOp;
				}
				
				codes.add("subr "+opOne+" "+opTwo);
				registerIndex++;
				opTwo = "r"+registerIndex;
				
				hashTable.put(opOne, opTwo);
				break;
			case "MULTI":
				opOne = null;
				opTwo = null;
				
				if(hashTable.containsKey(node.firstOp))
				{
					opTwo = hashTable.get(node.firstOp);
				}
				else
				{
					opOne = node.firstOp;
					opTwo = "r"+registerIndex;
					codes.add("move "+opOne+" "+opTwo);
				}
				
				if(hashTable.containsKey(node.secondOp))
				{
					opOne = hashTable.get(node.secondOp);
				}
				else
				{
					opOne = node.secondOp;
				}
				codes.add("muli "+opOne+" "+opTwo);
				registerIndex++;
				opTwo = "r"+registerIndex;
				
				hashTable.put(opOne, opTwo);
				break;
			case "MULTF":
				opOne = null;
				opTwo = null;
				
				if(hashTable.containsKey(node.firstOp))
				{
					opTwo = hashTable.get(node.firstOp);
				}
				else
				{
					if(node.firstOp.contains("$T"))
						opOne = "r"+node.firstOp.charAt(2);
					else
						opOne = node.firstOp;
					opTwo = "r"+registerIndex;
					codes.add("move "+opOne+" "+opTwo);
				}
				
				if(hashTable.containsKey(node.secondOp))
				{
					opOne = hashTable.get(node.secondOp);
				}
				else
				{
					opOne = node.secondOp;
				}
				
				if(opOne.contains("$T"))
					opOne = "r"+opOne.charAt(2);
				
				codes.add("mulr "+opOne+" "+opTwo);
				registerIndex++;
				opTwo = "r"+registerIndex;
				
				hashTable.put(opOne, opTwo);
				break;
			case "DIVI":
				opOne = null;
				opTwo = null;
				
				if(hashTable.containsKey(node.firstOp))
				{
					opTwo = hashTable.get(node.firstOp);
				}
				else
				{
					opOne = node.firstOp;
					opTwo = "r"+registerIndex;
					codes.add("move "+opOne+" "+opTwo);
				}
				
				if(hashTable.containsKey(node.secondOp))
				{
					opOne = hashTable.get(node.secondOp);
				}
				else
				{
					opOne = node.secondOp;
				}
				codes.add("divi "+opOne+" "+opTwo);
				registerIndex++;
				opTwo = "r"+registerIndex;
				
				hashTable.put(opOne, opTwo);
				break;
			case "DIVF":
				opOne = null;
				opTwo = null;
				
				if(hashTable.containsKey(node.firstOp))
				{
					opTwo = hashTable.get(node.firstOp);
				}
				else
				{
					opOne = node.firstOp;
					opTwo = "r"+registerIndex;
					codes.add("move "+opOne+" "+opTwo);
					hashTable.put(opOne, opTwo);
					hashTable.put(node.result, opTwo);
				}
				
				if(hashTable.containsKey(node.secondOp))
				{
					opOne = hashTable.get(node.secondOp);
				}
				else
				{
					opOne = node.secondOp;
				}
				codes.add("divr "+opOne+" "+opTwo);
				registerIndex++;
				opTwo = "r"+registerIndex;
				codes.add("move "+opOne+" "+opTwo);
				
				hashTable.put(opOne, opTwo);
				break;
			case "GTI":
				opOne = node.firstOp;
				opTwo = node.secondOp;
				if(opOne.contains("$T"))
				{
					opOne = "r"+registerIndex;
					registerIndex++;
				}
				
				if(opTwo.contains("$T"))
				{
					opTwo = "r"+registerIndex;
					registerIndex++;
				}
				
				codes.add("cmpi "+opOne+" "+opTwo);
				codes.add("jgt "+node.result);
				break;
			case "GTF":
				opOne = node.firstOp;
				opTwo = node.secondOp;
				if(opOne.contains("$T"))
				{
					opOne = "r"+registerIndex;
					registerIndex++;
				}
				
				if(opTwo.contains("$T"))
				{
					opTwo = "r"+registerIndex;
					registerIndex++;
				}
				
				codes.add("cmpr "+opOne+" "+opTwo);
				codes.add("jgt "+node.result);
				break;
			case "GEI":
				opOne = node.firstOp;
				opTwo = node.secondOp;
				if(opOne.contains("$T"))
				{
					opOne = "r"+registerIndex;
					registerIndex++;
				}
				
				if(opTwo.contains("$T"))
				{
					opTwo = "r"+registerIndex;
					registerIndex++;
				}
				
				codes.add("cmpi "+opOne+" "+opTwo);
				codes.add("jge "+node.result);
				break;
			case "GEF":
				opOne = node.firstOp;
				opTwo = node.secondOp;
				if(opOne.contains("$T"))
				{
					opOne = "r"+registerIndex;
					registerIndex++;
				}
				
				if(opTwo.contains("$T"))
				{
					opTwo = "r"+registerIndex;
					registerIndex++;
				}
				
				codes.add("cmpr "+opOne+" "+opTwo);
				codes.add("jge "+node.result);
				break;
			case "LTI":
				opOne = node.firstOp;
				opTwo = node.secondOp;
				if(opOne.contains("$T"))
				{
					opOne = "r"+registerIndex;
					registerIndex++;
				}
				
				if(opTwo.contains("$T"))
				{
					opTwo = "r"+registerIndex;
					registerIndex++;
				}
				
				codes.add("cmpi "+opOne+" "+opTwo);
				codes.add("jlt "+node.result);
				break;
			case "LTF":
				opOne = node.firstOp;
				opTwo = node.secondOp;
				if(opOne.contains("$T"))
				{
					opOne = "r"+registerIndex;
					registerIndex++;
				}
				
				if(opTwo.contains("$T"))
				{
					opTwo = "r"+registerIndex;
					registerIndex++;
				}
				
				codes.add("cmpr "+opOne+" "+opTwo);
				codes.add("jlt "+node.result);
				break;
			case "LEI":
				opOne = node.firstOp;
				opTwo = node.secondOp;
				if(opOne.contains("$T"))
				{
					opOne = "r"+registerIndex;
					registerIndex++;
				}
				
				if(opTwo.contains("$T"))
				{
					opTwo = "r"+registerIndex;
					registerIndex++;
				}
				
				codes.add("cmpi "+opOne+" "+opTwo);
				codes.add("jle "+node.result);
				break;
			case "LEF":
				opOne = node.firstOp;
				opTwo = node.secondOp;
				if(opOne.contains("$T"))
				{
					opOne = "r"+registerIndex;
					registerIndex++;
				}
				
				if(opTwo.contains("$T"))
				{
					opTwo = "r"+registerIndex;
					registerIndex++;
				}
				
				codes.add("cmpr "+opOne+" "+opTwo);
				codes.add("jle "+node.result);
				break;
			case "NEI":
				opOne = node.firstOp;
				opTwo = node.secondOp;
				if(opOne.contains("$T"))
				{
					opOne = "r"+registerIndex;
					registerIndex++;
				}
				
				if(opTwo.contains("$T"))
				{
					opTwo = "r"+registerIndex;
					registerIndex++;
				}
				
				codes.add("cmpi "+opOne+" "+opTwo);
				codes.add("jne "+node.result);
				break;
			case "NEF":
				opOne = node.firstOp;
				opTwo = node.secondOp;
				if(opOne.contains("$T"))
				{
					opOne = "r"+registerIndex;
					registerIndex++;
				}
				
				if(opTwo.contains("$T"))
				{
					opTwo = "r"+registerIndex;
					registerIndex++;
				}
				
				codes.add("cmpr "+opOne+" "+opTwo);
				codes.add("jne "+node.result);
				break;
			case "EQI":
				opOne = node.firstOp;
				opTwo = node.secondOp;
				if(opOne.contains("$T"))
				{
					registerIndex--;
					opOne = "r"+registerIndex;
					registerIndex++;
				}
				
				if(opTwo.contains("$T"))
				{
					registerIndex--;
					opTwo = "r"+registerIndex;
					registerIndex++;
				}
				
				codes.add("cmpi "+opOne+" "+opTwo);
				codes.add("jeq "+node.result);
				break;
			case "EQF":
				opOne = node.firstOp;
				opTwo = node.secondOp;
				if(opOne.contains("$T"))
				{
					opOne = "r"+registerIndex;
					registerIndex++;
				}
				
				if(opTwo.contains("$T"))
				{
					opTwo = "r"+registerIndex;
					registerIndex++;
				}
				
				codes.add("cmpr "+opOne+" "+opTwo);
				codes.add("jeq "+node.result);
				break;
			case "JUMP":
				codes.add("jmp "+node.result);
				break;
			case "WRITEF":
				codes.add("sys writer "+node.result);
				break;
			case "WRITEI":
				codes.add("sys writei "+node.result);
				break;
			case "WRITES":
				codes.add("sys writes newline");
				break;
			case "READF":
				codes.add("sys readr "+node.result);
				break;
			case "READI":
				codes.add("sys readi "+node.result);
				break;
			case "RET":
				codes.add("sys halt");
				break;
		}
		
		return codes;
	}
	
}
