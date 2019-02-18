package easy;

/**
 * @Description: 找出一串数字中连续数字1最多是多少
 * @Author: Zhang shaoyang
 * @CreateDate: 2019/1/22 0022 22:41
 */
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] == 1) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 0;
            }
        }
        return max;
    }
}
