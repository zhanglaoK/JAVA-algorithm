package com.junxi.day04;


/**
 *
 * “之”字形打印矩阵
 * 【题目】 给定一个矩阵matrix，按照“之”字形的方式打印这个矩阵，
 * 例如： 1 2 3 4 5 6 7 8 9  10 11 12“之”字形打印的
 * 结果为：1，2，5，9，6，3，4，7，10，11，8，12
 * 【要求】 额外空间复杂度为O(1
 *
 */

public class ZigZagPrintMatrix {

    public static void main(String[] args) {
        int [][]matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        printMatrixZigZag(matrix);
    }

    public static void printMatrixZigZag(int [][]matrix){
        int tR = 0;
        int tC = 0;
        int dR = 0;
        int dC = 0;
        int endR = matrix.length-1;
        int endC = matrix[0].length-1;
        boolean fromUp = false;
        while(tR != endR+1){
            printLevel(matrix,tR,tC,dR,dC,fromUp);
            //不可调换顺序
            tR = tC == endC ? tR+1:tR;
            tC = tC == endC ? tC:tC+1;
            dC = dR == endR ? dC+1:dC;
            dR = dR == endR ? dR:dR+1;
            fromUp = !fromUp;
        }

    }


    public static void printLevel(int[][]matrix,int tR,int tC,int dR,int dC,boolean fromUp){
        if(fromUp){
            while (tR != dR+1){
                System.out.print(matrix[tR++][tC--]+" ");
            }
        }else{
            while(dR != tR-1){
                System.out.print(matrix[dR--][dC++]+" ");
            }
        }
    }


}
