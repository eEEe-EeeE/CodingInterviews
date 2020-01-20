package question27;

import bean.BTNode;

// 生成一棵树的镜像
public class Solution {
    static BTNode solute(BTNode tree) {
        if (tree != null) {
            BTNode root = new BTNode();
            root.setKey(tree.getKey());
            root.setLeft(solute(tree.getRight()));
            root.setRight(solute(tree.getLeft()));
            return root;
        } else
            return null;
    }
}
