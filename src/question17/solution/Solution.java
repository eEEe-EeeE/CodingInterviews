package question17.solution;


import java.util.Arrays;

// 输入：数字n
// 输出：按顺序打印1到最大的n位十进制数
public class Solution {
    static void solute1(int n) {
        if (n <= 0)
            return;
        char[] nums = new char[n];
        Arrays.fill(nums, '0');
        while (!increase(nums)) {
            printNum(nums);
        }
    }

    static private boolean increase(char[] nums) {
        boolean isOverFlow = false;
        int carry = 0;
        for (int index = nums.length - 1; index >= 0; --index) {
            int digit = nums[index] - '0';
            if (index == nums.length - 1) {
                ++digit;
            } else {
                if (carry == 0)
                    break;
                else {
                    ++digit;
                    carry = 0;
                }
            }

            if (digit == 10) {
                if (index == 0)
                    isOverFlow = true;
                digit = 0;
                carry = 1;
            }

            nums[index] = (char) (digit + '0');
        }
        return isOverFlow;
    }

    static private void printNum(char[] nums) {
        int index = 0;
        while (index < nums.length && nums[index] == '0')
            ++index;
        if (index == nums.length)
            return;
        while (index != nums.length)
            System.out.print(nums[index++]);
        System.out.print('\n');
    }

    static void solute2(int n) {
        solute2Recur(n, "");
    }

    static private void solute2Recur(int n, String s) {
        if (n <= 0) {
            printNum(s.toCharArray());
            return;
        }
        for (int i = 0; i < 10; ++i) {
            solute2Recur(n - 1, s + i);
        }
    }

    // 扩展：一个char类型能够表示256个字符，表示一个十进制数用到10个字符，有没有更高效的方式表示大数？

    // 扩展：定义一个函数，该函数可以实现任意两个整数的加法
}
