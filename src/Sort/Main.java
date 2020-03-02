package Sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 0 1 2 3 3 4 4 5 5 6 7 8 9
        int[] arr = new int[]{3,5,1,3,8,5,7,9,4,6,2,0,4};
        Sorter.heapSort(arr);
        for (int v : arr) {
            System.out.print(v);
            System.out.print(' ');
        }
        System.out.println();
    }
}
