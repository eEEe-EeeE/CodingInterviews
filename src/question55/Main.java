package question55;

import bean.BTNode;

public class Main {
    public static void main(String[] args) {
        BTNode tree = BTNode.createTreeByPre(new Integer[]{5, 3, 2, null, null, 4, null, null, 7, 6, null, null, 8, null, null});
        System.out.println(Solution.solute2(tree));
    }
}
