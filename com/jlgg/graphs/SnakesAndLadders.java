package com.jlgg.graphs;

import java.io.*;
import java.util.*;


public class SnakesAndLadders {

    private static Map<Integer, Integer> laddersMap;
    private static Map<Integer, Integer> snakesMap;

    public static int printNumberDice() {
        // Queue for discovered vertices
        Queue<Integer> queue = new LinkedList<>();
        // Map for visited vertices {vertex: #rolls}
        Map<Integer, Integer> visited = new HashMap<>();
        // Mark first vertex as visited and Enqueue it
        visited.put(1, 0);
        queue.add(1);

        while (!queue.isEmpty()) {
            int vertex = queue.remove();
            // Return # of rolls needed to get to 100
            if (vertex == 100) {
                return visited.get(100);
            }
            // Roll the dice 1 to 6
            for (int i = 1; i <= 6; i++) {
                // next position
                int nextPos = vertex + i;
                // Check if next position has a ladder or a snake,
                // if it does update position of future vertex
                if (laddersMap.containsKey(nextPos)) {
                    nextPos = laddersMap.get(nextPos);
                } else if (snakesMap.containsKey(nextPos)) {
                    nextPos = snakesMap.get(nextPos);
                }
                // Check if future vertex has already been visited
                if (visited.get(nextPos) == null) {
                    // add future vertex as visited and sum #rolls from current vertex
                    visited.put(nextPos, visited.get(vertex) + 1);
                    // add the future vertex to the queue
                    queue.add(nextPos);
                } else if (visited.get(nextPos) > visited.get(vertex) + 1 ) {
                    // if future vertex has more #rolls than current vertex # rolls + 1
                    // update future vertex with less # of rolls
                    visited.put(nextPos, visited.get(vertex + 1));
                }
            }
        }

        return -1;
    }

    static void collectMaps(int[][] ladders, int[][] snakes) {
        // Add the ladders
        laddersMap = new HashMap<>();
        for (int i = 0; i < ladders.length; i++) {
            laddersMap.put(ladders[i][0], ladders[i][1]);
        }
        // Add the snakes
        snakesMap = new HashMap<>();
        for (int i = 0; i < snakes.length; i++) {
            snakesMap.put(snakes[i][0], snakes[i][1]);
        }
    }

    public static void main(String[] args) throws IOException {
        int[][] ladders = {{2, 100}, {42, 68}, {12, 98}};
        int[][] snakes = {{95, 13}, {97, 25}, {93, 37}, {79, 27}, {75, 19}, {49, 47}, {67, 17}};

        collectMaps(ladders, snakes);
        System.out.println(printNumberDice());
    }
}

