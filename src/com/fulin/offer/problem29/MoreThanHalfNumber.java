package com.fulin.offer.problem29;

/**
 * 数组中有一个数字穿线的次数超过数字长度的一半，请找出这个数字
 *
 * 例如：{1,2,3,2,2,2,5,4,2}
 * 输出：2
 * @author mfl4482
 *
 */
public class MoreThanHalfNumber {

    public static void main(String[] args) {
        int[] nums = {1,2,3,2,2,2,5,4,2};
        int result = moreThanHalfNumber(nums);
        System.out.println(result);
    }

    /**
     * 返回数组中出现次数超过一半的整数
     *
     * 思路：遍历数组时保存两个值，一个是数组中的一个数字，一个是出现的次数，当我们遍历到下一个数字的时候，如果下一个数字和我们之前保存的数字相同，则次数加1
     * 	如果和之前保存的数字不同，则减1，如果次数为0，我们需要保存下一个数字，并把次数置为1
     *
     * @param nums
     * @return
     */
    public static int moreThanHalfNumber(int[] nums){
        if(nums == null || nums.length == 0){
            return -1;
        }
        int number = nums[0];
        int count = 1;
        for(int i=1;i<nums.length;i++){
            if(count == 0){
                number = nums[i];
                count = 1;
                continue;
            }
            if(nums[i] == number){
                count ++;
            }else{
                count --;
            }
        }
        // 检查 number 是否为次数超过1的数字
        if(!checkMoreThanHalfNumber(nums , number)){
            return -1;
        }

        return number;
    }

    /**
     * 检查 该数字是否为数组中次数超过一半的整数
     * @param nums
     * @param number
     * @return
     */
    private static boolean checkMoreThanHalfNumber(int[] nums, int number) {
        boolean isMore = false;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == number){
                count ++;
            }
        }
        if((count << 2) > nums.length){
            isMore = true;
        }

        return isMore;
    }
}