package com.spooky.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {

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

    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        // use BFS, get all the nodes from the lvl and calculate the avg
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int lvlSize = queue.size();
            double lvlSum = 0;

            for (int i = 0; i < lvlSize; i++) {
                TreeNode node = queue.poll();
                lvlSum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            double avg = lvlSum / lvlSize;
            res.add(avg);
        }

        return res;
    }
}
