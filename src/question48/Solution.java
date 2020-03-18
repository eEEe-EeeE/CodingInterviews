package question48;

import java.util.HashMap;
import java.util.Map;

// 求一个字符串的最长不含重复字符的子串
public class Solution {
    static String solute(String str) {
        if (str == null || str.length() == 0)
            return null;
        // map里是滑动窗口遍历过的字母以及该字母前一个位置的索引，新的索引会覆盖旧的索引
        Map<Character, Integer> map = new HashMap<>();
        int left = str.length() - 1;
        int right = str.length() - 1;
        int begin = 0;
        int maxLen = 0;
        while (left >= 0) {
            if (map.containsKey(str.charAt(left))) {
                // 遍历过的字母可能已经不在窗口内了，就不用跳转right，否则要跳转right
                right = Math.min(right, map.get(str.charAt(left)));
            }
            map.put(str.charAt(left), left - 1);
            if ((right - left + 1) >= maxLen) {
                maxLen = right - left + 1;
                begin = left;
            }
            --left;
        }
        return "(" + begin + "," + maxLen + ")";
    }
}
