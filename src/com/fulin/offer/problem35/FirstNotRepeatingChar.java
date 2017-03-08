package com.fulin.offer.problem35;

/**
 * 在字符串中找出第一个只出现一次的字符
 *
 * 例如 	输入：abaccdeff
 * 	输出：b
 * @author mfl4482
 *
 */
public class FirstNotRepeatingChar {

    public static void main(String[] args) {
        char result = firstNotRepeatingChar("87");
        System.out.println(result);
    }

    public static char firstNotRepeatingChar(String str){
        char result  = ' ';
        if(str == null || str.length() == 0){
            return result;
        }
        int[] map = new int[2<<8];
        for(int i=0;i<str.length();i++){
            map[str.charAt(i)]  = map[str.charAt(i)] + 1;
        }

        for(int i=0;i<str.length();i++){
            if(map[str.charAt(i)] == 1){
                result = str.charAt(i);
                break;
            }
        }

        return result;
    }
}