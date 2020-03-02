package question32;

import bean.BTNode;

import java.util.*;

// 从上到下打印二叉树
// 题目1：不分行层序遍历二叉树
// 题目2：分行从上到下打印二叉树
// 题目3：之字形打印二叉树

public class Solution {
    static void solute1(BTNode tree) {
        if (tree == null)
            return;
        Queue<BTNode> queue = new LinkedList<>();
        queue.offer(tree);
        BTNode p;
        while (!queue.isEmpty()) {
            p = queue.poll();
            System.out.print(p.getKey());
            System.out.print(' ');
            if (p.getLeft() != null)
                queue.offer(p.getLeft());
            if (p.getRight() != null)
                queue.offer(p.getRight());
        }
    }

    static void solute2_1(BTNode tree) {
        if (tree == null)
            return;
        Queue<BTNode> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        queue1.offer(tree);
        queue2.offer(1);
        Integer cnt = 1;
        BTNode p;
        while (!queue1.isEmpty()) {
            p = queue1.poll();
            if (!queue2.peek().equals(cnt)) {
                cnt = queue2.poll();
                System.out.println();
            } else
                queue2.poll();
            System.out.print(p.getKey());
            System.out.print(' ');
            if (p.getLeft() != null) {
                queue1.offer(p.getLeft());
                queue2.offer(cnt + 1);
            }
            if (p.getRight() != null) {
                queue1.offer(p.getRight());
                queue2.offer(cnt + 1);
            }
        }
    }

    static void solute2_2(BTNode tree) {
        if (tree == null)
            return;
        Queue<BTNode> queue = new LinkedList<>();
        queue.offer(tree);
        int curCnt = 1;
        int nextCnt = 0;
        BTNode p;
        while (!queue.isEmpty()) {
            p = queue.poll();
            System.out.print(p.getKey());
            System.out.print(' ');
            if (p.getLeft() != null) {
                queue.offer(p.getLeft());
                ++nextCnt;
            }
            if (p.getRight() != null) {
                queue.offer(p.getRight());
                ++nextCnt;
            }
            --curCnt;
            if (curCnt == 0) {
                curCnt = nextCnt;
                nextCnt = 0;
                if (!queue.isEmpty())
                    System.out.println();
            }
        }
    }

    static void solute3(BTNode tree) {
        if (tree == null)
            return;
        Stack<BTNode> stack1 = new Stack<>();
        Stack<BTNode> stack2 = new Stack<>();
        boolean nextToRight = false;
        List<Stack<BTNode>> stackArray = new ArrayList<>();
        stackArray.add(stack1);
        stackArray.add(stack2);
        int curStack = 0;
        BTNode p;
        stackArray.get(curStack).push(tree);
        while (!stackArray.get(0).empty() || !stackArray.get(1).empty()) {
            p = stackArray.get(curStack).pop();
            System.out.print(p.getKey());
            System.out.print(' ');
            if (nextToRight) {
                if (p.getRight() != null) {
                    stackArray.get(1 - curStack).push(p.getRight());
                }
                if (p.getLeft() != null) {
                    stackArray.get(1 - curStack).push(p.getLeft());
                }
            } else {
                if (p.getLeft() != null) {
                    stackArray.get(1 - curStack).push(p.getLeft());
                }
                if (p.getRight() != null) {
                    stackArray.get(1 - curStack).push(p.getRight());
                }
            }
            if (stackArray.get(curStack).empty()) {
                nextToRight = !nextToRight;
                curStack = 1 - curStack;
                if (!stackArray.get(0).empty() || !stackArray.get(1).empty())
                    System.out.println();
            }
        }
    }
}
