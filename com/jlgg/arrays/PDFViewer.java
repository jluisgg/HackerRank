package com.jlgg.arrays;

import java.util.HashMap;
import java.util.Map;

public class PDFViewer {

    public static void main(String[] args) {
        int[] heights = {1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        String word = "abc";

        System.out.println(designerPdfViewer(heights, word));
    }

    private static int designerPdfViewer(int[] h, String word) {
        // Create letter:height dictionary
        Map<String, Integer> dictionary = new HashMap<>();
        populateDictionary(dictionary, h);

        // calculate highlighted area
       return calcHighlightedArea(dictionary, word);
    }

    private static void populateDictionary(Map<String, Integer> dictionary, int[] heights) {
        String[] keys = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        for (int i = 0; i < heights.length; i++) {
            dictionary.put(keys[i], heights[i]);
        }
    }

    private static int calcHighlightedArea(Map<String, Integer> dictionary, String word) {
        char[] wordArray = word.toCharArray();

        // calc wide
        int wide = wordArray.length;

        // calc height
        int height = 0;
        int highest = 0;
        for (int i = 0; i < wordArray.length; i++) {
            height = dictionary.get(String.valueOf(wordArray[i]));
            if (height > highest) {
                highest = height;
            }
        }

        return wide * highest;

    }
}
