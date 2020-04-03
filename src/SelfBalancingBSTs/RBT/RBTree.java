package SelfBalancingBSTs.RBT;

public class RBTree<E extends Comparable<? super E>> {
    // 1.只有红色和黑色
    // 2.根结点是黑色
    // 3.红结点不相邻
    // 4.每个结点到其任意一个后代空结点的路径上的黑结点数目相同
    private enum Color {
        Red, Black
    }

    private static class Node<E> {
        E item;
        Color color;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        Node(E item) {
            this.item = item;
        }
    }

    Node<E> root;

    /**
     * 插入：改颜色，旋转
     * 1.执行BTS插入，新结点x设为红
     * 2.如果x是根结点，则设为黑
     * 3.如果x不是根结点，x的父节点是红
     *     如果x的叔结点是红：
     *         设x的父节点和叔结点为黑
     *         设祖父结点为红
     *         设x为祖父结点，重复2和3
     *     如果叔结点是黑结点就以x的祖父结点为根结点进行AVL旋转，外旋是祖父结点和父节点变色，内旋是祖父结点和x结点变色
     * 4.如果x的父节点是黑，则插入完毕
     */
    public void insert(E item) {

    }

    /**
     * 删除：当一个黑结点被删除，他的一个黑子结点代替他的位置，这个黑子结点称为双黑
     * (1).执行BST删除，总会以删除无子结点或者只有一个子结点的结点为结束，
     * 因为有两个子结点时会用后继结点的值代替，然后删除后继结点，所以只考虑0个或1个子结点的结点删除
     * 设v是准备删除的结点，u是子结点，u可以是NULL结点
     * (2).v和u其中有一个是红色另一个是黑色：把u变成黑色
     * (3).v和u都是黑色：
     *     <1>.u是双黑结点，现在的任务是把双黑结点变成单黑结点
     *     <2>.u不是根结点，设u的兄弟节点为s，s一定不为NULL
     *         (a).如果s为黑结点且至少有一个红子结点设这个红子结点为r，以s的父节点为根结点进行旋转
     *             (i).left-left-case：s为左孩子，r为左孩子
     *             (ii).left-right-case：s为左孩子，r为右孩子
     *             (iii).right-right-case：s为右孩子，r为右孩子
     *             (iv).right-left-case：s为右孩子，r为左孩子
     *         (b).如果s为黑结点且都是黑孩子，则把s变为红色
     *             如果s父节点是红色，把p变成黑色
     *             如果s父节点是黑色，设u为p，转到<1>
     *         (c).如果s是红结点，以s父节点为根结点进行旋转
     *             left-case：s是左孩子，右旋p
     *             right-case：s是右孩子，左旋p
     *             p和s变色
     *             此时u的新兄弟节点一定为黑色，转到(a)
     *     <3>.u是根结点，直接返回
     */
    public void delete(E item) {

    }
}
