package bean;

public class LNode {
    Integer value;
    LNode next;

    public LNode() {}
    public LNode(Integer value) { this.value = value; }
    public LNode(Integer value, LNode next) {
        this.value = value;
        this.next = next;
    }

    public static LNode createList(Integer[] arr) {
        if (arr != null && arr.length != 0) {
            LNode head = new LNode();
            LNode p = head;
            for (Integer v : arr) {
                p.setNext(new LNode(v, null));
                p = p.getNext();
            }
            return head.getNext();
        }
        return null;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public LNode getNext() {
        return next;
    }

    public void setNext(LNode next) {
        this.next = next;
    }


}
