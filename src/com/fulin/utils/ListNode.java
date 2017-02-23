package com.fulin.utils;

/**
 * Created by fulin on 17-2-22.
 */
public class ListNode {
    public int val;

    public ListNode next;

    public ListNode (int val){
        this.val = val;
        this.next = null;
    }

    /**
     *
     * @param head
     */
    public static void printListNode(ListNode head){
        while(head != null){
            System.out.print(head.val);
            if(head.next != null){
                System.out.print("->");
            }
        }
        System.out.println();
    }
}
