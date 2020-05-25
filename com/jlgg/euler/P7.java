package com.jlgg.euler;

public class P7 {

    private static long maxPrime = 0;
    private static long counter = 0;

    public static boolean isPrime(long number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        counter++;
        return true;
    }


    public static void main(String[] args) {
        int n = 10000;
        while (counter <= n) {
            long next = maxPrime + 1;
            while (!isPrime(next)) {
                next++;
            }
            maxPrime = next;
        }

        System.out.println(maxPrime);
    }
}
