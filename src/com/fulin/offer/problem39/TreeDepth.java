package com.fulin.offer.problem39;

import com.fulin.utils.TreeNode;

/**
 * 输入一一棵二叉树的跟节点，请该二叉树的深度
 *
 * Created by fulin on 17-3-13.
 */
public class TreeDepth {

    public static void main(String[] args){
        TreeNode tree = new TreeNode(1);

        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);

        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);

        tree.right.right = new TreeNode(6);

        tree.left.right.left = new TreeNode(7);

        int result = treeDepth(tree);
        System.out.print(result);
    }

    public static int treeDepth(TreeNode tree){
        int result = 0;
        if(tree == null){
            return result;
        }

        int left = treeDepth(tree.left);
        int right = treeDepth(tree.right);
        if(left > right){
            result = left + 1;
        }else {
            result = right + 1;
        }
        return result;
    }
}
