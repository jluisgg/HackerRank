package com.jlgg.util;

import java.util.*;

/**
 * Used when dealing with data stored as key-value pairs. Keys must be unique
 * <p>
 * HashMap: store data with no guarantee in the order of iteration
 * TreeMap: orders by key value
 * LinkedHashMap orders a map by arrival time
 */
public class MapsUtils {

    public static void iterateMap(Map<Integer, String> map) {
        // Using enhanced for loop and keySet()
        for (Integer key : map.keySet()) {
            System.out.println("key: " + key + ", value: " + map.get(key));
        }
        // Using lambda expression (Java 8)
        map.forEach((key, value) -> System.out.println("key: " + key + ", value: " + value));
    }

    // entrySet() and iterator() - when need to perform operations on values within a map
    public static void iteratorEx(Map map) {
        Iterator<Map.Entry> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = it.next();
            entry.setValue(">>" + entry.getValue() + "<<");

        }
        System.out.println(map.entrySet());
    }

    public static void createTreeMap() {
        Map<Integer, String> map = new TreeMap<>();
        map.put(2, "two");
        map.put(3, "three");
        map.put(1, "one");
        System.out.println(map);
    }

    public static void createLinkedHashMap() {
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(2, "two");
        map.put(3, "three");
        map.put(1, "one");
        System.out.println(map);
    }

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");

        // entrySet() - returns the whole map key=value
        System.out.println(map.entrySet());
        // keySet() - just returns the keys
        System.out.println(map.keySet());

        createTreeMap();
        createLinkedHashMap();
        iterateMap(map);
        iteratorEx(map);
    }
}
