package question5.solution;

import question5.beans.Result;

class SpaceReplacer {
    Result replaceSpace(String s, String key) {
        int cnt = 0;
        char SPACE = ' ';
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == SPACE) {
                ++cnt;
            }
        }
        if (cnt == 0) {
            return new Result(s);
        }
        int len = s.length() + cnt * (key.length() - 1);
        char[] s1 = new char[len];
        int ch_i = len - 1;
        for (int i = s.length() - 1; i >= 0; --i) {
            if (s.charAt(i) != SPACE) {
                s1[ch_i--] = s.charAt(i);
            } else {
                for (int j = key.length() - 1; j >= 0; --j) {
                    s1[ch_i--] = key.charAt(j);
                }
            }
        }
        return new Result(String.valueOf(s1));
    }
}
