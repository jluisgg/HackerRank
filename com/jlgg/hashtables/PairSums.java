package com.jlgg.hashtables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairSums {

    // Add any helper functions you may need here
    static Map<Integer, List<Integer>> elMap;

    // {el2 : index,index}
    static void createMap(int[] arr) {
        elMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int el = arr[i];
            if (!elMap.containsKey(el)) {
                List<Integer> indexes = new ArrayList<>();
                indexes.add(i);
                elMap.put(el, indexes);
            } else {
                elMap.get(el).add(i);
            }
        }
    }


    static int numberOfWays(int[] arr, int k) {
        // k = el1 + el2 therefore el2 = k - el1, search problem for el2
        createMap(arr);
        int validPairs = 0;
        for (int i = 0; i < arr.length; i++) {
            int el1 = arr[i];
            int el2 = k - el1;
            if (elMap.containsKey(el2)) {
                int indexes = elMap.get(el2).size();
                if (el1 == el2) {
                    indexes--;
                    int sum = (indexes * (indexes + 1)) / 2;
                    validPairs += sum;
                } else {
                    validPairs += indexes;
                }
            }
            elMap.remove(el1);
            elMap.remove(el2);
        }

        return validPairs;
    }

    public static void main(String[] args) {
        int[] elements = {1, 5, 3, 3, 3, 3};
        int sum = 6;

        System.out.println(numberOfWays(elements, sum));
    }
}
