package com.jlgg.lists;

import java.util.HashSet;

/**
 * A linked list is said to contain a cycle if any node is visited more than once
 * while traversing the list
 */
public class CycleDetection {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public void insertEnd(int data) {
        Node newNode = new Node(data);
        // Empty list
        if (head == null) {
            head = newNode;
            return;
        }
        // Get the last node
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        // Point the last node to the new Node
        last.next = newNode;
        // Point the new node to null (new node is now the last)
        newNode.next = null;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + ", ");
            current = current.next;
        }
    }

    public boolean hasCycle() {
        HashSet<Node> hashSet = new HashSet<>();
        Node current = head;
        while (current != null) {
            // If already in the set there is a loop
            if (hashSet.contains(current)) {
                return true;
            }
            hashSet.add(current);
            current = current.next;
        }
        return false;
    }

    public static void main(String[] args) {
        CycleDetection list = new CycleDetection();
        list.insertEnd(1);
        list.insertEnd(2);
        list.insertEnd(3);
        list.insertEnd(4);

        list.printList();
        System.out.println("Has cycle? Ans: " + list.hasCycle());
        // Test case for has cycle
        list.head.next.next.next = list.head;
        System.out.println("Has cycle? Ans: " + list.hasCycle());
    }
}