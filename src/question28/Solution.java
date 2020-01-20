package question28;

import bean.BTNode;

import java.util.ArrayList;
import java.util.List;

// 判断一棵树是不是对称的
public class Solution {
    static boolean solute(BTNode tree) {
        Integer[] arr1 = preSequence(tree);
        Integer[] arr2 = preSequence2(tree);
        int len = arr1.length;
        int i = 0;
        while(i < len) {
            if (arr1[i] != (arr2[i]))
                break;
            ++i;
        }
        return i == len;
    }

    static Integer[] preSequence(BTNode tree) {
        List<Integer> list = new ArrayList<>();
        _preSequence(tree, list);
        return list.toArray(new Integer[0]);
    }
    static private void _preSequence(BTNode tree, List<Integer> arr) {
        if (tree != null) {
            arr.add(tree.getKey());
            _preSequence(tree.getLeft(), arr);
            _preSequence(tree.getRight(), arr);
        } else
            arr.add(null);
    }

    static Integer[] preSequence2(BTNode tree) {
        List<Integer> list = new ArrayList<>();
        _preSequence2(tree, list);
        return list.toArray(new Integer[0]);
    }
    static private void _preSequence2(BTNode tree, List<Integer> arr) {
        if (tree != null) {
            arr.add(tree.getKey());
            _preSequence2(tree.getRight(), arr);
            _preSequence2(tree.getLeft(), arr);
        } else
            arr.add(null);
    }
}
