package easy;

/**
 * @Description: ["a","a","b","b","c","c","c"]
 * Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
 * @Author: Zhang shaoyang
 * @CreateDate: 2019/1/6 0006 20:02
 */
public class StringCompress {
    public int compress(char[] chars) {
        if (chars.length == 0 || chars == null) {
            return 0;
        }
        int index = 0;
        int resultIndex = 0;
        while (index < chars.length) {
            char currChar = chars[index];
            int count = 0;
            while (index < chars.length && chars[index] == currChar) {
                count++;
                index++;
            }
            chars[resultIndex++] = currChar;
            if (count != 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[resultIndex++] = c;
                }
            }
        }
        return resultIndex;
    }
}
