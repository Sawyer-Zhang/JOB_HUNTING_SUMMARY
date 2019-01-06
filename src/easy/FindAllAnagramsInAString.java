package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @description:Given a string s and a non-empty string p, find all the start
 *                    indices of p's anagrams in s.
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
		 * 外层while循环的目的是找出第一次出现全部子串中字符的终止为止，说明起点到end指针指向的位置中可能出现 子串。count其实就是记录子串的字符个数
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
			 * 内层while循环主要的目的首先是找到第一次出现子串中字符的位置，之后恢复计数器 判断end-begin之间是不是和子串长度相同，如果相同就是其中一个解
			 * 只要找到其中一个字符就会退出循环，因为这时候两个指针中剩余的字符不足以组成一个子串的逆序，需要 到外层循环中继续遍历
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
