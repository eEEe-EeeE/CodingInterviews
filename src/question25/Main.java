package question25;

import bean.MyList;
import bean.MyLNode;

public class Main {
    public static void main(String[] args) {
        MyList l1 = new MyList(new int[]{1, 3, 5, 7, 9});
        MyList l2 = new MyList(new int[]{0, 2, 4, 6, 8});
        MyList l = Solution.solute(l1, l2);
        l.printList();
        MyLNode node = Solution.solute2(l1.getHead(), l2.getHead());
        while (node != null) {
            System.out.println(node.getValue());
            node = node.getNext();
        }
    }
}
