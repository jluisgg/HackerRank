package com.jlgg.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListSort {

    static int[] sortArrayDesc(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        Collections.sort(list, Collections.reverseOrder());
        for(int i=0; i< arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] elements = {6, 3, 5, 8, 2, 1};
        Arrays.sort(elements);
        System.out.println(Arrays.toString(elements));
        int[] elements2 = {6, 3, 5, 8, 2, 1};
        System.out.println(Arrays.toString(sortArrayDesc(elements2)));
    }
}
