import bean.BTNode;
import org.omg.CORBA.INTERNAL;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{8, 8, 9, null, null, 2, 4, null, null, 7, null, null, 7, null, null};
        String s = "abc";
        String s1= "abcabcabc";
        System.out.println("hello world.");
    }
    static boolean eliminated(String str, int len) {
        int j = 0;
        for (int i = len; i < str.length(); ++i) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            j = (j + 1) % len;
        }
        return true;
    }
    static int foo(int a, int b){
        if (b == 0) return 0;
        if (b %2 == 0) return foo(a+a,b/2);
        return foo(a+a,b/2)+a;
    }
    static void preOrder(BTNode tree) {
        if (tree != null) {
            System.out.print(tree.getKey());
            System.out.print(' ');
            preOrder(tree.getLeft());
            preOrder(tree.getRight());
        }
    }

    static int divide(int dividend, int divisor) {
        if (dividend == 0)
            return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        boolean positive = (dividend ^ divisor) >= 0;
        long x = Math.abs((long) dividend);
        long y = Math.abs((long) divisor);
        int result = 0;
        for (int i = 31; i >= 0; --i) {
            if (x >= (y << i)) {
                x -= y << i;
                result += 1 << i;
            }
        }
        return positive ? result : -result;
    }

    static int divide2(int dividend, int divisor) {
        if (dividend == 0)
            return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        boolean positive = (dividend ^ divisor) >= 0;
        long x = Math.abs((long) dividend);
        long y = Math.abs((long) divisor);
        int cnt;
        int result = 0;
        while (x >= y) {
            cnt = 0;
            while (x >= (y << cnt)) {
                ++cnt;
            }
            x -= y << (cnt - 1);
            result += 1 << (cnt - 1);
        }
        return positive ? result : -result;
    }

    static int divide3(int dividend, int divisor) {
        if (dividend == 0)
            return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        boolean positive = (dividend ^ divisor) >= 0;
        long x = Math.abs((long) dividend);
        long y = Math.abs((long) divisor);
        int result = _divide3(x, y);
        return positive ? result : -result;
    }

    private static int _divide3(long dividend, long divisor) {
        if (dividend < divisor)
            return 0;
        int cnt = 1;
        while (dividend >= (divisor << cnt)) {
            ++cnt;
        }
        --cnt;
        return (1 << cnt) + _divide3(dividend - (divisor << cnt), divisor);
    }

}
