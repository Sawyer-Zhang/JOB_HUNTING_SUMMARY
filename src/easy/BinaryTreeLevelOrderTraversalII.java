package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes'
 * values. (ie, from left to right, level by level from leaf to root).
 * 
 * @author Zhang shaoyang
 * 
 *         2018年8月21日
 */
public class BinaryTreeLevelOrderTraversalII {
	private static class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}
	/**
	 * bfs
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
		while(!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> levelResult = new LinkedList<Integer>();
			while(size-- > 0) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
				levelResult.add(node.val);
			}
			result.add(0, levelResult);
		}
		return result;
	}
}
