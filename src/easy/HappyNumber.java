package easy;

/**
 * 
 * Input: 19 Output: true Explanation: 12 + 92 = 82 82 + 22 = 68 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * 
 * @author Zhang shaoyang
 * 
 *         2018年11月28日
 */
public class HappyNumber {
	public boolean isHappy(int n) {
		int x = n;
		int y = n;
		while (x > 0) {
			x = cal(x);
			if (x == 1) {
				return true;
			}
			y = cal(cal(y));
			if (y == 1) {
				return true;
			}
			if (x == y) {
				return false;
			}
		}
		return false;
	}

	private int cal(int n) {
		int x = n;
		int result = 0;
		while (x > 0) {
			result = (x % 10) * (x % 10);
			x /= 10;
		}
		return result;
	}

	public static void main(String[] args) {
		HappyNumber hn = new HappyNumber();
		System.out.println(hn.isHappy(19));
	}
}
