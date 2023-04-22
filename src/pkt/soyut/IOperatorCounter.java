package pkt.soyut;

public interface IOperatorCounter {
	int count(String javaCode);

	String removeComments(String javaCode);

	String removeStringLiterals(String javaCode);

	int countOccurrences(String javaCode, String operator);
	String removeUnwantedParts(String javaCode) ;

}
