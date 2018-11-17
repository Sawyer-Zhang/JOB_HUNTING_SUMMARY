package easy;

import java.util.LinkedList;

import util.TreeNode;

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
			if (currentp.getVal() != currentq.getVal()) {
				return false;
			}
			if (currentp.getLeft() != null && currentq.getLeft() != null) {
				queue1.offer(currentp.getLeft());
				queue2.offer(currentq.getLeft());
			} else if (currentp.getLeft() == null && currentq.getLeft() == null) {

			} else {
				return false;
			}
			if (currentp.getRight() != null && currentq.getRight() != null) {
				queue1.offer(currentp.getRight());
				queue2.offer(currentq.getRight());
			} else if (currentp.getRight() == null && currentq.getRight() == null) {

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
		if (p.getVal() == q.getVal()) {
			return isSameTree(p.getLeft(), q.getLeft()) && isSameTree(p.getRight(), q.getRight());
		}
		return false;
	}
}
