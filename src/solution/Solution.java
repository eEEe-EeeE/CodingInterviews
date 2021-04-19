package solution;

import javafx.util.Pair;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {

    public static void main(String[] args) throws ClassNotFoundException {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode p = root;
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        p = p.left;
        p.right = new TreeNode(4);
        int ans = s.countPairs(root, 3);
    }

    public int countPairs(TreeNode root, int distance) {
        ans = 0;
        solve(root, distance);
        return ans;
    }

    int ans;

    List<Integer> solve(TreeNode root, int distance) {
        if (root == null)
            return new ArrayList<Integer>();
        if (root.left == null && root.right == null) {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            return list;
        }
        List<Integer> left = solve(root.left, distance);
        List<Integer> right = solve(root.right, distance);
        List<Integer> ret = new ArrayList<>();
        for (Integer l_val : left) {
            if (l_val + 1 < distance)
                ret.add(l_val + 1);
        }
        for (Integer r_val : right) {
            if (r_val + 1 < distance)
                ret.add(r_val + 1);
        }
        for (Integer l_val : left) {
            for (Integer r_val : right) {
                if (l_val + r_val + 2 <= distance)
                    ++ans;
            }
        }
        return ret;
    }

}

