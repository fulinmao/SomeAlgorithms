package com.fulin.number;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by fulin on 17-2-4.
 */
public class MedianFinder {

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        System.out.println(mf.findMedian());
        mf.addNum(3);
        System.out.println(mf.findMedian());
        mf.addNum(3);
        System.out.println(mf.findMedian());
        mf.addNum(4);
        System.out.println(mf.findMedian());
        mf.addNum(1);
        System.out.println(mf.findMedian());
    }

    public PriorityQueue<Integer> MIN_HEAP ,MAX_HEAP;

    public MedianFinder(){
        MAX_HEAP = new PriorityQueue<Integer>(1, Collections.reverseOrder());
        MIN_HEAP = new PriorityQueue<Integer>();
    }

    public void addNum(int num){
        MAX_HEAP.add(num);
        MIN_HEAP.add(MAX_HEAP.poll());
        if(MAX_HEAP.size() < MIN_HEAP.size()){
            MAX_HEAP.add(MIN_HEAP.poll());
        }
    }

    public double findMedian(){
        if(MAX_HEAP.size() == MIN_HEAP.size()){
            return (MAX_HEAP.peek() + MIN_HEAP.peek())  * 0.5;
        }else{
            return MAX_HEAP.peek();
        }
    }
}
