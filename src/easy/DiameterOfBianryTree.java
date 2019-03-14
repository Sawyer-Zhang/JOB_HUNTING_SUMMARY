package easy;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Description: Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 * @Author: Zhang shaoyang
 * @CreateDate: 2019/3/4 0004 22:35
 */
public class DiameterOfBianryTree {

    private static int max = 0;

    /**
     * 解题思路：找出一个二叉树中任意两个结点的最长路径，这条路径上可以包含根节点也可以不包含根节点
     * dfs深度优先遍历
     * 对于任意一个结点来说，经过它自身的最大长度是它的左子树的最大深度加上它的右子树的最大深度，但是它并非是
     * 全局的最长路径，维护一个全局变量比较经过每一个结点的最长路径
     *
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.getLeft());
        int right = maxDepth(root.getRight());

        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }

    /**
     * 用类似中序遍历的方法来进行结点的遍历
     * 记录该结点作为根节点时经过自身的最长路径和该结点作为子节点时经过自身的最大长度
     * @param root
     * @return
     */
    public int diameterOfBinaryTree1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = 0;
        Stack<TreeNode> nodeStack = new Stack<>();
        Map<TreeNode, Integer> nodePathMaxLen = new HashMap<>();
        nodeStack.push(root);
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.peek();
            if (node.getLeft() != null && !nodePathMaxLen.containsKey(node.getLeft())) {
                nodeStack.push(node.getLeft());
            } else if (node.getRight() != null && !nodePathMaxLen.containsKey(node.getRight())) {
                nodeStack.push(node.getRight());
            } else {
                node = nodeStack.pop();
                int leftMax = nodePathMaxLen.getOrDefault(node.getLeft(), 0);
                int rightMax = nodePathMaxLen.getOrDefault(node.getRight(), 0);
                nodePathMaxLen.put(node, 1 + Math.max(leftMax, rightMax));
                max = Math.max(max, leftMax + rightMax);
            }
        }
        return max;
    }
}
