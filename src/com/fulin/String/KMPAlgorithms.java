package com.fulin.String;

/**
 * Created by fulin on 17-2-4.
 */
public class KMPAlgorithms {

    public static void main(String[] args) {
// TODO Auto-generated method stub
        String str = "BBC ABCDAB ABCDABCDABDE";
        String pattern = "ABCDABD";
        int index = kmpAlgrithms(str, pattern);
        System.out.println(index);
        System.out.println(str.indexOf(pattern));
    }

    public static void getNextArray(char[] pattern ,int[] next){
        if(pattern == null || pattern.length ==0){
            return ;
        }
        int length = pattern.length;
// k 应该是 -1
        int k = -1;
        next[0] = -1;
        int j = 0;
// length - 1
        while(j < length -1){
            if(k== -1 || pattern[k] == pattern[j]){
                k++;
                j++;
                next[j] = k;
            }else{
                k = next[k];
            }

        }
    }

    public static void getNextArrayOpt(char[] pattern ,int[] next){
        if(pattern == null || pattern.length ==0){
            return ;
        }
        int length = pattern.length;
// k 应该是 -1
        int k = -1;
        next[0] = -1;
        int j = 0;
// length - 1
        while(j < length -1){
            if(k== -1 || pattern[k] == pattern[j]){
                k++;
                j++;
                if(pattern[k] != pattern[j]){
                    next[j] = k;
                }else{
                    next[j] = next[k];
                }
            }else{
                k = next[k];
            }

        }
    }

    public static int kmpAlgrithms(String str , String pattern){
        int index = -1;
        if(pattern == null || pattern.length() == 0){
            index = 0;
            return index;
        }
        if(str == null || str.length() ==0){
            return index;
        }
        char[] strArray = str.toCharArray();
        char[] patternArray = pattern.toCharArray();
        int sLength = strArray.length;
        int pLength = pattern.length();
        int[] next = new int[pLength];
        //	getNextArray(patternArray, next);
        getNextArrayOpt(patternArray, next);
        int i = 0;
        int j = next[0];
        while(i < sLength && j< pLength){
            if(j== -1 || strArray[i] == patternArray[j]){
                ++i;
                ++j;
            }else{
                j = next[j];
            }
        }
        if(j == pLength){
            index = i - j;
        }
        return index;
    }
}