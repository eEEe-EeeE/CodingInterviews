package question52;

import bean.LNode;

public class Main {
    public static void main(String[] args) {
        LNode l1 = LNode.createList(new Integer[]{1,2,3,6,7});
        LNode l2 = LNode.createList(new Integer[]{4,5});
        LNode p2 = l2;
        p2 = p2.getNext();
        LNode p1 = l1;
        int n = 3;
        while (p1 != null && n-- > 0)
            p1 = p1.getNext();
        p2.setNext(p1);
        LNode node = Solution.solute1(l1, l2);
        LNode node_ = Solution.solute2(l1, l2);
        System.out.println(node != null ? node.getValue() : null);
        System.out.println(node_ != null ? node_.getValue() : null);
    }
}
