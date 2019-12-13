package StringMatch;

import java.util.ArrayList;

// 尽早结束策略：利用历史信息消减多余的计算
// 使用尽早结束策略的方法有：动态规划，马拉车算法，KMP算法
public class KMPMatcher {

    // 前缀函数：Pq真后缀对P的最长前缀长度
    private MyPattern computePrefixFunc(String patStr) {
        MyPattern pattern = new MyPattern(patStr);
        int len = pattern.getPatStr().length();
        // 读入字符a之前的状态
        int k = 0;
        pattern.setPreFixFunc(1, 0);
        for (int q = 2; q <= len; ++q) {
            // 调整Pq-1的匹配状态，再比较P[k+1]和a
            while (k > 0 && pattern.getPatStr().charAt(k + 1) != pattern.getPatStr().charAt(q)) {
                k = pattern.getPreFixFunc(k);
            }
            if (pattern.getPatStr().charAt(k + 1) == pattern.getPatStr().charAt(q)) {
                ++k;
            }
            pattern.setPreFixFunc(q, k);
        }
        return pattern;
    }

    Result matchString(String textStr, String patStr) {
        int tLen = textStr.length();
        int pLen = patStr.length();
        MyPattern pattern = computePrefixFunc(patStr);
        int k = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < tLen; ++i) {
            while (k > 0 && pattern.getPatStr().charAt(k + 1) != textStr.charAt(i)) {
                k = pattern.getPreFixFunc(k);
            }
            if (pattern.getPatStr().charAt(k + 1) == textStr.charAt(i)) {
                ++k;
            }
            if (k == pLen) {
                list.add(i - pLen + 1);
                // 易漏写
                k = pattern.getPreFixFunc(k);
            }
        }
        return new Result(list.toArray(new Integer[0]));
    }
}
