package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}


