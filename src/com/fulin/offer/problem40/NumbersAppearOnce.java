package com.fulin.offer.problem40;

import java.util.ArrayList;
import java.util.List;

/**
 * 一个整型数组中除了两个数字之外，其他数字都出现了两次，
 * 请写程序找出这两个只出现一次的数字
 *
 * Created by fulin on 17-3-13.
 */
public class NumbersAppearOnce {

    public static boolean ISEXISTINARRAY = true;

    public static void main(String[] args){
        int[] nums = {2,4,3,6,3,2,5,5};
        List<Integer> result = findTwoNumberAppearOnce(nums);
        System.out.print(result);
    }

    public static int findNumbersAppearOnce(int[] nums){
        int result = 0;
        if(nums == null || nums.length == 0){
            ISEXISTINARRAY = false;
            return result ;
        }
        result = nums[0];
        for(int i = 1;i<nums.length;i++){
            result = result ^ nums[i];
        }

        // 检查查询的数字是否在数组中存在
        if( ! isExistInArray(nums,result)){
            ISEXISTINARRAY = false;
            return 0;
        }

        return  result;
    }

    public static boolean isExistInArray(int[] nums , int target){
        boolean result = false;
        if(nums == null || nums.length == 0){
            return  result;
        }
        for(int i = 0 ; i< nums.length ;i++){
            if(nums[i] == target){
                result = true;
                break;
            }
        }

        return  result;
    }


    public static List<Integer> findTwoNumberAppearOnce(int[] nums){
        List<Integer> list = new ArrayList<Integer>();

        if(nums == null || nums.length == 0){
            return  list;
        }

        int flagNumber = nums[0];
        for(int i = 1 ; i < nums.length ;i++){
            flagNumber ^= nums[i];
        }

        int departNumber = findLastBitsOne(flagNumber);

        int nums1 = 0;
        int nums2 = 0;
        for(int i = 0;i< nums.length ;i++){
            if((nums[i] & departNumber) == departNumber){
                nums1 = nums1 ^ nums[i];
            }else{
                nums2 = nums2 ^ nums[i];
            }
        }

        list.add(nums1);
        list.add(nums2);
        return list;
    }

    public static int findLastBitsOne(int number){
        int result = 0;
        if(number <= 0){
            return result;
        }
        result = 1;
        if((number & 1) == 1){
            return result;
        }
        while((number & 1 )!= 1){
            result = result << 1;
            number = number >>> 1;
        }

        return result;
    }

}
