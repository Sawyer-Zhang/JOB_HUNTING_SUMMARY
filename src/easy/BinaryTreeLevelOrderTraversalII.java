package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import util.TreeNode;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes'
 * values. (ie, from left to right, level by level from leaf to root).
 * 
 * @author Zhang shaoyang
 * 
 *         2018年8月21日
 */
public class BinaryTreeLevelOrderTraversalII {

	/**
	 * bfs
	 * 
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		if (root == null) {
			return new ArrayList<List<Integer>>();
		}
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> levelResult = new LinkedList<Integer>();
			while (size-- > 0) {
				TreeNode node = queue.poll();
				if (node.getLeft() != null) {
					queue.offer(node.getLeft());
				}
				if (node.getRight() != null) {
					queue.offer(node.getRight());
				}
				levelResult.add(node.getVal());
			}
			result.add(0, levelResult);
		}
		return result;
	}
}
