package easy;

/**
 * @Description: 找涂颜色区域的边界
 * @Author: Zhang shaoyang
 * @CreateDate: 2019/1/15 0015 22:45
 */
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int count = 0;
        int neightorhoods = 0;
        if (grid.length == 0) {
            return 0;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    if (i < grid.length - 1 && grid[i + 1][j] == 1)
                        neightorhoods++;
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1)
                        neightorhoods++;
                }
            }
        }
        return count * 4 - neightorhoods * 2;
    }
}
