package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.TreeNode;

/**
 * 
 * @description
 * 
 * @author Zhang shaoyang
 * 
 * @date 2019年2月18日
 */
public class FindModeInBinarySearchTree {
	int max = 0;

	public int[] findMode(TreeNode root) {
		if (root == null) {
			return new int[0];
		}
		Map<Integer, Integer> treeNodeMap = new HashMap<Integer, Integer>();
		List<Integer> result = new ArrayList<Integer>();
		transfer(root, treeNodeMap);
		for (int key : treeNodeMap.keySet()) {
			if (max == treeNodeMap.get(key)) {
				result.add(key);
			}
		}
		int[] resultArray = new int[result.size()];
		for (int i = 0; i < resultArray.length; i++) {
			resultArray[i] = result.get(i);
		}
		return resultArray;
	}

	private void transfer(TreeNode root, Map<Integer, Integer> treeNodeMap) {
		if (root.getLeft() != null) {
			transfer(root.getLeft(), treeNodeMap);
		}
		treeNodeMap.put(root.getVal(), treeNodeMap.getOrDefault(root.getVal(), 0) + 1);
		max = Math.max(max, treeNodeMap.get(root.getVal()));
		if (root.getRight() != null) {
			transfer(root.getRight(), treeNodeMap);
		}
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(2);
		t1.setRight(t2);
		t2.setLeft(t3);
		FindModeInBinarySearchTree fd = new FindModeInBinarySearchTree();
		int[] result = fd.findMode(t1);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
