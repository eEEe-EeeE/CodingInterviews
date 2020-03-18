package question44;

// 数字以01234567891011121314151617181920...的格式序列化到一个字符序列中，求字符序列第n位对应的数字
public class Solution {
    static int solute(int n) {
        if (n < 0)
            return -1;

        int digitLen = 1;
        int sum = 10;
        int radix = 10;
        while (n - sum >= 0) {
            ++digitLen;
            sum = sum + (radix - 1) * powBase10(digitLen - 1) * digitLen;
        }
        sum = sum - (radix - 1) * powBase10(digitLen - 1) * digitLen;
        int quotient = (n - sum) / digitLen;
        int remainder = (n - sum) % digitLen;
        int result = powBase10(digitLen - 1) + quotient;
        return getDigit(result, digitLen - 1 - remainder, radix);
    }

    private static int powBase10(int n) {
        if (n < 0)
            return 0;
        int result = 1;
        for (int i = 0; i < n; ++i)
            result *= 10;
        return result;
    }
    private static int getDigit(int key, int n, int radix) {
        if (n < 0)
            return -1;
        for (int i = 0; i < n; ++i) {
            key /= radix;
        }
        return key % radix;
    }
}
