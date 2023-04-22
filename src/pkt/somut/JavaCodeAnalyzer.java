
package pkt.somut;

import pkt.soyut.IFileRead;
import pkt.soyut.IOperatorCounter;

public class JavaCodeAnalyzer {

	private String content;
	private IOperatorCounter numericOperatorCounter;
	private IOperatorCounter relationalOperatorCounter;
	private IOperatorCounter logicalOperatorCounter;
	private IOperatorCounter functionCounter;
	private IOperatorCounter operandCounter;
	private IOperatorCounter binaryOperatorCounter;
	private IOperatorCounter singleOperatorCounter;
	private IFileRead fileReader;

	public JavaCodeAnalyzer() {

		numericOperatorCounter = new NumericOperatorCounter();
		relationalOperatorCounter = new RelationalOperatorCounter();
		logicalOperatorCounter = new LogicalOperatorCounter();
		functionCounter = new TotalFunctionCounter();
		operandCounter = new TotalOperandCounter();
		binaryOperatorCounter = new BinaryOperatorCounter();
		singleOperatorCounter = new SingleOperatorCounter();
		fileReader =new FileRead();
	}

	public void getResult(String fileName) {
		content = fileReader.readFile(fileName);

		System.out.println("Sayısal Operatör Sayısı: " + getNumericOperatorCount());

		System.out.println("İlişkisel Operatör Sayısı: " + getRelationalOperatorCount());

		System.out.println("Mantıksal Operatör Sayısı: " + getLogicalOperatorCount());

		System.out.println("Toplam Fonksiyon Sayısı: " + getFunctionCount());

		System.out.println("Toplam Operand Sayısı: " + getOperandCount());

		System.out.println("İkili Operatör Sayısı: " + getBinaryOperatorCount());

		System.out.println("Tekli Operatör Sayısı: " + getSingleOperatorCount());

	}

	public int getNumericOperatorCount() {
		return numericOperatorCounter.count(content);
	}

	public int getRelationalOperatorCount() {
		return relationalOperatorCounter.count(content);
	}

	public int getLogicalOperatorCount() {
		return logicalOperatorCounter.count(content);
	}

	public int getFunctionCount() {
		return functionCounter.count(content);
	}

	public int getOperandCount() {
		return operandCounter.count(content);
	}

	public int getBinaryOperatorCount() {
		return binaryOperatorCounter.count(content);
	}

	public int getSingleOperatorCount() {
		return singleOperatorCounter.count(content);
	}



}
