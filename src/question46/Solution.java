package question46;

// 0翻译成a，1翻译成b……25翻译成z
// 给定一个数字串，求这个数字串有多少种翻译方式
// 例如12，有bc和m两种
public class Solution {
    static int solute(int num) {
        if (num < 0)
            return 0;
        int len = 0;
        int n = num;
        if (num == 0)
            len = 1;
        else {
            while (n != 0) {
                n /= 10;
                ++len;
            }
        }
        int[] memorandum = new int[len];
        return translate(String.valueOf(num), 0, memorandum);
    }

    private static int translate(String num, int begin, int[] memorandum) {
        if (begin == num.length())
            return 1;
        else {
            if (memorandum[begin] != 0)
                return memorandum[begin];
            char digit = num.charAt(begin);
            int n;
            if (begin + 1 < num.length() &&
                    (digit == '1' || digit == '2' && '0' <= num.charAt(begin + 1) && num.charAt(begin + 1) <= '5'))
                n = translate(num, begin + 1, memorandum) + translate(num, begin + 2, memorandum);
            else
                n = translate(num, begin + 1, memorandum);
            memorandum[begin] = n;
            return n;
        }
    }
}
