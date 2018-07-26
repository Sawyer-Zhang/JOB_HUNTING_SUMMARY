package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * @author Zhang shaoyang
 * 
 * 2018年7月26日
 */
public class TwoSum {
	public static int[] twoSum(int []nums, int target) throws Exception {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int component = target - nums[i];//得到相加的另一个数字
			if (map.containsKey(component)) {
				return new int[] {map.get(component), i};
			}
			map.put(nums[i], i);
		}
		throw new Exception("no such two numbers");
	}
	public static void main(String []args) {
		try {
			int[] result = twoSum(new int[]{2,7,11,15}, 9);
			System.out.println(result[0]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
