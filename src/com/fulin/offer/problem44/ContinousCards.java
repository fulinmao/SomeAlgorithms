package com.fulin.offer.problem44;

import java.util.Arrays;

/**
 * Created by fulin on 17-3-15.
 */
public class ContinousCards {

    public static void main(String[] args){
        int[] nums = {0,1,1,3,5};
        boolean result = isContinousCards(nums);
        System.out.print(result);
    }

    public static boolean isContinousCards(int[] nums){
        boolean result = true;
        if(nums == null || nums.length < 5){
            result = false;
            return result;
        }

        int number0Count = 0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                number0Count ++;
            }
        }
        int small = 0;
        int big = small + 1;

        int gap = 0;

        while(big < nums.length){
            if(nums[small] == nums[big]){
                result = false;
                break;
            }

            gap += (nums[big] - nums[small] - 1);
            small = big;
            big ++;
        }

        if(gap != number0Count){
            result = false;
        }
        return result;
    }
}
