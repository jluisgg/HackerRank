package com.jlgg.heaps;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 *  https://www.geeksforgeeks.org/max-heap-in-java/
 *  A max-heap is complete binary tree in which the value in each internal node greater than or
 *  equal to  the values in the children of the node
 */
public class MaxHeap {

    public static void main(String[] args) {
        // Max Heap - Note the Comparator in desc
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Add items
        maxHeap.add(10);
        maxHeap.add(20);
        maxHeap.add(30);
        maxHeap.add(400);

        // Print the most priority element
        System.out.print("The root value: " + maxHeap.peek());

        // Print all elements
        printMinHeap(maxHeap);

        // Remove the root
        maxHeap.poll();
        printMinHeap(maxHeap);

        // Remove element
        maxHeap.remove(20);
        printMinHeap(maxHeap);

        // Add Elements
        maxHeap.add(5);
        maxHeap.add(500);

        // Print the most priority element
        System.out.print("\nThe root value: " + maxHeap.peek());
        printMinHeap(maxHeap);
    }

    private static void printMinHeap(PriorityQueue<Integer> heap) {
        System.out.println("\nThe Max-Heap elements:");
        Iterator<Integer> mIterator = heap.iterator();
        while (mIterator.hasNext()) {
            System.out.print(mIterator.next() + ", ");
        }
    }
}

