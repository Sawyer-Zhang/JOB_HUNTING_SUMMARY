package easy;

/**
 * 
 * @description 一堆小石头子，每个人每次最多拿3个，最少拿一个
 * 
 * @author Zhang shaoyang
 * 
 * @date 2018年12月13日
 */
public class NimName {
	public boolean canWinNim(int n) {
		if (n < 4)
			return true;
		boolean result[] = new boolean[n];
		for (int i = 3; i < n; i++) {
			result[0] = true;
			result[1] = true;
			result[2] = true;
			result[i] = !(result[i - 1] && result[i - 2] && result[i - 3]);
		}
		return result[n - 1];
	}

	public boolean canWinNim1(int n) {
		return !(n % 4 == 0);
	}
}
