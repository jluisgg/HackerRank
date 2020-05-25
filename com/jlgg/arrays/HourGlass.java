package com.jlgg.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Goal: Find max hourglass sum
 * int[row][column]
 */
public class HourGlass {

    // [6 - rows][6 - columns]
    private static final int[] matrixDimensions = {6, 6};

    public static void main(String[] args) {
        // input
        int[][] hgs = {
                {-9, -9, -9, 1, 1, 1},
                {0, -9, 0, 4, 3, 2},
                {-9, -9, -9, 1, 2, 3},
                {0, 0, 8, 6, 6, 0},
                {0, 0, 0, -2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };

        List<Integer> sums = new ArrayList<>();

        // Iterate by rows avoiding out of bounds
        for (int i = 0; (i + 2) < matrixDimensions[1]; i++) {
            // Iterate by columns avoiding out of bounds
            for (int j = 0; (j + 2) < matrixDimensions[0]; j++) {
                // Formula to define an hourglass
                int sum = hgs[i][j] + hgs[i][j + 1] + hgs[i][j + 2]
                        + hgs[i + 1][j + 1] + hgs[i + 2][j] + hgs[i + 2][j + 1] + hgs[i + 2][j + 2];
                sums.add(sum);
            }
        }

        Integer max = 0;
        for (int index = 0; index < sums.size(); index++) {
            if (sums.get(index) > max) {
                max = sums.get(index);
            }
        }

        System.out.println("Maximum sum: " + max);

    }
}
