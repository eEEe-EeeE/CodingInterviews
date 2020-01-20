package question30;

public class Main {
    public static void main(String[] args) {
        Solution.MyStack stack = new Solution.MyStack();
        stack.push(3);
        stack.push(4);
        stack.push(2);
        stack.push(1);
        System.out.println(stack.peekMin());
        stack.pop();
        stack.pop();
        System.out.println(stack.peekMin());
        stack.push(0);
        System.out.println(stack.peekMin());
    }
}
