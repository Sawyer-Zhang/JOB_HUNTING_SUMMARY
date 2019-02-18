package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @descriptionGiven a List of words, return the words that can be typed using
 *                   letters of alphabet on only one row's of American keyboard
 *                   like the image below.
 * 
 * @author Zhang shaoyang
 * 
 * @date 2019年2月11日
 */
public class KeyboardRow {
	public String[] findWords(String[] words) {
		String[] strs = new String[] { "QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM" };
		Map<Character, Integer> keyboardRow = new HashMap<Character, Integer>();
		for (int i = 0; i < strs.length; i++) {
			for (char c : strs[i].toCharArray()) {
				keyboardRow.put(c, i);
			}
		}
		List<String> result = new ArrayList<String>();
		for (String word : words) {
			int index = keyboardRow.get(word.toUpperCase().charAt(0));
			for (char c : word.toUpperCase().toCharArray()) {
				if (keyboardRow.get(c) != index) {
					index = -1;
					break;
				}
			}
			if (index != -1) {
				result.add(word);
			}
		}
		return result.toArray(new String[0]);
	}
}
