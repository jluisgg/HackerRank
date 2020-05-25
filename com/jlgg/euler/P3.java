package com.jlgg.euler;

public class P3 {

    private static long maxPrime = 2;

    private static void calcNextPrime() {
        for (long i = maxPrime + 1; i <= Long.MAX_VALUE; i++) {
            if (i == 3 || i == 5 || i == 7) {
                maxPrime = i;
                break;
            } else if (i % 2 != 0 && i % 3 != 0 && i % 5 != 0 && i % 7 != 0) {
                maxPrime = i;
                break;
            }
        }
    }

    public static void main(String[] args) {
        long result = 600851475143l;
        while (result != 1) {
            if (result % maxPrime != 0) {
                calcNextPrime();
            } else {
                result = result / maxPrime;
            }
        }

        System.out.println(maxPrime);
    }
}
