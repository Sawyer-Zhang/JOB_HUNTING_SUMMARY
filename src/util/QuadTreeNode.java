package util;

/**
 * 
 * @description 四叉树结点
 * 
 * @author Zhang shaoyang
 * 
 * @date 2018年12月25日
 */
public class QuadTreeNode {
	public boolean val;
	public boolean isLeaf;
	public QuadTreeNode topLeft;
	public QuadTreeNode topRight;
	public QuadTreeNode bottomLeft;
	public QuadTreeNode bottomRight;

	public QuadTreeNode() {

	}

	public QuadTreeNode(boolean val, boolean isLeaf, QuadTreeNode topLeft, QuadTreeNode topRight,
			QuadTreeNode bottomLeft, QuadTreeNode bottomRight) {
		this.val = val;
		this.isLeaf = isLeaf;
		this.topLeft = topLeft;
		this.topRight = topRight;
		this.bottomLeft = bottomLeft;
		this.bottomRight = bottomRight;
	}
}
