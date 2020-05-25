package com.jlgg.util;

import java.util.*;

/**
 * Sets store objects of a specific type avoiding duplicates:
 * <p>
 * HashSet: store data with no guarantee in the order of iteration
 * TreeSet: Orders by Set value
 * LinkedHashSet: Orders a Set by arrival time
 */
public class SetsUtils {

    public static void hashSetFromArray() {
        String[] arr = {"3", "25", "2", "79", "2"};
        Set<String> mySet = new HashSet<>();
        Collections.addAll(mySet, arr);
        System.out.println(mySet);
    }

    public static void treeSetFromArray() {
        String[] arr = {"3", "25", "2", "79", "2"};
        Set<String> mySet = new TreeSet<>();
        Collections.addAll(mySet, arr);
        System.out.println(mySet);
    }

    public static void linkedHashSetFromArray() {
        String[] arr = {"3", "25", "2", "79", "2"};
        Set<String> mySet = new LinkedHashSet<>();
        Collections.addAll(mySet, arr);
        System.out.println(mySet);
    }

    // union: set1.addAll(set2)
    public static void unionOp() {
        Integer[] numbers1 = new Integer[]{3, 25, 2, 79, 2};
        Integer[] numbers2 = new Integer[]{7, 12, 14, 79};
        Set<Integer> set1 = new TreeSet<>();
        Collections.addAll(set1, numbers1);
        Set<Integer> set2 = new TreeSet<>();
        Collections.addAll(set2, numbers2);
        set1.addAll(set2);
        System.out.println(set1);
    }

    // intersection: set1.retainAll(set2),
    // just leaves the ones in common between the 2 sets
    public static void intersectionOp() {
        Integer[] numbers1 = new Integer[]{3, 25, 2, 79, 2};
        Integer[] numbers2 = new Integer[]{7, 12, 14, 79};
        Set<Integer> set1 = new TreeSet<>();
        Collections.addAll(set1, numbers1);
        Set<Integer> set2 = new TreeSet<>();
        Collections.addAll(set2, numbers2);
        set1.retainAll(set2);
        System.out.println(set1);
    }

    // removeAll() - removes elements in common with set2
    public static void removeOp() {
        Integer[] numbers1 = new Integer[]{3, 25, 2, 79, 2};
        Integer[] numbers2 = new Integer[]{7, 12, 14, 79};
        Set<Integer> set1 = new TreeSet<>();
        Collections.addAll(set1, numbers1);
        Set<Integer> set2 = new TreeSet<>();
        Collections.addAll(set2, numbers2);
        set1.removeAll(set2);
        System.out.println(set1);
    }

    // containsAll() - Check whether the whole of set is contained within another set
    public static void containsOp() {
        Integer[] numbers1 = new Integer[]{7, 12, 14, 79};
        Integer[] numbers2 = new Integer[]{7, 12, 14};
        Set<Integer> set1 = new TreeSet<>();
        Collections.addAll(set1, numbers1);
        Set<Integer> set2 = new TreeSet<>();
        Collections.addAll(set2, numbers2);
        System.out.println(set1.containsAll(set2));
    }

    // iterate a Set
    public static void iterateSet() {
        Integer[] numbers = new Integer[]{7, 12, 14, 79};
        Set<Integer> set = new TreeSet<>();
        Collections.addAll(set, numbers);

        // Using enhanced for loop
        for (Integer val : set) {
            System.out.println(val);
        }
        // Using lambda expression
        set.forEach(System.out::println);
    }

    public static void setToObjectsArr(Set<Integer> set) {
        // Using toArr()
        Integer[] arr = set.toArray(new Integer[0]);
        System.out.println(Arrays.toString(arr));
        // Using Stream API
        Integer[] arr2 = set.stream().toArray(Integer[]::new);
        System.out.println(Arrays.toString(arr2));
    }

    public static void setToPrimitivesArr(Set<Integer> set) {
        // using Stream API
        int arr[] = set.stream().mapToInt(i -> i).toArray();
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        hashSetFromArray();
        treeSetFromArray();
        linkedHashSetFromArray();
        unionOp();
        intersectionOp();
        removeOp();
        containsOp();
        iterateSet();

        Integer[] numbers = new Integer[]{7, 12, 14, 79};
        Set<Integer> set = new TreeSet<>();
        Collections.addAll(set, numbers);

        setToObjectsArr(set);
        setToPrimitivesArr(set);
    }
}
