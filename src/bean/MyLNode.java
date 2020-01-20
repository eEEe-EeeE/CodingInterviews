package bean;

public class MyLNode {
    int value;
    MyLNode next;

    MyLNode(int value, MyLNode next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public MyLNode getNext() {
        return next;
    }

    public void setNext(MyLNode next) {
        this.next = next;
    }


}
