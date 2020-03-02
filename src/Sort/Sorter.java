package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

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

    /**
     * @ 快速排序
     * 基于分区
     * 基于挖坑填数
     */
    public static void quickSort1(int[] nums) {
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

    public static void quickSort2(int[] nums) {
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

    /**
     * @ 归并排序
     * 左右子数组的分界不一定为索引中位数
     * 必须归并两个有序数组
     */
    public static int[] mergeSort1(int[] nums) {
        if (nums == null || nums.length <= 1)
            return nums;
        int[] left = mergeSort1(Arrays.copyOfRange(nums, 0, nums.length / 2));
        int[] right = mergeSort1(Arrays.copyOfRange(nums, nums.length / 2, nums.length));
        return merge1(left, right);
    }

    private static int[] merge1(int[] left, int[] right) {
        int[] mergeArr = new int[left.length + right.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                mergeArr[k++] = left[i++];
            else
                mergeArr[k++] = right[j++];
        }
        while (i < left.length)
            mergeArr[k++] = left[i++];
        while (j < right.length)
            mergeArr[k++] = right[j++];
        return mergeArr;
    }

    public static void mergeSort2(int[] nums) {
        if (nums == null)
            return;
        int[] tmp = new int[nums.length];
        mergeSort2Rec(nums, tmp, 0, nums.length - 1);
    }

    private static void mergeSort2Rec(int[] sourceArr, int[] mergeArr, int left, int right) {
        if (left < right) {
            mergeSort2Rec(sourceArr, mergeArr, left, (left + right) / 2);
            mergeSort2Rec(sourceArr, mergeArr, (left + right) / 2 + 1, right);
            merge2(sourceArr, mergeArr, left, right);
        }
    }

    private static void merge2(int[] sourceArr, int[] mergeArr, int left, int right) {
        _merge(sourceArr, mergeArr, left, (left + right) / 2, right);
        while (left <= right) {
            sourceArr[left] = mergeArr[left];
            ++left;
        }
    }

    public static void mergeSort3(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        int[] sourceArr = nums;
        int[] mergeArr = new int[sourceArr.length];
        // 子问题规模从2开始到小于数组长度的最大子问题规模为止，每次规模增加一倍
        // seg是子问题规模的一半
        for (int seg = 1; seg < sourceArr.length; seg += seg) {
            // 依次处理所有子问题
            // 子问题的起始位置和规模确定了，就可合并数组的某一部分了
            for (int start = 0; start < sourceArr.length; start = start + (seg << 1)) {
                // 自底向上计算时，有序子数组分界线不一定等于mid，所以不能用(left + right) / 2计算
                int bound = Math.min(start + seg - 1, sourceArr.length - 1);
                int right = Math.min(sourceArr.length - 1, start + (seg << 1) - 1);
                _merge(sourceArr, mergeArr, start, bound, right);
            }
            int[] tmp = sourceArr;
            sourceArr = mergeArr;
            mergeArr = tmp;
        }
        if (sourceArr != nums)
            System.arraycopy(sourceArr, 0, nums, 0, sourceArr.length);
    }

    private static void _merge(int[] sourceArr, int[] mergeArr, int left, int bound, int right) {
        int i = left;
        int j = bound + 1;
        int k = left;
        while (i <= bound && j <= right) {
            if (sourceArr[i] <= sourceArr[j])
                mergeArr[k++] = sourceArr[i++];
            else
                mergeArr[k++] = sourceArr[j++];
        }
        while (i <= bound)
            mergeArr[k++] = sourceArr[i++];
        while (j <= right)
            mergeArr[k++] = sourceArr[j++];
    }

    /**
     * @ 冒泡排序
     */
    static void bubbleSort(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        for (int i = nums.length - 1; i >= 1; --i)
            for (int j = 0; j < i; ++j) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
    }

    /**
     * @ 选择排序
     * 比较后保存元素索引
     * 赋值时再取元素
     */
    static void selectSort(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        for (int trip = 0; trip < nums.length - 1; ++trip) {
            // 选择一个位置trip
            int index = trip;
            for (int i = trip + 1; i < nums.length; ++i) {
                if (nums[i] < nums[index])
                    index = i;
            }
            if (trip != index) {
                int tmp = nums[trip];
                nums[trip] = nums[index];
                nums[index] = tmp;
            }
        }
    }

    /**
     * @ 插入排序
     */
    static void insertSort(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        for (int i = 1; i < nums.length; ++i) {
            int tmp = nums[i];
            int index = i - 1;
            while (index >= 0 && tmp < nums[index]) {
                nums[index + 1] = nums[index];
                --index;
            }
            if (index + 1 != i)
                nums[index + 1] = tmp;
        }
    }

    /**
     * @ 希尔排序
     * 增量序列最后一个值为一
     * 增量解释为组数或者取值间隔数
     */
    static void shellSort(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        // 增量序列
        // 1.an = 1(n = 1) or 3an + 1(n > 1)
        // 2.an = 2^n - 1
        int gap = 1;
        while (gap < nums.length)
            gap = 3 * gap + 1;
        // 最终gap必须为1，进行最后的排序
        while (gap > 0) {
            // 并发地对这趟所有逻辑分组进行插入排序
            for (int i = gap; i < nums.length; ++i) {
                // 待插入的元素
                int tmp = nums[i];
                // 遍历逻辑分组的索引
                int index = i - gap;
                // 逻辑索引应该在物理范围内
                while (index >= 0 && tmp < nums[index]) {
                    nums[index + gap] = nums[index];
                    index -= gap;
                }
                if (index + gap != i)
                    nums[index + gap] = tmp;
            }
            gap /= 3;
        }
    }

    /**
     * @ 桶排序
     * 偏移数轴（自然数集）上求商和余
     */
    public static void bucketSort(int[] nums) {
        // 在自然数集上求商和余所以要定义周期长度，找到最小值，求某个数到最小值的偏移，再用偏移求商和余
        if (nums == null || nums.length <= 0)
            return;
        int bucketSize = 5;
        _bucketSort(nums, bucketSize);
    }

    private static void _bucketSort(int[] nums, int bucketSize) {
        // 桶容量实际上指的是能容纳的不同偏移数
        int minValue = 0;
        int maxValue = 0;
        for (int v : nums) {
            if (v < minValue)
                minValue = v;
            else if (v > maxValue)
                maxValue = v;
        }
        // 留一个数出来，其他数求商，如果有余数放到多出来的一个桶里，没有余数把留的这个数放到多出来的一个桶里
        int bucketNum = (maxValue - minValue) / bucketSize + 1;
        int[][] buckets = new int[bucketNum][0];
        for (int v : nums) {
            int i = (v - minValue) / bucketSize;
            buckets[i] = appendArr(buckets[i], v);
        }

        int i = 0;
        for (int[] bucket : buckets) {
            if (bucket.length > 1) {
                insertSort(bucket);
                for (int v : bucket)
                    nums[i++] = v;
            }
        }
    }

    private static int[] appendArr(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }

    /**
     * @ 基数排序
     * 数码，位数，基数，位权
     */
    static void radixSort(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;

        int maxValue = 0;
        int minValue = 0;
        for (int v : nums) {
            if (v > maxValue)
                maxValue = v;
            else if (v < minValue)
                minValue = v;
        }

        if (maxValue == minValue)
            return;

        int radix = 10;
        int maxDigit = 0;
        int tmp = maxValue;
        while (tmp != 0) {
            ++maxDigit;
            tmp /= radix;
        }

        tmp = minValue;
        while (tmp != 0) {
            ++maxDigit;
            tmp /= radix;
        }

        int[][] buckets = new int[radix][0];

        for (int i = 0; i < maxDigit; ++i) {
            for (int v : nums) {
                int digit = getDigital(v, i, radix);
                buckets[digit] = appendArr(buckets[digit], v);
            }
            int n = 0;
            for (int j = 0; j < buckets.length; ++j) {
                if (buckets[j].length != 0) {
                    for (int v : buckets[j]) {
                        nums[n++] = v;
                    }
                    buckets[j] = new int[0];
                }
            }
        }
    }

    private static int getDigital(int number, int digit, int radix) {
        while (digit != 0) {
            number /= radix;
            --digit;
        }
        return number % radix;
    }

    /**
     * @ 计数排序
     */
    // 在混排数组中，如果知道某个数在数组中小于等于它的元素数目就知道它应该排在哪
    static void countSort(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        int minValue = nums[0];
        int maxValue = nums[0];
        for (int v : nums) {
            if (v < minValue)
                minValue = v;
            else if (v > maxValue)
                maxValue = v;
        }
        int[] countArr = new int[maxValue - minValue + 1];
        for (int v : nums)
            countArr[v - minValue] += 1;
        if (countArr.length > 1)
            for (int i = 1; i < countArr.length; ++i)
                countArr[i] += countArr[i - 1];
        int index = 0;
        int[] result = new int[nums.length];
        for (int v : nums)
            result[countArr[v - minValue]-- - 1] = v;
        System.arraycopy(result, 0, nums, 0, result.length);
    }

    /**
     * @ 堆排序
     */
    static void heapSort(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        int[] heap = new int[nums.length + 1];
        // initialization
        heap[0] = Integer.MIN_VALUE;
        // insert
        int size = 0;
        for (int v : nums) {
            int i = ++size;
            while (heap[i / 2] > v) {
                heap[i] = heap[i / 2];
                i /= 2;
            }
            heap[i] = v;
        }
        // delete
        int n = 0;
        while (size > 0) {
            nums[n++] = heap[1];
            int lastElem = heap[size];
            --size;
            if (size > 0) {
                int child;
                int i;
                for (i = 1; 2 * i <= size; i = child) {
                    child = 2 * i;
                    // find smaller child
                    if (child != size && heap[child] > heap[child + 1])
                        ++child;
                    // percolate down 1 level
                    if (lastElem > heap[child])
                        heap[i] = heap[child];
                    else
                        break;
                }
                heap[i] = lastElem;
            }
        }
    }

}
