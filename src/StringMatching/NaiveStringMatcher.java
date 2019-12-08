package StringMatching;

import java.util.ArrayList;

public class NaiveStringMatcher {
    Result matchString(String str, String pat) {
        int strLen = str.length();
        int patLen = pat.length();
        int shift = 0;
        ArrayList<Integer> temp = new ArrayList<>();
        while (shift <= strLen - patLen) {
            if (pat.equals(str.substring(shift, shift + patLen))) {
                temp.add(shift);
            }
            ++shift;
        }
        return new Result(temp.toArray(new Integer[0]));
    }
}
