package easy;

/**
 * 
 * @description 把自然数序列当做字符串（1234567891011...）之后寻找第n位的数字，理解这道题花了好久。。。
 * 
 * @author Zhang shaoyang
 * 
 * @date 2018年12月19日
 */
public class NthDigit {
	public int findNthDigit(int n) {
		if (n <= 9) {
			return n;
		}
		int len = 1;//记录长度
		int start = 1;//记录开始的数字
		long count = 9;//个位数有9个，十位数有90个	
		while (n > len * count) {
			n = (int) (n - len * count);//len*count代表某一个长度的数字转换成字符串的总长度
			len = len + 1;//长度加一
			count = count * 10;//某一个长度的数字的个数
			start = start * 10;//某一个长度的开始数字
		}
		/*
		 * 已经找到了n是从多少长度的数字开始，之后去找具体的那个数字，最后去找在那个数字的哪一位上
		 */
		start = start + (n - 1) / len;
		String s = Integer.toString(start);
		return s.charAt((n - 1) % len) - '0';
	}
}
