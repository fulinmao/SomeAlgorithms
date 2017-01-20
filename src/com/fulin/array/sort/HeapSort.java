package com.fulin.array.sort;

import com.fulin.utils.ArrayUtils;

/**
 * Created by fulin on 17-1-20.
 */
public class HeapSort {

    public static void main(String[] args){
        int[] nums = {9,8,7,6,5,4,3,2,1,0,-1,-2,-3};
        ArrayUtils.printArray(nums);
        heapSort(nums);
        ArrayUtils.printArray(nums);
    }

    public static void heapSort(int[] nums){
        if(nums== null || nums.length == 0){
            return ;
        }
        buildMaxHeap(nums);

        for(int i= nums.length - 1 ; i>=1 ;i--){
            ArrayUtils.exchangeElements(nums, 0, i);
            maxHeap(nums , i ,0);
        }
    }

    public static void buildMaxHeap(int[] nums){
        if(nums == null || nums.length == 0){
            return;
        }
        int half = nums.length / 2;
        for (int i= half ; i>=0 ; i--){
            maxHeap(nums, nums.length, i);
        }
    }

    private static void maxHeap(int[] nums , int heapSize , int index){
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest = index;
        if(left < heapSize && nums[left] > nums[largest]){
            largest = left;
        }

        if(right < heapSize && nums[right] > nums[largest]){
            largest = right;
        }

        if(largest != index){
            ArrayUtils.exchangeElements(nums, index, largest);
            maxHeap(nums, heapSize, largest);
        }
    }
}
