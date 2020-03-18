package question47;

// 礼物的最大价值
// 礼物放在m*n的棋盘上
// 每个礼物有确定的价值大于零
// 从左上角开始，每次只能移动一步，向右或者向下，直到右下角，求最大价值
public class Solution {
    private static class Point {
        int r;
        int c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
        int getR() {
            return r;
        }
        int getC() {
            return c;
        }
    }
    static int solute(int[][] values) {
        if (values == null || values.length == 0 || values[0].length == 0)
            return 0;
        int cLen = values[0].length;
        for (int[] c : values)
            if (c.length != cLen)
                return 0;
        int[] memorandum = new int[values.length];
        // 假设只有唯一的路径，也就是只有r=rLen - 1 c=cLen - 1时rightValue==downValue
        Point[][] nextHop = new Point[values.length][values[0].length];
        int result = soluteRec(values, memorandum, 0, 0, nextHop);
        int r = 0;
        int c = 0;
        Point p;
        while (r != values.length || c != values[0].length) {
            System.out.print(values[r][c]);
            System.out.print(' ');
            p = nextHop[r][c];
            r = p.getR();
            c = p.getC();
        }
        System.out.println();
        return result;
    }

    // 终点固定，以r，c为起点的最大价值
    private static int soluteRec(int[][] values, int[] memorandum, int r, int c, Point[][] nextHop) {
        if (r == values.length || c == values[0].length)
            return 0;
        else {
            int rightValue;
            if (memorandum[r] != 0)
                rightValue = memorandum[r];
            else
                rightValue = soluteRec(values, memorandum, r, c + 1,nextHop);
            int downValue = soluteRec(values, memorandum, r + 1, c,nextHop);
            int maxValue;
            if (rightValue < downValue) {
                maxValue = values[r][c] + downValue;
                nextHop[r][c] = new Point(r + 1, c);
            } else if (rightValue > downValue) {
                maxValue = values[r][c] + rightValue;
                nextHop[r][c] = new Point(r, c + 1);
            } else {
                maxValue = values[r][c] + rightValue;
                nextHop[r][c] = new Point(values.length, values[0].length);
            }
            memorandum[r] = maxValue;
            return maxValue;
        }
    }
}
