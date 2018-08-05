package easy;
/**
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * @author Zhang shaoyang
 * 
 * 2018年8月5日
 */
public class RemoveElement {
	private int removeElement(int nums[], int val) {
		if (nums.length == 0) {
			return 0;
		}
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[result] = nums[i];
				result++;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		int nums[] = {1,1,1,2,2,2,3,4,4};
		int val = 1;
		RemoveElement re = new RemoveElement();
		int result = re.removeElement(nums, val);
		System.out.println(result);
	}

}
