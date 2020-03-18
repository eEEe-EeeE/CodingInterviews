package question56;

import java.util.ArrayList;

public class Solution {
    // 一个数组除了两个数以外，其他数字都出现了两次，找出两个只出现一次的数字，要求时间复杂度n，空间复杂度1
    static int[] solute1(int[] nums) {
        if (nums == null || nums.length <= 1)
            return null;
        int tmp = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            tmp ^= nums[i];
        }
        tmp = tmp & -tmp;
        int xor1 = 0;
        int xor2 = 0;
        for (int v : nums) {
            if ((v & tmp) == 0)
                xor1 ^= v;
            else
                xor2 ^= v;
        }
        return new int[]{xor1, xor2};
    }

    // 在一个数组中除一个数字只出现一次以外，其他数字都出现了三次，找出只出现一次的数字
    static int solute2(int[] nums) {
        int mask = 1;
        int sum;
        int result = 0;
        for (int i = 0; i < Integer.SIZE; ++i) {
            mask <<= i;
            sum = 0;
            for (int num : nums) {
                sum += (num & mask) != 0 ? 1 : 0;
            }
            result += sum % 3 != 0 ? mask : 0;
        }
        return result;
    }
}
