package com.jlgg.trees;

import java.io.*;
import java.util.*;
// Add any extra import statements you may need here


class SubTree {
    // Tree Node
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
            val = 0;
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    class Query {
        int v;
        char c;

        Query(int v, char c) {
            this.v = v;
            this.c = c;
        }
    }

    // Add any helper functions you may need here
    static int counter = 0;
    static int qValue = 0;
    static char qChar;
    Node qNode;
    Map<Integer, Character> valueToCharMap;

    void collectMap(String s) {
        valueToCharMap = new HashMap<>();
        char[] sArr = s.toCharArray();
        for (int i = 0; i < sArr.length; i++) {
            valueToCharMap.put(i + 1, sArr[i]);
        }
    }

    void findQueryNode(Node root) {
        if (root == null) {
            return;
        }
        if (qValue == root.val) {
            qNode = root;
            return;
        }
        Iterator it = root.children.listIterator();
        while (it.hasNext()) {
            Node child = (Node) it.next();
            findQueryNode(child);
        }
    }

    // Recursive function
    void countChars(Node parent) {
        if (parent == null) {
            return;
        }

        Character pChar = valueToCharMap.get(parent.val);
        if (pChar == qChar) {
            counter++;
        }

        Iterator it = parent.children.listIterator();
        while (it.hasNext()) {
            Node child = (Node) it.next();
            countChars(child);
        }
    }

    int executeQuery(Node root, Query query) {
        qValue = query.v;
        qChar = query.c;
        findQueryNode(root);
        countChars(qNode);
        qValue = 0;
        qChar = 0;
        qNode = null;
        return counter;
    }

    int[] countOfNodes(Node root, ArrayList<Query> queries, String s) {
        int[] results = new int[queries.size()];

        // Map {value: char}
        collectMap(s);

        // iterate each query
        Iterator it = queries.listIterator();
        int qc = 0;
        while (it.hasNext()) {
            executeQuery(root, (Query) it.next());
            results[qc] = counter;
            counter = 0;
            qc++;
        }

        return results;
    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;

    void check(int[] expected, int[] output) {
        int expected_size = expected.length;
        int output_size = output.length;
        boolean result = true;
        if (expected_size != output_size) {
            result = false;
        }
        for (int i = 0; i < Math.min(expected_size, output_size); i++) {
            result &= (output[i] == expected[i]);
        }
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printIntegerArray(expected);
            System.out.print(" Your output: ");
            printIntegerArray(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printIntegerArray(int[] arr) {
        int len = arr.length;
        System.out.print("[");
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.print("]");
    }

    public void run() throws IOException {
        Scanner sc = new Scanner(System.in);

        //Testcase 1
        int n_1 = 3, q_1 = 1;
        String s_1 = "aba";
        Node root_1 = new Node(1);
        root_1.children.add(new Node(2));
        root_1.children.add(new Node(3));
        ArrayList<Query> queries_1 = new ArrayList<>();
        queries_1.add(new Query(1, 'a'));
        int[] output_1 = countOfNodes(root_1, queries_1, s_1);
        int[] expected_1 = {2};
        check(expected_1, output_1);

        // Testcase 2
        int n_2 = 7, q_2 = 3;
        String s_2 = "abaacab";
        Node root_2 = new Node(1);
        root_2.children.add(new Node(2));
        root_2.children.add(new Node(3));
        root_2.children.add(new Node(7));
        root_2.children.get(0).children.add(new Node(4));
        root_2.children.get(0).children.add(new Node(5));
        root_2.children.get(1).children.add(new Node(6));
        ArrayList<Query> queries_2 = new ArrayList<>();
        queries_2.add(new Query(1, 'a'));
        queries_2.add(new Query(2, 'b'));
        queries_2.add(new Query(3, 'a'));
        int[] output_2 = countOfNodes(root_2, queries_2, s_2);
        int[] expected_2 = {4, 1, 2};
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) throws IOException {
        new SubTree().run();
    }
}