package com.fulin.offer.problem37;

import com.fulin.utils.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by fulin on 17-3-9.
 */
public class FirstCommonNodesInListsTest {
    @Test
    public void firstCommonNode() throws Exception {
        // case 1:正常情况 公共节点在 链表中间
        // list1:	1	2	3	6	7
        // list2:	4	5	6	7
        // 返回节点6
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        ListNode temp = new ListNode(3);
        temp.next = new ListNode(6);
        temp.next.next = new ListNode(7);
        list1.next = temp;

        ListNode list2 = new ListNode(4);
        list2.next = new ListNode(5);
        list2.next.next = temp;

        ListNode result = FirstCommonNodesInLists.firstCommonNode(list1, list2);

        if(result != temp){
            fail("case1: method failed ");
        }

        // case 2:两个链表没有公共节点
        list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);

        list2 = new ListNode(4);
        list2.next = new ListNode(5);
        list2.next.next = new ListNode(6);
        list2.next.next.next = new ListNode(7);

        result = FirstCommonNodesInLists.firstCommonNode(list1, list2);
        if(result != null){
            fail("case2 :method failed");
        }

        // case 3: 其中一个链表为空
        list1 = null;
        list2 = new ListNode(4);
        list2.next = new ListNode(5);
        list2.next.next = new ListNode(6);
        list2.next.next.next = new ListNode(7);
        result = FirstCommonNodesInLists.firstCommonNode(list1, list2);
        if(result != null){
            fail("case3 :method failed");
        }

        list1 = new ListNode(4);
        list1.next = new ListNode(5);
        list1.next.next = new ListNode(6);
        list1.next.next.next = new ListNode(7);

        list2 = null;

        result = FirstCommonNodesInLists.firstCommonNode(list1, list2);
        if(result != null){
            fail("case3 :method failed");
        }

        // case 4: 公共节点在链表尾部
        list1 = new ListNode(4);
        list1.next = new ListNode(5);
        list1.next.next = new ListNode(6);

        temp = new ListNode(7);
        list1.next.next.next = temp;

        list2 = new ListNode(2);
        list2.next = new ListNode(10);
        list2.next.next = temp;

        result = FirstCommonNodesInLists.firstCommonNode(list1, list2);

        if(result != temp){
            fail("case 4: method failed");
        }

        // case 5: 公共节点在链表的头结点
        temp = new ListNode(4);
        temp.next = new ListNode(5);
        temp.next.next = new ListNode(6);

        list1 = temp;

        list2 = temp;

        result = FirstCommonNodesInLists.firstCommonNode(list1, list2);

        if(result != temp){
            fail("case 5: method failed");
        }
    }

}