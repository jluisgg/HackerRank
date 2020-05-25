package com.jlgg.trees;

import java.util.*;

public class AverageByLevelv2 {

    static Node root;

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    private void insertNodes(Node parent, Node left, Node right) {
        if (parent == null) {
            return;
        }
        parent.left = left;
        parent.right = right;
    }

    private void createTree() {
        // Create Root Node
        root = new Node(4);
        Node seven = new Node(7);
        Node nine = new Node(9);
        insertNodes(root, seven, nine);
        Node ten = new Node(10);
        Node two = new Node(2);
        insertNodes(seven, ten, two);
        Node six = new Node(6);
        insertNodes(nine, null, six);
        Node six2 = new Node(6);
        insertNodes(two, null, six2);
        Node two2 = new Node(2);
        insertNodes(six2, two2, null);
    }

    // Use BFS
    public void calcAverage(Node root) {
        Queue<Node> discovered = new LinkedList<>();
        discovered.add(root);
        while (!discovered.isEmpty()) {
            int sum = 0;
            int count = 0;
            Queue<Node> children = new LinkedList<>();
            while (!discovered.isEmpty()) {
                // We need to save the parent
                Node parent = discovered.peek();
                // Remove the parent from the discovered queue
                discovered.remove();
                sum += parent.data;
                count++;
                if (parent.left != null) {
                    children.add(parent.left);
                }
                if (parent.right != null) {
                    children.add(parent.right);
                }
            }
            discovered = children;
            System.out.println(sum / count);
        }
    }

    public static void main(String[] args) {
        AverageByLevelv2 tree = new AverageByLevelv2();
        tree.createTree();
        tree.calcAverage(root);
    }

}
