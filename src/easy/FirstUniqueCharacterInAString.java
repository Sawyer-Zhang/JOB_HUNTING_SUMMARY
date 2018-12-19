package easy;

/**
 * 
 * @descriptionGiven a string, find the first non-repeating character in it and
 *                   return it's index. If it doesn't exist, return -1
 * 
 * @author Zhang shaoyang
 * 
 * @date 2018年12月19日
 */
public class FirstUniqueCharacterInAString {
	public int firstUniqChar(String s) {
		if (s.length() == 0) {
			return -1;
		}
		int[] alphabet = new int[26];
		char[] uniqueChar = s.toCharArray();
		for (int i = 0; i < uniqueChar.length; i++) {
			alphabet[uniqueChar[i] - 'a']++;
		}
		for (int j = 0; j < uniqueChar.length; j++) {
			if (alphabet[uniqueChar[j] - 'a'] == 1) {
				return j;
			}
		}
		return -1;
	}
}
