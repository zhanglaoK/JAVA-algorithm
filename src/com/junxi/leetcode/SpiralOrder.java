package com.junxi.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 54. 螺旋矩阵
 *
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 */
public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        int topRow = 0;
        int topCol = 0;
        int downRow = matrix.length-1;
        int downCol = matrix[0].length-1;
        List<Integer> res = new ArrayList<>();
        while(topRow<=downRow && topCol<=downCol){
            addMember(topRow++,topCol++,downRow--,downCol--,res,matrix);
        }
        return res;
    }

    private void addMember(int topRow,int topCol,int downRow,int downCol,List<Integer> res,int[][] matrix){
        if(topRow==downRow){
            for(int i=topCol;i<=downCol;i++){
                res.add(matrix[topRow][i]);
            }
        }else if(topCol==downCol){
            for(int i=topRow;i<=downRow;i++){
                res.add(matrix[i][topCol]);
            }
        }else{
            int curRow = topRow;
            int curCol = topCol;
            while(curCol!=downCol){
                res.add(matrix[curRow][curCol++]);
            }
            while(curRow != downRow){
                res.add(matrix[curRow++][curCol]);
            }
            while(curCol != topCol){
                res.add(matrix[curRow][curCol--]);
            }
            while(curRow != topRow){
                res.add(matrix[curRow--][curCol]);
            }
        }
    }



}
