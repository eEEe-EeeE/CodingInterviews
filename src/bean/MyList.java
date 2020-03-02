package bean;

public class MyList {

    private LNode head;
    private LNode tail;
    private int size;

    public MyList(int[] arr) {
        if (arr != null)
            for (int v : arr) {
                add(v);
            }
    }

    public MyList() {
    }

    public LNode getHead() {
        return head;
    }

    public LNode getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }

    public void setHead(LNode head) {
        this.head = head;
    }

    public void setTail(LNode tail) {
        this.tail = tail;
    }

    public void add(int v) {
        if (tail == null) {
            tail = new LNode(v, null);
            head = tail;
        } else {
            tail.next = new LNode(v, null);
            tail = tail.next;
        }
        ++size;
    }

    public LNode node(int index) {
        if (index < 0 || index >= size)
            return null;
        LNode p = head;
        for (int i = 0; i < index; ++i) {
            p = p.next;
        }
        return p;
    }

    public Integer getLastK(int k) {
        if (k < 1 || k > size)
            return null;
        LNode pK = head;
        LNode cur = head;
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

        LNode fast = head;
        LNode slow = head;
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
        LNode p = head;
        while (p != null) {
            System.out.println(p.getValue());
            p = p.getNext();
        }
    }
}
