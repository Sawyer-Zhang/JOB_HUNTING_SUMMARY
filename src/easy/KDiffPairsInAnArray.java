package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: Input: [3, 1, 4, 1, 5], k = 2
 * Output: 2
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 * Although we have two 1s in the input, we should only return the number of unique pairs.
 * Input: [1, 3, 1, 5, 4], k = 0
 * Output: 1
 * Explanation: There is one 0-diff pair in the array, (1, 1).
 * @Author: Zhang shaoyang
 * @CreateDate: 2019/3/3 0003 22:50
 */
public class KDiffPairsInAnArray {
    public int findPairs(int[] nums, int k) {
        if (nums.length == 0 || nums == null || k < 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        if (k == 0) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() >= 2) {
                    count++;
                }
            }
        } else {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (map.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }
        return count;
    }
}
