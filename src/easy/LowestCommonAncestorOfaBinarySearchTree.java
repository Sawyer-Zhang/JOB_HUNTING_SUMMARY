package easy;

import util.TreeNode;

/**
 * 
 * @description Given a binary search tree (BST), find the lowest common
 *              ancestor (LCA) of two given nodes in the BST.
 * 
 * @author Zhang shaoyang
 * 
 * @date 2018年12月9日
 */
public class LowestCommonAncestorOfaBinarySearchTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root.getVal() > Math.max(p.getVal(), q.getVal())) {
			return lowestCommonAncestor(root.getLeft(), p, q);
		}
		if (root.getVal() < Math.min(p.getVal(), q.getVal())) {
			return lowestCommonAncestor(root.getRight(), p, q);
		}
		return root;
	}
	
	public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root.getVal() == p.getVal() || root.getVal() == q.getVal()) {
			return root;
		}
		TreeNode left = lowestCommonAncestor1(root.getLeft(), p, q);
		TreeNode right = lowestCommonAncestor1(root.getRight(), p, q);
		if(left != null && right != null) {
			return root;
		}
		return left == null ? right :left;
	}
}
