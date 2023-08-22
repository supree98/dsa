package com.spooky.leetcode.tree.bst;

public class MinimumAbsoluteDifferenceInBST {

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

    private int minDiff = Integer.MAX_VALUE;

    private TreeNode prevNode = null;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return minDiff;
    }

    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        inorder(node.left);
        if (prevNode != null) {
            minDiff = Math.min(minDiff, Math.abs(node.val - prevNode.val));
        }

        prevNode = node;
        inorder(node.right);
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        MinimumAbsoluteDifferenceInBST min = new MinimumAbsoluteDifferenceInBST();
        int minimumDifference = min.getMinimumDifference(root);
        System.out.println(minimumDifference);
    }
}
