package com.spooky.leetcode.tree;

public class SumRootToLeafNumbers {

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

    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    public int sumNumbers(TreeNode root, int currentSum) {
        if (root == null) {
            return 0;
        }

        int newSum = currentSum * 10 + root.val;

        if (root.left == null && root.right == null) {
            return newSum;
        }
        int leftSum = sumNumbers(root.left, newSum);
        int rightSum = sumNumbers(root.right, newSum);
        return leftSum + rightSum;
    }
}
