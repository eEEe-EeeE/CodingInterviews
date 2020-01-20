package question26;

import bean.BTNode;

public class Main {
    public static void main(String[] args) {
        BTNode tree = BTNode.createTreeByPre(new Integer[]{8, 8, 9, null, null, 2, 4, null, null, 7, null, null, 7, null, null});
        BTNode tree2 = BTNode.createTreeByPre(new Integer[]{8, 9, null, null, 2, 4, null, null, 7, null, null});
        BTNode tree3 = BTNode.createTreeByPre(new Integer[]{8, 9, null, null, 3, null, null});
        System.out.println(Solution.solute2(tree, tree3));
    }
}
