package question3.solution;

import question3.beans.Result;
import question3.solution.DupNumFinder;

public class Main {
    public static void main(String[] args) {
        Integer[] a = new Integer[]{2, 3, 5, 4, 3, 2, 6, 7};
        DupNumFinder d = new DupNumFinder();
        Result r = d.findDuplicate2(a);
        System.out.println(r.getFound());
        System.out.println(r.getDupNum());
    }
}
