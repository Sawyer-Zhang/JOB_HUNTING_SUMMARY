package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @description We define a harmonious array is an array where the difference
 *              between its maximum value and its minimum value is exactly 1.
 * 
 *              Now, given an integer array, you need to find the length of its
 *              longest harmonious subsequence among all its possible
 *              subsequences.
 * 
 * @author Zhang shaoyang
 * 
 * @date 2019年5月30日
 */
public class LongestHarmoniousSubsequence {
	public int findLHS(int[] nums) {
		if (nums.length == 0 || nums == null) {
			return 0;
		}
		int max = 0;
		Map<Integer, Integer> count = new HashMap<Integer, Integer>();
		for (int num : nums) {
			count.put(num, count.getOrDefault(num, 0) + 1);
		}
		for (int num : nums) {
			if (count.containsKey(num + 1)) {
				max = Math.max(max, count.get(num) + count.get(num + 1));
			}
		}
		return max;
	}
}
