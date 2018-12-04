package easy;

/**
 * 
 * @description Given an integer, write a function to determine if it is a power
 *              of two.
 * 
 * @author Zhang shaoyang
 * 
 * @date 2018年12月4日
 */
public class PowerOfTwo {
	public boolean isPowerOfTwo(int n) {
		return n > 0 && ((n & (n - 1)) == 0);
	}

	public boolean isPowerOfTwo1(int n) {
		if (n <= 0)
			return false;
		while (n % 2 == 0) {
			n /= 2;
		}
		return n == 1;
	}

	public boolean isPowerOfTwo2(int n) {
		return n > 0 && 1073741824 % n == 0;
	}
}
