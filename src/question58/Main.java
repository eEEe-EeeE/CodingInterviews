package question58;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String s = "I am a student.";
        char[] str = s.toCharArray();
        Solution.solute1(str);
        System.out.println(str);
        char[] str1 = "abcdefg".toCharArray();
        Solution.solute2(str1, 2);
        System.out.println(str1);
    }
}
