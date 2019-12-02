package question6.solution;

import question6.bean.MyLinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedListPrinter<Integer> printer = new LinkedListPrinter<>();
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        printer.printListReverse(list);
    }
}
