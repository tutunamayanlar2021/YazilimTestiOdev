package pkt.somut;

import pkt.soyut.OperatorCounter;

public class TotalFunctionCounter extends  OperatorCounter {
	private static final String [] FUNCTION_PATTERN = { "(public|protected|private|static|\\s) +[\\w\\<\\>\\[\\]]+\\s+([a-z][A-Za-z0-9_]*) *\\("};
  
	@Override
	protected String[] getOperators() {
		// TODO Auto-generated method stub
		return FUNCTION_PATTERN;
	}
}
