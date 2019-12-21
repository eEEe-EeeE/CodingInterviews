package question10.solution;

public class FibGenerator {
    int fibRecur(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return fibRecur(n - 2) + fibRecur(n - 1);
    }

    int fib(int n) {
        int i = 0;
        int j = 1;
        int cnt = 0;
        while (cnt < n) {
            i = i + j;
            i = i ^ j;
            j = i ^ j;
            i = i ^ j;
            ++cnt;
        }
        return i;
    }
}
