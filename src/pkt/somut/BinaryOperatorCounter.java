/** *
* @author Kader Oral kadriye.oral@ogr.sakarya.edu.tr
* @since 20.04.2023
* <p>
* İklii operatörler sınıfı
* </p> */

package pkt.somut;

import pkt.soyut.OperatorCounter;

public class BinaryOperatorCounter  extends OperatorCounter{
	private static final String[] BINARY_OPERATORS = {
			"((?<!\\-)(\\s)*\\-(?!\\-))", // -- engellenir ve - önünde boşluk olabilir veya olmayabilir
			"((?<!\\+)(\\s)*\\+(?!\\+))" , // ++ engellenir ve + önünde boşluk olabilir veya olmayabilir

			"\\*",// * işaretini al
		    "\\/",// / işaretini al
		    "\\%",// % al 
		    "&&",// &&
		    "\\|\\|",// ||
		    "<(?!<|=)",// < işareti = olmadan 
		    "<=",
		    ">(?!>|=)", //> iş = olmadan 
		    ">=",
		    "==",
		    "!(\\s)*=(?!\\=)",
		    "&",//&
		    "\\|(?!\\|)(=?)",// | ve |=
		    "\\^(?!\\^)(=?)",// ^ ve ^= 
		    "<<",
		    ">>",
		    "(?<=[a-zA-Z_$][a-zA-Z_$0-9]*)\\s*=\\s*(?!=)"//=
		};




	@Override
	protected String[] getOperators() {
		// TODO Auto-generated method stub
		return BINARY_OPERATORS;
	}

}
