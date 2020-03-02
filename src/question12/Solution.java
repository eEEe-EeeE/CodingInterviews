package question12;

// 矩阵中的路径
// 输入：字符矩阵，字符串
// 输出：是否存在与字符串对应的非交叉路径
public class Solution {

    static boolean solute(char[][] matrix, String str) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int r = matrix.length;
        int c = matrix[0].length;
        boolean[][] isVisited = new boolean[r][c];
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if (findPath(matrix, i, j, isVisited, str, 0))
                    return true;
            }
        }
        return false;
    }

    static private boolean findPath(char[][] matrix, int row, int col, boolean[][] isVisited, String str, int i) {
        if (matrix[row][col] == str.charAt(i)) {
            if (!isVisited[row][col]) {
                if (str.length() == i + 1)
                    return true;

                isVisited[row][col] = true;
                boolean E = false;
                boolean S = false;
                boolean W = false;
                boolean N = false;
                if (col + 1 < matrix[0].length)
                    E = findPath(matrix, row, col + 1, isVisited, str, i + 1);
                if (row + 1 < matrix.length)
                    S = findPath(matrix, row + 1, col, isVisited, str, i + 1);
                if (col - 1 >= 0)
                    W = findPath(matrix, row, col - 1, isVisited, str, i + 1);
                if (row - 1 >= 0)
                    N = findPath(matrix, row - 1, col, isVisited, str, i + 1);
                boolean hasPath = E || S || W || N;
                if (!hasPath)
                    isVisited[row][col] = false;
                return hasPath;
            } else
                return false;
        } else
            return false;
    }
}
