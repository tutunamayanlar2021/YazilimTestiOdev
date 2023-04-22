
/** *
* @author Kader Oral kadriye.oral@ogr.sakarya.edu.tr
* @since 20.04.2023
* <p>
* bütün operatör bulan sınıfların kalıtım aldığı soyut sınıf uygulamnın beyni 
* </p> */
package pkt.soyut;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class OperatorCounter implements IOperatorCounter {
	protected abstract String[] getOperators();

	@Override
	public int count(String javaCode) {
		  String cleanedCode = removeComments(javaCode);
          String codeWithoutStrings = removeUnwantedParts(cleanedCode);
          int count = 0;
          for (String operator :getOperators()) {
              count += countOccurrences(codeWithoutStrings, operator);
           
          }
          return count;
	}

	@Override
	public String removeComments(String javaCode) {
		String patternString = "//.*|(\"(?:\\\\[^\"]|\\\\\"|.)*?\")|(?s)/\\*.*?\\*/";
		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(javaCode);
		StringBuffer sb = new StringBuffer(javaCode.length());
		while (matcher.find()) {
			matcher.appendReplacement(sb, matcher.group(1) != null ? matcher.group(1) : "");
		}
		matcher.appendTail(sb);
		return sb.toString();
	}

	@Override
	public String removeStringLiterals(String javaCode) {
		String patternString = "\"(?:\\\\\"|[^\"])*?\"";
		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(javaCode);
		StringBuffer sb = new StringBuffer(javaCode.length());
		while (matcher.find()) {
			matcher.appendReplacement(sb, "");
		}
		matcher.appendTail(sb);
		return sb.toString();
	}

	@Override
	public int countOccurrences(String javaCode, String operator) {
		Pattern pattern = Pattern.compile(operator);
		Matcher matcher = pattern.matcher(javaCode);
		int count = 0;
		while (matcher.find()) {
			count++;
		}
		return count;
	}
	
	@Override
	public String removeUnwantedParts(String javaCode) {
	    // String literalleri kaldırma
	    String stringWithoutStringLiterals = removeStringLiterals(javaCode);

	    // package ve import ifadelerini kaldırma
	    String stringWithoutPackageImport = stringWithoutStringLiterals.replaceAll("(?m)^(\\s*(import|package)\\s+[^;]+;\\s*)", "");
	    return stringWithoutPackageImport;
	}

	

}
