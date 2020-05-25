package com.jlgg.euler;

public class P4 {

    private static boolean isPalindrome(long number) {
        char[] nArr = String.valueOf(number).toCharArray();
        int middle = nArr.length / 2;
        int right = nArr.length - 1;
        for (int left = 0; left < middle; left++) {
            if (nArr[left] != nArr[right]) {
                return false;
            }
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        long product = 0;
        long maxPalindrome = 0;
        for (int i = 999; i >= 100; i--) {
            for (int j = 999; j >= 100; j--) {
                product = i * j;
                if (isPalindrome(product)) {
                    maxPalindrome = product > maxPalindrome ? product : maxPalindrome;
                }
            }
        }
        System.out.println(maxPalindrome);
    }
}
