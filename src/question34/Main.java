package question34;

import bean.BTNode;

public class Main {
    public static void main(String[] args) {
        BTNode tree = BTNode.createTreeByPre(
                new Integer[]{10,5,4,null,null,7,null,null,12,null,null});
        int key = 22;
        Solution.solute(tree, key);
    }
}
