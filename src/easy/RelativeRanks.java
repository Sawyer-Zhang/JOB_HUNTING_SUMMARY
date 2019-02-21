package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @description
 * 
 * @author Zhang shaoyang
 * 
 * @date 2019年2月21日
 */
public class RelativeRanks {
	public String[] findRelativeRanks(int[] nums) {
		if (nums == null) {
			return null;
		}
		String[] result = new String[nums.length];
		Map<Integer, Integer> numsMap = new HashMap<Integer, Integer>();
		int[] temp = Arrays.copyOf(nums, nums.length);
		Arrays.sort(temp);
		for (int i = 0; i < temp.length; i++) {
			numsMap.put(temp[i], temp.length - i);
		}
		for (int i = 0; i < nums.length; i++) {
			if (numsMap.get(nums[i]) == 1) {
				result[i] = "Gold Medal";
			} else if (numsMap.get(nums[i]) == 2) {
				result[i] = "Silver Medal";
			} else if (numsMap.get(nums[i]) == 3) {
				result[i] = "Bronze Medal";
			} else {
				result[i] = String.valueOf(numsMap.get(nums[i]));
			}
		}
		return result;
	}
}
