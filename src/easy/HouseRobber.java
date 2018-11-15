package easy;

/**
 * 
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 * 
 * @author Zhang shaoyang
 * 
 *         2018年11月15日
 */
public class HouseRobber {
	public int rob(int[] nums) {
		return rob(nums, nums.length - 1);
	}

	public int rob(int[] nums, int i) {
		if (i < 0) {
			return 0;
		}
		return Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
	}

	public int rob1(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int[] temp = new int[nums.length + 1];
		temp[0] = 0;
		temp[1] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			temp[i + 1] = Math.max(temp[i - 1] + nums[i], temp[i]);
		}
		return temp[nums.length];
	}
}
