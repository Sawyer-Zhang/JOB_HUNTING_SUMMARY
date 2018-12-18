package easy;

/**
 * 
 * @description 两个整数加和（正整数和负整数）
 * 
 * @author Zhang shaoyang
 * 
 * @date 2018年12月18日
 */
public class SumOfTwoIntegers {
	public int getSum(int a, int b) {
		if (a == 0)
			return b;
		if (b == 0)
			return a;
		while (b != 0) {
			/*
			 * 首先是获取进位，在二进制中，如果两个位置都为1，相加之后会产生进位所以用'&'操作获取两个数相加产生的进位
			 */
			int carry = a & b;
			/*
			 * 将两个被加数进行异或操作，如果两个位置都为0，那么相加后保持不变，如果都为1那么应该进位
			 * 如果两个位置不同那么应该为1，所以用异或操作得到的结果加上进位就是这两个数字的和。
			 */
			a = a ^ b;
			/*
			 * 将进位左移一位，进位之后要再去看和a的加和会不会产生新的进位
			 */
			b = carry << 1;
		}
		return a;
	}
}
 