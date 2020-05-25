package com.jlgg.heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MedianStream {

    // Add any helper functions you may need here
    private static int calcMedianOdd(PriorityQueue<Integer> heap) {
        // if odd then return the middle integer (heap.size() / 2) 1/2 = 0, 3/2 = 1, 5/2 = 2
        int size = heap.size();
        int[] elements = new int[size];
        int index = 0;
        while (!heap.isEmpty()) {
            elements[index] = heap.poll();
            index++;
        }

        return elements[size / 2];
    }

    private static int calcMedianEven(PriorityQueue<Integer> heap) {
        // retun the average of the two middle most (i can use the heap for this)
        int nElements = heap.size();
        int sum = 0;
        while (!heap.isEmpty()) {
            sum += heap.poll();
        }

        return sum / nElements;
    }

    public static int[] findMedian(int[] arr) {
        int[] results = new int[arr.length];
        PriorityQueue<Integer> minheap = new PriorityQueue<>();

        // iterate the arr
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) {
                // enter the subarray in a minheap
                minheap.add(arr[j]);
            }
            // calculate the median
            if (minheap.size() % 2 == 0) {
                results[i] = calcMedianEven(minheap);
            } else {
                results[i] = calcMedianOdd(minheap);
            }
        }

        return results;
    }

    public static void main(String[] args) {
        int[] arr = {5, 15, 1, 3};
        System.out.println(Arrays.toString(findMedian(arr)));
    }
}
