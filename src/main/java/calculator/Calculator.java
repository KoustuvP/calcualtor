package calculator;

import java.util.ArrayList;

import com.sun.tools.javac.util.List;

public class Calculator {

	public int add(String numbers) {
		if (numbers.isBlank())
			return 0;
		else {
			numbers= numbers.replace("\n","");

			int separatorIndex = numbers.indexOf(",");
			if (separatorIndex > 0) {
				int begin = 0, sum = 0;
				ArrayList<Integer> numberList = new ArrayList<Integer>();
				for (int i = 0; i < numbers.length(); i++) {
					if (numbers.charAt(i) == ',') {
						numberList.add(Integer.parseInt(numbers.substring(begin, i)));
						begin = i + 1;
					}
				}
				if(begin<numbers.length())
				numberList.add(Integer.parseInt(numbers.substring(begin)));
				for (int number : numberList) {
					sum += number;
				}
				return sum;
			} else
				return Integer.parseInt(numbers);
		}
	}

}
