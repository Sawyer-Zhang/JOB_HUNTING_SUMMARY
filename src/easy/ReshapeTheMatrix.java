package easy;

/**
 * @Description: Input:
 * nums =
 * [[1,2],
 * [3,4]]
 * r = 1, c = 4
 * Output:
 * [[1,2,3,4]]
 * Explanation:
 * The row-traversing of nums is [1,2,3,4].
 * The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.
 * @Author: Zhang shaoyang
 * @CreateDate: 2019/5/20 0020 15:07
 */
public class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null) {
            return null;
        }
        int row = nums.length;
        int column = nums[0].length;
        if (row * column != r * c) {
            return nums;
        }
        int result[][] = new int[r][c];
        for (int i = 0; i < r * c; i++) {
            result[i / c][i % c] = nums[i / column][i % column];
        }
        return result;
    }
}
