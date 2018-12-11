package easy;

/**
 * 
 * @descriptionInput Ugly numbers are positive numbers whose prime factors only
 *                   include 2, 3, 5.
 * 
 * @author Zhang shaoyang
 * 
 * @date 2018年12月11日
 */
public class UglyNumber {
	public boolean isUgly(int num) {
		if (num <= 0) {
			return false;
		}
		while (num % 2 == 0)
			num /= 2;
		while (num % 3 == 0)
			num /= 3;
		while (num % 5 == 0)
			num /= 5;
		return num == 1;
	}
}
