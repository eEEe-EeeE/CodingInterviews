package LongestCommonPrefix;

public class LstComPre {

    public String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0)
            return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; ++i) {
            if (prefix.equals(""))
                break;
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }


    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0)
            return "";
        String first = strs[0];
        for (int i = 0; i < first.length(); ++i) {
            for (int j = 1; j < strs.length; ++j) {
                if (i == strs[j].length() || first.charAt(i) != strs[j].charAt(i))
                    return first.substring(0, i);
            }
        }
        return first;
    }


    // 尾后模式需要处理 "0"和"1"两种基本情况
    // 非尾后模式 需要处理 "-1"和"0"两种基本情况
    static String lcp(String[] strs) {
        return lcp(strs, 0, strs.length);
    }
    static String lcp(String[] strs, int begin, int end) {
        if (begin == end)
            return "";
        if (end - begin == 1)
            return strs[begin];
        String left = lcp(strs, begin, (begin + end) / 2);
        String right = lcp(strs, (begin + end) / 2, end);
        return commonPrefix(left, right);
    }
    static String commonPrefix(String left, String right) {
        for (int i = 0; i < left.length(); ++i) {
            if (i == right.length() || right.charAt(i) != left.charAt(i))
                return left.substring(0, i);
        }
        return left;
    }


    static String findInHalf(String[] strs) {
        if (strs.length == 0)
            return "";
        int end = strs[0].length();
        for (int i = 1; i < strs.length; ++i) {
            if (strs[i].length() < end)
                end = strs[i].length();
        }
        ++end;

        int begin = 0;
        int mid;
        while (begin != end) {
            mid = (begin + end) / 2;
            if (isCommonPrefix(strs, mid))
                begin = mid + 1;
            else
                end = mid;
        }
        return strs[0].substring(0, end - 1);
    }
    static boolean isCommonPrefix(String[] strs, int len) {
        String prefix = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; ++i) {
            if (!strs[i].startsWith(prefix))
                return false;
        }
        return true;
    }
}
