package question62;

import bean.LNode;

public class Solution {
    // 约瑟夫环问题
    // 0~n-1这n个数字排成一个圆圈，从0开始，每次从圆圈里删除第m个数字，求圆圈剩下的最后一个数字
    static int solute1(int[] nums, int m) {
        LNode prev = new LNode();
        LNode p = prev;
        for (int v : nums) {
            p.setNext(new LNode(v));
            p = p.getNext();
        }
        p.setNext(prev.getNext());

        p = prev.getNext();
        int cnt;
        while (p.getNext() != p) {
            cnt = m - 1;
            while (cnt > 0) {
                prev = p;
                p = p.getNext();
                --cnt;
            }
            prev.setNext(p.getNext());
            p = p.getNext();
        }
        return p.getValue();
    }

    // 递推法：f(n)的值为在一个长n的环中从某个数开始每数m个数丢弃一个最后剩下的数的索引
    // 这个索引跟n，m以及序列的起始数数位置有关
    // f(n) = (f(n-1) + m) % n , n > 1
    // f(1) = 0
    static int solute2(int[] nums, int m) {
        if (nums == null || nums.length==0 || m <= 0)
            return -1;


        int fn = 0;
        for (int n = 2; n <= nums.length; ++n) {
            fn = (fn + m) % n;
        }
        return nums[fn];
    }
}
