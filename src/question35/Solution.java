package question35;

import java.util.HashMap;
import java.util.Map;

// 复制复杂链表，复杂链表每个结点包含key，next和指向任意结点（可能为null）的指针sibling
public class Solution {
    private static class CLNode {
        int key;
        CLNode next;
        CLNode sibling;

        CLNode(int key, CLNode next) {
            this.key = key;
            this.next = next;
        }
    }

    static CLNode solute(CLNode list) {
        CLNode head = new CLNode(0, null);
        CLNode pre = head;
        for (CLNode p = list; p != null; p = p.next) {
            pre.next = new CLNode(p.key, p.next);
            pre = pre.next;
        }
        pre = head.next;
        CLNode cur;
        for (CLNode p = list; p != null; p = p.next) {
            if (p.sibling != null) {
                cur = pre;
                for (CLNode q = list; q != null; q = q.next) {
                    if (q == p.sibling) {
                        pre.sibling = cur;
                        break;
                    }
                    cur = cur.next;
                }
            } else
                pre.sibling = null;
            pre = pre.next;
        }
        return head.next;
    }

    static CLNode solute2(CLNode list) {
        CLNode head = new CLNode(0, null);
        CLNode pre = head;
        Map<CLNode, CLNode> map = new HashMap<>();
        for (CLNode p = list; p != null; p = p.next) {
            pre.next = new CLNode(p.key, p.next);
            pre = pre.next;
            map.put(p, pre);
        }
        pre = head.next;
        for (CLNode p = list; p != null; p = p.next) {
            if (p.sibling != null) {
                pre.sibling = map.get(p.sibling);
            } else
                pre.sibling = null;
        }
        return head.next;
    }

    static CLNode solute3(CLNode list) {
        CLNode iterPtr;
        for (CLNode p = list; p != null; p = p.next.next) {
            iterPtr = new CLNode(p.key, p.next);
            p.next = iterPtr;
        }
        for (CLNode p = list; p != null; p = p.next.next) {
            iterPtr = p.next;
            iterPtr.sibling = p.sibling.next;
        }
        CLNode head = new CLNode(0, null);
        iterPtr = head;
        for (CLNode p = list; p != null; p = p.next) {
            iterPtr.next = p.next;
            iterPtr = iterPtr.next;
            p.next = p.next.next;
        }
        return head.next;
    }
}
