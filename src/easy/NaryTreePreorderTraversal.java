package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import util.Node;

/**
 * 
 * @description Given an n-ary tree, return the preorder traversal of its nodes'
 *              values.
 * 
 * @author Zhang shaoyang
 * 
 * @date 2019年5月28日
 */
public class NaryTreePreorderTraversal {
	public List<Integer> preorder(Node root) {
		List<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		Stack<Node> nodeStack = new Stack<Node>();
		nodeStack.push(root);
		while (!nodeStack.isEmpty()) {
			Node temp = nodeStack.pop();
			List<Node> childrenNode = temp.children;
			result.add(temp.val);
			if (!childrenNode.isEmpty()) {
				for (int i = childrenNode.size() - 1; i >= 0; i--) {
					nodeStack.push(childrenNode.get(i));
				}
			}
		}
		return result;
	}
	
	private List<Integer> recursiveResult = new ArrayList<Integer>();
	
	public List<Integer> preorder1(Node root){
		if (root == null) {
			return recursiveResult;
		}
		recursiveResult.add(root.val);
		for(Node node: root.children) {
			preorder1(node);
		}
		return recursiveResult;
	}
}
