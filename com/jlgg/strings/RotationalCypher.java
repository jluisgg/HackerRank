package com.jlgg.strings;

import java.util.ArrayList;
import java.util.List;

public class RotationalCypher {
    static Character[] charsArr = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    static int[] digitsArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    static List<Character> charsList;
    static List<Integer> digitsList;

    private static void createLists() {
        charsList = new ArrayList<>();
        for (int i = 0; i < charsArr.length; i++) {
            charsList.add(charsArr[i]);
        }
        digitsList = new ArrayList<>();
        for (int i = 0; i < digitsArr.length; i++) {
            digitsList.add(digitsArr[i]);
        }
    }

    public static Character rotateChar(Character c, int factor) {
        int newIndex = (charsList.indexOf(c) + factor) % 26;
        return charsArr[newIndex];
    }

    public static int rotateDigit(int d, int factor) {
        int newIndex = (digitsList.indexOf(d) + factor) % 10;
        return digitsArr[newIndex];
    }

    public static void main(String[] args) {
        // Input
        String input = "abcdefghijklmNOPQRSTUVWXYZ0123456789";
        int rotationFactor = 39;

        // Populate ArrayLists
        createLists();

        char[] inputArr = input.toCharArray();
        StringBuilder cyphered = new StringBuilder();
        Character current; boolean isUC;
        for (int i = 0; i < inputArr.length; i++) {
            current = inputArr[i];
            isUC = Character.isUpperCase(current);
            if (charsList.contains(Character.toLowerCase(current))) {
                current = isUC ? Character.toLowerCase(current) : current;
                cyphered.append(rotateChar(current, rotationFactor));
            } else if (digitsList.contains(Character.getNumericValue(current))) {
                cyphered.append(rotateDigit(Character.getNumericValue(current), rotationFactor));
            } else {
                cyphered.append(current);
            }
        }

        System.out.println(cyphered.toString());
    }
}