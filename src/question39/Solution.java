package question39;

import java.util.Collections;

// 找出数组中出现次数超过一半的数字
public class Solution {
    static Integer solute(Integer[] arr) {
        if (arr == null || arr.length == 0)
            return null;
        Integer begin = 0;
        Integer end = arr.length - 1;
        int mid = partition1(arr, begin, end);
        while (mid != arr.length / 2) {
            if (mid < arr.length / 2)
                mid = partition2(arr, mid + 1, end);
            else
                mid = partition2(arr, begin, mid - 1);
        }
        int time = 0;
        for (Integer v : arr) {
            if (arr[mid].equals(v))
                ++time;
        }
        if (time * 2 <= arr.length)
            return null;
        return arr[mid];
    }

    private static Integer partition1(Integer[] arr, Integer begin, Integer end) {
        int fast = begin;
        int slow = begin - 1;
        Integer temp = arr[begin];
        arr[begin] = arr[end];
        arr[end] = temp;
        while (fast < end) {
            if (arr[fast] < arr[end]) {
                temp = arr[++slow];
                arr[slow] = arr[fast];
                arr[fast] = temp;
            }
            ++fast;
        }
        temp = arr[++slow];
        arr[slow] = arr[end];
        arr[end] = temp;
        return slow;
    }

    private static Integer partition2(Integer[] arr, Integer begin, Integer end) {
        int left = begin;
        int right = end;
        Integer piv = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= piv)
                --right;
            if (left < right)
                arr[left++] = arr[right];
            while (left < right && arr[left] < piv)
                ++left;
            if (left < right)
                arr[right--] = arr[left];
        }
        arr[left] = piv;
        return left;
    }

    static Integer solute2(Integer[] arr) {
        if (arr == null || arr.length == 0)
            return null;
        Integer num = arr[0];
        Integer time = 1;
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i].equals(num)) {
                ++time;
            } else {
                --time;
                if (time.equals(0)) {
                    ++time;
                    num = arr[i];
                }
            }
        }
        time = 0;
        for (Integer integer : arr) {
            if (integer.equals(num))
                ++time;
        }
        if (time * 2 <= arr.length)
            return null;
        return num;
    }
}
