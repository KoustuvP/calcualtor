package calculator;

import java.util.ArrayList;

import com.sun.tools.javac.util.List;

public class Calculator {

	public int add(String numbers) throws Exception {
		if (numbers.isBlank())
			return 0;
		else {
			char delemiter = ',';
			if (numbers.charAt(0) == '/' && numbers.charAt(1) == '/') {
				delemiter = numbers.charAt(2);
				numbers = numbers.substring(4);
			}
			numbers = numbers.replace("\n", "");

			int separatorIndex = numbers.indexOf(delemiter);
			if (separatorIndex > 0) {
				int begin = 0, sum = 0;
				String errorNumbers = "";
				ArrayList<Integer> numberList = new ArrayList<Integer>();
				for (int i = 0; i < numbers.length(); i++) {
					if (numbers.charAt(i) == delemiter) {
						numberList.add(Integer.parseInt(numbers.substring(begin, i)));
						begin = i + 1;
					}
				}
				if (begin < numbers.length())
					numberList.add(Integer.parseInt(numbers.substring(begin)));

				for (int number : numberList) {
					if (number < 0)
						errorNumbers += number + " ";
					if (number <= 1000)
						sum += number;
				}
				if (errorNumbers.length() > 0)
					throw new Exception("“negatives not allowed - " + errorNumbers);
				return sum;
			} else
				return Integer.parseInt(numbers);
		}
	}

}
