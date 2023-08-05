package com.spooky.leetcode.tree;

public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSum(root, targetSum, 0);
    }

    private boolean hasPathSum(TreeNode node, int targetSum, int currentSum) {
        if (node == null) {
            return false;
        }
        currentSum += node.val;
        if (node.left == null && node.right == null && currentSum == targetSum) {
            return true;
        }

        boolean hasPathSumLeft = hasPathSum(node.left, targetSum, currentSum);
        boolean hasPathSumRight = hasPathSum(node.right, targetSum, currentSum);

        if (hasPathSumLeft || hasPathSumRight) {
            return true;
        }

        return false;
    }

    public class TreeNode {
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
}
