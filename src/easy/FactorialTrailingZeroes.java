package easy;

/**
 * 
 * 
 * @author Zhang shaoyang
 * 
 *         2018年9月28日
 */
public class FactorialTrailingZeroes {
	/**
	 * 统计阶乘后面0的个数，简单的想法就是先算出阶乘的结果，之后求余算0个个数，但是无论使用long还是double都会出现 超出范围的情况，所以要转变想法。
	 * 分析一下如何会出现10，就是有2有5就会有0，那么2出现的次数肯定比5多，所以统计因子中5的个数就是末尾出现0的个数
	 * 
	 * @param n
	 * @return
	 */
	public int trailingZeroes(int n) {
		int count = 0;
		while (n >= 5) {
			while (n % 5 == 0) {
				count = count + n / 5;
				n = n / 5;
			}
			n--;
		}
		return count;
	}

	public int trailingZeroes1(int n) {
		return n >= 5 ? n / 5 + trailingZeroes(n / 5) : 0;
	}
}
