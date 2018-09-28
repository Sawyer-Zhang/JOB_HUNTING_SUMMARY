package easy;

/**
 * 
 * Given a positive integer, return its corresponding column title as appear in
 * an Excel sheet.
 * 
 * @author Zhang shaoyang
 * 
 *         2018年9月27日
 */
public class ExcelSheetColumnTitle {
	public String convertToTitle(int n) {
		StringBuffer sb = new StringBuffer();
		while (n > 0) {
			n--;
			sb.insert(0, (char) ('A' + n % 26));
			n = n / 26;
		}
		return sb.toString();
	}
	/**
	 * 上面那道题反过来
	 * 
	 * @param s
	 * @return
	 */
	public int titleToNumber(String s) {
		if (s.length() == 1) {
			return s.charAt(0) - 64;
		}
		char[] chars = s.toCharArray();
		int result = 0;
		for (Character i : chars) {
			i++;
			result = result * 26 + (i - 65);
		}
		return result;
	}
}
