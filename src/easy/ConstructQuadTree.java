package easy;

import util.QuadTreeNode;

/**
 * 
 * @description 用二维数组构建四叉树
 * 
 * @author Zhang shaoyang
 * 
 * @date 2018年12月25日
 */
public class ConstructQuadTree {
	public QuadTreeNode construct(int[][] grid) {
		return construct(grid, 0, 0, grid.length - 1, grid.length - 1);
	}

	private QuadTreeNode construct(int[][] grid, int x, int y, int rowLen, int colLen) {
		if (x > rowLen || y > colLen) {
			return null;
		}
		for (int i = x; i <= rowLen; i++) {
			for (int j = y; j <= colLen; j++) {
				if (grid[i][j] != grid[x][y]) {
					int rowMid = (x + rowLen) / 2;
					int colMid = (y + colLen) / 2;
					return new QuadTreeNode(false, false, construct(grid, x, y, rowMid, colMid),
							construct(grid, x, colMid + 1, rowMid, colLen),
							construct(grid, rowMid + 1, y, rowLen, colMid),
							construct(grid, rowMid + 1, colMid + 1, rowLen, colLen));
				}
			}
		}
		return new QuadTreeNode(grid[x][y] == 1, true, null, null, null, null);
	}
}
