package util;

import java.util.List;

/**
 * @Description: 有一些特殊的树状结点
 * @Author: Zhang shaoyang
 * @CreateDate: 2018/12/27 0027 22:34
 */
public class Node {
    private int val;
    private List<Node> children;

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }
}
