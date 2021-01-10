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
}


