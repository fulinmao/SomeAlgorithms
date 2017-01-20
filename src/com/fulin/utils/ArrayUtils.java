package com.fulin.utils;

/**
 * Created by fulin on 17-1-20.
 */
public class ArrayUtils {

    public static void printArray(int[] nums){
        System.out.print("{");
        for(int i = 0;i< nums.length;i++){
            System.out.print(nums[i]);
            if(i!=nums.length - 1){
                System.out.print(",");
            }
        }
        System.out.println("}");
    }

    public static void exchangeElements(int[] nums , int index1 ,int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
