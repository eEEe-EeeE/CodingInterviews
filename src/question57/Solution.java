package question57;

public class Solution {
    // 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得他们的和正好是s，输出任意一对
    static int[] solute1(int[] nums, int s) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] < s) {
                ++left;
            } else if (nums[left] + nums[right] > s) {
                --right;
            } else {
                return new int[]{left, right};
            }
        }
        return null;
    }

    // 输入一个正数，打印所有和为s的正数序列，至少含有两个数
    static void solute2(int s) {
        int left = 1;
        int right = 2;
        int sum = 3;
        while (right <= (1 + s) / 2) {
            if (sum < s) {
                ++right;
                sum += right;
            } else if (sum > s) {
                sum -= left;
                ++left;
            } else {
                for (int i = left; i <= right; ++i) {
                    System.out.print(i);
                    System.out.print(' ');
                }
                System.out.println();
                ++right;
                sum += right;
                sum -= left;
                ++left;
            }
        }
    }
}
