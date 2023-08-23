package com.spooky.leetcode.tree.bst;

import java.util.Stack;

public class BSTIterator {

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

    private Stack<TreeNode> nodes = new Stack<>();

    private void addAllLeftNodes(TreeNode node) {
        while (node != null) {
            nodes.push(node);
            node = node.left;
        }
    }

    public BSTIterator(TreeNode root) {
        addAllLeftNodes(root);
    }

    public int next() {
        if (hasNext()) {
            TreeNode node = nodes.pop();
            if (node.right != null) {
                addAllLeftNodes(node.right);
            }
            return node.val;
        } else {
            return 0;
        }
    }

    public boolean hasNext() {
        return !nodes.isEmpty();
    }
}
