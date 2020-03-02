package question36;

import bean.BTNode;

// 输入一棵二叉搜索树，将该二叉搜索树转换成排序的双向链表，不能创建新结点，只能调整树中结点的指针
public class Solution {
    private static class Node {
        BTNode key;

        public BTNode getKey() {
            return key;
        }

        public void setKey(BTNode key) {
            this.key = key;
        }
    }
    static BTNode solute(BTNode tree) {
        if (tree == null)
            return null;
        BTNode head = tree;
        while (head.getLeft() != null) {
            head = head.getLeft();
        }
        _solute(tree, new Node());
        return head;
    }

    private static void _solute(BTNode tree, Node node) {
        if (tree != null) {
            _solute(tree.getLeft(), node);
            if (node.getKey() != null) {
                node.getKey().setRight(tree);
                tree.setLeft(node.getKey());
            }
            node.setKey(tree);
            _solute(tree.getRight(), node);
        }
    }
}
