package question40;

import sun.reflect.generics.tree.Tree;

import java.util.*;

// 输入n个整数，找出其中最小的k个数
public class Solution {
    static void solute1(Integer[] arr, int k) {
        if (arr == null || arr.length == 0)
            return;
        int index = partition2(arr, 0, arr.length - 1);
        while (index != k - 1) {
            if (index < k - 1) {
                index = partition2(arr, index + 1, arr.length - 1);
            } else
                index = partition2(arr, 0, index - 1);
        }
        for (int i = 0; i < k; ++i) {
            System.out.print(arr[i]);
            System.out.print(' ');
        }
    }
    private static Integer partition1(Integer[] arr, Integer begin, Integer end) {
        int fast = begin;
        int slow = begin - 1;
        Integer temp = arr[fast];
        arr[fast] = arr[end];
        arr[end] = temp;
        while (fast < end) {
            if (arr[fast] < arr[end]) {
                ++slow;
                if (slow != fast) {
                    temp = arr[fast];
                    arr[fast] = arr[slow];
                    arr[slow] = temp;
                }
            }
            ++fast;
        }
        ++slow;
        if (slow != fast) {
            temp = arr[fast];
            arr[fast] = arr[slow];
            arr[slow] = temp;
        }
        return slow;
    }
    private static Integer partition2(Integer[] arr, Integer begin, Integer end) {
        int left = begin;
        int right = end;
        Integer piv = arr[begin];
        while (left < right) {
            while (left < right && arr[right] >= piv)
                --right;
            if (left < right)
                arr[left++] = arr[right];
            while (left < right && arr[left] < piv)
                ++left;
            if (left < right)
                arr[right--] = arr[left];
        }
        arr[left] = piv;
        return left;
    }

    static void solute2(Integer[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0 || k > arr.length)
            return;
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int index = 0;
        while (index < k) {
            queue.offer(arr[index]);
            ++index;
        }

        while (index < arr.length) {
            if (queue.peek() != null && arr[index] < queue.peek()) {
                queue.poll();
                queue.offer(arr[index]);
            }
            ++index;
        }
        for (Integer v : queue) {
            System.out.print(v);
            System.out.print(' ');
        }
    }
    
}
