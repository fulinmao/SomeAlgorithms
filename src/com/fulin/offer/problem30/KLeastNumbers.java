package com.fulin.offer.problem30;

import com.fulin.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 输入n个整数，找出最小的k个数
 *
 * 例如
 * 	输入：4,5,1,6,2,7,3,8
 * 	输出：1,2,3,4
 * @author mfl4482
 *
 */
public class KLeastNumbers {

    public static void main(String[] args) {
        int[] nums = {4,5,1,6,2,7,3,8};
        int k = 2;
        List<Integer> result = kLeastNumberByPartition(nums,k);
        System.out.println(result);
    }

    /**
     * 使用 堆的结构进行选择最小的k个树
     * @param nums
     * @param k
     * @return
     */
    public static List<Integer> kLeastNumberByHeap(int[] nums,int k){
        List<Integer> list = new ArrayList<Integer>();
        if(nums == null || nums.length <=0 || k <=0 ){
            return list;
        }
        if(k >= nums.length){
            for(int t : nums){
                list.add(t);
            }
        }


        return list;
    }

    /**
     * 使用Partition的方法进行选择 找到最小的k个数
     * @param nums
     * @param k
     * @return
     */
    public static List<Integer> kLeastNumberByPartition(int[] nums , int k){
        List<Integer> list = new ArrayList<Integer>();
        if(nums == null || nums.length <=0 || k <=0 ){
            return list;
        }
        if(k >= nums.length){
            for(int t : nums){
                list.add(t);
            }
        }

        int start = 0;
        int end = nums.length - 1;
        int index = partition(nums,start,end);
        while(index != k -1){
            if(index > k -1){
                end = index - 1;
                index = partition(nums,start ,end);
            }else{
                start = index + 1;
                index = partition(nums, start, end);
            }
        }
        for(int i=0;i<k;i++){
            list.add(nums[i]);
        }
        return list;
    }

    /**
     * 将数组进行分区，小于nums[index]的位于数组左侧，大于等于的位于数组右侧
     * 返回index
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private static int partition(int[] nums, int start, int end) {
        int index = -1;
        if(nums == null || nums.length <= 0 || (start >end )){
            return index;
        }
        int pivot = nums[end];

        index = start - 1;
        for(int i = start;i<end;i++){
            if(nums[i] < pivot){
                ++ index;
                if( index != i){
                    ArrayUtils.exchangeElements(nums,index,i);
                }
            }
        }

        ++ index;
        ArrayUtils.exchangeElements(nums,index,end);

        return index;
    }

}