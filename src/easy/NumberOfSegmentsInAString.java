package easy;

/**
 * 
 * @description:Count the number of segments in a string, where a segment is
 *                    defined to be a contiguous sequence of non-space
 *                    characters.
 * 
 * @author Zhang shaoyang
 * 
 * @date 2019年1月1日
 */
public class NumberOfSegmentsInAString {
	public int countSegments(String s) {
		if (s.length() == 0 || s == null) {
			return 0;
		}
		int result = 0;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == ' ' && s.charAt(i - 1) != ' ') {
				result++;
			}
		}
		if (s.charAt(s.length() - 1) != ' ') {
			result++;
		}
		return result;
	}
}
