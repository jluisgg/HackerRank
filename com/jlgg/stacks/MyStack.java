package com.jlgg.stacks;

/**
 * Stack is a linear data structure which follows LIFO (last in first out)
 * O(1) - Constant time in all stack operations: push, pop, peek, isEmpty
 * Implementation using a linked list
 */
public class MyStack {

    Node top;

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * Pushes an item into the top of the stack
     * O(1) - Constant
     */
    public void push(int data) {
        Node newNode = new Node(data);
        if (top == null) {
            top = newNode;
        } else {
            Node temp = top;
            top = newNode;
            top.next = temp;
        }
    }

    /**
     * Removes an item at the top of the stack
     * O(1) - Constant
     */
    public int pop() {
        int popped = Integer.MIN_VALUE;
        if (top == null) {
            System.out.println("The stack is empty");
        } else {
            popped = top.data;
            top = top.next;
        }
        return popped;
    }

    /**
     * Looks at the object at the top of the stack without removing it
     * O(1) - Constant
     */
    public int peek() {
        if (top == null) {
            System.out.println("The stack is empty");
            return Integer.MIN_VALUE;
        } else {
            return top.data;
        }
    }

    /**
     * Tests if the stack is empty
     */
    public boolean isEmpty() {
        return top == null ? true : false;
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top of the Stack: " + stack.peek());
        System.out.println("Popped from the Stack: " + stack.pop());
        System.out.println("Top of the stack after pop(): " + stack.peek());
    }
}
