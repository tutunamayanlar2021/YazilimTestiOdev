
/** *
* @author Kader Oral kadriye.oral@ogr.sakarya.edu.tr
* @since 20.04.2023
* <p>
* OperatorCounter abstruct sınıfın kullandığı arayüz 
* </p> */

package pkt.soyut;

public interface IOperatorCounter {
	int count(String javaCode);

	String removeComments(String javaCode);

	String removeStringLiterals(String javaCode);

	int countOccurrences(String javaCode, String operator);
	String removeUnwantedParts(String javaCode) ;

}
