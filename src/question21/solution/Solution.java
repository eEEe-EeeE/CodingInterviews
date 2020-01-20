package question21.solution;

// 写一个函数，把数组中所有奇数放在前面，所有偶数放在后面
public class Solution {
    static void solute(int[] arr) {
        if (arr == null || arr.length <= 1)
            return;
        int bound = -1;
        int pos = 0;
        while (pos != arr.length) {
            if (!isEven(arr[pos])) {
                ++bound;
                if (bound != pos) {
                    arr[bound] ^= arr[pos];
                    arr[pos] ^= arr[bound];
                    arr[bound] ^= arr[pos];
                }
            }
            ++pos;
        }
    }

    static void solute2(int[] arr) {
        if (arr == null || arr.length <= 1)
            return;
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            while (left < right && !isEven(arr[left]))
                ++left;
            while (left < right && isEven(arr[right]))
                --right;
            if (left < right) {
                arr[left] ^= arr[right];
                arr[right] ^= arr[left];
                arr[left] ^= arr[right];
                ++left;
                --right;
            }
        }
    }

    static private boolean isEven(int num) {
        return (num & 1) == 0;
    }
}
