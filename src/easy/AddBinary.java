package easy;
/**
 * Given two binary strings, return their sum (also a binary string).
 * The input strings are both non-empty and contains only characters 1 or 0.
 * @author Zhang shaoyang
 * 
 * 2018年8月16日
 */
public class AddBinary {
	/**
	 * 解题思路:从最低位相加，和是2的进位（carry=1），不是2的保留1，不进位
	 * 结果都拼接在字符串中，循环结束如果carry有值说明还需进位拼接最后一位做逆序输出
	 * 如果使用stack，不需要逆序，将sum%2的值入栈，这样做不需要逆序
	 * @param a
	 * @param b
	 * @return
	 */
	public String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int alen = a.length() - 1;
		int blen = b.length() - 1;
		int carry = 0;
		while(alen >= 0 || blen >= 0) {
			int sum = carry;
			if (alen >= 0) {
				sum += a.charAt(alen--) - '0';
			}
			if (blen >= 0) {
				sum += b.charAt(blen--) - '0';
			}
			sb.append(sum % 2);
			carry = sum / 2;
		}
		if (carry != 0) {
			sb.append(carry);
		}
		return sb.reverse().toString();
	}
	public static void main(String[] args) {
		AddBinary ab = new AddBinary();
		String result = ab.addBinary("1010", "1011");
		System.out.println(result);
	}
}
