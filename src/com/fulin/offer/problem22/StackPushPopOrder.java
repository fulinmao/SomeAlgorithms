package com.fulin.offer.problem22;

import java.util.Arrays;
import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序，
 * 假设： 压入栈的所有数字均不相等
 *
 * 例如：	序列1：1	2	3	4	5
 *	序列2：4	5	3	2	1
 * 	序列3：4	3	5	1	2
 * 输入：
 * 	序列2 是序列1的弹出序列
 *  序列3不是序列1的弹出序列
 * @author mfl4482
 *
 */
public class StackPushPopOrder {

    public static void main(String[] args) {
// TODO Auto-generated method stub
        int[] nums1 = {1,2,3,4,5};
//	int[] nums2 = {4,5,3,2,1};
        int[] nums2 = {4,3,5,1,2};
        boolean result = stackPushPopOrder(nums1, nums2);
        System.out.println(result);
    }

    public static boolean stackPushPopOrder(int[] nums1,int[] nums2){
        if(nums1 == null || nums1.length == 0){
            return nums2 == null;
        }

        if(nums1.length != nums2.length){
            return false;
        }
        boolean result = true;
        Stack<Integer> stack1 = new Stack<Integer>();

        int start = 0;
        for(int i=0;i<nums2.length ;i++){
            int number = nums2[i];
            int index = search(nums1,start,number);
            if(index != -1){
            // 需要把 指定的元素加入到栈中
                for(int j=start;j<=index;j++){
                    stack1.push(nums1[j]);
                }
                start = index + 1;
            }

            int peek = stack1.peek();

            if(peek != nums2[i]){
                result = false;
                break;
            }else{
                stack1.pop();
            }
        }

        return result;
    }

    private static int search(int[] nums1, int start, int number) {
        int index = -1;

        for(int i=start;i<nums1.length;i++){
            if(nums1[i] == number){
                index = i;
                break;
            }
        }

        return index;
    }



}