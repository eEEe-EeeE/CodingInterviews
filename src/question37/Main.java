package question37;

import bean.BTNode;
import bean.LNode;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        LNode list = LNode.createList(new Integer[]{1, 2, 4, null, null, null, 3, 5, null, null, 6, null, null});
        BTNode tree = Solution.deserialize(list);
        list = Solution.serialize(tree);
        System.out.println();
    }
}
