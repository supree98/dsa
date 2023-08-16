package com.spooky.leetcode.tree;

public class CountCompleteTreeNodes {
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
    }

    public int countNodes(TreeNode root) {
        return countNodes(root, 0);
    }

    public int countNodes(TreeNode root, int count) {
        if (root == null) {
            return count;
        }
        count = countNodes(root.left, count);
        count = countNodes(root.right, count);
        return count + 1;
    }
}
