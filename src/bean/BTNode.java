package bean;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;

public class BTNode {
    private Integer key;
    private BTNode left;
    private BTNode right;

    public BTNode() {
    }

    public BTNode(Integer key, BTNode left, BTNode right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public BTNode getLeft() {
        return left;
    }

    public void setLeft(BTNode left) {
        this.left = left;
    }

    public BTNode getRight() {
        return right;
    }

    public void setRight(BTNode right) {
        this.right = right;
    }

    static public BTNode createTreeByPre(Integer[] pre) {
        preIndex = 0;
        return _createTreeByPre(pre);
    }

    static private Integer preIndex;

    static private BTNode _createTreeByPre(Integer[] pre) {
        if (pre[preIndex] != null) {
            BTNode tree = new BTNode();
            tree.setKey(pre[preIndex++]);
            tree.setLeft(_createTreeByPre(pre));
            tree.setRight(_createTreeByPre(pre));
            return tree;
        } else {
            ++preIndex;
            return null;
        }
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }
}
