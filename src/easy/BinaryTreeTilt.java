package easy;

import util.TreeNode;

/**
 * @Description: Input:
 * 1
 * /   \
 * 2     3
 * Output: 1
 * Explanation:
 * Tilt of node 2 : 0
 * Tilt of node 3 : 0
 * Tilt of node 1 : |2-3| = 1
 * Tilt of binary tree : 0 + 0 + 1 = 1
 * @Author: Zhang shaoyang
 * @CreateDate: 2019/5/19 0019 22:18
 */
public class BinaryTreeTilt {
    private int result = 0;

    public int findTilt(TreeNode root) {

        postOrder(root);
        return result;
    }

    private int postOrder(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        result += Math.abs(left - right);

        return root.val + left + right;
    }
}
