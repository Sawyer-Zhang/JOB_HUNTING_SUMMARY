package easy;

/**
 * @Description: Given a string and an integer k,
 * you need to reverse the first k characters for every 2k characters counting from the start of the string.
 * If there are less than k characters left, reverse all of them.
 * If there are less than 2k but greater than or equal to k characters,
 * then reverse the first k characters and left the other as original.
 * @Author: Zhang shaoyang
 * @CreateDate: 2019/3/4 0004 21:55
 */
public class ReverseStringII {
    public String reverseStr(String s, int k) {
        if (s == null || k == 0 || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i += 2 * k) {
            int start = i;
            int end = Math.min(i + k - 1, len - 1);//如果翻转的字符串长度不足，取值到最后一位，避免出现ArrayIndexOutOfBoundsException
            while (start < end) {
                char temp = chars[start];
                chars[start++] = chars[end];
                chars[end--] = temp;
            }
        }
        return String.valueOf(chars);
    }
}
