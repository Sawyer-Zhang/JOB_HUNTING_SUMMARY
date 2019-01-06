package easy;

import util.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description: Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * @Author: Zhang shaoyang
 * @CreateDate: 2018/12/27 0027 22:28
 */
public class NaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> levelNode = new LinkedList<>();
        levelNode.offer(root);
        while (!levelNode.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            int len = levelNode.size();
            for (int i = 0; i < len; i++) {
                Node node = levelNode.poll();
                level.add(node.getVal());
                levelNode.addAll(node.getChildren());
            }
            result.add(level);
        }
        return result;
    }
}
