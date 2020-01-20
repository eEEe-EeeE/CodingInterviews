package question29;

// 顺时针打印矩阵
//
public class Solution {
    static void solute(Integer[][] nums) {
        if (nums == null || nums.length == 0 || nums[0].length == 0)
            return;
        int start = 0;
        while (start <= ((nums.length - 1) >> 1) && start <= ((nums[0].length - 1) >> 1)) {
            print(nums, start);
            ++start;
        }
    }

    private static void print(Integer[][] nums, int start) {
        int endX = nums[0].length - 1 - start;
        int endY = nums.length - 1 - start;

        for (int i = start; i <= endX; ++i) {
            System.out.print(nums[start][i]);
        }
        System.out.println();
        if (endY > start) {
            for (int i = start + 1; i <= endY; ++i) {
                System.out.print(nums[i][endX]);
            }
            System.out.println();
        }

        if (endY > start && endX > start) {
            for (int i = endX - 1; i >= start; --i) {
                System.out.print(nums[endY][i]);
            }
            System.out.println();
        }

        if (endY > start + 1 && endX > start) {
            for (int i = endY - 1; i > start; --i) {
                System.out.print(nums[i][start]);
            }
            System.out.println();
        }

    }
}
