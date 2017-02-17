package com.fulin.offer.problem9;

/**
 * 写一个函数， 输入n 求斐波那契（Fibonacci）数列的第n项
 *
 * f(0) = 0
 * f(1) =1
 * f(n) = f(n-1) + f(n-2)
 *
 * Created by fulin on 17-2-17.
 */
public class Fibonacci {


    public static void main(String[] args){
        for(int i=0;i<10;i++){
            System.out.println(fibonacci3(i));
        }
    }

    public static int fibonacci(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }else{
            return fibonacci(n - 1) + fibonacci(n - 2);
        }

    }

    public  static int fibonacci2(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int[] result = new int[n + 1];
        result[0] = 0;
        result[1] = 1;
        for(int i=2;i<=n;i++){
            result[i] = result[i - 1] + result[i -2];
        }

        return result[n];
    }


    public static int fibonacci3(int n){
        int first = 0;
        int second = 1;

        if(n ==0){
            return first;
        }

        if(n == 1){
            return second;
        }
        int result = 0;

        for(int i=2;i<=n ;i++){
            result = first + second;
            first = second;
            second = result;
        }

        return result;
    }
}
