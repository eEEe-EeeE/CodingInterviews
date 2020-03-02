package question18;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Solution {
    static class Node {
        private int value;
        private Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    static Node createList(int[] arr) {
        Node head = new Node(0);
        Node p = head;
        for (int v : arr) {
            p.next = new Node(v);
            p = p.next;
        }
        return head.next;
    }

    static Node deleteNode(Node list, Node pToBeDeleted) {
        if (list == null || pToBeDeleted == null)
            return null;
        if (pToBeDeleted.next == null) {
            Node pre = list;
            Node p = list;
            while (p != pToBeDeleted) {
                pre = p;
                p = p.next;
            }
            if (pre == p)
                return null;
            pre.next = null;
        } else {
            pToBeDeleted.value = pToBeDeleted.next.value;
            pToBeDeleted.next = pToBeDeleted.next.next;
        }
        return list;
    }

    // 在O(1)时间内删除链表结点
    static void solute(int[] arr, int index) {
        Node list = createList(arr);
        if (index < 0 || index >= arr.length)
            return;
        Node p = list;
        for (int i = 0; i < index; ++i)
            p = p.next;
        list = deleteNode(list, p);
        for (p = list; p != null; p = p.next)
            System.out.println(p.value);
    }

    // 删除排序链表重复结点，例如有两个值为2的结点，这两个结点都要删除
    static void solute2(int[] arr) {
        if (arr == null || arr.length < 1)
            return;
        if (arr.length == 1) {
            System.out.println(arr[0]);
            return;
        }
        Node list = createList(arr);
        Node last = list;
        Node first = list;
        Node cur = list.next;
        while (cur != null) {
            if (first.value != cur.value) {
                if (first.next == cur)
                    last = first;
                else {
                    if (last != first)
                        last.next = cur;
                    else {
                        list = cur;
                        last = cur;
                    }
                }
                first = cur;
            }
            cur = cur.next;
        }
        if (first.next != null)
            if (last != first)
                last.next = null;
            else
                list = null;
        for (Node p = list; p != null; p = p.next) {
            System.out.println(p.value);
        }
    }
}
