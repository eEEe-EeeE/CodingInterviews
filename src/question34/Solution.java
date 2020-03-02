package question34;

import bean.BTNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    static void solute(BTNode tree, int key) {
        List<BTNode> list = new LinkedList<>();
        int sum = 0;
        _solute(tree, key, list, sum);
    }
    private static void _solute(BTNode tree, int key, List<BTNode> list, int sum) {
        sum += tree.getKey();
        list.add(tree);
        if (tree.isLeaf()) {
            if (sum == key) {
                for (BTNode node : list) {
                    System.out.print(node.getKey());
                    System.out.print(' ');
                }
                System.out.println();
            }
        } else {
            _solute(tree.getLeft(), key, list, sum);
            _solute(tree.getRight(), key, list, sum);
        }
        list.remove(tree);
    }
}