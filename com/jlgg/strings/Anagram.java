package com.jlgg.strings;

import java.util.*;

/**
 * You will be given a string. You must split it into two contiguous substrings,
 * then determine the minimum number of characters to change to make the two substrings
 * into anagrams of one another.
 */
public class Anagram {

    static void fillMap(Map<Character, Integer> map, char[] arr) {
        for (char c : arr) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
    }

    /**
     * It should return the minimum number of characters to change to make the words anagrams,
     * or -1  if it's not possible.
     */
    static int anagram(String s) {
        if (s.length() % 2 != 0) {
            return -1;
        }
        // Split the String in 2
        int middle = s.length() / 2;
        char[] s1Arr = s.substring(0, middle).toCharArray();
        char[] s2Arr = s.substring(middle, s.length()).toCharArray();
        // Create Maps
        Map<Character, Integer> map1 = new HashMap<>();
        fillMap(map1, s1Arr);
        Map<Character, Integer> map2 = new HashMap<>();
        fillMap(map2, s2Arr);

        // The idea is to make S1 equal to S2
        int counter = 0;
        for(Character c : map2.keySet()) {
            // Check if char is contained in map1
            if(!map1.containsKey(c)) {
                // char(s) needs to be changed
                counter += map2.get(c);
            } else {
                // calc diff frequencies, if map1 has more then 0 chars changed,
                // otherwise, the diff means chars to be changed
                counter += Math.max(0, map2.get(c) - map1.get(c));
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        String[] sArr = {"xaxbbbxx"};

        for (String el : sArr) {
            System.out.println(anagram(el));
        }
    }
}
