package com.fulin.offer.problem41;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个递增排序的数组和一个数字target,在数组中查找两个数，使得他们的和正好是target。
 * 如果存在多对，只需返回一对即可
 * @author mfl4482
 *
 */
public class TwoNumberWithSum {

    public static void main(String[] args) {
        int[] nums = {1,2,4,7,11,15};
        int target = 15;
        List<Integer> result = findTwoNumberWithSum(nums, target);
        System.out.println(result);
    }

    public static List<Integer> findTwoNumberWithSum(int[] nums , int target){
        List<Integer> list = new ArrayList<Integer>();
        if(nums == null || nums.length == 0){
            return list;
        }
        int start = 0;
        int end = nums.length - 1;
        while(start < end){
            int sum = nums[start] + nums[end];
            if(target > sum){
                start ++;
            }else if(target < sum){
                end --;
            }else{
                list.add(nums[start]);
                list.add(nums[end]);
                break;
            }

        }
        return list;
    }
}