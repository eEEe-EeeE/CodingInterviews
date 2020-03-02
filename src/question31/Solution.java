package question31;

import java.util.Stack;

// 栈的压入、弹出序列
// 输入两个整数序列，第一个是栈的压入序列，判断第二个是否为栈的弹出序列
public class Solution {
    static boolean solute(int[] seq1, int[] seq2) {
        if (seq1 == null || seq2 == null || seq1.length == 0 || seq2.length == 0)
            return false;
        Stack<Integer> stack = new Stack<>();
        int index1 = 0;
        int index2 = 0;
        while (index2 != seq2.length) {
            while (stack.empty() || seq2[index2] != stack.peek()) {
                if (index1 == seq1.length) {
                    return false;
                }
                stack.push(seq1[index1]);
                ++index1;
            }
            stack.pop();
            ++index2;
        }
        return stack.empty();
    }
}
