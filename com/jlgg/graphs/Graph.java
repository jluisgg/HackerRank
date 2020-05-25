package com.jlgg.graphs;

import java.util.*;

/**
 * https://www.geeksforgeeks.org/graph-and-its-representations/
 * Graph is a data structure that consists of the following components:
 * 1. A finite set of vertices also called as nodes
 * 2. A finite set of ordered pair of the form (u,v) called edge. The pair is ordered because (u,v)
 * is not same as (v,u) in case of a directed graph. The pair of the form (u,v) indicates that there is
 * an edge from vertex u to vertex v. The edges may contain weight/value/cost
 */
public class Graph {

    // Number of vertices or nodes
    private int V;

    /**
     * Adjacency List: An array of lists is used. Size of the array is equal to the number of vertices.
     * An entry arr[i] represents the list of vertices adjacent to the ith vertex.
     */
    private List<ArrayList<Integer>> adjList;

    /**
     * Creates and initializes the adjacency list
     */
    public Graph(int v) {
        this.V = v;
        adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(i, new ArrayList<>());
        }
    }

    /**
     * Adds an edge in an undirected graph
     */
    public void addUEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    /**
     * Adds an edge in an directed graph
     */
    public void addDEdge(int u, int v) {
        adjList.get(u).add(v);
    }

    /**
     * Prints the adjacency list
     */
    public void print() {
        for (int i = 0; i < adjList.size(); i++) {
            System.out.println("Adjacency list of vertex: " + i);
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(" -> " + adjList.get(i).get(j));
            }
            System.out.println();
        }
    }

    /**
     * https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
     * Unlike trees, graph may contain cycles, so we may come to the same node again.
     * To avoid processing a node more than once, we use a boolean visited array.
     * For simplicity, it is assumed that all vertices are reachable from the starting vertex
     * v = starting vertex (source)
     */
    public void traverseBFS(int v) {
        // By default all vertices are initialized as not visited (false)
        boolean[] visited = new boolean[this.V];
        // Create a Queue for BFS
        Queue<Integer> queue = new LinkedList<>();
        // Mark the current node as visited and enqueued
        visited[v] = true;
        queue.add(v);
        // Traverse
        while(!queue.isEmpty()) {
            // Dequeue a vertex and print it
            int vertex = queue.remove();
            System.out.print(vertex + " ");
            // Get all adjacent vertices of the removed vertex
            // if adjacent has not been visited, then mark it as visited and enqueued
            Iterator<Integer> ilist = adjList.get(vertex).iterator();
            while(ilist.hasNext()) {
                int next = ilist.next();
                if(!visited[next]){
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }

    public static void main(String[] args) {
        // Create the Graph
        Graph graph = new Graph(5);

        // Adding edges
        graph.addUEdge(0, 1);
        graph.addUEdge(0, 4);
        graph.addUEdge(1, 4);
        graph.addUEdge(1, 3);
        graph.addUEdge(1, 2);
        graph.addUEdge(2, 3);
        graph.addUEdge(3, 4);

        // Print the Graph
        graph.print();

        // BFS
        System.out.println("BFS traversal: " );
        graph.traverseBFS(3);
    }
}
