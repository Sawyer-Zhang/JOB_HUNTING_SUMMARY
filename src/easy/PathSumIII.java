package easy;

import java.util.HashMap;
import java.util.Map;

import util.TreeNode;

/**
 * 
 * @description:You are given a binary tree in which each node contains an
 *                  integer value.
 * 
 *                  Find the number of paths that sum to a given value.
 * 
 *                  The path does not need to start or end at the root or a
 *                  leaf, but it must go downwards (traveling only from parent
 *                  nodes to child nodes).
 * 
 * @author Zhang shaoyang
 * 
 * @date 2019年1月2日
 */
public class PathSumIII {
	private int result;

	/**
	 * 解法一：使用HashMap，key为走到当前节点的和，value是对应出现的次数
	 * 花费了很多时间去理解，我们可以从叶子节点往回想,currSum=target+A，我们要求的就是A出现的值,这个A的值出现 多少次，最后求的总和就有多少个
	 * 最后的减一是防止不同的子树相互干扰
	 * 
	 * @param root
	 * @param sum
	 * @return
	 */
	public int pathSum(TreeNode root, int sum) {
		Map<Integer, Integer> currSumMap = new HashMap<Integer, Integer>();
		currSumMap.put(0, 1);
		count(root, 0, sum, currSumMap);
		return result;
	}

	private void count(TreeNode root, int currSum, int target, Map<Integer, Integer> currSumMap) {
		if (root == null)
			return;
		currSum += root.getVal();
		if (currSumMap.containsKey(currSum - target)) {
			result += currSumMap.get(currSum - target);
		}
		if (!currSumMap.containsKey(currSum)) {
			currSumMap.put(currSum, 1);
		} else {
			currSumMap.put(currSum, currSumMap.get(currSum) + 1);
		}

		count(root.getLeft(), currSum, target, currSumMap);
		count(root.getRight(), currSum, target, currSumMap);
		currSumMap.put(currSum, currSumMap.get(currSum) - 1);
	}

	public int pathSum1(TreeNode root, int sum) {
		if (root == null)
			return 0;
		return pathSumFrom(root, sum) + pathSum1(root.getLeft(), sum) + pathSum1(root.getRight(), sum);
	}

	private int pathSumFrom(TreeNode root, int sum) {
		if (root == null)
			return 0;
		return (root.getVal() == sum ? 1 : 0) + pathSumFrom(root.getLeft(), sum - root.getVal())
				+ pathSumFrom(root.getRight(), sum - root.getVal());
	}
}
