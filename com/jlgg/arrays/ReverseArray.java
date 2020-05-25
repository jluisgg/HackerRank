package com.jlgg.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class ReverseArray {

    public static void main(String[] args) {
        final int[] elements = {1, 3, 6, 8, 2, 4, 9, 6, 8};
        final int[] elements2 = {1, 3, 6, 8, 2, 4, 9, 6, 8};
        final Integer[] elements3 = {1, 3, 6, 8, 2, 4, 9, 6, 8};

        System.out.println("Original Array: " + Arrays.toString(elements));

        reverse(elements);
        System.out.println("Reversed Array: " + Arrays.toString(elements));

        reverseOptimized(elements2);
        System.out.println("Reversed Array: " + Arrays.toString(elements2));

        reverseWithCollections(elements3);
        System.out.println("Reversed with Collections: " + Arrays.toString(elements3));
    }

    /**
     * Brute force solution:
     * Creates a temp array, reverse and then copy the temp to the original array
     *
     * @param elements
     */
    private static void reverse(int[] elements) {
        int[] reversed = new int[elements.length];
        int cursor = elements.length - 1;

        for (int i = 0; i < elements.length; i++) {
            reversed[i] = elements[cursor];
            cursor--;
        }

        for (int i = 0; i < reversed.length; i++) {
            elements[i] = reversed[i];
        }
    }

    /**
     * Takes the first element and the last element and swap them
     * Repeat until to reach the middle of the array
     *
     * @param elements
     */
    public static void reverseOptimized(int[] elements) {
        int cursor = elements.length - 1;
        for (int i = 0; i < elements.length / 2; i++) {
            swap(elements, i, cursor);
            cursor--;
        }
    }

    public static void swap(int[] elements, int a, int b) {
        int temp = elements[a];
        elements[a] = elements[b];
        elements[b] = temp;
    }

    /**
     * The original Integer[] elements mutates within the method
     *
     * @param elements
     */
    public static void reverseWithCollections(Integer[] elements) {
        // Convert Integer[] to List<Integer>
        List<Integer> myList = Arrays.asList(elements);
        // Collections.reverse()
        Collections.reverse(myList);
        // Convert List<Integer> to Integer[] and assign it to elements
        myList.toArray(new Integer[myList.size()]);
    }

}
