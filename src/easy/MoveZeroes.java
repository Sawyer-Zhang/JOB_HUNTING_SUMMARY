package easy;

/**
 * 
 * @descriptionInput: [0,1,0,3,12] Output: [1,3,12,0,0]
 * 
 * @author Zhang shaoyang
 * 
 * @date 2018年12月12日
 */
public class MoveZeroes {
	public void moveZeroes(int[] nums) {
		if (nums.length == 0)
			return;
		int beyondZeroLen = 0;
		for (int num : nums) {
			if (num != 0) {
				nums[beyondZeroLen++] = num;
			}
		}
		while (beyondZeroLen != nums.length) {
			nums[beyondZeroLen++] = 0;
		}
	}
}
