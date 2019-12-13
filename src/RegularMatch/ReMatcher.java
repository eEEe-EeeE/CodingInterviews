package RegularMatch;

public class ReMatcher {

    /*
        判断字符串和模式是否匹配，不是字符串的某个真子串和模式是否匹配
        匹配：字符串的每个字符都能映射到模式的某个字符上且是满射  f(字符串的一个字符) = 模式的一个字符
        或者：模式的每个字符(不包括限定符)都能映射到字符串的一个子串上(包括空字符串)且是满射，一般是这种情况
        主要两种情况：1.和不带限定符的字符匹配 2.和带限定符的字符匹配
     */
    public static boolean isMatch(String text, String pattern) {
        int[][] dp = new int[text.length() + 1][pattern.length() + 1];
        return dpDownMatch(0, 0, text, pattern, dp) == 1;
    }

    // 0: 备忘录未填充
    // 1: 填充为true
    // 2: 填充为false
    // 子问题结构：dp[1...i][1...j]具有左边界
    private static int dpDownMatch(int i, int j, String text, String pattern, int[][] dp) {
        if (dp[i][j] != 0)
            return dp[i][j];
        if (j == pattern.length())
            if (i == text.length()) {
                dp[i][j] = 1;
                return 1;
            } else {
                dp[i][j] = 2;
                return 2;
            }
        int firstMatch;
        if (i != text.length() && (text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.'))
            firstMatch = 1;
        else
            firstMatch = 2;
        if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
            if (dpDownMatch(i, j + 2, text, pattern, dp) == 1 ||
                    firstMatch == 1 && dpDownMatch(i + 1, j, text, pattern, dp) == 1)
                dp[i][j] = 1;
            else
                dp[i][j] = 2;
        } else {
            if (firstMatch == 1 && dpDownMatch(i + 1, j + 1, text, pattern, dp) == 1)
                dp[i][j] = 1;
            else
                dp[i][j] = 2;
        }
        return dp[i][j];
    }

    // 子问题结构：dp[1...i][1...j]具有右边界
    static boolean dpUpMatch(String text, String pattern) {
        if (pattern.isEmpty())
            return text.isEmpty();
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        boolean firstMatch;
        for (int i = 0; i <= text.length(); ++i) {
            for (int j = 0; j <= pattern.length(); ++j) {
                firstMatch = i != text.length() && (text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.');
                if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {

                } else {

                }
            }
        }

        return dp[text.length()][pattern.length()];
    }
}
