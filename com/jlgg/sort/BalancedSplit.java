package com.jlgg.sort;

import java.util.Arrays;

public class BalancedSplit {

    static boolean balancedSplitExists(int[] arr) {
        // sort the Array by asc order
        Arrays.sort(arr);

        // then split left most first as pivot and compare
        boolean isBalanced = false;
        for (int i = 0; i < arr.length; i++) {
            int leftSum = 0;
            for (int j = i; j >= 0; j--) {
                if (j >= 0) {
                    leftSum += arr[j];
                }
            }
            int rightSum = 0;
            for (int k = i + 1; k < arr.length; k++) {
                if (k < arr.length) {
                    rightSum += arr[k];
                }
            }

            if (leftSum == rightSum) {
                isBalanced = true;
                break;
            }
        }

        return isBalanced;

    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 3, 4, 4};
        System.out.println(balancedSplitExists(arr));
    }
}
