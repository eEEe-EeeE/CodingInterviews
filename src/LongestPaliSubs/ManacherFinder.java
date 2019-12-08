package LongestPaliSubs;

public class ManacherFinder {
    private String processString(String str) {
        if (str == null)
            return null;
        if (str.equals(""))
            return "";
        StringBuilder builder = new StringBuilder("^#");
        int index = 0;
        while (index < str.length()) {
            builder.append(str.charAt(index++));
            builder.append("#");
        }
        builder.append("$");
        return builder.toString();
    }

    String longestPalindrome(String str) {
        String string = processString(str);
        if (string == null)
            return null;
        if (string.equals(""))
            return "";
        int[] P = new int[string.length()];
        int C = 1;
        int R = 2;
        int symmetry;
        for (int i = 1; i < string.length() - 1; ++i) {
            symmetry = 2 * C - i;
            if (R > i) {
                P[i] = Math.min(P[symmetry], R - i);
            }

            while (string.charAt(i + P[i] + 1) == string.charAt(i - P[i] - 1)) {
                ++P[i];
            }
            if (i + P[i] > R) {
                R = i + P[i];
                C = i;
            }
        }

        int maxRadius = 1;
        int maxCenterIndex = 1;
        for (int i = 1; i < string.length() - 1; ++i) {
            if (P[i] > maxRadius) {
                maxRadius = P[i];
                maxCenterIndex = i;
            }
        }
        int startIndex = (maxCenterIndex - maxRadius) / 2;
        return str.substring(startIndex, startIndex + maxRadius);
    }
}
