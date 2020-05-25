package com.jlgg.euler;

public class P9 {

    private static int[] pythagoreanTriplet() {
        int[] result = new int[3];
        int sum = 0;
        for (int i = 1; i <= 997; i++) {
            for (int j = i + 1; j <= 998; j++) {
                for (int k = j + 1; k <= 999; k++) {
                    sum = i + j + k;
                    if (sum == 1000) {
                        if (Math.pow(i, 2) + Math.pow(j, 2) == Math.pow(k, 2)) {
                            result[0] = i;
                            result[1] = j;
                            result[2] = k;
                            return result;
                        }
                    }
                }
            }

        }

        return result;
    }

    public static void main(String[] args) {
        int[] result = pythagoreanTriplet();

        System.out.println("a:" + result[0] + " b:" + result[1] + " c:" + result[2]);
        System.out.println(result[0] * result[1] * result[2]);
    }
}
