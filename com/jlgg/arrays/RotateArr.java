package com.jlgg.arrays;

import java.util.Arrays;

public class RotateArr {

    static int[] rotLeft(int[] a, int r) {
        if (r == 0) {
            return a;
        }
        // 1 2 3 4 5 ->  2 3 4 5 1 -> 3 4 5 1 2 -> 4 5 1 2 3 -> 5 1 2 3 4
        for (int i = 1; i <= r; i++) {
            // Store first element
            int el = a[0];
            // Shift elements to the left
            for (int j = 0; j < a.length - 1; j++) {
                a[j] = a[j + 1];
            }
            // Place first element to the end of the array
            a[a.length - 1] = el;
        }

        return a;
    }

    static int[] rotateRight(int[] a, int r) {
        if (r == 0) {
            return a;
        }
        // 1 2 3 4 5 -> 5 1 2 3 4 -> 4 5 1 2 3 -> 3 4 5 1 2 -> 2 3 4 5 1
        for (int i = 1; i <= r; i++) {
            // Store last element
            int el = a[a.length - 1];
            // Shift elements to the right
            for (int j = a.length - 1; j > 0; j--) {
                a[j] = a[j - 1];
            }
            // Place last element to the beginning of the array
            a[0] = el;
        }

        return a;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] arr2 = arr.clone();
        int rotations = 3;
        System.out.println("Left Rotation: " + Arrays.toString(rotLeft(arr, 3)));
        System.out.println("Right Rotation: " + Arrays.toString(rotateRight(arr2, 3)));
    }
}
