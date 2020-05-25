package com.jlgg.arrays;

public class NewYearChaos {

    static void minimumBribes(int[] q) {
        int bribes = 0;
        for (int i = 0; i < q.length; i++) {
            // if current el is more than two pos ahead its original
            if (q[i] - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }
            // traverse the array from current pos - 2,
            // if el bigger than current there was a bribe
            for (int j = q[i] - 2; j < i; j++) {
                if (j >= 0 && q[j] > q[i]) {
                    bribes++;
                }
            }
        }
        System.out.println(bribes);
    }

    public static void main(String[] args) {
        int[] pos = {2, 1, 5, 3, 4};
        minimumBribes(pos);

    }
}
