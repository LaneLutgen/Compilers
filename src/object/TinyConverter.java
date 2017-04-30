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
		ArrayList<String> codes = new ArrayList<String>();
		
		switch(node.opCode)
		{
			case "LABEL":
				codes.add("label "+node.result);
				break;
			case "STOREF":
			case "STOREI":
				
				String op = node.firstOp;
				String result = node.result;
				
				//Create seperate registers
				if(!op.contains("$T") && !result.contains("$T"))
				{
					String temp = result;
					String reg = "r"+registerIndex;
					codes.add("move "+op+" "+reg);
					codes.add("move "+reg+" "+temp);
					registerIndex++;
					
					hashTable.put(temp, reg);
				}
				else
				{
					if(op.contains("$T"))
					{
						op = "r"+registerIndex;
						registerIndex++;
					}
					
					if(result.contains("$T"))
					{
						result = "r"+registerIndex;
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
				
				opOne = node.secondOp;
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
				
				opOne = node.secondOp;
				codes.add("addr "+opOne+" "+opTwo);
				registerIndex++;
				opTwo = "r"+registerIndex;
				codes.add("move "+opOne+" "+opTwo);
				registerIndex++;
				
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
				
				opOne = node.secondOp;
				codes.add("subi "+opOne+" "+opTwo);
				registerIndex++;
				opTwo = "r"+registerIndex;
				codes.add("move "+opOne+" "+opTwo);
				registerIndex++;
				
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
				
				opOne = node.secondOp;
				codes.add("subr "+opOne+" "+opTwo);
				registerIndex++;
				opTwo = "r"+registerIndex;
				codes.add("move "+opOne+" "+opTwo);
				registerIndex++;
				
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
				
				opOne = node.secondOp;
				codes.add("muli "+opOne+" "+opTwo);
				registerIndex++;
				opTwo = "r"+registerIndex;
				codes.add("move "+opOne+" "+opTwo);
				registerIndex++;
				
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
					opOne = node.firstOp;
					opTwo = "r"+registerIndex;
					codes.add("move "+opOne+" "+opTwo);
				}
				
				opOne = node.secondOp;
				codes.add("mulr "+opOne+" "+opTwo);
				registerIndex++;
				opTwo = "r"+registerIndex;
				codes.add("move "+opOne+" "+opTwo);
				registerIndex++;
				
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
				
				opOne = node.secondOp;
				codes.add("divi "+opOne+" "+opTwo);
				registerIndex++;
				opTwo = "r"+registerIndex;
				codes.add("move "+opOne+" "+opTwo);
				registerIndex++;
				
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
				}
				
				opOne = node.secondOp;
				codes.add("divr "+opOne+" "+opTwo);
				registerIndex++;
				opTwo = "r"+registerIndex;
				codes.add("move "+opOne+" "+opTwo);
				registerIndex++;
				
				hashTable.put(opOne, opTwo);
				break;
			case "GTI":
				break;
			case "GTF":
				break;
			case "GEI":
				break;
			case "GEF":
				break;
			case "LTI":
				break;
			case "LTF":
				break;
			case "LEI":
				break;
			case "LEF":
				break;
			case "NEI":
				break;
			case "NEF":
				break;
			case "EQF":
				break;
			case "EQI":
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
				break;
			case "READI":
				break;
			case "RET":
				codes.add("sys halt");
				break;
		}
		
		return codes;
	}
	
}
