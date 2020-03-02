package question24;

import bean.MyList;
import bean.LNode;

// 反转链表
public class Solution {
    static MyList solute(MyList list) {
        if (list == null || list.getHead() == null || list.getHead().getNext() == null)
            return list;

        LNode temp = list.getHead();
        LNode prev = list.getHead();
        LNode cur = list.getHead();
        LNode next = list.getHead().getNext();

        cur.setNext(null);
        prev = cur;
        cur = next;
        next = cur.getNext();
        while (next != null) {
            cur.setNext(prev);
            prev = cur;
            cur = next;
            next = cur.getNext();
        }
        cur.setNext(prev);
        list.setHead(cur);
        list.setTail(temp);
        return list;
    }
}
