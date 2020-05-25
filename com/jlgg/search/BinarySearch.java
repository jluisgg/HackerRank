package com.jlgg.search;

import java.util.Arrays;

public class BinarySearch {

    public static int binarySearch(int[] els, int x) {
        int left = 0;
        int right = els.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (x == els[middle]) {
                return middle;
            }
            // if X is greater than middle, discard left
            if ( x > els[middle]) {
                left = middle + 1;
            } else {
                // X is less than middle, discard right
                right = middle - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] els = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(binarySearch(els, 7));
        // Using the collections framework (but the array mut be sorted)
        System.out.println(Arrays.binarySearch(els,7));
    }
}
