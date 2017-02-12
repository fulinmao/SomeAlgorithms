package com.fulin.offer.problem3;

/**
 * 在一个二维的数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序
 *
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 *
 * maxtrix :	1	2	8	9
 * 				2	4	9	12
 * 				4	7	10	13
 * 				6	8	11	15
 * target:	5
 *
 * return false
 *
 *
 *
 * @author mfl4482
 *
 */
public class FindInPartiallySortedMatrix {

	public static void main(String[] args) {
		int[][] matrix = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		int target = 16;
		System.out.println(findInPartiallySortedMatrix(matrix, target));
	}

	public static boolean findInPartiallySortedMatrix(int[][] matrix , int target){
		boolean result = false;
		if(matrix == null ){
			return result;
		}
		int high = matrix.length;
		int width = matrix[0] == null ? 0 : matrix[0].length;

		int i = 0;
		int j = width - 1;
		while(i< high && j>=0){
			if(matrix[i][j] == target){
				result = true;
				break;
			}else if(matrix[i][j] > target){
				j --;
			}else if(matrix[i][j] < target){
				i ++;
			}
		}
		return result;
	}
}