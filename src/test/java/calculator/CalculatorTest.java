package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
	Calculator calculator = new Calculator();
	
	@Test
    void addTestWithEmptyValue() { 	
		int testValue = 0;
		int expectedResult= calculator.add("");
		assertEquals(expectedResult, testValue);
    }
	
	@Test
    void addTestWithFirstOperandValue() { 	
		int testValue = 5;
		int expectedResult= calculator.add("5");
		assertEquals(expectedResult, testValue);
    }
	
	@Test
    void addTestWithTwoOperandValue() { 	
		int testValue = 12;
		int expectedResult= calculator.add("5,7");
		assertEquals(expectedResult, testValue);
    }
	@Test
    void addTestWithmultipleOperands() { 	
		int testValue = 20;
		int expectedResult= calculator.add("5,7,3,5");
		assertEquals(expectedResult, testValue);
    }
	@Test
    void addTestWithNewLineBetweenNumbers() { 	
		int testValue = 67;
		int expectedResult= calculator.add("5\n7,7,3");
		assertEquals(expectedResult, testValue);
    }
	
	@Test
    void addTestWithEndingSeparator() { 	
		int testValue = 67;
		int expectedResult= calculator.add("5\n7,7,3,");
		assertEquals(expectedResult, testValue);
    }
	@Test
    void addTestWithDifferentDelimiter() { 	
		int testValue = 3;
		int expectedResult= calculator.add("//;\n1;2");
		assertEquals(expectedResult, testValue);
    }
	@Test
    void addTestWithNegativeNumberException() { 	
		assertThrows(Exception.class,()->{
			calculator.add("-5,-6");
		});
    }
}


