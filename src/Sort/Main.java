package Sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 0 1 2 3 3 4 4 5 5 6 7 8 9
        int[] arr = new int[]{3, 5, 1, 3, 8, 5, 7, 9, 4, 6, 2, 0, 4};
        int[] nums = {4, 5, 765, 1, 451, 543, 2645, 742, 7, 12, 321324, 43, 453, 234, 243, 2, 2, 6, 757, 876};
        Sorter.mergeSort2(nums);
        for (int v : nums) {
            System.out.print(v);
            System.out.print(' ');
        }
        System.out.println();
    }
}
