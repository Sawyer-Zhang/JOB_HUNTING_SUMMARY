package easy;

/**
 * 
 * @description Input: s = "abcd" t = "abcde"
 * 
 *              Output: e
 * 
 * @author Zhang shaoyang
 * 
 * @date 2018年12月19日
 */
public class FindTheDifference {
	public char findTheDifference(String s, String t) {
		int[] alphabet = new int[26];
		char[] tArray = t.toCharArray();
		char[] sArray = s.toCharArray();
		for (int i = 0; i < sArray.length; i++) {
			alphabet[sArray[i] - 'a']++;
		}
		for (int j = 0; j < tArray.length; j++) {
			if (--alphabet[tArray[j] - 'a'] < 0) {
				return tArray[j];
			}
		}
		return ' ';
	}
}
