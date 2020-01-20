package question24;

import bean.MyList;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[0];
        MyList list = new MyList(arr);
        System.out.println(list.getHead());
    }
}
