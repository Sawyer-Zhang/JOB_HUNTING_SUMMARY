package easy;

/**
 * 
 * @descriptionInput: [2, 6, 4, 8, 10, 9, 15] Output: 5 Explanation: You need to
 *                    sort [6, 4, 8, 10, 9] in ascending order to make the whole
 *                    array sorted in ascending order.
 * 
 * @author Zhang shaoyang
 * 
 * @date 2019年5月24日
 */
public class shortestUnsortedContinuousSubarray {
	public int findUnsortedSubarray(int[] nums) {
		int i = 0, j = -1, len = nums.length;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int l = 0, r = len - 1; l <= len - 1 && r >= 0; l++, r--) {
			max = Math.max(nums[l], max);
			if (nums[l] != max) {
				j = l;
			}
			min = Math.min(nums[r], min);
			if (nums[r] != min) {
				i = r;
			}
		}
		return (j - i + 1);
	}
}
