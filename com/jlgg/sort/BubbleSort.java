package com.jlgg.sort;

import java.util.Arrays;

/**
 * Swaps repeatedly the adjacent elements if they are in wrong order
 * Time complexity
 * Average: O(n^2), Worst: O(n^2)
 */
public class BubbleSort {
    /**
     * Takes each element and compares against next if greater swap, repeat until end of array
     * After first run the smallest element is the first element in the array,
     * move the cursor to next element, repeat steps
     */
    private static void bubbleSort(int[] elements) {
        for (int i = 0; i < elements.length; i++) {
            for (int j = i + 1; j < elements.length; j++) {
                if (elements[i] > elements[j]) {
                    swap(elements, i, j);
                }
            }
        }
    }

    private static void swap(int[] elements, int indexA, int indexB) {
        int temp = elements[indexA];
        elements[indexA] = elements[indexB];
        elements[indexB] = temp;
    }

    public static void main(String[] args) {
        int[] elements = {8, 5, 4, 3, 1, 8, 5, 0, 23, 1, 28, 2, 7, 0, 15, 24};
        bubbleSort(elements);
        System.out.println("Bubble Sorted: " + Arrays.toString(elements));
    }
}
