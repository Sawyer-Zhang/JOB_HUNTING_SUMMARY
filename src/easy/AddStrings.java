package easy;

/**
 * 
 * @description 两个数字组成的字符串，相加成一个新的字符串
 * 
 * @author Zhang shaoyang
 * 
 * @date 2018年12月24日
 */
public class AddStrings {
	/**
	 * explain:for循环里面的判断条件是如果还有剩余的没有计算的数字或者有进位没有处理，循环要继续
	 * 用ascii码去求出对应char的数字，对应位加和10求余是结果对应位置的数字，进位除以10可以得出
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	public String addStrings(String num1, String num2) {
		StringBuilder result = new StringBuilder();
		int carry = 0;
		for (int i = num1.length() - 1, j = num2.length() - 1; i > 0 || j > 0 || carry == 1; i--, j--) {
			int x = i < 0 ? 0 : num1.charAt(i) - '0';
			int y = j < 0 ? 0 : num2.charAt(j) - '0';
			result.append((x + y + carry) % 10);
			carry = (x + y + carry) / 10;
		}
		return result.reverse().toString();
	}
}
