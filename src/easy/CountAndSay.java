package easy;
/**
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth term of the count-and-say sequence.
 * @author Zhang shaoyang
 * 
 * 2018年8月6日
 */
public class CountAndSay {
	/**
	 * *使用递归思想实现该算法，n为1的时候是边界条件返回1，n为2的时候去统计n为1的结果1个1，结果为11
	 * *n为3的时候观察n为2的结果为2个1，结果为21，以此类推。
	 * @param n
	 * @return
	 */
	private String countAndSay(int n) {
		if (n == 1) {
			return "1";
		}
		String str = countAndSay(n - 1) + "*";
		int count = 1;
		char []charArray = str.toCharArray();
		String resultStr = "";
		for (int i = 0; i < charArray.length - 1; i++) {
			if (charArray[i] == charArray[i+1]) {
				count++;
			}else {
				resultStr = resultStr + String.valueOf(count) + charArray[i]; 
				count = 1;
			}
		}
		return resultStr;
	}
	public static void main(String []args) {
		CountAndSay cas = new CountAndSay();
		String result = cas.countAndSay(6);
		System.out.println(result);
	}
}
