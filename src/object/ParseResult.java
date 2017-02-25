package object;

public class ParseResult extends ObjectTemplate{
	private boolean accepted;
	private final String acceptedString = "Accepted";
	private final String rejectedString = "Not accepted";
	
	@Override
	public void printData() {
		if(accepted)
			System.out.println(acceptedString);
		else
			System.out.println(rejectedString);
	}

}
