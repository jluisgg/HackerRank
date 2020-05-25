package com.jlgg.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Find the char to be removed to make the string a palindrome
 * if the word is already a palindrome or no solution return -1
 */
public class Palindrome {

    static boolean isPalindrome(List<Character> list) {
        Character[] cArr = list.toArray(new Character[0]);
        int j = cArr.length - 1;
        int middle = cArr.length / 2;
        for (int i = 0; i < middle; i++) {
            if (cArr[i] != cArr[j]) {
                return false;
            }
            j--;
        }

        return true;
    }

    static int palindromeIndex(String s) {
        char[] sArr = s.toCharArray();

        List<Character> list = new ArrayList<>();
        for (char el : sArr) {
            list.add(el);
        }

        int j = sArr.length - 1;
        int middle = sArr.length / 2;
        for (int i = 0; i < middle; i++) {
            if (sArr[i] != sArr[j]) {
                // remove i and see if palindrome
                list.remove(i);
                if (isPalindrome(list)) {
                    return i;
                }
                // restore i then remove j and see if palindrome
                list.add(i, sArr[i]);
                list.remove(j);
                if (isPalindrome(list)) {
                    return j;
                }
            }
            j--;
        }

        return -1;
    }

    public static void main(String args[]) {
        String text = "aaa";
        System.out.println(palindromeIndex(text));
    }
}
