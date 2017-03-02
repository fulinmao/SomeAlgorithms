package com.fulin.offer.problem26;

import com.fulin.utils.ComplexListNode;

/**
 * 复杂链表的复制
 *
 * 请实现一个函数copyComplexList 复制一个复杂链表
 * @author mfl4482
 *
 */
public class CopyComplexList {

    public static void main(String[] args) {
// TODO Auto-generated method stub

        ComplexListNode head = new ComplexListNode(1);
        head.next = new ComplexListNode(2);
        head.next.next = new ComplexListNode(3);
        head.next.next.next = new ComplexListNode(4);
        head.next.next.next.next = new ComplexListNode(5);

        head.other = head.next.next;
        head.next.next.next.other = head.next;
        head.next.other = head.next.next.next.next;

        ComplexListNode head1 = head;
        while(head1 != null){
            System.out.print(head1.val);
            head1 = head1.next;
        }
        System.out.println();
        ComplexListNode result = copyComplexList(head);
        while(result != null){
            System.out.print(result.val);
            result = result.next;
        }
        System.out.println();

        head1 = head;
        while(head1 != null){
            System.out.print(head1.val);
            head1 = head1.next;
        }
        System.out.println();
    }

    public static ComplexListNode copyComplexList(ComplexListNode head){
        ComplexListNode result = new ComplexListNode(-1);
        if(head == null){
            return null;
        }
        ComplexListNode pNode = head;
        while(pNode != null){
            ComplexListNode pCloneNode = new ComplexListNode(pNode.val);

            pCloneNode.next = pNode.next;
            pNode.next = pCloneNode;

            pNode = pCloneNode.next;
        }

        pNode = head;
        while(pNode.next.next != null){
            if(pNode.other != null){
                pNode.next.other = pNode.other.next;
            }

            pNode = pNode.next.next;
        }

        pNode = head;
        result.next = pNode.next;
        ComplexListNode pCloneNode = result.next;
        while(pNode.next.next != null){
            pNode.next = pCloneNode.next;
            pNode = pNode.next;

            pCloneNode.next = pNode.next;
            pCloneNode = pCloneNode.next;
        }
        pNode.next = null;
        pCloneNode.next = null;

        return result.next;
    }
}