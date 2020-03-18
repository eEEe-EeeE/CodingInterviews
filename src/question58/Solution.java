package question58;

// 翻转字符串
public class Solution {
    // 翻转英文句子，单词内部顺序不变
    static void solute1(char[] string) {
        if (string == null || string.length == 0)
            return;
        symmetry(string, 0, string.length - 1);
        int begin = 0;
        while (begin < string.length && string[begin] == ' ')
            ++begin;
        int end = begin;
        while (end < string.length) {
            if (string[end] == ' ') {
                symmetry(string, begin, end - 1);
                ++end;
                begin = end;
            } else {
                ++end;
            }
        }
    }
    private static void symmetry(char[] arr, int left, int right) {
        if (arr == null || arr.length <= 1 || left >= right)
            return;
        char tmp;
        while (left < right) {
            tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            ++left;
            --right;
        }
    }

    // 左旋转字符串
    static void solute2(char[] string, int k) {
        if (string == null || string.length <= 1 || k == 0)
            return;
        symmetry(string, 0, string.length - 1);
        symmetry(string, 0, string.length - k - 1);
        symmetry(string, string.length - k, string.length - 1);
    }
}
