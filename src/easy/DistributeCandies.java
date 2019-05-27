package easy;

import java.util.HashSet;

/**
 * 
 * @descriptionInput: candies = [1,1,2,3] Output: 2 Explanation: For example,
 *                    the sister has candies [2,3] and the brother has candies
 *                    [1,1]. The sister has two different kinds of candies, the
 *                    brother has only one kind of candies.
 * 
 * @author Zhang shaoyang
 * 
 * @date 2019年5月24日
 */
public class DistributeCandies {
	public int distributeCandies(int[] candies) {
		int len = candies.length;
		if (len == 0 || candies == null) {
			return 0;
		}

		HashSet<Integer> diffNum = new HashSet<Integer>();
		for (int i = 0; i < len; i++) {
			diffNum.add(candies[i]);
		}
		return len / 2 >= diffNum.size() ? diffNum.size() : len / 2;
	}
}
