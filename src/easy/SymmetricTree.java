package easy;

import java.util.Stack;

import util.TreeNode;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric
 * around its center).
 * 
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * 
 * @author Zhang shaoyang
 * 
 *         2018年8月19日
 */
public class SymmetricTree {
	/**
	 * 递归实现，每次解题都想不起来用
	 * 
	 * @param root
	 * @return
	 */
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isSymmetric(root.getLeft(), root.getRight());
	}

	public boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null || right == null) {
			return left == right;
		}
		if (left.getVal() != right.getVal()) {
			return false;
		}
		return isSymmetric(left.getLeft(), right.getRight()) && isSymmetric(left.getRight(), right.getLeft());
	}

	/**
	 * 非递归做法，判断太多了，写着写着就绕晕了
	 * 
	 * @param root
	 * @return
	 */
	public boolean isSymmetricSecond(TreeNode root) {
		if (root == null) {
			return true;
		}
		TreeNode left;
		TreeNode right;
		Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
		if (root.getLeft() != null) {
			if (root.getRight() == null) {
				return false;
			}
			treeNodeStack.push(root.getLeft());
			treeNodeStack.push(root.getRight());
		} else if (root.getRight() != null) {
			return false;
		}
		while (!treeNodeStack.isEmpty()) {
			if (treeNodeStack.size() % 2 != 0) {
				return false;
			}
			right = treeNodeStack.pop();
			left = treeNodeStack.pop();
			if (right.getVal() != left.getVal()) {
				return false;
			}
			if (left.getLeft() != null) {
				if (right.getRight() == null) {
					return false;
				}
				treeNodeStack.push(left.getLeft());
				treeNodeStack.push(right.getRight());
			} else if (right.getRight() != null) {
				return false;
			}

			if (left.getRight() != null) {
				if (right.getLeft() == null) {
					return false;
				}
				treeNodeStack.push(left.getRight());
				treeNodeStack.push(right.getLeft());
			} else if (right.getLeft() != null) {
				return false;
			}
		}
		return true;
	}
}
