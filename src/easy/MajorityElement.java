package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than n/2 times.
 * 
 * @author Zhang shaoyang
 * 
 *         2018年9月28日
 */
public class MajorityElement {
	/**
	 * 第一种解法使用集合类
	 * @param nums
	 * @return
	 */
	public int majorityElement(int[] nums) {
		Map<Integer, Integer> statistical = new HashMap<Integer, Integer>();
		int max = 0;
		int result = 0;
		for (int i : nums) {
			if (statistical.containsKey(i)) {
				statistical.put(i, statistical.get(i) + 1);
			} else {
				statistical.put(i, 1);
			}
		}
		for (Map.Entry<Integer, Integer> element : statistical.entrySet()) {
			if (element.getValue() > max) {
				max = element.getValue();
				result = element.getKey();
			}
		}
		return result;
	}
	/**
	 * 第二种解法比较巧妙，相当于累加第一个出现的数字，如果出现其他其他数字就把累加的次数减一
	 * 当次数为0时，就更换统计数字
	 * @param nums
	 * @return
	 */
	public int majorityElement1(int[] nums) {
		int count = 1;
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (count == 0) {
				max = nums[i];
				count++;
			} else if (nums[i] == max) {
				count++;
			} else {
				count--;
			}
		}
		return max;
	}
}
