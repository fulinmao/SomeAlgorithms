package com.fulin.offer.problem37;

import com.fulin.utils.ListNode;

public class FirstCommonNodesInLists {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        ListNode temp = new ListNode(3);
        temp.next = new ListNode(6);
        temp.next.next = new ListNode(7);
        list1.next = temp;

        ListNode list2 = new ListNode(4);
        list2.next = new ListNode(5);
        list2.next.next = temp;

        ListNode result = firstCommonNode(list1, list2);

        if(result == temp){
            System.out.println("OK");
        }
    }


    /**
     * 首先计算出两个链表的长度，两个链表的指针 分辨指向链表的头部
     * 然后 将较长的链表的指向 往后移动，保证 两个指针到链表的尾部 数目相同
     * 最后找到两个指针指向相同的节点
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode firstCommonNode(ListNode list1 , ListNode list2){
        ListNode result = null;

        if(list1 == null || list2 == null){
            return result;
        }

        int list1Size = 0;
        int list2Size = 0;
        ListNode head1 = list1;
        ListNode head2 = list2;

        while(head1 != null){
            list1Size ++;
            head1 = head1.next;
        }

        while(head2 != null){
            list2Size ++;
            head2 = head2.next;
        }
        head1 = list1;
        head2 = list2;
        if(list1Size > list2Size){
            int gap = list1Size - list2Size;
            while(gap > 0){
                head1 = head1.next;
                gap --;
            }
        }else{
            int gap = list2Size - list1Size;
            while(gap > 0){
                head2 = head2.next;
                gap --;
            }
        }

        while(head1 != head2){
            head1 = head1.next;
            head2 = head2.next;
        }
        result = head1;
        return result;
    }
}