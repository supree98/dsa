package com.spooky.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {

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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightSideView(root, 0, result);
        return result;
    }

    public void rightSideView(TreeNode root, int lvl, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (result.size() == lvl) {
            result.add(root.val);
        }
        rightSideView(root.right, lvl + 1, result);
        rightSideView(root.left, lvl + 1, result);
    }
}
