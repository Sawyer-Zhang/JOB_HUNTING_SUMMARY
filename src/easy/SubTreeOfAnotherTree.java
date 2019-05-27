package easy;

import java.util.Stack;

import util.TreeNode;

/**
 * 
 * @description Given two non-empty binary trees s and t, check whether tree t
 *              has exactly the same structure and node values with a subtree of
 *              s. A subtree of s is a tree consists of a node in s and all of
 *              this node's descendants. The tree s could also be considered as
 *              a subtree of itself.
 * 
 * @author Zhang shaoyang
 * 
 * @date 2019年5月22日
 */
public class SubTreeOfAnotherTree {
	public boolean isSubtree(TreeNode s, TreeNode t) {
		if (s == null || t == null) {
			return false;
		}
		Stack<TreeNode> nodeStack = new Stack<TreeNode>();
		nodeStack.push(s);
		while (!nodeStack.isEmpty()) {
			TreeNode node = nodeStack.pop();
			if (isSameTree(node, t)) {
				return true;
			}
			if (node.left != null) {
				nodeStack.push(node.left);
			}
			if (node.right != null) {
				nodeStack.push(node.right);
			}
		}
		return false;
	}

	private boolean isSameTree(TreeNode subTreeRoot, TreeNode root) {
		if (subTreeRoot == null && root == null) {
			return true;
		}
		if (subTreeRoot == null || root == null) {
			return false;
		}
		if (subTreeRoot.val != root.val) {
			return false;
		}
		return isSameTree(subTreeRoot.left, root.left) && isSameTree(subTreeRoot.right, root.right);
	}
}
