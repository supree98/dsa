package com.spooky.learnbay.tree;

public class MorrisTraversal {

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

    public void inorder(TreeNode root) {
        TreeNode current = root;

        while (current != null) {
            if (current.left == null) {
                System.out.print(current.val + ", ");
                current = current.right;
            } else {
                TreeNode temp = current.left;
                while (temp.right != null && temp.right != current) {
                    temp = temp.right;
                }
                if (temp.right == null) {
                    temp.right = current;
                    current = current.left;
                } else {
                    temp.right = null;
                    System.out.print(current.val + ", ");
                    current = current.right;
                }
            }
        }
    }

    public static void main(String[] args) {
//                         44
//                13                 74
//            4        29        45       88
//                                                98
        TreeNode root = new TreeNode(44);
        root.left = new TreeNode(13);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(5);
        root.left.right = new TreeNode(29);
        root.right = new TreeNode(74);
        root.right.left = new TreeNode(45);
        root.right.right = new TreeNode(88);
        root.right.right.right = new TreeNode(98);

        MorrisTraversal traversal = new MorrisTraversal();
        traversal.inorder(root);
    }
}
