package question22.solution;

import bean.MyList;


public class Solution {
    // 找到倒数第K个结点
    static int solute(int[] arr, int k) {
        MyList list = new MyList(arr);
        return list.getLastK(k);
    }

    // 找到中位数
    static int solute2(int[] arr) {
        MyList list = new MyList(arr);
        return list.getMidK();
    }

}
