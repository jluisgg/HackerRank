package com.jlgg.euler;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class P6 {
    public static void main(String[] args) {
        int n = 100;
        long sumN = 0l;
        long sumSq = 0l;

        for (int i = 1; i <= n; i++) {
            sumN += i;
            sumSq += Math.pow(i, 2.0);
        }

        NumberFormat formatter = new DecimalFormat("#########");
        String f = formatter.format(Math.pow(sumN, 2.0) - sumSq);
        System.out.println(f);
    }
}
