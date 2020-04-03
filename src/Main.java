import Sort.Sorter;
import bean.BTNode;
import java.text.DecimalFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {

    }

    static void sort(char[] array, int begin, int end) {
        if (end - begin > 0) {
            int bound = partition(array, begin, end);
            sort(array, begin, bound - 1);
            sort(array, bound + 1, end);
        }
    }

    static int partition(char[] array, int begin, int end) {
        int slow = begin - 1;
        int fast = begin;
        while (fast < end) {
            if (array[fast] < array[end])
                swap(array, ++slow, fast);
            ++fast;
        }
        swap(array, ++slow, fast);
        return slow;
    }

    static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}