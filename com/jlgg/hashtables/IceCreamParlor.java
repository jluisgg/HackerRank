package com.jlgg.hashtables;

import java.util.*;

/**
 * Sunny and Johnny never buy the same flavor, and they have to spend all their money.
 * Given the money to spend and a list of prices, the function should return an array containing the indexes
 * of the prices they buy, sorted ascending
 */
public class IceCreamParlor {

    /**
     * O(N^2) - Polynomial Complexity
     */
    static int[] icecreamParlor(int m, int[] arr) {
        int[] result;

        int el1;
        int el2;
        // Permutations el1 vs rest, then el1 + 1 vs the rest
        for (int i = 0; i < arr.length; i++) {
            el1 = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                el2 = arr[j];
                if (m == el1 + el2) {
                    // If they add up finish
                    result = new int[2];
                    result[0] = i + 1;
                    result[1] = j + 1;
                    return result;
                }
            }
        }
        // el1 and el2 did not add up, look if el1 matches m
        for (int i = 0; i < arr.length; i++) {
            if (m == arr[i]) {
                result = new int[1];
                result[0] = i + 1;
                return result;
            }
        }

        return new int[0];
    }


    /**
     * Use a HashMap to make it O(N) - linear complexity
     * m = el1 + el2, therefore: el2 = m - el1
     * We transform it into a Search problem for el2
     */
    static int[] icecreamParlorv2(int m, int[] arr) {
        int el1 = -1;
        int el2 = -1;

        Map<Integer, List<Integer>> costToIndex = createMap(arr);
        for (int i = 0; i < arr.length; i++) {
            // Look for el2 = m - el1
            if(costToIndex.containsKey(m - arr[i])) {
                el1 = i;
                el2 = costToIndex.get(m - arr[i]).get(0); // get the lowest index
                // Verify el1 and el2 do not refer to the same index
                if(el1 == el2) {
                    if(costToIndex.get(m - arr[i]).size() > 1) {
                        el2 = costToIndex.get(m - arr[i]).get(1);
                        break;
                    }
                } else {
                    break;
                }
            }
        }

        el1 += 1;
        el2 += 1;
        int[] result = {el1, el2};
        return result;
    }

    /**
     * map = {cost1: index1 index2, cost2: index3, index4}
     */
    private static Map<Integer, List<Integer>> createMap(int arr[]) {
        Map<Integer, List<Integer>> costToIndex = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!costToIndex.containsKey(arr[i])) {
                List<Integer> indexList = new LinkedList<>();
                indexList.add(i);
                costToIndex.put(arr[i], indexList);
            } else {
                costToIndex.get(arr[i]).add(i);
            }
        }
        return costToIndex;
    }

    public static void main(String[] args) {
        int money = 2;
        int[] flavorsCosts = {1, 4, 5, 3, 2};

        System.out.println(Arrays.toString(icecreamParlor(money, flavorsCosts)));
        System.out.println(Arrays.toString(icecreamParlorv2(money, flavorsCosts)));
    }

}
