package com.jlgg.euler;

public class P10 {

    private static long maxPrime = 2;
    private static long sumPrimes = 2;

    private static void findNextPrime(long next) {
        if (isPrime(next)) {
            maxPrime = next;
            sumPrimes += maxPrime;
        }
    }

    public static boolean isPrime(long number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        long next = 2;
        while (next < 2000000) {
            if (next % 2 != 0) {
                findNextPrime(next);
            }
            next++;
        }
        System.out.println(sumPrimes);
    }
}
