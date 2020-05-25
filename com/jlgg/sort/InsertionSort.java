package com.jlgg.sort;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/insertion-sort/
 * Time Complexity: O(N^2)
 */
public class InsertionSort {

    public static void insertionSort(int[] arr) {
        // Iterate from i+1 
        for (int i = 1; i < arr.length; i++) {
            int currentEl = arr[i];
            int leftIndex = i - 1;

            while (leftIndex >= 0 && arr[leftIndex] > currentEl) {
                // Move each element of subarray that is greater than the currentEl one position to the right
                arr[leftIndex + 1] = arr[leftIndex];
                leftIndex--;
            }
            arr[leftIndex + 1] = currentEl;
        }
    }

    public static void main(String[] args) {
        int[] elements = {8, 5, 4, 3, 1, 8, 5, 0, 23, 1, 28, 2, 7, 0, 15, 24};
        insertionSort(elements);
        System.out.println(Arrays.toString(elements));
    }
}
