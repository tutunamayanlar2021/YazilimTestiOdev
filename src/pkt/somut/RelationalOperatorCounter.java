package pkt.somut;

import pkt.soyut.OperatorCounter;

public class RelationalOperatorCounter extends OperatorCounter {
	private static final String[] RELATIONAL_OPERATORS = { "<", "<=", ">", ">=", "==", "!=" };

	@Override
	protected String[] getOperators() {
		// TODO Auto-generated method stub
		return RELATIONAL_OPERATORS;
	}

}
