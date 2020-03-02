package question7.solution;

import question7.bean.BiTreeNode;

// 前序序列和中序序列构造二叉树
// 两个问题：1.二叉树不能有重复数值的结点 2.只有当两个序列完全从流中读出才能开始构造
class BiTreeConstructor {


    BiTreeNode consBiTreeByPreIn(int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder == null || preOrder.length == 0)
            return null;
        else
            return consRecur(preOrder, inOrder, 0, 0, preOrder.length);
    }

    private BiTreeNode consRecur(int[] preOrder, int[] inOrder, int preBegin, int inBegin, int len) {
        if (len == 0)
            return null;
        int key = preOrder[preBegin];
        BiTreeNode root = new BiTreeNode(key);
        int rootIndex = inBegin;
        int leftLen = 0;
        while (key != inOrder[rootIndex]) {
            ++rootIndex;
            ++leftLen;
        }
        root.setLeft(consRecur(preOrder, inOrder, preBegin + 1, rootIndex - leftLen, leftLen));
        int rightLen = len - leftLen - 1;
        root.setRight(consRecur(preOrder, inOrder, preBegin + leftLen + 1, rootIndex + 1, rightLen));
        return root;
    }
}
