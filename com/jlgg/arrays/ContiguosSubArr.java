package com.jlgg.arrays;

import java.util.Arrays;

public class ContiguosSubArr {

    public static int[] countSubarrays(int[] arr) {
        int[] result = new int[arr.length];
        // Iterate arr
        int current;
        int subArrays;
        for (int i = 0; i < arr.length; i++) {
            subArrays = 1;
            current = arr[i];
            // one loop to the left
            for (int j = i; j >= 0; j--) {
                if ((j - 1) >= 0 && current > arr[j - 1]) { // protect outofbounds
                    subArrays += 1;
                } else {
                    break;
                }
            }
            // one loop to the right
            for (int j = i; j < arr.length; j++) {
                if ((j + 1) < arr.length && current > arr[j +1]) { // protect outofbouns
                    subArrays += 1;
                } else {
                    break;
                }
            }

            result[i] = subArrays;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = {3, 4, 1, 6, 2};
        System.out.println(Arrays.toString(countSubarrays(a)));
    }
}
