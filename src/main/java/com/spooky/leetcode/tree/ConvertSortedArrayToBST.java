package com.spooky.leetcode.tree;

public class ConvertSortedArrayToBST {

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

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;        // NOTE: find mid in any portion of an array
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, left, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, right);

        return node;
    }

    public static void main(String[] args) {
        ConvertSortedArrayToBST convert = new ConvertSortedArrayToBST();
        TreeNode root = convert.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(root);
    }
}
