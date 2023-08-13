package com.spooky.learnbay.tree;

import com.spooky.datastructure.Queue;

public class BinaryTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }

    public void printBreadthFirst(TreeNode root) {
        Queue<TreeNode> queue = new Queue<>();
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.dequeue();
            System.out.print(node.val + " ");
            if (node.left != null) {
                queue.enqueue(node.left);
            }
            if (node.right != null) {
                queue.enqueue(node.right);
            }
        }
    }

    public void printNewLvlInNewLine(TreeNode root) {
        Queue<TreeNode> queue = new Queue<>();
        queue.enqueue(root);
        queue.enqueue(null);

        while (!queue.isEmpty()) {
            TreeNode node = queue.dequeue();
            if (node == null && queue.isEmpty()) {
                break;
            }
            if (node == null) {
                System.out.println();
                queue.enqueue(null);
                continue;
            }
            System.out.print(node.val + " ");
            if (node.left != null) {
                queue.enqueue(node.left);
            }
            if (node.right != null) {
                queue.enqueue(node.right);
            }
        }
    }

    public static void main(String[] args) {
//                         44
//                13                 74
//            4        29        45       88
        TreeNode root = new TreeNode(44);
        root.left = new TreeNode(13);
        root.right = new TreeNode(74);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(29);
        root.right.left = new TreeNode(45);
        root.right.right = new TreeNode(88);

        BinaryTree tree = new BinaryTree();
        tree.printNewLvlInNewLine(root);
    }
}
