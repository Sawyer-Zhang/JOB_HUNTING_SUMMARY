package easy;

/**
 * @Description: Given n, find the total number of full staircase rows that can be formed.
 * @Author: Zhang shaoyang
 * @CreateDate: 2019/1/6 0006 15:59
 */
public class ArrangingCoins {
    public int arrangeCoins(int n) {
        if (n == 1) {
            return 1;
        }
        int row = n;
        for (int i = 1; i <= row; i++) {
            if (n < i) {
                return i - 1;
            }
            n -= i;
        }
        return 0;
    }

    public int arrangeCoins1(int n) {
        int i = 0;
        while (n > 0) {
            i += 1;
            n -= i;
        }
        return n == 0 ? i : i - 1;
    }
}
