package com.fulin.offer.problem5;

import java.util.Stack;

/**
 * 输入一个链表的头结点，从尾到头打印出每一个i哦节点的值
 *
 * 例如：输入 2 -> 3 -> 5 -> 7
 *
 * 输出：7 -> 5 -> 3 -> 2
 * Created by fulin on 17-2-9.
 */
public class PrintListNodeReverse {

    public static void main(String[] args){
        ListNode list = new ListNode(2);
        list.next = new ListNode(3);
        list.next.next = new ListNode(5);
        list.next.next.next = new ListNode(7);
        list = printListNodeReverse(list);
        while(list != null){
            System.out.println(list.value);
            list = list.next;
        }
    }

    public static ListNode printListNodeReverse(ListNode list){
        if(list == null) {
            return list;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode head = list;
        while(head != null){
            stack.add(head);
            head = head.next;
        }
        head = new ListNode(-1);
        list = head;
        while(!stack.isEmpty()){
            ListNode temp = stack.pop();
            list.next = temp;
            list = list.next;
        }
        list.next = null;
        return  head.next;
    }


}

class ListNode{
    int value;
    ListNode next;

    ListNode(int value){
        this.value = value;
        this.next = null;
    }
}