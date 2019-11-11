package util;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 树结点工具类
 * 
 * @author Zhang shaoyang
 * 
 *         2018年11月17日
 */
public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int val) {
		this.val = val;
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public static TreeNode getSimpleTree() {
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		root.setLeft(node1);
		root.setRight(node2);
		node1.setLeft(node3);
		return root;
	}

	/**
	 * 使用层次遍历打印树节点
	 */
	public static String toString(TreeNode root) {
		StringBuilder result = new StringBuilder();
		if (root == null) {
			return result.toString();
		}
		Queue<TreeNode> treeNodeQueue = new LinkedList<TreeNode>();
		treeNodeQueue.add(root);
		while (!treeNodeQueue.isEmpty()) {
			TreeNode temp = treeNodeQueue.poll();
			if (temp.left != null) {
				treeNodeQueue.add(temp.left);
			}
			if (temp.right != null) {
				treeNodeQueue.add(temp.right);
			}
			result.append(temp.val);
		}
		return result.toString();
	}
}
