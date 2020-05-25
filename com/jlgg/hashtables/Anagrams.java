package com.jlgg.hashtables;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagrams {

    static int sherlockAndAnagrams(String s) {
        // Dictionary to store the {substring: frequency}
        Map<String, Integer> map = new HashMap<>();

        // define the length of the subString
        int throttle = s.length() - 1;
        for (int i = 1; i <= throttle; i++) {
            // this loop controls the # of substrings
            for (int j = 0; j < s.length(); j++) {
                if (j + i <= s.length()) {
                    char[] fArr = s.substring(j, j + i).toCharArray();
                    Arrays.sort(fArr);
                    String first = String.valueOf(fArr);
                    // this loop controls the length of the substings
                    for (int k = j + 1; k <= s.length(); k++) {
                        if (k + i <= s.length()) {
                            char[] sArr = s.substring(k, k + i).toCharArray();
                            Arrays.sort(sArr);
                            String second = String.valueOf(sArr);
                            // Sorted string is key to identify if anagram
                            if (first.equals(second)) {
                                String key = String.valueOf(first);
                                if (!map.containsKey(key)) {
                                    map.put(key, 1);
                                } else {
                                    map.put(key, map.get(key) + 1);
                                }
                            }
                        }
                    }
                }
            }
        }

        int anagrams = 0;
        for (String key : map.keySet()) {
            anagrams += map.get(key);
        }

        return anagrams;
    }

    public static void main(String[] args) {
        String input = "abba";
        System.out.println(sherlockAndAnagrams(input));
    }
}
