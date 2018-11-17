package easy;

import java.util.Stack;

import util.TreeNode;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum.
 * 
 * @author Zhang shaoyang
 * 
 *         2018年9月23日
 */
public class PathSum {

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
		if (root.getLeft() == null && root.getRight() == null && root.getVal() - sum == 0) {
			return true;
		}
		return hasPathSum(root.getLeft(), sum - root.getVal()) || hasPathSum(root.getRight(), sum - root.getVal());
	}

	/**
	 * dfs
	 * 
	 * @param root
	 * @param sum
	 * @return
	 */
	public boolean hasPathSum1(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		if (root.getLeft() == null && root.getRight() == null) {
			return root.getVal() == sum;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode currentNode = root;
		TreeNode temp = null;
		int result = 0;
		while (currentNode != null || !stack.isEmpty()) {
			while (currentNode != null) {
				stack.push(currentNode);
				result = result + currentNode.getVal();
				currentNode = currentNode.getLeft();
			}
			currentNode = stack.peek();
			if (currentNode.getLeft() == null && currentNode.getRight() == null && result == sum) {
				return true;
			}
			if (currentNode.getRight() != null && temp != currentNode.getRight()) {
				currentNode = currentNode.getRight();
			} else {
				temp = currentNode;
				stack.pop();
				result = result - currentNode.getVal();
				currentNode = null;
			}

		}
		return false;
	}
}
