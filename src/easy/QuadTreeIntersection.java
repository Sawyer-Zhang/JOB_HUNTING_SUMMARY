package easy;

import util.QuadTreeNode;

/**
 * @Description: Your task is to implement a function that will take two quadtrees and
 * return a quadtree that represents the logical OR (or union) of the two trees
 * @Author: Zhang shaoyang
 * @CreateDate: 2019/4/8 0008 19:31
 */
public class QuadTreeIntersection {
    public QuadTreeNode intersect(QuadTreeNode quadTree1, QuadTreeNode quadTree2) {
        if (quadTree1.isLeaf) {
            return quadTree1.val ? quadTree1 : quadTree2;
        }
        if (quadTree2.isLeaf) {
            return quadTree2.val ? quadTree2 : quadTree1;
        }

        quadTree1.topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
        quadTree1.topRight = intersect(quadTree1.topRight, quadTree2.topRight);
        quadTree1.bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        quadTree1.bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);

        if (quadTree1.topLeft.isLeaf && quadTree1.topRight.isLeaf && quadTree1.bottomRight.isLeaf
                && quadTree1.bottomLeft.isLeaf && quadTree1.topLeft.val == quadTree1.topRight.val &&
                quadTree1.topRight.val == quadTree1.bottomLeft.val && quadTree1.bottomLeft.val == quadTree1.bottomRight.val) {
            quadTree1.isLeaf = true;
            quadTree1.val = quadTree1.topLeft.val;
        }
        return quadTree1;
    }
}