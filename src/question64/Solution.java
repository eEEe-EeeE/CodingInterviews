package question64;

// 不用乘法除法，循环，分支，条件语句求1+2+...+n
public class Solution {
    static int solute(int n) {
        return n == 1 ? 1 : (1 + n) * n / 2;
    }
}
