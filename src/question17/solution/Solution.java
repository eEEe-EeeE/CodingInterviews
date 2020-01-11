package question17.solution;


// 输入：数字n
// 输出：按顺序打印1到最大的n位十进制数
public class Solution {
    static void solute(int n) {
        char[] nums = new char[n + 1];
        while (!increase(nums)) {
            printNum(nums);
        }
    }

    static private boolean increase(char[] nums) {
        return false;
    }

    static private void printNum(char[] nums) {

    }

    // 扩展：一个char类型能够表示256个字符，表示一个十进制数用到10个字符，有没有更高效的方式表示大数？

    // 扩展：定义一个函数，该函数可以实现任意两个整数的加法
}
