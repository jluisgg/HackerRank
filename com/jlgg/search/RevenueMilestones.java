package com.jlgg.search;

import java.util.Arrays;

public class RevenueMilestones {
    public static int[] getMilestoneDays(int[] revenues, int[] milestones) {
        int[] results = new int[milestones.length];
        int day = 1;
        int accRevenue = 0;
        for (int i = 0; i < revenues.length; i++) {
            accRevenue += revenues[i];
            for (int j = 0; j < milestones.length; j++) {
                int milestone = milestones[j];
                if (milestone > 0 && accRevenue >= milestone) {
                    results[j] = day;
                    milestones[j] = -1;
                }
            }
            day++;
        }
        return results;
    }

    public static void main(String[] args) {
        int revenues_2[] = {700, 800, 600, 400, 600, 700};
        int milestones_2[] = {3100, 2200, 800, 2100, 1000};
        System.out.println(Arrays.toString(getMilestoneDays(revenues_2, milestones_2)));
    }
}
