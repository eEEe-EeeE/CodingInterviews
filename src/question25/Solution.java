package question25;

import bean.MyList;
import bean.MyLNode;

// 合并两个排序链表
public class Solution {
    static MyList solute(MyList l1, MyList l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        MyList res = new MyList();
        MyLNode p1 = l1.getHead();
        MyLNode p2 = l2.getHead();
        while (p1 != null && p2 != null) {
            if (p1.getValue() <= p2.getValue()) {
                res.add(p1.getValue());
                p1 = p1.getNext();
            } else {
                res.add(p2.getValue());
                p2 = p2.getNext();
            }
        }
        if (p1 == null) {
            while (p2 != null) {
                res.add(p2.getValue());
                p2 = p2.getNext();
            }
        } else {
            while (p1 != null) {
                res.add(p1.getValue());
                p1 = p1.getNext();
            }
        }
        return res;
    }

    static MyLNode solute2(MyLNode l1, MyLNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.getValue() <= l2.getValue()) {
            l1.setNext(solute2(l1.getNext(), l2));
            return l1;
        } else {
            l2.setNext(solute2(l1, l2.getNext()));
            return l2;
        }
    }
}
