package com.spooky.datastructure;

public class BinarySearchTree {

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

    private TreeNode root;

    public void add(int val) {
        TreeNode node = new TreeNode(val);

        if (root == null) {
            root = node;
            return;
        }
        TreeNode current = root;
        while (true) {
            if (val < current.val) {
                if (current.left == null) {
                    current.left = node;
                    return;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = node;
                    return;
                }
                current = current.right;
            }
        }
    }

    public void addRec(int val) {
        root = addRec(val, root);
    }

    public TreeNode addRec(int val, TreeNode node) {
        if (node == null) {
            return new TreeNode(val);
        }
        if (val < node.val) {
            node.left = addRec(val, node.left);
        } else {
            node.right = addRec(val, node.right);
        }
        return node;
    }

    public boolean search(int val) {
        return search(val, root);
    }

    public boolean search(int val, TreeNode node) {
        if (node == null) {
            return false;
        }
        if (val == node.val) {
            return true;
        }
        if (val < node.val) {
            return search(val, node.left);
        } else {
            return search(val, node.right);
        }
    }

    public void inorderTraversal() {
        inorderTraversalRec(root);
    }

    private void inorderTraversalRec(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversalRec(root.left);
        System.out.print(root.val + " ");
        inorderTraversalRec(root.right);
    }

    public void preorderTraversal() {
        preorderTraversalRec(root);
    }

    private void preorderTraversalRec(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preorderTraversalRec(root.left);
        preorderTraversalRec(root.right);
    }

    public void postorderTraversal() {
        postorderTraversalRec(root);
    }

    private void postorderTraversalRec(TreeNode root) {
        if (root == null) {
            return;
        }
        postorderTraversalRec(root.left);
        postorderTraversalRec(root.right);
        System.out.print(root.val + " ");
    }

    public static void main(String[] args) {
//                         44
//                13                 74
//            4        29        45       88
//                                                98
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(44);
        tree.add(13);
        tree.add(74);
        tree.add(4);
        tree.add(29);
        tree.add(45);
        tree.add(88);
        tree.add(98);
        tree.inorderTraversal();
        System.out.println();
        tree.preorderTraversal();
        System.out.println();
        tree.postorderTraversal();
        System.out.println();
        System.out.println(tree.search(86));
    }
}
