package com.jlgg.lists;

/**
 * Linked list is a linear data structure, the elements are linked using references
 * Advantages over arrays: a) Dynamic size, b) Easy of insertion/deletion
 * Head: Reference to the first node of the list, if list is empty head = null
 */
public class MyLinkedList {
    // Head of the list
    Node head;

    /**
     * Node contains: a) data, b) reference to the next node
     */
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * O(N) - linear, N = number of nodes of the list
     */
    public void traverseList() {
        // Empty list
        if (head == null) {
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    /**
     * Inserts a node at the beginning of the list
     * O(1) - Constant
     */
    public void insertFirst(int data) {
        Node newNode = new Node(data);
        // new node next points now to old head node
        newNode.next = head;
        // new node is now the head of the list
        head = newNode;
    }

    /**
     * Inserts a node after the given node
     * O(1) - Constant
     */
    public void insertAfter(Node current, int data) {
        if (current == null) {
            return;
        }
        Node newNode = new Node(data);
        // new node next points to old node next
        newNode.next = current.next;
        // old node next now points to new node
        current.next = newNode;
    }

    /**
     * Inserts a new node at the end of the list
     * O(N) - linear, N = number of nodes of the list
     */
    public void insertEnd(int data) {
        Node newNode = new Node(data);

        // If the list is empty then make the new node the head
        if (head == null) {
            head = newNode;
            return;
        }

        // new node will be now the last node
        newNode.next = null;

        // traverse the list until the old last node
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }

        // old last node next will now point to the new last
        last.next = newNode;
    }

    /**
     * Given a key, removes the first occurrence of it
     */
    public void deleteNode(int key) {
        Node n = head;

        // If list is empty, do nothing
        if (n == null) {
            return;
        }
        // If node to be removed is the head
        if (n.data == key) {
            // Unlink the old head
            head = n.next;
            return;
        }

        while (n.next != null) {
            if (n.next.data == key) {
                // Unlink the Node
                n.next = n.next.next;
                return;
            }
            // Move forward in the list
            n = n.next;
        }
    }

    /**
     * Returns the data at the specified position in the list
     */
    public int getNode(int index) {
        int counter = 0;
        Node current = head;
        while (current != null) {
            if (index == counter) {
                return current.data;
            }
            current = current.next;
            counter++;
        }
        return -1;
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        list.head = new Node(1);

        list.insertEnd(2);
        list.insertEnd(3);
        list.insertEnd(4);

        System.out.println("Node at index 1: " + list.getNode(1));

        list.deleteNode(1);
        list.deleteNode(4);

        System.out.println("Node at index 1: " + list.getNode(1));

        list.traverseList();
    }
}