package question54;

import bean.BTNode;

public class Main {
    public static void main(String[] args) {
        BTNode tree = BTNode.createTreeByPre(new Integer[]{5, 3, 2, null, null, 4, null, null, 7, 6, null, null, 8, null, null});
        int k = 7;
        BTNode node = Solution.solute(tree, k);
        System.out.println(node.getKey());
    }
}
