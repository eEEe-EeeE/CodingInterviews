package question65;

// 不用加减乘除做加法
public class Solution {
    static int solute(int a, int b) {
        int sum = a ^ b;
        int carry = (a & b) << 1;
        int tmp;
        while (carry != 0) {
            tmp = sum ^ carry;
            carry = (sum & carry) << 1;
            sum = tmp;
        }
        return sum;
    }
}
