package com.jlgg.recursion;

public class Encrypted {
    // Add any helper functions you may need here
    static StringBuffer sb = new StringBuffer();

    // recursive function
    static String findEncryptedWord(String s) {
        char[] sArr = s.toCharArray();

        if(s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            sb.append(s);
            return "";
        }

        int middle = 0;
        if(s.length() % 2 == 0) {
            // if even, the middle is the left most char
            middle = (s.length() / 2) - 1 ;
        } else {
            middle = s.length() / 2;
        }

        sb.append(sArr[middle]);
        // substring [begin, end) - does not include end
        findEncryptedWord(s.substring(0, middle));
        findEncryptedWord(s.substring(middle + 1, s.length()));
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "abcxcba";
        System.out.println(findEncryptedWord(s));
    }
}
