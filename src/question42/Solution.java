package question42;

// 求连续子数组的最大和
// 1.递推的 且 2.以一个元素的前一个元素为结束的所有连续子数组中最大的和小于等于0 则以这个元素为结束的最大和的连续子数组为它本身
public class Solution {
    static Integer solute(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;

        int curMaxSum = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i == 0 || sum <= 0) {
                sum = nums[i];
            } else {
                sum = sum + nums[i];
            }
            curMaxSum = Math.max(sum, curMaxSum);
        }
        return curMaxSum; 
    }
}
