package question52;

import bean.LNode;

import java.util.Stack;

// 输入两个链表，找出他们的第一个公共结点
public class Solution {
    static LNode solute1(LNode l1, LNode l2) {
        if (l1 == null || l2 == null)
            return null;
        Stack<LNode> stack1 = new Stack<>();
        Stack<LNode> stack2 = new Stack<>();
        for (LNode p = l1; p != null; p = p.getNext()) {
            stack1.push(p);
        }
        for (LNode p = l2; p != null; p = p.getNext()) {
            stack2.push(p);
        }
        LNode node1;
        LNode node2;
        LNode node = null;
        while (!stack1.empty() && !stack2.empty()) {
            node1 = stack1.pop();
            node2 = stack2.pop();
            if (node1 != node2)
                break;
            node = node1;
        }
        return node;
    }

    static LNode solute2(LNode l1, LNode l2) {
        if (l1 == null || l2 == null)
            return null;
        int l1Len = 0;
        int l2Len = 0;
        LNode p = l1;
        while (p != null) {
            ++l1Len;
            p = p.getNext();
        }
        p = l2;
        while (p != null) {
            ++l2Len;
            p = p.getNext();
        }
        LNode longList;
        LNode shortList;
        if (l1Len >= l2Len) {
            longList = l1;
            shortList = l2;
        } else {
            longList = l2;
            shortList = l1;
        }
        int diff = Math.abs(l1Len - l2Len);
        for (int i = 0; i < diff; ++i) {
            longList = longList.getNext();
        }
        while (longList != null) {
            if (longList == shortList)
                return longList;
            longList = longList.getNext();
            shortList = shortList.getNext();
        }
        return null;
    }
}
