package easy;

import java.util.Stack;

/**
 * 
 * @author Zhang shaoyang
 * 
 *         2018年8月26日
 */
public class ConvertSortedArraytoBinarySearchTree {
	private static class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public TreeNode sortedArrayToBST0(int[] nums) {
		int len = nums.length;
		if (len == 0) {
			return null;
		}
		TreeNode head = new TreeNode(0);
		Stack<TreeNode> nodeStack = new Stack<TreeNode>();
		Stack<Integer> leftIndexStack = new Stack<Integer>();
		Stack<Integer> rightIndexStack = new Stack<Integer>();
		nodeStack.push(head);
		leftIndexStack.push(0);
		rightIndexStack.push(len - 1);
		while (!nodeStack.isEmpty()) {
			TreeNode currNode = nodeStack.pop();
			int left = leftIndexStack.pop();
			int right = rightIndexStack.pop();
			int mid = left + (right - left) / 2;
			currNode.val = nums[mid];
			if (left <= mid - 1) {
				currNode.left = new TreeNode(0);
				nodeStack.push(currNode.left);
				leftIndexStack.push(left);
				rightIndexStack.push(mid - 1);
			}
			if (right >= mid + 1) {
				currNode.right = new TreeNode(0);
				nodeStack.push(currNode.right);
				leftIndexStack.push(mid + 1);
				rightIndexStack.push(right);
			}
		}
		return head;
	}

	public TreeNode sortedArrayToBST1(int[] nums) {
		if (nums.length == 0) {
			return null;
		}
		return sortedArrayToBST1(nums, 0, nums.length - 1);
	}

	private TreeNode sortedArrayToBST1(int[] nums, int left, int right) {
		if (left > right) {
			return null;
		}
		int mid = (left + right) / 2;
		TreeNode head = new TreeNode(nums[mid]);
		head.left = sortedArrayToBST1(nums, left, mid - 1);
		head.right = sortedArrayToBST1(nums, mid + 1, right);
		return head;
	}
}
