
package pkt.somut;

import pkt.soyut.OperatorCounter;

public class NumericOperatorCounter extends OperatorCounter {
	 private static final String[] NUMERIC_OPERATORS = {
			"\\+{1,2}", "\\-", "\\-\\-", "\\*", "/", "%", "\\\\&\\\\=?", "\\|(?!\\|)", "\\^","(?<=^|[^!])=(?!=)","\\+=", "\\-=", "/=", "\\*=", "%=", "&=(?![&])", "\\|=(?!\\|)", "\\^="
		    };

	@Override
	protected String[] getOperators() {
		// TODO Auto-generated method stub
		return NUMERIC_OPERATORS;
	}


	

}
