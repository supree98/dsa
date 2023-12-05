package com.spooky.leetcode.tree.bst;

public class KthSmallestElementInABST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "val: " + val;
        }
    }

    private int count = 0;
    private int result = 0;

    // trick is to use inorder traversal
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        // before
        inorder(node.left, k);

        // MID: everytime we get to null we have reached one smallest elem, so count++
        count++;
        if (count == k) {
            result = node.val;
            return;
        }

        // after
        inorder(node.right, k);
    }

    public static void main(String[] args) {
        KthSmallestElementInABST smallestElementInABST = new KthSmallestElementInABST();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        System.out.println(smallestElementInABST.kthSmallest(root, 3));
    }

}
