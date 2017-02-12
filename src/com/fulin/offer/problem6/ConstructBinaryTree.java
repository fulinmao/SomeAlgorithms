package com.fulin.offer.problem6;

import java.util.Arrays;

/**
 * 输入某二叉树的前序和中序遍历的结果 请重建出该二叉树
 *
 * 假设输入的前序遍历和中序遍历的结果都不包含重复的数字
 *
 * 例如： 前序遍历 ：{1,2,4,7,3,5,6,8}
 * 	           中序遍历：{4,7,2,1,5,3,8,6}
 * 输出：树
 *				1
 *		2				3
 *	4				5		6
 *		7 				8
 * @author mfl4482
 *
 */
public class ConstructBinaryTree {

	public static void main(String[] args) {
		int[] preOrder = {1,2,4,7,3,5,6,8};
		int[] inOrder = {4,7,2,1,5,3,8,6};
		TreeNode head = constructBinaryTree(preOrder, inOrder);
		System.out.println(head.value);
	}

	public static TreeNode constructBinaryTree(int[] preOrder ,int[] inOrder){
		if(preOrder == null || inOrder == null){
			return null;
		}
		if(preOrder.length == 0 || inOrder.length == 0){
			return null;
		}
		if(preOrder.length != inOrder.length){
			return null;
		}
		TreeNode head = new TreeNode(-1);
		if(preOrder.length == 1){
			head = new TreeNode(preOrder[0]);
			return head;
		}
		head = new TreeNode(preOrder[0]);
		int index = search(inOrder , 0, inOrder.length - 1,preOrder[0]);
		if(index < 0){
			return null;
		}

		head.left = constructTree(preOrder,1,index,inOrder, 0,index -1);
		head.right = constructTree(preOrder,index + 1,preOrder.length -1 ,inOrder,index+ 1,inOrder.length -1);
		return head;
	}

	private static TreeNode constructTree(int[] preOrder , int start , int end ,int[] inOrder,int start1 ,int end1){
		if(start > end){
			return null;
		}
		if(start1 > end1){
			return null;
		}
		TreeNode head = new TreeNode(preOrder[start]);
		int index = search(inOrder, start1, end1, preOrder[start]);
		int length = index - start1;
		head.left = constructTree(preOrder, start +1 ,start + length , inOrder, start1, index-1);
		head.right = constructTree(preOrder, start + length +1, end, inOrder, index + 1, end1);
		return head;
	}

	/**
	 * 从数组中返回 指定元素所在的位置
	 * @param array
	 * @param start
	 * @param end
	 * @param target
	 * @return
	 */
	private static int search(int[] array ,int start ,int end ,int target){
		int index = -1;
		for(int i= start ;i<= end ;i++){
			if(target == array[i]){
				index = i;
				break;
			}
		}
		return index;
	}
}

class TreeNode {
	int value ;
	TreeNode left;
	TreeNode right;

	TreeNode(int value){
		this.value = value;
		this.left = null;
		this.right = null;
	}
}