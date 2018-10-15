package easy;

/**
 * 
 * Write a function that takes an unsigned integer and returns the number of '1'
 * bits it has
 * 
 * @author Zhang shaoyang
 * 
 *         2018年10月15日
 */
public class Numberof1Bits {
	public int hammingWeight(int n) {
		int count = 0;
		while (n != 0) {
			count = count + (n & 1);
			n >>>= 1;
		}
		return count;
	}
}
