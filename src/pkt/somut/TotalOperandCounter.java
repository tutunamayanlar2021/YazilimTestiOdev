
/** *
* @author Kader Oral kadriye.oral@ogr.sakarya.edu.tr
* @since 20.04.2023
* <p>
* Toplam operand sayısını bulan sınıf
* </p> */

package pkt.somut;

import pkt.soyut.OperatorCounter;

public class TotalOperandCounter extends OperatorCounter {
    private static final String[] OPERAND_PATTERN = {
    		  "(?<!\\.|\\w)(?!(System\\.out\\.|static\\s+void\\s+main|String\\[\\]|args)\\b|\\w+\\s*\\(|\\s*new\\s)\\p{L}[_\\p{L}\\p{N}]*\\b(?!\\s*(=|\\(|\\)|\\.)\\s*)"};

    @Override
    protected String[] getOperators() {
        return OPERAND_PATTERN;
    }
}
