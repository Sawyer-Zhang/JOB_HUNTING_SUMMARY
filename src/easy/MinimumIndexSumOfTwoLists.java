package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @description Input: ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 *              ["KFC", "Shogun", "Burger King"] Output: ["Shogun"] Explanation:
 *              The restaurant they both like and have the least index sum is
 *              "Shogun" with index sum 1 (0+1).
 * 
 * @author Zhang shaoyang
 * 
 * @date 2019年6月3日
 */
public class MinimumIndexSumOfTwoLists {
	public String[] findRestaurant(String[] list1, String[] list2) {
		Map<String, Integer> result = new HashMap<String, Integer>();
		List<String> restaurant = new ArrayList<String>();
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < list1.length; i++) {
			result.put(list1[i], i);
		}
		for (int i = 0; i < list2.length; i++) {
			Integer j = result.get(list2[i]);
			if (j != null && i + j <= min) {
				if (i + j < min) {
					restaurant.clear();
					min = i + j;
				}
				restaurant.add(list2[i]);
			}
		}
		return restaurant.toArray(new String[restaurant.size()]);
	}
	public static void main(String []args) {
		String []a = new String[]{"Shogun","Tapioca Express","Burger King","KFC"};
		String []b = new String[] {"KFC","Shogun","Burger King"};
		MinimumIndexSumOfTwoLists min = new MinimumIndexSumOfTwoLists();
		min.findRestaurant(a, b);
	}
}
