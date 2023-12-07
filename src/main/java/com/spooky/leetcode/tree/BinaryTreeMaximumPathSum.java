package com.spooky.leetcode.tree;

public class BinaryTreeMaximumPathSum {

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

    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];

        // there can be only root with -ve value (in this case it will return 0) so take min value
        max[0] = Integer.MIN_VALUE;
        maxPathSum(root, max);

        return max[0];
    }

    public int maxPathSum(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }

        int leftMaxPathSum = Math.max(0, maxPathSum(root.left, max));
        int rightMaxPathSum = Math.max(0, maxPathSum(root.right, max));

        // update the res considering the left & right path from the current node
        max[0] = Math.max(max[0], leftMaxPathSum + rightMaxPathSum + root.val);

        // while returning only consider the max of left & right path plus current node
        return Math.max(leftMaxPathSum, rightMaxPathSum) + root.val;
    }

    public static void main(String[] args) {

    }
}
