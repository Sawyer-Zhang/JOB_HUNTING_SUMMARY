package easy;

/**
 * @Description: Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * @Author: Zhang shaoyang
 * @CreateDate: 2019/3/14 0014 22:48
 */
public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        if (s.length() == 0 || s == null) {
            return result.toString();
        }
        String[] words = s.split(" ");
        for (String word : words) {
            int start = 0;
            int end = word.length() - 1;
            char[] revWord = word.toCharArray();
            while (start < end) {
                char temp = revWord[start];
                revWord[start++] = revWord[end];
                revWord[end--] = temp;
            }
            result.append(String.valueOf(revWord) + " ");
        }
        return result.toString().substring(0, result.length()-2);
    }
}
