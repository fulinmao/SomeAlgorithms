package com.fulin.offer.problem15;

import com.fulin.utils.ListNode;

/**
 * 输入一个链表，输出该链表中倒数第K个结点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾结点是倒数第一个结点。
 *
 * 例如，一个链表有6个结点，从头结点开始它的值依次为1,2,3,4,5,6 这个链表的倒数第三个结点是值为4的结点
 * Created by fulin on 17-2-22.
 */
public class KthNodeFromEnd {

    public static void main(String[] args){

    }

    public static ListNode findKthNodeFromEnd(ListNode head,int k){
        ListNode result = null;
        if(k<=0){
            return result;
        }
        if(head == null){
            return result;
        }

        ListNode fastNode = head;
        ListNode slowNode = head;
        int count = 0;

        while(fastNode != null && count < k){
            count ++;
            fastNode  = fastNode.next;
        }
        while(fastNode != null){
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        if(count <= k){
            return  result;
        }
        result = slowNode;
        return result;
    }
}
