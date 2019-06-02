package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import util.Node;

/**
 * 
 * @description Given an n-ary tree, return the postorder traversal of its
 *              nodes' values.
 * 
 * @author Zhang shaoyang
 * 
 * @date 2019年5月28日
 */
public class NaryTreePostorderTraversal {
	public List<Integer> postorder(Node root) {
		List<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		Stack<Node> nodeStack = new Stack<Node>();
		nodeStack.push(root);
		while (!nodeStack.isEmpty()) {
			Node temp = nodeStack.pop();
			result.add(temp.val);
			List<Node> childrenNode = temp.children;
			for (Node node : childrenNode) {
				nodeStack.push(node);
			}
		}
		Collections.reverse(result);
		return result;
	}

	private List<Integer> recursiveResult = new ArrayList<Integer>();

	public List<Integer> postorderByRecursive(Node root) {
		if (root == null) {
			return recursiveResult;
		}
		for (Node node : root.children) {
			postorderByRecursive(node);
		}
		recursiveResult.add(root.val);
		return recursiveResult;
	}
}
