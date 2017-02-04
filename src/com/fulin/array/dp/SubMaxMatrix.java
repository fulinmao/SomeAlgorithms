package com.fulin.array.dp;

/**
 * Created by fulin on 17-2-4.
 */
public class SubMaxMatrix {

    public static void main(String[] args) {
        int[][] nums = {{0,-2,-7,0},{9,2,-6,2},{-4,1,-4,1},{-1,8,0,-2}};

        System.out.println(subMaxMatrix(nums));
    }

    public static int subMaxMatrix(int[][] nums){
        if(nums == null || nums.length ==0){
            return Integer.MIN_VALUE;
        }
        int[][] total = new int[nums.length][nums[0].length];
        total[0] = nums[0];
        for(int i=1;i<nums.length;i++){
        // total[i] = total[0] + nums[i];
            for(int j=0;j < nums[i].length;j++){
                total[i][j] = total[i-1][j] + nums[i][j];
            }
        }
        int result = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){

                int[] tempArray = new int[nums[i].length];
                for(int k=0;k<nums[i].length;k++){
                    if(i==0){
                        tempArray[k] = total[j][k];
                    }else{
                        tempArray[k] = total[j][k] - total[i- 1][k] ;
                    }
                }
                int maxSubArray = maxSubArray(tempArray);
                if(maxSubArray > result){
                    result = maxSubArray;
                }

            }
        }


        return result;
    }

    public static int maxSubArray(int[] nums){
        if(nums == null || nums.length ==0){
            return Integer.MIN_VALUE;
        }
        int result = nums[0];
        int currMaxNum = result;
        for(int i=1;i<nums.length;i++){
            currMaxNum =  Math.max(nums[i],currMaxNum + nums[i]);
            if(currMaxNum > result){
                result = currMaxNum;
            }
        }
        return result;
    }
}
