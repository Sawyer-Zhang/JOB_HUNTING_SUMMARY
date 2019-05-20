package easy;

import util.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Description: The maximum depth is the
 * number of nodes along the longest path from the root node down to the farthest leaf node.
 * @Author: Zhang shaoyang
 * @CreateDate: 2019/5/17 0017 11:08
 */
public class MaximumDepthOfNaryTree {
    public int maxDepth(Node root) {
        int max = 0;
        if (root == null) {
            return max;
        }
        Stack<Node> nodeStack = new Stack<>();
        Stack<Integer> integerStack = new Stack<>();
        nodeStack.push(root);
        integerStack.push(1);
        while (!nodeStack.isEmpty()) {
            Node node = nodeStack.pop();
            int temp = integerStack.pop();
            max = Math.max(max, temp);
            for (Node subNode : node.getChildren()) {
                nodeStack.push(subNode);
                integerStack.push(temp + 1);
            }
        }
        return max;
    }

    public int maxDepth1(Node root) {
        int max = 0;
        if (root == null) {
            return max;
        }
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            while (size-- > 0) {
                for (Node node : root.getChildren()) {
                    nodeQueue.offer(node);
                }
            }
            max++;
        }
        return max;
    }
}
