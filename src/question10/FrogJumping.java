package question10;

public class FrogJumping {
    static int jumpWayNum(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return jumpWayNum(n - 1) + jumpWayNum(n - 2);
    }
}
