package com.jlgg.trees;


class Node {

    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
        left = null;
        right = null;
    }

    public int getValue() {
        return this.value;
    }

    public void setLeft(Node node) {
        this.left = node;
    }

    public Node getLeft() {
        return this.left;
    }

    public void setRight(Node node) {
        this.right = node;
    }

    public Node getRight() {
        return this.right;
    }
}

class BinaryTree {

    public void insert(Node parent, int value) {
        if (value < parent.getValue()) {
            if (parent.getLeft() == null) {
                parent.setLeft(new Node(value));
                System.out.println(" Inserted " + value + " to left of " + parent.getValue());
            } else {
                insert(parent.getLeft(), value);
            }
        } else if (value > parent.getValue()) {
            if (parent.getRight() == null) {
                parent.setRight(new Node(value));
                System.out.println(" Inserted " + value + " to right of " + parent.getValue());
            } else {
                insert(parent.getRight(), value);
            }
        }
    }

    public void traverseInOrder(Node parent) {
        if (parent != null) {
            traverseInOrder(parent.getLeft());
            System.out.print(" " + parent.getValue());
            traverseInOrder(parent.getRight());
        }
    }

    public int calcHeight(Node parent) {
        if (parent == null) {
            return -1;
        } else {
            int leftHeight = calcHeight(parent.getLeft());
            int rightHeight = calcHeight(parent.getRight());
            return  1 + Math.max(leftHeight, rightHeight);
        }
    }
}

public class SolutionHeightTree {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Node root = new Node(4);

        tree.insert(root, 2);
        tree.insert(root, 6);
        tree.insert(root, 1);
        tree.insert(root, 3);
        tree.insert(root, 5);
        tree.insert(root, 7);

        tree.traverseInOrder(root);
        int height = tree.calcHeight(root);
        System.out.println("\nThe Tree height is: " + height);
    }
}
