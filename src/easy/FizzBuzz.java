package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @description
 * 
 * @author Zhang shaoyang
 * 
 * @date 2018年12月20日
 */
public class FizzBuzz {
	public List<String> fizzBuzz(int n) {
		List<String> result = new ArrayList<String>();
		if (n <= 0)
			return result;
		for (int i = 1; i <= n; i++) {
			if (i % 3 == 0 && i % 5 == 0)
				result.add("FizzBuzz");
			else if (i % 3 == 0)
				result.add("Fizz");
			else if (i % 5 == 0)
				result.add("Buzz");
			else
				result.add(Integer.toString(i));
		}
		return result;
	}
}
