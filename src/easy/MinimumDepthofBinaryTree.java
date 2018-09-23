package easy;

import java.util.LinkedList;

/**
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
 * 
 * @author Zhang shaoyang
 * 
 *         2018年9月19日
 */
public class MinimumDepthofBinaryTree {
	private static class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	/**
	 * 递归实现
	 * 
	 * @param root
	 * @return
	 */
	public int minDepth0(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null || root.right == null) {
			return 1 + Math.max(minDepth0(root.left), minDepth0(root.right));
		}
		return 1 + Math.min(minDepth0(root.left), minDepth0(root.right));
	}
	/**
	 * bfs
	 * @param root
	 * @return
	 */
	public int minDepth1(TreeNode root) {
        if(root == null){
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        int depth = 1;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                TreeNode temp = queue.poll();
                if(temp.left == null && temp.right == null){
                    return depth;
                }
                if(temp.left != null){
                    queue.offer(temp.left);
                }
                if(temp.right != null){
                    queue.offer(temp.right);
                }
            }
            depth++;
        }
        return depth;
    }

}
