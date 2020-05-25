package com.jlgg.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysUtils {

    public static void iterate(int[] arr) {
        // enhanced loop
        for (int el : arr) {
            System.out.println(el);
        }
    }

    public static void objectsArrToList(String[] arr) {
        // a) not preferred Arrays.asList() - fixed size(), more restrictive
        List<String> myList = Arrays.asList(arr);
        System.out.println(myList);
        // b) preferred Collections.addAll(list, arr[])
        List<String> myList2 = new ArrayList<>();
        Collections.addAll(myList2, arr);
        System.out.println(myList2);
    }

    public static void primitivesArrToList(int[] arr) {
        // a) using enhanced loop
        List<Integer> list = new ArrayList<>();
        for (int el : arr) {
            list.add(el);
        }
        System.out.println(list);
        // b) Using Stream API
        List<Integer> list2 = Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println(list2);
    }

    public static void main(String[] args) {
        // Sort Array
        String[] text = new String[]{"spam", "more", "buy"};
        Arrays.sort(text);
        // Array to String
        System.out.println(Arrays.toString(text));
        // Fill an Array
        int[] numbers = new int[5];
        Arrays.fill(numbers, 100);
        System.out.println(Arrays.toString(numbers));
        // Copy a range
        int[] numbers2 = Arrays.copyOfRange(numbers, 0, 2);
        System.out.println(Arrays.toString(numbers2));
        // Compare if equals
        int[] numbers3 = {100, 100, 100, 100, 100};
        System.out.println(Arrays.equals(numbers, numbers3));
        // Binary Search in a sorted Array
        System.out.println(Arrays.binarySearch(text, "more"));

        iterate(numbers3);
        objectsArrToList(text);
        primitivesArrToList(numbers3);
    }
}
