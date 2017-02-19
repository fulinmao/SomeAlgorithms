package com.fulin.offer.problem10;

/**
 * Created by fulin on 17-2-19.
 */
public class NumberOf1InBinary {

    public static void main(String[] args){
        int n = -10;
        System.out.println(Integer.toBinaryString(n));
        int result = numberof1InBinary(n);
        System.out.println(result);
    }

    public static int numberof1InBinary(int n){
        int result = 0;

        while(n != 0){
            n = n & (n -1);
            result ++;
        }

        return result;
    }
}
