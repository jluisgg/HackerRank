package com.jlgg.strings;

import java.util.Arrays;

public class SplitText {
    public static void main(String[] args) {
        String text = "\"\"@+ This is a text, eliminate punctuation, only words. No especial chars, Mike's 9934 $usd #$%<>@";
        // Split the text around white space
        String[] words = text.split("\\s");
        // Remove any punctuation
        for (int i = 0; i < words.length; i++) {
            // [^\w] replace anything that is not a word with an empty string
            words[i] = words[i].replaceAll("[^\\w]", "");
        }

        System.out.println(Arrays.toString(words));
    }
}
