package com.fulin.offer.problem29;

import static org.junit.Assert.*;

import org.junit.Test;

public class MoreThanHalfNumberTest {

    @Test
    public void test() {
        int[] nums = {1,2,3,2,2,2,5,4,2};
        int result = MoreThanHalfNumber.moreThanHalfNumber(nums);
        if(result != 2){
            fail("method error");
        }

        int[] nums1 = {1,2,3,4,5,6,7};
        result = MoreThanHalfNumber.moreThanHalfNumber(nums1);
        if(result != -1){
            fail("method error");
        }

        int[] nums2 = {1};
        result = MoreThanHalfNumber.moreThanHalfNumber(nums2);
        if(result != 1){
            fail("method error");
        }
    }

}