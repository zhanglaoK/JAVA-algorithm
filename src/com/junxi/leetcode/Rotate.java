package com.junxi.leetcode;

/**
 * LEETCODE 48
 *
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 *
 * 需要原地旋转
 *
 */
public class Rotate {

    public static void main(String[] args) {
        int [][]matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        new Rotate().rotate(matrix);
        System.out.println(matrix);

    }


    public void rotate(int[][] matrix) {
        //拿到左上角和右下角的位置
        int topRow = 0;
        int topCol = 0;
        int downRow = matrix.length-1;
        int downCol = matrix[0].length-1;
        while(topRow<downRow){
            rotateMatrix(matrix,topRow++,topCol++,downRow--,downCol--);
        }

    }
    private void rotateMatrix(int[][] matrix,int topRow,int topCol,int downRow,int downCol){
        int times = downCol - topCol;
        for(int i=0;i<times;i++){
            int temp = matrix[topRow][topCol+i];
            matrix[topRow][topCol+i] = matrix[downRow-i][topCol];
            matrix[downRow-i][topCol] = matrix[downRow][downCol-i];
            matrix[downRow][downCol-i] = matrix[topRow+i][downCol];
            matrix[topRow+i][downCol] = temp;
        }
    }
}
