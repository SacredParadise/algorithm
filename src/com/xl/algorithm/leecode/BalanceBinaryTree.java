package com.xl.algorithm.leecode;

import javax.swing.tree.TreeNode;

/**
 * 第 110 号问题：平衡二叉树
 *
 * 题目描述:
 *     给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 题目解析:
 *     采取后序遍历的方式遍历二叉树的每一个结点。
 *
 *     在遍历到一个结点之前已经遍历了它的左右子树，那么只要在遍历每个结点的时候记录它的深度（某一结点的深度等于它到叶结点的路径的长度），
 *     就可以一边遍历一边判断每个结点是不是平衡的。
 */
public class BalanceBinaryTree {
    private static boolean isBalance = true;

    public static void main(String[] args) {
        TreeNode root = new TreeNode();

        System.out.println(isBalance(root));
    }


    private static boolean isBalance(TreeNode treeNode) {
        getDepth(treeNode);

        return isBalance;
    }

    private static int getDepth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int left = getDepth(treeNode.left);
        int right = getDepth(treeNode.right);

        if (Math.abs(left - right) > 1) {
            isBalance = false;
        }

        return right > left ? right + 1 : left + 1;
    }




    static class TreeNode {
        private int value;

        private TreeNode left;

        private TreeNode right;
    }


}
