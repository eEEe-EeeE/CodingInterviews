package question68;

import bean.BTNode;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,4,6,null,null,7,null,null,5,8,null,null,9,null,null,3,null,null};
        BTNode tree = BTNode.createTreeByPre(arr);
        BTNode node = Solution.solute(tree, 3, 3);
        System.out.println(node != null ? node.getKey() : null);
    }
}
