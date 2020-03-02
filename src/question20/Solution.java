package question20;

// 判断字符串是否表示数值
// A[.[B]][e|EC]|.B[e|EC]
// A和C是前缀可以有+或者-，包含0-9的数字
// B是包含0-9的数字
// 小数点需要前面包含整数或者后面包含数字
// e前面需要有数字且后面需要有整数
public class Solution {
    static private class NumString{
        String str;
        int nextToScan;
        boolean curIsNum;
        NumString(String str) {
            this.str = str;
            this.nextToScan = 0;
            this.curIsNum = false;
        }
        char getNextScanChar() {
            return str.charAt(nextToScan);
        }
        boolean scanCompleted() {
            return nextToScan == str.length();
        }
    }
    static boolean solute(String str) {
        if (str == null || str.length() == 0)
            return false;
        NumString numString = new NumString(str);
        numString.curIsNum = scanInteger(numString);
        if (!numString.scanCompleted() && numString.getNextScanChar() == '.') {
            ++numString.nextToScan;
            numString.curIsNum = scanUnsigned(numString) || numString.curIsNum;
        }
        if (!numString.scanCompleted() && (numString.getNextScanChar() == 'e' || numString.getNextScanChar() == 'E')) {
            ++numString.nextToScan;
            numString.curIsNum = numString.curIsNum && scanInteger(numString);
        }
        return numString.curIsNum && numString.scanCompleted();
    }

    static private boolean scanInteger(NumString str) {
        if (!str.scanCompleted() && (str.getNextScanChar() == '+' || str.getNextScanChar() == '-'))
            ++str.nextToScan;
        return scanUnsigned(str);
    }

    static private boolean scanUnsigned(NumString str) {
        int cnt = 0;
        while (!str.scanCompleted() && str.getNextScanChar() >= '0' && str.getNextScanChar() <= '9') {
            ++str.nextToScan;
            ++cnt;
        }
        return cnt != 0;
    }
}
