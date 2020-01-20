package bean;

public class MyList {

    private MyLNode head;
    private MyLNode tail;
    private int size;

    public MyList(int[] arr) {
        if (arr != null)
            for (int v : arr) {
                add(v);
            }
    }

    public MyList() {
    }

    public MyLNode getHead() {
        return head;
    }

    public MyLNode getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }

    public void setHead(MyLNode head) {
        this.head = head;
    }

    public void setTail(MyLNode tail) {
        this.tail = tail;
    }

    public void add(int v) {
        if (tail == null) {
            tail = new MyLNode(v, null);
            head = tail;
        } else {
            tail.next = new MyLNode(v, null);
            tail = tail.next;
        }
        ++size;
    }

    public MyLNode node(int index) {
        if (index < 0 || index >= size)
            return null;
        MyLNode p = head;
        for (int i = 0; i < index; ++i) {
            p = p.next;
        }
        return p;
    }

    public Integer getLastK(int k) {
        if (k < 1 || k > size)
            return null;
        MyLNode pK = head;
        MyLNode cur = head;
        for (int i = 0; i < k; ++i)
            cur = cur.next;
        while (cur != null) {
            cur = cur.next;
            pK = pK.next;
        }
        return pK.value;
    }

    public Integer getMidK() {
        if (size == 0)
            return null;
        if (size == 1 || size == 2)
            return head.value;

        MyLNode fast = head;
        MyLNode slow = head;
        while (true) {
            fast = fast.next;
            if (fast == null)
                break;
            fast = fast.next;
            if (fast == null)
                break;
            slow = slow.next;
        }
        return slow.value;
    }

    public void reformLoop(int entrance) {
        tail.next = node(entrance);
    }

    public void printList() {
        MyLNode p = head;
        while (p != null) {
            System.out.println(p.getValue());
            p = p.getNext();
        }
    }
}
