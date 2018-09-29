package easy;

/**
 * Given an array, rotate the array to the right by k steps, where k is
 * non-negative.
 * 
 * @author Zhang shaoyang
 * 
 *         2018年9月29日
 */
public class RotateArray {
	public void rotate(int[] nums, int k) {
		int len = nums.length;
		while (k > 0) {
			int temp = nums[len - 1];
			for (int i = len - 1; i > 0; i--) {
				nums[i] = nums[i - 1];
			}
			nums[0] = temp;
			k--;
		}
	}

	public void rotate1(int[] nums, int k) {
		if (k == 0 || nums.length == 0) {
			return;
		}
		k = k % nums.length;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
	}

	private void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[end];
			nums[end] = nums[start];
			nums[start] = temp;
			start++;
			end--;
		}
	}
}
