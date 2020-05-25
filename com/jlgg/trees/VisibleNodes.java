package com.jlgg.trees;

class MyTree extends BinaryTree {

    private static int maxLevel = 0;
    private static int counter = 0;

    private void leftViewNodes(Node parent, int level) {
        if(parent == null) {
            return;
        }

        if (maxLevel < level) {
            maxLevel = level;
            counter++;
        }

        leftViewNodes(parent.getLeft(), level + 1);
        leftViewNodes(parent.getRight(), level + 1);
    }

    public int returnVisibleLeft(Node root) {
        leftViewNodes(root, 1);
        return counter;
    }
}

public class VisibleNodes {
    public static void main(String[] args) {
        int[] values = {8, 3, 10, 1, 6, 14, 4, 7, 13};

        // create Tree
        MyTree tree = new MyTree();

        // insert nodes
        Node root = new Node(values[0]);
        for(int i = 1; i < values.length; i++){
            tree.insert(root, values[i]);
        }

        // traverseLeft
        System.out.println(tree.returnVisibleLeft(root));
    }
}
