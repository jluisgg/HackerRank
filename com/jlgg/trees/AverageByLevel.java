package com.jlgg.trees;

import java.util.*;

public class AverageByLevel {

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public void insert(Node parent, int value) {
        if (value < parent.value) {
            if (parent.left == null) {
                parent.left = new Node(value);
            } else {
                insert(parent.left, value);
            }
        } else if (value > parent.value) {
            if (parent.right == null) {
                parent.right = new Node(value);
            } else {
                insert(parent.right, value);
            }
        }
    }

    public void calcAverageByLevel(Node root) {
        Queue<Node> discovered = new LinkedList<>();
        discovered.add(root);
        while (!discovered.isEmpty()) {
            int sum = 0;
            int count = 0;
            Queue<Node> children = new LinkedList<>();
            while (!discovered.isEmpty()) {
                Node parent = discovered.peek();
                discovered.remove();
                sum += parent.value;
                count++;
                if (parent.left != null) {
                    children.add(parent.left);
                }
                if (parent.right != null) {
                    children.add(parent.right);
                }
            }
            discovered = children;
            System.out.println(sum * 1.0 / count + "");
        }
    }

    public static void main(String[] args) {
        int[] values = {4, 2, 7, 1, 3, 6};
        AverageByLevel tree = new AverageByLevel();

        Node root = new Node(values[0]);
        for (int i = 0; i < values.length; i++) {
            tree.insert(root, values[i]);
        }

        tree.calcAverageByLevel(root);
    }
}
