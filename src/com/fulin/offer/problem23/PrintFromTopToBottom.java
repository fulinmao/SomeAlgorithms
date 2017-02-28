package com.fulin.offer.problem23;

import com.fulin.utils.TreeNode;
import com.sun.deploy.panel.TreeRenderers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印二叉树的每一个结点 同一层的结点按照从左往右的顺序打印
 *
 * 例如
 *              8
 *      6           10
 *  5       7   9       11
 *
 *  输出：
 *      8   6   10  5   7   9   11
 * Created by fulin on 17-2-28.
 */
public class PrintFromTopToBottom {

    public static void main(String[] args){
        TreeNode tree = new TreeNode(8);
        tree.left = new TreeNode(6);
        tree.right = new TreeNode(10);

        tree.left.left = new TreeNode(5);
        tree.left.right = new TreeNode(7);

        tree.right.left = new TreeNode(9);
        tree.right.right = new TreeNode(11);
        printFromTopToBottom(tree);

    }

    public static void printFromTopToBottom(TreeNode tree){
        if(tree == null){
            return;
        }

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(tree);
        while(queue != null && queue.size()>0){

            TreeNode temp = queue.peek();
            if(temp.left != null){
                queue.offer(temp.left);
            }

            if(temp.right != null){
                queue.offer(temp.right);
            }
            temp = queue.poll();
            printNumber(temp);
        }


    }

    private static void printNumber(TreeNode tree){
        if(tree == null){
            return ;
        }
        System.out.print(tree.val);
        System.out.print("\t");
    }
}
