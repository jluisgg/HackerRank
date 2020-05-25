package com.jlgg.trees;

import java.util.PriorityQueue;
import java.util.Scanner;

public class QHeap1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int query = Integer.parseInt(scanner.nextLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        while (query > 0) {
            String[] line = scanner.nextLine().split(" ");
            switch (Integer.parseInt(line[0])) {
                case 1:
                    minHeap.add(Integer.parseInt(line[1]));
                    break;
                case 2:
                    minHeap.remove(Integer.parseInt(line[1]));
                    break;
                case 3:
                    System.out.println(minHeap.peek());
                    break;
            }
            query--;
        }

    }
}
