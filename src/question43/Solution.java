package question43;

// 1~n整数中1出现的次数
public class Solution {

    static int solute(int k) {
        // 分为两部分
        // 1.1~dx，d是k最高数位减一，x是k位数减一的最大数
        // 2.dx+1~k
        // 例如k=321，d=2，x=99，dx+1=300
        if (k < 1)
            return 0;

        int radix = 10;
        int digitLen = getNumberLength(k, radix);
        if (k < radix)
            return 1;

        int sum = 0;
        int expTerm = 1;
        // f(n) = 10 * f(n-1) + 10^(n-1)
        // f(1) = 1
        for (int i = 1; i < digitLen; ++i) {
            if (i == 1) {
                sum = 1;
            } else {
                expTerm *= radix;
                sum = radix * sum + expTerm;
            }
        }
        expTerm *= radix;
        int highDigit = getHighDigit(k, radix);

        int firstPart;
        if (highDigit == 1) {
            firstPart = sum + (k - highDigit * expTerm + 1);
        } else {
            firstPart = highDigit * sum + expTerm;
        }
        if (k - highDigit * expTerm >= 1)
            return firstPart + solute(k - highDigit * expTerm);
        else
            return firstPart;
    }

    private static int getNumberLength(int n, int radix) {
        if (n == 0)
            return 1;
        int digitNum = 0;
        while (n != 0) {
            n /= radix;
            ++digitNum;
        }
        return digitNum;
    }

    private static int getHighDigit(int n, int radix) {
        if (n == 0)
            return 0;
        while (n / radix != 0) {
            n /= radix;
        }
        return Math.abs(n);
    }

    static int solute2(int k) {
        // 分为两部分
        // 1.1~x，x是k去掉最高位的数
        // 2.x+1~k
        // 例如k=1024，x=24，x+1=25
        if (k < 1)
            return 0;

        int radix = 10;
        if (k < radix)
            return 1;

        int highDigit = getHighDigit(k, radix);
        int digitLen = getNumberLength(k, radix);
        int bound = k - highDigit * powBase10(digitLen - 1);

        int highPart = 0;
        if (highDigit == 1)
            highPart = bound + 1;
        else
            highPart = powBase10(digitLen - 1);
        // 分别对每一位计算1的数目
        // 例如0000~9999 分别对每一位取1其他位从0-9随意排，共有4*3^10个1
        int otherPart = highDigit * (digitLen - 1) * powBase10(digitLen - 2);
        return highPart + otherPart + solute2(bound);
    }

    private static int powBase10(int n) {
        int result = 1;
        for (int i = 0; i < n; ++i)
            result *= 10;
        return result;
    }
}
