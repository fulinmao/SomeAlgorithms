package com.fulin.offer.problem31;

/**
 * 输入一个整型数组，数组中有正数也有负数。数组中䘝或者连续多个整数组成一个子数组，求所有子数组的和的最大值
 *
 * 例如
 *  输入：1,-2,3,10,4,7,2,5
 *  输出：18
 * Created by fulin on 17-3-4.
 */
public class GreatestSumOfSubArrays {

    public static void main(String[] args){
        int[] nums = {1,-2,3,10,4,7,2,5};
        int result = greatestSumOfSubArraysByDP(nums);
        System.out.print(result);
    }

    public static boolean isInvalid = true;

    public static int greatestSumOfSubArrays(int[] nums){
        int result = 0;
        if(nums == null || nums.length <= 0){
            isInvalid = false;
            return result;
        }
        result = nums[0];
        int preSum = nums[0];
        for(int i=1;i<nums.length;i++){
            int currMax = Math.max(preSum + nums[i], nums[i]);
            if(currMax > result){
                result = currMax;
            }
            if(preSum < 0){
                preSum = nums[i];
            }else{
                preSum += nums[i];
            }
        }

        return result;
    }


    /**
     * 使用动态规划的方法计算
     * @param nums
     * @return
     */
    public static int greatestSumOfSubArraysByDP(int[] nums){
        if(nums == null || nums.length <= 0){
            isInvalid = false;
            return 0;
        }
        int[] temp = new int[nums.length];
        temp[0] = nums[0];
        int result = temp[0];
        for(int i=1;i<nums.length;i++){
            temp[i] = Math.max(temp[i-1] + nums[i], nums[i]);
            if(temp[i] > result){
                result = temp[i];
            }
        }
        return result;
    }
}
