package question23;

import bean.LNode;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        LNode node = Solution.solute2(arr, 8);
        if (node != null)
            System.out.println(node.getValue());
    }
}
