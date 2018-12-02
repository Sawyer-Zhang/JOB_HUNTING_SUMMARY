package easy;

/**
 * Input: 10 Output: 4 Explanation: There are 4 prime numbers less than 10, they
 * are 2, 3, 5, 7.
 * 
 * @author Zhang shaoyang
 * 
 *         2018年12月2日
 */
public class CountPrimes {
	/**
	 * boolean数组中的值默认为false，偶数都为非质数
	 * 
	 * @param n
	 * @return
	 */
	public int countPrimes(int n) {
		if (n <= 2)
			return 0;
		boolean[] isPrime = new boolean[n];
		int result = 1;
		for (int i = 3; i < n; i += 2) {
			if(!isPrime[i]) {
				result++;
			}
			for (int j = 3; i * j < n; j += 2) {
				isPrime[i * j] = true;
			}
		}
		return result;
	}
}
