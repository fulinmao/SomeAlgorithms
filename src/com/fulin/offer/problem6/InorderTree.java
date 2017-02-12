package com.fulin.offer.problem6;

import java.util.ArrayList;
import java.util.List;

/**
 * 树的终须遍历 先左子树  然后再根节点 最后右右子树
 *
 *
 *
 * @author mfl4482
 *
 */
public class InorderTree {

	public static void main(String[] args) {
		TreeNode head = buildTreeNode();
		List<Integer> result = inOrderTree(head);
		System.out.println(result);
	}

	public static TreeNode buildTreeNode(){
		TreeNode head = new TreeNode(1);
		TreeNode right = new TreeNode(7);
		TreeNode left = new TreeNode(4);
		left.right = right;
		right = new TreeNode(2);
		right.left = left;
		head.left = right;

		//右子树
		left = new TreeNode(8);
		right = new TreeNode(6);
		right.left = left;

		left = new TreeNode(3);
		left.left = new TreeNode(5);
		left.right = right;

		head.right = left;
		return head;
	}

	public static List<Integer> inOrderTree(TreeNode head){
		List<Integer> list = new ArrayList<Integer>();
		if(head == null){
			return list;
		}
		if(head.left!= null){
			list.addAll(inOrder(head.left));
		}
		list.add(head.value);
		if(head.right != null){
			list.addAll(inOrder(head.right));
		}
		return list;
	}

	private static List<Integer> inOrder(TreeNode head){
		List<Integer> list = new ArrayList<Integer>();
		if(head == null ){
			return list;
		}
		if(head.left != null){
			list.addAll(inOrder(head.left));
		}
		list.add(head.value);
		if(head.right != null){
			list.addAll(inOrder(head.right));
		}
		return list;
	}

}