package com.fulin.offer.problem28;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列
 *
 * 例如：输入字符串：abc
 * 	         输出：abc acb bac bca cab cba
 * @author mfl4482
 *
 */
public class StringPermutation {

    public static void main(String[] args) {
        String str = "abc";
        List<String> result = stringPermutation(str);
        System.out.println(result);
    }

    public static List<String> stringPermutation(String str){
        List<String> result = new ArrayList<String>();
        if(str == null || str.length() <=0){
            return result;
        }
        char[] strArray = str.toCharArray();
        if(strArray.length == 1){
            result.add(str);
            return result;
        }

        result = stringPermutationRecurisivly(strArray,0,strArray.length - 1);
        return result;
    }

    private static List<String> stringPermutationRecurisivly(char[] strArray,int start ,int end){
        List<String> result = new ArrayList<String>();
        if(strArray == null || strArray.length <=0){
            return null;
        }
        if(start > strArray.length){
            return null;
        }

        if(start == strArray.length){
            String str = new String(strArray);
            result.add(str);
        }else{
            for(int i=start;i<=end;i++){
                char temp = strArray[start];
                strArray[start] = strArray[i];
                strArray[i] = temp;

                List<String> tList = stringPermutationRecurisivly(strArray, start + 1, end);
                if(tList != null && tList.size() >0){
                    result.addAll(tList);
                }

                // 遍历完成后，将原字符串数组进行恢复
                temp = strArray[start];
                strArray[start] = strArray[i];
                strArray[i] = temp;
            }
        }
        return result;

    }
}