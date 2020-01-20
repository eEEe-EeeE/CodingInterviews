package question30;

import java.util.Stack;

// 构造包含Min函数的栈
public class Solution {
    static class MyStack {
        private Stack<Integer> stack = new Stack<>();
        private Stack<Integer> auxiliaryStack = new Stack<>();
        void push(Integer num) {
            stack.push(num);
            if (auxiliaryStack.isEmpty())
                auxiliaryStack.push(num);
            else {
                if (auxiliaryStack.peek() > num)
                    auxiliaryStack.push(num);
                else
                    auxiliaryStack.push(auxiliaryStack.peek());
            }
        }
        Integer pop() {
            auxiliaryStack.pop();
            return stack.pop();
        }
        Integer peekMin() {
            return auxiliaryStack.peek();
        }
    }

}
