package solution;

import java.util.*;

public class Main {

    static class Pair {
        int x;
        int y;

        Pair() {
        }

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Pair other = (Pair) obj;
            return x == other.x && y == other.y;
        }
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{4, 4, 7, 5, 1, 9, 4, 7, 3, 8};
        Main main = new Main();
        System.out.println('b' - 'a');
    }

    public int minIncrementForUnique(int[] A) {
        int len = A.length;
        if (len == 0)
            return 0;
        Arrays.sort(A);
        int begin = 0;
        int end = 0;
        int next_height = A[0];
        int res = 0;
        while (begin < len) {
            if (end < len && A[end] == A[begin]) {
                ++end;
            } else {
                res += Math.max(next_height - A[begin], 0) * (end - begin);
                res += getSum(end - begin - 1);
                next_height = Math.max(next_height, A[begin]) + end - begin;
                begin = end;
            }
        }
        return res;
    }

    int getSum(int n) {
        if (n < 1)
            return 0;
        return (1 + n) * n / 2;
    }


    static int solute(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length;
        int[] leftDistSum = new int[len];
        int[] rightDistSum = new int[len];

        for (int i = 1; i < len; ++i) {
            leftDistSum[i] = leftDistSum[i - 1] + i * (arr[i] - arr[i - 1]);
        }
        for (int i = len - 2; i >= 0; --i) {
            rightDistSum[i] = rightDistSum[i + 1] + (len - i - 1) * (arr[i + 1] - arr[i]);
        }

        int min_val = Integer.MAX_VALUE;
        for (int i = 0; i < len; ++i) {
            min_val = Math.min(min_val, leftDistSum[i] + rightDistSum[i]);
        }
        return min_val;
    }


}