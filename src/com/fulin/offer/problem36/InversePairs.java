package com.fulin.offer.problem36;

import java.util.Arrays;

/**
 * 在数组中的两个数字 如果前面要给数字大于后面的数字，则这两个数字组成一个逆序对
 *
 * 输入一个数组，求出这个数组中的逆序对的总数
 *
 * 例如	输入：{7,5,6,4}
 * 	输出：5(逆序对分别为(7,6),(7,5),(7,4),(6,4),(5,4))
 * @author mfl4482
 *
 */
public class InversePairs {

    public static void main(String[] args) {

//        int[] nums = {7,5,6,4};
        int[] nums = {7,5,6,4};
        int result = inversePairsCount(nums);
        System.out.println(result);

    }

    public static int inversePairsCount(int[] nums){
        int result = 0;
        if(nums == null || nums.length == 0){
            return result;
        }
        int[] copyArray =  new int[nums.length];
        System.arraycopy(nums, 0, copyArray, 0, nums.length);

        result = inversePairCore(nums, copyArray ,0,nums.length - 1);
        return result;
    }


    private static int inversePairCore(int[] nums , int[] copy ,int start , int end){
        int result = 0;
        if(start == end){
            copy[start] = nums[start];
            return result;
        }

        int length = (end - start) / 2;
        // 注意 次数传递的参数 一定要注意 顺序发生交换了
        int left = inversePairCore(copy, nums, start, start + length);
        int right = inversePairCore(copy, nums, start + length + 1, end);

        int count = 0;
        int i = start + length;
        int j = end;
        int copyIndex = end;

        while(i >= start && j>= (start + length +1)){
            if(nums[i] > nums[j]){
                copy[copyIndex --] = nums[i --];
                count += j - start -length;
            }else{
                copy[copyIndex --] = nums[j --];
            }
        }

        while(i>= start){
            copy[copyIndex --] = nums[i--];
        }

        while(j>= (start + length +1)){
            copy[copyIndex --] = nums[j --];
        }


        result = left + right + count;
        return result;
    }

}