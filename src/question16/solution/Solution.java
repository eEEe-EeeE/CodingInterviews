package question16.solution;

public class Solution {
    static double solute(double base, int exponent) {
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;
        double result = solute(base, exponent >> 1);
        result *= result;
        if ((exponent & 1) == 1)
            result *= base;
        return result;
    }
}
