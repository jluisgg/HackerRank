package com.jlgg.util;

import java.util.*;

/**
 * Lists are sequential collections of data. Series of nodes connected by links.
 * <p>
 * Note: Lists generated from Arrays.asList() do not behave the same way as List
 * because they have fixed length, the elements cannot be removed
 * SO BETTER USE Collections.addAll(list, arr[])
 */
public class ListsUtils {

    public static void iterate(List<Integer> list) {
        // using enhanced loop
        for (Integer el : list) {
            System.out.println(el);
        }
        // using lambda expression
        list.forEach(System.out::println);
    }

    // listIterator() - allows perform ops on elements
    public static void listIteratorEx(List<Integer> list) {
        System.out.println("Original list: " + list);
        ListIterator<Integer> listIt = list.listIterator();
        int el = 0;
        while (listIt.hasNext()) {
            el = listIt.next() * 2;
            listIt.set(el);
        }
        System.out.println("Modified list: " + list);
    }

    public static void listToObjectsArr(List<Integer> list) {
        // using toArray()
        Integer[] arr = list.toArray(new Integer[0]);
        System.out.println(Arrays.toString(arr));
        // using Stream API
        Integer[] arr2 = list.stream().toArray(Integer[]::new);
        System.out.println(Arrays.toString(arr2));
    }

    public static void listToPrimitivesArr(List<Integer> list) {
        // using Stream API
        int arr[] = list.stream().mapToInt(i -> i).toArray();
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Integer[] numbers = {7, 35, 19, 11, 83, 7};
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, numbers);

        //indexOf - position of an object
        System.out.println(list.indexOf(11));
        // lastIndexOf - position of the last occurrence of an object
        System.out.println(list.lastIndexOf(7));
        // remove() - by index of by object
        list.remove(0);
        System.out.println(list);
        // set() - change the content of a node
        list.set(0, 23);
        System.out.println(list);
        // clear() - empties the list
        list.clear();
        System.out.println(list);
        // subList() - returns a view of the portion of the list
        Collections.addAll(list, numbers);
        System.out.println(list.subList(0, 3));
        // sort() - with the help of Collections
        Collections.sort(list);
        System.out.println(list);
        // reverse() - with the help of Collections
        Collections.reverse(list);
        System.out.println(list);
        // swap() - with the help of Collections
        Collections.swap(list, 0, list.size() - 1);
        System.out.println(list);

        iterate(list);
        listToObjectsArr(list);
        listToPrimitivesArr(list);
        listIteratorEx(list);
    }
}
