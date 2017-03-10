package com.fulin.offer.problem38;

/**
 *
 * 统计一个数字在排序数组中出现的次数
 * 例如
 *  输入：{1,2,3,3,3,3,4,5} 和 3
 *  输出：4
 * Created by fulin on 17-3-10.
 */
public class NumberOfK {

    public static void main(String[] args){

        int[] nums = {1,2,3,3,3,3,4,5};
        int target = 6;
        int result = numberOfK(nums,target);
        System.out.print(result);
    }


    public static int numberOfK(int[] nums , int target){
        int result = 0;
        if(nums == null || nums.length == 0){
            return result;
        }

        int first = getFirstK(nums , target,0,nums.length -1);
        int last = getLastK(nums,target , 0 ,nums.length -1);

        if(first > -1 && last > -1){
            result = last - first + 1;
        }
        return result;
    }

    private static int getFirstK(int[] nums , int target , int start , int end){
        int index = -1;
        if(start > end){
            return index;
        }

        int middle = (start + end) / 2;

        if(nums[middle] > target){
            index = getFirstK(nums,target,start,middle - 1);
        }else if(nums[middle] == target){
            if(middle == 0){
                index = middle;
                return index;
            }else if(nums[middle - 1] != target){
                index = middle;
                return index;
            }else {
                index = getFirstK(nums,target,start ,middle -1);
            }

        }else{
            index = getFirstK(nums,target,middle + 1, end);
        }

        return index;

    }

    private static int getLastK(int[] nums , int target , int start , int end){
        int index = -1;

        if(start > end){
            return  index;
        }
        int middle = (start + end) /  2;
        if(nums[middle] == target){
            if(middle == nums.length - 1){
                index = nums.length - 1;
            }else if(nums[middle + 1] != target){
                index = middle ;
            }else {
                index = getLastK(nums,target,middle + 1,end);
            }

        }else if(nums[middle] > target){
            index = getLastK(nums,target,start,middle - 1);
        }else {
            index = getLastK(nums,target,middle + 1,end);
        }
        return index;
    }

}
