package easy;

/**
 * 
 * @description
 * 
 * @author Zhang shaoyang
 * 
 * @date 2018年12月24日
 */
public class ThirdMaximumNumber {
	public int thirdMax(int[] nums) {
		Integer nums1 = null;
		Integer nums2 = null;
		Integer nums3 = null;
		for (Integer n : nums) {
			if (n.equals(nums1) || n.equals(nums2) || n.equals(nums3)) {
				continue;
			}
			if (nums1 == null || n > nums1) {
				nums3 = nums2;
				nums2 = nums1;
				nums1 = n;
			} else if (nums2 == null || n > nums2) {
				nums3 = nums2;
				nums2 = n;
			} else if (nums3 == null || n > nums3) {
				nums3 = n;
			}
		}
		return nums3 == null ? nums1 : nums3;
	}
}
