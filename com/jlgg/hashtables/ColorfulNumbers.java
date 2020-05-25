package com.jlgg.hashtables;

import java.util.*;

/**
 * Colorful number: When in a given number, product of every digit of a contiguous sub-sequence are different
 * Number:3245
 * 3, 2, 4, 5, 3*2=6, 2*4=8, 4*5=20, 3*2*4=24, 2*4*5=40 -> is colorful
 * Number:326
 * 3, 2, 6, 3*2=6, 2*6=12 -> not colorful because product of (3*2)=6 and 6 are repeated
 */
public class ColorfulNumbers {

    public static boolean isColorful(List<Integer> digits) {
        // Create a Set of products, so if already contains a product then is not colorful
        Set<Integer> productsSet = new HashSet<>();

        // Iterate by groups of: 1, 2, 3,... digits.length -1
        int groupSize = 1;
        while (groupSize < digits.size()) {
            // Second loop to obtain the first operand
            for (int i = 0; i < digits.size(); i++) {
                int product = digits.get(i);
                boolean outOfBounds = false;
                // Third loop to obtain the rest of the operands
                // i + groupSize = how many more operands to include
                // if 1st run, then 0 more, if 2nd run then just 1 more, if 3rd run then just 2 more
                for (int j = i + 1; j < i + groupSize; j++) {
                    // Check if Out of bounds
                    if (j >= digits.size()) {
                        outOfBounds = true;
                        break;
                    }
                    product = product * digits.get(j);
                }

                if (!outOfBounds) {
                    if (productsSet.contains(product)) {
                        return false;
                    } else {
                        productsSet.add(product);
                    }
                }
            }
            groupSize++;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "3245";
        char[] sArr = s.toCharArray();
        // ArrayList is more convenient than array
        List<Integer> digits = new ArrayList<>();
        for (int i = 0; i < sArr.length; i++) {
            digits.add(Character.getNumericValue(sArr[i]));
        }
        System.out.println("Is " + s + " Colorful? Ans: " + isColorful(digits));
    }
}
