package com.junxi.day04;

/**
 * 矩阵反转
 */
public class RotateMatrix {

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }


    public static void main(String[] args) {
        int [][]matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        printMatrix(matrix);
        rotate(matrix);
        printMatrix(matrix);
    }

    public static void rotate(int [][]nums){
        int tR = 0;
        int tC = 0;
        int dR = nums.length-1;
        int dC = nums[0].length-1;
        while(tR<dR){
            rotateMatrix(nums,tR++,tC++,dR--,dC--);
        }
    }

    public static void rotateMatrix(int[][] nums,int tR,int tC,int dR,int dC){
        int times = dC-tC;
        for (int i=0;i<times;i++){
            int temp = nums[tR+i][dC];
            nums[tR+i][dC] = nums[tR][tC+i];
            nums[tR][tC+i] = nums[dR-i][tC];
            nums[dR-i][tC] = nums[dR][dC-i];
            nums[dR][dC-i] = temp;
        }
    }

}
