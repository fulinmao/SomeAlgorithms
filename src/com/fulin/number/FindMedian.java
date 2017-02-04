package com.fulin.number;

/**
 * Created by fulin on 17-2-4.
 */

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 寻找数组中的中位数
 * @author mfl4482
 *
 */
public class FindMedian {

    public static void main(String[] args) {
// TODO Auto-generated method stub

    }

    public int[] medianII(int[] nums){
        if(nums == null || nums.length ==0){
            return null;
        }
        int[] res = new int[nums.length];
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(1,new Comparator<Integer>() {
            @Override
            public int compare(Integer x ,Integer y){
                return y - x;
            }
        });

        res[0] = nums[0];
        maxHeap.add(nums[0]);
        for(int i=0;i<nums.length;i++){
            int x = maxHeap.peek();
            if(nums[i] <= x){
                maxHeap.add(nums[i]);
            }else{
                minHeap.add(nums[i]);
            }
            if(maxHeap.size() > minHeap.size()){
                minHeap.add(maxHeap.poll());
            }else if(maxHeap.size() < minHeap.size()){
                maxHeap.add(minHeap.poll());
            }
            res[i] = maxHeap.peek();
        }

        return res;
    }

}

//public class MedianFinder(){
//	public PriorityQueue<Integer> MIN_HEAP , MAX_HEAP;
//
//	public FindMedian(){
//	MAX_HEAP = new PriorityQueue<Integer>();
//	MIN_HEAP = new PriorityQueue<Integer>();
//	}
//}
