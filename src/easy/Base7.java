package easy;

/**
 * 
 * @description 把一个数字转换成7进制，输出字符串
 * 
 * @author Zhang shaoyang
 * 
 * @date 2019年2月21日
 */
public class Base7 {
	public String convertToBase7(int num) {
		int base = 1;
		int value = 0;
		while (num != 0) {
			value += base * (num % 7);
			num = num / 7;
			base = base * 10;
		}
		return String.valueOf(value);
	}
}
