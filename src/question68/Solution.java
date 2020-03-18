package question68;

import bean.BTNode;
import bean.LNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    // 求树中两个结点的最低公共祖先
    // 这里简化为二叉树
    static BTNode solute(BTNode tree, int x, int y) {
        if (tree == null)
            return null;
        Deque<BTNode> pathX = new LinkedList<>();
        Deque<BTNode> pathY = new LinkedList<>();
        getNodePath(tree, x, pathX);
        getNodePath(tree, y, pathY);
        return getLastCommonNode(pathX, pathY);
    }

    private static boolean getNodePath(BTNode root, int key, Deque<BTNode> path) {
        if (root == null)
            return false;
        if (root.getKey() == key)
            return true;
        path.offerLast(root);
        boolean childFound;
        childFound = getNodePath(root.getLeft(), key, path);
        if (!childFound)
            childFound = getNodePath(root.getRight(), key, path);
        if (!childFound) {
            path.pollLast();
            return false;
        }
        return true;
    }

    private static BTNode getLastCommonNode(Deque<BTNode> l1, Deque<BTNode> l2) {
        if (l1.isEmpty() || l2.isEmpty())
            return null;
        BTNode common = null;
        BTNode b1;
        BTNode b2;
        while (!l1.isEmpty() && !l2.isEmpty()) {
            b1 = l1.pollFirst();
            b2 = l2.pollFirst();
            if (b1 == b2)
                common = b1;
            else
                break;
        }
        return common;
    }
}
