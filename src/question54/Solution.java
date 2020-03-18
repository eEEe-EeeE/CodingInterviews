package question54;

import bean.BTNode;

public class Solution {
    private static class Count {
        int cnt = 0;
        void increase() {
            ++cnt;
        }
        void decrease() {
            --cnt;
        }
        int getCnt() {
            return cnt;
        }
    }
    static BTNode solute(BTNode tree, int k) {
        if (tree == null || k < 1)
            return null;
        return soluteRec(tree, new Count(), k);
    }
    private static BTNode soluteRec(BTNode tree, Count c, int k) {
        if (tree != null) {
            BTNode left = soluteRec(tree.getLeft(), c, k);
            c.increase();
            if (c.getCnt() == k)
                return tree;
            BTNode right = soluteRec(tree.getRight(), c, k);
            return left != null ? left : right;
        } else {
            return null;
        }
    }
}
