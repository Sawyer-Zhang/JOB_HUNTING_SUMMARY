package easy;

/**
 * @Description: 最长非公共子序列，如果两个字符串长度不一样，那么结果就是长度更长的字符串的长度
 * 如果两个字符串长度一致，那么判断两个字符串是否相等，如果相等的话，不存在非公共子序列，
 * 两个字符串不相同但是长度相同，答案就是字符串长度
 * @Author: Zhang shaoyang
 * @CreateDate: 2019/2/28 0028 22:21
 */
public class LongestUncommonSubsequenceI {
    public int findLUSlength(String a, String b) {
        return a.length() == b.length() ?
                a.equals(b) ? -1 : a.length() :
                a.length() > b.length() ? a.length() : b.length();
    }
}
