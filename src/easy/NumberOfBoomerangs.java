package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Description: Given n points in the plane that are all pairwise distinct,
 * a "boomerang" is a tuple of points (i, j, k) such that
 * the distance between i and j equals the distance between i and k (the order of the tuple matters).
 * @Author: Zhang shaoyang
 * @CreateDate: 2019/1/6 0006 21:49
 */
public class NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        if (points.length < 3) {
            return result;
        }
        Map<Integer, Integer> countMap = new HashMap<>();//key是距离的平方，value是出现的次数
        for (int j = 0; j < points.length; j++) {
            for (int i = 0; i < points.length; i++) {
                if (j == i) continue;
                int distance = getDistance(points[j], points[i]);
                countMap.put(distance, countMap.getOrDefault(distance, 0) + 1);
            }
            for (int count : countMap.values()) {
                result = result + count * (count - 1);
            }
            countMap.clear();
        }
        return result;
    }

    private int getDistance(int[] a, int[] b) {
        int x = b[0] - a[0];
        int y = b[1] - a[1];
        return x * x + y * y;
    }
}
