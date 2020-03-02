public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int dividend = 1;
        int divisor = 1;
        System.out.println(divide(dividend, divisor));
        System.out.println(divide2(dividend, divisor));
        System.out.println(divide3(dividend, divisor));
        System.out.println(dividend / divisor);
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

    void func() {
        try {
            int x = 1 / 0;
        } catch (ArithmeticException e) {
            System.out.println(e);
        }
    }
}
