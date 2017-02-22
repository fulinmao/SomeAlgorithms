package com.fulin.offer.problem11;

/**
 * 实现函数 double power(double base , int exponent),求base的exponent次方。
 *
 * 不使用库函数  同时不需要考虑大数的问题
 *
 * @author mfl4482
 *
 */
public class Power {

    public static void main(String[] args){

    }

    public static double power(double base , int exponent){
        double result = 0;
        // 情况1： base: 0 exponent:
        if(equals(base, 0.0) && exponent <= 0){
            return result;	// 如果 底数为0 ，且 指数小于等于0 返回为0
        }

        if(exponent < 0 && equals(base, 0.0)){
            return result;
        }

        int absExponent = exponent;
        if(exponent < 0){
            absExponent = -exponent;
        }

        result = powerUnsignedIntExponent(base, absExponent);

        if(exponent < 0){	// 情况2：指数为负数，需取倒数
            result = 1.0 / result;
        }

        return result;
    }

    /**
     * double 类型的数字比较 尽可能不要用 等号
     * @param a
     * @param b
     * @return
     */
    private static boolean equals(double a , double b){
        boolean result = false;
        if(a - b < 0.00000000001){
            result = true;
        }
        return result;
    }

    private static double powerUnsignedIntExponent(double base , int exponent){
        double result = 1.0;
        for(int i=0;i< exponent;i++){
            result *= base;
        }

        return result;
    }
}