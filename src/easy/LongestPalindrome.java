package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @description Input: "abccccdd"
 * 
 *              Output: 7
 * 
 *              Explanation: One longest palindrome that can be built is
 *              "dccaccd", whose length is 7.
 * 
 * 
 * @author Zhang shaoyang
 * 
 * @date 2018年12月20日
 */
public class LongestPalindrome {
	public int longestPalindrome(String s) {
		if (s.length() == 0 || s == null) {
			return 0;
		}
		Set<Character> charSet = new HashSet<Character>();
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (charSet.contains(s.charAt(i))) {
				charSet.remove(s.charAt(i));
				count++;
			} else {
				charSet.add(s.charAt(i));
			}
		}
		return charSet.isEmpty() ? count * 2 : count * 2 + 1;
	}
}
