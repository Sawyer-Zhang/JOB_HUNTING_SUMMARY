package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array),
 * some elements appear twice and others appear once.
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * @Author: Zhang shaoyang
 * @CreateDate: 2019/1/7 0007 20:48
 */
public class FindAllNumbersDisappearedInAnArray {
    /*
     * nums[nums[i] - 1] = -nums[nums[i] - 1]
     * 将出现在数组中的数字作为下标查找对应的数字，将查找出来的数字置为负数。第一轮循环结束之后，数组中还是正数的
     * 数字对应的下标加一就是没出现的数字。
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if (nums.length == 0)
            return result;
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }

    /*
     * 上面的方法是置为负数，这种方法是将出现过的数字加上n，没出现过的数字作为下角标查找对应的数字小于n
     */
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        int n = nums.length;
        if (n == 0)
            return result;
        for (int i = 0; i < n; i++)
            nums[(nums[i] - 1) % n] += n;//出现重复的数字时会超出数组边界，所以需要求余操作
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n)
                result.add(i + 1);
        }
        return result;
    }
}
