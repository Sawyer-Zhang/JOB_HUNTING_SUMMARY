package easy;

/**
 * @Description:
 * @Author: Zhang shaoyang
 * @CreateDate: 2019/1/14 0014 22:14
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int count = 0;
        int result = x ^ y;//先求异或，位不同为1
        for (int i = 0; i < 32; i++) {
            count += (result >> i) & 1;//求数字中1的个数
        }
        return count;
    }
}
