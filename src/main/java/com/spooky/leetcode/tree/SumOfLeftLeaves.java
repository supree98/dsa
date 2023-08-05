package com.spooky.leetcode.tree;

public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, true);
    }

    public int sumOfLeftLeaves(TreeNode node, boolean isLeftLeafChild) {
        if (node == null) {
            return 0;
        }

        int leftSum = sumOfLeftLeaves(node.left, false);
        int rightSum = sumOfLeftLeaves(node.right, true);

        if (node.left == null && node.right == null) {
            if (isLeftLeafChild) {
                return 0;
            } else {
                return node.val;
            }
        }
        return leftSum + rightSum;
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
