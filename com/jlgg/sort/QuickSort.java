package com.jlgg.sort;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/quick-sort/
 * Quick Sort is a divide and conquer algorithm
 * Time complexity:
 * Average: Time & Space O(N log N)
 * The input list is divided in two-sublists by an element called pivot.
 * One list with elements lesser than the pivot. The other with elements greater than the pivot.
 * This process repeats for each sub-list.
 */
public class QuickSort {
    /**
     * Recursive function
     */
    public static void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            // Partition the Array, returns the partition point in its final place
            int partitionIndex = partition(arr, begin, end);
            // Recursively repeat for left sub-array
            quickSort(arr, begin, partitionIndex - 1);
            // Recursively repeat for right sub-array
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    /**
     * It takes the last element as a pivot and places it in its final position.
     * Places the elements that are less than the pivot before the pivot.
     * Places the elements that are greater than the pivot after the pivot.
     * Returns the partition index (the pivot's final position)
     */
    private static int partition(int arr[], int begin, int end) {
        // Get the last element as the Pivot
        int pivot = arr[end];
        // The left pointer (place it before the first element)
        // Left pointer is a reference needed to place the pivot to its final position
        int left = begin - 1;
        // Iterate each element and compare its value against the pivot value
        for (int current = begin; current < end; current++) {
            if (arr[current] <= pivot) { // we only take action if current value <= pivot value
                left++;
                swap(arr, left, current);
            }
        }
        // Place the pivot to its final position: left + 1
        swap(arr, left + 1, end);
        // The new partition index will be the pivot's final position
        return left + 1;
    }

    private static void swap(int[] arr, int el1, int el2) {
        int temp = arr[el1];
        arr[el1] = arr[el2];
        arr[el2] = temp;
    }

    public static void main(String[] args) {
        int[] elements = {1, 3, 7, 6, 8, 4, 9, 5};
        quickSort(elements, 0, elements.length - 1);
        System.out.println(Arrays.toString(elements));
    }
}
