package easy;

/**
 * 
 * @description Input: 38 Output: 2 Explanation: The process is like: 3 + 8 =
 *              11, 1 + 1 = 2. Since 2 has only one digit, return it.
 * 
 * @author Zhang shaoyang
 * 
 * @date 2018年12月10日
 */
public class AddDigits {
	public int addDigits(int num) {
		/* 相当于小于10直接返回 */
		while (num / 10 > 0) {
			num = sumDigits(num);
		}
		return num;
	}

	private int sumDigits(int num) {
		if (num == 0) {
			return 0;
		}
		return num % 10 + sumDigits(num / 10);
	}

	public int addDigits1(int num) {
		if (num < 10) {
			return num;
		} else if (num % 9 == 0) {
			return 9;
		} else {
			return num % 9;
		}
	}
}
