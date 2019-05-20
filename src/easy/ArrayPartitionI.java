package easy;

import java.util.Arrays;

/**
 * @Description: Input: [1,4,3,2]
 * Output: 4
 * Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
 * @Author: Zhang shaoyang
 * @CreateDate: 2019/5/17 0017 16:57
 */
public class ArrayPartitionI {
    public int arrayPairSum(int[] nums) {
        int result = 0;
        if (nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i + 2 <= nums.length; i += 2) {
            result += Math.min(nums[i], nums[i + 1]);
        }
        return result;
    }
}
