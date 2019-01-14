package easy;

/**
 * @Description: Input:[1,2,3]
 * Output:3
 * Explanation:
 * Only three moves are needed (remember each move increments two elements):
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 * @Author: Zhang shaoyang
 * @CreateDate: 2019/1/7 0007 20:49
 */
public class MinimumMovesToEqualArrayElements {
    /**
     * 可以将这道题当做一道数学题来理解
     * sum+m*(n-1) = x*n(sum是起始数字的和，m是需要做加和操作的次数，x是最后统一之后的数字，我们要求的就是m)
     * x = minNum+m(最后的数字等于当前最小的数字加上m)
     * 可以得到m=sum-n*minNum
     *
     * @param nums
     * @return
     */
    public int minMoves(int[] nums) {
        int min = nums[0];
        int result = 0;
        for (int i : nums) {
            if (i < min) min = i;
        }
        for (int i : nums) {
            result += i - min;
        }
        return result;
    }
}
