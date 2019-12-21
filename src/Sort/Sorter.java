package Sort;

public class Sorter {
    public static void main(String[] args) {
        int[] nums = {4, 5, 765, 1, 451, 543, 2645, 742, 7, 12, 321324, 43, 453, 234, 243, 2, 2, 6, 757, 876};
        System.out.println(nums.length);
        quickSort2(nums);
        for (int i : nums) {
            System.out.print(i + ", ");
        }
        System.out.println(nums.length);
    }

    static void quickSort1(int[] nums) {
        quick_sort1(nums, 0, nums.length);
    }

    private static void quick_sort1(int[] nums, int begin, int end) {
        if (end - begin > 1) {
            int base = partition(nums, begin, end);
            quick_sort1(nums, begin, base);
            quick_sort1(nums, base + 1, end);
        }
    }

    private static int partition(int[] nums, int begin, int end) {
        int index = begin;
        int last_small = begin;
        int base_point = end - 1;
        int temp;

        while (index != base_point) {
            if (nums[index] < nums[base_point]) {
                temp = nums[last_small];
                nums[last_small] = nums[index];
                nums[index] = temp;
                ++last_small;
            }
            ++index;
        }

        temp = nums[last_small];
        nums[last_small] = nums[base_point];
        nums[base_point] = temp;
        return last_small;
    }

    static void quickSort2(int[] nums) {
        quick_sort2(nums, 0, nums.length - 1);
    }

    private static void quick_sort2(int[] nums, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;
            int temp = nums[left];
            while (i != j) {
                while (j != i && nums[j] >= temp)
                    --j;
                if (j != i) {
                    nums[i] = nums[j];
                    ++i;
                }

                while (i != j && nums[i] < temp)
                    ++i;
                if (i != j) {
                    nums[j] = nums[i];
                    --j;
                }
            }
            nums[i] = temp;
            quick_sort2(nums, left, i - 1);
            quick_sort2(nums, i + 1, right);
        }
    }
}
