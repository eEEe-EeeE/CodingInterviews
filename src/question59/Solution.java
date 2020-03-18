package question59;

import java.util.Deque;
import java.util.LinkedList;

// 队列的最大值
public class Solution {
    // 给定一个数组和滑动窗口的大小，求所有滑动窗口的最大值
    static int[] solute(int[] nums, int size) {
        // 在插入新数据前双端队列的元素包含上一个窗口和当前窗口的内容的索引
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < size - 1; ++i) {
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i])
                deque.pollLast();
            deque.offerLast(i);
        }

        int[] maxValue = new int[nums.length - size + 1];
        int k = 0;
        for (int i = size - 1; i < nums.length; ++i) {
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i])
                deque.pollLast();
            deque.offerLast(i);
            if (i - deque.getFirst() >= size)
                deque.pollFirst();

            maxValue[k++] = nums[deque.getFirst()];
        }
        return maxValue;
    }

}

// 定义一个队列，并实现函数max得到队列里的最大值，要求offerLast，pollFirst，max时间复杂度都是1
class QUEUE<E extends Comparable<? super E>> {
    private LinkedList<E> list = new LinkedList<>();
    private Deque<E> deque = new LinkedList<>();
    boolean offerLast(E item) {
        while (!deque.isEmpty() && deque.peekLast().compareTo(item) <= 0)
            deque.pollLast();
        deque.offerLast(item);
        return list.offerLast(item);
    }
    E pollFirst() {
        if (deque.peekFirst() == list.peekFirst())
            deque.pollFirst();
        return list.pollFirst();
    }
    E peekMax() {
        return deque.peekFirst();
    }
}
