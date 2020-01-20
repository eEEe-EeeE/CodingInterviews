package question26;

import bean.BTNode;

import java.util.ArrayList;
import java.util.List;

// 判断二叉树B是不是二叉树A的子树
public class Solution {
    static boolean solute1(BTNode A, BTNode B) {
        if (B == null)
            return true;
        else if (A == null)
            return false;
        else {
            if (A.getKey() == B.getKey() &&
                    hasSameStruct(A.getLeft(), B.getLeft()) &&
                    hasSameStruct(A.getRight(), B.getRight())) {
                return true;
            } else {
                return solute1(A.getLeft(), B) || solute1(A.getRight(), B);
            }
        }
    }

    static private boolean hasSameStruct(BTNode A, BTNode B) {
        if (B == null)
            return true;
        else if (A == null) {
            return false;
        } else {
            if (A.getKey() == B.getKey())
                return hasSameStruct(A.getLeft(), B.getLeft()) && hasSameStruct(A.getRight(), B.getRight());
            else
                return false;
        }
    }

    static boolean solute2(BTNode A, BTNode B) {
        List<Integer> listA = new ArrayList<>();
        preTraversal(A, listA);
        List<Integer> listB = new ArrayList<>();
        preTraversal(B, listB);
        for (int i = 0; i <= listA.size() - listB.size(); ++i) {
            int j = i;
            for (Integer v : listB) {
                if (!v.equals(listA.get(j)))
                    break;
                ++j;
            }
            if (i + listB.size() == j)
                return true;
        }
        return false;
    }

    static private void preTraversal(BTNode tree, List<Integer> list) {
        if (tree != null) {
            list.add(tree.getKey());
            preTraversal(tree.getLeft(), list);
            preTraversal(tree.getRight(), list);
        }
    }

}
