package SelfBalancingBSTs.BST;

public class BinarySearchTree {
    static class Node {
        int key;
        Node left;
        Node right;
        Node(int key) {
            this.key = key;
        }
    }
    // root of bst
    private Node root;

    // this method mainly calls insertRec
    void insert(int key) {
        root = insertRec(root, key);
    }
    private Node insertRec(Node root, int key) {
        if (root == null)
            return new Node(key);
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
        return root;
    }

    // this method mainly calls inorderRec
    void inorder() {
        inorderRec(root);
    }
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }

    private int minValue(Node root) {
        Node minNode = root;
        while (minNode.left != null)
            minNode = minNode.left;
        return minNode.key;
    }
    // this method mainly calls deleteRec
    void deleteKey(int key) {
        root = deleteRec(root, key);
    }
    private Node deleteRec(Node root, int key) {
        if (root == null)
            return null;
        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children: get the inorder successor
            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    Node search(int key) {
        return searchRec(root, key);
    }
    private Node searchRec(Node root, int key) {
        if (root == null || root.key == key)
            return root;
        else if (key < root.key)
            return searchRec(root.left, key);
        else
            return searchRec(root.right, key);
    }
}
