package com.jlgg.trees;

/**
 * You are given pointer to the root of the binary search tree and two values val1 and val2.
 * You need to return the lowest common ancestor (LCA) of val1 and val2 in the binary search tree.
 */
public class LowestCommonAncestor {
    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public String toString() {
            return String.valueOf(this.value);
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

    public Node findLCA(Node node, int val1, int val2) {
        if (node == null) {
            return null;
        }
        if (node.value > val1 && node.value > val2) {
            return findLCA(node.left, val1, val2);
        }
        if (node.value < val1 && node.value < val2) {
            return findLCA(node.right, val1, val2);
        }

        return node;
    }

    public static void main(String[] args) {
        int[] nodes = {2, 1, 3, 4, 5, 6};
        int[] values = {4, 6};
        LowestCommonAncestor tree = new LowestCommonAncestor();

        Node root = new Node(nodes[0]);
        for (int i = 0; i < nodes.length; i++) {
            tree.insert(root, nodes[i]);
        }

        // find common ancestor
        System.out.println("Least Common Ancestor: " + tree.findLCA(root, values[0], values[1]).value);
    }
}
