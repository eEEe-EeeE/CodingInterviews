package question67;

public class Solution {
    // 把字符串转换成整数
    static Integer solute(String num) {
        if (num == null || num.length() == 0)
            return null;
        int i = 0;
        int len = num.length();
        int limit = -Integer.MAX_VALUE;
        int sign = -1;
        char first = num.charAt(i);
        if (first < '0' || first > '9') {
            if (first == '-') {
                limit = Integer.MIN_VALUE;
                sign = 1;
            } else if (first != '+') {
                return null;
            }
            if (len == 1)
                return null;
            ++i;
        }
        int radix = 10;
        int mulMin = limit / radix;
        int result = 0;
        int digit;
        while (i < len) {
            digit = digit(num.charAt(i++));
            if (digit < 0)
                return null;
            if (result < mulMin)
                return null;
            result *= radix;
            if (result < limit + digit)
                return null;
            result -= digit;
        }
        return sign * result;
    }

    private static int digit(char ch) {
        if (ch < '0' || ch > '9')
            return -1;
        else
            return ch - '0';
    }
}
