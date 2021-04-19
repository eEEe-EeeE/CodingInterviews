package question20;

// 判断字符串是否表示数值
// A[.[B]][e|EA]|[+|-].B[e|EA]
// (A[.[B]]|[+|-].B)[e|EA]
// C[e|EA]
// A是有可选前缀+或-且其他部分只包含0-9的数字，即符号整数
// B是只包含0-9的数字，即无符号整数
// C是有理数，即整数或浮点数
// 小数点前后至少一处要有整数，有可选前缀+或-
// e前必须是有理数，后必须是符号整数
// 小数点要在e之前
// 数值的第一个字符必须是符号或数码或小数点
// 符号后面必须是数码或小数点
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
