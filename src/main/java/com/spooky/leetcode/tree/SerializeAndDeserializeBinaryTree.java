package com.spooky.leetcode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SerializeAndDeserializeBinaryTree {

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

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    public void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("N,");
            return;
        }
        sb.append(root.val).append(",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        String[] chars = data.split(",");
        return deserialize(new ArrayList<>(Arrays.asList(chars)));
    }

    public TreeNode deserialize(List<String> chars) {

        String c = chars.remove(0);
        if (c.equalsIgnoreCase("N")) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.parseInt(c));
            node.left = deserialize(chars);
            node.right = deserialize(chars);
            return node;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        SerializeAndDeserializeBinaryTree binaryTree = new SerializeAndDeserializeBinaryTree();
        TreeNode deserializedRoot = binaryTree.deserialize(binaryTree.serialize(root));
        System.out.println(deserializedRoot);
    }
}
