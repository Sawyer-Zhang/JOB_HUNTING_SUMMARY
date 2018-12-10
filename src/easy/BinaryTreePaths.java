package easy;

import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

/**
 * 
 * @description Output: ["1->2->5", "1->3"]
 * 
 *              Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 * 
 * @author Zhang shaoyang
 * 
 * @date 2018年12月10日
 */
public class BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<String>();
		if (root == null)
			return result;
		binaryTreePaths(root, "", result);
		return result;
	}
	/*
	 * 	理解一下String传递引用会造成什么后果，和使用StringBuilder的方法做一个对比
	 */
	private void binaryTreePaths(TreeNode node, String path, List<String> result) {
		if (node.getLeft() == null && node.getRight() == null) {
			result.add(path + node.getVal());
			return;
		}
		if (node.getLeft() != null) {
			binaryTreePaths(node.getLeft(), path + node.getVal() + "->", result);
		}
		if (node.getRight() != null) {
			binaryTreePaths(node.getRight(), path + node.getVal() + "->", result);
		}
	}

	public List<String> binaryTreePaths1(TreeNode root) {
		List<String> result = new ArrayList<String>();
		if (root == null)
			return result;
		StringBuilder path = new StringBuilder();
		binaryTreePaths1(root, path, result);
		return result;
	}

	private void binaryTreePaths1(TreeNode node, StringBuilder path, List<String> result) {
		if (node.getLeft() == null && node.getRight() == null) {
			path.append(node.getVal());
			result.add(path.toString());
			return;
		}
		if (node.getLeft() != null) {
			String prevPath = path.toString();
			path.append(node.getVal() + "->");
			binaryTreePaths1(node.getLeft(), path, result);
			path = new StringBuilder(prevPath);
		}
		if (node.getRight() != null) {
			path.append(node.getVal() + "->");
			binaryTreePaths1(node.getRight(), path, result);
		}
	}
}
