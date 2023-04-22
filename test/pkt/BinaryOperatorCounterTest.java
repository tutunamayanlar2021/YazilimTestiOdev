package pkt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;

import pkt.somut.BinaryOperatorCounter;

class BinaryOperatorCounterTest {
	 BinaryOperatorCounter counter = new BinaryOperatorCounter();
	@Test
	void test() {

		  BinaryOperatorCounter counter = new BinaryOperatorCounter();
		    Faker faker = new Faker();
		    List<String> singleOperators = Arrays.asList(
		    		"++", "--","!"
	                
	        );
		    List<String> binaryOperators = Arrays.asList(
		    		 "+=", "-=", "*=", "/=", "%=", "&=", "|=", "^=", "<=", ">=", "==", "!=", "&&", "||","<",">","+","-","*","/","%","&","%","|","^"
	                
	        );
		   int num= faker.number().numberBetween(0,15);
	        Random random = new Random();
	        System.out.println("Beklenen sayi: "+num);
	       // String randomOperator = singleOperators.get(random.nextInt(singleOperators.size()));
	       // System.out.println("Randomly selected single operator: " + randomOperator);
	    
	     
	        ArrayList<String> myList = new ArrayList<String>();
	        for (int i = 0; i < num; i++) {
	          
	        	String randomOperator = singleOperators.get(random.nextInt(singleOperators.size()));
	           //System.out.println((i + 1) + ". " + randomOperator);
	           myList.add(randomOperator);
	        }
	        for (int i = 0; i < num; i++) {
	          
	        	String randomOperator= binaryOperators.get(random.nextInt(binaryOperators.size()));
	             //  System.out.println((i + 1) + ". " + randomOperator);
	              
	               myList.add(randomOperator);
	              
	        }
	        String code = "";
	        for (int i = 0; i < myList.size(); i++) {
	        	code += myList.get(i) + " ";
	        }
	     
	        System.out.println("gerçek code: "+code);
	        int expectedCount = num;
	        int actualCount = counter.count(code);
	       System.out.println("Olan sayi: "+actualCount);
	        Assertions.assertEquals(expectedCount, actualCount);
	        
	}
	
   
	

}
