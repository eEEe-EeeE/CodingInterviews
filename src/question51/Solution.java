package question51;

import java.util.Arrays;

// 求数组中逆序对的总数
public class Solution {
    static int solute(int[] nums) {
        if (nums == null || nums.length <= 1)
            return 0;
        int[] copy = Arrays.copyOf(nums, nums.length);
        return mergeSolute(copy, nums, 0, nums.length - 1);
    }

    private static int mergeSolute(int[] sourceArr, int[] mergeArr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            int ln = mergeSolute(mergeArr, sourceArr, left, mid);
            int rn = mergeSolute(mergeArr, sourceArr, mid + 1, right);
            int i = left;
            int j = mid + 1;
            int k = left;
            int reverseOrdinal = 0;
            while (i <= mid && j <= right) {
                if (sourceArr[i] <= sourceArr[j]) {
                    mergeArr[k++] = sourceArr[i++];
                } else {
                    mergeArr[k++] = sourceArr[j++];
                    reverseOrdinal += (mid - i + 1);
                }
            }
            while (i <= mid) {
                mergeArr[k++] = sourceArr[i++];
            }
            while (j <= right) {
                mergeArr[k++] = sourceArr[j++];
            }
            return ln + rn + reverseOrdinal;
        } else {
            return 0;
        }
    }
}
