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
            return res + minPath(matrix,i,j-1);
        }
        if(i!=0 && j==0){
            return res + minPath(matrix,i-1,j);
        }

        return res + Math.min(minPath(matrix,i-1,j),minPath(matrix,i,j-1));
    }

    /**
     * 暴力枚举
     * @param matrix
     * @param i
     * @param j
     * @return
     */
    public static int minPath1(int[][]matrix,int i,int j){
        if(i==matrix.length-1 || j==matrix[0].length){
            return matrix[i][j];
        }
        if(i==matrix.length-1){
            return matrix[i][j] + minPath1(matrix,i,j+1);
        }
        if(j==matrix[0].length-1){
            return matrix[i][j] + minPath1(matrix,i+1,j);
        }
        return matrix[i][j] + Math.min(minPath1(matrix,i+1,j),minPath1(matrix,i,j+1));
    }


    /**
     * 动态规划解法
     * @param matrix
     * @return
     */
    public static int minPath2(int[][]matrix){
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int [][]dp = new int [row][col];
        dp[0][0] = matrix[0][0];
        for(int i=1;i<row;i++){
            dp[i][0] = dp[i-1][0] + matrix[i][0];
        }
        for (int j=1;j<col;j++){
            dp[0][j] = dp[0][j-1] + matrix[0][j];
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + matrix[i][j];
            }
        }
        return dp[row-1][col-1];
    }


    public static void main(String[] args) {
        int[][] m = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } };
        System.out.println(minPath(m,m.length-1,m[0].length-1));
        System.out.println(minPath1(m,0,0));
        System.out.println(minPath2(m));

    }

}
