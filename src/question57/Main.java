package question57;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,4,7,11,15};
        int[] a = Solution.solute1(nums, 15);
        if (a != null)
            for (int v : a) {
                System.out.println(nums[v]);
            }
        Solution.solute2(15);
    }
}
