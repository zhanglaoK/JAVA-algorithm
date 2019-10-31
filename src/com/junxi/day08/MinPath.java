package com.junxi.day08;
/**
 * 最小路径和问题
 * 给你一个二维数组，二维数组中的每个数都是正数，要求从左上
 * 角走到右下角，每一步只能向右或者向下。沿途经过的数字要累
 * 加起来。返回最小的路径和。
 *
 */
public class MinPath {

    /**
     * 暴力枚举
     * @param matrix
     * @param i
     * @param j
     * @return
     */
    public static int minPath(int[][]matrix,int i,int j){
        int res = matrix[i][j];
        if(i==0 && j==0){
            return res;
        }
        if(i==0 && j!=0){
            return res + minPath(matrix,i,j+1);
        }
        if(i!=0 && j==0){
            return res + minPath(matrix,i+1,j);
        }
        return res + Math.min(minPath(matrix,i+1,j),minPath(matrix,i,j+1));
    }

    /**
     * 暴力枚举
     * @param matrix
     * @param i
     * @param j
     * @return
     */
    public static int minPath1(int[][]matrix,int i,int j){
        if(i==matrix.length-1 && j==matrix[0].length){
            return matrix[i][j];
        }
        if(i==matrix.length-1){
            return matrix[i][j] + minPath(matrix,i,j+1);
        }
        if(j==matrix[0].length-1){
            return matrix[i][j] + minPath(matrix,i+1,j);
        }
        return matrix[i][j] + Math.min(minPath(matrix,i+1,j),minPath(matrix,i,j+1));
    }



}
