package com.junxi.day04;

/**
 *
 * 转圈打印矩阵
 * 【题目】 给定一个整型矩阵matrix，请按照转圈的方式打印它。
 * 例如： 1 2 3 4 5 6 7 8 9 10 11 12 13 14
 * 15 16 打印结果为：1，2，3，4，8，12，16，15，14，13，9，
 * 5，6，7，11， 10
 * 【要求】 额外空间复杂度为O(1)。
 *
 */
public class PrintMatrix {

    public static void main(String[] args) {
        int [][]matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        print(matrix);
    }

    public static void print(int [][]matrix){
        int tr = 0;
        int tc = 0;
        int dr = matrix.length-1;
        int dc = matrix[0].length-1;
        while (tr<=dr && tc<=dc){
            printEdge(matrix,tr++,tc++,dr--,dc--);
        }
    }

    public static void printEdge(int [][]matrix,int tr,int tc,int dr,int dc){
        if(tr == dr){
            for(int i = tc;i<=dc;i++){
                System.out.print(matrix[tr][i]+" ");
            }
        }else if(tc == dc){
            for (int i = tr;i<=dr;i++){
                System.out.print(matrix[i][tc]+" ");
            }
        }else {
            int curC = tc;
            int curR = tr;
            while (curC != dc){
                System.out.print(matrix[tr][curC]+" ");
                curC++;
            }
            while (curR != dr){
                System.out.print(matrix[curR][dc]+" ");
                curR++;
            }
            while (curC != tc){
                System.out.print(matrix[dr][curC]+" ");
                curC--;
            }
            while (curR != tr){
                System.out.print(matrix[curR][tc]+" ");
                curR--;
            }
        }

    }

}
