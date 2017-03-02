package com.fulin.offer.problem27;

import com.fulin.utils.TreeNode;

/**
 * 输入一个二叉搜索树，将该二叉树转换成一个排序的双向链表
 *
 * 要求：不能创建任何新的结点，只能调整树中的结点指针的指向
 * 例如
 *              10
 *      6              14
 *  4       8       12      16
 *
 *  输出： 4<=>6<=>8<=>10<=>12<=>14<=>16
 *
 * Created by fulin on 17-3-2.
 */
public class ConverBinarySearchTree {

    public static void main(String[] args){
        TreeNode tree = new TreeNode(10);
        tree.left = new TreeNode(6);
        tree.right = new TreeNode(14);

        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(8);

        tree.right.left = new TreeNode(12);
        tree.right.left = new TreeNode(16);

        TreeNode result = convertBinarySearchTree(tree);
        while(result != null){
            System.out.println(result.val);
            result = result.right;
        }

    }

    public static TreeNode convertBinarySearchTree(TreeNode tree){
        TreeNode result = null;
        if(tree == null){
            return result;
        }
        // convert 返回链表中的最后一个结点
        result = convert(tree,result);

        while(result.left != null){
            result = result.left;
        }
        return result;
    }

    private static TreeNode convert(TreeNode tree,TreeNode lastNodeInList){
        if(tree == null){
            return null;
        }
        TreeNode current = tree;
        if(tree.left != null){
            lastNodeInList = convert(tree.left,lastNodeInList);
        }
        current.left = lastNodeInList;
        if(lastNodeInList != null){
            lastNodeInList.right = tree;
        }
        lastNodeInList = current;

        if(tree.right != null){
            lastNodeInList = convert(tree.right,lastNodeInList);
        }
        return lastNodeInList;
    }
}
