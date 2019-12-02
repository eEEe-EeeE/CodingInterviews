package question6.bean;

public class MyLinkedList<E> {

    private int size = 0;
    private Node<E> head;
    private Node<E> tail;

    private void linkLast(E e) {
        final Node<E> l = tail;
        final Node<E> newNode = new Node<>(e, null);
        tail = newNode;
        if (l == null) {
            head = newNode;
        } else {
            l.next = newNode;
        }
        ++size;
    }

    public boolean add(E item) {
        linkLast(item);
        return true;
    }

    public int getSize() {
        return size;
    }

    public Node<E> getHead() {
        return head;
    }

    public Node<E> getTail() {
        return tail;
    }

    public static class Node<E> {
        E item;
        Node<E> next;
        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
        public Node<E> getNext() {
            return next;
        }
        public E getItem() {
            return item;
        }
    }
}
