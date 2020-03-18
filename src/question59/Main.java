package question59;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,4,2,6,2,5,1};
        for (int v : Solution.solute(nums, 3)) {
            System.out.println(v);
        }
        System.out.println();
        QUEUE<Integer> queue = new QUEUE<>();
        queue.offerLast(1);
        queue.offerLast(3);
        queue.offerLast(6);
        queue.offerLast(2);
        queue.pollFirst();
        queue.pollFirst();
        queue.pollFirst();
        System.out.println(queue.peekMax());
    }
}
