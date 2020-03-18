package SelfBalancingBSTs.B_Tree;

import java.util.ArrayList;
import java.util.List;

public class BTree<E extends Comparable<? super E>> {
    private static class Node<E> {
        int minDegree;
        List<E> keys;
        List<Node<E>> children;
        boolean isLeaf;
    }
    Node<E> root;

    /**
     * 插入：主动拆分
     * 如果树是空的，初始化x为根结点
     * 如果树非空，根结点为x
     *     如果根结点满了，则根结点分裂，形成新的根结点，key小于新根结点key，x指向左子树，否则x指向右子树
     *     while：x是内部结点
     *         找到key应该插入的子树，设子树的根结点为y
     *         如果y.k数目不满，则x指向y
     *         如果y.k数目满了，则把y分为两部分，y.k的mid放入x.k中，y的两部分分别放在mid的左右
     *             如果key小于mid则x指向y的前半部分，否则x指向y的后半部分
     *     此时x是叶结点，x.k >= t-1，直接把key插入x
     */
    public void insert(E item) {

    }

    /**
     * 删除：从根结点开始，设为x
     * 如果x包含key
     *     如果x是叶结点，则直接删除
     *     如果x是内部结点
     *         (1)设x.key的前一个子结点为y，如果y.k数目大于等于t，
     *         在以y为根结点的子树中找到x.key的前驱key0，用key0替换x.key，在y中递归删除key0
     *         (2)如果y.k数目小于t，设x.key的后一个子结点为z，如果z.k数大于等于t
     *         在以z为根结点的子树中找到x.key的后继key1，用key1替换x.key，在z中递归删除key1
     *         (3)如果z.k数目小于t，把x.key和z合并到子结点y中，在y中递归删除key
     * 如果x不包含key
     *     如果x是叶结点，则key不在树中
     *     while：如果x是内部结点，则如果key在树中那么一定包含于x某个子树中，设为y
     *         (I)如果y.k == t-1
     *             (1)但是存在邻接兄弟z.k >= t，把相应的x.key和相应z的子结点放到y中，把相应的z.key放到x中
     *             (2)但是不存在邻接兄弟z.k >= t，选择一个兄弟与相应的x.key和y合并成新的子结点
     *             然后设x为y
     *         (II)如果y.k >= t
     *             则设x为y
     */
    public void delete(E item) {

    }
}
