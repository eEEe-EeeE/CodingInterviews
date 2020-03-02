package question19;


// 包含.和*的正则匹配
public class Solution {
    static boolean solute(String pattern, String text) {
        return match(pattern, text, 0, 0);
    }

    static private boolean match(String pattern, String text, int i, int j) {
        // 处理特殊情况
        if (i == pattern.length()) {
            return j == text.length();
        }
        boolean firstMatch = j != text.length() && (pattern.charAt(i) == text.charAt(j) || pattern.charAt(i) == '.');
        if (i + 1 < pattern.length() && pattern.charAt(i + 1) == '*') {
            return match(pattern, text, i + 2, j) || firstMatch && match(pattern, text, i, j + 1);
        } else {
            return firstMatch && match(pattern, text, i + 1, j + 1);
        }
    }
}
