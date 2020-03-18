package bean;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

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

    public static BTNode createTreeByPre(Integer[] pre) {
        List<Integer> list = Arrays.asList(pre);
        return createTreeByPreRec(list.iterator());
    }

    private static BTNode createTreeByPreRec(Iterator<Integer> iterator) {
        Integer key = iterator.next();
        if (key != null) {
            BTNode node = new BTNode();
            node.setKey(key);
            node.setLeft(createTreeByPreRec(iterator));
            node.setRight(createTreeByPreRec(iterator));
            return node;
        } else {
            return null;
        }
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }
}
