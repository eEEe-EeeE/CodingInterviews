package question61;

import Sort.Sorter;

import java.util.Arrays;

public class Solution {
    // 从扑克牌中随机选5张牌，判断是不是一个顺子
    static boolean solute(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Sorter.quickSort1(copy);
        int zeroNum = 0;
        while (copy[zeroNum] == 0)
            ++zeroNum;
        int breakNum = 0;
        for (int i = zeroNum + 1; i < copy.length; ++i) {
            if (copy[i] == copy[i - 1])
                return false;
            breakNum += copy[i] - copy[i - 1] - 1;
        }
        return zeroNum >= breakNum;
    }
}
