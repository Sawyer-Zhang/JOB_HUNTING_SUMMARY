package easy;

/**
 * 
 * @description Input: m = 3, n = 3 operations = [[2,2],[3,3]] Output: 4
 *              Explanation: Initially, M = [[0, 0, 0], [0, 0, 0], [0, 0, 0]]
 * 
 *              After performing [2,2], M = [[1, 1, 0], [1, 1, 0], [0, 0, 0]]
 * 
 *              After performing [3,3], M = [[2, 2, 1], [2, 2, 1], [1, 1, 1]]
 * 
 *              So the maximum integer in M is 2, and there are four of it in M.
 *              So return 4.
 * 
 * @author Zhang shaoyang
 * 
 * @date 2019年6月2日
 */
public class RangeAdditionII {
	public int maxCount(int m, int n, int[][] ops) {
		if (ops == null || ops.length == 0 || ops[0].length == 0) {
			return m * n;
		}
		int minx = ops[0][0];
		int miny = ops[0][1];
		for (int i = 0; i <= ops.length; i++) {
			minx = Math.min(minx, ops[i][0]);
			miny = Math.min(miny, ops[i][1]);
		}
		return minx * miny;
	}
}
