package question9.solution;

import java.util.LinkedList;
import java.util.Queue;

public class StackBy2Queues<E> {
    Queue<E> q1 = new LinkedList<>();
    Queue<E> q2 = new LinkedList<>();

    void pushTop(E item) {
        if (q1.isEmpty()) {
            q2.add(item);
        } else {
            q1.add(item);
        }
    }

    E popTop() {
        if (q1.isEmpty()) {
            int len = q2.size();
            while (len > 1) {
                q1.add(q2.remove());
                --len;
            }
            if (!q2.isEmpty())
                return q2.remove();
            else
                return null;
        } else {
            int len = q1.size();
            while (len > 1) {
                q2.add(q1.remove());
                --len;
            }
            if (!q1.isEmpty())
                return q1.remove();
            else
                return null;
        }
    }
}
