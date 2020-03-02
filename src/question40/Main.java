package question40;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = new Integer[] {4,5,1,6,2,7,3,8};
        int k = 4;
        Solution.solute1(arr, k);
        System.out.println();
        Solution.solute2(arr, k);
    }
}
