package com.spooky.learnbay.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintNodeAndLvl {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }

    Map<Integer, List<TreeNode>> map = new HashMap<>();

    public void printNodeAndLvl(TreeNode root) {
        mapNodeAndLvl(root, 0);
        for (Map.Entry<Integer, List<TreeNode>> entry : map.entrySet()) {
            for (TreeNode node : entry.getValue()) {
                System.out.println("Lvl : " + entry.getKey() + " Val : " + node.val);
            }
        }
    }

    public void mapNodeAndLvl(TreeNode node, int lvl) {
        if (node == null) {
            return;
        }
        List<TreeNode> list;
        if (map.containsKey(lvl)) {
            list = map.get(lvl);
        } else {
            list = new ArrayList<>();
        }
        list.add(node);
        map.put(lvl, list);

        mapNodeAndLvl(node.left, lvl + 1);
        mapNodeAndLvl(node.right, lvl + 1);
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

        PrintNodeAndLvl printNodeAndLvl = new PrintNodeAndLvl();
        printNodeAndLvl.printNodeAndLvl(root);
    }

}
