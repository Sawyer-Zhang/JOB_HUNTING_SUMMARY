package easy;

/**
 * 
 * @description 判断一个数字是不是平方数
 * 
 * @author Zhang shaoyang
 * 
 * @date 2018年12月18日
 */
public class ValidPerfectSquare {
	public boolean isPerfectSquare(int num) {
		if (num < 0) {
			return false;
		}
		for (int i = 1; num > 0; i += 2) {
			num -= i;
		}
		return num == 0;
	}

	public boolean isPerfectSquare1(int num) {
		if (num == 1) {
			return true;
		}
		long left = 1;
		long right = num / 2;
		long mid = 0;
		while (left <= right) {
			mid = left + (right - left) / 2;
			if (mid * mid == num) {
				return true;
			} else if (mid * mid < num) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return false;
	}
	
}
