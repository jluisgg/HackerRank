package com.jlgg.recursion;

import java.util.*;

public class Cells {

    /**
     * Lessons learned:
     * Avoid IDE debug in online editor
     * if void in signature then do not include return in tail recursion
     * needed to clone an Arr to pass as arg for next recursive call
     */
    public int[] updateState(int[] states, int days) {
        int[] temp = states.clone();

        // base case
        if (days == 0) {
            return temp;
        }

        // update the states
        int leftN;
        int rightN;
        for (int i = 0; i < states.length; i++) {
            leftN = (i - 1) < 0 ? 0 : states[i - 1];
            rightN = (i + 1) > states.length - 1 ? 0 : states[i + 1];
            temp[i] = leftN == rightN ? 0 : 1;
        }

        return updateState(temp, days - 1);
    }

    /**
     * Lesson learned:
     * Iterative solution is easier
     * temp[] arr is the key to solution
     */
    public int[] updateStateIt(int[] states, int days) {
        int[] temp = new int[states.length];
        for (int i = days; i > 0; i--) {
            int leftN;
            int rightN;
            for (int j = 0; j < states.length; j++) {
                leftN = (j - 1) < 0 ? 0 : states[j - 1];
                rightN = (j + 1) > states.length - 1 ? 0 : states[j + 1];
                temp[j] = leftN == rightN ? 0 : 1;
            }
            states = temp.clone();
        }
        return states;
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<Integer> cellCompete(int[] states, int days) {
        // Sanitize input
        if (states == null || days < 0) {
            return new ArrayList<>();
        }

        // Call recursive function
        int[] resArr = updateStateIt(states, days);

        // format the output as requested
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < resArr.length; i++) {
            results.add(resArr[i]);
        }

        return results;
    }

    public static void main(String[] args) {
        Cells cells = new Cells();
        int[] states = {1, 1, 1, 0, 1, 1, 1, 1};
        int days = 2;
        System.out.println(cells.cellCompete(states, days));
    }
}
