package question50;

import org.omg.CORBA.INTERNAL;

import java.util.*;

public class Solution {
    // 求字符串中第一个只出现一次的字符
    static Character solute(String str) {
        if (str == null || str.length() == 0)
            return null;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); ++i) {
            if (map.containsKey(str.charAt(i)))
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            else
                map.put(str.charAt(i), 1);
        }
        for (int i = 0; i < str.length(); ++i) {
            if (map.get(str.charAt(i)).equals(1))
                return str.charAt(i);
        }
        return '\0';
    }

    // 定义一个函数输入两个字符串，从第一个字符串中删除第二个字符串出现过的所有字符
    static String solute1(String str1, String str2) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str2.length(); ++i) {
            set.add(str2.charAt(i));
        }
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < str1.length(); ++i) {
            if (!set.contains(str1.charAt(i)))
                s.append(str1.charAt(i));
        }
        return s.toString();
    }

    // 定义一个函数，删除字符串中所有重复出现的字符
    static String solute2(String str) {
        Set<Character> set = new HashSet<>();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < str.length(); ++i) {
            if (!set.contains(str.charAt(i))) {
                set.add(str.charAt(i));
                s.append(str.charAt(i));
            }
        }
        return s.toString();
    }

    // 两个单词中出现的字母相同，每个字母出现的次数也相同，那么这两个单词互为变位词
    // 完成一个函数，判断两个字符串是否互为变位词
    static boolean solute3(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); ++i) {
            if (map.containsKey(s1.charAt(i))) {
                map.put(s1.charAt(i), map.get(s1.charAt(i)) + 1);
            } else {
                map.put(s1.charAt(i), 1);
            }
        }
        for (int i = 0; i < s2.length(); ++i) {
            if (map.isEmpty())
                return false;
            if (map.containsKey(s2.charAt(i))) {
                map.put(s2.charAt(i), map.get(s2.charAt(i)) - 1);
                if (map.get(s2.charAt(i)).equals(0))
                    map.remove(s2.charAt(i));
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }

    // 字符流中第一个只出现一次的字符
    static void solute() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder str = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        int first = 0;
        int end = 0;
        System.out.println("input ctrl+D to quit.");
        while (scanner.hasNext()) {
            str.append(scanner.next());
            for (int i = end; i < str.length(); ++i) {
                if (map.containsKey(str.charAt(i))) {
                    map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
                } else {
                    map.put(str.charAt(i), 1);
                }
            }
            for (int i = first; i < str.length() && !map.get(str.charAt(i)).equals(1); ++i) {
                ++first;
            }
            if (first == str.length())
                System.out.println('\0');
            else
                System.out.println(str.charAt(first));
            System.out.println("input ctrl+D to quit.");
        }
    }
}
