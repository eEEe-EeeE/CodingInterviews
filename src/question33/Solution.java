package question33;

// 搜索二叉树的后序遍历序列
// 输入一个整数数组判断该数组是不是某二叉搜索树的后序遍历序列。
public class Solution {
    static boolean solute(int[] seq) {
        if (seq == null)
            return false;
        if (seq.length == 0)
            return true;
        return _solute(seq, 0, seq.length);
    }

    static boolean _solute(int[] seq, int begin, int end) {
        if (end - begin == 1)
            return true;
        // 小于和大于的反转次数
        int cnt = 0;
        // 后序序列的根结点值
        int root = seq[end - 1];
        // 初始状态
        boolean state = seq[begin] < root;
        // 右子树起始索引
        int rightIndex = state ? end - 1 : begin;
        for (int i = begin + 1; i < end - 1; ++i) {
            if (seq[i] < root != state) {
                if (cnt == 0 && state)
                    rightIndex = i;
                ++cnt;
                state = seq[i] < root;
            }
        }
        if (cnt > 1 || cnt == 1 && state)
            return false;
        boolean left = true;
        if (rightIndex > begin)
            left = _solute(seq, begin, rightIndex);
        boolean right = true;
        if (rightIndex < end - 1)
            right = _solute(seq, rightIndex, end - 1);
        return left && right;
    }

    static boolean solute2(int[] seq) {
        if (seq == null)
            return false;
        if (seq.length == 0)
            return true;
        return _solute2(seq, 0, seq.length);
    }

    static boolean _solute2(int[] seq, int begin, int end) {
        if (end - begin == 1)
            return true;
        int root = seq[end - 1];
        int i = begin;
        while (i < end - 1 && root > seq[i]) {
            ++i;
        }

        int j = i;
        while (j < end - 1 && root < seq[j]) {
            ++j;
        }

        if (j != end - 1)
            return false;

        boolean left = true;
        if (i > begin)
            left = _solute2(seq, begin, i);
        boolean right = true;
        if (i < end - 1)
            right = _solute2(seq, i, end - 1);
        return left && right;
    }
}
