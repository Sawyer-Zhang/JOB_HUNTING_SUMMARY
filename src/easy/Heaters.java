package easy;

import java.util.Arrays;

/**
 * @Description:
 * @Author: Zhang shaoyang
 * @CreateDate: 2019/1/15 0015 22:49
 */
public class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int i = 0;
        int result = 0;
        for (int house : houses) {
            while (i < heaters.length - 1 && heaters[i + 1] + heaters[i] <= house * 2) {
                i++;
            }
            result += Math.max(result, Math.abs(heaters[i] - house));
        }
        return result;
    }
}
