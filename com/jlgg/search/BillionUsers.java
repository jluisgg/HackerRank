package com.jlgg.search;

public class BillionUsers {
    static float BILLION = 1000000000f;

    static int getBillionUsersDay(float[] growthRates) {
        // Write your code here
        float[] results = new float[growthRates.length];
        int days = 0;
        float maxGrowth = 0;
        while(maxGrowth <= BILLION) {
            for(int i = 0; i < growthRates.length; i++) {
                float currentGrowth = (float) Math.pow((double) growthRates[i], days * 1.0);
                if(currentGrowth > maxGrowth) {
                    maxGrowth = currentGrowth;
                }
            }
            if(maxGrowth <= BILLION) {
                days++;
            }
        }

        return days;
    }

    public static void main(String[] args) {
        float[] grs = {1.1f, 1.2f, 1.3f};
        System.out.println(getBillionUsersDay(grs));
    }

}
