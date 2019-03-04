package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @description Input: 28 Output: True Explanation: 28 = 1 + 2 + 4 + 7 + 14
 * 
 * @author Zhang shaoyang
 * 
 * @date 2019年2月23日
 */
public class PerfectNumber {
	public boolean checkPerfectNumber(int num) {
		if (num == 1) {
			return false;
		}
		int sqrt = (int) Math.sqrt(num);
		List<Integer> factors = new ArrayList<Integer>();
		int result = 1;
		for (int i = 2; i <= sqrt; i++) {
			if (num % i == 0) {
				factors.add(i);
				factors.add(num / i);
			}
		}
		for (int factor : factors) {
			result += factor;
		}
		return result == num ? true : false;
	}

	public static void main(String[] args) {
		PerfectNumber pn = new PerfectNumber();
		System.out.println(pn.checkPerfectNumber(6));
	}
}
