package com.jlgg.graphs;


/**
 * https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
 * Unlike trees, graph may contain cycles, so we may come to the same node again.
 * To avoid processing a node more than once, we use a boolean visited array.
 * For simplicity, it is assumed that all vertices are reachable from the starting vertex
 */
public class BreadFirstSearch {

    public static void main(String[] args) {
        // Create the Graph
        Graph graph = new Graph(4);

        // Add Directed Edges
        graph.addDEdge(0, 1);
        graph.addDEdge(0, 2);
        graph.addDEdge(1, 2);
        graph.addDEdge(2, 0);
        graph.addDEdge(2,3);
        graph.addDEdge(3,3);

        // print
        graph.traverseBFS(2);
    }

}
