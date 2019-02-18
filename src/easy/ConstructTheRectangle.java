package easy;

/**
 * @Description: 找整数长和宽，要求两个值的差距最小
 * @Author: Zhang shaoyang
 * @CreateDate: 2019/1/22 0022 23:18
 */
public class ConstructTheRectangle {
    public int[] constructRectangle(int area) {
        int sqrt = (int) Math.sqrt(area);
        while (area % sqrt != 0) sqrt--;
        return new int[]{area / sqrt, sqrt};
    }
}
