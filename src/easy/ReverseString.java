package easy;
/**
 * 
 * @description 翻转字符串
 * 	
 * @author Zhang shaoyang
 * 
 * @date 2018年12月14日
 */
public class ReverseString {
	public String reverseString(String s) {
		if (s == null) {
			return s;
		}
		char []revChar = s.toCharArray();
		int start = 0;
		int end = revChar.length - 1;
		while(start <end) {
			char temp = revChar[end];
			revChar[end] = revChar[start];
			revChar[start] = temp;
			
			start++;
			end--;
		}
		return String.valueOf(revChar);
	}
}
