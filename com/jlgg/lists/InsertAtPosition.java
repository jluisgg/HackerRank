package com.jlgg.lists;

public class InsertAtPosition {

    Node head;

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public void printList() {
        if (head == null) {
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public void insertAtPosition(int index, int data) {
        Node newNode = new Node(data);
        // If position equals O, Insert node as head
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node current = head;
        while (current != null) {
            if (current.data == index) {
                newNode.next = current.next;
                current.next = newNode;
                return;
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        InsertAtPosition list = new InsertAtPosition();
        list.insertAtPosition(0, 1);
        list.insertAtPosition(0, 5);
        list.insertAtPosition(1, 2);
        list.insertAtPosition(2, 3);
        list.insertAtPosition(3, 4);
        list.printList();
    }
}
