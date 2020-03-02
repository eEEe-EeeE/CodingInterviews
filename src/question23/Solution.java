package question23;

import bean.MyList;
import bean.LNode;

import java.util.HashSet;
import java.util.Set;

// 找到链表环路的入口结点
public class Solution {

    static LNode solute(int[] arr, int entrance) {
        MyList list = new MyList(arr);
        list.reformLoop(entrance);
        Set<LNode> set = new HashSet<>();
        LNode p = list.getHead();
        while (p != null) {
            if (!set.contains(p))
                set.add(p);
            else
                break;
            p = p.getNext();
        }
        return p;
    }

    static LNode solute2(int[] arr, int entrance) {
        MyList list = new MyList(arr);
        list.reformLoop(entrance);

        LNode slow = list.getHead();
        LNode fast = list.getHead().getNext();
        while (fast != slow) {
            if (fast == null || fast.getNext() == null)
                return null;
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        int loopSize = 0;
        do {
            slow = slow.getNext();
            ++loopSize;
        } while (slow != fast);
        LNode p = list.getHead();
        int n = list.getSize() - loopSize;
        while (n-- > 0) {
            p = p.getNext();
        }
        return p;
    }
}
