package question13;

// 机器人的运动范围
// 输入矩阵的长和宽，约束K
// 输出能走的格子数目
public class Solution {
    static int solute(int nrow, int ncol, int k) {
        if (k < 0 || nrow <= 0 || ncol <= 0)
            return 0;
        boolean[][] visited = new boolean[nrow][ncol];
        return countGrid(nrow, ncol, 0, 0, visited, k);
    }

    static private int countGrid(int nrow, int ncol, int row, int col, boolean[][] visited, int k) {
        if (0 <= row && row < nrow && 0 <= col && col < ncol) {
            if (!visited[row][col] && getSum(row, col) <= k) {
                visited[row][col] = true;
                return 1 + countGrid(nrow, ncol, row, col + 1, visited, k) +
                        countGrid(nrow, ncol, row, col - 1, visited, k) +
                        countGrid(nrow, ncol, row + 1, col, visited, k) +
                        countGrid(nrow, ncol, row - 1, col, visited, k);
            } else
                return 0;
        } else
            return 0;
    }

    static private int getSum(int row, int col) {
        int cnt = 0;
        while (row > 0) {
            cnt += row % 10;
            row /= 10;
        }
        while (col > 0) {
            cnt += col % 10;
            col /= 10;
        }
        return cnt;
    }
}
