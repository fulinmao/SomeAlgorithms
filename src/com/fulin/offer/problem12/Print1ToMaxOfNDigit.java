package com.fulin.offer.problem12;

/**
 *
 * 输入数字n 按照顺序打印出从1到最大的n位十进制数
 *
 * 比如 输入 3，则打印1.2.3....999
 *
 * Created by fulin on 17-2-21.
 */
public class Print1ToMaxOfNDigit {

    public static void main(String[] args){
        int n = 2;
//        print1TOMaxOfNDigit(n);
        print1ToMaxNDigit(n);
    }

    /**
     * 打印1 到 最大的n位数
     *
     * 使用字符串加法的方式
     * @param n
     */
    public static void print1TOMaxOfNDigit(int n){
        if(n <=0 ){
            return;
        }
        char[] number = new char[n];
        for(int i=0;i<n;i++){
            number[i] = '0';
        }
        while(!increment(number)){
            printNumber(number);
        }

    }

    /**
     * 使用字符串加1的算法 进行加1操作
     * @param number
     * @return
     */
    private static boolean increment(char[] number){
        boolean isOver = false;
        int nSUm = 0;
        int flag = 0;

        int length = number.length;
        for(int  i= length - 1 ; i >= 0 ; i--){


            nSUm = number[i] - '0' + 1 + flag;
            if(nSUm >= 10){
                flag = 1;
                number[i] = (char) ((nSUm - 10) + '0');

            }else{
                flag = 0;
                number[i] = (char) (nSUm +  '0');
            }

            if(i == 0){
                if(flag > 0){
                    isOver = true;
                    break;
                }
            }
        }
        return isOver;
    }


    /**
     * 打印字符数组  字符数组前部分如果有0 不进行打印
     * @param number
     */
    private static void printNumber(char[] number){
        if(number == null || number.length == 0){
            return ;
        }

        for(int i=0;i<number.length;i++){
            if(number[i] == '0'){
                continue;
            }
            System.out.print(number[i]);
        }
        System.out.println();
    }


    /**
     * 使用递归的方式 打印数字
     * @param n
     */
    public static void print1ToMaxNDigit(int n){
        if(n <= 0){
            return ;
        }

        char[] number = new char[n];
        for(int i=0;i<n;i++){
            number[i] = '0';
        }
        for(int i=0;i<10;i++){
            number[0] = (char) (i + '0');
            print1ToMaxNDigitRecursively(number ,n , 0);

        }

    }

    private static void print1ToMaxNDigitRecursively(char[] number , int length , int index){
        if(index == length - 1){
            printNumber(number);
            return;
        }
        for(int i=0;i<10;i++){
            number[index + 1] = (char) (i + '0');
            print1ToMaxNDigitRecursively(number,length,index + 1);
        }
    }
}
