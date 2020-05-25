package com.jlgg.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/***
 * https://medium.com/edureka/java-binary-tree-caede8dfada5
 *
 * A binary tree is a recursive tree data structure where each node can have 2 children at most.
 * a) Full: every node has exactly 0 or 2 Nodes
 * b) Perfect: all internal nodes have 2 children and all leaves are at the same level (leaves: last nodes at the tree)
 * c) Complete: Every level (except possibly the last) is filled, and all nodes are as far as left as possible
 *
 * Tree Traversals:
 *
 * >>> Depth First Search (uses a stack) Complexity: O(N)
 * You go as deep as possible down one path before backing up and trying a different one
 * could be done: in-order, pre-order, and post-order
 * a) in-order: First visiting the left sub-tree, then the root node, finally the right sub-tree
 * b) pre-order: visit the root node first, then left sub-tree, finally the right sub-tree
 * c) post-order: left subtree first, then the right sub-tree, finally the root node
 *
 * >>> Breadth First Search (uses a queue) Complexity O(N)
 * Visits all the nodes of a level before going to the next level.
 * a) level-order: visits all the levels of the tree starting from the root, and from left to right
 */
public class BTree {
    /**
     * Auxiliary class to store int values and reference of each child
     */
    static class Node {
        private int value;
        private Node left;
        private Node right;

        private Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    /**
     * To keep the Tree sorted:
     * a) If the new node's value is lower than than the current's node, go to the left child
     * b) If the new node's value is higher than the the current's node, go to the right child
     * c) When the current node is null, we've reached a leaf node, we insert the new node in that position
     */
    public void insert(Node node, int value) {
        if (value < node.value) {
            if (node.left != null) {
                insert(node.left, value);
            } else {
                System.out.println(" Inserted " + value + " to left of " + node.value);
                node.left = new Node(value);
            }
        } else if (value > node.value) {
            if (node.right != null) {
                insert(node.right, value);
            } else {
                System.out.println("  Inserted " + value + " to right of " + node.value);
                node.right = new Node(value);
            }
        }
    }

    /**
     * Depth First Search: in-order traversal
     * Recursion uses implicit stack
     */
    public void traverseDFSInOrder(Node node) {
        if (node != null) {
            traverseDFSInOrder(node.left);
            System.out.print(" " + node.value);
            traverseDFSInOrder(node.right);
        }
    }

    /**
     * Breadth First Search
     * The queue keeps references of all the children nodes of every visited node.
     * The Nodes in the queue are discovered nodes but not yet visited
     */
    public void traverseBFS(Node root) {
        if (root != null) {
            Queue<Node> queue = new LinkedList<>();
            //Insert the root in the queue
            queue.add(root);
            while (!queue.isEmpty()) {
                // Extract the Node from the queue
                Node node = queue.remove();
                // Print the extracted Node
                System.out.println(node.value);
                // Insert the Node's children into the queue
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        BTree tree = new BTree();

        Node root = new Node(4);
        tree.insert(root, 7);
        tree.insert(root, 6);
        tree.insert(root, 5);
        tree.insert(root, 3);
        tree.insert(root, 2);
        tree.insert(root, 1);

        System.out.println("Traversing tree DFS in-order");
        tree.traverseDFSInOrder(root);

        System.out.println("\nTraversing tree BFS");
        tree.traverseBFS(root);
    }
}