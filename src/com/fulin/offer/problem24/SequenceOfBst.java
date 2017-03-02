package com.fulin.offer.problem24;


/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果，如果是，则返回true 否则返回false.
 *
 * 假设：输入的数组的任意两个数字都互不相同
 *
 *
 * @author mfl4482
 *
 */
public class SequenceOfBst {

    public static void main(String[] args) {

        int[] nums = {5,7,6,9,11,10,8};
        boolean result = sequenceOfBst(nums,0,nums.length -1);
        System.out.println(result);
    }

    public static boolean sequenceOfBst(int[] nums,int start,int end){
        if(nums == null || nums.length == 0){
            return false;
        }
        if(start > end){
            return false;
        }

        if(start == end){
            return true;
        }

        int root = nums[end];
        int index = start ;
        // 寻找到左子树和右子树的分割点
        for(int i = start;i<end;i++){
            if(nums[i] < root){
                index = i;
            }else{
                break;
            }
        }
        //检查右子树的元素是否都大于根节点
        int j = index + 1;
        for(;j < end ;j ++){
            if(nums[j] < root){
                return false;
            }
        }
        // 检查左子树 是否为BST
        boolean left = true;
        if(index > start){
            left = sequenceOfBst(nums, start, index);
            if(!left){
                return left;
            }

        }

        // 检查右子树是否为树
        boolean right = true;
        if(index  < end){
            right = sequenceOfBst(nums, index + 1, end -1);
        }
        return left && right;
    }

}