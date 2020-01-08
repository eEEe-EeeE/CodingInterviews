package question11.solution;

// 旋转数组的最小数字
// 输入：旋转数组
// 输出：最小数字索引
public class Solution {
    static int solute(int[] array) {
        if (array == null || array.length == 0)
            return -1;

        int len = array.length;
        if (array[0] < array[len - 1])
            return array[0];

        int left = 0;
        int right = len - 1;
        int mid;
        int res;
        while (right - left != 1) {
            mid = (left + right) / 2;
            if (array[left] == array[right]) {
                if (array[mid] == array[left]) {
                    int index = left + 1;
                    res = left;
                    while (index <= right) {
                        if (array[index] < array[res])
                            res = index;
                        ++index;
                    }
                    return res;
                } else if (array[mid] > array[left]) {
                    left = mid;
                } else {
                    right = mid;
                }
            } else {
                if (array[mid] >= array[left])
                    left = mid;
                else if (array[mid] <= array[right])
                    right = mid;
                else {
                    System.out.println("error array.");
                    return -1;
                }
            }
        }
        return right;
    }
}
