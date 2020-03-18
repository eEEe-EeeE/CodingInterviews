package question49;

import genericBean.LNode;

// 只包含因子2，3，5的数称为丑数
// 例如6，8是丑数，14不是丑数
// 求从小到大顺序的第k个丑数
public class Solution {
    static int solute(int k) {
        if (k <= 0)
            return -1;
        // u为当前最大丑数
        int u = 1;
        // t2为1-u的某个数，乘以2大于u，且t2以前的数乘以2都小于等于u
        LNode<Integer> head = new LNode<>();
        head.setItem(u);
        LNode<Integer> list = head;
        LNode<Integer> t2 = head;
        LNode<Integer> t3 = head;
        LNode<Integer> t5 = head;
        for (int i = 1; i < k; ++i) {
            while (t2.getItem() * 2 <= u)
                t2 = t2.getNext();
            while (t3.getItem() * 3 <= u)
                t3 = t3.getNext();
            while (t5.getItem() * 5 <= u)
                t5 = t5.getNext();
            u = Math.min(Math.min(t2.getItem() * 2, t3.getItem() * 3), t5.getItem() * 5);
            list.setNext(new LNode<>(u));
            list = list.getNext();
        }
        return u;
    }
}
