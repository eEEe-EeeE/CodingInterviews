package question23;

import bean.MyList;
import bean.MyLNode;

import java.util.HashSet;
import java.util.Set;

// 找到链表环路的入口结点
public class Solution {

    static MyLNode solute(int[] arr, int entrance) {
        MyList list = new MyList(arr);
        list.reformLoop(entrance);
        Set<MyLNode> set = new HashSet<>();
        MyLNode p = list.getHead();
        while (p != null) {
            if (!set.contains(p))
                set.add(p);
            else
                break;
            p = p.getNext();
        }
        return p;
    }

    static MyLNode solute2(int[] arr, int entrance) {
        MyList list = new MyList(arr);
        list.reformLoop(entrance);

        MyLNode slow = list.getHead();
        MyLNode fast = list.getHead().getNext();
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
        MyLNode p = list.getHead();
        int n = list.getSize() - loopSize;
        while (n-- > 0) {
            p = p.getNext();
        }
        return p;
    }
}
