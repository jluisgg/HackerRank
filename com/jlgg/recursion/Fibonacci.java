package com.jlgg.recursion;

/**
 * A recursive function is tail recursive when recursive call is the last thing
 * executed by the function.
 * Time Complexity is: O(2^N) exponential
 */
public class Fibonacci {

    static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        // Tail recursion
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(fibonacci(n));
    }
}
