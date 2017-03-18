package com.fulin.offer.problem45;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 0,1,...,n-这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里删除第m个数字，求出这个圆圈里剩下的最后一个数字
 *
 * 例如
 * 	输入：n=5,m=3
 * 	输出：3
 * @author mfl4482
 *
 */
public class LastNumberInCircle {

    public static void main(String[] args) {
        int n = 5;
        int m = 3;
        int result = findLastNumberInCircle(n, m);
        System.out.println(result);
    }

    public static int findLastNumberInCircle(int n , int m){
        int result = -1;
        List<Integer> list = new ArrayList<Integer>();
        int start = 0;
        for(int i = 0;i < n ; i ++){
            list.add(i);
        }
        Iterator<Integer> iterator = list.iterator();
        while(list.size() !=1){
            while(start < m){
                if(iterator == null || (!iterator.hasNext())){
                    iterator = list.iterator();
                    iterator.next();
                }else{
                    iterator.next();
                }
                start ++;
            }
            if(start == m){
                iterator.remove();
                start = 0;
            }

        }
        result = list.get(0);
        return result;
    }

}
