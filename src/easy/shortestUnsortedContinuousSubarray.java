package easy;

/**
 * 
 * @description
 * Input: [2, 6, 4, 8, 10, 9, 15] Output: 5 Explanation: You need to
 *                    sort [6, 4, 8, 10, 9] in ascending order to make the whole
 *                    array sorted in ascending order.
 * understanding：首先，我们假设最小连续的乱序连续的子串的起始位置是i，结束位置为j，可得nums[0,i-1]和
 * 				 nums[j+1,n-1]这两个子串是有序的。nums[i]>nums[i-1],nums[j]<nums[j+1]。假设在nums[i,j]
 * 				 子串中最大的值是max，最小的值是min，那么可知nums[i]≠min，nums[j]≠max
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
