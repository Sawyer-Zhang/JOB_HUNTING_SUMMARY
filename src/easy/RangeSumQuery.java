package easy;

/**
 * 
 * @description Given nums = [-2, 0, 3, -5, 2, -1]
 * 
 *              sumRange(0, 2) -> 1 sumRange(2, 5) -> -1 sumRange(0, 5) -> -3
 * 
 * @author Zhang shaoyang
 * 
 * @date 2018年12月13日
 */
public class RangeSumQuery {
	private int[] nums;

	public RangeSumQuery(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			nums[i] = nums[i] + nums[i - 1];
		}
		this.nums = nums;
	}

	public int sumRange(int i, int j) {
		if (i < 1)
			return nums[j];
		return nums[j] - nums[i - 1];
	}
}
