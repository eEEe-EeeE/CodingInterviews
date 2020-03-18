package question45;

// 设集合S以及定义在S上的关系集合R
// 自反性：<a,a>属于R
// 对称性：若<a,b>属于R，则<b,a>属于R
// 传递性：若<a,b> <b,c>属于R，则<a,c>属于R
// 关系<?,?>不指代具体确定的一个关系，而指代R上定义的几种关系中的某一个

public class Solution {
    static void solute(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        for (int value : nums) {
            if (value <= 0)
                return;
        }
        // 归并排序
        mergeSort(nums);
        for (int value : nums) {
            System.out.print(value);
        }
        System.out.println();
    }

    private static void mergeSort(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        int[] tmp = new int[nums.length];
        mergeSortRec(nums, tmp, 0, nums.length - 1);
    }

    private static void mergeSortRec(int[] sourceArr, int[] mergeArr, int left, int right) {
        if (left < right) {
            mergeSortRec(sourceArr, mergeArr, left, (left + right) / 2);
            mergeSortRec(sourceArr, mergeArr, (left + right) / 2 + 1, right);
            merge(sourceArr, mergeArr, left, (left + right) / 2, right);
        }
    }

    private static void merge(int[] sourceArr, int[] mergeArr, int left, int bound, int right) {
        int i = left;
        int j = bound + 1;
        int k = left;
        while (i <= bound && j <= right) {
            if (compare(sourceArr[i], sourceArr[j]) <= 0)
                mergeArr[k++] = sourceArr[i++];
            else
                mergeArr[k++] = sourceArr[j++];
        }
        while (i <= bound)
            mergeArr[k++] = sourceArr[i++];
        while (j <= right)
            mergeArr[k++] = sourceArr[j++];
        while (left <= right) {
            sourceArr[left] = mergeArr[left];
            ++left;
        }
    }

    // 比较函数：
    // 1.一个数是另一个数的前缀：要自比较
    // 2.一个数不是另一个数的前缀：肯定能比较出大小
    private static int compare(int a, int b) {
         String s1 = String.valueOf(a);
         String s2 = String.valueOf(b);
         int i = 0;
         int j = 0;
         while (i < s1.length() && j < s2.length()) {
             if (s1.charAt(i) < s2.charAt(j))
                 return -1;
             else if (s1.charAt(i) > s2.charAt(j))
                 return 1;
             ++i;
             ++j;
         }
         // 到这里了，说明肯定是前缀，前缀要自比较
         int k = 0;
         while (i < s1.length()) {
             if (s1.charAt(i) < s1.charAt(k))
                 return -1;
             else if (s1.charAt(i) > s2.charAt(k))
                 return 1;
             ++i;
             ++k;
         }
         while (j < s2.length()) {
             if (s2.charAt(k) < s2.charAt(j))
                 return -1;
             else if (s2.charAt(k) > s2.charAt(j))
                 return 1;
             ++j;
             ++k;
         }
         return 0;
    }
}
