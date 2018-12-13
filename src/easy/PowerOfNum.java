package easy;

/**
 * 
 * @author Zhang shaoyang
 * 
 * @date 2018年12月4日
 */
public class PowerOfNum {
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

	public boolean isPowerOfThree(int n) {
		if (n < 1)
			return false;
		while (n % 3 == 0)
			n /= 3;
		return n == 1;
	}

	public boolean isPowerOfThree1(int n) {
		return n > 0 && 1162261467 % n == 0;
	}

	/*
	 * 0xaaaaaaaa = 10101010101010101010101010101010 (偶数位为1，奇数位为0）
	 * 
	 * 0x55555555 = 1010101010101010101010101010101 (偶数位为0，奇数位为1）
	 * 
	 * 0x33333333 = 110011001100110011001100110011 (1和0每隔两位交替出现)
	 * 
	 * 0xcccccccc = 11001100110011001100110011001100 (0和1每隔两位交替出现)
	 * 
	 * 0x0f0f0f0f = 00001111000011110000111100001111 (1和0每隔四位交替出现)
	 * 
	 * 0xf0f0f0f0 = 11110000111100001111000011110000 (0和1每隔四位交替出现)
	 */
	public boolean isPowerOfFour(int n) {
		return n > 0 && ((n & (n - 1)) == 0) && ((n & 0xaaaaaaaa) == 0);
	}
}
