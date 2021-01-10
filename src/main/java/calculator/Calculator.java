package calculator;

import java.util.ArrayList;

import com.sun.tools.javac.util.List;

public class Calculator {

	public int add(String numbers) throws Exception {
		if (numbers.isBlank())
			return 0;
		else {
			String delemiter = ",";
			int delemiterLength = 1;
			boolean isMulti=false;
			boolean separatorIndex=false;
			
			ArrayList<Integer> delemiterIndexList = new ArrayList<Integer>();
			if (numbers.charAt(0) == '/' && numbers.charAt(1) == '/') {
				if(numbers.indexOf("][")>0)
				isMulti=true;
				int ind=0;
				while(numbers.indexOf("][",ind)!=-1) {
					 delemiterIndexList.add(numbers.indexOf("][",ind));
					 ind+=numbers.indexOf("][")+1;
				}
				if(isMulti) {
					delemiter="";
					for(int number:delemiterIndexList) {
					delemiter+=numbers.charAt(number-1)+""+numbers.charAt(number+2);
					 separatorIndex=true;
					}
					delemiterLength = numbers.substring(3, numbers.indexOf("]")).length();
					numbers = numbers.substring(numbers.indexOf("\n") + 1);
				}
				else {
					if (numbers.charAt(2) == '[') {
						delemiterLength = numbers.substring(3, numbers.indexOf("]")).length();
						delemiter = ""+numbers.substring(3, numbers.indexOf("]") - 1).charAt(0);
						numbers = numbers.substring(numbers.indexOf("]") + 1);
					} else {
						delemiter = ""+numbers.charAt(2);
						numbers = numbers.substring(4);
					}
				}
				
				

			}
			numbers = numbers.replace("\n", "");
			if (numbers.endsWith("" + delemiter))
				numbers = numbers.substring(0, numbers.length() - delemiterLength);
			if(!isMulti)
			 separatorIndex = numbers.contains(delemiter);
			if (separatorIndex) {
				int begin = 0, sum = 0;
				String errorNumbers = "";
				ArrayList<Integer> numberList = new ArrayList<Integer>();
				for (int i = 0; i < numbers.length(); i++) {
					if (delemiter.contains(""+numbers.charAt(i)) && i < numbers.length() - 1
							&& !delemiter.contains(""+numbers.charAt(i + 1) )) {
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
