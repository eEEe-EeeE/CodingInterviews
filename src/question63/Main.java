package question63;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{9, 11, 8, 5, 7, 12, 16, 14};
        int[] arr = Solution.solute(nums);
        System.out.println(arr[0] + " " + arr[1]);
        System.out.println(nums[arr[1]] - nums[arr[0]]);
    }
}
