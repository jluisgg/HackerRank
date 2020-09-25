package com.jlgg.sort;

import java.util.Arrays;

public class ActivityNotification {

    /**
     * If the amount spent by a client on a particular day is greater than or equal to the client's median
     * spending for a trailing number of days, they send the client a notification about potential fraud.
     * The bank doesn't send the client any notifications until they have at least that trailing number of
     * prior days' transaction data.
     */
    static int activityNotifications(int[] expenditure, int d) {
        int notifications = 0;
        for (int i = 0; i < expenditure.length; i++) {
            // do not notify until d + 1
            if (i >= d) {
                // calculate median of last d days
                int[] tempEx = Arrays.copyOfRange(expenditure, i - d, i);
                Arrays.sort(tempEx);
                double median = calcMedian(tempEx);
                // Notify
                if (expenditure[i] >= 2 * median) {
                    notifications++;
                }
            }
        }
        return notifications;
    }

    static double calcMedian(int[] arr) {
        int n = arr.length / 2;
        if (arr.length % 2 == 0) {
            return (double) (arr[n] + arr[n - 1]) / 2;
        } else {
            return arr[n];
        }
    }

    public static void main(String[] args) {
        int[] expenditure = {1, 2, 3, 4, 4};
        System.out.println(activityNotifications(expenditure, 4));
    }
}
