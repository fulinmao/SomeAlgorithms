package com.fulin.offer.problem39;

import com.fulin.utils.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by fulin on 17-3-13.
 */
public class TreeDepthTest {
    @Test
    public void treeDepth() throws Exception {

        //case 1 : 普通的而茶树
        TreeNode tree = new TreeNode(1);

        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);

        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);

        tree.right.right = new TreeNode(6);

        tree.left.right.left = new TreeNode(7);

        int result = TreeDepth.treeDepth(tree);
        if(result != 4){
            fail("case 1 : method failed");
        }

        // case 2: 只有左子树
        tree = new TreeNode(5);
        tree.left = new TreeNode(4);
        tree.left.left = new TreeNode(3);
        tree.left.left.left = new TreeNode(2);
        tree.left.left.left.left = new TreeNode(1);

        result = TreeDepth.treeDepth(tree);
        if(result != 5){
            fail("case 2 :method failed");
        }

        //case 3: 只有右子树
        tree = new TreeNode(5);
        tree.right = new TreeNode(4);
        tree.right.right = new TreeNode(3);
        tree.right.right.right = new TreeNode(2);
        tree.right.right.right.right = new TreeNode(1);
        result = TreeDepth.treeDepth(tree);
        if(result != 5){
            fail("case 3 :method failed");
        }



        //case 4: 二叉树只有一个节点
        tree = new TreeNode(4);
        result = TreeDepth.treeDepth(tree);
        if(result != 1){
            fail("case 4 : method failed");
        }

        //case 5：二叉树的头结点为null
        tree = null;
        result = TreeDepth.treeDepth(tree);
        if(result != 0){
            fail("case 5 : method failed");
        }
    }

}