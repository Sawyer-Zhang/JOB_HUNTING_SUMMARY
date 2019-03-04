package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @description:Given a string s and a non-empty string p, find all the start
 *                    indices of p's anagrams in s.
 *                    找出全部p字符串的全排列在s字符串中出现的起始位置
 * 
 * @author Zhang shaoyang
 * 
 * @date 2019年1月3日
 */
public class FindAllAnagramsInAString {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<Integer>();
		if (s.length() < p.length()) {
			return result;
		}
		Map<Character, Integer> alphabetMap = new HashMap<Character, Integer>();
		for (char c : p.toCharArray()) {
			/* 先将被寻找的字符串转变为字符数组分别存到hashmap中，key是字符，value是出现次数 */
			alphabetMap.put(c, alphabetMap.getOrDefault(c, 0) + 1);
		}
		int count = alphabetMap.size();
		int end = 0;
		int begin = 0;
		/**
		 * 外层while循环的目的是
		 * 找出字符串s出现全部p串中字符的位置，将这个位置定为end
         * 说明起点到end指针指向的位置中可能出现子串的排列
		 */
		while (end < s.length()) {
			char endChar = s.charAt(end);
			if (alphabetMap.containsKey(endChar)) {
				alphabetMap.put(endChar, alphabetMap.get(endChar) - 1);
				if (alphabetMap.get(endChar) == 0) {
					count--;
				}
			}
			end++;
			/**
			 * count为0的时候说明begin到end中出现了可以构成p字符串的全部字符
             * 判断end-begin之间是不是和子串长度相同，如果相同就是其中一个解
			 * 只要找到其中一个字符就会退出循环
             * begin指针指向的是第一个出现存在于p串中的字符假设为a，将count加一的目的是退出循环
             * 在外层循环中重新寻找一个a字符，和之前已经找到的end-begin中的字符重新满足了构成所有p串中字符的条件
			 */
			while (count == 0) {
				char beginChar = s.charAt(begin);
				if (alphabetMap.containsKey(beginChar)) {
					alphabetMap.put(beginChar, alphabetMap.get(beginChar) + 1);
					if (alphabetMap.get(beginChar) > 0) {
						count++;
					}
				}
				if (end - begin == p.length()) {
					result.add(begin);
				}
				begin++;
			}
		}
		return result;
	}
}
