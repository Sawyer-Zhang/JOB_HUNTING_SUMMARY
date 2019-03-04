package easy;

import util.TreeNode;

import java.util.Stack;

/**
 * @Description: Given a Binary Search Tree (BST),
 * convert it to a Greater Tree
 * such that every key of the original BST is changed to the original key plus sum of
 * all keys greater than the original key in BST.
 * @Author: Zhang shaoyang
 * @CreateDate: 2019/3/3 0003 23:29
 */
public class ConvertBSTToGreaterTree {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }

    private void convert(TreeNode root) {
        if (root == null) {
            return;
        }
        convert(root.getRight());
        root.setVal(root.getVal() + sum);
        sum = root.getVal();
        convert(root.getLeft());
    }

    public TreeNode convertBST1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.getRight();
            }
            cur = stack.pop();
            cur.setVal(cur.getVal() + sum);
            sum = cur.getVal();
            cur = cur.getLeft();
        }
        return root;
    }
}
