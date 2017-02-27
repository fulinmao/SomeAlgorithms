package com.fulin.offer.problem20;

/**
 * 顺时针打印打印矩阵，输入一个矩阵，按照从外向里的顺序依次打印出每一个数字
 *
 * 例如
 *   输入：
 *      1   2   3   4
 *      5   6   7   8
 *      9   10  11  12
 *      13  14  15  16
 *   输出：
 *      1   2   3   4   8   12  16  15  14  13  9   5   6   7   11  10
 * Created by fulin on 17-2-27.
 */
public class PrintMatrix {

    public static void main(String[] args){
//        int[][] nums = {{1 ,  2  , 3  , 4},{5   ,6  , 7  , 8},{9   ,10  ,11  ,12},{13  ,14 , 15,16}};
        int[][] nums = {{1 ,  2  , 3  },{4,5   ,6   },{7,8,9 }};
        printMatrix(nums);
    }

    public static void printMatrix(int[][] nums){
        if(nums == null){
            return;
        }

        int row = nums.length;
        int column = row <= 0 ? -1 : nums[0].length;

        if(row <0|| column <0){
            return ;
        }
        int start = 0;
        while((row > start *2) && (column > start*2) ){
            printMatrixByOneCricle(nums,start);
            start ++;
        }
    }

    private static void printMatrixByOneCricle(int[][] nums, int start) {
        if(nums == null){
            return ;
        }

        int row = nums.length - 1;
        int column = nums[0].length - 1;

        int startX = start;
        int startY = start;

        int endX = column - start;
        int endY = row - start;

        //从左往右打印数组
        for(int i=startX;i<= endX;i++){
            System.out.print(nums[startY][i]);
            System.out.print("\t");
        }

        //从上往下打印数组
        if(start < endY){
            for(int i=startY+1;i<= endY;i++){
                System.out.print(nums[i][endX]);
                System.out.print("\t");
            }
        }


        // 从右向左打印数组
        if(start < endX &&  start < endY){
            for(int i=endX -1; i>= startX;i--){
                System.out.print(nums[endY][i]);
                System.out.print("\t");
            }
        }

        // 从下往上打印数组
        if(start < endX && start < endY){
            for(int i= endY - 1; i> startY;i--){
                System.out.print(nums[i][startX]);
                System.out.print("\t");
            }
        }

    }


}
