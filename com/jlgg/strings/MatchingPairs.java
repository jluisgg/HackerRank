package com.jlgg.strings;

import java.util.*;

public class MatchingPairs {

    // Add any helper functions you may need here
    private static boolean checkIfExists(String s, String t) {
        char[] tArr = t.toCharArray();
        for (int i = 0; i < tArr.length; i++) {
            if (!s.contains(Character.toString(tArr[i]))) {
                return false;
            }
        }
        return true;
    }

    // {Character: pos1,pos2,pos3, etc} for str
    private static Map<Character, List<Integer>> collectMap(String str) {
        char[] strArr = str.toCharArray();
        Map<Character, List<Integer>> map = new HashMap<>();
        List<Integer> indexes;
        for (int i = 0; i < strArr.length; i++) {
            if (!map.containsKey(strArr[i])) {
                indexes = new ArrayList<>();
                indexes.add(i);
                map.put(strArr[i], indexes);
            } else {
                map.get(strArr[i]).add(i);
            }
        }

        return map;
    }

    private static int[] getMinAndMax(String s, Map<Character, List<Integer>> sMap, Map<Character, List<Integer>>tMap) {
        int[] maxAndMin = new int[2];
        // iterate the map, for each key get the first el and determine min, repeat for max
        int min = s.length() - 1;
        int max = 0;
        int cMin;
        int cMax;
        List<Integer> indexes;

        for (Character entry : tMap.keySet()) {
            indexes = sMap.get(entry);
            cMin = indexes.get(0);
            cMax = indexes.get(indexes.size() - 1);
            min = cMin < min ? cMin : min;
            max = cMax > max ? cMax : max;
        }

        maxAndMin[0] = min;
        maxAndMin[1] = max;

        return maxAndMin;
    }

    private static boolean isValidSubstring(Map<Character, List<Integer>> tMap, Map<Character, List<Integer>> subMap) {
        // compare frequency of each key of tMap against frequency of subMap
        for (Character key : tMap.keySet()) {
            if (tMap.get(key).size() != subMap.get(key).size()) {
                return false;
            }
        }

        return true;
    }

    static int minLengthSubstring(String s, String t) {
        // check if every t is contained in s
        if (!checkIfExists(s, t)) {
            return -1;
        }

        // {Character: pos1,pos2,pos3, etc} for t
        Map<Character, List<Integer>> tMap = collectMap(t);

        // Get the Min and Max Position
        Map<Character, List<Integer>> sMap = collectMap(s);
        int[] minAndMax = getMinAndMax(s, sMap, tMap);
        System.out.println(Arrays.toString(minAndMax));

        // Get SubString
        String subStr = s.substring(minAndMax[0], minAndMax[1]);

        // collect Map of SubString
        Map<Character, List<Integer>> subMap = collectMap(s);

        // Based on both Maps (chars frequency) check if valid substring
        boolean isValid = isValidSubstring(tMap, subMap);

        if (isValid) {
            return (minAndMax[1] - minAndMax[0]) + 1;
        } else {
            return -1;
        }

    }

    public static void main(String[] args) {
        String s = "dcbefebce";
        String t = "fd";

        System.out.println(minLengthSubstring(s,t));
    }
}
