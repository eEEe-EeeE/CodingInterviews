package question50;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String str = "张abaccdeff";
        System.out.println(Solution.solute(str));
        System.out.println(Solution.solute1("We are students.", "aeiou"));
        System.out.println(Solution.solute2("google"));
        System.out.println(Solution.solute3("evil", "live"));
        Solution.solute();
    }
}
