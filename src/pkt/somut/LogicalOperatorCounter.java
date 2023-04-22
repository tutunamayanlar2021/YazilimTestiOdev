package pkt.somut;

import pkt.soyut.OperatorCounter;

public class LogicalOperatorCounter extends OperatorCounter {
	private static final String[] LOGICAL_OPERATORS = { "&&", "\\|\\|", "(?<!\\p{L})!(?!=)" };

	@Override
	protected String[] getOperators() {
		// TODO Auto-generated method stub
		return LOGICAL_OPERATORS;
	}

}
