package question14.solution;

// 剪绳子
// 输入绳子长度
// 输出剪完最大乘积
public class Solution {
    static int solute1(int len) {
        // 这里不能切0刀
        if (len <= 1)
            return 0;
        if (len == 2)
            return 1;
        if (len == 3)
            return 2;
        int[] memorandum = new int[len - 1];
        memorandum[0] = 2;
        memorandum[1] = 3;
        return solute1_recur(len, memorandum);
    }

    static private int solute1_recur(int len, int[] memorandum) {
        if (memorandum[len - 2] != 0)
            return memorandum[len - 2];
        int product;
        int max = 0;
        for (int i = 1; i <= (len + 1) / 2; ++i) {
            // 这里可以切0刀，因为默认已经切了1刀
            product = i * solute1_recur(len - i, memorandum);
            if (max < product)
                max = product;
        }
        memorandum[len - 2] = max;
        return max;
    }
}
