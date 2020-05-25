package com.jlgg.warmup;

/**
 * Given a list of colors find the # of pairs
 */
public class SockMerchant {

    public static void main(String[] args) {

        int[] colors = {10, 20, 20, 10, 10, 30, 50, 10, 20};

        // calculate pairs
        int numberOfPairs = calculatePairs(colors);

        System.out.println("Number of Pairs: " + numberOfPairs);

    }

    private static int calculatePairs(int[] colors) {
        int pairs = 0;

        // Process each item
        for (int i = 0; i < colors.length; i++) {
            int color = colors[i];
            int frequency = 1;
            // skip processed items (-1)
            if (color > 0) {
                // compare current color against the rest of the items
                for (int j = i + 1; j < colors.length; j++) {
                    int nextColor = colors[j];
                    if (color == nextColor) {
                        // there was match
                        frequency++;
                        // mark next item as processed
                        colors[j] = -1;
                    }
                }
            }
            // mark current item as processed
            colors[i] = -1;
            pairs = pairs + (frequency / 2);
        }

        return pairs;
    }
}
