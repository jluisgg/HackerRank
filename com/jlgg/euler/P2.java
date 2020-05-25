package com.jlgg.euler;

public class P2 {

    public static void main(String[] args) {
        long max = 4000000;
        long evenSum = 0;

        // 1, 2, 3, 5, 8, 13
        long[] preValues = {1, 1};
        long currentValue = 1;
            while (currentValue < max) {
            currentValue = preValues[0] + preValues[1];
            if (currentValue > max) {
                break;
            }
            preValues[0] = preValues[1];
            preValues[1] = currentValue;

            if (currentValue % 2 == 0) {
                evenSum += currentValue;
            }
        }

        System.out.println(evenSum);

    }
}
