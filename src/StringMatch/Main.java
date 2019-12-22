package StringMatch;

import java.nio.charset.Charset;

public class Main {
    public static void main(String[] args) {
        KMPMatcher matcher = new KMPMatcher();
        String text = "aaa";
        String pattern = "aa";
        Result res = matcher.matchString(text, pattern);
        for (Integer s : res.getEffectiveShifts()) {
            System.out.println(s);
            System.out.println(text.substring(s, s + pattern.length()));
        }


    }
}
