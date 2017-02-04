package com.fulin.number;

/**
 * Created by fulin on 17-2-4.
 */
public class NumberOf1BetweenAndN {

    public static void main(String[] args) {
        int n = 12;
        int result = numberOf1BetweenAndN(n);
        System.out.println(result);
    }

    public static int numberOf1BetweenAndN(int n){
        int result = 0;
        if(n <=0){
            return result;
        }
        result = numberOf1(String.valueOf(n));
        return result;
    }

    public static int numberOf1(String str){
        char[] strArray = str.toCharArray();
        int length = strArray.length;
        if(length == 1 && strArray[0] == '0'){
            return 0;
        }
        if(length == 1 && strArray[0] > '1'){
            return 1;
        }

        int numOfFirstDigit = 0;
        if(strArray[0] > '1'){
            numOfFirstDigit = (int) Math.pow(10, length - 1);
        }else if(strArray[0] == '1'){
            numOfFirstDigit = Integer.parseInt(str.substring(1)) + 1;
        }
        int numOfOtherDigit = (int) (Math.pow(10, length - 2) * (length - 1) * (strArray[0] - '0'));
        int numOfRecursive = numberOf1(str.substring(1));
        return numOfFirstDigit + numOfOtherDigit + numOfRecursive;
    }
}
