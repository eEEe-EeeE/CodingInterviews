package question6.solution;

import question6.bean.MyLinkedList;

class LinkedListPrinter<E> {
    void printListReverse(MyLinkedList<E> linkedList) {
        if (linkedList != null && linkedList.getSize() != 0) {
            printRecur(linkedList.getHead());
        }
    }

    private void printRecur(MyLinkedList.Node<E> node) {
        if (node.getNext() != null) {
            printRecur(node.getNext());
        }
        System.out.println(node.getItem());
    }
}
