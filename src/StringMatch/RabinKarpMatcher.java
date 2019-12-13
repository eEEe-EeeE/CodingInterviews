package StringMatch;

import java.util.ArrayList;

public class RabinKarpMatcher {
    Result matchString(String str, String pat, Integer base, Integer mod) {
        int strLen = str.length();
        int patLen = pat.length();
        int p = 0;
        int t = 0;
        for (int i = 0; i < patLen; ++i) {
            p = base * p + pat.charAt(i);
            t = base * t + str.charAt(i);
        }

        int h = 1;
        for (int i = 1; i < patLen; ++i) {
            h *= base;
        }
        h %= mod;

        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i <= strLen - patLen; ++i) {
            if (p == t) {
                if (pat.equals(str.substring(i, i + patLen))) {
                    temp.add(i);
                }
            }

            if (i < strLen - patLen) {
                t = (base * (t - h * str.charAt(i)) + str.charAt(i + patLen)) % mod;
            }
        }

        return new Result(temp.toArray(new Integer[0]));

    }
}
