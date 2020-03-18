package question41;

// 读出流数据中的中位数

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

// 从流中读取数据，数据随时间变化而增加
// 用一个容器保存读取的数据，就能容易定位到当前读取数据的中位数
// 1.无序数组：每次从流中读取数据加入数组尾部，可以基于分区的思想求得中位数
// 2.有序数组：每次从流中读取数据时让数组保持有序
// 3.有序链表：两个指针指向中间结点，奇数指向相同，偶数不同
// 4.二叉搜索树：定义一个以该结点为树的结点数目域
// 5.AVL数：重新定义平衡因子，左右子树结点数目之差
// 6.大小堆：大堆最大的数小于等于小堆最小的数，两个堆结点数之差不超过一
public class Solution {
    static Double solute() {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input some Integers: ctrl+D to quit");
        while (scanner.hasNext()) {
            String s = scanner.next();
            try {
                insert(Integer.parseInt(s), maxHeap, minHeap);
            } catch (NumberFormatException e) {
                System.out.println("must input integer.");
            }
        }
        return getMedian(maxHeap, minHeap);
    }

    private static void insert(int key, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        if (maxHeap.size() == minHeap.size()) {
            Integer maxPeek = maxHeap.peek();
            if (maxPeek == null || key >= maxPeek)
                minHeap.offer(key);
            else {
                maxHeap.poll();
                maxHeap.offer(key);
                minHeap.offer(maxPeek);
            }
        } else {
            Integer minPeek = minHeap.peek();
            if (key <= minPeek)
                maxHeap.offer(key);
            else {
                minHeap.poll();
                minHeap.offer(key);
                maxHeap.offer(minPeek);
            }
        }
    }

    private static Double getMedian(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        if (maxHeap.isEmpty() && minHeap.isEmpty())
            return null;
        if (maxHeap.size() == minHeap.size()) {
            return ((double) maxHeap.peek() + minHeap.peek()) / 2;
        } else {
            return (double) minHeap.peek();
        }
    }
}
