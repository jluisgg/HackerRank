package com.jlgg.warmup;

/**
 * Can jump in cumulus clouds(0) which index = [index + 1],[index + 2]
 * Minimum number of jumps from starting position to the end
 * c=[0,1,0,0,0,1,0]
 * Paths = 0 -> 2 -> 4 -> 6 or 0 -> 2 -> 3 -> 4 -> 6
 */
public class JumpingClouds {

    static int jumpingOnClouds(int[] c) {
        int jumps = 0;
        for (int i = 0; i < c.length; i++) {
            if (i + 2 < c.length && c[i + 2] == 0) {
                i++;
                jumps++;
            } else if (i + 1 < c.length && c[i + 1] == 0) {
                jumps++;
            }
        }

        return jumps;
    }

    public static void main(String[] args) {
        int[] clouds = {0, 0, 1, 0, 0, 1, 0};
        System.out.println(jumpingOnClouds(clouds));
    }
}
