package com.fulin.offer.problem41;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个正数s , 输出所有和为s的连续正数序列（至少含有两个数）
 *
 * 例如：
 * 	输入：15
 * 	输出：1~5、4~6、7~8
 * @author mfl4482
 *
 */
public class ContinuesSquenceWithSum {

    public static void main(String[] args) {
// TODO Auto-generated method stub
        int target = 15;
        List<List<Integer>> result =  findContinuesSquenceWithSum(target);
        for(List<Integer> list : result){
            System.out.println(list);
        }
    }


    public static List<List<Integer>> findContinuesSquenceWithSum(int target){
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(target < 3){
            return list;
        }
        int small = 1;
        int big = 2;
        int stop = (target + 1) / 2;
        int currentSum = small + big;
        while(small < stop){
            if(currentSum == target){
                list.add(genList(small, big));
            }

            while(currentSum > target && small < stop){
                currentSum -= small;
                small ++;

                if(currentSum == target){
                    list.add(genList(small, big));
                }

            }

            big ++;
            currentSum += big;
        }
        return list;
    }

    private static List<Integer> genList(int small , int big){
        List<Integer> list = new ArrayList<Integer>();
        for(int i= small ; i <= big ;i++){
            list.add(i);
        }
        return list;
    }

}