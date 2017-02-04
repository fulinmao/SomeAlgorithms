package com.fulin.array.sort;

/**
 * Created by fulin on 17-2-4.
 */

import com.fulin.utils.ArrayUtils;

/**
 * 荷兰国旗问题
 * 一组数中 只有 3个数字    将三个数字按照从小到大的数进行排序
 *
 * 例如 ：0 1 2 1 1 2 0 2 1 0
 * 排序：0 0 0 1 1 1 1 2 2 2
 * @author mfl4482
 *
 */
public class ThreeWayPartion {

    public static void main(String[] args) {
// TODO Auto-generated method stub
        int[] nums = {0,1,2,1,1,2,0,2,1,0};
        ArrayUtils.printArray(nums);
        threeWayPartion(nums);
        ArrayUtils.printArray(nums);
    }



    public static void threeWayPartion(int[] nums){
        if(nums == null || nums.length == 0){
            return ;
        }
        int beigin = 0;
        int current = 0;
        int end = nums.length - 1;

        while(current <= end){
            if(nums[current] ==0){
                ArrayUtils.exchangeElements(nums, current, beigin);
                beigin ++;
                current ++;
            }else if(nums[current] == 1){
                current ++;
            }else if(nums[current] == 2){
                ArrayUtils.exchangeElements(nums, current, end);
                end --;
            }
        }

    }
}
