package easy;

/**
 * 
 * @description 翻转string里面出现的元音
 * 
 * @author Zhang shaoyang
 * 
 * @date 2018年12月14日
 */
public class ReverseVowelsOfAString {
	public String reverseVowels(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		String vowels = "aeiouAEIOU";
		char[] reverseVowels = s.toCharArray();
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			if (!vowels.contains(reverseVowels[start] + "")) {
				start++;
				continue;
			}
			if (!vowels.contains(reverseVowels[end] + "")) {
				end--;
				continue;
			}
			char temp = reverseVowels[end];
			reverseVowels[end] = reverseVowels[start];
			reverseVowels[start] = temp;
			start++;
			end--;
		}
		return String.valueOf(reverseVowels);
	}
}
