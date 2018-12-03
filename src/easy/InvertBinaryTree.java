package easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import util.TreeNode;

/**
 * 
 * @description 翻转一个二叉树
 * 
 * @author Zhang shaoyang
 * 
 * @date 2018年12月3日
 */
public class InvertBinaryTree {
	/*
	 * recursive
	 */
	public TreeNode invertTree0(TreeNode root) {
		if (root == null)
			return null;
		TreeNode left = root.getLeft();
		TreeNode right = root.getRight();
		root.setLeft(invertTree0(right));
		root.setRight(invertTree0(left));
		return root;
	}

	/*
	 * dfs
	 */
	public TreeNode invertTree1(TreeNode root) {
		if (root == null)
			return null;
		Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
		treeNodeStack.push(root);
		while (!treeNodeStack.isEmpty()) {
			TreeNode node = treeNodeStack.pop();
			TreeNode left = node.getLeft();
			TreeNode right = node.getRight();
			node.setLeft(right);
			node.setRight(left);
			if (right != null) {
				treeNodeStack.push(right);
			}
			if (left != null) {
				treeNodeStack.push(left);
			}
		}
		return root;
	}

	/*
	 * bfs
	 */
	public TreeNode invertTree2(TreeNode root) {
		if(root == null) return null;
		Queue<TreeNode> treeNodeQueue = new LinkedList<TreeNode>();
		treeNodeQueue.offer(root);
		while(!treeNodeQueue.isEmpty()) {
			TreeNode node = treeNodeQueue.poll();
			TreeNode left = node.getLeft();
			TreeNode right = node.getRight();
			node.setLeft(right);
			node.setRight(left);
			if(left != null) {
				treeNodeQueue.offer(left);
			}
			if(right != null) {
				treeNodeQueue.offer(right);
			}
		}
		return root;
	}
}
