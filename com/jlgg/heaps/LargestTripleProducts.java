package com.jlgg.heaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class LargestTripleProducts {

    public static int[] findMaxProduct(int[] arr) {

        int[] results = new int[arr.length];

        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < arr.length; i++) {
            if (i < 2) {
                results[i] = -1;
            } else {
                for (int j = 0; j <= i; j++) {
                    maxheap.add(arr[j]);
                }
                int p1 = maxheap.poll();
                int p2 = maxheap.poll();
                int p3 = maxheap.poll();

                results[i] = p1 * p2 * p3;
            }
        }

        return results;
    }

    public static void main(String[] args) {
        int[] elements = {2, 4, 7, 1, 5, 3};
        System.out.println(Arrays.toString(findMaxProduct(elements)));
    }
}
