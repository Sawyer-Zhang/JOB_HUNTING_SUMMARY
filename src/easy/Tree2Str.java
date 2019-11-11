package easy;

import util.TreeNode;

/**
 * 
 * @description 二叉树转换成字符串
 * 
 * @author Zhang shaoyang
 * 
 * @date 2019年11月3日
 */
public class Tree2Str {
	public String solution(TreeNode t) {
		String result = new String();
		if (t == null) {
			return result;
		}
		result = String.valueOf(t.val);
		if (t.left == null && t.right == null) {
			return result;
		}
		String left = "(" + solution(t.left) + ")";
		String right = t.right == null ? "" : "(" + solution(t.right) + ")";
		return result + left + right;
	}
}
