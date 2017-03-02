package com.fulin.offer.problem25;

import java.util.ArrayList;
import java.util.List;

import com.fulin.utils.TreeNode;

/**
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径
 *
 * 从根节点开始往下一直到叶节点所经过的节点形成路径
 *
 * @author mfl4482
 *
 */
public class PathInTree {

    public static void main(String[] args) {
        // 输出 【10,5,7】
        //    【10,12】
        //	TreeNode tree = new TreeNode(10);
        //	tree.left = new TreeNode(5);
        //	tree.right = new TreeNode(12);
        //
        //	tree.left.left = new TreeNode(4);
        //	tree.left.right = new TreeNode(7);

        // 输出 【5,4,11,2】
        //	      【5,8,4,5】
        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(4);
        tree.right = new TreeNode(8);

        tree.left.left = new TreeNode(11);

        tree.right.left = new TreeNode(13);
        tree.right.right = new TreeNode(4);

        tree.left.left.left = new TreeNode(7);
        tree.left.left.right = new TreeNode(2);

        tree.right.right.left = new TreeNode(5);
        tree.right.right.right = new TreeNode(1);

        int target = 22;

        List<List<Integer>> result = pathInTree(tree, target);
        for(List<Integer> list : result){
            System.out.println(list);
        }

    }

    public static List<List<Integer>> pathInTree(TreeNode tree , int target){
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(tree == null){
            return list;
        }

        if(tree.left== null && tree.right == null){
            if(target == tree.val){
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(tree.val);
                list.add(temp);
            }
            return list;
        }
        //查看 左子树是否存在满足条件的 list
        if(tree.left != null && (target - tree.val > 0)){
            List<List<Integer>> temp = pathInTree(tree.left , target - tree.val);
            if(temp!= null && temp.size() >0){
                for(List<Integer> t :temp){
                    List<Integer> newList = new ArrayList<Integer>();
                    newList.add(tree.val);
                    newList.addAll(t);
                    list.add(newList);
                }
            }
        }

        //查看右子树是否存在满足条件的 list
        if(tree.right != null && (target - tree.val > 0)){
            List<List<Integer>> temp = pathInTree(tree.right , target - tree.val);
            if(temp!= null && temp.size() >0){
                for(List<Integer> t :temp){
                    List<Integer> newList = new ArrayList<Integer>();
                    newList.add(tree.val);
                    newList.addAll(t);
                    list.add(newList);
                }
            }
        }

        return list;

    }


}