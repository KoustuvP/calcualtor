package calculator;

public class Calculator {

	public int add(String numbers) {
		if (numbers.isBlank())
			return 0;
		return Integer.parseInt(numbers);
	}

}
