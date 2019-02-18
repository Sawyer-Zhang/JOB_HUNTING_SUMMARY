package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * @description Input: nums1 = [4,1,2], nums2 = [1,3,4,2]. Output: [-1,3,-1]
 *              Explanation: For number 4 in the first array, you cannot find
 *              the next greater number for it in the second array, so output
 *              -1. For number 1 in the first array, the next greater number for
 *              it in the second array is 3. For number 2 in the first array,
 *              there is no next greater number for it in the second array, so
 *              output -1.
 * 
 * @author Zhang shaoyang
 * 
 * @date 2019年1月31日
 */
public class NextGreatElement1 {
	public int[] nextGreaterElement(int[] num1, int[] num2) {
		Stack<Integer> stack = new Stack<Integer>();
		Map<Integer, Integer> nextGreatElementMap = new HashMap<Integer, Integer>();
		for (int num : num2) {
			while (!stack.isEmpty() && stack.peek() < num) {
				nextGreatElementMap.put(stack.pop(), num);
			}
			stack.push(num);
		}
		for (int i = 0; i < num1.length; i++) {
			num1[i] = nextGreatElementMap.getOrDefault(num1[i], -1);
		}
		return num1;
	}
}
