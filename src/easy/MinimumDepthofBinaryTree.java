package easy;

import java.util.LinkedList;

import util.TreeNode;

/**
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
 * 
 * @author Zhang shaoyang
 * 
 *         2018年9月19日
 */
public class MinimumDepthofBinaryTree {

	/**
	 * 递归实现
	 * 
	 * @param root
	 * @return
	 */
	public int minDepth0(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.getLeft() == null || root.getRight() == null) {
			return 1 + Math.max(minDepth0(root.getLeft()), minDepth0(root.getRight()));
		}
		return 1 + Math.min(minDepth0(root.getLeft()), minDepth0(root.getRight()));
	}

	/**
	 * bfs
	 * 
	 * @param root
	 * @return
	 */
	public int minDepth1(TreeNode root) {
		if (root == null) {
			return 0;
		}
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		int depth = 1;
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				TreeNode temp = queue.poll();
				if (temp.getLeft() == null && temp.getRight() == null) {
					return depth;
				}
				if (temp.getLeft() != null) {
					queue.offer(temp.getLeft());
				}
				if (temp.getRight() != null) {
					queue.offer(temp.getRight());
				}
			}
			depth++;
		}
		return depth;
	}

}
