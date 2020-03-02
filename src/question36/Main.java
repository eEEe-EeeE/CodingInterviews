package question36;

import bean.BTNode;

public class Main {
    public static void main(String[] args) {
        BTNode tree = BTNode.createTreeByPre(
                new Integer[]{10, 6, 4, null, null, 8, null, null, 14, 12, null, null, 16, null, null});
        BTNode p = Solution.solute(tree);
        while (p != null) {
            System.out.print(p.getKey());
            System.out.print(' ');
            p = p.getRight();
        }
    }
}
