package com.jlgg.strings;

/**
 * Change the letter into a palindrome
 * a) Can only reduce the value of a letter by 1
 * b) The letter "a" cannot be reduced
 * Each reduction is counted as a single operation, find the minimum number of operations to
 * convert a string into a palindrome.
 */
public class LoveLetter {

    static int[] createLetter(String s) {
        int[] letters = new int[s.length()];
        char[] sArr = s.toCharArray();
        int i = 0;
        for (char c : sArr) {
            letters[i] = (int) c;
            i++;
        }
        return letters;
    }

    static int theLoveLetterMystery(String s) {
        // Create the letters int[]
        int[] letters = createLetter(s);

        int middle = letters.length / 2;
        int last = letters.length - 1;
        int operations = 0;

        // compare first and last letter, reduce the greater until equals
        for (int first = 0; first < middle; first++) {
            if (letters[first] < letters[last]) {
                while (letters[first] != letters[last]) {
                    letters[last] = letters[last] - 1;
                    operations++;
                }
            } else if (letters[first] > letters[last]) {
                while (letters[first] != letters[last]) {
                    letters[first] = letters[first] - 1;
                    operations++;
                }
            }
            last--;
        }

        return operations;
    }

    public static void main(String[] args) {
        String[] arr = {"abc", "abcba", "abcd", "cba"};
        for (String s : arr) {
            System.out.println(theLoveLetterMystery(s));
        }
    }
}
