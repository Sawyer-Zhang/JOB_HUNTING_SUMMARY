package easy;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the root
 * node down to the farthest leaf node.
 * 
 * @author Zhang shaoyang
 * 
 *         2018年8月20日
 */
public class MaximumDepthofBinaryTree {
	private static class TreeNode{
		private int val;
		private TreeNode left;
		private TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	/**
	 * dfs使用stack
	 * @param node
	 * @return
	 */
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Stack<TreeNode> stack = new Stack<>();
		Stack<Integer> value = new Stack<>();
		int max = 0;
		stack.push(root);
		value.push(1);
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			int temp = value.pop();
			max = Math.max(max, temp);
			if (node.left != null) {
				stack.push(node.left);
				value.push(temp + 1);
			}
			if (node.right != null) {
				stack.push(node.right);
				value.push(temp + 1);
			}
		}
		return max;
	}
	/**
	 * bfs使用队列来实现
	 * @param root
	 * @return
	 */
	public int maxDepth1(TreeNode root) {
		if (root == null) {
			return 0;
		}
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int result = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-- > 0) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			result++;
		}
		return result;
	}
	/**
	 * 递归实现
	 * @param root
	 * @return
	 */
	public int maxDepth2(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(maxDepth2(root.left), maxDepth2(root.right));
	}
}
