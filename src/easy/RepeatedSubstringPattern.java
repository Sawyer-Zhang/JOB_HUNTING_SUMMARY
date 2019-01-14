package easy;

/**
 * @Description: Input: "abab"
 * Output: True
 * Input: "aba"
 * Output: False
 * @Author: Zhang shaoyang
 * @CreateDate: 2019/1/14 0014 21:45
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        if (len == 0 || s == null) {
            return false;
        }
        for (int i = len / 2; i >= 1; i--) {
            if (len % i == 0) {
                int time = len / i;
                String repeatedString = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < time; j++) {
                    sb.append(repeatedString);
                }
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }
}
