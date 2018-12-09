package easy;

/**
 * 
 * @description Input: s = "anagram", t = "nagaram" Output: true(是否是字母乱序)
 * 
 * @author Zhang shaoyang
 * 
 * @date 2018年12月9日
 */
public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
		if (s == null || s.length() == 0) {
			return true;
		}
		int[] alphabet = new int[26];
		for (int i = 0; i < s.length(); i++) {
			alphabet[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < t.length(); i++) {
			alphabet[t.charAt(i) - 'a']--;
		}
		for (int i = 0; i < alphabet.length; i++) {
			if (alphabet[i] != 0)
				return false;
		}
		return true;
	}
}
