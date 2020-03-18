package genericBean;

public class LNode<E> {
    E item;
    LNode<E> next;

    public LNode() {
    }
    public LNode(E item) {
        this.item = item;
    }
    public LNode(E item, LNode<E> next) {
        this.item = item;
        this.next = next;
    }

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public LNode<E> getNext() {
        return next;
    }

    public void setNext(LNode<E> next) {
        this.next = next;
    }

}
