package com.fulin.offer.problem14;



/**
 * 输入一个整数数组 ，实现一个函数调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有偶数位于数组的后半部分
 *
 * @author mfl4482
 *
 */
public class ReorderArray {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {1,2,3,4,5};
        reorderArray(nums);
        for(int i=0;i<nums.length ;i++){
            System.out.println(nums[i]);
        }
    }

    public static void reorderArray(int[] nums){
        if(nums == null || nums.length <= 1){
            return ;
        }

        int length = nums.length;
        int start = 0;
        int end = length - 1;

        while(start <= end){
            while((nums[start] & 1) == 1){
                start ++;
            }

            while((nums[end] & 1) != 1){
                end --;
            }

            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start ++;
            end --;
        }
    }
}