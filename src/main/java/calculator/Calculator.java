package calculator;

public class Calculator {

	public int add(String numbers) {
		if (numbers.isBlank())
			return 0;
		else {
			int separatorIndex = numbers.indexOf(",");
			if (separatorIndex > 0)
				return Integer.parseInt(numbers.substring(0, separatorIndex))
						+ Integer.parseInt(numbers.substring(separatorIndex + 1, numbers.length()));
			else
				return Integer.parseInt(numbers);
		}
	}

}
