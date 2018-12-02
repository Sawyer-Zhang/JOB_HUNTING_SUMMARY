package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Input: s = "foo", t = "bar" Output: false Input: s = "paper", t = "title"
 * Output: true
 * 
 * @author Zhang shaoyang
 * 
 *         2018年12月2日
 */
public class IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {
		if (s == null || s.length() == 0)
			return true;
		Map<Character, Character> charMap = new HashMap<Character, Character>();
		for (int i = 0; i < s.length(); i++) {
			char sin = s.charAt(i);
			char tin = t.charAt(i);
			if (charMap.containsKey(sin)) {
				if (charMap.get(sin) == tin) {
					continue;
				} else {
					return false;
				}
			} else {
				if (!charMap.containsValue(tin)) {
					charMap.put(sin, tin);
				} else {
					return false;
				}
			}
		}
		return true;
	}
	public static void main(String[] args) {
		IsomorphicStrings is = new IsomorphicStrings();
		System.out.println(is.isIsomorphic("paper", "title"));
	}
}
