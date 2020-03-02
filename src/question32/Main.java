package question32;

import bean.BTNode;

public class Main {
    public static void main(String[] args) {
        BTNode tree = BTNode.createTreeByPre(
                new Integer[]{8,6,5,null,null,7,null,null,10,9,null,null,11,null,null});
        Solution.solute1(tree);
        System.out.println();
        Solution.solute2_1(tree);
        System.out.println();
        Solution.solute2_2(tree);
        System.out.println();
        Solution.solute3(tree);
    }
}
