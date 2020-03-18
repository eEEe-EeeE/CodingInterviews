package question53;

import Sort.Sorter;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,3,3,3,4,5};
        System.out.println(Solution.solute(nums, 3));
        System.out.println(Solution.solute2(new int[]{0,1,2,3,4,5,7,8,9}));
        System.out.println(Solution.solute3(new int[]{-3,-1,1,4,5}));
    }
}
