package com.jlgg.hashtables;

import java.util.*;

public class RamsonNote {

    static void checkMagazine(String[] magazine, String[] note) {
        Map<String, List<String>> magMap = new HashMap<>();
        collectMap(magazine, magMap);

        String noteWord;
        for (int i = 0; i < note.length; i++) {
            noteWord = note[i];
            if (magMap.containsKey(noteWord) && !magMap.get(noteWord).isEmpty()) {
                magMap.get(noteWord).remove(noteWord);
            } else {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }

    private static void collectMap(String[] magazine, Map<String, List<String>> map) {
        List<String> list;
        for (int i = 0; i < magazine.length; i++) {
            String word = magazine[i];
            list = new ArrayList();
            if (map.containsKey(word)) {
                map.get(word).add(word);
            } else {
                list.add(word);
                map.put(word, list);
            }
        }
    }

    public static void main(String[] args) {
        String magazine = "give me one grand today night";
        String note = "give one grand today";

        String[] mArr = magazine.split(" ");
        String[] nArr = note.split(" ");

        checkMagazine(mArr, nArr);

    }
}
