package easy;

/**
 * Given a non-empty array of integers, every element appears twice except for
 * one. Find that single one.
 * 
 * @author Zhang shaoyang
 * 
 *         2018年9月26日
 */
public class SingleNumber {
	public int singleNumber(int[] nums) {
		int result = 0;
		for (int i : nums) {
			result = result ^ i;
		}
		return result;
	}
}
