package com.jlgg.queues;

import java.util.Stack;

/**
 * A queue is maintains the order in which elements are added to it.
 * Allowing the oldest elements to be removed from the front and new elements added to the rear
 * It is a FIFO (first in first out) data structure
 * Operations:
 * a) Enqueue: add a new element at the end of the queue
 * b) Dequeue: remove the element from the front of the queue and return it
 */
public class TwoStacks {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    /**
     * O(N) - linear
     */
    public void enQueue(int data) {
        // Move all elements from stack1 to stack2
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        // Push item to stack1
        stack1.push(data);
        // Push everything back to stack1
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    /**
     * O(1) - constant
     */
    public int deQueue() {
        if (stack1.isEmpty()) {
            return -1;
        } else {
            return stack1.pop();
        }
    }

    public void traverseQueue() {
        if (stack1.isEmpty()) {
            System.out.println("The queue is empty");
        } else {
            while (!stack1.isEmpty()) {
                System.out.println(stack1.pop() + ", ");
            }
        }
    }

    public static void main(String[] args) {
        TwoStacks queue = new TwoStacks();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.deQueue();
        queue.enQueue(3);
        queue.enQueue(4);
        queue.deQueue();

        queue.traverseQueue();

    }
}
