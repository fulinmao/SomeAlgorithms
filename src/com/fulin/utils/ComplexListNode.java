package com.fulin.utils;

/**
 * 复杂链表结构
 * 	（1）节点值
 * 	（2）指向下一个节点的节点
 * 	（3）执行链表中任意节点的节点
 * @author mfl4482
 *
 */
public class ComplexListNode {
    public int val;
    public ComplexListNode next;
    public ComplexListNode other;

    public ComplexListNode(int val){
        this.val = val;
        this.next = null;
        this.other = null;
    }


}