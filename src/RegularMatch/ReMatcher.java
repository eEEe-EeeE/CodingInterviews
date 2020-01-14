package RegularMatch;

import java.util.regex.Pattern;

public class ReMatcher {

    public static void main(String[] args) {
        System.out.println(Pattern.matches("ab*a*c*a", "aaa"));
        System.out.println(dpUpMatch("", "a*"));
    }
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

    // 子问题结构：dp[1...i][1...j]具有右边界，即左边固定，右边增长
    // 下标分别指代text和pattern的前缀，数组值表示两个前缀是否匹配
    /*
        分析：
        1.前缀P(j)的最后一个字符为一般字符或者.字符，当字符text(i)和pattern(j)匹配且前缀T(i-1)和P(j-1)匹配时前缀T(i)和P(j)匹配
        2.前缀P(j)的最后一个字符为*字符，当字符text(i)和pattern(j-1)不匹配且前缀T(i)和P(j-2)匹配时前缀T(i)和P(j)匹配，限定符匹配0次
        3.前缀P(j)的最后一个字符为*字符，当字符text(i)和pattern(j-1)匹配且前缀T(i)和P(j-2)匹配或者前缀T(i-1)和P(j)匹配时前缀T(i)和P(j)匹配，限定符匹配0次或者多次
        2和3说明，限定符前一个字符不匹配时如果要前缀匹配则限定符只能匹配0次，限定符前一个字符匹配时如果要前缀匹配则限定符可以匹配0次也可以匹配多次
     */
    // 自底向上的dp枚举各种情况
    static boolean dpUpMatch(String s, String p) {
        if (!p.isEmpty() && p.charAt(0) == '*')
            return false;
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        for (int j = 1; j <= p.length(); ++j) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            } else {
                dp[0][j] = false;
            }
        }

        // i和j分别指代text和pattern的前缀
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = 1; j <= p.length(); ++j) {
                if (p.charAt(j - 1) == '*') {
                    if (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                } else {
                    dp[i][j] = (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.')
                            && dp[i - 1][j - 1];
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}
