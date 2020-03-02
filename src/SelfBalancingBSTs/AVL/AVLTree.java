package SelfBalancingBSTs.AVL;

import java.util.LinkedList;
import java.util.List;

public class AVLTree<E extends Comparable<? super E>> {
    private static class Node<E> {
        E item;
        Node<E> left;
        Node<E> right;
        int height;

        Node(E item) {
            this.item = item;
            this.height = 1;
        }
    }

    Node<E> root;

    int height(Node<E> node) {
        if (node == null)
            return 0;
        return node.height;
    }

    private int getBalance(Node<E> node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    private E minValue(Node<E> root) {
        Node<E> min = root;
        while (min.left != null)
            min = min.left;
        return min.item;
    }

    private Node<E> rightRotate(Node<E> root) {
        Node<E> node = root.left;
        root.left = node.right;
        node.right = root;
        root.height = 1 + Math.max(height(root.left), height(root.right));
        node.height = 1 + Math.max(height(node.left), height(node.right));
        return node;
    }

    private Node<E> leftRotate(Node<E> root) {
        Node<E> node = root.right;
        root.right = node.left;
        node.left = root;
        root.height = 1 + Math.max(height(root.left), height(root.right));
        node.height = 1 + Math.max(height(node.left), height(node.right));
        return node;
    }

    public void insert(E item) {
        root = insertRec(root, item);
    }

    // 1.BST插入
    // 2.发现最小不平衡子树
    // 3.再平衡
    private Node<E> insertRec(Node<E> root, E item) {
        if (root == null)
            return new Node<>(item);
        if (item.compareTo(root.item) < 0)
            root.left = insertRec(root.left, item);
        else if (item.compareTo(root.item) > 0)
            root.right = insertRec(root.right, item);
        root.height = 1 + Math.max(height(root.left), height(root.right));
        int balance = getBalance(root);
        if (balance > 1 && item.compareTo(root.left.item) < 0)
            return rightRotate(root);
        if (balance < -1 && item.compareTo(root.right.item) > 0)
            return leftRotate(root);
        if (balance > 1 && item.compareTo(root.left.item) > 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if (balance < -1 && item.compareTo(root.right.item) < 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    public void delete(E item) {
        root = deleteRec(root, item);
    }

    // 1.BST删除结点
    // 2.发现最小不平衡子树
    // 3.再平衡
    private Node<E> deleteRec(Node<E> root, E item) {
        if (root == null)
            return null;
        if (item.compareTo(root.item) < 0)
            root.left = deleteRec(root.left, item);
        else if (item.compareTo(root.item) > 0)
            root.right = deleteRec(root.right, item);
        else {
            if (root.left == null)
                root = root.right;
            else if (root.right == null)
                root = root.left;
            else {
                // find right subtree successor
                root.item = minValue(root.right);
                root.right = deleteRec(root.right, root.item);
            }
        }
        if (root == null)
            return null;
        root.height = 1 + Math.max(height(root.left), height(root.right));
        int balance = getBalance(root);
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(Node<E> root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.item);
            inorderRec(root.right);
        }
    }

}
