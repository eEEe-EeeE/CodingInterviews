package question16.solution;

// 求数值的整数次方

public class Solution {
    static double solute(double base, int exponent) {
        if (base == 0.0 && exponent < 0) {
            return 0;
        }
        if (exponent == Integer.MIN_VALUE)
            ++exponent;
        int absEXP = Math.abs(exponent);
        double res = power(base, absEXP);
        if (exponent < 0)
            res = 1.0 / res;
        return res;
    }

    static private double power(double base, int exponent) {
        if (exponent == 0) {
            if (base == 0)
                return 0;
            return 1;
        }
        if (exponent == 1)
            return base;
        double result = power(base, exponent >> 1);
        result *= result;
        if ((exponent & 1) == 1)
            result *= base;
        return result;
    }
}
