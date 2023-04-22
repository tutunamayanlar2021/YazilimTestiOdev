package pkt;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.junit.jupiter.api.Assertions;
import com.github.javafaker.Faker;

import pkt.somut.SingleOperatorCounter;

import static org.mockito.Mockito.spy;

import java.util.ArrayList;

class SingleOperatorCounterTest {
	SingleOperatorCounter counter = new SingleOperatorCounter();

	@Test
	void testCount1() {

		String code = "int a = 5 + 3; // this is a comment\n" + "String str = \"hello world\";\n"
				+ "boolean b =(a > 0) && (a < 10);\n" + "if (!b) {\n"
				+ "    System.out.println(\"a is not between 0 and 10\");\n" + "}";
		int expectedCount = 1;
		int actualCount = counter.count(code);
		Assertions.assertEquals(expectedCount, actualCount);
	}

	@Test
	public void testCount2() {
		
		SingleOperatorCounter counter = new SingleOperatorCounter();
		String code = "int i = 0;\ni++;\n--i;";

		int count = counter.count(code);

		
		Assertions.assertEquals(2, count);
	}

	@Test
	public void testCount3() {
		
		SingleOperatorCounter counter = new SingleOperatorCounter();
		String code = "int i = 0;\nfor (int j = 0; j < 10; j++) {\n    i++;\n}\nwhile (i > 0) {\n    --i;\n}\ni++;";

	
		int count = counter.count(code);

		
		Assertions.assertEquals(4, count);

	}

	@Test
	void testFaker() {
		/*
		 * Bu teste hem tekli hem de ikiliden random sayıda operatör türetiyoruz ve
		 * bunları bir listeye attıktan sonra bu listedeki tekli operatörleri doğru
		 * şekilde programın sayıp saymadığını kontrol ediyorum.
		 */

		Faker faker = new Faker();
		List<String> singleOperators = Arrays.asList("++", "--","!"

		);
		List<String> binaryOperators = Arrays.asList("+=", "-=", "*=", "/=", "%=", "&=", "|=", "^=", "<=", ">=", "==",
				"!=", "&&", "||"

		);
		int num = faker.number().numberBetween(0, 15);
		Random random = new Random();

		System.out.println("rastegele sayi: " + num);
		ArrayList<String> myList = new ArrayList<String>();
		for (int i = 0; i < num; i++) {

			String randomOperator = singleOperators.get(random.nextInt(singleOperators.size()));
			System.out.println((i + 1) + ". " + randomOperator);
			myList.add(randomOperator);
		}
		for (int i = 0; i < num; i++) {

			String randomOperator = binaryOperators.get(random.nextInt(binaryOperators.size()));
			System.out.println((i + 1) + ". " + randomOperator);

			myList.add(randomOperator);

		}
		String code = "";
		for (int i = 0; i < myList.size(); i++) {
			code += myList.get(i) + " ";
		}

		System.out.println("gerçek code: " + code);
		int expectedCount = num;
		int actualCount = counter.count(code);
		System.out.println("gerçek sayi: " + actualCount);
		Assertions.assertEquals(expectedCount, actualCount);

	}

	@BeforeEach
	void setUp() {
		counter = spy(new SingleOperatorCounter());
	}

	@Test
	void testCountWithMock() {
		String javaCode = "public class TestClass {\n" + "    public int add(int a, int b) {\n"
				+ "        int c = a + b;\n" + "        System.out.println(\"a + b = \" + (a + b));\n"
				+ "        return c;\n" + "    }\n" +

				"c++;" + "}";

		int expected = 1;

		// Spy kullanarak "removeComments" ve "removeUnwantedParts" metotlarını gerçek
		// halleriyle çağırma
		doCallRealMethod().when(counter).removeComments(anyString());
		doCallRealMethod().when(counter).removeUnwantedParts(anyString());

		int actual = counter.count(javaCode);

		assertEquals(expected, actual);

		// Metotların gerçekten çağrıldığını doğrulama
		verify(counter, times(1)).removeComments(javaCode);
		verify(counter, times(1)).removeUnwantedParts(anyString());
	}
	

	
	

}
