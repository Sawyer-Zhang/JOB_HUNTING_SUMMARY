package easy;
/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * @author Zhang shaoyang
 * 
 * 2018年8月5日
 */
public class RemoveDuplicatesFromSortedArray {
	private int removeDuplicates(int []nums) {
		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return 1;
		}
		int index = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i-1]) {
				nums[index] = nums[i];
				index++;
			}
		}
		return index;
	}
	public static void main(String []args) {
		int nums[] = {0,0,2,3,3,4,4,5};
		RemoveDuplicatesFromSortedArray rdfsa = new RemoveDuplicatesFromSortedArray();
		int result = rdfsa.removeDuplicates(nums);
		System.out.println(result);
	}
}
