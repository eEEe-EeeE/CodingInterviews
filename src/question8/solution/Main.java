package question8.solution;

import question8.bean.BiTreeNode;

/*
给定二叉树和一个结点的地址，找出该结点在中序遍历序列中的下一个结点
 */
public class Main {
    public static void main(String[] args) {
        NodeFinder finder = new NodeFinder();
        int[] a = new int[]{1, 2, 3, -1, -1, 4, 5, -1, -1, 6, -1, -1, 7, -1, -1, -1};
        BiTreeNode node = finder.initBiTree(a);
        System.out.println(finder.findNextNode(node.getRight()) == null);
    }
}
