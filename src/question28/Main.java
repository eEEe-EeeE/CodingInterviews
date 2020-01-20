package question28;

import bean.BTNode;

public class Main {
    public static void main(String[] args) {
        BTNode tree = BTNode.createTreeByPre(new Integer[]{8, 8, 9, null, null, 2, 4, null, null, 7, null, null, 7, null, null});
        BTNode tree2 = BTNode.createTreeByPre(new Integer[]{8, 6, 5, null, null, 7, null, null, 6, 7, null, null, 5, null, null});
        BTNode tree3 = BTNode.createTreeByPre(new Integer[]{8, 6, 5, null, null, 7, null, null, 9, 7, null, null, 5, null, null});
        System.out.println(Solution.solute(tree));
    }
}
