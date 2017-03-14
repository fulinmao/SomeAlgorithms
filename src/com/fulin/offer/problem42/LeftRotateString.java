package com.fulin.offer.problem42;

/**
 * 字符串的左转操作是把字符串前面的若干个字符转移到字符串的尾部
 *
 * 例如：
 *      输入： abcdefg 2
 *      输出： cdefgab
 *
 * Created by fulin on 17-3-14.
 */
public class LeftRotateString {

    public static void main(String[] args){
        String str=  "abcdefg";
        int index = 2;
        String result = leftRotateString(str,index);
        System.out.print(result);
    }

    public static String leftRotateString(String str,int index){
        String result = null;
        if(str == null || str.length() == 0){
            return result;
        }
        if(index <0 || index >= str.length()){
            return result;
        }
        char[] array = str.toCharArray();
        reverseWord(array,0,index - 1);
        reverseWord(array,index,str.length() - 1);
        reverseWord(array,0 , array.length - 1);

        result = new String(array);
        return result;
    }

    /**
     * 翻转数组中指定区域内的字符
     * @param array
     * @param start
     * @param end
     */
    public static void reverseWord(char[] array , int start , int end){
        if(start > end){
            return ;
        }

        while(start <= end){
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;

            start ++;
            end --;
        }

    }
}
