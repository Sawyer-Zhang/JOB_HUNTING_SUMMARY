package easy;

import java.util.Stack;

import util.TreeNode;

/**
 * 
 * @description 一个二叉树，找他的叶子节点，统计左叶子节点的加和
 * 
 * @author Zhang shaoyang
 * 
 * @date 2018年12月20日
 */
public class SumOfLeftLeaves {
	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int sum = 0;
		if (root.getLeft() != null) {
			if (root.getLeft().getLeft() == null && root.getLeft().getRight() == null) {
				sum += root.getLeft().getVal();
			} else {
				sum += sumOfLeftLeaves(root.getLeft());
			}
		}
		sum += sumOfLeftLeaves(root.getRight());
		return sum;
	}

	public int sumOfLeftLeaves1(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int sum = 0;
		Stack<TreeNode> nodeStack = new Stack<TreeNode>();
		nodeStack.push(root);
		while (!nodeStack.isEmpty()) {
			TreeNode node = nodeStack.pop();
			if (node.getLeft() != null) {
				if (node.getLeft().getLeft() == null && node.getLeft().getRight() == null) {
					sum += node.getLeft().getVal();
				} else {
					nodeStack.push(node.getLeft());
				}
			}
			if (node.getRight() != null) {
				if (node.getRight().getLeft() != null || node.getRight().getRight() != null) {
					nodeStack.push(node.getRight());
				}
			}
		}
		return sum;
	}
}
