package com.spooky.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 102. Binary Tree Level Order Traversal
public class BinaryTreeLevelOrderTraversal {

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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int lvlSize = queue.size();

            List<Integer> nodes = new ArrayList<>();
            for (int i = 0; i < lvlSize; i++) {
                TreeNode node = queue.poll();
                nodes.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(nodes);
        }

        return result;
    }

    public static void main(String[] args) {
//                         44
//                13                 74
//            4        29        45       88
        TreeNode root = new TreeNode(44);
        root.left = new TreeNode(13);
        root.right = new TreeNode(74);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(29);
        root.right.left = new TreeNode(45);
        root.right.right = new TreeNode(88);

        BinaryTreeLevelOrderTraversal traversal = new BinaryTreeLevelOrderTraversal();
        traversal.levelOrder(root);
    }
}
