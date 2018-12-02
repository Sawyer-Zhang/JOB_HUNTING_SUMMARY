package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Input: nums = [1,0,1,1], k = 1 Output: true
 * 
 * Input: nums = [1,2,3,1,2,3], k = 2 Output: false
 * 
 * @author Zhang shaoyang
 * 
 *         2018年12月2日
 */
public class ContainsDuplicate2 {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if (nums.length == 0)
			return false;
		Map<Integer, Integer> resultMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (resultMap.containsKey(nums[i])) {
				if (i - resultMap.get(nums[i]) <= k) {
					return true;
				}
			}
			resultMap.put(nums[i], i);
		}
		return false;
	}

	public static void main(String[] args) {
		int test[] = new int[] { 1, 2, 3, 1 };
		ContainsDuplicate2 cd = new ContainsDuplicate2();
		System.out.println(cd.containsNearbyDuplicate(test, 1));
	}
}