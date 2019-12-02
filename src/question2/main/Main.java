package question2.main;

import question2.solution.Singleton1;
import question2.solution.Singleton2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String s = "dsf";
        System.out.println(Main.atoI("-91283472332"));
    }

    static int atoI(String str) {
        if (str == null || str.equals("") || str.charAt(0) != ' ' && str.charAt(0) != '+' && str.charAt(0) != '-' && !Character.isDigit(str.charAt(0)))
            return 0;

        int index = 0;
        while (true) {
            if (index != str.length()) {
                if (str.charAt(index) == ' ')
                    ++index;
                else
                    break;
            } else {
                return 0;
            }
        }

        long res = 0;
        int sign = 1;
        if (str.charAt(index) == '-') {
            sign = -1;
            ++index;
        }
        else if (str.charAt(index) == '+') {
            sign = 1;
            ++index;
        }
        while (true) {
            if (index == str.length())
                return (int) res * sign;

            if (Character.isDigit(str.charAt(index))) {
                res = res * 10 + (str.charAt(index++) - 48);
                if (res * sign < Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;
                else if (res * sign > Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
            } else {
                return (int) res * sign;
            }
        }

    }
}
