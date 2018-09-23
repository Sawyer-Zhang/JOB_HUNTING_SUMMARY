package easy;

import java.util.Stack;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum.
 * 
 * @author Zhang shaoyang
 * 
 *         2018年9月23日
 */
public class PathSum {
	private static class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	/**
	 * recursion solution
	 * 
	 * @param root
	 * @param sum
	 * @return
	 */
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null && root.val - sum == 0) {
			return true;
		}
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}
	/**
	 * dfs
	 * @param root
	 * @param sum
	 * @return
	 */
	public boolean hasPathSum1(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null) {
			return root.val == sum;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode currentNode = root;
		TreeNode temp = null;
		int result = 0;
		while (currentNode != null || !stack.isEmpty()) {
			while (currentNode != null) {
				stack.push(currentNode);
				result = result + currentNode.val;
				currentNode = currentNode.left;
			}
			currentNode = stack.peek();
			if (currentNode.left == null && currentNode.right == null && result == sum) {
				return true;
			}
			if (currentNode.right != null && temp != currentNode.right) {
				currentNode = currentNode.right;
			} else {
				temp = currentNode;
				stack.pop();
				result = result - currentNode.val;
				currentNode = null;
			}

		}
		return false;
	}
}
