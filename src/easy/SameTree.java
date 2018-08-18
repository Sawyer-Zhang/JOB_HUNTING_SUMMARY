package easy;

import java.util.LinkedList;

/**
 * Given two binary trees, write a function to check if they are the same or
 * not.
 * 
 * Two binary trees are considered the same if they are structurally identical
 * and the nodes have the same value.
 * 
 * @author Zhang shaoyang
 * 
 *         2018年8月18日
 */
public class SameTree {
	private static class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(int value) {
			this.val = value;
		}
	}

	/**
	 * bfs广度优先遍历，非递归做法
	 * 
	 * @param p
	 * @param q
	 * @return
	 */
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null) {
			return false;
		}
		LinkedList<TreeNode> queue1 = new LinkedList<TreeNode>();
		LinkedList<TreeNode> queue2 = new LinkedList<TreeNode>();
		TreeNode currentp = null;
		TreeNode currentq = null;
		queue1.offer(p);
		queue2.offer(q);
		while (!queue1.isEmpty() && !queue2.isEmpty()) {
			currentp = queue1.poll();
			currentq = queue2.poll();
			if (currentp.val != currentq.val) {
				return false;
			}
			if (currentp.left != null && currentq.left != null) {
				queue1.offer(currentp.left);
				queue2.offer(currentq.left);
			} else if (currentp.left == null && currentq.left == null) {

			} else {
				return false;
			}
			if (currentp.right != null && currentq.right != null) {
				queue1.offer(currentp.right);
				queue2.offer(currentq.right);
			} else if (currentp.right == null && currentq.right == null) {

			} else {
				return false;
			}
		}
		if (!queue1.isEmpty() || !queue2.isEmpty()) {
			return false;
		}
		return true;
	}
	/**
	 * bfs递归实现
	 * 
	 * @param p
	 * @param q
	 * @return
	 */
	public boolean isSameTree1(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;
		if (p.val == q.val) {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
		return false;
	}
}
