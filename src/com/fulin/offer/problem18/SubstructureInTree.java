package com.fulin.offer.problem18;

import com.fulin.utils.TreeNode;

/**
 * 输入两颗二叉树A和B，判断B是不是A的子结构
 *
 * @author mfl4482
 *
 */
public class SubstructureInTree {

    public static void main(String[] args) {
// TODO Auto-generated method stub
        TreeNode A = new TreeNode(8);
        A.left = new TreeNode(8);
        A.rigth = new TreeNode(7);
        A.left.left = new TreeNode(9);
        A.left.rigth = new TreeNode(2);

        A.left.rigth.left = new TreeNode(4);
        A.left.rigth.rigth = new TreeNode(4);
        TreeNode B = new TreeNode(8);
        B.left = new TreeNode(9);
        B.rigth = new TreeNode(3);

        boolean result = subStructureInTree(A, B);
        System.out.println(result);
    }

    /**
     * 判断B树 是否为A树的子结构
     * @param ATree
     * @param BTree
     * @return
     */
    public static boolean subStructureInTree(TreeNode ATree, TreeNode BTree) {
        if (BTree == null) {
            return true;
        }
        if (ATree == null) {
            return false;
        }

        boolean result = false;
        if (ATree.val == BTree.val) {
            result = doesTree1HaveTree2(ATree, BTree);
        }
        if (!result) {
            result = subStructureInTree(ATree.left, BTree);
        }

        if (!result) {
            result = subStructureInTree(ATree.rigth, BTree);
        }

        return result;
    }

    /**
     * 判断 两个树 是否完全相同
     * @param ATree
     * @param BTree
     * @return
     */
    private static boolean doesTree1HaveTree2(TreeNode ATree , TreeNode BTree){
        if(BTree == null){
            return true;
        }
        if(ATree == null){
            return false;
        }

        boolean result = (ATree.val == BTree.val)
                && (doesTree1HaveTree2(ATree.left, BTree.left))
                && (doesTree1HaveTree2(ATree.rigth, BTree.rigth));
        return result;
    }
}