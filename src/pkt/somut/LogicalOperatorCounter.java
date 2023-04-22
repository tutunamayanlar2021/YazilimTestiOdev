/** *
* @author Kader Oral kadriye.oral@ogr.sakarya.edu.tr
* @since 20.04.2023
* <p>
* mantıksal operatör okuma sınıfı
* </p> */

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
