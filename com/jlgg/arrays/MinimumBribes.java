package com.jlgg.arrays;

public class MinimumBribes {
    static void minimumBribes(int[] q) {
        int totalBribes = 0;
        for (int i = 0; i < q.length; i++) {
            // get # of bribes of current el
            int bribes = q[i] - (i + 1);
            if (bribes > 2) {
                System.out.println("Too chaotic");
                return;
            } else {
                if (bribes > 0) {
                    totalBribes += bribes;
                } else if (bribes < 0) {
                    // Check if current el bribed
                    if ((i + 1) < q.length && q[i] > q[i + 1]) {
                        bribes = Math.abs(bribes);
                        if(bribes > 2) {
                            System.out.println("Too chaotic");
                        } else {
                            totalBribes += bribes;
                        }
                    }
                }
            }
        }

        System.out.println(totalBribes);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 3, 7, 8, 6, 4};
        minimumBribes(arr);
    }
}
