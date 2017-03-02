package com.fulin.offer.problem24;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fulin.utils.TreeNode;

public class SequenceOfBstTest {

    @Test
    public void test() {

        int[] nums = {5,7,6,9,11,10,8};
        boolean result = SequenceOfBst.sequenceOfBst(nums,0,nums.length - 1);
        if(!result){
            fail("method test error");
        }

    }

}