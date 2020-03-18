package question63;

// 股票的最大利润
// 把股票价格按时间顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少
public class Solution {
    // 保存状态法
    static int[] solute(int[] nums) {
        int historyMin = 0;
        int maxProfit = 0;
        int begin = 0;
        int end = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[historyMin] > nums[i])
                historyMin = i;
            if (nums[i] - nums[historyMin] > maxProfit) {
                maxProfit = nums[i] - nums[historyMin];
                begin = historyMin;
                end = i;
            }
        }
        return new int[]{begin, end};
    }
}
