package com.fulin.offer.problem32;

/**
 * 输入一个整数 n 求1到n这n个整数的十进制表示中1出现的次数
 *
 * 例如
 *  输入：12
 *  输出：5（1,10,11,12）
 * Created by fulin on 17-3-6.
 */
public class NumberOf1 {

    public static void main(String[] args){
        int num = 1;
        int result = numberOf1(num);
        System.out.print(result);
    }

    public static int numberOf1(int n){
        int result = 0;
        if(n <= 0){
            return result;
        }

        result = numberOf1(String.valueOf(n));
        return result;
    }

    public static int numberOf1(String str){
        int result = 0;
        if(str == null || str.length() == 0){
            return result;
        }

        char[] strArray = str.toCharArray();

        if(str.length() == 1 && strArray[0] == '0'){
            return result;
        }

        if(str.length() == 1 && strArray[0] > '0'){
            result = 1;
            return result;
        }

        int numofFirstDigit = 0;
        if(strArray[0] - '0' > 1){
            numofFirstDigit = (int )Math.pow(10,strArray.length - 1);
        }else{
            numofFirstDigit =  Integer.parseInt(str.substring(1)) + 1;
        }

        // 1346 - 11345  11346 - 21345 共计两段，每段有4位， 全排列的规则 10*10*10 共计有4× 1000 = 4000
        int numOfOtherDigit = (int)Math.pow(10,(strArray.length - 2)) * (strArray[0] - '0') * (strArray.length - 1);

        // 1 - 1345 中1的个数
        int numOfRecurisivly = numberOf1(str.substring(1));

        return numofFirstDigit + numOfRecurisivly + numOfOtherDigit;
    }
}
