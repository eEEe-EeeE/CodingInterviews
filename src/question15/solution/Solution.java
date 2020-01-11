package question15.solution;

public class Solution {
    static int solute1(int n) {
        int cnt = 0;
        while (n != 0) {
            if ((n & Integer.MIN_VALUE) != 0)
                ++cnt;
            n <<= 1;
        }
        return cnt;
    }

    static int solute2(int n) {
        int cnt = 0;
        while (n != 0) {
            ++cnt;
            n = (n - 1) & n;
        }
        return cnt;
    }
}
