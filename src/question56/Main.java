package question56;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 3, 6, 3, 2, 5, 5};
        for (int v : Solution.solute1(arr)) {
            System.out.println(v);
        }
        int[] arr1 = new int[]{2, 3, 4, 1, 2, 3, 4, 2, 3, 4, 1, 8, 1};
        System.out.println(Solution.solute2(arr1));
    }
}
