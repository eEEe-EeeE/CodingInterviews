package question55;

import bean.BTNode;

public class Solution {
    // 求二叉树的深度
    static int solute(BTNode tree) {
        if (tree != null) {
            return 1 + Math.max(solute(tree.getLeft()), solute(tree.getRight()));
        } else
            return 0;
    }

    // 判断二叉树是不是平衡二叉树
    private static class Height {
        int height = 0;

        void setHeight(int height) {
            this.height = height;
        }

        int getHeight() {
            return height;
        }
    }

    static boolean solute2(BTNode tree) {
        Height h = new Height();
        boolean r = solute2Rec(tree, h);
        System.out.println(h.getHeight());
        return r;
    }

    private static boolean solute2Rec(BTNode tree, Height h) {
        if (tree != null) {
            Height leftH = new Height();
            Height rightH = new Height();
            boolean child = solute2Rec(tree.getLeft(), leftH) && solute2Rec(tree.getRight(), rightH);
            if (Math.abs(leftH.getHeight() - rightH.getHeight()) <= 1) {
                h.setHeight(Math.max(leftH.getHeight(), rightH.getHeight()) + 1);
                return child;
            } else {
                return false;
            }
        } else {
            h.setHeight(0);
            return true;
        }
    }
}
