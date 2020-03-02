package question37;

import bean.BTNode;
import bean.LNode;

import java.util.Stack;

// 实现两个函数序列化和反序列化二叉树
public class Solution {
    static LNode serialize(BTNode tree) {
        LNode head = new LNode(0, null);
        LNode p = head;
        Stack<BTNode> stack = new Stack<>();
        stack.push(tree);
        BTNode iterPtr;
        while (!stack.empty()) {
            iterPtr = stack.pop();
            if (iterPtr != null) {
                p.setNext(new LNode(iterPtr.getKey(), null));
                stack.push(iterPtr.getRight());
                stack.push(iterPtr.getLeft());
            } else {
                p.setNext(new LNode(null, null));
            }
            p = p.getNext();
        }
        return head.getNext();
    }


    // 用栈模拟函数调用和函数返回
    // 除了哨兵结点，每个结点需要两次出栈，分别为左指针和右指针赋值，哨兵结点只出栈一次，为左指针赋值
    // 所以需要两个栈，一个栈存放结点，一个栈存放计数器（计数结点出栈次数）
    // 序列元素值不为null则创建结点，调整栈；元素值为null则调整栈
    // 二叉树有n个结点则有n+1个虚结点，前序序列长度等于结点数+虚结点数
    // 读每个序列元素都会出栈1次，共出栈2n+1次，每个结点会出栈2次，n个结点出栈2n次，哨兵结点出栈1次
    static BTNode deserialize(LNode list) {
        LNode p = list;

        BTNode head = new BTNode();
        head.setKey(null);
        head.setRight(head);
        BTNode iterPtr;

        Stack<BTNode> stack = new Stack<>();
        BTNode stack_elem;
        Stack<Integer> cnt = new Stack<>();
        Integer cnt_elem;

        stack.push(head);
        cnt.push(0);
        while (p != null) {
            if (p.getValue() != null) {
                iterPtr = new BTNode(p.getValue(), null, null);
                stack_elem = stack.pop();
                cnt_elem = cnt.pop();
                if (cnt_elem == 0) {
                    stack_elem.setLeft(iterPtr);
                    stack.push(stack_elem);
                    cnt.push(1);
                } else {
                    stack_elem.setRight(iterPtr);
                }
                stack.push(iterPtr);
                cnt.push(0);
            } else {
                cnt_elem = cnt.pop();
                if (cnt_elem == 0)
                    cnt.push(1);
                else
                    stack.pop();
            }
            p = p.getNext();
        }
        return stack.pop().getLeft();
    }
}
