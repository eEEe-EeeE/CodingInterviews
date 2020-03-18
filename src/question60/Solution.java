package question60;

public class Solution {
    // 回溯法
    static double[] solute1(int n) {
        final int maxPoint = 6;
        double[] probabilities = new double[n * maxPoint + 1];
        solute1Rec(n, maxPoint, 0, probabilities);
        double total = Math.pow(maxPoint, n);
        for (int i = 0; i < probabilities.length; ++i) {
            probabilities[i] /= total;
        }
        return probabilities;
    }

    private static void solute1Rec(int diceNum, int maxPoint, int sum, double[] probabilities) {
        if (diceNum == 0) {
            probabilities[sum] += 1;
        } else {
            for (int i = 1; i <= maxPoint; ++i) {
                solute1Rec(diceNum - 1, maxPoint, sum + i, probabilities);
            }
        }
    }

    // 递推法
    static double[] solute2(int n) {
        final int maxPoint = 6;
        double[][] probabilities = new double[2][n * maxPoint + 1];
        int flag = 0;
        for (int i = 1; i <= maxPoint; ++i) {
            probabilities[flag][i] = 1;
        }
        // i 表示骰子数
        for (int i = 2; i <= n; ++i) {
            // j 表示有i个骰子时点数总和
            for (int j = 1; j < i; ++j) {
                probabilities[1 - flag][j] = 0;
            }
            for (int j = i; j <= maxPoint * i; ++j) {
                // k 表示有i个骰子点数总和j的第前k个总和
                probabilities[1 - flag][j] = 0;
                for (int k = 1; j - k >= 0 && k <= maxPoint; ++k) {
                    probabilities[1 - flag][j] += probabilities[flag][j - k];
                }
            }
            flag = 1 - flag;
        }
        double total = Math.pow(maxPoint, n);
        for (int i = 0; i < probabilities[0].length; ++i) {
            probabilities[flag][i] /= total;
        }
        return probabilities[flag];
    }
}
