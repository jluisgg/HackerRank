package com.jlgg.strings;

import java.util.*;

public class WordsFrequency {

    private static List<String> wList = new ArrayList<>();
    private static List<Data> frequencies = new ArrayList<>();

    /**
     * Data class to avoid using Map and create a list of this objects instead
     * to eventually be used by SortByValue class
     */
    static class Data {
        String word;
        int frequency;

        Data(String w, int f) {
            word = w;
            frequency = f;
        }

        @Override
        public String toString() {
            return "word: " + word + " freq: " + frequency;
        }
    }

    /**
     * This class implements comparator interface and must implement compare()
     * to sort by value in descending order
     */
    static class SortByValue implements Comparator<Data> {
        public int compare(Data a, Data b) {
            return b.frequency - a.frequency;
        }
    }

    private static void textToWordsList(String text) {
        // \s+ regex for one or more whitespaces
        String[] textArr = text.split("\\s+");
        Collections.addAll(wList, textArr);
    }

    private static void calcFrequencies() {
        Set<String> wSet = new HashSet<>();
        wSet.addAll(wList);
        for (String word : wSet) {
            // Get the amount of times this word shows in the text
            int freq = Collections.frequency(wList, word);
            // Add Data object to frequencies list
            frequencies.add(new Data(word, freq));
        }
    }

    public static void main(String[] args) {
        String text = "this is just a test this an awesome  @ this is a program for this night";
        // Convert Text to Words list
        textToWordsList(text);
        // Calculate the Frequencies
        calcFrequencies();
        // Sort the Words Desc by Frequency
        Collections.sort(frequencies, new SortByValue());
        // Print the list
        System.out.println(frequencies);
    }
}
