package com.fulin.offer.problem36;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by fulin on 17-3-8.
 */
public class InversePairsTest {
    @Test
    public void inversePairsCount() throws Exception {

        // case 1 : 正常情况，输入未进行排序的数组
        int[] nums = {7,5,6,3,9,1};
        int result = InversePairs.inversePairsCount(nums);
        if(result != 10){
            fail("case 1 : method fail,result:" +result);
        }
        // case 2: 正常情况：递增排序的数组
        int[] nums1 = {1,2,3,4,5,6,7,8,9};
        result = InversePairs.inversePairsCount(nums1);
        if(result != 0){
            fail("case 2 : method fail");
        }

        // case 3: 正常情况：递减排序的数组
        int[] nums2 = {7,6,5,4};
        result = InversePairs.inversePairsCount(nums2);
        if(result != 6){
            fail("case 3 : method fail");
        }

        // case 4: 输入的数组中包含重复的数组
        int[] nums3 = {7,5,4,5};
        result = InversePairs.inversePairsCount(nums3);
        if(result != 4){
            fail("case 4 : method fail,result:" +result);
        }

        // case 5 边界值测试，数组中只有两个数字
        int[] nums4 = {7,5};
        result = InversePairs.inversePairsCount(nums4);
        if(result != 1){
            fail("case 5 : method fail");
        }

        // case 6 边界值测试，数组中只有一个数字
        int[] nums5 = {7};
        result = InversePairs.inversePairsCount(nums5);
        if(result != 0){
            fail("case 6 : method fail");
        }

        // case 7 特殊输入测试：数组为null
        int[] nums6 = null;
        result = InversePairs.inversePairsCount(nums6);
        if(result != 0){
            fail("case 7 : method fail");
        }
    }

}