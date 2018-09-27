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
}
