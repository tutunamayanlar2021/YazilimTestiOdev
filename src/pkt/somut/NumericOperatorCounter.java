/** *
* @author Kader Oral kadriye.oral@ogr.sakarya.edu.tr
* @since 20.04.2023
* <p>
* Sayısal operatör sınıfı
* </p> */

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
