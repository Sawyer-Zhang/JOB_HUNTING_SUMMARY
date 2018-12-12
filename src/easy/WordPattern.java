package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 
 * @description Input: pattern = "abba", str = "dog cat cat dog" Output: true
 * 
 * @author Zhang shaoyang
 * 
 * @date 2018年12月12日
 */
public class WordPattern {
	public boolean wordPattern(String pattern, String str) {
		String[] words = str.split(" ");
		if (pattern.length() != words.length) {
			return false;
		}
		Map<Object, Integer> wordMap = new HashMap<Object, Integer>();
		for (int i = 0; i < pattern.length(); i++) {
			if (!Objects.equals(wordMap.put(pattern.charAt(i), i), wordMap.put(words[i], i)))
				return false;
		}
		return true;
	}
}
