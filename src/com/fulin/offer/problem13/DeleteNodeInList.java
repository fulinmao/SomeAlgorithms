package com.fulin.offer.problem13;

import com.fulin.utils.ListNode;

/**
 * 给定单向链表的头指针和和一个节点指针 ，定义一个函数 在 O(1)的时间删除该结点，
 *
 * 前提条件：删除的节点 肯定在链表中
 * @author mfl4482
 *
 */
public class DeleteNodeInList {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public static void deleteNodeInList(ListNode head , ListNode toBeDeleted ){
        if(head == null){
            return ;
        }
        if(toBeDeleted == null){
            return ;
        }

        // case 0 : 如果链表中只有一个节点,且该节点为需要删除的节点
        if(head.next == null && toBeDeleted.next == null && head == toBeDeleted){
            head = null;
            toBeDeleted = null;
            return ;
        }

        //case 1 delete的结点为最后一个节点
        //处理方法 ：只能有顺序删除的方法 找到删除节点的前一个节点 然后将前一个节点的next 值为null;
        if(toBeDeleted.next == null){
            ListNode current = head;
            while(current.next != null){
                if(current.next == toBeDeleted){
                    current.next = null;
                    break;
                }
                current = current.next;
            }
        }

        //case 2 : 删除节点为头结点
        //
        if(head.val == toBeDeleted.val && head.next == toBeDeleted.next){
            toBeDeleted.val = toBeDeleted.next.val;
            toBeDeleted.next = toBeDeleted.next;
            head = toBeDeleted;
        }else{
            // case 3: 其他情况  存在多个节点 且删除节点 不为第一个节点  不为最后一个节点
            toBeDeleted.val = toBeDeleted.next.val;
            toBeDeleted.next = toBeDeleted.next;
        }
        return ;

    }

}