package com.fulin.offer.problem42;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变
 *
 * 例如：
 *      输入：I am Student.
 *      输出：Student. am I
 * Created by fulin on 17-3-14.
 */
public class ReverseWordsInSentence {

    public static void main(String[] args){
        String str = "I am Student.";
        String result = reverseWord(str);
        System.out.print(result);
    }

    public static  String reverseWord(String str){
        String result = null;
        if(str == null || str.length() == 0){
            return  result;
        }
        char[] array = str.toCharArray();
        int start = 0;
        int end = 0;
        while(end < array.length && start < array.length){
            while(end < array.length &&array[end] != ' ' ){
                end ++;
            }
            reverseWord(array , start , end - 1);
            start = end + 1;
            end ++;
        }
        reverseWord(array,0,array.length - 1);
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
