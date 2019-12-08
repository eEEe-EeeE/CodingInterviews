package question8.bean;

public class BiTreeNode {
    // key >= 0
    private int key;
    private BiTreeNode parent;
    private BiTreeNode left;
    private BiTreeNode right;

    public BiTreeNode(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public BiTreeNode getParent() {
        return parent;
    }

    public void setParent(BiTreeNode parent) {
        this.parent = parent;
    }

    public BiTreeNode getLeft() {
        return left;
    }

    public void setLeft(BiTreeNode left) {
        this.left = left;
    }

    public BiTreeNode getRight() {
        return right;
    }

    public void setRight(BiTreeNode right) {
        this.right = right;
    }
}
