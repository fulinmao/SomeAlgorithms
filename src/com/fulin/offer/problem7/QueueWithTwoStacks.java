package com.fulin.offer.problem7;

import java.util.Stack;

/**
 * 用两个栈实现一个队列
 * 队列的声明如下：实现两个函数appendTail和deleteHead,
 * appendTail：完成在队列尾部插入结点
 * deleteHead：在队列头部删除结点的功能
 * @author mfl4482
 *
 */
public class QueueWithTwoStacks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue queue = new Queue();
		queue.appendTail(1);
		queue.appendTail(2);
		queue.appendTail(3);
		System.out.println(queue.deleteHead());
		queue.appendTail(4);
		System.out.println(queue.deleteHead());
		System.out.println(queue.deleteHead());
		System.out.println(queue.deleteHead());
	}
}

class Queue {
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> stackReverse = new Stack<Integer>();

	public Queue(){
		stack = new Stack<Integer>();
		stackReverse = new Stack<Integer>();
	}

	public void appendTail(int value){
		stack.add(value);
	}

	public int deleteHead(){
		int result = -1;

		if(stackReverse.isEmpty() && stack.isEmpty()){
			return result;
		}
		if(stackReverse.isEmpty()){
			while(!stack.isEmpty()){
				int value = stack.pop();
				stackReverse.add(value);
			}
		}
		result = stackReverse.pop();

//		while(!stackReverse.isEmpty()){
//			int value = stack.pop();
//			stack.add(value);
//		}
		return result;
	}

}