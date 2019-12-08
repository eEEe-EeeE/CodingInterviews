package question8.solution;

import question8.bean.BiTreeNode;

public class NodeFinder {
    BiTreeNode findNextNode(BiTreeNode node) {
        if (node == null)
            return null;
        BiTreeNode root = node.getRight();
        if (root != null) {
            while (root.getLeft() != null) {
                root = root.getLeft();
            }
            return root;
        } else {
            root = node;
            // root代表的树已访问完
            while (root.getParent() != null) {
                if (root.getParent().getLeft() == root) {
                    return root.getParent();
                } else {
                    root = root.getParent();
                }
            }
            return null;
        }
    }

    BiTreeNode initBiTree(int[] a) {
        if (a == null || a.length == 0)
            return null;

        PreOrder order = new PreOrder();
        order.index = 0;
        order.seq = a;

        return consTreeByPre(order, null);

    }

    private static class PreOrder {
        int[] seq;
        int index;
    }

    private BiTreeNode consTreeByPre(PreOrder order, BiTreeNode parent) {
        if (order.index == order.seq.length)
            return null;

        BiTreeNode root;
        int key = order.seq[order.index++];
        if (key == -1) {
            root = null;
        } else {
            root = new BiTreeNode(key);
            root.setLeft(consTreeByPre(order, root));
            root.setRight(consTreeByPre(order, root));
        }
        if (root != null)
            root.setParent(parent);
        return root;
    }
}
