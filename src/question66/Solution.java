package question66;

public class Solution {
    // 给定一个数组A，构建一个数组B，其中元素为B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]
    static int[] solute(int[] A) {
        if (A == null || A.length <= 1)
            return null;
        int[] C = new int[A.length];
        int[] D = new int[A.length];

        C[0] = 1;
        for (int i = 1; i < C.length; ++i) {
            C[i] = C[i - 1] * A[i - 1];
        }
        D[0] = 1;
        for (int i = 1; i < D.length; ++i) {
            D[i] = D[i - 1] * A[A.length - i];
        }
        int[] B = new int[A.length];
        for (int i = 0; i < B.length; ++i) {
            B[i] = C[i] * D[D.length - i - 1];
        }
        return B;
    }
}
