package easy;

import util.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as:
 * 
 * a binary tree in which the depth of the two subtrees of every node never
 * differ by more than 1.
 * 
 * @author Zhang shaoyang
 * 
 *         2018年9月9日
 */
public class BalancedBinaryTree {

	/**
	 * 递归法使用深度优先遍历
	 * 
	 * @param root
	 * @return
	 */
	public boolean isBalanced(TreeNode root) {
		return isBalancedTree(root) != -1;
	}

	private int isBalancedTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = isBalancedTree(root.getLeft());
		if (leftHeight == -1) {
			return -1;
		}
		int rightHeight = isBalancedTree(root.getRight());
		if (rightHeight == -1) {
			return -1;
		}
		if (Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		}
		return Math.max(leftHeight, rightHeight) + 1;
	}
}
