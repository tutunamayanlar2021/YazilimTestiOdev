/** *
* @author Kader Oral kadriye.oral@ogr.sakarya.edu.tr
* @since 20.04.2023
* <p>
* ilişkisel operatör sınıfı
* </p> */

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
