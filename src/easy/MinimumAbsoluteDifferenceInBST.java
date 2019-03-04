package easy;

import util.TreeNode;

import java.util.TreeSet;

/**
 * @Description: Given a binary search tree with non-negative values,
 * find the minimum absolute difference between values of any two nodes.
 * @Author: Zhang shaoyang
 * @CreateDate: 2019/3/3 0003 15:33
 */
public class MinimumAbsoluteDifferenceInBST {

    int min = Integer.MAX_VALUE;
    Integer prev = null;
    TreeSet<Integer> set = new TreeSet<>();

    /**
     * 如果是二叉搜索树，使用这个方法
     *
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return min;
        }
        getMinimumDifference(root.getLeft());
        if (prev != null) {
            min = Math.min(min, root.getVal() - prev);
        }
        prev = root.getVal();
        getMinimumDifference(root.getRight());
        return min;
    }

    /**
     * 如果树中元素是无序的，那么可以使用下面这种方法
     *
     * @param root
     * @return
     */
    public int getMinimumDifference1(TreeNode root) {
        if (root == null) {
            return min;
        }
        if (!set.isEmpty()) {
            if (set.floor(root.getVal()) != null) {
                min = Math.min(min, Math.abs(set.floor(root.getVal()) - root.getVal()));
            }
            if (set.ceiling(root.getVal()) != null) {
                min = Math.min(min, Math.abs(set.ceiling(root.getVal()) - root.getVal()));
            }
        }
        set.add(root.getVal());
        getMinimumDifference1(root.getLeft());
        getMinimumDifference1(root.getRight());
        return min;
    }
}
