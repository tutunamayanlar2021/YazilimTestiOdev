/** *
* @author Kader Oral kadriye.oral@ogr.sakarya.edu.tr
* @since 20.04.2023
* <p>
* toplam fonksiyon sayısını bulan sınıfın testi
* </p> */
package pkt;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import pkt.somut.TotalFunctionCounter;

class TotalFunctionCounterTest {
	TotalFunctionCounter funcCounter= new TotalFunctionCounter();
	@Test
	void testCount() {
		TotalFunctionCounter funcCounter= new TotalFunctionCounter();
		 String javaCode = "public class TestClass {\n" +
	                "    public void method1() {\n" +
	                "    }\n" +
	                "\n" +
	                "    private int method2(String input) {\n" +
	                "        return 0;\n" +
	                "    }\n" +
	                "}";

	        int expected = 2;

	        int actual = funcCounter.count(javaCode);

	        assertEquals(expected, actual, "TotalFunctionCounter should count the number of functions correctly");
	}
	
	
	@Test
	void testCount2() {
		String javaCode = "public class TestClass {\n" +
	            "    public int add(int a, int b) {\n" +
	            "        int c = a + b;\n" +
	            "        System.out.println(\"a + b = \" + (a + b));\n" +
	            "        return c;\n" +
	            "    }\n" +
	            "}";

	    int expected = 1;

	    int actual = funcCounter.count(javaCode);

	    assertEquals(expected, actual);

	    


		
	}
}
