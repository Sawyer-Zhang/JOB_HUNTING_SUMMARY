package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given an array of integers that is already sorted in ascending order, find
 * two numbers such that they add up to a specific target number.
 * 
 * @author Zhang shaoyang
 * 
 *         2018年9月27日
 */
public class TwoSum2 {
	public int[] twoSum(int[] numbers, int target) {
		int len = numbers.length;
		Map<Integer, Integer> judgeMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < len; i++) {
			int component = target - numbers[i];
			if (judgeMap.containsKey(component)) {
				return new int[] { judgeMap.get(component), i + 1 };
			}
			judgeMap.put(numbers[i], i + 1);
		}
		return null;
	}
}
