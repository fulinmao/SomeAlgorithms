package com.fulin.offer.problem8;

/**
 * 把一个数组最开始的若干个元素搬到数组的尾部，称之为数组的旋转
 *
 * 输入一个递增排序的数组的一个旋转  输出旋转数组的最小元素。】
 *
 * 例如：{3,4,5,1,2}   该数组的最小值为1
 *
 * Created by fulin on 17-2-17.
 */
public class MinNumberInRotatedArray {

    public static void main(String[] args){
//        int[] nums = {3,4,5,1,2};
//         int[] nums = {1,0,1,1,1};
         int[] nums = {1,1,1,0,1};
        int result = minNumberInRotatedArray(nums);
        System.out.println(result);
    }

    public static int minNumberInRotatedArray(int[] nums){
        int result = -1;
        if(nums == null || nums.length == 0){
            return result;
        }
        int start = 0;
        int end = nums.length - 1;
        int middle = start; //用于处理 没有进行移动的数组 的情况

        while(nums[start] >= nums[end]){
            if(end - start == 1){
                middle = end;
                break;
            }
            middle = start + (end - start) / 2;

            if(nums[start] == nums[end] && nums[start] == nums[middle] && nums[end] == nums[middle]){
                return MidInOrder(nums , start ,end);
            }

            if(nums[start] <= nums[middle]){
                start = middle;
            }else if(nums[start] >= nums[middle]){
                end = middle;
            }

        }
        result = nums[middle];
        return result;
    }

    /**
     * 按顺序遍历查找最小的元素
     * @param nums
     * @param start
     * @param end
     * @return
     */
    public static int MidInOrder(int[] nums , int start , int end){

        int result = nums[start];
        for(int i=start + 1; i <= end ;i++){
            if(result > nums[i]){
                result = nums[i];
            }
        }
        return result;
    }


}
