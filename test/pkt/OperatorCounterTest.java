package pkt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import pkt.soyut.OperatorCounter;

class OperatorCounterTest {
	  private static class TestOperatorCounter extends OperatorCounter {
	        @Override
	        protected String[] getOperators() {
	            return new String[]{"\\+", "\\-", "\\*", "\\/", "\\%"};
	        }
	    }

	    private TestOperatorCounter operatorCounter;

	    @BeforeEach
	    public void setUp() {
	        operatorCounter = Mockito.spy(new TestOperatorCounter());
	    }

	    @Test
	    public void testCount() {
	        String javaCode = "int a = 5 + 6;\n" +
	                          "int b = a * 2;\n" +
	                          "int c = b / 3;\n" +
	                          "int d = a - c;\n" +
	                          "int e = d % 5;\n";
	        int count = operatorCounter.count(javaCode);
	        assertEquals(5, count);
	    }
	    
	    @Test
	    public void testRemoveComments() {
	        String javaCode = "int a = 5; // This is a single line comment\n" +
	                          "/* This is a\n" +
	                          "   multi-line comment */\n" +
	                          "int b = 6;";
	        String result = operatorCounter.removeComments(javaCode);
	        String expected = "int a = 5; \n" +
	                          "\n" +
	                          "int b = 6;";
	        assertEquals(expected, result);
	    }
	    
	    @Test
	    public void testRemoveStringLiterals() {
	        String javaCode = "String a = \"This is a string literal\";\n" +
	                          "String b = \"Another \\\"string\\\" literal\";";
	        String result = operatorCounter.removeStringLiterals(javaCode);
	        String expected = "String a = ;\n" +
	                          "String b = ;";
	        assertEquals(expected, result);
	    }
	    @Test
	    public void testCountOccurrences() {
	        String javaCode = "int a = 1 + 2 + 3;\n" +
	                          "int b = a + 4;";
	        int count = operatorCounter.countOccurrences(javaCode, "\\+");
	        assertEquals(3, count);
	    }

	    @Test
	    public void testRemoveUnwantedParts() {
	        String javaCode = "package com.example;\n" +
	                          "import java.util.*;\n" +
	                          "String a = \"Remove this string\";\n" +
	                          "int b = 5;";
	        String result = operatorCounter.removeUnwantedParts(javaCode);
	        String expected ="String a = ;\n" +
	                          "int b = 5;";
	        System.out.println(result);
	        assertEquals(expected, result);
	    }
}
