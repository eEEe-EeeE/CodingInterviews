package question7.solution;

import question7.bean.BiTreeNode;

/*
输入某二叉树的前序遍历和中序遍历结果，重建二叉树
 */
class Main {
    public static void main(String[] args) {
        BiTreeConstructor constructor = new BiTreeConstructor();
        int[] pre = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] in = new int[]{2, 3, 1, 5, 4, 7, 8, 6, 9};
        BiTreeNode node = constructor.consBiTreeByPreIn(pre, in);
        System.out.println("xxx");
    }
}
