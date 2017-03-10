package com.fulin.offer.problem38;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by fulin on 17-3-10.
 */
public class NumberOfKTest {

    @Test
    public void numberOfK() throws Exception {
        // case 1 正常情况
        int[] nums = {1,2,3,3,3,3,4,5};
        int target = 3;
        int result = NumberOfK.numberOfK(nums,target);
        if(result != 4 ){
            fail("case 1 :method fail");
        }

        // case 2 查找不存在的数字
        target = 10;
        result = NumberOfK.numberOfK(nums,target);
        if(result != 0){
            fail("case 2 :method fail");
        }

        // case 3 查找最大值
        target = 1;
        result = NumberOfK.numberOfK(nums,target);
        if(result != 1){
            fail("case 3 : method fail");
        }

        // case 4 查找最大值
        target = 5;
        result = NumberOfK.numberOfK(nums , target);
        if(result != 1){
            fail("case 4 :method fail");
        }

        // case 5 : 数组中只有一个数字
        int[] nums1 = null;

        result = NumberOfK.numberOfK(nums1 , target);
        if(result != 0){
            fail("case 5:method fail");
        }

        // case 6 : 数组中中只有一个数字
        nums1 = new int[1];
        nums1[0] = 1;
        target = 1;
        result = NumberOfK.numberOfK(nums1,target);
        if(result != 1){
            fail("case 6 :method fail");
        }
    }
}