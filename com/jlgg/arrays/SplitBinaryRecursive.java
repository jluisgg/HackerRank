package com.jlgg.arrays;

import java.util.Arrays;

public class SplitBinaryRecursive {

    public static void main(String[] args) {

        int[] elements = {8, 5, 4, 3, 1, 8, 5, 0, 23, 1, 28, 2, 7, 0, 15, 24};

        divideRecursively(elements);
    }

    private static void divideRecursively(int[] elements) {

        if (elements.length <= 2) {
            System.out.println(Arrays.toString(elements));
            return;
        }

        int middle = elements.length / 2;

        // left = start to middle
        int left[] = new int[middle];
        for (int i = 0; i < left.length; i++) {
            left[i] = elements[i];
        }

        // right = middle to end
        int right[] = new int[elements.length - middle];
        for (int i = 0; i < right.length; i++) {
            right[i] = elements[middle + i];
        }

        divideRecursively(left);
        divideRecursively(right);
    }
}




