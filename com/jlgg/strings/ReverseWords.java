package com.jlgg.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseWords {

    private static List<String> wList = new ArrayList<>();

    public static void textToList(String text) {
        String[] wArr = text.split("\\.");
        Collections.addAll(wList, wArr);
    }

    public static void displayOutput() {
        StringBuffer sb = new StringBuffer();
        int index = 0;
        for (String word : wList) {
            sb.append(word);
            if (index < wList.size() - 1) {
                sb.append(".");
            }
            index++;
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        String text = "i.like.this.program.very.much";
        // textToList
        textToList(text);
        // reverseList
        Collections.reverse(wList);
        // displayOutput
        displayOutput();
    }
}
