package question9.solution;

import java.util.Stack;

public class QueueBy2Stacks<E> {
    Stack<E> s1 = new Stack<>();
    Stack<E> s2 = new Stack<>();

    void appendTail(final E item) {
        s1.push(item);
    }

    E deleteHead() {
        if (s2.empty()) {
            while (!s1.empty())
                s2.push(s1.pop());
            if (!s2.empty())
                return s2.pop();
            else
                return null;
        } else {
            return s2.pop();
        }
    }
}
