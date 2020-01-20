package question27;

import bean.BTNode;

public class Main {
    public static void main(String[] args) {
        BTNode tree = BTNode.createTreeByPre(new Integer[]{8, 8, 9, null, null, 2, 4, null, null, 7, null, null, 7, null, null});
        BTNode mirror = Solution.solute(tree);
    }
}
