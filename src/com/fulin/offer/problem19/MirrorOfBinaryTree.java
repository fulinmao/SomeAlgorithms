package com.fulin.offer.problem19;

import com.fulin.utils.TreeNode;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像
 */
public class MirrorOfBinaryTree {

    public static void main(String[] args) {
        TreeNode A = new TreeNode(8);
        A.left = new TreeNode(6);
        A.right = new TreeNode(10);
        A.left.left = new TreeNode(5);
        A.left.right = new TreeNode(7);

        A.right.left = new TreeNode(9);
        A.right.right = new TreeNode(11);

        System.out.println(A.val);
        System.out.println(A.left.val);
        System.out.println(A.right.val);

        System.out.println(A.left.left.val);
        System.out.println(A.left.right.val);

        System.out.println(A.right.left.val);
        System.out.println(A.right.right.val);

        TreeNode result = mirrorOfBinaryTree(A);

        System.out.println(result.val);
        System.out.println(result.left.val);
        System.out.println(result.right.val);

        System.out.println(result.left.left.val);
        System.out.println(result.left.right.val);

        System.out.println(result.right.left.val);
        System.out.println(result.right.right.val);
    }


    public static TreeNode mirrorOfBinaryTree(TreeNode tree){

        if(tree == null){
            return null;
        }
        TreeNode result  = new TreeNode(tree.val);

        if(tree.left == null && tree.right == null){
            return result;
        }
        if(tree.right != null){
            result.left = mirrorOfBinaryTree(tree.right);

        }
        if(tree.left != null){
            result.right = mirrorOfBinaryTree(tree.left);
        }
        return result;
    }
}
