package com.fulin.offer.problem17;

import com.fulin.utils.ListNode;

/**
 * 输入两个递增排序的链表，合并这两个链表并是新链表中的节点 依然是按照递增排序的
 *
 * 例如链表1:1->3->5->7
 *    链表2:2->4->6->8
 *
 *    输出：1->2->3->4->5->6->7->8
 *
 * @author mfl4482
 *
 */
public class MergeSortedLists {

    public static void main(String[] args) {



//	ListNode list1 = new ListNode(1);
//	list1.next = new ListNode(3);
//	list1.next.next = new ListNode(5);
//	list1.next.next.next = new ListNode(7);
//	ListNode list2 = new ListNode(2);
//	list2.next = new ListNode(4);
//	list2.next.next = new ListNode(6);
//	list2.next.next.next = new ListNode(8);
        ListNode list1 = null;
        ListNode list2 = new ListNode(1);
        ListNode result = mergetSortedList(list1, list2);
        ListNode.printListNode(result);

    }

    public static ListNode mergetSortedList(ListNode list1,ListNode list2){
        ListNode result = null;
        if(list1 == null && list2 == null){
            return result;
        }

        if(list1 == null){
            return list2;
        }

        if(list2 == null){
            return list1;
        }
        ListNode list1Index = list1;
        ListNode list2Index = list2;

        result = new ListNode(-1);
        ListNode resultIndex = result;
        while(list1Index != null && list2Index != null){
            if(list1Index.val < list2Index.val){
                resultIndex.next = list1Index;
                list1Index = list1Index.next;
            }else{
                resultIndex.next = list2Index;
                list2Index  = list2Index.next;
            }
            resultIndex = resultIndex.next;

        }

        if(list1Index == null){
            while(list2Index != null){
                resultIndex = list2Index;
                list2Index = list2Index.next;
                resultIndex = resultIndex.next;
            }
        }

        if(list2Index == null){
            while(list1Index != null){
                resultIndex = list1Index;
                list1Index = list1Index.next;
                resultIndex = resultIndex.next;
            }
        }

        return result.next;
    }

}