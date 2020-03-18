package question53;

public class Solution {
    // 统计一个数字在排序数组中出现的次数
    static int solute(int[] nums, int key) {
        int first = getFirstKeyIndex(nums, key);
        if (first == -1)
            return 0;
        int last = getLastKeyIndex(nums, key);
        return last - first + 1;
    }
    private static int getFirstKeyIndex(int[] nums, int key) {
        int mid;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] < key) {
                left = mid + 1;
            } else if (nums[mid] > key) {
                right = mid - 1;
            } else if (mid - 1 < 0 || nums[mid - 1] != key) {
                return mid;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private static int getLastKeyIndex(int[] nums, int key) {
        int mid;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] < key) {
                left = mid + 1;
            } else if (nums[mid] > key) {
                right = mid - 1;
            } else if (mid + 1 >= nums.length || nums[mid + 1] != key) {
                return mid;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    // 长度为n-1的递增排序数组所有数字都是唯一的，并且取值范围是0~n-1，范围内的n个数字只有一个不在数组中，找出这个数字
    static int solute2(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        int mid;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else if (mid - 1 < 0 || nums[mid - 1] == mid - 1) {
                return mid;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    static int solute3(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        int mid;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] > mid) {
                right = mid - 1;
            } else if (nums[mid] < mid) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
