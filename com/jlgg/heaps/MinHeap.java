package com.jlgg.heaps;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * https://www.geeksforgeeks.org/binary-heap/
 * It is a Binary Tree with the following properties:
 * a) It is a complete tree (all levels are completely filled, except possible the last, the last level has all
 * keys as left as possible)
 * b) Is either MinHeap or MaxHeap
 * 1. MinHeap: the key at root must be minimum among all keys present in BinaryHeap, the same property must be
 * recursively true for all nodes in Binary Tree.
 * 2. MaxHeap: the jey at root must be maximum among all keys present in BinaryHeap, the same property must be
 * recursively true for all nodes in Binary Tree.
 */
public class MinHeap {

    /**
     * Min-Heap implementation using a Priority Queue.
     * A priority queue is used when objects are supposed to be processed based on the priority.
     * It is based in the priority heap. The elements in the priority queue are ordered according
     * to the natural ordering, or by a Comparator provided at queue construction time.
     */
    public static void main(String[] args) {
        // MinHeap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add items
        minHeap.add(10);
        minHeap.add(30);
        minHeap.add(20);
        minHeap.add(400);

        // Print the most priority element
        System.out.print("The root value: " + minHeap.peek());

        // Print all elements
        printMinHeap(minHeap);

        // Remove the root
        minHeap.poll();
        printMinHeap(minHeap);

        // Remove element
        minHeap.remove(400);
        printMinHeap(minHeap);

        // Add Elements
        minHeap.add(5);
        minHeap.add(500);

        // Print the most priority element
        System.out.print("\nThe root value: " + minHeap.peek());
        printMinHeap(minHeap);
    }

    private static void printMinHeap(PriorityQueue<Integer> heap) {
        System.out.println("\nThe Min-Heap elements:");
        Iterator<Integer> mIterator = heap.iterator();
        while(mIterator.hasNext()){
            System.out.print(mIterator.next() + ", ");
        }
    }
}
