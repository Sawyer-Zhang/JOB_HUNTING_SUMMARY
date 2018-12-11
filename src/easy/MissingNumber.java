package easy;

/**
 * 
 * @description Given an array containing n distinct numbers taken from 0, 1, 2,
 *              ..., n, find the one that is missing from the array.
 * 
 * @author Zhang shaoyang
 * 
 * @date 2018年12月11日
 */
public class MissingNumber {
	/*
	 * a^b^b = a（如果是有序的可以用二分法哦）
	 * 
	 */
	public int missingNumber(int[] nums) {
		int result = nums.length;
		for (int i = 0; i < nums.length; i++) {
			result = result ^ i ^ nums[i];
		}
		return result;
	}
}
