package easy;

import java.util.Stack;

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
	private static class TreeNode{
		private int val;
		private TreeNode left;
		private TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
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
		return isSymmetric(root.left , root.right);
	}
	public boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null || right == null) {
			return left == right;
		}
		if (left.val != right.val) {
			return false;
		}
		return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
	}
	/**
	 * 非递归做法，判断太多了，写着写着就绕晕了
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
		if (root.left != null) {
			if (root.right == null) {
				return false;
			}
			treeNodeStack.push(root.left);
			treeNodeStack.push(root.right);
		}else if(root.right != null){
            return false;
        }
		while(!treeNodeStack.isEmpty()) {
			if (treeNodeStack.size() % 2 != 0) {
				return false;
			}
			right = treeNodeStack.pop();
			left = treeNodeStack.pop();
			if (right.val != left.val) {
				return false;
			}
			if (left.left != null) {
				if (right.right == null) {
					return false;
				}
				treeNodeStack.push(left.left);
				treeNodeStack.push(right.right);
			}else if(right.right != null){
				return false;
			}
			
			if (left.right != null) {
				if(right.left == null) {
					return false;
				}
				treeNodeStack.push(left.right);
				treeNodeStack.push(right.left);
			}else if(right.left != null) {
				return false;
			}
		}
		return true;
	}
}
