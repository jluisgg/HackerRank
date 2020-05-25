package com.jlgg.search;

import java.util.ArrayList;
import java.util.List;

/**
 * Sequential Search. The array is traversed sequentially and every element is checked
 */
public class LinearSearch {
    public static void main(String[] args) {
        int[] elements = {1, 3, 6, 8, 2, 4, 9, 6, 8};
        int searchKey = 6;

        linearSearch(elements, searchKey);
    }

    private static void linearSearch(int[] elements, int searchKey) {
        List<Integer> foundIndexes = new ArrayList();
        for (int i = 0; i < elements.length; i++) {
            if(elements[i] == searchKey) {
                foundIndexes.add(i);
            }
        }
        System.out.println(foundIndexes.toArray(new Integer[foundIndexes.size()]));
    }
}
