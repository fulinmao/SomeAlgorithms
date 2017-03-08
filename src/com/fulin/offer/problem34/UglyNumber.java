package com.fulin.offer.problem34;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 我们把只因子2.3.5的数称作丑数
 *
 * 求按从小到大的顺序的第1500个丑数。
 *
 * Created by fulin on 17-3-7.
 */
public class UglyNumber {

    public static void main(String[] args){
        int n = 11;
        for(int i=1;i<=n;i++){
            System.out.println(uglyNumber(i));
        }

    }

    public static int uglyNumber(int n){
        int result = 0;
        if(n <= 0){
            return 0;
        }
        int[] uglyArray = new int[n];
        uglyArray[0] = 1;
        int index = 1;
        int uglyNumber2Index = 0;
        int uglyNumber3Index = 0;
        int uglyNumber5Index = 0;
        int uglyNumber2,uglyNumber3,uglyNumber5;
        while(index < n){
            uglyNumber2 = uglyArray[uglyNumber2Index] * 2;
            uglyNumber3 = uglyArray[uglyNumber3Index] * 3;
            uglyNumber5 = uglyArray[uglyNumber5Index] * 5;

            int min = uglyNumber2;
            if(uglyNumber3 < min){
                min = uglyNumber3;
                uglyNumber3Index ++;
            }
            if(uglyNumber5 < min){
                min  = uglyNumber5;
                uglyNumber5Index ++;
            }
            if(min == uglyNumber2){
                uglyNumber2Index ++;
            }

            if(min > uglyArray[index - 1]){
                uglyArray[index] = min;
                index ++;
            }
        }
        result = uglyArray[n - 1];
        return result;
    }

    private static int min(int a , int b , int c){
        int min = a;
        if(b < min){
            min = b;
        }
        if(c < min){
            min  = c;
        }
        return min;
    }
}
