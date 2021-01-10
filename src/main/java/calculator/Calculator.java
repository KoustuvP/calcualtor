package calculator;

import java.util.ArrayList;

import com.sun.tools.javac.util.List;

public class Calculator {

	public int add(String numbers) throws Exception {
		if (numbers.isBlank())
			return 0;
		else {
			char delemiter = ',';
			int delemiterLength = 1;
			if (numbers.charAt(0) == '/' && numbers.charAt(1) == '/') {
				if (numbers.charAt(2) == '[') {
					delemiterLength = numbers.substring(3, numbers.indexOf("]")).length();
					delemiter = numbers.substring(3, numbers.indexOf("]") - 1).charAt(0);
					numbers = numbers.substring(numbers.indexOf("]") + 1);
				} else {
					delemiter = numbers.charAt(2);
					numbers = numbers.substring(4);
				}

			}
			numbers = numbers.replace("\n", "");
			if (numbers.endsWith("" + delemiter))
				numbers = numbers.substring(0, numbers.length() - delemiterLength);
			int separatorIndex = numbers.indexOf(delemiter);
			if (separatorIndex > 0) {
				int begin = 0, sum = 0;
				String errorNumbers = "";
				ArrayList<Integer> numberList = new ArrayList<Integer>();
				for (int i = 0; i < numbers.length(); i++) {
					if (numbers.charAt(i) == delemiter && i < numbers.length() - 1
							&& numbers.charAt(i + 1) != delemiter) {
						numberList.add(Integer.parseInt(numbers.substring(begin, i + 1 - delemiterLength)));

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
